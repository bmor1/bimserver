package org.bimserver.shared;

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

import java.util.List;

import org.bimserver.interfaces.objects.SImmediateNotificationResult;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SLongActionState;
import org.bimserver.interfaces.objects.SProfileDescriptor;
import org.bimserver.interfaces.objects.SServiceDescriptor;
import org.bimserver.shared.exceptions.ServerException;
import org.bimserver.shared.exceptions.UserException;
import org.bimserver.shared.interfaces.NotificationInterface;

public class NotificationInterfaceAdapter implements NotificationInterface {

	@Override
	public SImmediateNotificationResult newLogAction(String uuid, SLogAction logAction, String serviceIdentifier, String profileIdentifier, String token, String apiUrl) throws UserException, ServerException {
		return null;
	}
	
	public void progress(Long topicId, SLongActionState state) throws UserException, ServerException {
	}

	@Override
	public void setToken(String token) {
	}

	@Override
	public String getCurrentToken() throws ServerException, UserException {
		return null;
	}

	@Override
	public List<SProfileDescriptor> getPublicProfiles(String serviceIdentifier) {
		return null;
	}

	@Override
	public List<SProfileDescriptor> getPrivateProfiles(String serviceIdentifier, String token) {
		return null;
	}

	@Override
	public SServiceDescriptor getService(String serviceIdentifier) {
		return null;
	}
}