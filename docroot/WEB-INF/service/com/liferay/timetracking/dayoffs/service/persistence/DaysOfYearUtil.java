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
 * @author LÃ¡szlÃ³ HudÃ¡k
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
	* Returns all the days of years where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the days of years where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where groupId = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByGroupId_PrevAndNext(
		long dayOfYearId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(dayOfYearId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the days of years where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of days of years where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the days of years where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassNameId(
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassNameId(classNameId);
	}

	/**
	* Returns a range of all the days of years where classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classNameId the class name ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassNameId(
		long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassNameId(classNameId, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classNameId the class name ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassNameId(
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassNameId(classNameId, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassNameId_First(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByClassNameId_First(classNameId, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassNameId_First(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameId_First(classNameId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassNameId_Last(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByClassNameId_Last(classNameId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassNameId_Last(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByClassNameId_Last(classNameId, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where classNameId = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByClassNameId_PrevAndNext(
		long dayOfYearId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByClassNameId_PrevAndNext(dayOfYearId, classNameId,
			orderByComparator);
	}

	/**
	* Removes all the days of years where classNameId = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClassNameId(classNameId);
	}

	/**
	* Returns the number of days of years where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClassNameId(classNameId);
	}

	/**
	* Returns all the days of years where classPK = &#63;.
	*
	* @param classPK the class p k
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassPK(
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassPK(classPK);
	}

	/**
	* Returns a range of all the days of years where classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPK the class p k
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassPK(
		long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByClassPK(classPK, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where classPK = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param classPK the class p k
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassPK(
		long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByClassPK(classPK, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassPK_First(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByClassPK_First(classPK, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassPK_First(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByClassPK_First(classPK, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassPK_Last(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByClassPK_Last(classPK, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassPK_Last(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByClassPK_Last(classPK, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where classPK = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByClassPK_PrevAndNext(
		long dayOfYearId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByClassPK_PrevAndNext(dayOfYearId, classPK,
			orderByComparator);
	}

	/**
	* Removes all the days of years where classPK = &#63; from the database.
	*
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByClassPK(long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByClassPK(classPK);
	}

	/**
	* Returns the number of days of years where classPK = &#63;.
	*
	* @param classPK the class p k
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByClassPK(long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByClassPK(classPK);
	}

	/**
	* Returns all the days of years where dayId = &#63;.
	*
	* @param dayId the day ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDayId(
		java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDayId(dayId);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDayId(
		java.util.Date dayId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDayId(dayId, start, end);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDayId(
		java.util.Date dayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByDayId(dayId, start, end, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByDayId_First(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByDayId_First(dayId, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDayId_First(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDayId_First(dayId, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByDayId_Last(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByDayId_Last(dayId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDayId_Last(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByDayId_Last(dayId, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByDayId_PrevAndNext(
		long dayOfYearId, java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByDayId_PrevAndNext(dayOfYearId, dayId,
			orderByComparator);
	}

	/**
	* Removes all the days of years where dayId = &#63; from the database.
	*
	* @param dayId the day ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByDayId(java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByDayId(dayId);
	}

	/**
	* Returns the number of days of years where dayId = &#63;.
	*
	* @param dayId the day ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByDayId(java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByDayId(dayId);
	}

	/**
	* Returns all the days of years where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_C(
		java.util.Date dayId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_C(dayId, classNameId);
	}

	/**
	* Returns a range of all the days of years where dayId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @return the range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_C(
		java.util.Date dayId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByD_C(dayId, classNameId, start, end);
	}

	/**
	* Returns an ordered range of all the days of years where dayId = &#63; and classNameId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param start the lower bound of the range of days of years
	* @param end the upper bound of the range of days of years (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_C(
		java.util.Date dayId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByD_C(dayId, classNameId, start, end, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_C_First(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByD_C_First(dayId, classNameId, orderByComparator);
	}

	/**
	* Returns the first days of year in the ordered set where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_First(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_C_First(dayId, classNameId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_C_Last(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByD_C_Last(dayId, classNameId, orderByComparator);
	}

	/**
	* Returns the last days of year in the ordered set where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_Last(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_C_Last(dayId, classNameId, orderByComparator);
	}

	/**
	* Returns the days of years before and after the current days of year in the ordered set where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayOfYearId the primary key of the current days of year
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByD_C_PrevAndNext(
		long dayOfYearId, java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence()
				   .findByD_C_PrevAndNext(dayOfYearId, dayId, classNameId,
			orderByComparator);
	}

	/**
	* Removes all the days of years where dayId = &#63; and classNameId = &#63; from the database.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByD_C(java.util.Date dayId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByD_C(dayId, classNameId);
	}

	/**
	* Returns the number of days of years where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_C(java.util.Date dayId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_C(dayId, classNameId);
	}

	/**
	* Returns the days of year where dayId = &#63; and classNameId = &#63; and classPK = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_C_C(
		java.util.Date dayId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByD_C_C(dayId, classNameId, classPK);
	}

	/**
	* Returns the days of year where dayId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_C(
		java.util.Date dayId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_C_C(dayId, classNameId, classPK);
	}

	/**
	* Returns the days of year where dayId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_C(
		java.util.Date dayId, long classNameId, long classPK,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByD_C_C(dayId, classNameId, classPK, retrieveFromCache);
	}

	/**
	* Removes the days of year where dayId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the days of year that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear removeByD_C_C(
		java.util.Date dayId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().removeByD_C_C(dayId, classNameId, classPK);
	}

	/**
	* Returns the number of days of years where dayId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_C_C(java.util.Date dayId, long classNameId,
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_C_C(dayId, classNameId, classPK);
	}

	/**
	* Returns the days of year where dayId = &#63; and classPK = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_CPK(
		java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().findByD_CPK(dayId, classPK);
	}

	/**
	* Returns the days of year where dayId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_CPK(
		java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_CPK(dayId, classPK);
	}

	/**
	* Returns the days of year where dayId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_CPK(
		java.util.Date dayId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByD_CPK(dayId, classPK, retrieveFromCache);
	}

	/**
	* Removes the days of year where dayId = &#63; and classPK = &#63; from the database.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the days of year that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.DaysOfYear removeByD_CPK(
		java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException {
		return getPersistence().removeByD_CPK(dayId, classPK);
	}

	/**
	* Returns the number of days of years where dayId = &#63; and classPK = &#63;.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public static int countByD_CPK(java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByD_CPK(dayId, classPK);
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