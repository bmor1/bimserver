package org.bimserver.shared;

/******************************************************************************
 * (c) Copyright bimserver.org 2009
 * Licensed under GNU GPLv3
 * http://www.gnu.org/licenses/gpl-3.0.txt
 * For more information mail to license@bimserver.org
 *
 * Bimserver.org is free software: you can redistribute it and/or modify 
 * it under the terms of the GNU General Public License as published by 
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * Bimserver.org is distributed in the hope that it will be useful, but 
 * WITHOUT ANY WARRANTY; without even the implied warranty of 
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU 
 * General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License a 
 * long with Bimserver.org . If not, see <http://www.gnu.org/licenses/>.
 *****************************************************************************/

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.activation.DataHandler;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.xml.bind.annotation.XmlMimeType;

import org.bimserver.interfaces.objects.SAccessMethod;
import org.bimserver.interfaces.objects.SCheckout;
import org.bimserver.interfaces.objects.SClash;
import org.bimserver.interfaces.objects.SClashDetectionSettings;
import org.bimserver.interfaces.objects.SEidClash;
import org.bimserver.interfaces.objects.SGeoTag;
import org.bimserver.interfaces.objects.SGuidClash;
import org.bimserver.interfaces.objects.SLogAction;
import org.bimserver.interfaces.objects.SProject;
import org.bimserver.interfaces.objects.SRevision;
import org.bimserver.interfaces.objects.SUser;
import org.bimserver.interfaces.objects.SUserType;
import org.bimserver.shared.SCompareResult.SCompareType;

//TODO: Document the rest of the interface
/**
 * This interface defines all functions that are made available via SOAP, but
 * also used by the JSP web interface
 */
@WebService(name="soap")
@Path("/")
@Produces("application/xml")
@SOAPBinding(style = Style.DOCUMENT, use = Use.LITERAL, parameterStyle = ParameterStyle.WRAPPED)
public interface ServiceInterface {
	@GET
	@Path("/ping")
	@Produces("application/text")
	@WebMethod(action = "ping")
	String ping(@QueryParam("in") @WebParam(name = "in", partName = "ping.in") String in);

	@GET
	@Path("/login")
	@Produces("application/xml")
	@WebMethod(action = "login")
	boolean login(@QueryParam("username") @WebParam(name = "username", partName="login.username") String username, @QueryParam("password") @WebParam(name = "password", partName="login.password") String password) throws UserException, ServerException;

	@WebMethod(action = "autologin")
	boolean autologin(@WebParam(name = "username", partName="autologin.username") String username, @WebParam(name = "hash", partName="autologin.hash") String hash) throws UserException, ServerException;

	@WebMethod(action = "checkinSync")
	SCheckinResult checkinSync(@WebParam(name = "poid", partName="checkinSync.poid") long poid, @WebParam(name = "comment", partName="checkinSync.comment") String comment,
			@WebParam(name = "fileSize", partName="checkinSync.fileSize") long fileSize, @WebParam(name = "ifcFile", partName="checkinSync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile, boolean merge) throws UserException, ServerException;

	@WebMethod(action = "checkinAsync")
	SCheckinResult checkinAsync(@WebParam(name = "poid", partName="checlinAsync.poid") long poid, @WebParam(name = "comment", partName="checkinAsync.comment") String comment,
			@WebParam(name = "fileSize", partName="checkinSync.fileSize") long fileSize, @WebParam(name = "ifcFile", partName="checkinAsync.ifcFile") @XmlMimeType("application/octet-stream") DataHandler ifcFile, boolean merge) throws UserException, ServerException;

	@WebMethod(action = "checkout")
	SCheckoutResult checkout(@WebParam(name = "roid", partName="checkout.roid") long roid, @WebParam(name = "resultType", partName="checkout.resultType") ResultType resultType) throws UserException, ServerException;

	@WebMethod(action = "checkoutLastRevision")
	SCheckoutResult checkoutLastRevision(@QueryParam("poid") @WebParam(name = "poid", partName="checkoutLastRevision.poid") long poid, @QueryParam("resultType") @WebParam(name = "resultType", partName="checkoutLastRevision.resultType") ResultType resultType)
			throws UserException, ServerException;

	@GET
	@Path("/download")
	@Produces("application/xml")
	@WebMethod(action = "download")
	SDownloadResult download(@QueryParam("roid") @WebParam(name = "roid", partName="download.roid") long roid, @QueryParam("resultType") @WebParam(name = "resultType", partName="download.resultType") ResultType resultType)
			throws UserException, ServerException;

	@WebMethod(action = "downloadByOids")
	SDownloadResult downloadByOids(@WebParam(name = "roids", partName="downloadByOids.roids") Set<Long> roids, @WebParam(name = "oids", partName="downloadByOids.oids") Set<Long> oids,
			@WebParam(name = "resultType", partName="downloadByOids.resultType") ResultType resultType) throws UserException, ServerException;

	@WebMethod(action = "downloadOfType")
	SDownloadResult downloadOfType(@WebParam(name = "roid", partName="downloadOfType.roid") long roid, @WebParam(name = "className", partName="downloadOfType.className") String className,
			@WebParam(name = "resultType", partName="downloadOfType.resultType") ResultType resultType) throws UserException, ServerException;

	@WebMethod(action = "downloadByGuids")
	SDownloadResult downloadByGuids(@WebParam(name = "roids", partName="downloadByGuids.roids") Set<Long> roids, @WebParam(name = "guids", partName="downloadByGuids.guids") Set<String> guids,
			@WebParam(name = "resultType", partName="downloadByGuids.resultType") ResultType resultType) throws UserException, ServerException;

	@WebMethod(action = "downloadProjects")
	SDownloadResult downloadProjects(@WebParam(name = "roids", partName="downloadProjects.roids") Set<Long> roids, @WebParam(name = "resultType", partName="downloadProjects.resultType") ResultType resultType)
			throws UserException, ServerException;

	@WebMethod(action = "addUser")
	long addUser(@WebParam(name = "username", partName="addUser.username") String username, @WebParam(name = "name", partName="addUser.name") String name, @WebParam(name = "type", partName="addUser.type") SUserType type, boolean selfRegistration) throws UserException, ServerException;

	@WebMethod(action = "changeUserType")
	void changeUserType(@WebParam(name = "uoid", partName="changeUserType.uoid") long uoid, @WebParam(name = "userType", partName="changeUserType.userType") SUserType userType) throws UserException, ServerException;

	@WebMethod(action = "addProject")
	SProject addProject(@WebParam(name = "projectName", partName="addProject.projectName") String projectName) throws UserException, ServerException;

	@WebMethod(action = "addProjectAsSubProject")
	SProject addProjectAsSubProject(@WebParam(name = "projectName", partName="addProjectAsSubProject.projectName") String projectName, @WebParam(name = "parentPoid", partName="addProjectAsSubProject.parentPoid") long parentPoid)
			throws UserException, ServerException;

	@WebMethod(action = "updateProject")
	void updateProject(@WebParam(name = "sProject", partName="updateProject.sProject") SProject sProject) throws UserException, ServerException;

	@WebMethod(action = "updateRevision")
	void updateRevision(@WebParam(name = "sRevision", partName="updateRevision.sRevision") SRevision sRevision) throws UserException, ServerException;

	@WebMethod(action = "addUserToProject")
	boolean addUserToProject(@WebParam(name = "uoid", partName="addUserToProject.uoid") long uoid, @WebParam(name = "poid", partName="addUserToProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "removeUserFromProject")
	boolean removeUserFromProject(@WebParam(name = "uoid", partName="removeProjectFromUser.uoid") long uoid, @WebParam(name = "poid", partName="removeUserFromProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "deleteProject")
	boolean deleteProject(@WebParam(name = "poid", partName="deleteProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "deleteUser")
	boolean deleteUser(@WebParam(name = "uoid", partName="deleteUser.uoid") long uoid) throws UserException, ServerException;

	@GET
	@Path("/getAllProjects")
	@Produces("application/xml")
	@WebMethod(action = "getAllProjects")
	List<SProject> getAllProjects() throws UserException, ServerException;

	@WebMethod(action = "getAllUsers")
	List<SUser> getAllUsers() throws UserException, ServerException;

	@GET
	@Path("/getAllRevisionsOfProject")
	@Produces("application/xml")
	@WebMethod(action = "getAllRevisionsOfProject")
	List<SRevision> getAllRevisionsOfProject(@QueryParam("poid") @WebParam(name = "poid", partName="getAllRevisionsOfProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "getAllCheckoutsOfProject")
	List<SCheckout> getAllCheckoutsOfProject(@WebParam(name = "poid", partName="getAllCheckoutsOfProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "getAllRevisionsByUser")
	List<SRevision> getAllRevisionsByUser(@WebParam(name = "uoid", partName="getAllRevisionsOfUser.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "getAllCheckoutsByUser")
	List<SCheckout> getAllCheckoutsByUser(@WebParam(name = "uoid", partName="getAllCheckoutsByUser.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "getAllCheckoutsOfRevision")
	List<SCheckout> getAllCheckoutsOfRevision(@WebParam(name = "roid", partName="getAllCheckoutsOfRevision.roid") long roid) throws UserException, ServerException;

	@WebMethod(action = "getProjectByPoid")
	SProject getProjectByPoid(@WebParam(name = "poid", partName="getProjectByPoid.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "getRevision")
	SRevision getRevision(@WebParam(name = "roid", partName="getRevision.roid") long roid) throws UserException, ServerException;

	@WebMethod(action = "getAvailableClasses")
	List<String> getAvailableClasses() throws UserException, ServerException;

	@WebMethod(action = "getDatabaseInformation")
	DatabaseInformation getDatabaseInformation() throws UserException, ServerException;

	@WebMethod(action = "getLoggedInUser")
	SUser getLoggedInUser() throws UserException, ServerException;

	@WebMethod(action = "getAllNonAuthorizedProjectsOfUser")
	List<SProject> getAllNonAuthorizedProjectsOfUser(@WebParam(name = "uoid", partName="getAllNonAuthorizedProjectsOfUser.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "logout")
	void logout() throws UserException, ServerException;

	@WebMethod(action = "changePassword")
	boolean changePassword(@WebParam(name = "uoid", partName="changePassword.uoid") long uoid, @WebParam(name = "oldPassword", partName="changePassword.oldPassword") String oldPassword,
			@WebParam(name = "newPassword", partName="changePassword.newPassword") String newPassword) throws UserException, ServerException;

	@WebMethod(action = "getUserByUserName")
	SUser getUserByUserName(@WebParam(name = "username", partName="getUserByUserName.username") String username) throws UserException, ServerException;

	@WebMethod(action = "undeleteProject")
	boolean undeleteProject(@WebParam(name = "poid", partName="undeleteProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "undeleteUser")
	boolean undeleteUser(@WebParam(name = "uoid", partName="undeleteUser.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "compare")
	SCompareResult compare(@WebParam(name = "roid1", partName="compare.roid1") long roid1, @WebParam(name = "roid2", partName="compare.roid2") long roid2, @WebParam(name="sCompareType", partName="compare.sCompareType") SCompareType sCompareType)
			throws UserException, ServerException;

	@WebMethod(action = "getRevisionSummary")
	SRevisionSummary getRevisionSummary(@WebParam(name = "roid", partName="getRevisionSummary.roid") long roid) throws UserException, ServerException;

	@WebMethod(action = "userHasCheckinRights")
	boolean userHasCheckinRights(@WebParam(name = "poid", partName="userHasCheckinRights.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "getShowCheckoutWarning")
	String getShowCheckoutWarning(@WebParam(name = "poid", partName="getShowCheckoutWarning.poid") long poid, @WebParam(name = "uoid", partName="getShowCheckoutWarning.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "userHasRights")
	boolean userHasRights(@WebParam(name = "poid", partName="userHasRights.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "getDataObjectByOid")
	SDataObject getDataObjectByOid(@WebParam(name = "roid", partName="getDataObjectByOid.roid") long roid, @WebParam(name = "oid", partName="getDataObjectByOid.oid") long oid,
			@WebParam(name = "className", partName="getDataObjectByOid.className") String className) throws UserException, ServerException;

	@WebMethod(action = "getDataObjectByGuid")
	SDataObject getDataObjectByGuid(@WebParam(name = "roid", partName="getDataObjectByGuid.roid") long roid, @WebParam(name = "guid", partName="getDataObjectByGuid.guid") String guid) throws UserException, ServerException;

	@WebMethod(action = "getDataObjectsByType")
	List<SDataObject> getDataObjectsByType(@WebParam(name = "roid", partName="getDataObjectsByType.roid") long roid, @WebParam(name = "className", partName="getDataObjectsByType.className") String className)
			throws UserException, ServerException;

	@WebMethod(action = "findClashesByGuid")
	List<SGuidClash> findClashesByGuid(@WebParam(name = "sClashDetectionSettings", partName="findClashesByGuid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException;

	@WebMethod(action = "findClashesByEid")
	List<SEidClash> findClashesByEid(@WebParam(name = "sClashDetectionSettings", partName="findClashesByEid.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException;

	@WebMethod(action = "getLastClashes")
	List<SClash> getLastClashes(@WebParam(name = "roid", partName="getLastClashes.roid") long roid) throws UserException, ServerException;

	@WebMethod(action = "branchToNewProject")
	SCheckinResult branchToNewProject(@WebParam(name = "roid", partName="branchToNewProject.roid") long roid, @WebParam(name = "projectName", partName="branchToNewProject.projectName") String projectName,
			@WebParam(name = "comment", partName="branchToNewProject.comment") String comment) throws UserException, ServerException;

	@WebMethod(action = "branchToExistingProject")
	SCheckinResult branchToExistingProject(@WebParam(name = "roid", partName="branchToExistingProject.roid") long roid, @WebParam(name = "destPoid", partName="branchToExistingProject.destPoid") long destPoid,
			@WebParam(name = "comment", partName="branchToExistingProject.comment") String comment) throws UserException, ServerException;

	@WebMethod(action = "getLogs")
	List<SLogAction> getLogs() throws UserException, ServerException;

	@WebMethod(action = "getGeoTag")
	SGeoTag getGeoTag(@WebParam(name = "goid", partName="getGeoTag.goid") long goid) throws UserException, ServerException;

	@WebMethod(action = "updateGeoTag")
	void updateGeoTag(@WebParam(name = "sGeoTag", partName="updateGeoTag.sGeoTag") SGeoTag sGeoTag) throws UserException, ServerException;

	@WebMethod(action = "getClashDetectionSettings")
	SClashDetectionSettings getClashDetectionSettings(@WebParam(name = "cdsoid", partName="getClashDetectionSettings.cdsoid") long cdsoid) throws UserException, ServerException;

	@WebMethod(action = "updateClashDetectionSettings")
	void updateClashDetectionSettings(@WebParam(name = "sClashDetectionSettings", partName="updateClashDetectionSettings.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings)
			throws UserException, ServerException;

	@WebMethod(action = "getUserByUoid")
	SUser getUserByUoid(@WebParam(name = "uoid", partName="getUserByUoid.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "getAnonymousUser")
	SUser getAnonymousUser() throws UserException, ServerException;

	@WebMethod(action = "getAllNonAuthorizedUsersOfProject")
	List<SUser> getAllNonAuthorizedUsersOfProject(@WebParam(name = "poid", partName="getAllNonAuthorizedUsersOfProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "getAllAuthorizedUsersOfProject")
	List<SUser> getAllAuthorizedUsersOfProject(@WebParam(name = "poid", partName="getAllAuthorizedUsersOfProject.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "getUsersProjects")
	List<SProject> getUsersProjects(@WebParam(name = "uoid", partName="getUsersProjects.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "getProjectByName")
	List<SProject> getProjectByName(@WebParam(name = "name", partName="getProjectByName.name") String name) throws UserException, ServerException;

	@WebMethod(action = "setRevisionTag")
	void setRevisionTag(@WebParam(name = "roid", partName="setRevisionTag.roid") long roid, @WebParam(name = "tag", partName="setRevisionTag.tag") String tag) throws UserException, ServerException;

	@WebMethod(action = "getSubProjects")
	List<SProject> getSubProjects(@WebParam(name = "poid", partName="getSubProjects.poid") long poid) throws UserException, ServerException;

	@WebMethod(action = "isExportTypeEnabled")
	boolean isExportTypeEnabled(@WebParam(name = "resultType", partName="isExportTypeEnabled.resultType") ResultType resultType) throws UserException, ServerException;

	@WebMethod(action = "setExportTypeEnabled")
	void setExportTypeEnabled(@WebParam(name = "resultType", partName="setExportTypeEnabled.resultType") ResultType resultType, boolean enabled) throws UserException, ServerException;

	@WebMethod(action = "getCurrentUser")
	SUser getCurrentUser() throws UserException, ServerException;

	@WebMethod(action = "isLoggedIn")
	boolean isLoggedIn() throws UserException, ServerException;

	@WebMethod(action = "loginAnonymous")
	void loginAnonymous() throws UserException, ServerException;
	
	@WebMethod(action = "getActiveUserSessions")
	List<SUserSession> getActiveUserSessions() throws ServerException, ServiceException;

	@WebMethod(action = "getActiveLongActions")
	List<SLongAction> getActiveLongActions() throws ServerException, ServiceException;

	@WebMethod(action = "getActiveSince")
	Date getActiveSince() throws UserException, ServerException;

	@WebMethod(action = "getLastActive")
	Date getLastActive() throws UserException, ServerException;

	@WebMethod(action = "getCurrentToken")
	Token getCurrentToken() throws UserException, ServerException;

	@WebMethod(action = "getAccessMethod")
	SAccessMethod getAccessMethod() throws UserException, ServerException;
	
	@WebMethod(action = "getEnabledResultTypes")
	Set<ResultType> getEnabledResultTypes() throws UserException, ServerException;
	
	@WebMethod(action = "getAllResultTypes")
	Set<ResultType> getAllResultTypes() throws UserException, ServerException;

	@WebMethod(action = "getAllCheckoutsOfProjectAndSubProjects")
	List<SCheckout> getAllCheckoutsOfProjectAndSubProjects(@WebParam(name="poid", partName="getAllCheckoutsOfProjectAndSubProjects.poid") long poid) throws UserException, ServerException;
	
	@WebMethod(action = "requestPasswordChange")
	void requestPasswordChange(@WebParam(name="uoid", partName="requestPasswordChange.uoid") long uoid) throws UserException, ServerException;

	@WebMethod(action = "validateAccount")
	void validateAccount(@WebParam(name="uoid", partName="validateAccount.uoid") long uoid, @WebParam(name="token", partName="validateAccount.token") String token, @WebParam(name="password", partName="validateAccount.password") String password) throws UserException, ServerException;

	@WebMethod(action = "sendClashesEmail")
	void sendClashesEmail(@WebParam(name="sClashDetectionSettings", partName="sendClashesEmail.sClashDetectionSettings") SClashDetectionSettings sClashDetectionSettings, @WebParam(name="poid", partName="sendClashesEmail.poid" )long poid, @WebParam(name="addressesTo", partName="sendClashesEmail.addressesTo")Set<String> addressesTo) throws UserException, ServerException;
}