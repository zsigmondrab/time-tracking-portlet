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

package com.liferay.timetracking.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import com.liferay.timetracking.model.TaskAssignment;

/**
 * The persistence interface for the task assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BénaBéla
 * @see TaskAssignmentPersistenceImpl
 * @see TaskAssignmentUtil
 * @generated
 */
public interface TaskAssignmentPersistence extends BasePersistence<TaskAssignment> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskAssignmentUtil} to access the task assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the task assignments where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @return the matching task assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.TaskAssignment> findByTaskAssignmentId(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the task assignments where taskAssignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taskAssignmentId the task assignment ID
	* @param start the lower bound of the range of task assignments
	* @param end the upper bound of the range of task assignments (not inclusive)
	* @return the range of matching task assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.TaskAssignment> findByTaskAssignmentId(
		long taskAssignmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the task assignments where taskAssignmentId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taskAssignmentId the task assignment ID
	* @param start the lower bound of the range of task assignments
	* @param end the upper bound of the range of task assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching task assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.TaskAssignment> findByTaskAssignmentId(
		long taskAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task assignment
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.TaskAssignment findByTaskAssignmentId_First(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException;

	/**
	* Returns the first task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task assignment, or <code>null</code> if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.TaskAssignment fetchByTaskAssignmentId_First(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task assignment
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.TaskAssignment findByTaskAssignmentId_Last(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException;

	/**
	* Returns the last task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task assignment, or <code>null</code> if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.TaskAssignment fetchByTaskAssignmentId_Last(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the task assignments where taskAssignmentId = &#63; from the database.
	*
	* @param taskAssignmentId the task assignment ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTaskAssignmentId(long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of task assignments where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @return the number of matching task assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countByTaskAssignmentId(long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the task assignment in the entity cache if it is enabled.
	*
	* @param taskAssignment the task assignment
	*/
	public void cacheResult(
		com.liferay.timetracking.model.TaskAssignment taskAssignment);

	/**
	* Caches the task assignments in the entity cache if it is enabled.
	*
	* @param taskAssignments the task assignments
	*/
	public void cacheResult(
		java.util.List<com.liferay.timetracking.model.TaskAssignment> taskAssignments);

	/**
	* Creates a new task assignment with the primary key. Does not add the task assignment to the database.
	*
	* @param taskAssignmentId the primary key for the new task assignment
	* @return the new task assignment
	*/
	public com.liferay.timetracking.model.TaskAssignment create(
		long taskAssignmentId);

	/**
	* Removes the task assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskAssignmentId the primary key of the task assignment
	* @return the task assignment that was removed
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.TaskAssignment remove(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException;

	public com.liferay.timetracking.model.TaskAssignment updateImpl(
		com.liferay.timetracking.model.TaskAssignment taskAssignment)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the task assignment with the primary key or throws a {@link com.liferay.timetracking.NoSuchTaskAssignmentException} if it could not be found.
	*
	* @param taskAssignmentId the primary key of the task assignment
	* @return the task assignment
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.TaskAssignment findByPrimaryKey(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException;

	/**
	* Returns the task assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskAssignmentId the primary key of the task assignment
	* @return the task assignment, or <code>null</code> if a task assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.TaskAssignment fetchByPrimaryKey(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the task assignments.
	*
	* @return the task assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.TaskAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the task assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task assignments
	* @param end the upper bound of the range of task assignments (not inclusive)
	* @return the range of task assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.TaskAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the task assignments.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of task assignments
	* @param end the upper bound of the range of task assignments (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of task assignments
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.TaskAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the task assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of task assignments.
	*
	* @return the number of task assignments
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}