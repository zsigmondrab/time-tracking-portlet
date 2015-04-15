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
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.InstanceFactory;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.PropsKeys;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.UnmodifiableList;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException;
import com.liferay.timetracking.dayoffs.model.DaysOfYear;
import com.liferay.timetracking.dayoffs.model.impl.DaysOfYearImpl;
import com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

/**
 * The persistence implementation for the days of year service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see DaysOfYearPersistence
 * @see DaysOfYearUtil
 * @generated
 */
public class DaysOfYearPersistenceImpl extends BasePersistenceImpl<DaysOfYear>
	implements DaysOfYearPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link DaysOfYearUtil} to access the days of year persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = DaysOfYearImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_DAYSOFYEARID = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByDaysOfYearId",
			new String[] { Long.class.getName() },
			DaysOfYearModelImpl.DAYOFYEARID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DAYSOFYEARID = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDaysOfYearId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the days of year where dayOfYearId = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	 *
	 * @param dayOfYearId the day of year ID
	 * @return the matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByDaysOfYearId(long dayOfYearId)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByDaysOfYearId(dayOfYearId);

		if (daysOfYear == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dayOfYearId=");
			msg.append(dayOfYearId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDaysOfYearException(msg.toString());
		}

		return daysOfYear;
	}

	/**
	 * Returns the days of year where dayOfYearId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dayOfYearId the day of year ID
	 * @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByDaysOfYearId(long dayOfYearId)
		throws SystemException {
		return fetchByDaysOfYearId(dayOfYearId, true);
	}

	/**
	 * Returns the days of year where dayOfYearId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dayOfYearId the day of year ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByDaysOfYearId(long dayOfYearId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dayOfYearId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID,
					finderArgs, this);
		}

		if (result instanceof DaysOfYear) {
			DaysOfYear daysOfYear = (DaysOfYear)result;

			if ((dayOfYearId != daysOfYear.getDayOfYearId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

			query.append(_FINDER_COLUMN_DAYSOFYEARID_DAYOFYEARID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayOfYearId);

				List<DaysOfYear> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DaysOfYearPersistenceImpl.fetchByDaysOfYearId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DaysOfYear daysOfYear = list.get(0);

					result = daysOfYear;

					cacheResult(daysOfYear);

					if ((daysOfYear.getDayOfYearId() != dayOfYearId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID,
							finderArgs, daysOfYear);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID,
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
			return (DaysOfYear)result;
		}
	}

	/**
	 * Removes the days of year where dayOfYearId = &#63; from the database.
	 *
	 * @param dayOfYearId the day of year ID
	 * @return the days of year that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear removeByDaysOfYearId(long dayOfYearId)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = findByDaysOfYearId(dayOfYearId);

		return remove(daysOfYear);
	}

	/**
	 * Returns the number of days of years where dayOfYearId = &#63;.
	 *
	 * @param dayOfYearId the day of year ID
	 * @return the number of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDaysOfYearId(long dayOfYearId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DAYSOFYEARID;

		Object[] finderArgs = new Object[] { dayOfYearId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYSOFYEAR_WHERE);

			query.append(_FINDER_COLUMN_DAYSOFYEARID_DAYOFYEARID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(dayOfYearId);

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

	private static final String _FINDER_COLUMN_DAYSOFYEARID_DAYOFYEARID_2 = "daysOfYear.dayOfYearId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEDAY = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByDateDay",
			new String[] {
				Date.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEDAY =
		new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByDateDay",
			new String[] { Date.class.getName() },
			DaysOfYearModelImpl.DAYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_DATEDAY = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByDateDay",
			new String[] { Date.class.getName() });

	/**
	 * Returns all the days of years where dayId = &#63;.
	 *
	 * @param dayId the day ID
	 * @return the matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByDateDay(Date dayId) throws SystemException {
		return findByDateDay(dayId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DaysOfYear> findByDateDay(Date dayId, int start, int end)
		throws SystemException {
		return findByDateDay(dayId, start, end, null);
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
	@Override
	public List<DaysOfYear> findByDateDay(Date dayId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEDAY;
			finderArgs = new Object[] { dayId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_DATEDAY;
			finderArgs = new Object[] { dayId, start, end, orderByComparator };
		}

		List<DaysOfYear> list = (List<DaysOfYear>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOfYear daysOfYear : list) {
				if (!Validator.equals(dayId, daysOfYear.getDayId())) {
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

			query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

			boolean bindDayId = false;

			if (dayId == null) {
				query.append(_FINDER_COLUMN_DATEDAY_DAYID_1);
			}
			else {
				bindDayId = true;

				query.append(_FINDER_COLUMN_DATEDAY_DAYID_2);
			}

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDayId) {
					qPos.add(CalendarUtil.getTimestamp(dayId));
				}

				if (!pagination) {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOfYear>(list);
				}
				else {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first days of year in the ordered set where dayId = &#63;.
	 *
	 * @param dayId the day ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByDateDay_First(Date dayId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByDateDay_First(dayId, orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dayId=");
		msg.append(dayId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the first days of year in the ordered set where dayId = &#63;.
	 *
	 * @param dayId the day ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByDateDay_First(Date dayId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOfYear> list = findByDateDay(dayId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DaysOfYear findByDateDay_Last(Date dayId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByDateDay_Last(dayId, orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dayId=");
		msg.append(dayId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the last days of year in the ordered set where dayId = &#63;.
	 *
	 * @param dayId the day ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByDateDay_Last(Date dayId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByDateDay(dayId);

		if (count == 0) {
			return null;
		}

		List<DaysOfYear> list = findByDateDay(dayId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
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
	@Override
	public DaysOfYear[] findByDateDay_PrevAndNext(long dayOfYearId, Date dayId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = findByPrimaryKey(dayOfYearId);

		Session session = null;

		try {
			session = openSession();

			DaysOfYear[] array = new DaysOfYearImpl[3];

			array[0] = getByDateDay_PrevAndNext(session, daysOfYear, dayId,
					orderByComparator, true);

			array[1] = daysOfYear;

			array[2] = getByDateDay_PrevAndNext(session, daysOfYear, dayId,
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

	protected DaysOfYear getByDateDay_PrevAndNext(Session session,
		DaysOfYear daysOfYear, Date dayId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

		boolean bindDayId = false;

		if (dayId == null) {
			query.append(_FINDER_COLUMN_DATEDAY_DAYID_1);
		}
		else {
			bindDayId = true;

			query.append(_FINDER_COLUMN_DATEDAY_DAYID_2);
		}

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
			query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDayId) {
			qPos.add(CalendarUtil.getTimestamp(dayId));
		}

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOfYear);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOfYear> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days of years where dayId = &#63; from the database.
	 *
	 * @param dayId the day ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByDateDay(Date dayId) throws SystemException {
		for (DaysOfYear daysOfYear : findByDateDay(dayId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(daysOfYear);
		}
	}

	/**
	 * Returns the number of days of years where dayId = &#63;.
	 *
	 * @param dayId the day ID
	 * @return the number of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByDateDay(Date dayId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_DATEDAY;

		Object[] finderArgs = new Object[] { dayId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYSOFYEAR_WHERE);

			boolean bindDayId = false;

			if (dayId == null) {
				query.append(_FINDER_COLUMN_DATEDAY_DAYID_1);
			}
			else {
				bindDayId = true;

				query.append(_FINDER_COLUMN_DATEDAY_DAYID_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDayId) {
					qPos.add(CalendarUtil.getTimestamp(dayId));
				}

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

	private static final String _FINDER_COLUMN_DATEDAY_DAYID_1 = "daysOfYear.dayId IS NULL";
	private static final String _FINDER_COLUMN_DATEDAY_DAYID_2 = "daysOfYear.dayId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNIT = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnit",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnit",
			new String[] { Long.class.getName() },
			DaysOfYearModelImpl.UNITID_COLUMN_BITMASK |
			DaysOfYearModelImpl.DAYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNIT = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnit",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the days of years where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByUnit(long unitId) throws SystemException {
		return findByUnit(unitId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days of years where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of days of years
	 * @param end the upper bound of the range of days of years (not inclusive)
	 * @return the range of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByUnit(long unitId, int start, int end)
		throws SystemException {
		return findByUnit(unitId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days of years where unitId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitId the unit ID
	 * @param start the lower bound of the range of days of years
	 * @param end the upper bound of the range of days of years (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByUnit(long unitId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT;
			finderArgs = new Object[] { unitId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNIT;
			finderArgs = new Object[] { unitId, start, end, orderByComparator };
		}

		List<DaysOfYear> list = (List<DaysOfYear>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOfYear daysOfYear : list) {
				if ((unitId != daysOfYear.getUnitId())) {
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

			query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

			query.append(_FINDER_COLUMN_UNIT_UNITID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

				if (!pagination) {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOfYear>(list);
				}
				else {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first days of year in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByUnit_First(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByUnit_First(unitId, orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the first days of year in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByUnit_First(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOfYear> list = findByUnit(unitId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days of year in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByUnit_Last(long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByUnit_Last(unitId, orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitId=");
		msg.append(unitId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the last days of year in the ordered set where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByUnit_Last(long unitId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUnit(unitId);

		if (count == 0) {
			return null;
		}

		List<DaysOfYear> list = findByUnit(unitId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days of years before and after the current days of year in the ordered set where unitId = &#63;.
	 *
	 * @param dayOfYearId the primary key of the current days of year
	 * @param unitId the unit ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear[] findByUnit_PrevAndNext(long dayOfYearId, long unitId,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = findByPrimaryKey(dayOfYearId);

		Session session = null;

		try {
			session = openSession();

			DaysOfYear[] array = new DaysOfYearImpl[3];

			array[0] = getByUnit_PrevAndNext(session, daysOfYear, unitId,
					orderByComparator, true);

			array[1] = daysOfYear;

			array[2] = getByUnit_PrevAndNext(session, daysOfYear, unitId,
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

	protected DaysOfYear getByUnit_PrevAndNext(Session session,
		DaysOfYear daysOfYear, long unitId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

		query.append(_FINDER_COLUMN_UNIT_UNITID_2);

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
			query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOfYear);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOfYear> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days of years where unitId = &#63; from the database.
	 *
	 * @param unitId the unit ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnit(long unitId) throws SystemException {
		for (DaysOfYear daysOfYear : findByUnit(unitId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(daysOfYear);
		}
	}

	/**
	 * Returns the number of days of years where unitId = &#63;.
	 *
	 * @param unitId the unit ID
	 * @return the number of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUnit(long unitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UNIT;

		Object[] finderArgs = new Object[] { unitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYSOFYEAR_WHERE);

			query.append(_FINDER_COLUMN_UNIT_UNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitId);

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

	private static final String _FINDER_COLUMN_UNIT_UNITID_2 = "daysOfYear.unitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITTYPE = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByUnitType",
			new String[] {
				Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITTYPE =
		new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByUnitType",
			new String[] { Integer.class.getName() },
			DaysOfYearModelImpl.UNITTYPE_COLUMN_BITMASK |
			DaysOfYearModelImpl.DAYID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_UNITTYPE = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByUnitType",
			new String[] { Integer.class.getName() });

	/**
	 * Returns all the days of years where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByUnitType(int unitType)
		throws SystemException {
		return findByUnitType(unitType, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the days of years where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of days of years
	 * @param end the upper bound of the range of days of years (not inclusive)
	 * @return the range of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByUnitType(int unitType, int start, int end)
		throws SystemException {
		return findByUnitType(unitType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days of years where unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param unitType the unit type
	 * @param start the lower bound of the range of days of years
	 * @param end the upper bound of the range of days of years (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByUnitType(int unitType, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITTYPE;
			finderArgs = new Object[] { unitType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_UNITTYPE;
			finderArgs = new Object[] { unitType, start, end, orderByComparator };
		}

		List<DaysOfYear> list = (List<DaysOfYear>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOfYear daysOfYear : list) {
				if ((unitType != daysOfYear.getUnitType())) {
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

			query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

			query.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitType);

				if (!pagination) {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOfYear>(list);
				}
				else {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first days of year in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByUnitType_First(int unitType,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByUnitType_First(unitType,
				orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitType=");
		msg.append(unitType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the first days of year in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByUnitType_First(int unitType,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOfYear> list = findByUnitType(unitType, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days of year in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByUnitType_Last(int unitType,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByUnitType_Last(unitType, orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("unitType=");
		msg.append(unitType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the last days of year in the ordered set where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByUnitType_Last(int unitType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByUnitType(unitType);

		if (count == 0) {
			return null;
		}

		List<DaysOfYear> list = findByUnitType(unitType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days of years before and after the current days of year in the ordered set where unitType = &#63;.
	 *
	 * @param dayOfYearId the primary key of the current days of year
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear[] findByUnitType_PrevAndNext(long dayOfYearId,
		int unitType, OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = findByPrimaryKey(dayOfYearId);

		Session session = null;

		try {
			session = openSession();

			DaysOfYear[] array = new DaysOfYearImpl[3];

			array[0] = getByUnitType_PrevAndNext(session, daysOfYear, unitType,
					orderByComparator, true);

			array[1] = daysOfYear;

			array[2] = getByUnitType_PrevAndNext(session, daysOfYear, unitType,
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

	protected DaysOfYear getByUnitType_PrevAndNext(Session session,
		DaysOfYear daysOfYear, int unitType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

		query.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_2);

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
			query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(unitType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOfYear);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOfYear> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days of years where unitType = &#63; from the database.
	 *
	 * @param unitType the unit type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByUnitType(int unitType) throws SystemException {
		for (DaysOfYear daysOfYear : findByUnitType(unitType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOfYear);
		}
	}

	/**
	 * Returns the number of days of years where unitType = &#63;.
	 *
	 * @param unitType the unit type
	 * @return the number of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByUnitType(int unitType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_UNITTYPE;

		Object[] finderArgs = new Object[] { unitType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_DAYSOFYEAR_WHERE);

			query.append(_FINDER_COLUMN_UNITTYPE_UNITTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(unitType);

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

	private static final String _FINDER_COLUMN_UNITTYPE_UNITTYPE_2 = "daysOfYear.unitType = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_D_U = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByD_U",
			new String[] { Date.class.getName(), Long.class.getName() },
			DaysOfYearModelImpl.DAYID_COLUMN_BITMASK |
			DaysOfYearModelImpl.UNITID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_U = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_U",
			new String[] { Date.class.getName(), Long.class.getName() });

	/**
	 * Returns the days of year where dayId = &#63; and unitId = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	 *
	 * @param dayId the day ID
	 * @param unitId the unit ID
	 * @return the matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByD_U(Date dayId, long unitId)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByD_U(dayId, unitId);

		if (daysOfYear == null) {
			StringBundler msg = new StringBundler(6);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("dayId=");
			msg.append(dayId);

			msg.append(", unitId=");
			msg.append(unitId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchDaysOfYearException(msg.toString());
		}

		return daysOfYear;
	}

	/**
	 * Returns the days of year where dayId = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param dayId the day ID
	 * @param unitId the unit ID
	 * @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByD_U(Date dayId, long unitId)
		throws SystemException {
		return fetchByD_U(dayId, unitId, true);
	}

	/**
	 * Returns the days of year where dayId = &#63; and unitId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param dayId the day ID
	 * @param unitId the unit ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByD_U(Date dayId, long unitId,
		boolean retrieveFromCache) throws SystemException {
		Object[] finderArgs = new Object[] { dayId, unitId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_D_U,
					finderArgs, this);
		}

		if (result instanceof DaysOfYear) {
			DaysOfYear daysOfYear = (DaysOfYear)result;

			if (!Validator.equals(dayId, daysOfYear.getDayId()) ||
					(unitId != daysOfYear.getUnitId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(4);

			query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

			boolean bindDayId = false;

			if (dayId == null) {
				query.append(_FINDER_COLUMN_D_U_DAYID_1);
			}
			else {
				bindDayId = true;

				query.append(_FINDER_COLUMN_D_U_DAYID_2);
			}

			query.append(_FINDER_COLUMN_D_U_UNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDayId) {
					qPos.add(CalendarUtil.getTimestamp(dayId));
				}

				qPos.add(unitId);

				List<DaysOfYear> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_U,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"DaysOfYearPersistenceImpl.fetchByD_U(Date, long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					DaysOfYear daysOfYear = list.get(0);

					result = daysOfYear;

					cacheResult(daysOfYear);

					if ((daysOfYear.getDayId() == null) ||
							!daysOfYear.getDayId().equals(dayId) ||
							(daysOfYear.getUnitId() != unitId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_U,
							finderArgs, daysOfYear);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_U,
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
			return (DaysOfYear)result;
		}
	}

	/**
	 * Removes the days of year where dayId = &#63; and unitId = &#63; from the database.
	 *
	 * @param dayId the day ID
	 * @param unitId the unit ID
	 * @return the days of year that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear removeByD_U(Date dayId, long unitId)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = findByD_U(dayId, unitId);

		return remove(daysOfYear);
	}

	/**
	 * Returns the number of days of years where dayId = &#63; and unitId = &#63;.
	 *
	 * @param dayId the day ID
	 * @param unitId the unit ID
	 * @return the number of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByD_U(Date dayId, long unitId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_U;

		Object[] finderArgs = new Object[] { dayId, unitId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DAYSOFYEAR_WHERE);

			boolean bindDayId = false;

			if (dayId == null) {
				query.append(_FINDER_COLUMN_D_U_DAYID_1);
			}
			else {
				bindDayId = true;

				query.append(_FINDER_COLUMN_D_U_DAYID_2);
			}

			query.append(_FINDER_COLUMN_D_U_UNITID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDayId) {
					qPos.add(CalendarUtil.getTimestamp(dayId));
				}

				qPos.add(unitId);

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

	private static final String _FINDER_COLUMN_D_U_DAYID_1 = "daysOfYear.dayId IS NULL AND ";
	private static final String _FINDER_COLUMN_D_U_DAYID_2 = "daysOfYear.dayId = ? AND ";
	private static final String _FINDER_COLUMN_D_U_UNITID_2 = "daysOfYear.unitId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_D_UT = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByD_UT",
			new String[] {
				Date.class.getName(), Integer.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_UT = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, DaysOfYearImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByD_UT",
			new String[] { Date.class.getName(), Integer.class.getName() },
			DaysOfYearModelImpl.DAYID_COLUMN_BITMASK |
			DaysOfYearModelImpl.UNITTYPE_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_D_UT = new FinderPath(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByD_UT",
			new String[] { Date.class.getName(), Integer.class.getName() });

	/**
	 * Returns all the days of years where dayId = &#63; and unitType = &#63;.
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @return the matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByD_UT(Date dayId, int unitType)
		throws SystemException {
		return findByD_UT(dayId, unitType, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the days of years where dayId = &#63; and unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @param start the lower bound of the range of days of years
	 * @param end the upper bound of the range of days of years (not inclusive)
	 * @return the range of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByD_UT(Date dayId, int unitType, int start,
		int end) throws SystemException {
		return findByD_UT(dayId, unitType, start, end, null);
	}

	/**
	 * Returns an ordered range of all the days of years where dayId = &#63; and unitType = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.DaysOfYearModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @param start the lower bound of the range of days of years
	 * @param end the upper bound of the range of days of years (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findByD_UT(Date dayId, int unitType, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_UT;
			finderArgs = new Object[] { dayId, unitType };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_D_UT;
			finderArgs = new Object[] {
					dayId, unitType,
					
					start, end, orderByComparator
				};
		}

		List<DaysOfYear> list = (List<DaysOfYear>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (DaysOfYear daysOfYear : list) {
				if (!Validator.equals(dayId, daysOfYear.getDayId()) ||
						(unitType != daysOfYear.getUnitType())) {
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

			query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

			boolean bindDayId = false;

			if (dayId == null) {
				query.append(_FINDER_COLUMN_D_UT_DAYID_1);
			}
			else {
				bindDayId = true;

				query.append(_FINDER_COLUMN_D_UT_DAYID_2);
			}

			query.append(_FINDER_COLUMN_D_UT_UNITTYPE_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDayId) {
					qPos.add(CalendarUtil.getTimestamp(dayId));
				}

				qPos.add(unitType);

				if (!pagination) {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOfYear>(list);
				}
				else {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByD_UT_First(Date dayId, int unitType,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByD_UT_First(dayId, unitType,
				orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dayId=");
		msg.append(dayId);

		msg.append(", unitType=");
		msg.append(unitType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the first days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByD_UT_First(Date dayId, int unitType,
		OrderByComparator orderByComparator) throws SystemException {
		List<DaysOfYear> list = findByD_UT(dayId, unitType, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByD_UT_Last(Date dayId, int unitType,
		OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByD_UT_Last(dayId, unitType,
				orderByComparator);

		if (daysOfYear != null) {
			return daysOfYear;
		}

		StringBundler msg = new StringBundler(6);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("dayId=");
		msg.append(dayId);

		msg.append(", unitType=");
		msg.append(unitType);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchDaysOfYearException(msg.toString());
	}

	/**
	 * Returns the last days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching days of year, or <code>null</code> if a matching days of year could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByD_UT_Last(Date dayId, int unitType,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByD_UT(dayId, unitType);

		if (count == 0) {
			return null;
		}

		List<DaysOfYear> list = findByD_UT(dayId, unitType, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the days of years before and after the current days of year in the ordered set where dayId = &#63; and unitType = &#63;.
	 *
	 * @param dayOfYearId the primary key of the current days of year
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear[] findByD_UT_PrevAndNext(long dayOfYearId, Date dayId,
		int unitType, OrderByComparator orderByComparator)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = findByPrimaryKey(dayOfYearId);

		Session session = null;

		try {
			session = openSession();

			DaysOfYear[] array = new DaysOfYearImpl[3];

			array[0] = getByD_UT_PrevAndNext(session, daysOfYear, dayId,
					unitType, orderByComparator, true);

			array[1] = daysOfYear;

			array[2] = getByD_UT_PrevAndNext(session, daysOfYear, dayId,
					unitType, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected DaysOfYear getByD_UT_PrevAndNext(Session session,
		DaysOfYear daysOfYear, Date dayId, int unitType,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_DAYSOFYEAR_WHERE);

		boolean bindDayId = false;

		if (dayId == null) {
			query.append(_FINDER_COLUMN_D_UT_DAYID_1);
		}
		else {
			bindDayId = true;

			query.append(_FINDER_COLUMN_D_UT_DAYID_2);
		}

		query.append(_FINDER_COLUMN_D_UT_UNITTYPE_2);

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
			query.append(DaysOfYearModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		if (bindDayId) {
			qPos.add(CalendarUtil.getTimestamp(dayId));
		}

		qPos.add(unitType);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(daysOfYear);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<DaysOfYear> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the days of years where dayId = &#63; and unitType = &#63; from the database.
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByD_UT(Date dayId, int unitType)
		throws SystemException {
		for (DaysOfYear daysOfYear : findByD_UT(dayId, unitType,
				QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(daysOfYear);
		}
	}

	/**
	 * Returns the number of days of years where dayId = &#63; and unitType = &#63;.
	 *
	 * @param dayId the day ID
	 * @param unitType the unit type
	 * @return the number of matching days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByD_UT(Date dayId, int unitType) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_D_UT;

		Object[] finderArgs = new Object[] { dayId, unitType };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_COUNT_DAYSOFYEAR_WHERE);

			boolean bindDayId = false;

			if (dayId == null) {
				query.append(_FINDER_COLUMN_D_UT_DAYID_1);
			}
			else {
				bindDayId = true;

				query.append(_FINDER_COLUMN_D_UT_DAYID_2);
			}

			query.append(_FINDER_COLUMN_D_UT_UNITTYPE_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindDayId) {
					qPos.add(CalendarUtil.getTimestamp(dayId));
				}

				qPos.add(unitType);

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

	private static final String _FINDER_COLUMN_D_UT_DAYID_1 = "daysOfYear.dayId IS NULL AND ";
	private static final String _FINDER_COLUMN_D_UT_DAYID_2 = "daysOfYear.dayId = ? AND ";
	private static final String _FINDER_COLUMN_D_UT_UNITTYPE_2 = "daysOfYear.unitType = ?";

	public DaysOfYearPersistenceImpl() {
		setModelClass(DaysOfYear.class);
	}

	/**
	 * Caches the days of year in the entity cache if it is enabled.
	 *
	 * @param daysOfYear the days of year
	 */
	@Override
	public void cacheResult(DaysOfYear daysOfYear) {
		EntityCacheUtil.putResult(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearImpl.class, daysOfYear.getPrimaryKey(), daysOfYear);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID,
			new Object[] { daysOfYear.getDayOfYearId() }, daysOfYear);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_U,
			new Object[] { daysOfYear.getDayId(), daysOfYear.getUnitId() },
			daysOfYear);

		daysOfYear.resetOriginalValues();
	}

	/**
	 * Caches the days of years in the entity cache if it is enabled.
	 *
	 * @param daysOfYears the days of years
	 */
	@Override
	public void cacheResult(List<DaysOfYear> daysOfYears) {
		for (DaysOfYear daysOfYear : daysOfYears) {
			if (EntityCacheUtil.getResult(
						DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
						DaysOfYearImpl.class, daysOfYear.getPrimaryKey()) == null) {
				cacheResult(daysOfYear);
			}
			else {
				daysOfYear.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all days of years.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(DaysOfYearImpl.class.getName());
		}

		EntityCacheUtil.clearCache(DaysOfYearImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the days of year.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(DaysOfYear daysOfYear) {
		EntityCacheUtil.removeResult(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearImpl.class, daysOfYear.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(daysOfYear);
	}

	@Override
	public void clearCache(List<DaysOfYear> daysOfYears) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (DaysOfYear daysOfYear : daysOfYears) {
			EntityCacheUtil.removeResult(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
				DaysOfYearImpl.class, daysOfYear.getPrimaryKey());

			clearUniqueFindersCache(daysOfYear);
		}
	}

	protected void cacheUniqueFindersCache(DaysOfYear daysOfYear) {
		if (daysOfYear.isNew()) {
			Object[] args = new Object[] { daysOfYear.getDayOfYearId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYSOFYEARID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID, args,
				daysOfYear);

			args = new Object[] { daysOfYear.getDayId(), daysOfYear.getUnitId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_U, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_U, args, daysOfYear);
		}
		else {
			DaysOfYearModelImpl daysOfYearModelImpl = (DaysOfYearModelImpl)daysOfYear;

			if ((daysOfYearModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_DAYSOFYEARID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { daysOfYear.getDayOfYearId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_DAYSOFYEARID,
					args, Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID,
					args, daysOfYear);
			}

			if ((daysOfYearModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_D_U.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOfYear.getDayId(), daysOfYear.getUnitId()
					};

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_D_U, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_D_U, args,
					daysOfYear);
			}
		}
	}

	protected void clearUniqueFindersCache(DaysOfYear daysOfYear) {
		DaysOfYearModelImpl daysOfYearModelImpl = (DaysOfYearModelImpl)daysOfYear;

		Object[] args = new Object[] { daysOfYear.getDayOfYearId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAYSOFYEARID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID, args);

		if ((daysOfYearModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_DAYSOFYEARID.getColumnBitmask()) != 0) {
			args = new Object[] { daysOfYearModelImpl.getOriginalDayOfYearId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DAYSOFYEARID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_DAYSOFYEARID, args);
		}

		args = new Object[] { daysOfYear.getDayId(), daysOfYear.getUnitId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_U, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_U, args);

		if ((daysOfYearModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_D_U.getColumnBitmask()) != 0) {
			args = new Object[] {
					daysOfYearModelImpl.getOriginalDayId(),
					daysOfYearModelImpl.getOriginalUnitId()
				};

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_U, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_D_U, args);
		}
	}

	/**
	 * Creates a new days of year with the primary key. Does not add the days of year to the database.
	 *
	 * @param dayOfYearId the primary key for the new days of year
	 * @return the new days of year
	 */
	@Override
	public DaysOfYear create(long dayOfYearId) {
		DaysOfYear daysOfYear = new DaysOfYearImpl();

		daysOfYear.setNew(true);
		daysOfYear.setPrimaryKey(dayOfYearId);

		return daysOfYear;
	}

	/**
	 * Removes the days of year with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param dayOfYearId the primary key of the days of year
	 * @return the days of year that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear remove(long dayOfYearId)
		throws NoSuchDaysOfYearException, SystemException {
		return remove((Serializable)dayOfYearId);
	}

	/**
	 * Removes the days of year with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the days of year
	 * @return the days of year that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear remove(Serializable primaryKey)
		throws NoSuchDaysOfYearException, SystemException {
		Session session = null;

		try {
			session = openSession();

			DaysOfYear daysOfYear = (DaysOfYear)session.get(DaysOfYearImpl.class,
					primaryKey);

			if (daysOfYear == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchDaysOfYearException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(daysOfYear);
		}
		catch (NoSuchDaysOfYearException nsee) {
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
	protected DaysOfYear removeImpl(DaysOfYear daysOfYear)
		throws SystemException {
		daysOfYear = toUnwrappedModel(daysOfYear);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(daysOfYear)) {
				daysOfYear = (DaysOfYear)session.get(DaysOfYearImpl.class,
						daysOfYear.getPrimaryKeyObj());
			}

			if (daysOfYear != null) {
				session.delete(daysOfYear);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (daysOfYear != null) {
			clearCache(daysOfYear);
		}

		return daysOfYear;
	}

	@Override
	public DaysOfYear updateImpl(
		com.liferay.timetracking.dayoffs.model.DaysOfYear daysOfYear)
		throws SystemException {
		daysOfYear = toUnwrappedModel(daysOfYear);

		boolean isNew = daysOfYear.isNew();

		DaysOfYearModelImpl daysOfYearModelImpl = (DaysOfYearModelImpl)daysOfYear;

		Session session = null;

		try {
			session = openSession();

			if (daysOfYear.isNew()) {
				session.save(daysOfYear);

				daysOfYear.setNew(false);
			}
			else {
				session.merge(daysOfYear);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !DaysOfYearModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((daysOfYearModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEDAY.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOfYearModelImpl.getOriginalDayId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATEDAY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEDAY,
					args);

				args = new Object[] { daysOfYearModelImpl.getDayId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_DATEDAY, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_DATEDAY,
					args);
			}

			if ((daysOfYearModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOfYearModelImpl.getOriginalUnitId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);

				args = new Object[] { daysOfYearModelImpl.getUnitId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNIT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNIT,
					args);
			}

			if ((daysOfYearModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITTYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOfYearModelImpl.getOriginalUnitType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITTYPE,
					args);

				args = new Object[] { daysOfYearModelImpl.getUnitType() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_UNITTYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_UNITTYPE,
					args);
			}

			if ((daysOfYearModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_UT.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						daysOfYearModelImpl.getOriginalDayId(),
						daysOfYearModelImpl.getOriginalUnitType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_UT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_UT,
					args);

				args = new Object[] {
						daysOfYearModelImpl.getDayId(),
						daysOfYearModelImpl.getUnitType()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_D_UT, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_D_UT,
					args);
			}
		}

		EntityCacheUtil.putResult(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
			DaysOfYearImpl.class, daysOfYear.getPrimaryKey(), daysOfYear);

		clearUniqueFindersCache(daysOfYear);
		cacheUniqueFindersCache(daysOfYear);

		return daysOfYear;
	}

	protected DaysOfYear toUnwrappedModel(DaysOfYear daysOfYear) {
		if (daysOfYear instanceof DaysOfYearImpl) {
			return daysOfYear;
		}

		DaysOfYearImpl daysOfYearImpl = new DaysOfYearImpl();

		daysOfYearImpl.setNew(daysOfYear.isNew());
		daysOfYearImpl.setPrimaryKey(daysOfYear.getPrimaryKey());

		daysOfYearImpl.setDayOfYearId(daysOfYear.getDayOfYearId());
		daysOfYearImpl.setGroupId(daysOfYear.getGroupId());
		daysOfYearImpl.setCompanyId(daysOfYear.getCompanyId());
		daysOfYearImpl.setUserId(daysOfYear.getUserId());
		daysOfYearImpl.setUserName(daysOfYear.getUserName());
		daysOfYearImpl.setCreateDate(daysOfYear.getCreateDate());
		daysOfYearImpl.setModifiedDate(daysOfYear.getModifiedDate());
		daysOfYearImpl.setDayId(daysOfYear.getDayId());
		daysOfYearImpl.setRuleId(daysOfYear.getRuleId());
		daysOfYearImpl.setUnitId(daysOfYear.getUnitId());
		daysOfYearImpl.setUnitType(daysOfYear.getUnitType());

		return daysOfYearImpl;
	}

	/**
	 * Returns the days of year with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the days of year
	 * @return the days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByPrimaryKey(Serializable primaryKey)
		throws NoSuchDaysOfYearException, SystemException {
		DaysOfYear daysOfYear = fetchByPrimaryKey(primaryKey);

		if (daysOfYear == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchDaysOfYearException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return daysOfYear;
	}

	/**
	 * Returns the days of year with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException} if it could not be found.
	 *
	 * @param dayOfYearId the primary key of the days of year
	 * @return the days of year
	 * @throws com.liferay.timetracking.dayoffs.NoSuchDaysOfYearException if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear findByPrimaryKey(long dayOfYearId)
		throws NoSuchDaysOfYearException, SystemException {
		return findByPrimaryKey((Serializable)dayOfYearId);
	}

	/**
	 * Returns the days of year with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the days of year
	 * @return the days of year, or <code>null</code> if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		DaysOfYear daysOfYear = (DaysOfYear)EntityCacheUtil.getResult(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
				DaysOfYearImpl.class, primaryKey);

		if (daysOfYear == _nullDaysOfYear) {
			return null;
		}

		if (daysOfYear == null) {
			Session session = null;

			try {
				session = openSession();

				daysOfYear = (DaysOfYear)session.get(DaysOfYearImpl.class,
						primaryKey);

				if (daysOfYear != null) {
					cacheResult(daysOfYear);
				}
				else {
					EntityCacheUtil.putResult(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
						DaysOfYearImpl.class, primaryKey, _nullDaysOfYear);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(DaysOfYearModelImpl.ENTITY_CACHE_ENABLED,
					DaysOfYearImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return daysOfYear;
	}

	/**
	 * Returns the days of year with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param dayOfYearId the primary key of the days of year
	 * @return the days of year, or <code>null</code> if a days of year with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public DaysOfYear fetchByPrimaryKey(long dayOfYearId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)dayOfYearId);
	}

	/**
	 * Returns all the days of years.
	 *
	 * @return the days of years
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<DaysOfYear> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
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
	@Override
	public List<DaysOfYear> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
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
	@Override
	public List<DaysOfYear> findAll(int start, int end,
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

		List<DaysOfYear> list = (List<DaysOfYear>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_DAYSOFYEAR);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_DAYSOFYEAR;

				if (pagination) {
					sql = sql.concat(DaysOfYearModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<DaysOfYear>(list);
				}
				else {
					list = (List<DaysOfYear>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the days of years from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (DaysOfYear daysOfYear : findAll()) {
			remove(daysOfYear);
		}
	}

	/**
	 * Returns the number of days of years.
	 *
	 * @return the number of days of years
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

				Query q = session.createQuery(_SQL_COUNT_DAYSOFYEAR);

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
	 * Initializes the days of year persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.dayoffs.model.DaysOfYear")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<DaysOfYear>> listenersList = new ArrayList<ModelListener<DaysOfYear>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<DaysOfYear>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(DaysOfYearImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_DAYSOFYEAR = "SELECT daysOfYear FROM DaysOfYear daysOfYear";
	private static final String _SQL_SELECT_DAYSOFYEAR_WHERE = "SELECT daysOfYear FROM DaysOfYear daysOfYear WHERE ";
	private static final String _SQL_COUNT_DAYSOFYEAR = "SELECT COUNT(daysOfYear) FROM DaysOfYear daysOfYear";
	private static final String _SQL_COUNT_DAYSOFYEAR_WHERE = "SELECT COUNT(daysOfYear) FROM DaysOfYear daysOfYear WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "daysOfYear.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No DaysOfYear exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No DaysOfYear exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(DaysOfYearPersistenceImpl.class);
	private static DaysOfYear _nullDaysOfYear = new DaysOfYearImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<DaysOfYear> toCacheModel() {
				return _nullDaysOfYearCacheModel;
			}
		};

	private static CacheModel<DaysOfYear> _nullDaysOfYearCacheModel = new CacheModel<DaysOfYear>() {
			@Override
			public DaysOfYear toEntityModel() {
				return _nullDaysOfYear;
			}
		};
}