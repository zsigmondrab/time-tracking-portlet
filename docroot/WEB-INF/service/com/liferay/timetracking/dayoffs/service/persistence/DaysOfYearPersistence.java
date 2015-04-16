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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.timetracking.dayoffs.model.DaysOfYear;

/**
 * The persistence interface for the days of year service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LÃ¡szlÃ³ HudÃ¡k
 * @see DaysOfYearPersistenceImpl
 * @see DaysOfYearUtil
 * @generated
 */
public interface DaysOfYearPersistence extends BasePersistence<DaysOfYear> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link DaysOfYearUtil} to access the days of year persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the days of years where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the first days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the last days of year in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByGroupId_PrevAndNext(
		long dayOfYearId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Removes all the days of years where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of days of years where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the days of years where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassNameId(
		long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassNameId(
		long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassNameId(
		long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassNameId_First(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the first days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassNameId_First(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassNameId_Last(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the last days of year in the ordered set where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassNameId_Last(
		long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByClassNameId_PrevAndNext(
		long dayOfYearId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Removes all the days of years where classNameId = &#63; from the database.
	*
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of days of years where classNameId = &#63;.
	*
	* @param classNameId the class name ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassNameId(long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the days of years where classPK = &#63;.
	*
	* @param classPK the class p k
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassPK(
		long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassPK(
		long classPK, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByClassPK(
		long classPK, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassPK_First(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the first days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassPK_First(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByClassPK_Last(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the last days of year in the ordered set where classPK = &#63;.
	*
	* @param classPK the class p k
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByClassPK_Last(
		long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByClassPK_PrevAndNext(
		long dayOfYearId, long classPK,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Removes all the days of years where classPK = &#63; from the database.
	*
	* @param classPK the class p k
	* @throws SystemException if a system exception occurred
	*/
	public void removeByClassPK(long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of days of years where classPK = &#63;.
	*
	* @param classPK the class p k
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countByClassPK(long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the days of years where dayId = &#63;.
	*
	* @param dayId the day ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDayId(
		java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDayId(
		java.util.Date dayId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByDayId(
		java.util.Date dayId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByDayId_First(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the first days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDayId_First(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByDayId_Last(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the last days of year in the ordered set where dayId = &#63;.
	*
	* @param dayId the day ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByDayId_Last(
		java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByDayId_PrevAndNext(
		long dayOfYearId, java.util.Date dayId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Removes all the days of years where dayId = &#63; from the database.
	*
	* @param dayId the day ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByDayId(java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of days of years where dayId = &#63;.
	*
	* @param dayId the day ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countByDayId(java.util.Date dayId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the days of years where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @return the matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_C(
		java.util.Date dayId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_C(
		java.util.Date dayId, long classNameId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findByD_C(
		java.util.Date dayId, long classNameId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_C_First(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the first days of year in the ordered set where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_First(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_C_Last(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the last days of year in the ordered set where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_Last(
		java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear[] findByD_C_PrevAndNext(
		long dayOfYearId, java.util.Date dayId, long classNameId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Removes all the days of years where dayId = &#63; and classNameId = &#63; from the database.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByD_C(java.util.Date dayId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of days of years where dayId = &#63; and classNameId = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_C(java.util.Date dayId, long classNameId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_C_C(
		java.util.Date dayId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the days of year where dayId = &#63; and classNameId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_C(
		java.util.Date dayId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_C_C(
		java.util.Date dayId, long classNameId, long classPK,
		boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the days of year where dayId = &#63; and classNameId = &#63; and classPK = &#63; from the database.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the days of year that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear removeByD_C_C(
		java.util.Date dayId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the number of days of years where dayId = &#63; and classNameId = &#63; and classPK = &#63;.
	*
	* @param dayId the day ID
	* @param classNameId the class name ID
	* @param classPK the class p k
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_C_C(java.util.Date dayId, long classNameId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the days of year where dayId = &#63; and classPK = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the matching days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByD_CPK(
		java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the days of year where dayId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_CPK(
		java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the days of year where dayId = &#63; and classPK = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByD_CPK(
		java.util.Date dayId, long classPK, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes the days of year where dayId = &#63; and classPK = &#63; from the database.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the days of year that was removed
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear removeByD_CPK(
		java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the number of days of years where dayId = &#63; and classPK = &#63;.
	*
	* @param dayId the day ID
	* @param classPK the class p k
	* @return the number of matching days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countByD_CPK(java.util.Date dayId, long classPK)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the days of year in the entity cache if it is enabled.
	*
	* @param daysOfYear the days of year
	*/
	public void cacheResult(
		com.liferay.timetracking.dayoffs.model.DaysOfYear daysOfYear);

	/**
	* Caches the days of years in the entity cache if it is enabled.
	*
	* @param daysOfYears the days of years
	*/
	public void cacheResult(
		java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> daysOfYears);

	/**
	* Creates a new days of year with the primary key. Does not add the days of year to the database.
	*
	* @param dayOfYearId the primary key for the new days of year
	* @return the new days of year
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear create(
		long dayOfYearId);

	/**
	* Removes the days of year with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param dayOfYearId the primary key of the days of year
	* @return the days of year that was removed
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear remove(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	public com.liferay.timetracking.dayoffs.model.DaysOfYear updateImpl(
		com.liferay.timetracking.dayoffs.model.DaysOfYear daysOfYear)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the days of year with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	*
	* @param dayOfYearId the primary key of the days of year
	* @return the days of year
	* @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear findByPrimaryKey(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;

	/**
	* Returns the days of year with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param dayOfYearId the primary key of the days of year
	* @return the days of year, or <code>null</code> if a days of year with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.dayoffs.model.DaysOfYear fetchByPrimaryKey(
		long dayOfYearId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the days of years.
	*
	* @return the days of years
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.dayoffs.model.DaysOfYear> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the days of years from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of days of years.
	*
	* @return the number of days of years
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}