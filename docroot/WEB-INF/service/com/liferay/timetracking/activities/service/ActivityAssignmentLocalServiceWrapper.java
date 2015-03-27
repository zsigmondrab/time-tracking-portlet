/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.timetracking.activities.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link ActivityAssignmentLocalService}.
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityAssignmentLocalService
 * @generated
 */
public class ActivityAssignmentLocalServiceWrapper
	implements ActivityAssignmentLocalService,
		ServiceWrapper<ActivityAssignmentLocalService> {
	public ActivityAssignmentLocalServiceWrapper(
		ActivityAssignmentLocalService activityAssignmentLocalService) {
		_activityAssignmentLocalService = activityAssignmentLocalService;
	}

	/**
	* Adds the activity assignment to the database. Also notifies the appropriate model listeners.
	*
	* @param activityAssignment the activity assignment
	* @return the activity assignment that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.activities.model.ActivityAssignment addActivityAssignment(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.addActivityAssignment(activityAssignment);
	}

	/**
	* Creates a new activity assignment with the primary key. Does not add the activity assignment to the database.
	*
	* @param activityAssignmentId the primary key for the new activity assignment
	* @return the new activity assignment
	*/
	@Override
	public com.liferay.timetracking.activities.model.ActivityAssignment createActivityAssignment(
		long activityAssignmentId) {
		return _activityAssignmentLocalService.createActivityAssignment(activityAssignmentId);
	}

	/**
	* Deletes the activity assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment that was removed
	* @throws PortalException if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.activities.model.ActivityAssignment deleteActivityAssignment(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.deleteActivityAssignment(activityAssignmentId);
	}

	/**
	* Deletes the activity assignment from the database. Also notifies the appropriate model listeners.
	*
	* @param activityAssignment the activity assignment
	* @return the activity assignment that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.activities.model.ActivityAssignment deleteActivityAssignment(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.deleteActivityAssignment(activityAssignment);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _activityAssignmentLocalService.dynamicQuery();
	}

	/**
	* Performs a dynamic query on the database and returns the matching rows.
	*
	* @param dynamicQuery the dynamic query
	* @return the matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @return the range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end) throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.dynamicQuery(dynamicQuery,
			start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dynamicQuery the dynamic query
	* @param start the lower bound of the range of model instances
	* @param end the upper bound of the range of model instances (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching rows
	* @throws SystemException if a system exception occurred
	*/
	@Override
	@SuppressWarnings("rawtypes")
	public java.util.List dynamicQuery(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.dynamicQuery(dynamicQuery,
			start, end, orderByComparator);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.dynamicQueryCount(dynamicQuery);
	}

	/**
	* Returns the number of rows that match the dynamic query.
	*
	* @param dynamicQuery the dynamic query
	* @param projection the projection to apply to the query
	* @return the number of rows that match the dynamic query
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public long dynamicQueryCount(
		com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery,
		com.liferay.portal.kernel.dao.orm.Projection projection)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.dynamicQueryCount(dynamicQuery,
			projection);
	}

	@Override
	public com.liferay.timetracking.activities.model.ActivityAssignment fetchActivityAssignment(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.fetchActivityAssignment(activityAssignmentId);
	}

	/**
	* Returns the activity assignment with the primary key.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment
	* @throws PortalException if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.activities.model.ActivityAssignment getActivityAssignment(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.getActivityAssignment(activityAssignmentId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the activity assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity assignments
	* @param end the upper bound of the range of activity assignments (not inclusive)
	* @return the range of activity assignments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> getActivityAssignments(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.getActivityAssignments(start, end);
	}

	/**
	* Returns the number of activity assignments.
	*
	* @return the number of activity assignments
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getActivityAssignmentsCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.getActivityAssignmentsCount();
	}

	/**
	* Updates the activity assignment in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param activityAssignment the activity assignment
	* @return the activity assignment that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.activities.model.ActivityAssignment updateActivityAssignment(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _activityAssignmentLocalService.updateActivityAssignment(activityAssignment);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _activityAssignmentLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_activityAssignmentLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _activityAssignmentLocalService.invokeMethod(name,
			parameterTypes, arguments);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public ActivityAssignmentLocalService getWrappedActivityAssignmentLocalService() {
		return _activityAssignmentLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedActivityAssignmentLocalService(
		ActivityAssignmentLocalService activityAssignmentLocalService) {
		_activityAssignmentLocalService = activityAssignmentLocalService;
	}

	@Override
	public ActivityAssignmentLocalService getWrappedService() {
		return _activityAssignmentLocalService;
	}

	@Override
	public void setWrappedService(
		ActivityAssignmentLocalService activityAssignmentLocalService) {
		_activityAssignmentLocalService = activityAssignmentLocalService;
	}

	private ActivityAssignmentLocalService _activityAssignmentLocalService;
}