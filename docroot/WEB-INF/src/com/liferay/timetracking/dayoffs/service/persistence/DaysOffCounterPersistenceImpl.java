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

import com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException;
import com.liferay.timetracking.dayoffs.model.DaysOffCounter;
import com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterImpl;
import com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the days off counter service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak
 * @see DaysOffCounterPersistence
 * @see DaysOffCounterUtil
 * @generated
 */
public class DaysOffCounterPersistenceImpl extends BasePersistenceImpl<DaysOffCounter>
	implements DaysOffCounterPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DaysOffCounterUtil} to access the days off counter persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DaysOffCounterImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKERUSERID =
		new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByWorkerUserId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKERUSERID =
		new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByWorkerUserId",
			new String[] { Long.class.getName() },
			DaysOffCounterModelImpl.WORKERUSERID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.WORKERUSERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_WORKERUSERID = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByWorkerUserId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the days off counters where workerUserId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @return the matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByWorkerUserId(long workerUserId)
		throws SystemException {
		return findByWorkerUserId(workerUserId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days off counters where workerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workerUserId the worker user ID
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @return the range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByWorkerUserId(long workerUserId,
		int start, int end) throws SystemException {
		return findByWorkerUserId(workerUserId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days off counters where workerUserId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workerUserId the worker user ID
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByWorkerUserId(long workerUserId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKERUSERID;
			finderArgs = new Object[] { workerUserId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_WORKERUSERID;
			finderArgs = new Object[] {
					workerUserId,
					
					start, end, orderByComparator
				};
		}

		List<DaysOffCounter> list = (List<DaysOffCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOffCounter daysOffCounter : list) {
				if ((workerUserId != daysOffCounter.getWorkerUserId())) {
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

			query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_WORKERUSERID_WORKERUSERID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

				if (!pagination) {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOffCounter>(list);
				}
				else {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
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
	 * Returns the first days off counter in the ordered set where workerUserId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByWorkerUserId_First(long workerUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByWorkerUserId_First(workerUserId,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workerUserId=");
		msg.append(workerUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the first days off counter in the ordered set where workerUserId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByWorkerUserId_First(long workerUserId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOffCounter> list = findByWorkerUserId(workerUserId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days off counter in the ordered set where workerUserId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByWorkerUserId_Last(long workerUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByWorkerUserId_Last(workerUserId,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workerUserId=");
		msg.append(workerUserId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the last days off counter in the ordered set where workerUserId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByWorkerUserId_Last(long workerUserId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByWorkerUserId(workerUserId);

		if (count == 0) {
			return null;
		}

		List<DaysOffCounter> list = findByWorkerUserId(workerUserId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days off counters before and after the current days off counter in the ordered set where workerUserId = &#63;.
	 *
	 * @param dayOffCounterId the primary key of the current days off counter
	 * @param workerUserId the worker user ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter[] findByWorkerUserId_PrevAndNext(
		long dayOffCounterId, long workerUserId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = findByPrimaryKey(dayOffCounterId);

		Session session = null;

		try {
			session = openSession();

			DaysOffCounter[] array = new DaysOffCounterImpl[3];

			array[0] = getByWorkerUserId_PrevAndNext(session, daysOffCounter,
					workerUserId, orderByComparator, true);

			array[1] = daysOffCounter;

			array[2] = getByWorkerUserId_PrevAndNext(session, daysOffCounter,
					workerUserId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DaysOffCounter getByWorkerUserId_PrevAndNext(Session session,
		DaysOffCounter daysOffCounter, long workerUserId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

		query.append(_FINDER_COLUMN_WORKERUSERID_WORKERUSERID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(workerUserId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOffCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOffCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days off counters where workerUserId = &#63; from the database.
	 *
	 * @param workerUserId the worker user ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByWorkerUserId(long workerUserId)
		throws SystemException {
		for (DaysOffCounter daysOffCounter : findByWorkerUserId(workerUserId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOffCounter);
		}
	}

	/**
	 * Returns the number of days off counters where workerUserId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @return the number of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByWorkerUserId(long workerUserId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_WORKERUSERID;

		Object[] finderArgs = new Object[] { workerUserId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_WORKERUSERID_WORKERUSERID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

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

	private static final String _FINDER_COLUMN_WORKERUSERID_WORKERUSERID_2 = "daysOffCounter.workerUserId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RULEID = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByRuleId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEID =
		new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleId",
			new String[] { Long.class.getName() },
			DaysOffCounterModelImpl.RULEID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.WORKERUSERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RULEID = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the days off counters where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByRuleId(long ruleId)
		throws SystemException {
		return findByRuleId(ruleId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days off counters where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @return the range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByRuleId(long ruleId, int start, int end)
		throws SystemException {
		return findByRuleId(ruleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days off counters where ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByRuleId(long ruleId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEID;
			finderArgs = new Object[] { ruleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RULEID;
			finderArgs = new Object[] { ruleId, start, end, orderByComparator };
		}

		List<DaysOffCounter> list = (List<DaysOffCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOffCounter daysOffCounter : list) {
				if ((ruleId != daysOffCounter.getRuleId())) {
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

			query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_RULEID_RULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				if (!pagination) {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOffCounter>(list);
				}
				else {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
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
	 * Returns the first days off counter in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByRuleId_First(long ruleId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByRuleId_First(ruleId,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the first days off counter in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByRuleId_First(long ruleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOffCounter> list = findByRuleId(ruleId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days off counter in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByRuleId_Last(long ruleId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByRuleId_Last(ruleId,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the last days off counter in the ordered set where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByRuleId_Last(long ruleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRuleId(ruleId);

		if (count == 0) {
			return null;
		}

		List<DaysOffCounter> list = findByRuleId(ruleId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days off counters before and after the current days off counter in the ordered set where ruleId = &#63;.
	 *
	 * @param dayOffCounterId the primary key of the current days off counter
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter[] findByRuleId_PrevAndNext(long dayOffCounterId,
		long ruleId, OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = findByPrimaryKey(dayOffCounterId);

		Session session = null;

		try {
			session = openSession();

			DaysOffCounter[] array = new DaysOffCounterImpl[3];

			array[0] = getByRuleId_PrevAndNext(session, daysOffCounter, ruleId,
					orderByComparator, true);

			array[1] = daysOffCounter;

			array[2] = getByRuleId_PrevAndNext(session, daysOffCounter, ruleId,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DaysOffCounter getByRuleId_PrevAndNext(Session session,
		DaysOffCounter daysOffCounter, long ruleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

		query.append(_FINDER_COLUMN_RULEID_RULEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOffCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOffCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days off counters where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRuleId(long ruleId) throws SystemException {
		for (DaysOffCounter daysOffCounter : findByRuleId(ruleId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOffCounter);
		}
	}

	/**
	 * Returns the number of days off counters where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRuleId(long ruleId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RULEID;

		Object[] finderArgs = new Object[] { ruleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_RULEID_RULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

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

	private static final String _FINDER_COLUMN_RULEID_RULEID_2 = "daysOffCounter.ruleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByYear",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByYear",
			new String[] { Integer.class.getName() },
			DaysOffCounterModelImpl.YEAR_COLUMN_BITMASK |
			DaysOffCounterModelImpl.WORKERUSERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_YEAR = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByYear",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the days off counters where year = &#63;.
	 *
	 * @param year the year
	 * @return the matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByYear(int year) throws SystemException {
		return findByYear(year, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days off counters where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @return the range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByYear(int year, int start, int end)
		throws SystemException {
		return findByYear(year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days off counters where year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param year the year
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByYear(int year, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_YEAR;
			finderArgs = new Object[] { year, start, end, orderByComparator };
		}

		List<DaysOffCounter> list = (List<DaysOffCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOffCounter daysOffCounter : list) {
				if ((year != daysOffCounter.getYear())) {
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

			query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

				if (!pagination) {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOffCounter>(list);
				}
				else {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
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
	 * Returns the first days off counter in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByYear_First(int year,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByYear_First(year,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the first days off counter in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByYear_First(int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOffCounter> list = findByYear(year, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days off counter in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByYear_Last(int year,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByYear_Last(year, orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the last days off counter in the ordered set where year = &#63;.
	 *
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByYear_Last(int year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByYear(year);

		if (count == 0) {
			return null;
		}

		List<DaysOffCounter> list = findByYear(year, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days off counters before and after the current days off counter in the ordered set where year = &#63;.
	 *
	 * @param dayOffCounterId the primary key of the current days off counter
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter[] findByYear_PrevAndNext(long dayOffCounterId,
		int year, OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = findByPrimaryKey(dayOffCounterId);

		Session session = null;

		try {
			session = openSession();

			DaysOffCounter[] array = new DaysOffCounterImpl[3];

			array[0] = getByYear_PrevAndNext(session, daysOffCounter, year,
					orderByComparator, true);

			array[1] = daysOffCounter;

			array[2] = getByYear_PrevAndNext(session, daysOffCounter, year,
					orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DaysOffCounter getByYear_PrevAndNext(Session session,
		DaysOffCounter daysOffCounter, int year,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

		query.append(_FINDER_COLUMN_YEAR_YEAR_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOffCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOffCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days off counters where year = &#63; from the database.
	 *
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByYear(int year) throws SystemException {
		for (DaysOffCounter daysOffCounter : findByYear(year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOffCounter);
		}
	}

	/**
	 * Returns the number of days off counters where year = &#63;.
	 *
	 * @param year the year
	 * @return the number of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByYear(int year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_YEAR;

		Object[] finderArgs = new Object[] { year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_YEAR_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_YEAR_YEAR_2 = "daysOffCounter.year = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_R_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByR_Y",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByR_Y",
			new String[] { Long.class.getName(), Integer.class.getName() },
			DaysOffCounterModelImpl.RULEID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.YEAR_COLUMN_BITMASK |
			DaysOffCounterModelImpl.WORKERUSERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_R_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByR_Y",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the days off counters where ruleId = &#63; and year = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @return the matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByR_Y(long ruleId, int year)
		throws SystemException {
		return findByR_Y(ruleId, year, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the days off counters where ruleId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @return the range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByR_Y(long ruleId, int year, int start,
		int end) throws SystemException {
		return findByR_Y(ruleId, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days off counters where ruleId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByR_Y(long ruleId, int year, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_Y;
			finderArgs = new Object[] { ruleId, year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_R_Y;
			finderArgs = new Object[] {
					ruleId, year,
					
					start, end, orderByComparator
				};
		}

		List<DaysOffCounter> list = (List<DaysOffCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOffCounter daysOffCounter : list) {
				if ((ruleId != daysOffCounter.getRuleId()) ||
						(year != daysOffCounter.getYear())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_R_Y_RULEID_2);

			query.append(_FINDER_COLUMN_R_Y_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				qPos.add(year);

				if (!pagination) {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOffCounter>(list);
				}
				else {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
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
	 * Returns the first days off counter in the ordered set where ruleId = &#63; and year = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByR_Y_First(long ruleId, int year,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByR_Y_First(ruleId, year,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the first days off counter in the ordered set where ruleId = &#63; and year = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByR_Y_First(long ruleId, int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOffCounter> list = findByR_Y(ruleId, year, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days off counter in the ordered set where ruleId = &#63; and year = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByR_Y_Last(long ruleId, int year,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByR_Y_Last(ruleId, year,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("ruleId=");
		msg.append(ruleId);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the last days off counter in the ordered set where ruleId = &#63; and year = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByR_Y_Last(long ruleId, int year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByR_Y(ruleId, year);

		if (count == 0) {
			return null;
		}

		List<DaysOffCounter> list = findByR_Y(ruleId, year, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days off counters before and after the current days off counter in the ordered set where ruleId = &#63; and year = &#63;.
	 *
	 * @param dayOffCounterId the primary key of the current days off counter
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter[] findByR_Y_PrevAndNext(long dayOffCounterId,
		long ruleId, int year, OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = findByPrimaryKey(dayOffCounterId);

		Session session = null;

		try {
			session = openSession();

			DaysOffCounter[] array = new DaysOffCounterImpl[3];

			array[0] = getByR_Y_PrevAndNext(session, daysOffCounter, ruleId,
					year, orderByComparator, true);

			array[1] = daysOffCounter;

			array[2] = getByR_Y_PrevAndNext(session, daysOffCounter, ruleId,
					year, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DaysOffCounter getByR_Y_PrevAndNext(Session session,
		DaysOffCounter daysOffCounter, long ruleId, int year,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

		query.append(_FINDER_COLUMN_R_Y_RULEID_2);

		query.append(_FINDER_COLUMN_R_Y_YEAR_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(ruleId);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOffCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOffCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days off counters where ruleId = &#63; and year = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByR_Y(long ruleId, int year) throws SystemException {
		for (DaysOffCounter daysOffCounter : findByR_Y(ruleId, year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOffCounter);
		}
	}

	/**
	 * Returns the number of days off counters where ruleId = &#63; and year = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @param year the year
	 * @return the number of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByR_Y(long ruleId, int year) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_R_Y;

		Object[] finderArgs = new Object[] { ruleId, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_R_Y_RULEID_2);

			query.append(_FINDER_COLUMN_R_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_R_Y_RULEID_2 = "daysOffCounter.ruleId = ? AND ";
	private static final String _FINDER_COLUMN_R_Y_YEAR_2 = "daysOffCounter.year = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_W_R = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByW_R",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_R = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByW_R",
			new String[] { Long.class.getName(), Long.class.getName() },
			DaysOffCounterModelImpl.WORKERUSERID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.RULEID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.WORKERUSERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_W_R = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByW_R",
			new String[] { Long.class.getName(), Long.class.getName() });

	/**
	 * Returns all the days off counters where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @return the matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByW_R(long workerUserId, long ruleId)
		throws SystemException {
		return findByW_R(workerUserId, ruleId, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days off counters where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @return the range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByW_R(long workerUserId, long ruleId,
		int start, int end) throws SystemException {
		return findByW_R(workerUserId, ruleId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days off counters where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByW_R(long workerUserId, long ruleId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_R;
			finderArgs = new Object[] { workerUserId, ruleId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_W_R;
			finderArgs = new Object[] {
					workerUserId, ruleId,
					
					start, end, orderByComparator
				};
		}

		List<DaysOffCounter> list = (List<DaysOffCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOffCounter daysOffCounter : list) {
				if ((workerUserId != daysOffCounter.getWorkerUserId()) ||
						(ruleId != daysOffCounter.getRuleId())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_W_R_WORKERUSERID_2);

			query.append(_FINDER_COLUMN_W_R_RULEID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

				qPos.add(ruleId);

				if (!pagination) {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOffCounter>(list);
				}
				else {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
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
	 * Returns the first days off counter in the ordered set where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByW_R_First(long workerUserId, long ruleId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByW_R_First(workerUserId, ruleId,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workerUserId=");
		msg.append(workerUserId);

		msg.append(", ruleId=");
		msg.append(ruleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the first days off counter in the ordered set where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByW_R_First(long workerUserId, long ruleId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOffCounter> list = findByW_R(workerUserId, ruleId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days off counter in the ordered set where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByW_R_Last(long workerUserId, long ruleId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByW_R_Last(workerUserId, ruleId,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workerUserId=");
		msg.append(workerUserId);

		msg.append(", ruleId=");
		msg.append(ruleId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the last days off counter in the ordered set where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByW_R_Last(long workerUserId, long ruleId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByW_R(workerUserId, ruleId);

		if (count == 0) {
			return null;
		}

		List<DaysOffCounter> list = findByW_R(workerUserId, ruleId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days off counters before and after the current days off counter in the ordered set where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * @param dayOffCounterId the primary key of the current days off counter
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter[] findByW_R_PrevAndNext(long dayOffCounterId,
		long workerUserId, long ruleId, OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = findByPrimaryKey(dayOffCounterId);

		Session session = null;

		try {
			session = openSession();

			DaysOffCounter[] array = new DaysOffCounterImpl[3];

			array[0] = getByW_R_PrevAndNext(session, daysOffCounter,
					workerUserId, ruleId, orderByComparator, true);

			array[1] = daysOffCounter;

			array[2] = getByW_R_PrevAndNext(session, daysOffCounter,
					workerUserId, ruleId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DaysOffCounter getByW_R_PrevAndNext(Session session,
		DaysOffCounter daysOffCounter, long workerUserId, long ruleId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

		query.append(_FINDER_COLUMN_W_R_WORKERUSERID_2);

		query.append(_FINDER_COLUMN_W_R_RULEID_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(workerUserId);

		qPos.add(ruleId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOffCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOffCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days off counters where workerUserId = &#63; and ruleId = &#63; from the database.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByW_R(long workerUserId, long ruleId)
		throws SystemException {
		for (DaysOffCounter daysOffCounter : findByW_R(workerUserId, ruleId,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOffCounter);
		}
	}

	/**
	 * Returns the number of days off counters where workerUserId = &#63; and ruleId = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @return the number of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByW_R(long workerUserId, long ruleId)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_W_R;

		Object[] finderArgs = new Object[] { workerUserId, ruleId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_W_R_WORKERUSERID_2);

			query.append(_FINDER_COLUMN_W_R_RULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

				qPos.add(ruleId);

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

	private static final String _FINDER_COLUMN_W_R_WORKERUSERID_2 = "daysOffCounter.workerUserId = ? AND ";
	private static final String _FINDER_COLUMN_W_R_RULEID_2 = "daysOffCounter.ruleId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_W_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_LIST_WITH_PAGINATION,
			"findByW_Y",
			new String[] {
				Long.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByW_Y",
			new String[] { Long.class.getName(), Integer.class.getName() },
			DaysOffCounterModelImpl.WORKERUSERID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.YEAR_COLUMN_BITMASK |
			DaysOffCounterModelImpl.WORKERUSERNAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_W_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByW_Y",
			new String[] { Long.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the days off counters where workerUserId = &#63; and year = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @return the matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByW_Y(long workerUserId, int year)
		throws SystemException {
		return findByW_Y(workerUserId, year, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days off counters where workerUserId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @return the range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByW_Y(long workerUserId, int year,
		int start, int end) throws SystemException {
		return findByW_Y(workerUserId, year, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days off counters where workerUserId = &#63; and year = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findByW_Y(long workerUserId, int year,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_Y;
			finderArgs = new Object[] { workerUserId, year };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_W_Y;
			finderArgs = new Object[] {
					workerUserId, year,
					
					start, end, orderByComparator
				};
		}

		List<DaysOffCounter> list = (List<DaysOffCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOffCounter daysOffCounter : list) {
				if ((workerUserId != daysOffCounter.getWorkerUserId()) ||
						(year != daysOffCounter.getYear())) {
					list = null;

					break;
				}
			}
		}

		if (list == null) {
			StringBundler query = null;

			if (orderByComparator != null) {
				query = new StringBundler(4 +
						(orderByComparator.getOrderByFields().length * 3));
			}
			else {
				query = new StringBundler(4);
			}

			query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_W_Y_WORKERUSERID_2);

			query.append(_FINDER_COLUMN_W_Y_YEAR_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

				qPos.add(year);

				if (!pagination) {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOffCounter>(list);
				}
				else {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
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
	 * Returns the first days off counter in the ordered set where workerUserId = &#63; and year = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByW_Y_First(long workerUserId, int year,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByW_Y_First(workerUserId, year,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workerUserId=");
		msg.append(workerUserId);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the first days off counter in the ordered set where workerUserId = &#63; and year = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByW_Y_First(long workerUserId, int year,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOffCounter> list = findByW_Y(workerUserId, year, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days off counter in the ordered set where workerUserId = &#63; and year = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByW_Y_Last(long workerUserId, int year,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByW_Y_Last(workerUserId, year,
				orderByComparator);

		if (daysOffCounter != null) {
			return daysOffCounter;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("workerUserId=");
		msg.append(workerUserId);

		msg.append(", year=");
		msg.append(year);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOffCounterException(msg.toString());
	}

	/**
	 * Returns the last days off counter in the ordered set where workerUserId = &#63; and year = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByW_Y_Last(long workerUserId, int year,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByW_Y(workerUserId, year);

		if (count == 0) {
			return null;
		}

		List<DaysOffCounter> list = findByW_Y(workerUserId, year, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days off counters before and after the current days off counter in the ordered set where workerUserId = &#63; and year = &#63;.
	 *
	 * @param dayOffCounterId the primary key of the current days off counter
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter[] findByW_Y_PrevAndNext(long dayOffCounterId,
		long workerUserId, int year, OrderByComparator orderByComparator)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = findByPrimaryKey(dayOffCounterId);

		Session session = null;

		try {
			session = openSession();

			DaysOffCounter[] array = new DaysOffCounterImpl[3];

			array[0] = getByW_Y_PrevAndNext(session, daysOffCounter,
					workerUserId, year, orderByComparator, true);

			array[1] = daysOffCounter;

			array[2] = getByW_Y_PrevAndNext(session, daysOffCounter,
					workerUserId, year, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DaysOffCounter getByW_Y_PrevAndNext(Session session,
		DaysOffCounter daysOffCounter, long workerUserId, int year,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

		query.append(_FINDER_COLUMN_W_Y_WORKERUSERID_2);

		query.append(_FINDER_COLUMN_W_Y_YEAR_2);

		if (orderByComparator != null) {
			String[] orderByConditionFields = orderByComparator.getOrderByConditionFields();

			if (orderByConditionFields.length > 0) {
				query.append(WHERE_AND);
			}

			for (int i = 0; i < orderByConditionFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByConditionFields[i]);

				if ((i + 1) < orderByConditionFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN_HAS_NEXT);
					}
					else {
						query.append(WHERE_LESSER_THAN_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(WHERE_GREATER_THAN);
					}
					else {
						query.append(WHERE_LESSER_THAN);
					}
				}
			}

			query.append(ORDER_BY_CLAUSE);

			String[] orderByFields = orderByComparator.getOrderByFields();

			for (int i = 0; i < orderByFields.length; i++) {
				query.append(_ORDER_BY_ENTITY_ALIAS);
				query.append(orderByFields[i]);

				if ((i + 1) < orderByFields.length) {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC_HAS_NEXT);
					}
					else {
						query.append(ORDER_BY_DESC_HAS_NEXT);
					}
				}
				else {
					if (orderByComparator.isAscending() ^ previous) {
						query.append(ORDER_BY_ASC);
					}
					else {
						query.append(ORDER_BY_DESC);
					}
				}
			}
		}
		else {
			query.append(DaysOffCounterModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(workerUserId);

		qPos.add(year);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOffCounter);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOffCounter> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days off counters where workerUserId = &#63; and year = &#63; from the database.
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByW_Y(long workerUserId, int year)
		throws SystemException {
		for (DaysOffCounter daysOffCounter : findByW_Y(workerUserId, year,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOffCounter);
		}
	}

	/**
	 * Returns the number of days off counters where workerUserId = &#63; and year = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param year the year
	 * @return the number of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByW_Y(long workerUserId, int year)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_W_Y;

		Object[] finderArgs = new Object[] { workerUserId, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_W_Y_WORKERUSERID_2);

			query.append(_FINDER_COLUMN_W_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_W_Y_WORKERUSERID_2 = "daysOffCounter.workerUserId = ? AND ";
	private static final String _FINDER_COLUMN_W_Y_YEAR_2 = "daysOffCounter.year = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_W_R_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED,
			DaysOffCounterImpl.class, FINDER_CLASS_NAME_ENTITY, "fetchByW_R_Y",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			},
			DaysOffCounterModelImpl.WORKERUSERID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.RULEID_COLUMN_BITMASK |
			DaysOffCounterModelImpl.YEAR_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_W_R_Y = new FinderPath(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByW_R_Y",
			new String[] {
				Long.class.getName(), Long.class.getName(),
				Integer.class.getName()
			});

	/**
	 * Returns the days off counter where workerUserId = &#63; and ruleId = &#63; and year = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException} if it could not be found.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param year the year
	 * @return the matching days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByW_R_Y(long workerUserId, long ruleId, int year)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByW_R_Y(workerUserId, ruleId, year);

		if (daysOffCounter == null) {
			StringBundler msg = new StringBundler(8);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("workerUserId=");
			msg.append(workerUserId);

			msg.append(", ruleId=");
			msg.append(ruleId);

			msg.append(", year=");
			msg.append(year);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDaysOffCounterException(msg.toString());
		}

		return daysOffCounter;
	}

	/**
	 * Returns the days off counter where workerUserId = &#63; and ruleId = &#63; and year = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param year the year
	 * @return the matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByW_R_Y(long workerUserId, long ruleId, int year)
		throws SystemException {
		return fetchByW_R_Y(workerUserId, ruleId, year, true);
	}

	/**
	 * Returns the days off counter where workerUserId = &#63; and ruleId = &#63; and year = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param year the year
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching days off counter, or <code>null</code> if a matching days off counter could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByW_R_Y(long workerUserId, long ruleId,
		int year, boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { workerUserId, ruleId, year };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_W_R_Y,
					finderArgs, this);
		}

		if (result instanceof DaysOffCounter) {
			DaysOffCounter daysOffCounter = (DaysOffCounter)result;

			if ((workerUserId != daysOffCounter.getWorkerUserId()) ||
					(ruleId != daysOffCounter.getRuleId()) ||
					(year != daysOffCounter.getYear())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(5);

			query.append(_SQL_SELECT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_W_R_Y_WORKERUSERID_2);

			query.append(_FINDER_COLUMN_W_R_Y_RULEID_2);

			query.append(_FINDER_COLUMN_W_R_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

				qPos.add(ruleId);

				qPos.add(year);

				List<DaysOffCounter> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_R_Y,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DaysOffCounterPersistenceImpl.fetchByW_R_Y(long, long, int, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DaysOffCounter daysOffCounter = list.get(0);

					result = daysOffCounter;

					cacheResult(daysOffCounter);

					if ((daysOffCounter.getWorkerUserId() != workerUserId) ||
							(daysOffCounter.getRuleId() != ruleId) ||
							(daysOffCounter.getYear() != year)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_R_Y,
							finderArgs, daysOffCounter);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_W_R_Y,
					finderArgs);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		if (result instanceof List<?>) {
			return null;
		}
		else {
			return (DaysOffCounter)result;
		}
	}

	/**
	 * Removes the days off counter where workerUserId = &#63; and ruleId = &#63; and year = &#63; from the database.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param year the year
	 * @return the days off counter that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter removeByW_R_Y(long workerUserId, long ruleId, int year)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = findByW_R_Y(workerUserId, ruleId, year);

		return remove(daysOffCounter);
	}

	/**
	 * Returns the number of days off counters where workerUserId = &#63; and ruleId = &#63; and year = &#63;.
	 *
	 * @param workerUserId the worker user ID
	 * @param ruleId the rule ID
	 * @param year the year
	 * @return the number of matching days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByW_R_Y(long workerUserId, long ruleId, int year)
		throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_W_R_Y;

		Object[] finderArgs = new Object[] { workerUserId, ruleId, year };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_COUNT_DAYSOFFCOUNTER_WHERE);

			query.append(_FINDER_COLUMN_W_R_Y_WORKERUSERID_2);

			query.append(_FINDER_COLUMN_W_R_Y_RULEID_2);

			query.append(_FINDER_COLUMN_W_R_Y_YEAR_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(workerUserId);

				qPos.add(ruleId);

				qPos.add(year);

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

	private static final String _FINDER_COLUMN_W_R_Y_WORKERUSERID_2 = "daysOffCounter.workerUserId = ? AND ";
	private static final String _FINDER_COLUMN_W_R_Y_RULEID_2 = "daysOffCounter.ruleId = ? AND ";
	private static final String _FINDER_COLUMN_W_R_Y_YEAR_2 = "daysOffCounter.year = ?";

	public DaysOffCounterPersistenceImpl() {
		setModelClass(DaysOffCounter.class);
	}

	/**
	 * Caches the days off counter in the entity cache if it is enabled.
	 *
	 * @param daysOffCounter the days off counter
	 */
	@Override
	public void cacheResult(DaysOffCounter daysOffCounter) {
		EntityCacheUtil.putResult(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterImpl.class, daysOffCounter.getPrimaryKey(),
			daysOffCounter);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_R_Y,
			new Object[] {
				daysOffCounter.getWorkerUserId(), daysOffCounter.getRuleId(),
				daysOffCounter.getYear()
			}, daysOffCounter);

		daysOffCounter.resetOriginalValues();
	}

	/**
	 * Caches the days off counters in the entity cache if it is enabled.
	 *
	 * @param daysOffCounters the days off counters
	 */
	@Override
	public void cacheResult(List<DaysOffCounter> daysOffCounters) {
		for (DaysOffCounter daysOffCounter : daysOffCounters) {
			if (EntityCacheUtil.getResult(
						DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
						DaysOffCounterImpl.class, daysOffCounter.getPrimaryKey()) == null) {
				cacheResult(daysOffCounter);
			}
			else {
				daysOffCounter.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all days off counters.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DaysOffCounterImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DaysOffCounterImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the days off counter.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DaysOffCounter daysOffCounter) {
		EntityCacheUtil.removeResult(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterImpl.class, daysOffCounter.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(daysOffCounter);
	}

	@Override
	public void clearCache(List<DaysOffCounter> daysOffCounters) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DaysOffCounter daysOffCounter : daysOffCounters) {
			EntityCacheUtil.removeResult(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
				DaysOffCounterImpl.class, daysOffCounter.getPrimaryKey());

			clearUniqueFindersCache(daysOffCounter);
		}
	}

	protected void cacheUniqueFindersCache(DaysOffCounter daysOffCounter) {
		if (daysOffCounter.isNew()) {
			Object[] args = new Object[] {
					daysOffCounter.getWorkerUserId(), daysOffCounter.getRuleId(),
					daysOffCounter.getYear()
				};

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_W_R_Y, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_R_Y, args,
				daysOffCounter);
		}
		else {
			DaysOffCounterModelImpl daysOffCounterModelImpl = (DaysOffCounterModelImpl)daysOffCounter;

			if ((daysOffCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_W_R_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOffCounter.getWorkerUserId(),
						daysOffCounter.getRuleId(), daysOffCounter.getYear()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_W_R_Y, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_W_R_Y, args,
					daysOffCounter);
			}
		}
	}

	protected void clearUniqueFindersCache(DaysOffCounter daysOffCounter) {
		DaysOffCounterModelImpl daysOffCounterModelImpl = (DaysOffCounterModelImpl)daysOffCounter;

		Object[] args = new Object[] {
				daysOffCounter.getWorkerUserId(), daysOffCounter.getRuleId(),
				daysOffCounter.getYear()
			};

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_W_R_Y, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_W_R_Y, args);

		if ((daysOffCounterModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_W_R_Y.getColumnBitmask()) != 0) {
			args = new Object[] {
					daysOffCounterModelImpl.getOriginalWorkerUserId(),
					daysOffCounterModelImpl.getOriginalRuleId(),
					daysOffCounterModelImpl.getOriginalYear()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_W_R_Y, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_W_R_Y, args);
		}
	}

	/**
	 * Creates a new days off counter with the primary key. Does not add the days off counter to the database.
	 *
	 * @param dayOffCounterId the primary key for the new days off counter
	 * @return the new days off counter
	 */
	@Override
	public DaysOffCounter create(long dayOffCounterId) {
		DaysOffCounter daysOffCounter = new DaysOffCounterImpl();

		daysOffCounter.setNew(true);
		daysOffCounter.setPrimaryKey(dayOffCounterId);

		return daysOffCounter;
	}

	/**
	 * Removes the days off counter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dayOffCounterId the primary key of the days off counter
	 * @return the days off counter that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter remove(long dayOffCounterId)
		throws NoSuchDaysOffCounterException, SystemException {
		return remove((Serializable)dayOffCounterId);
	}

	/**
	 * Removes the days off counter with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the days off counter
	 * @return the days off counter that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter remove(Serializable primaryKey)
		throws NoSuchDaysOffCounterException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DaysOffCounter daysOffCounter = (DaysOffCounter)session.get(DaysOffCounterImpl.class,
					primaryKey);

			if (daysOffCounter == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDaysOffCounterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(daysOffCounter);
		}
		catch (NoSuchDaysOffCounterException nsee) {
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
	protected DaysOffCounter removeImpl(DaysOffCounter daysOffCounter)
		throws SystemException {
		daysOffCounter = toUnwrappedModel(daysOffCounter);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(daysOffCounter)) {
				daysOffCounter = (DaysOffCounter)session.get(DaysOffCounterImpl.class,
						daysOffCounter.getPrimaryKeyObj());
			}

			if (daysOffCounter != null) {
				session.delete(daysOffCounter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (daysOffCounter != null) {
			clearCache(daysOffCounter);
		}

		return daysOffCounter;
	}

	@Override
	public DaysOffCounter updateImpl(
		com.liferay.timetracking.dayoffs.model.DaysOffCounter daysOffCounter)
		throws SystemException {
		daysOffCounter = toUnwrappedModel(daysOffCounter);

		boolean isNew = daysOffCounter.isNew();

		DaysOffCounterModelImpl daysOffCounterModelImpl = (DaysOffCounterModelImpl)daysOffCounter;

		Session session = null;

		try {
			session = openSession();

			if (daysOffCounter.isNew()) {
				session.save(daysOffCounter);

				daysOffCounter.setNew(false);
			}
			else {
				session.merge(daysOffCounter);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DaysOffCounterModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((daysOffCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKERUSERID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOffCounterModelImpl.getOriginalWorkerUserId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKERUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKERUSERID,
					args);

				args = new Object[] { daysOffCounterModelImpl.getWorkerUserId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_WORKERUSERID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_WORKERUSERID,
					args);
			}

			if ((daysOffCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOffCounterModelImpl.getOriginalRuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEID,
					args);

				args = new Object[] { daysOffCounterModelImpl.getRuleId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULEID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULEID,
					args);
			}

			if ((daysOffCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOffCounterModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);

				args = new Object[] { daysOffCounterModelImpl.getYear() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_YEAR, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_YEAR,
					args);
			}

			if ((daysOffCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOffCounterModelImpl.getOriginalRuleId(),
						daysOffCounterModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_Y,
					args);

				args = new Object[] {
						daysOffCounterModelImpl.getRuleId(),
						daysOffCounterModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_R_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_R_Y,
					args);
			}

			if ((daysOffCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_R.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOffCounterModelImpl.getOriginalWorkerUserId(),
						daysOffCounterModelImpl.getOriginalRuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_W_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_R,
					args);

				args = new Object[] {
						daysOffCounterModelImpl.getWorkerUserId(),
						daysOffCounterModelImpl.getRuleId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_W_R, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_R,
					args);
			}

			if ((daysOffCounterModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_Y.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOffCounterModelImpl.getOriginalWorkerUserId(),
						daysOffCounterModelImpl.getOriginalYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_W_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_Y,
					args);

				args = new Object[] {
						daysOffCounterModelImpl.getWorkerUserId(),
						daysOffCounterModelImpl.getYear()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_W_Y, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_W_Y,
					args);
			}
		}

		EntityCacheUtil.putResult(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
			DaysOffCounterImpl.class, daysOffCounter.getPrimaryKey(),
			daysOffCounter);

		clearUniqueFindersCache(daysOffCounter);
		cacheUniqueFindersCache(daysOffCounter);

		return daysOffCounter;
	}

	protected DaysOffCounter toUnwrappedModel(DaysOffCounter daysOffCounter) {
		if (daysOffCounter instanceof DaysOffCounterImpl) {
			return daysOffCounter;
		}

		DaysOffCounterImpl daysOffCounterImpl = new DaysOffCounterImpl();

		daysOffCounterImpl.setNew(daysOffCounter.isNew());
		daysOffCounterImpl.setPrimaryKey(daysOffCounter.getPrimaryKey());

		daysOffCounterImpl.setDayOffCounterId(daysOffCounter.getDayOffCounterId());
		daysOffCounterImpl.setCompanyId(daysOffCounter.getCompanyId());
		daysOffCounterImpl.setUserId(daysOffCounter.getUserId());
		daysOffCounterImpl.setUserName(daysOffCounter.getUserName());
		daysOffCounterImpl.setCreateDate(daysOffCounter.getCreateDate());
		daysOffCounterImpl.setModifiedDate(daysOffCounter.getModifiedDate());
		daysOffCounterImpl.setWorkerUserId(daysOffCounter.getWorkerUserId());
		daysOffCounterImpl.setWorkerUserName(daysOffCounter.getWorkerUserName());
		daysOffCounterImpl.setRuleId(daysOffCounter.getRuleId());
		daysOffCounterImpl.setYear(daysOffCounter.getYear());
		daysOffCounterImpl.setAllDays(daysOffCounter.getAllDays());
		daysOffCounterImpl.setRemainingDays(daysOffCounter.getRemainingDays());

		return daysOffCounterImpl;
	}

	/**
	 * Returns the days off counter with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the days off counter
	 * @return the days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDaysOffCounterException, SystemException {
		DaysOffCounter daysOffCounter = fetchByPrimaryKey(primaryKey);

		if (daysOffCounter == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDaysOffCounterException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return daysOffCounter;
	}

	/**
	 * Returns the days off counter with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException} if it could not be found.
	 *
	 * @param dayOffCounterId the primary key of the days off counter
	 * @return the days off counter
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOffCounterException if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter findByPrimaryKey(long dayOffCounterId)
		throws NoSuchDaysOffCounterException, SystemException {
		return findByPrimaryKey((Serializable)dayOffCounterId);
	}

	/**
	 * Returns the days off counter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the days off counter
	 * @return the days off counter, or <code>null</code> if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DaysOffCounter daysOffCounter = (DaysOffCounter)EntityCacheUtil.getResult(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
				DaysOffCounterImpl.class, primaryKey);

		if (daysOffCounter == _nullDaysOffCounter) {
			return null;
		}

		if (daysOffCounter == null) {
			Session session = null;

			try {
				session = openSession();

				daysOffCounter = (DaysOffCounter)session.get(DaysOffCounterImpl.class,
						primaryKey);

				if (daysOffCounter != null) {
					cacheResult(daysOffCounter);
				}
				else {
					EntityCacheUtil.putResult(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
						DaysOffCounterImpl.class, primaryKey,
						_nullDaysOffCounter);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DaysOffCounterModelImpl.ENTITY_CACHE_ENABLED,
					DaysOffCounterImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return daysOffCounter;
	}

	/**
	 * Returns the days off counter with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dayOffCounterId the primary key of the days off counter
	 * @return the days off counter, or <code>null</code> if a days off counter with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOffCounter fetchByPrimaryKey(long dayOffCounterId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dayOffCounterId);
	}

	/**
	 * Returns all the days off counters.
	 *
	 * @return the days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days off counters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @return the range of days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the days off counters.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOffCounterModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of days off counters
	 * @param end the upper bound of the range of days off counters (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of days off counters
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOffCounter> findAll(int start, int end,
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

		List<DaysOffCounter> list = (List<DaysOffCounter>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DAYSOFFCOUNTER);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DAYSOFFCOUNTER;

				if (pagination) {
					sql = sql.concat(DaysOffCounterModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOffCounter>(list);
				}
				else {
					list = (List<DaysOffCounter>)QueryUtil.list(q,
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
	 * Removes all the days off counters from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DaysOffCounter daysOffCounter : findAll()) {
			remove(daysOffCounter);
		}
	}

	/**
	 * Returns the number of days off counters.
	 *
	 * @return the number of days off counters
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

				Query q = session.createQuery(_SQL_COUNT_DAYSOFFCOUNTER);

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
	 * Initializes the days off counter persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.dayoffs.model.DaysOffCounter")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DaysOffCounter>> listenersList = new ArrayList<ModelListener<DaysOffCounter>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DaysOffCounter>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DaysOffCounterImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DAYSOFFCOUNTER = "SELECT daysOffCounter FROM DaysOffCounter daysOffCounter";
	private static final String _SQL_SELECT_DAYSOFFCOUNTER_WHERE = "SELECT daysOffCounter FROM DaysOffCounter daysOffCounter WHERE ";
	private static final String _SQL_COUNT_DAYSOFFCOUNTER = "SELECT COUNT(daysOffCounter) FROM DaysOffCounter daysOffCounter";
	private static final String _SQL_COUNT_DAYSOFFCOUNTER_WHERE = "SELECT COUNT(daysOffCounter) FROM DaysOffCounter daysOffCounter WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "daysOffCounter.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DaysOffCounter exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DaysOffCounter exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DaysOffCounterPersistenceImpl.class);
	private static DaysOffCounter _nullDaysOffCounter = new DaysOffCounterImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DaysOffCounter> toCacheModel() {
				return _nullDaysOffCounterCacheModel;
			}
		};

	private static CacheModel<DaysOffCounter> _nullDaysOffCounterCacheModel = new CacheModel<DaysOffCounter>() {
			@Override
			public DaysOffCounter toEntityModel() {
				return _nullDaysOffCounter;
			}
		};
}