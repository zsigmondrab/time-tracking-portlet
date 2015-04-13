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

import com.liferay.portal.kernel.cache.CacheRegistryUtil;
import com.liferay.portal.kernel.dao.orm.EntityCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderCacheUtil;
import com.liferay.portal.kernel.dao.orm.FinderPath;
import com.liferay.portal.kernel.dao.orm.Query;
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
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.timetracking.timesheet.NoSuchWorkDayException;
import com.liferay.timetracking.timesheet.model.WorkDay;
import com.liferay.timetracking.timesheet.model.impl.WorkDayImpl;
import com.liferay.timetracking.timesheet.model.impl.WorkDayModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the work day service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see WorkDayPersistence
 * @see WorkDayUtil
 * @generated
 */
public class WorkDayPersistenceImpl extends BasePersistenceImpl<WorkDay>
	implements WorkDayPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link WorkDayUtil} to access the work day persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = WorkDayImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
			WorkDayModelImpl.FINDER_CACHE_ENABLED, WorkDayImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
			WorkDayModelImpl.FINDER_CACHE_ENABLED, WorkDayImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
			WorkDayModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);

	public WorkDayPersistenceImpl() {
		setModelClass(WorkDay.class);
	}

	/**
	 * Caches the work day in the entity cache if it is enabled.
	 *
	 * @param workDay the work day
	 */
	@Override
	public void cacheResult(WorkDay workDay) {
		EntityCacheUtil.putResult(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
			WorkDayImpl.class, workDay.getPrimaryKey(), workDay);

		workDay.resetOriginalValues();
	}

	/**
	 * Caches the work daies in the entity cache if it is enabled.
	 *
	 * @param workDaies the work daies
	 */
	@Override
	public void cacheResult(List<WorkDay> workDaies) {
		for (WorkDay workDay : workDaies) {
			if (EntityCacheUtil.getResult(
						WorkDayModelImpl.ENTITY_CACHE_ENABLED,
						WorkDayImpl.class, workDay.getPrimaryKey()) == null) {
				cacheResult(workDay);
			}
			else {
				workDay.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all work daies.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(WorkDayImpl.class.getName());
		}

		EntityCacheUtil.clearCache(WorkDayImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the work day.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(WorkDay workDay) {
		EntityCacheUtil.removeResult(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
			WorkDayImpl.class, workDay.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<WorkDay> workDaies) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (WorkDay workDay : workDaies) {
			EntityCacheUtil.removeResult(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
				WorkDayImpl.class, workDay.getPrimaryKey());
		}
	}

	/**
	 * Creates a new work day with the primary key. Does not add the work day to the database.
	 *
	 * @param workDayId the primary key for the new work day
	 * @return the new work day
	 */
	@Override
	public WorkDay create(long workDayId) {
		WorkDay workDay = new WorkDayImpl();

		workDay.setNew(true);
		workDay.setPrimaryKey(workDayId);

		return workDay;
	}

	/**
	 * Removes the work day with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param workDayId the primary key of the work day
	 * @return the work day that was removed
	 * @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkDay remove(long workDayId)
		throws NoSuchWorkDayException, SystemException {
		return remove((Serializable)workDayId);
	}

	/**
	 * Removes the work day with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the work day
	 * @return the work day that was removed
	 * @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkDay remove(Serializable primaryKey)
		throws NoSuchWorkDayException, SystemException {
		Session session = null;

		try {
			session = openSession();

			WorkDay workDay = (WorkDay)session.get(WorkDayImpl.class, primaryKey);

			if (workDay == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchWorkDayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(workDay);
		}
		catch (NoSuchWorkDayException nsee) {
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
	protected WorkDay removeImpl(WorkDay workDay) throws SystemException {
		workDay = toUnwrappedModel(workDay);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(workDay)) {
				workDay = (WorkDay)session.get(WorkDayImpl.class,
						workDay.getPrimaryKeyObj());
			}

			if (workDay != null) {
				session.delete(workDay);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (workDay != null) {
			clearCache(workDay);
		}

		return workDay;
	}

	@Override
	public WorkDay updateImpl(
		com.liferay.timetracking.timesheet.model.WorkDay workDay)
		throws SystemException {
		workDay = toUnwrappedModel(workDay);

		boolean isNew = workDay.isNew();

		Session session = null;

		try {
			session = openSession();

			if (workDay.isNew()) {
				session.save(workDay);

				workDay.setNew(false);
			}
			else {
				session.merge(workDay);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		EntityCacheUtil.putResult(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
			WorkDayImpl.class, workDay.getPrimaryKey(), workDay);

		return workDay;
	}

	protected WorkDay toUnwrappedModel(WorkDay workDay) {
		if (workDay instanceof WorkDayImpl) {
			return workDay;
		}

		WorkDayImpl workDayImpl = new WorkDayImpl();

		workDayImpl.setNew(workDay.isNew());
		workDayImpl.setPrimaryKey(workDay.getPrimaryKey());

		workDayImpl.setWorkDayId(workDay.getWorkDayId());
		workDayImpl.setGroupId(workDay.getGroupId());
		workDayImpl.setCompanyId(workDay.getCompanyId());
		workDayImpl.setUserId(workDay.getUserId());
		workDayImpl.setUserName(workDay.getUserName());
		workDayImpl.setCreateDate(workDay.getCreateDate());
		workDayImpl.setModifiedDate(workDay.getModifiedDate());
		workDayImpl.setDayOfYearId(workDay.getDayOfYearId());
		workDayImpl.setStartTime(workDay.getStartTime());
		workDayImpl.setEndTime(workDay.getEndTime());
		workDayImpl.setPause(workDay.getPause());

		return workDayImpl;
	}

	/**
	 * Returns the work day with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the work day
	 * @return the work day
	 * @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkDay findByPrimaryKey(Serializable primaryKey)
		throws NoSuchWorkDayException, SystemException {
		WorkDay workDay = fetchByPrimaryKey(primaryKey);

		if (workDay == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchWorkDayException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return workDay;
	}

	/**
	 * Returns the work day with the primary key or throws a {@link com.liferay.timetracking.timesheet.NoSuchWorkDayException} if it could not be found.
	 *
	 * @param workDayId the primary key of the work day
	 * @return the work day
	 * @throws com.liferay.timetracking.timesheet.NoSuchWorkDayException if a work day with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkDay findByPrimaryKey(long workDayId)
		throws NoSuchWorkDayException, SystemException {
		return findByPrimaryKey((Serializable)workDayId);
	}

	/**
	 * Returns the work day with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the work day
	 * @return the work day, or <code>null</code> if a work day with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkDay fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		WorkDay workDay = (WorkDay)EntityCacheUtil.getResult(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
				WorkDayImpl.class, primaryKey);

		if (workDay == _nullWorkDay) {
			return null;
		}

		if (workDay == null) {
			Session session = null;

			try {
				session = openSession();

				workDay = (WorkDay)session.get(WorkDayImpl.class, primaryKey);

				if (workDay != null) {
					cacheResult(workDay);
				}
				else {
					EntityCacheUtil.putResult(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
						WorkDayImpl.class, primaryKey, _nullWorkDay);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(WorkDayModelImpl.ENTITY_CACHE_ENABLED,
					WorkDayImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return workDay;
	}

	/**
	 * Returns the work day with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param workDayId the primary key of the work day
	 * @return the work day, or <code>null</code> if a work day with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public WorkDay fetchByPrimaryKey(long workDayId) throws SystemException {
		return fetchByPrimaryKey((Serializable)workDayId);
	}

	/**
	 * Returns all the work daies.
	 *
	 * @return the work daies
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<WorkDay> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<WorkDay> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<WorkDay> findAll(int start, int end,
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

		List<WorkDay> list = (List<WorkDay>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_WORKDAY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_WORKDAY;

				if (pagination) {
					sql = sql.concat(WorkDayModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<WorkDay>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<WorkDay>(list);
				}
				else {
					list = (List<WorkDay>)QueryUtil.list(q, getDialect(),
							start, end);
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
	 * Removes all the work daies from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (WorkDay workDay : findAll()) {
			remove(workDay);
		}
	}

	/**
	 * Returns the number of work daies.
	 *
	 * @return the number of work daies
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

				Query q = session.createQuery(_SQL_COUNT_WORKDAY);

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
	 * Initializes the work day persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.timesheet.model.WorkDay")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<WorkDay>> listenersList = new ArrayList<ModelListener<WorkDay>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<WorkDay>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(WorkDayImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_WORKDAY = "SELECT workDay FROM WorkDay workDay";
	private static final String _SQL_COUNT_WORKDAY = "SELECT COUNT(workDay) FROM WorkDay workDay";
	private static final String _ORDER_BY_ENTITY_ALIAS = "workDay.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No WorkDay exists with the primary key ";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(WorkDayPersistenceImpl.class);
	private static WorkDay _nullWorkDay = new WorkDayImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<WorkDay> toCacheModel() {
				return _nullWorkDayCacheModel;
			}
		};

	private static CacheModel<WorkDay> _nullWorkDayCacheModel = new CacheModel<WorkDay>() {
			@Override
			public WorkDay toEntityModel() {
				return _nullWorkDay;
			}
		};
}