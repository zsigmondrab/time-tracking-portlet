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

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.timetracking.activities.model.ActivityAssignment;

/**
 * The persistence interface for the activity assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityAssignmentPersistenceImpl
 * @see ActivityAssignmentUtil
 * @generated
 */
public interface ActivityAssignmentPersistence extends BasePersistence<ActivityAssignment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link ActivityAssignmentUtil} to access the activity assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the activity assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity assignment
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException;

	/**
	* Returns the first activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching activity assignment, or <code>null</code> if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity assignment
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException;

	/**
	* Returns the last activity assignment in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching activity assignment, or <code>null</code> if a matching activity assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public com.liferay.timetracking.activities.model.ActivityAssignment[] findByGroupId_PrevAndNext(
		long activityAssignmentId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException;

	/**
	* Removes all the activity assignments where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of activity assignments where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the activity assignment in the entity cache if it is enabled.
	*
	* @param activityAssignment the activity assignment
	*/
	public void cacheResult(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment);

	/**
	* Caches the activity assignments in the entity cache if it is enabled.
	*
	* @param activityAssignments the activity assignments
	*/
	public void cacheResult(
		java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> activityAssignments);

	/**
	* Creates a new activity assignment with the primary key. Does not add the activity assignment to the database.
	*
	* @param activityAssignmentId the primary key for the new activity assignment
	* @return the new activity assignment
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment create(
		long activityAssignmentId);

	/**
	* Removes the activity assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment that was removed
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment remove(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException;

	public com.liferay.timetracking.activities.model.ActivityAssignment updateImpl(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the activity assignment with the primary key or throws a {@link com.liferay.timetracking.activities.NoSuchActivityAssignmentException} if it could not be found.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment
	* @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment findByPrimaryKey(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.activities.NoSuchActivityAssignmentException;

	/**
	* Returns the activity assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param activityAssignmentId the primary key of the activity assignment
	* @return the activity assignment, or <code>null</code> if a activity assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.activities.model.ActivityAssignment fetchByPrimaryKey(
		long activityAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the activity assignments.
	*
	* @return the activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

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
	public java.util.List<com.liferay.timetracking.activities.model.ActivityAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the activity assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of activity assignments.
	*
	* @return the number of activity assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}