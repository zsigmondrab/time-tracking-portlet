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

import com.liferay.timetracking.model.Task;

/**
 * The persistence interface for the task service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BénaBéla
 * @see TaskPersistenceImpl
 * @see TaskUtil
 * @generated
 */
public interface TaskPersistence extends BasePersistence<Task> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. Always use {@link TaskUtil} to access the task persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
	 */

	/**
	* Returns all the tasks where taskId = &#63;.
	*
	* @param taskId the task ID
	* @return the matching tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.Task> findByTaskId(
		long taskId) throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tasks where taskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taskId the task ID
	* @param start the lower bound of the range of tasks
	* @param end the upper bound of the range of tasks (not inclusive)
	* @return the range of matching tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.Task> findByTaskId(
		long taskId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tasks where taskId = &#63;.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param taskId the task ID
	* @param start the lower bound of the range of tasks
	* @param end the upper bound of the range of tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of matching tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.Task> findByTaskId(
		long taskId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the first task in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task
	* @throws com.liferay.timetracking.NoSuchTaskException if a matching task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.Task findByTaskId_First(long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskException;

	/**
	* Returns the first task in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task, or <code>null</code> if a matching task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.Task fetchByTaskId_First(
		long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the last task in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task
	* @throws com.liferay.timetracking.NoSuchTaskException if a matching task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.Task findByTaskId_Last(long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskException;

	/**
	* Returns the last task in the ordered set where taskId = &#63;.
	*
	* @param taskId the task ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task, or <code>null</code> if a matching task could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.Task fetchByTaskId_Last(long taskId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tasks where taskId = &#63; from the database.
	*
	* @param taskId the task ID
	* @throws SystemException if a system exception occurred
	*/
	public void removeByTaskId(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tasks where taskId = &#63;.
	*
	* @param taskId the task ID
	* @return the number of matching tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countByTaskId(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Caches the task in the entity cache if it is enabled.
	*
	* @param task the task
	*/
	public void cacheResult(com.liferay.timetracking.model.Task task);

	/**
	* Caches the tasks in the entity cache if it is enabled.
	*
	* @param tasks the tasks
	*/
	public void cacheResult(
		java.util.List<com.liferay.timetracking.model.Task> tasks);

	/**
	* Creates a new task with the primary key. Does not add the task to the database.
	*
	* @param taskId the primary key for the new task
	* @return the new task
	*/
	public com.liferay.timetracking.model.Task create(long taskId);

	/**
	* Removes the task with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskId the primary key of the task
	* @return the task that was removed
	* @throws com.liferay.timetracking.NoSuchTaskException if a task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.Task remove(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskException;

	public com.liferay.timetracking.model.Task updateImpl(
		com.liferay.timetracking.model.Task task)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the task with the primary key or throws a {@link com.liferay.timetracking.NoSuchTaskException} if it could not be found.
	*
	* @param taskId the primary key of the task
	* @return the task
	* @throws com.liferay.timetracking.NoSuchTaskException if a task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.Task findByPrimaryKey(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskException;

	/**
	* Returns the task with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskId the primary key of the task
	* @return the task, or <code>null</code> if a task with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public com.liferay.timetracking.model.Task fetchByPrimaryKey(long taskId)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns all the tasks.
	*
	* @return the tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.Task> findAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns a range of all the tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tasks
	* @param end the upper bound of the range of tasks (not inclusive)
	* @return the range of tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.Task> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns an ordered range of all the tasks.
	*
	* <p>
	* Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.model.impl.TaskModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	* </p>
	*
	* @param start the lower bound of the range of tasks
	* @param end the upper bound of the range of tasks (not inclusive)
	* @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	* @return the ordered range of tasks
	* @throws SystemException if a system exception occurred
	*/
	public java.util.List<com.liferay.timetracking.model.Task> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Removes all the tasks from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException;

	/**
	* Returns the number of tasks.
	*
	* @return the number of tasks
	* @throws SystemException if a system exception occurred
	*/
	public int countAll()
		throws com.liferay.portal.kernel.exception.SystemException;
}