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

package com.liferay.timetracking.timesheet.service;

import com.liferay.portal.service.ServiceWrapper;

/**
 * Provides a wrapper for {@link WorkDayLocalService}.
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see WorkDayLocalService
 * @generated
 */
public class WorkDayLocalServiceWrapper implements WorkDayLocalService,
	ServiceWrapper<WorkDayLocalService> {
	public WorkDayLocalServiceWrapper(WorkDayLocalService workDayLocalService) {
		_workDayLocalService = workDayLocalService;
	}

	/**
	* Adds the work day to the database. Also notifies the appropriate model listeners.
	*
	* @param workDay the work day
	* @return the work day that was added
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay addWorkDay(
		com.liferay.timetracking.timesheet.model.WorkDay workDay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.addWorkDay(workDay);
	}

	/**
	* Creates a new work day with the primary key. Does not add the work day to the database.
	*
	* @param workDayId the primary key for the new work day
	* @return the new work day
	*/
	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay createWorkDay(
		long workDayId) {
		return _workDayLocalService.createWorkDay(workDayId);
	}

	/**
	* Deletes the work day with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workDayId the primary key of the work day
	* @return the work day that was removed
	* @throws PortalException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay deleteWorkDay(
		long workDayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.deleteWorkDay(workDayId);
	}

	/**
	* Deletes the work day from the database. Also notifies the appropriate model listeners.
	*
	* @param workDay the work day
	* @return the work day that was removed
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay deleteWorkDay(
		com.liferay.timetracking.timesheet.model.WorkDay workDay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.deleteWorkDay(workDay);
	}

	@Override
	public com.liferay.portal.kernel.dao.orm.DynamicQuery dynamicQuery() {
		return _workDayLocalService.dynamicQuery();
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
		return _workDayLocalService.dynamicQuery(dynamicQuery);
	}

	/**
	* Performs a dynamic query on the database and returns a range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workDayLocalService.dynamicQuery(dynamicQuery, start, end);
	}

	/**
	* Performs a dynamic query on the database and returns an ordered range of the matching rows.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
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
		return _workDayLocalService.dynamicQuery(dynamicQuery, start, end,
			orderByComparator);
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
		return _workDayLocalService.dynamicQueryCount(dynamicQuery);
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
		return _workDayLocalService.dynamicQueryCount(dynamicQuery, projection);
	}

	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay fetchWorkDay(
		long workDayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.fetchWorkDay(workDayId);
	}

	/**
	* Returns the work day with the primary key.
	*
	* @param workDayId the primary key of the work day
	* @return the work day
	* @throws PortalException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay getWorkDay(
		long workDayId)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.getWorkDay(workDayId);
	}

	@Override
	public com.liferay.portal.model.PersistedModel getPersistedModel(
		java.io.Serializable primaryKeyObj)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.getPersistedModel(primaryKeyObj);
	}

	/**
	* Returns a range of all the work daies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @return the range of work daies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> getWorkDaies(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.getWorkDaies(start, end);
	}

	/**
	* Returns the number of work daies.
	*
	* @return the number of work daies
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public int getWorkDaiesCount()
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.getWorkDaiesCount();
	}

	/**
	* Updates the work day in the database or adds it if it does not yet exist. Also notifies the appropriate model listeners.
	*
	* @param workDay the work day
	* @return the work day that was updated
	* @throws SystemException if a system exception occurred
	*/
	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay updateWorkDay(
		com.liferay.timetracking.timesheet.model.WorkDay workDay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.updateWorkDay(workDay);
	}

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	@Override
	public java.lang.String getBeanIdentifier() {
		return _workDayLocalService.getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	@Override
	public void setBeanIdentifier(java.lang.String beanIdentifier) {
		_workDayLocalService.setBeanIdentifier(beanIdentifier);
	}

	@Override
	public java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return _workDayLocalService.invokeMethod(name, parameterTypes, arguments);
	}

	/**
	* NOTE FOR DEVELOPERS:
	*
	* Never reference this interface directly. Always use {@link com.liferay.timetracking.timesheet.service.WorkDayLocalServiceUtil} to access the work day local service.
	*/
	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay addWorkDay(
		long userId, long companyId, long startTime, long endTime,
		long dayOfYearId, int break_,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.addWorkDay(userId, companyId, startTime,
			endTime, dayOfYearId, break_, serviceContext);
	}

	@Override
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> getWorkDays(
		long userId, long startTime, long endTime)
		throws com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.getWorkDays(userId, startTime, endTime);
	}

	@Override
	public com.liferay.timetracking.timesheet.model.WorkDay updateWorkDay(
		long userId, long workDayId, long startTime, long endTime,
		long dayOfYearId, int break_,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return _workDayLocalService.updateWorkDay(userId, workDayId, startTime,
			endTime, dayOfYearId, break_, serviceContext);
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #getWrappedService}
	 */
	public WorkDayLocalService getWrappedWorkDayLocalService() {
		return _workDayLocalService;
	}

	/**
	 * @deprecated As of 6.1.0, replaced by {@link #setWrappedService}
	 */
	public void setWrappedWorkDayLocalService(
		WorkDayLocalService workDayLocalService) {
		_workDayLocalService = workDayLocalService;
	}

	@Override
	public WorkDayLocalService getWrappedService() {
		return _workDayLocalService;
	}

	@Override
	public void setWrappedService(WorkDayLocalService workDayLocalService) {
		_workDayLocalService = workDayLocalService;
	}

	private WorkDayLocalService _workDayLocalService;
}