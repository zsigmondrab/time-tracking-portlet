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

package com.liferay.timetracking.activities.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.timetracking.activities.model.ActivityAssignment;

import java.util.List;

/**
 * The persistence utility for the activity assignment service. This utility wraps {@link ActivityAssignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityAssignmentPersistence
 * @see ActivityAssignmentPersistenceImpl
 * @generated
 */
public class ActivityAssignmentUtil {
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
	public static void clearCache(ActivityAssignment activityAssignment) {
		getPersistence().clearCache(activityAssignment);
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
	public static List<ActivityAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<ActivityAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<ActivityAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static ActivityAssignment update(
		ActivityAssignment activityAssignment) throws SystemException {
		return getPersistence().update(activityAssignment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static ActivityAssignment update(
		ActivityAssignment activityAssignment, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(activityAssignment, serviceContext);
	}

	/**
	* Returns all the activity assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
	}

	/**
	* Returns a range of all the activity assignments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of activity assignments
	* @param end the upper bound of the range of activity assignments (not inclusive)
	* @return the range of matching activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
	}

	/**
	* Returns an ordered range of all the activity assignments where groupId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param groupId the group ID
	* @param start the lower bound of the range of activity assignments
	* @param end the upper bound of the range of activity assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
	}

	/**
	* Returns the first activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity assignment
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity assignment, or <code>null</code> if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the last activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity assignment
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity assignment, or <code>null</code> if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the activity assignments before and after the current activity assignment in the ordered set where groupId = &#63;.
	*
	* @param activityAssignmentId the primary key of the current activity assignment
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the previous, current, and next activity assignment
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment[] findByGroupId_PrevAndNext(
		long activityAssignmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(activityAssignmentId, groupId,
			orderByComparator);
	}

	/**
	* Removes all the activity assignments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of activity assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Caches the activity assignment in the entity cache if it is enabled.
	*
	* @param activityAssignment the activity assignment
	*/
	public static void cacheResult(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment) {
		getPersistence().cacheResult(activityAssignment);
	}

	/**
	* Caches the activity assignments in the entity cache if it is enabled.
	*
	* @param activityAssignments the activity assignments
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> activityAssignments) {
		getPersistence().cacheResult(activityAssignments);
	}

	/**
	* Creates a new activity assignment with the primary key. Does not add the activity assignment to the database.
	*
	* @param activityAssignmentId the primary key for the new activity assignment
	* @return the new activity assignment
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment create(
		long activityAssignmentId) {
		return getPersistence().create(activityAssignmentId);
	}

	/**
	* Removes the activity assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment that was removed
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment remove(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException {
		return getPersistence().remove(activityAssignmentId);
	}

	public static com.liferay.timetracking.activities.model.ActivityAssignment updateImpl(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(activityAssignment);
	}

	/**
	* Returns the activity assignment with the primary key or throws a {@link com.liferay.timetracking.activities.NoSuchActivityAssignmentException} if it could not be found.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment findByPrimaryKey(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException {
		return getPersistence().findByPrimaryKey(activityAssignmentId);
	}

	/**
	* Returns the activity assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment, or <code>null</code> if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.activities.model.ActivityAssignment fetchByPrimaryKey(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(activityAssignmentId);
	}

	/**
	* Returns all the activity assignments.
	*
	* @return the activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

	/**
	* Returns an ordered range of all the activity assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of activity assignments
	* @param end the upper bound of the range of activity assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the activity assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of activity assignments.
	*
	* @return the number of activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static ActivityAssignmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (ActivityAssignmentPersistence)PortletBeanLocatorUtil.locate(com.liferay.timetracking.activities.service.ClpSerializer.getServletContextName(),
					ActivityAssignmentPersistence.class.getName());

			ReferenceRegistry.registerReference(ActivityAssignmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(ActivityAssignmentPersistence persistence) {
	}

	private static ActivityAssignmentPersistence _persistence;
}