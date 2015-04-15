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

package com.liferay.timetracking.dayoffs.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.timetracking.dayoffs.model.DaysOfYear;

import java.util.List;

/**
 * The persistence utility for the days of year service. This utility wraps {@link DaysOfYearPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see DaysOfYearPersistence
 * @see DaysOfYearPersistenceImpl
 * @generated
 */
public class DaysOfYearUtil {
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
	public static void clearCache(DaysOfYear daysOfYear) {
		getPersistence().clearCache(daysOfYear);
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
	public static List<DaysOfYear> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<DaysOfYear> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<DaysOfYear> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static DaysOfYear update(DaysOfYear daysOfYear)
		throws SystemException {
		return getPersistence().update(daysOfYear);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static DaysOfYear update(DaysOfYear daysOfYear,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(daysOfYear, serviceContext);
	}

	/**
	* Returns the days of year where dayOfYearId = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	*
	* @param dayOfYearId the day of year ID
	* @return the matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByDaysOfYearId(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByDaysOfYearId(dayOfYearId);
	}

	/**
	* Returns the days of year where dayOfYearId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dayOfYearId the day of year ID
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDaysOfYearId(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDaysOfYearId(dayOfYearId);
	}

	/**
	* Returns the days of year where dayOfYearId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dayOfYearId the day of year ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDaysOfYearId(
		long dayOfYearId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByDaysOfYearId(dayOfYearId, retrieveFromCache);
	}

	/**
	* Removes the days of year where dayOfYearId = &#63; from the database.
	*
	* @param dayOfYearId the day of year ID
	* @return the days of year that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear removeByDaysOfYearId(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().removeByDaysOfYearId(dayOfYearId);
	}

	/**
	* Returns the number of days of years where dayOfYearId = &#63;.
	*
	* @param dayOfYearId the day of year ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDaysOfYearId(long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDaysOfYearId(dayOfYearId);
	}

	/**
	* Returns all the days of years where dayId = &#63;.
	*
	* @param dayId the day ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDateDay(
		java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDateDay(dayId);
	}

	/**
	* Returns a range of all the days of years where dayId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dayId the day ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDateDay(
		java.util.Date dayId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDateDay(dayId, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where dayId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dayId the day ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDateDay(
		java.util.Date dayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByDateDay(dayId, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByDateDay_First(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByDateDay_First(dayId, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDateDay_First(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDateDay_First(dayId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByDateDay_Last(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByDateDay_Last(dayId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDateDay_Last(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDateDay_Last(dayId, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where dayId = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByDateDay_PrevAndNext(
		long dayOfYearId, java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByDateDay_PrevAndNext(dayOfYearId, dayId,
			orderByComparator);
	}

	/**
	* Removes all the days of years where dayId = &#63; from the database.
	*
	* @param dayId the day ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDateDay(java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDateDay(dayId);
	}

	/**
	* Returns the number of days of years where dayId = &#63;.
	*
	* @param dayId the day ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDateDay(java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDateDay(dayId);
	}

	/**
	* Returns all the days of years where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByUnit(
		long unitId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId);
	}

	/**
	* Returns a range of all the days of years where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByUnit(
		long unitId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where unitId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitId the unit ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByUnit(
		long unitId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnit(unitId, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByUnit_First(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_First(unitId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByUnit_Last(
		long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnit_Last(unitId, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where unitId = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param unitId the unit ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByUnit_PrevAndNext(
		long dayOfYearId, long unitId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByUnit_PrevAndNext(dayOfYearId, unitId,
			orderByComparator);
	}

	/**
	* Removes all the days of years where unitId = &#63; from the database.
	*
	* @param unitId the unit ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnit(unitId);
	}

	/**
	* Returns the number of days of years where unitId = &#63;.
	*
	* @param unitId the unit ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnit(long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnit(unitId);
	}

	/**
	* Returns all the days of years where unitType = &#63;.
	*
	* @param unitType the unit type
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByUnitType(
		int unitType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitType(unitType);
	}

	/**
	* Returns a range of all the days of years where unitType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitType the unit type
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByUnitType(
		int unitType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByUnitType(unitType, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where unitType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param unitType the unit type
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByUnitType(
		int unitType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByUnitType(unitType, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where unitType = &#63;.
	*
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByUnitType_First(
		int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByUnitType_First(unitType, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where unitType = &#63;.
	*
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByUnitType_First(
		int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByUnitType_First(unitType, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where unitType = &#63;.
	*
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByUnitType_Last(
		int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByUnitType_Last(unitType, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where unitType = &#63;.
	*
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByUnitType_Last(
		int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByUnitType_Last(unitType, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where unitType = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByUnitType_PrevAndNext(
		long dayOfYearId, int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByUnitType_PrevAndNext(dayOfYearId, unitType,
			orderByComparator);
	}

	/**
	* Removes all the days of years where unitType = &#63; from the database.
	*
	* @param unitType the unit type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByUnitType(int unitType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByUnitType(unitType);
	}

	/**
	* Returns the number of days of years where unitType = &#63;.
	*
	* @param unitType the unit type
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByUnitType(int unitType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByUnitType(unitType);
	}

	/**
	* Returns the days of year where dayId = &#63; and unitId = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	*
	* @param dayId the day ID
	* @param unitId the unit ID
	* @return the matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_U(
		java.util.Date dayId, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByD_U(dayId, unitId);
	}

	/**
	* Returns the days of year where dayId = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dayId the day ID
	* @param unitId the unit ID
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_U(
		java.util.Date dayId, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_U(dayId, unitId);
	}

	/**
	* Returns the days of year where dayId = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dayId the day ID
	* @param unitId the unit ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_U(
		java.util.Date dayId, long unitId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_U(dayId, unitId, retrieveFromCache);
	}

	/**
	* Removes the days of year where dayId = &#63; and unitId = &#63; from the database.
	*
	* @param dayId the day ID
	* @param unitId the unit ID
	* @return the days of year that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear removeByD_U(
		java.util.Date dayId, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().removeByD_U(dayId, unitId);
	}

	/**
	* Returns the number of days of years where dayId = &#63; and unitId = &#63;.
	*
	* @param dayId the day ID
	* @param unitId the unit ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_U(java.util.Date dayId, long unitId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_U(dayId, unitId);
	}

	/**
	* Returns all the days of years where dayId = &#63; and unitType = &#63;.
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_UT(
		java.util.Date dayId, int unitType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_UT(dayId, unitType);
	}

	/**
	* Returns a range of all the days of years where dayId = &#63; and unitType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_UT(
		java.util.Date dayId, int unitType, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_UT(dayId, unitType, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where dayId = &#63; and unitType = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_UT(
		java.util.Date dayId, int unitType, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByD_UT(dayId, unitType, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_UT_First(
		java.util.Date dayId, int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByD_UT_First(dayId, unitType, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_UT_First(
		java.util.Date dayId, int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_UT_First(dayId, unitType, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_UT_Last(
		java.util.Date dayId, int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByD_UT_Last(dayId, unitType, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_UT_Last(
		java.util.Date dayId, int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_UT_Last(dayId, unitType, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param dayId the day ID
	* @param unitType the unit type
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByD_UT_PrevAndNext(
		long dayOfYearId, java.util.Date dayId, int unitType,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByD_UT_PrevAndNext(dayOfYearId, dayId, unitType,
			orderByComparator);
	}

	/**
	* Removes all the days of years where dayId = &#63; and unitType = &#63; from the database.
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByD_UT(java.util.Date dayId, int unitType)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByD_UT(dayId, unitType);
	}

	/**
	* Returns the number of days of years where dayId = &#63; and unitType = &#63;.
	*
	* @param dayId the day ID
	* @param unitType the unit type
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_UT(java.util.Date dayId, int unitType)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_UT(dayId, unitType);
	}

	/**
	* Caches the days of year in the entity cache if it is enabled.
	*
	* @param daysOfYear the days of year
	*/
	public static void cacheResult(
		com.liferay.timetracking.dayoffs.model.DaysOfYear daysOfYear) {
		getPersistence().cacheResult(daysOfYear);
	}

	/**
	* Caches the days of years in the entity cache if it is enabled.
	*
	* @param daysOfYears the days of years
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> daysOfYears) {
		getPersistence().cacheResult(daysOfYears);
	}

	/**
	* Creates a new days of year with the primary key. Does not add the days of year to the database.
	*
	* @param dayOfYearId the primary key for the new days of year
	* @return the new days of year
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear create(
		long dayOfYearId) {
		return getPersistence().create(dayOfYearId);
	}

	/**
	* Removes the days of year with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dayOfYearId the primary key of the days of year
	* @return the days of year that was removed
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear remove(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().remove(dayOfYearId);
	}

	public static com.liferay.timetracking.dayoffs.model.DaysOfYear updateImpl(
		com.liferay.timetracking.dayoffs.model.DaysOfYear daysOfYear)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(daysOfYear);
	}

	/**
	* Returns the days of year with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	*
	* @param dayOfYearId the primary key of the days of year
	* @return the days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByPrimaryKey(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByPrimaryKey(dayOfYearId);
	}

	/**
	* Returns the days of year with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dayOfYearId the primary key of the days of year
	* @return the days of year, or <code>null</code> if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByPrimaryKey(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(dayOfYearId);
	}

	/**
	* Returns all the days of years.
	*
	* @return the days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

	/**
	* Returns a range of all the days of years.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the days of years.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the days of years from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of days of years.
	*
	* @return the number of days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static DaysOfYearPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (DaysOfYearPersistence)PortletBeanLocatorUtil.locate(com.liferay.timetracking.dayoffs.service.ClpSerializer.getServletContextName(),
					DaysOfYearPersistence.class.getName());

			ReferenceRegistry.registerReference(DaysOfYearUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(DaysOfYearPersistence persistence) {
	}

	private static DaysOfYearPersistence _persistence;
}