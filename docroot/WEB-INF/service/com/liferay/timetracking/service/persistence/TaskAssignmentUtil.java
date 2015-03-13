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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.timetracking.model.TaskAssignment;

import java.util.List;

/**
 * The persistence utility for the task assignment service. This utility wraps {@link TaskAssignmentPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BénaBéla
 * @see TaskAssignmentPersistence
 * @see TaskAssignmentPersistenceImpl
 * @generated
 */
public class TaskAssignmentUtil {
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
	public static void clearCache(TaskAssignment taskAssignment) {
		getPersistence().clearCache(taskAssignment);
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
	public static List<TaskAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<TaskAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<TaskAssignment> findWithDynamicQuery(
		DynamicQuery dynamicQuery, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static TaskAssignment update(TaskAssignment taskAssignment)
		throws SystemException {
		return getPersistence().update(taskAssignment);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static TaskAssignment update(TaskAssignment taskAssignment,
		ServiceContext serviceContext) throws SystemException {
		return getPersistence().update(taskAssignment, serviceContext);
	}

	/**
	* Returns all the task assignments where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @return the matching task assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.model.TaskAssignment> findByTaskAssignmentId(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByTaskAssignmentId(taskAssignmentId);
	}

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
	public static java.util.List<com.liferay.timetracking.model.TaskAssignment> findByTaskAssignmentId(
		long taskAssignmentId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaskAssignmentId(taskAssignmentId, start, end);
	}

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
	public static java.util.List<com.liferay.timetracking.model.TaskAssignment> findByTaskAssignmentId(
		long taskAssignmentId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByTaskAssignmentId(taskAssignmentId, start, end,
			orderByComparator);
	}

	/**
	* Returns the first task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task assignment
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.model.TaskAssignment findByTaskAssignmentId_First(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException {
		return getPersistence()
				   .findByTaskAssignmentId_First(taskAssignmentId,
			orderByComparator);
	}

	/**
	* Returns the first task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching task assignment, or <code>null</code> if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.model.TaskAssignment fetchByTaskAssignmentId_First(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTaskAssignmentId_First(taskAssignmentId,
			orderByComparator);
	}

	/**
	* Returns the last task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task assignment
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.model.TaskAssignment findByTaskAssignmentId_Last(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException {
		return getPersistence()
				   .findByTaskAssignmentId_Last(taskAssignmentId,
			orderByComparator);
	}

	/**
	* Returns the last task assignment in the ordered set where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching task assignment, or <code>null</code> if a matching task assignment could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.model.TaskAssignment fetchByTaskAssignmentId_Last(
		long taskAssignmentId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByTaskAssignmentId_Last(taskAssignmentId,
			orderByComparator);
	}

	/**
	* Removes all the task assignments where taskAssignmentId = &#63; from the database.
	*
	* @param taskAssignmentId the task assignment ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByTaskAssignmentId(long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByTaskAssignmentId(taskAssignmentId);
	}

	/**
	* Returns the number of task assignments where taskAssignmentId = &#63;.
	*
	* @param taskAssignmentId the task assignment ID
	* @return the number of matching task assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countByTaskAssignmentId(long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByTaskAssignmentId(taskAssignmentId);
	}

	/**
	* Caches the task assignment in the entity cache if it is enabled.
	*
	* @param taskAssignment the task assignment
	*/
	public static void cacheResult(
		com.liferay.timetracking.model.TaskAssignment taskAssignment) {
		getPersistence().cacheResult(taskAssignment);
	}

	/**
	* Caches the task assignments in the entity cache if it is enabled.
	*
	* @param taskAssignments the task assignments
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timetracking.model.TaskAssignment> taskAssignments) {
		getPersistence().cacheResult(taskAssignments);
	}

	/**
	* Creates a new task assignment with the primary key. Does not add the task assignment to the database.
	*
	* @param taskAssignmentId the primary key for the new task assignment
	* @return the new task assignment
	*/
	public static com.liferay.timetracking.model.TaskAssignment create(
		long taskAssignmentId) {
		return getPersistence().create(taskAssignmentId);
	}

	/**
	* Removes the task assignment with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param taskAssignmentId the primary key of the task assignment
	* @return the task assignment that was removed
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.model.TaskAssignment remove(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException {
		return getPersistence().remove(taskAssignmentId);
	}

	public static com.liferay.timetracking.model.TaskAssignment updateImpl(
		com.liferay.timetracking.model.TaskAssignment taskAssignment)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(taskAssignment);
	}

	/**
	* Returns the task assignment with the primary key or throws a {@link com.liferay.timetracking.NoSuchTaskAssignmentException} if it could not be found.
	*
	* @param taskAssignmentId the primary key of the task assignment
	* @return the task assignment
	* @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.model.TaskAssignment findByPrimaryKey(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.NoSuchTaskAssignmentException {
		return getPersistence().findByPrimaryKey(taskAssignmentId);
	}

	/**
	* Returns the task assignment with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param taskAssignmentId the primary key of the task assignment
	* @return the task assignment, or <code>null</code> if a task assignment with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.model.TaskAssignment fetchByPrimaryKey(
		long taskAssignmentId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(taskAssignmentId);
	}

	/**
	* Returns all the task assignments.
	*
	* @return the task assignments
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.model.TaskAssignment> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
	}

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
	public static java.util.List<com.liferay.timetracking.model.TaskAssignment> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
	}

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
	public static java.util.List<com.liferay.timetracking.model.TaskAssignment> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the task assignments from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of task assignments.
	*
	* @return the number of task assignments
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static TaskAssignmentPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (TaskAssignmentPersistence)PortletBeanLocatorUtil.locate(com.liferay.timetracking.service.ClpSerializer.getServletContextName(),
					TaskAssignmentPersistence.class.getName());

			ReferenceRegistry.registerReference(TaskAssignmentUtil.class,
				"_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(TaskAssignmentPersistence persistence) {
	}

	private static TaskAssignmentPersistence _persistence;
}