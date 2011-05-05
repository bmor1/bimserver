package org.bimserver.longaction;

import org.bimserver.MergerFactory;
import org.bimserver.SettingsManager;
import org.bimserver.cache.DiskCacheManager;
import org.bimserver.database.BimDatabase;
import org.bimserver.database.BimDatabaseSession;
import org.bimserver.database.actions.BimDatabaseAction;
import org.bimserver.database.actions.DownloadByGuidsDatabaseAction;
import org.bimserver.database.actions.DownloadByOidsDatabaseAction;
import org.bimserver.database.actions.DownloadDatabaseAction;
import org.bimserver.database.actions.DownloadOfTypeDatabaseAction;
import org.bimserver.database.actions.DownloadProjectsDatabaseAction;
import org.bimserver.ifc.IfcModel;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.serializers.EmfSerializerFactory;
import org.bimserver.shared.LongActionState;
import org.bimserver.shared.LongActionState.ActionState;

public class LongDownloadAction extends LongDownloadOrCheckoutAction {

	private BimDatabaseAction<IfcModel> action;
	private final SettingsManager settingsManager;
	private BimDatabaseSession session;
	private final MergerFactory mergerFactory;

	public LongDownloadAction(DownloadParameters downloadParameters, long currentUoid, LongActionManager longActionManager, BimDatabase bimDatabase, AccessMethod accessMethod,
			EmfSerializerFactory emfSerializerFactory, SettingsManager settingsManager, DiskCacheManager diskCacheManager, MergerFactory mergerFactory) {
		super(downloadParameters, bimDatabase, longActionManager, accessMethod, emfSerializerFactory, currentUoid, diskCacheManager);
		this.settingsManager = settingsManager;
		this.mergerFactory = mergerFactory;
	}

	public void execute() {
		state = ActionState.STARTED;
		try {
			executeAction(action, downloadParameters, session, false);
 		} catch (Exception e) {
			LOGGER.error("", e);
		} finally {
			if (session != null) {
				session.close();
			}
		}
		state = ActionState.FINISHED;
	}

	public void init() {
		if (getDiskCacheManager().contains(downloadParameters)) {
			return;
		}
		session = bimDatabase.createReadOnlySession();
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD:
			action = new DownloadDatabaseAction(session, accessMethod, settingsManager, mergerFactory, downloadParameters.getRoid(), currentUoid);
			break;
		case DOWNLOAD_BY_OIDS:
			action = new DownloadByOidsDatabaseAction(session, accessMethod, settingsManager, mergerFactory, downloadParameters.getRoids(), downloadParameters.getOids(), currentUoid);
			break;
		case DOWNLOAD_BY_GUIDS:
			action = new DownloadByGuidsDatabaseAction(session, accessMethod, settingsManager, mergerFactory, downloadParameters.getRoids(), downloadParameters.getGuids(), currentUoid);
			break;
		case DOWNLOAD_OF_TYPE:
			action = new DownloadOfTypeDatabaseAction(session, accessMethod, settingsManager, mergerFactory, downloadParameters.getRoid(), downloadParameters.getClassName(), currentUoid);
			break;
		case DOWNLOAD_PROJECTS:
			action = new DownloadProjectsDatabaseAction(session, accessMethod, settingsManager, mergerFactory, downloadParameters.getRoids(), currentUoid);
			break;
		}
	}

	@Override
	public synchronized LongActionState getState() {
		LongActionState ds = new LongActionState();
		if (action == null) {
			ds.setState(state);
			ds.setProgress(100);
			return ds;
		}
		switch (downloadParameters.getDownloadType()) {
		case DOWNLOAD:
			ds.setProgress(((DownloadDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_BY_OIDS:
			ds.setProgress(((DownloadByOidsDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_BY_GUIDS:
			ds.setProgress(((DownloadByGuidsDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_OF_TYPE:
			ds.setProgress(((DownloadOfTypeDatabaseAction) action).getProgress());
			break;
		case DOWNLOAD_PROJECTS:
			ds.setProgress(((DownloadProjectsDatabaseAction) action).getProgress());
			break;
		}
		ds.setState(state);
		if (state == ActionState.FINISHED) {
			ds.setProgress(100);
		}
		return ds;
	}

	@Override
	public String getDescription() {
		return "Download";
	}

	@Override
	public DownloadParameters getKey() {
		return downloadParameters;
	}
}