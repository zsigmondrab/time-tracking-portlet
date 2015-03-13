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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.timetracking.NoSuchTaskAssignmentException;
import com.liferay.timetracking.model.TaskAssignment;
import com.liferay.timetracking.model.impl.TaskAssignmentImpl;
import com.liferay.timetracking.model.impl.TaskAssignmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the task assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author BénaBéla
 * @see TaskAssignmentPersistence
 * @see TaskAssignmentUtil
 * @generated
 */
public class TaskAssignmentPersistenceImpl extends BasePersistenceImpl<TaskAssignment>
	implements TaskAssignmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link TaskAssignmentUtil} to access the task assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = TaskAssignmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TaskAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TaskAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_TASKASSIGNMENTID =
		new FinderPath(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TaskAssignmentImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByTaskAssignmentId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKASSIGNMENTID =
		new FinderPath(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentModelImpl.FINDER_CACHE_ENABLED,
			TaskAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"findByTaskAssignmentId", new String[] { Long.class.getName() },
			TaskAssignmentModelImpl.TASKASSIGNMENTID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_TASKASSIGNMENTID = new FinderPath(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION,
			"countByTaskAssignmentId", new String[] { Long.class.getName() });

	/**
	 * Returns all the task assignments where taskAssignmentId = &#63;.
	 *
	 * @param taskAssignmentId the task assignment ID
	 * @return the matching task assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskAssignment> findByTaskAssignmentId(long taskAssignmentId)
		throws SystemException {
		return findByTaskAssignmentId(taskAssignmentId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskAssignment> findByTaskAssignmentId(long taskAssignmentId,
		int start, int end) throws SystemException {
		return findByTaskAssignmentId(taskAssignmentId, start, end, null);
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
	@Override
	public List<TaskAssignment> findByTaskAssignmentId(long taskAssignmentId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKASSIGNMENTID;
			finderArgs = new Object[] { taskAssignmentId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_TASKASSIGNMENTID;
			finderArgs = new Object[] {
					taskAssignmentId,
					
					start, end, orderByComparator
				};
		}

		List<TaskAssignment> list = (List<TaskAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (TaskAssignment taskAssignment : list) {
				if ((taskAssignmentId != taskAssignment.getTaskAssignmentId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(3 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(3);
			}

			query.append(_SQL_SELECT_TASKASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_TASKASSIGNMENTID_TASKASSIGNMENTID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(TaskAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskAssignmentId);

				if (!pagination) {
					list = (List<TaskAssignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaskAssignment>(list);
				}
				else {
					list = (List<TaskAssignment>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
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
	@Override
	public TaskAssignment findByTaskAssignmentId_First(long taskAssignmentId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskAssignmentException, SystemException {
		TaskAssignment taskAssignment = fetchByTaskAssignmentId_First(taskAssignmentId,
				orderByComparator);

		if (taskAssignment != null) {
			return taskAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taskAssignmentId=");
		msg.append(taskAssignmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskAssignmentException(msg.toString());
	}

	/**
	 * Returns the first task assignment in the ordered set where taskAssignmentId = &#63;.
	 *
	 * @param taskAssignmentId the task assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching task assignment, or <code>null</code> if a matching task assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment fetchByTaskAssignmentId_First(long taskAssignmentId,
		OrderByComparator orderByComparator) throws SystemException {
		List<TaskAssignment> list = findByTaskAssignmentId(taskAssignmentId, 0,
				1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public TaskAssignment findByTaskAssignmentId_Last(long taskAssignmentId,
		OrderByComparator orderByComparator)
		throws NoSuchTaskAssignmentException, SystemException {
		TaskAssignment taskAssignment = fetchByTaskAssignmentId_Last(taskAssignmentId,
				orderByComparator);

		if (taskAssignment != null) {
			return taskAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("taskAssignmentId=");
		msg.append(taskAssignmentId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchTaskAssignmentException(msg.toString());
	}

	/**
	 * Returns the last task assignment in the ordered set where taskAssignmentId = &#63;.
	 *
	 * @param taskAssignmentId the task assignment ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching task assignment, or <code>null</code> if a matching task assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment fetchByTaskAssignmentId_Last(long taskAssignmentId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByTaskAssignmentId(taskAssignmentId);

		if (count == 0) {
			return null;
		}

		List<TaskAssignment> list = findByTaskAssignmentId(taskAssignmentId,
				count - 1, count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Removes all the task assignments where taskAssignmentId = &#63; from the database.
	 *
	 * @param taskAssignmentId the task assignment ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByTaskAssignmentId(long taskAssignmentId)
		throws SystemException {
		for (TaskAssignment taskAssignment : findByTaskAssignmentId(
				taskAssignmentId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(taskAssignment);
		}
	}

	/**
	 * Returns the number of task assignments where taskAssignmentId = &#63;.
	 *
	 * @param taskAssignmentId the task assignment ID
	 * @return the number of matching task assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByTaskAssignmentId(long taskAssignmentId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_TASKASSIGNMENTID;

		Object[] finderArgs = new Object[] { taskAssignmentId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_TASKASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_TASKASSIGNMENTID_TASKASSIGNMENTID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(taskAssignmentId);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(finderPath, finderArgs, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	private static final String _FINDER_COLUMN_TASKASSIGNMENTID_TASKASSIGNMENTID_2 =
		"taskAssignment.taskAssignmentId = ?";

	public TaskAssignmentPersistenceImpl() {
		setModelClass(TaskAssignment.class);
	}

	/**
	 * Caches the task assignment in the entity cache if it is enabled.
	 *
	 * @param taskAssignment the task assignment
	 */
	@Override
	public void cacheResult(TaskAssignment taskAssignment) {
		EntityCacheUtil.putResult(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentImpl.class, taskAssignment.getPrimaryKey(),
			taskAssignment);

		taskAssignment.resetOriginalValues();
	}

	/**
	 * Caches the task assignments in the entity cache if it is enabled.
	 *
	 * @param taskAssignments the task assignments
	 */
	@Override
	public void cacheResult(List<TaskAssignment> taskAssignments) {
		for (TaskAssignment taskAssignment : taskAssignments) {
			if (EntityCacheUtil.getResult(
						TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						TaskAssignmentImpl.class, taskAssignment.getPrimaryKey()) == null) {
				cacheResult(taskAssignment);
			}
			else {
				taskAssignment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all task assignments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(TaskAssignmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(TaskAssignmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the task assignment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(TaskAssignment taskAssignment) {
		EntityCacheUtil.removeResult(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentImpl.class, taskAssignment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<TaskAssignment> taskAssignments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (TaskAssignment taskAssignment : taskAssignments) {
			EntityCacheUtil.removeResult(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				TaskAssignmentImpl.class, taskAssignment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new task assignment with the primary key. Does not add the task assignment to the database.
	 *
	 * @param taskAssignmentId the primary key for the new task assignment
	 * @return the new task assignment
	 */
	@Override
	public TaskAssignment create(long taskAssignmentId) {
		TaskAssignment taskAssignment = new TaskAssignmentImpl();

		taskAssignment.setNew(true);
		taskAssignment.setPrimaryKey(taskAssignmentId);

		return taskAssignment;
	}

	/**
	 * Removes the task assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param taskAssignmentId the primary key of the task assignment
	 * @return the task assignment that was removed
	 * @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment remove(long taskAssignmentId)
		throws NoSuchTaskAssignmentException, SystemException {
		return remove((Serializable)taskAssignmentId);
	}

	/**
	 * Removes the task assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the task assignment
	 * @return the task assignment that was removed
	 * @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment remove(Serializable primaryKey)
		throws NoSuchTaskAssignmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			TaskAssignment taskAssignment = (TaskAssignment)session.get(TaskAssignmentImpl.class,
					primaryKey);

			if (taskAssignment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchTaskAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(taskAssignment);
		}
		catch (NoSuchTaskAssignmentException nsee) {
			throw nsee;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	protected TaskAssignment removeImpl(TaskAssignment taskAssignment)
		throws SystemException {
		taskAssignment = toUnwrappedModel(taskAssignment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(taskAssignment)) {
				taskAssignment = (TaskAssignment)session.get(TaskAssignmentImpl.class,
						taskAssignment.getPrimaryKeyObj());
			}

			if (taskAssignment != null) {
				session.delete(taskAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (taskAssignment != null) {
			clearCache(taskAssignment);
		}

		return taskAssignment;
	}

	@Override
	public TaskAssignment updateImpl(
		com.liferay.timetracking.model.TaskAssignment taskAssignment)
		throws SystemException {
		taskAssignment = toUnwrappedModel(taskAssignment);

		boolean isNew = taskAssignment.isNew();

		TaskAssignmentModelImpl taskAssignmentModelImpl = (TaskAssignmentModelImpl)taskAssignment;

		Session session = null;

		try {
			session = openSession();

			if (taskAssignment.isNew()) {
				session.save(taskAssignment);

				taskAssignment.setNew(false);
			}
			else {
				session.merge(taskAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !TaskAssignmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((taskAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKASSIGNMENTID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						taskAssignmentModelImpl.getOriginalTaskAssignmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASKASSIGNMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKASSIGNMENTID,
					args);

				args = new Object[] {
						taskAssignmentModelImpl.getTaskAssignmentId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_TASKASSIGNMENTID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_TASKASSIGNMENTID,
					args);
			}
		}

		EntityCacheUtil.putResult(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			TaskAssignmentImpl.class, taskAssignment.getPrimaryKey(),
			taskAssignment);

		return taskAssignment;
	}

	protected TaskAssignment toUnwrappedModel(TaskAssignment taskAssignment) {
		if (taskAssignment instanceof TaskAssignmentImpl) {
			return taskAssignment;
		}

		TaskAssignmentImpl taskAssignmentImpl = new TaskAssignmentImpl();

		taskAssignmentImpl.setNew(taskAssignment.isNew());
		taskAssignmentImpl.setPrimaryKey(taskAssignment.getPrimaryKey());

		taskAssignmentImpl.setTaskAssignmentId(taskAssignment.getTaskAssignmentId());
		taskAssignmentImpl.setTaskId(taskAssignment.getTaskId());
		taskAssignmentImpl.setWorkDayId(taskAssignment.getWorkDayId());
		taskAssignmentImpl.setStartTime(taskAssignment.getStartTime());
		taskAssignmentImpl.setEndTime(taskAssignment.getEndTime());
		taskAssignmentImpl.setCompanyId(taskAssignment.getCompanyId());
		taskAssignmentImpl.setGroupId(taskAssignment.getGroupId());
		taskAssignmentImpl.setUserId(taskAssignment.getUserId());
		taskAssignmentImpl.setUserName(taskAssignment.getUserName());
		taskAssignmentImpl.setCreateDate(taskAssignment.getCreateDate());
		taskAssignmentImpl.setModifiedDate(taskAssignment.getModifiedDate());

		return taskAssignmentImpl;
	}

	/**
	 * Returns the task assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the task assignment
	 * @return the task assignment
	 * @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchTaskAssignmentException, SystemException {
		TaskAssignment taskAssignment = fetchByPrimaryKey(primaryKey);

		if (taskAssignment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchTaskAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return taskAssignment;
	}

	/**
	 * Returns the task assignment with the primary key or throws a {@link com.liferay.timetracking.NoSuchTaskAssignmentException} if it could not be found.
	 *
	 * @param taskAssignmentId the primary key of the task assignment
	 * @return the task assignment
	 * @throws com.liferay.timetracking.NoSuchTaskAssignmentException if a task assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment findByPrimaryKey(long taskAssignmentId)
		throws NoSuchTaskAssignmentException, SystemException {
		return findByPrimaryKey((Serializable)taskAssignmentId);
	}

	/**
	 * Returns the task assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the task assignment
	 * @return the task assignment, or <code>null</code> if a task assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		TaskAssignment taskAssignment = (TaskAssignment)EntityCacheUtil.getResult(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				TaskAssignmentImpl.class, primaryKey);

		if (taskAssignment == _nullTaskAssignment) {
			return null;
		}

		if (taskAssignment == null) {
			Session session = null;

			try {
				session = openSession();

				taskAssignment = (TaskAssignment)session.get(TaskAssignmentImpl.class,
						primaryKey);

				if (taskAssignment != null) {
					cacheResult(taskAssignment);
				}
				else {
					EntityCacheUtil.putResult(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						TaskAssignmentImpl.class, primaryKey,
						_nullTaskAssignment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(TaskAssignmentModelImpl.ENTITY_CACHE_ENABLED,
					TaskAssignmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return taskAssignment;
	}

	/**
	 * Returns the task assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param taskAssignmentId the primary key of the task assignment
	 * @return the task assignment, or <code>null</code> if a task assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public TaskAssignment fetchByPrimaryKey(long taskAssignmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)taskAssignmentId);
	}

	/**
	 * Returns all the task assignments.
	 *
	 * @return the task assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<TaskAssignment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<TaskAssignment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<TaskAssignment> findAll(int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL;
			finderArgs = FINDER_ARGS_EMPTY;
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_ALL;
			finderArgs = new Object[] { start, end, orderByComparator };
		}

		List<TaskAssignment> list = (List<TaskAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_TASKASSIGNMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_TASKASSIGNMENT;

				if (pagination) {
					sql = sql.concat(TaskAssignmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<TaskAssignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<TaskAssignment>(list);
				}
				else {
					list = (List<TaskAssignment>)QueryUtil.list(q,
							getDialect(), start, end);
				}

				cacheResult(list);

				FinderCacheUtil.putResult(finderPath, finderArgs, list);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(finderPath, finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return list;
	}

	/**
	 * Removes all the task assignments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (TaskAssignment taskAssignment : findAll()) {
			remove(taskAssignment);
		}
	}

	/**
	 * Returns the number of task assignments.
	 *
	 * @return the number of task assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countAll() throws SystemException {
		Long count = (Long)FinderCacheUtil.getResult(FINDER_PATH_COUNT_ALL,
				FINDER_ARGS_EMPTY, this);

		if (count == null) {
			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(_SQL_COUNT_TASKASSIGNMENT);

				count = (Long)q.uniqueResult();

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY, count);
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_ALL,
					FINDER_ARGS_EMPTY);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return count.intValue();
	}

	/**
	 * Initializes the task assignment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.model.TaskAssignment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<TaskAssignment>> listenersList = new ArrayList<ModelListener<TaskAssignment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<TaskAssignment>)InstanceFactory.newInstance(
							getClassLoader(), listenerClassName));
				}

				listeners = listenersList.toArray(new ModelListener[listenersList.size()]);
			}
			catch (Exception e) {
				_log.error(e);
			}
		}
	}

	public void destroy() {
		EntityCacheUtil.removeCache(TaskAssignmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_TASKASSIGNMENT = "SELECT taskAssignment FROM TaskAssignment taskAssignment";
	private static final String _SQL_SELECT_TASKASSIGNMENT_WHERE = "SELECT taskAssignment FROM TaskAssignment taskAssignment WHERE ";
	private static final String _SQL_COUNT_TASKASSIGNMENT = "SELECT COUNT(taskAssignment) FROM TaskAssignment taskAssignment";
	private static final String _SQL_COUNT_TASKASSIGNMENT_WHERE = "SELECT COUNT(taskAssignment) FROM TaskAssignment taskAssignment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "taskAssignment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No TaskAssignment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No TaskAssignment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(TaskAssignmentPersistenceImpl.class);
	private static TaskAssignment _nullTaskAssignment = new TaskAssignmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<TaskAssignment> toCacheModel() {
				return _nullTaskAssignmentCacheModel;
			}
		};

	private static CacheModel<TaskAssignment> _nullTaskAssignmentCacheModel = new CacheModel<TaskAssignment>() {
			@Override
			public TaskAssignment toEntityModel() {
				return _nullTaskAssignment;
			}
		};
}