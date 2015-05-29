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

package com.liferay.timetracking.timesheet.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.timetracking.timesheet.model.WorkDay;

/**
 * The persistence interface for the work day service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see WorkDayPersistenceImpl
 * @see WorkDayUtil
 * @generated
 */
public interface WorkDayPersistence extends BasePersistence<WorkDay> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link WorkDayUtil} to access the work day persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the work daies where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the work daies where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @return the range of matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the work daies where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException;

	/**
	* Returns the first work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work day, or <code>null</code> if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException;

	/**
	* Returns the last work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work day, or <code>null</code> if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the work daies before and after the current work day in the ordered set where companyId = &#63;.
	*
	* @param workDayId the primary key of the current work day
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay[] findByCompanyId_PrevAndNext(
		long workDayId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException;

	/**
	* Returns all the work daies that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the work daies that the user has permission to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @return the range of matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the work daies that the user has permissions to view where companyId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param companyId the company ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the work daies before and after the current work day in the ordered set of work daies that the user has permission to view where companyId = &#63;.
	*
	* @param workDayId the primary key of the current work day
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay[] filterFindByCompanyId_PrevAndNext(
		long workDayId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException;

	/**
	* Removes all the work daies where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of work daies where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of work daies that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the work day in the entity cache if it is enabled.
	*
	* @param workDay the work day
	*/
	public void cacheResult(
		com.liferay.timetracking.timesheet.model.WorkDay workDay);

	/**
	* Caches the work daies in the entity cache if it is enabled.
	*
	* @param workDaies the work daies
	*/
	public void cacheResult(
		java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> workDaies);

	/**
	* Creates a new work day with the primary key. Does not add the work day to the database.
	*
	* @param workDayId the primary key for the new work day
	* @return the new work day
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay create(
		long workDayId);

	/**
	* Removes the work day with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workDayId the primary key of the work day
	* @return the work day that was removed
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay remove(
		long workDayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException;

	public com.liferay.timetracking.timesheet.model.WorkDay updateImpl(
		com.liferay.timetracking.timesheet.model.WorkDay workDay)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the work day with the primary key or throws a {@link com.liferay.timetracking.timesheet.NoSuchWorkDayException} if it could not be found.
	*
	* @param workDayId the primary key of the work day
	* @return the work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay findByPrimaryKey(
		long workDayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException;

	/**
	* Returns the work day with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workDayId the primary key of the work day
	* @return the work day, or <code>null</code> if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.timesheet.model.WorkDay fetchByPrimaryKey(
		long workDayId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the work daies.
	*
	* @return the work daies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the work daies.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of work daies
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the work daies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of work daies.
	*
	* @return the number of work daies
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}