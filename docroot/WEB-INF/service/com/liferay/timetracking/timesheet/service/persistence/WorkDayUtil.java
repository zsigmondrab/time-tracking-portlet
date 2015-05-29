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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.timetracking.timesheet.model.WorkDay;

import java.util.List;

/**
 * The persistence utility for the work day service. This utility wraps {@link WorkDayPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see WorkDayPersistence
 * @see WorkDayPersistenceImpl
 * @generated
 */
public class WorkDayUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache()
	 */
	public static void clearCache() {
		getPersistence().clearCache();
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#clearCache(com.liferay.portal.model.BaseModel)
	 */
	public static void clearCache(WorkDay workDay) {
		getPersistence().clearCache(workDay);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#countWithDynamicQuery(DynamicQuery)
	 */
	public static long countWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().countWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery)
	 */
	public static List<WorkDay> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<WorkDay> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<WorkDay> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static WorkDay update(WorkDay workDay) throws SystemException {
		return getPersistence().update(workDay);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static WorkDay update(WorkDay workDay, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(workDay, serviceContext);
	}

	/**
	* Returns all the work daies where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId);
	}

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
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByCompanyId(companyId, start, end, orderByComparator);
	}

	/**
	* Returns the first work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay findByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .findByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the first work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work day, or <code>null</code> if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay fetchByCompanyId_First(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_First(companyId, orderByComparator);
	}

	/**
	* Returns the last work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay findByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .findByCompanyId_Last(companyId, orderByComparator);
	}

	/**
	* Returns the last work day in the ordered set where companyId = &#63;.
	*
	* @param companyId the company ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work day, or <code>null</code> if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay fetchByCompanyId_Last(
		long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByCompanyId_Last(companyId, orderByComparator);
	}

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
	public static com.liferay.timetracking.timesheet.model.WorkDay[] findByCompanyId_PrevAndNext(
		long workDayId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .findByCompanyId_PrevAndNext(workDayId, companyId,
			orderByComparator);
	}

	/**
	* Returns all the work daies that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByCompanyId(
		long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId);
	}

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
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByCompanyId(
		long companyId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByCompanyId(companyId, start, end);
	}

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
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByCompanyId(
		long companyId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByCompanyId(companyId, start, end,
			orderByComparator);
	}

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
	public static com.liferay.timetracking.timesheet.model.WorkDay[] filterFindByCompanyId_PrevAndNext(
		long workDayId, long companyId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .filterFindByCompanyId_PrevAndNext(workDayId, companyId,
			orderByComparator);
	}

	/**
	* Removes all the work daies where companyId = &#63; from the database.
	*
	* @param companyId the company ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByCompanyId(companyId);
	}

	/**
	* Returns the number of work daies where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByCompanyId(companyId);
	}

	/**
	* Returns the number of work daies that the user has permission to view where companyId = &#63;.
	*
	* @param companyId the company ID
	* @return the number of matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByCompanyId(long companyId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByCompanyId(companyId);
	}

	/**
	* Returns all the work daies where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @return the matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByS_E_U(
		java.util.Date startTime, java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByS_E_U(startTime, endTime, userId);
	}

	/**
	* Returns a range of all the work daies where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @return the range of matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByS_E_U(
		java.util.Date startTime, java.util.Date endTime, long userId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_E_U(startTime, endTime, userId, start, end);
	}

	/**
	* Returns an ordered range of all the work daies where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByS_E_U(
		java.util.Date startTime, java.util.Date endTime, long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByS_E_U(startTime, endTime, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first work day in the ordered set where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay findByS_E_U_First(
		java.util.Date startTime, java.util.Date endTime, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .findByS_E_U_First(startTime, endTime, userId,
			orderByComparator);
	}

	/**
	* Returns the first work day in the ordered set where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching work day, or <code>null</code> if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay fetchByS_E_U_First(
		java.util.Date startTime, java.util.Date endTime, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_E_U_First(startTime, endTime, userId,
			orderByComparator);
	}

	/**
	* Returns the last work day in the ordered set where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay findByS_E_U_Last(
		java.util.Date startTime, java.util.Date endTime, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .findByS_E_U_Last(startTime, endTime, userId,
			orderByComparator);
	}

	/**
	* Returns the last work day in the ordered set where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching work day, or <code>null</code> if a matching work day could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay fetchByS_E_U_Last(
		java.util.Date startTime, java.util.Date endTime, long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByS_E_U_Last(startTime, endTime, userId,
			orderByComparator);
	}

	/**
	* Returns the work daies before and after the current work day in the ordered set where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param workDayId the primary key of the current work day
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay[] findByS_E_U_PrevAndNext(
		long workDayId, java.util.Date startTime, java.util.Date endTime,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .findByS_E_U_PrevAndNext(workDayId, startTime, endTime,
			userId, orderByComparator);
	}

	/**
	* Returns all the work daies that the user has permission to view where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @return the matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByS_E_U(
		java.util.Date startTime, java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterFindByS_E_U(startTime, endTime, userId);
	}

	/**
	* Returns a range of all the work daies that the user has permission to view where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @return the range of matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByS_E_U(
		java.util.Date startTime, java.util.Date endTime, long userId,
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByS_E_U(startTime, endTime, userId, start, end);
	}

	/**
	* Returns an ordered range of all the work daies that the user has permissions to view where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param start the lower bound of the range of work daies
	* @param end the upper bound of the range of work daies (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> filterFindByS_E_U(
		java.util.Date startTime, java.util.Date endTime, long userId,
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .filterFindByS_E_U(startTime, endTime, userId, start, end,
			orderByComparator);
	}

	/**
	* Returns the work daies before and after the current work day in the ordered set of work daies that the user has permission to view where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param workDayId the primary key of the current work day
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay[] filterFindByS_E_U_PrevAndNext(
		long workDayId, java.util.Date startTime, java.util.Date endTime,
		long userId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence()
				   .filterFindByS_E_U_PrevAndNext(workDayId, startTime,
			endTime, userId, orderByComparator);
	}

	/**
	* Removes all the work daies where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63; from the database.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByS_E_U(java.util.Date startTime,
		java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByS_E_U(startTime, endTime, userId);
	}

	/**
	* Returns the number of work daies where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @return the number of matching work daies
	* @throws SystemException if a system exception occurred
	*/
	public static int countByS_E_U(java.util.Date startTime,
		java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByS_E_U(startTime, endTime, userId);
	}

	/**
	* Returns the number of work daies that the user has permission to view where startTime &gt; &#63; and endTime &lt; &#63; and userId = &#63;.
	*
	* @param startTime the start time
	* @param endTime the end time
	* @param userId the user ID
	* @return the number of matching work daies that the user has permission to view
	* @throws SystemException if a system exception occurred
	*/
	public static int filterCountByS_E_U(java.util.Date startTime,
		java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().filterCountByS_E_U(startTime, endTime, userId);
	}

	/**
	* Caches the work day in the entity cache if it is enabled.
	*
	* @param workDay the work day
	*/
	public static void cacheResult(
		com.liferay.timetracking.timesheet.model.WorkDay workDay) {
		getPersistence().cacheResult(workDay);
	}

	/**
	* Caches the work daies in the entity cache if it is enabled.
	*
	* @param workDaies the work daies
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> workDaies) {
		getPersistence().cacheResult(workDaies);
	}

	/**
	* Creates a new work day with the primary key. Does not add the work day to the database.
	*
	* @param workDayId the primary key for the new work day
	* @return the new work day
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay create(
		long workDayId) {
		return getPersistence().create(workDayId);
	}

	/**
	* Removes the work day with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param workDayId the primary key of the work day
	* @return the work day that was removed
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay remove(
		long workDayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence().remove(workDayId);
	}

	public static com.liferay.timetracking.timesheet.model.WorkDay updateImpl(
		com.liferay.timetracking.timesheet.model.WorkDay workDay)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(workDay);
	}

	/**
	* Returns the work day with the primary key or throws a {@link com.liferay.timetracking.timesheet.NoSuchWorkDayException} if it could not be found.
	*
	* @param workDayId the primary key of the work day
	* @return the work day
	* @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay findByPrimaryKey(
		long workDayId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.timesheet.NoSuchWorkDayException {
		return getPersistence().findByPrimaryKey(workDayId);
	}

	/**
	* Returns the work day with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param workDayId the primary key of the work day
	* @return the work day, or <code>null</code> if a work day with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.timesheet.model.WorkDay fetchByPrimaryKey(
		long workDayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(workDayId);
	}

	/**
	* Returns all the work daies.
	*
	* @return the work daies
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the work daies from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of work daies.
	*
	* @return the number of work daies
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static WorkDayPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (WorkDayPersistence)PortletBeanLocatorUtil.locate(com.liferay.timetracking.timesheet.service.ClpSerializer.getServletContextName(),
					WorkDayPersistence.class.getName());

			ReferenceRegistry.registerReference(WorkDayUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(WorkDayPersistence persistence) {
	}

	private static WorkDayPersistence _persistence;
}