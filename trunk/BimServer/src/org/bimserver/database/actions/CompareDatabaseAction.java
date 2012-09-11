package org.bimserver.database.actions;

/******************************************************************************
 * Copyright (C) 2009-2012  BIMserver.org
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 * 
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import org.bimserver.BimServer;
import org.bimserver.database.BimserverDatabaseException;
import org.bimserver.database.BimserverLockConflictException;
import org.bimserver.database.DatabaseSession;
import org.bimserver.emf.IfcModelInterface;
import org.bimserver.models.log.AccessMethod;
import org.bimserver.models.store.CompareResult;
import org.bimserver.models.store.CompareType;
import org.bimserver.models.store.ModelCompare;
import org.bimserver.models.store.StorePackage;
import org.bimserver.plugins.VoidReporter;
import org.bimserver.plugins.modelcompare.ModelCompareException;
import org.bimserver.plugins.modelcompare.ModelComparePlugin;
import org.bimserver.plugins.objectidms.ObjectIDM;
import org.bimserver.plugins.objectidms.ObjectIDMException;
import org.bimserver.shared.exceptions.UserException;

public class CompareDatabaseAction extends BimDatabaseAction<CompareResult> {

	private final long actingUoid;
	private final long roid1;
	private final long roid2;
	private final CompareType sCompareType;
	private final BimServer bimServer;
	private final long mcid;

	public CompareDatabaseAction(BimServer bimServer, DatabaseSession databaseSession, AccessMethod accessMethod, long actingUoid, long roid1, long roid2,
			CompareType sCompareType, long mcid) {
		super(databaseSession, accessMethod);
		this.bimServer = bimServer;
		this.actingUoid = actingUoid;
		this.roid1 = roid1;
		this.roid2 = roid2;
		this.sCompareType = sCompareType;
		this.mcid = mcid;
	}

	public org.bimserver.plugins.modelcompare.ModelCompare getModelCompare() throws ModelCompareException {
		ModelCompare modelCompareObject = getDatabaseSession().get(StorePackage.eINSTANCE.getModelCompare(), mcid, false, null);
		if (modelCompareObject != null) {
			ModelComparePlugin modelComparePlugin = bimServer.getPluginManager().getModelComparePlugin(modelCompareObject.getClassName(), true);
			if (modelComparePlugin != null) {
				org.bimserver.plugins.modelcompare.ModelCompare modelCompare = modelComparePlugin.createModelCompare();
				return modelCompare;
			} else {
				throw new ModelCompareException("No Model Compare found " + modelCompareObject.getClassName());
			}
		} else {
			throw new ModelCompareException("No configured Model Compare found");
		}
	}

	@Override
	public CompareResult execute() throws UserException, BimserverLockConflictException, BimserverDatabaseException {
		CompareResult compareResults = null;// bimServer.getCompareCache().getCompareResults(roid1,
											// roid2, sCompareType,
											// sCompareIdentifier);
		if (compareResults == null) {
			IfcModelInterface model1 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid1, -1, actingUoid, null, new VoidReporter()).execute();
			IfcModelInterface model2 = new DownloadDatabaseAction(bimServer, getDatabaseSession(), getAccessMethod(), roid2, -1, actingUoid, null, new VoidReporter()).execute();
			try {
				compareResults =  getModelCompare().compare(model1, model2, sCompareType);
			} catch (ModelCompareException e) {
				throw new UserException(e);
			}
//			bimServer.getCompareCache().storeResults(roid1, roid2, sCompareType, sCompareIdentifier, compareResults);
		}
		return compareResults;
	}
}