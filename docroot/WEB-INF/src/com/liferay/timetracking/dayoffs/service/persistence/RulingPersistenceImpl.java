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
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.model.ModelListener;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;

import com.liferay.timetracking.dayoffs.NoSuchRulingException;
import com.liferay.timetracking.dayoffs.model.Ruling;
import com.liferay.timetracking.dayoffs.model.impl.RulingImpl;
import com.liferay.timetracking.dayoffs.model.impl.RulingModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the ruling service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see RulingPersistence
 * @see RulingUtil
 * @generated
 */
public class RulingPersistenceImpl extends BasePersistenceImpl<Ruling>
	implements RulingPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RulingUtil} to access the ruling persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RulingImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, RulingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, RulingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_FETCH_BY_RULEID = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, RulingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRuleId",
			new String[] { Long.class.getName() },
			RulingModelImpl.RULEID_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RULEID = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleId",
			new String[] { Long.class.getName() });

	/**
	 * Returns the ruling where ruleId = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRulingException} if it could not be found.
	 *
	 * @param ruleId the rule ID
	 * @return the matching ruling
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling findByRuleId(long ruleId)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = fetchByRuleId(ruleId);

		if (ruling == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ruleId=");
			msg.append(ruleId);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRulingException(msg.toString());
		}

		return ruling;
	}

	/**
	 * Returns the ruling where ruleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ruleId the rule ID
	 * @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByRuleId(long ruleId) throws SystemException {
		return fetchByRuleId(ruleId, true);
	}

	/**
	 * Returns the ruling where ruleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ruleId the rule ID
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByRuleId(long ruleId, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ruleId };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RULEID,
					finderArgs, this);
		}

		if (result instanceof Ruling) {
			Ruling ruling = (Ruling)result;

			if ((ruleId != ruling.getRuleId())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RULING_WHERE);

			query.append(_FINDER_COLUMN_RULEID_RULEID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(ruleId);

				List<Ruling> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULEID,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RulingPersistenceImpl.fetchByRuleId(long, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Ruling ruling = list.get(0);

					result = ruling;

					cacheResult(ruling);

					if ((ruling.getRuleId() != ruleId)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULEID,
							finderArgs, ruling);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RULEID,
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
			return (Ruling)result;
		}
	}

	/**
	 * Removes the ruling where ruleId = &#63; from the database.
	 *
	 * @param ruleId the rule ID
	 * @return the ruling that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling removeByRuleId(long ruleId)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = findByRuleId(ruleId);

		return remove(ruling);
	}

	/**
	 * Returns the number of rulings where ruleId = &#63;.
	 *
	 * @param ruleId the rule ID
	 * @return the number of matching rulings
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

			query.append(_SQL_COUNT_RULING_WHERE);

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

	private static final String _FINDER_COLUMN_RULEID_RULEID_2 = "ruling.ruleId = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_RULENAME = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, RulingImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByRuleName",
			new String[] { String.class.getName() },
			RulingModelImpl.RULENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RULENAME = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleName",
			new String[] { String.class.getName() });

	/**
	 * Returns the ruling where ruleName = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRulingException} if it could not be found.
	 *
	 * @param ruleName the rule name
	 * @return the matching ruling
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling findByRuleName(String ruleName)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = fetchByRuleName(ruleName);

		if (ruling == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("ruleName=");
			msg.append(ruleName);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRulingException(msg.toString());
		}

		return ruling;
	}

	/**
	 * Returns the ruling where ruleName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param ruleName the rule name
	 * @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByRuleName(String ruleName) throws SystemException {
		return fetchByRuleName(ruleName, true);
	}

	/**
	 * Returns the ruling where ruleName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param ruleName the rule name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByRuleName(String ruleName, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { ruleName };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_RULENAME,
					finderArgs, this);
		}

		if (result instanceof Ruling) {
			Ruling ruling = (Ruling)result;

			if (!Validator.equals(ruleName, ruling.getRuleName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RULING_WHERE);

			boolean bindRuleName = false;

			if (ruleName == null) {
				query.append(_FINDER_COLUMN_RULENAME_RULENAME_1);
			}
			else if (ruleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RULENAME_RULENAME_3);
			}
			else {
				bindRuleName = true;

				query.append(_FINDER_COLUMN_RULENAME_RULENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRuleName) {
					qPos.add(ruleName);
				}

				List<Ruling> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULENAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RulingPersistenceImpl.fetchByRuleName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Ruling ruling = list.get(0);

					result = ruling;

					cacheResult(ruling);

					if ((ruling.getRuleName() == null) ||
							!ruling.getRuleName().equals(ruleName)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULENAME,
							finderArgs, ruling);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RULENAME,
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
			return (Ruling)result;
		}
	}

	/**
	 * Removes the ruling where ruleName = &#63; from the database.
	 *
	 * @param ruleName the rule name
	 * @return the ruling that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling removeByRuleName(String ruleName)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = findByRuleName(ruleName);

		return remove(ruling);
	}

	/**
	 * Returns the number of rulings where ruleName = &#63;.
	 *
	 * @param ruleName the rule name
	 * @return the number of matching rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRuleName(String ruleName) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RULENAME;

		Object[] finderArgs = new Object[] { ruleName };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULING_WHERE);

			boolean bindRuleName = false;

			if (ruleName == null) {
				query.append(_FINDER_COLUMN_RULENAME_RULENAME_1);
			}
			else if (ruleName.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_RULENAME_RULENAME_3);
			}
			else {
				bindRuleName = true;

				query.append(_FINDER_COLUMN_RULENAME_RULENAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindRuleName) {
					qPos.add(ruleName);
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

	private static final String _FINDER_COLUMN_RULENAME_RULENAME_1 = "ruling.ruleName IS NULL";
	private static final String _FINDER_COLUMN_RULENAME_RULENAME_2 = "ruling.ruleName = ?";
	private static final String _FINDER_COLUMN_RULENAME_RULENAME_3 = "(ruling.ruleName IS NULL OR ruling.ruleName = '')";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_RULETYPE = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, RulingImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByRuleType",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULETYPE =
		new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, RulingImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByRuleType",
			new String[] { Double.class.getName() },
			RulingModelImpl.MULTIPLIER_COLUMN_BITMASK |
			RulingModelImpl.RULENAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_RULETYPE = new FinderPath(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByRuleType",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the rulings where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @return the matching rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ruling> findByRuleType(double multiplier)
		throws SystemException {
		return findByRuleType(multiplier, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the rulings where multiplier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RulingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param multiplier the multiplier
	 * @param start the lower bound of the range of rulings
	 * @param end the upper bound of the range of rulings (not inclusive)
	 * @return the range of matching rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ruling> findByRuleType(double multiplier, int start, int end)
		throws SystemException {
		return findByRuleType(multiplier, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rulings where multiplier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RulingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param multiplier the multiplier
	 * @param start the lower bound of the range of rulings
	 * @param end the upper bound of the range of rulings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ruling> findByRuleType(double multiplier, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULETYPE;
			finderArgs = new Object[] { multiplier };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_RULETYPE;
			finderArgs = new Object[] { multiplier, start, end, orderByComparator };
		}

		List<Ruling> list = (List<Ruling>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Ruling ruling : list) {
				if ((multiplier != ruling.getMultiplier())) {
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

			query.append(_SQL_SELECT_RULING_WHERE);

			query.append(_FINDER_COLUMN_RULETYPE_MULTIPLIER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RulingModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(multiplier);

				if (!pagination) {
					list = (List<Ruling>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ruling>(list);
				}
				else {
					list = (List<Ruling>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Returns the first ruling in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ruling
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling findByRuleType_First(double multiplier,
		OrderByComparator orderByComparator)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = fetchByRuleType_First(multiplier, orderByComparator);

		if (ruling != null) {
			return ruling;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("multiplier=");
		msg.append(multiplier);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRulingException(msg.toString());
	}

	/**
	 * Returns the first ruling in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching ruling, or <code>null</code> if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByRuleType_First(double multiplier,
		OrderByComparator orderByComparator) throws SystemException {
		List<Ruling> list = findByRuleType(multiplier, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last ruling in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ruling
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling findByRuleType_Last(double multiplier,
		OrderByComparator orderByComparator)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = fetchByRuleType_Last(multiplier, orderByComparator);

		if (ruling != null) {
			return ruling;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("multiplier=");
		msg.append(multiplier);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRulingException(msg.toString());
	}

	/**
	 * Returns the last ruling in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching ruling, or <code>null</code> if a matching ruling could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByRuleType_Last(double multiplier,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByRuleType(multiplier);

		if (count == 0) {
			return null;
		}

		List<Ruling> list = findByRuleType(multiplier, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rulings before and after the current ruling in the ordered set where multiplier = &#63;.
	 *
	 * @param ruleId the primary key of the current ruling
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next ruling
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a ruling with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling[] findByRuleType_PrevAndNext(long ruleId, double multiplier,
		OrderByComparator orderByComparator)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = findByPrimaryKey(ruleId);

		Session session = null;

		try {
			session = openSession();

			Ruling[] array = new RulingImpl[3];

			array[0] = getByRuleType_PrevAndNext(session, ruling, multiplier,
					orderByComparator, true);

			array[1] = ruling;

			array[2] = getByRuleType_PrevAndNext(session, ruling, multiplier,
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

	protected Ruling getByRuleType_PrevAndNext(Session session, Ruling ruling,
		double multiplier, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULING_WHERE);

		query.append(_FINDER_COLUMN_RULETYPE_MULTIPLIER_2);

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
			query.append(RulingModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(multiplier);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(ruling);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Ruling> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rulings where multiplier = &#63; from the database.
	 *
	 * @param multiplier the multiplier
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByRuleType(double multiplier) throws SystemException {
		for (Ruling ruling : findByRuleType(multiplier, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(ruling);
		}
	}

	/**
	 * Returns the number of rulings where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @return the number of matching rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByRuleType(double multiplier) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_RULETYPE;

		Object[] finderArgs = new Object[] { multiplier };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULING_WHERE);

			query.append(_FINDER_COLUMN_RULETYPE_MULTIPLIER_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(multiplier);

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

	private static final String _FINDER_COLUMN_RULETYPE_MULTIPLIER_2 = "ruling.multiplier = ?";

	public RulingPersistenceImpl() {
		setModelClass(Ruling.class);
	}

	/**
	 * Caches the ruling in the entity cache if it is enabled.
	 *
	 * @param ruling the ruling
	 */
	@Override
	public void cacheResult(Ruling ruling) {
		EntityCacheUtil.putResult(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingImpl.class, ruling.getPrimaryKey(), ruling);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULEID,
			new Object[] { ruling.getRuleId() }, ruling);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULENAME,
			new Object[] { ruling.getRuleName() }, ruling);

		ruling.resetOriginalValues();
	}

	/**
	 * Caches the rulings in the entity cache if it is enabled.
	 *
	 * @param rulings the rulings
	 */
	@Override
	public void cacheResult(List<Ruling> rulings) {
		for (Ruling ruling : rulings) {
			if (EntityCacheUtil.getResult(
						RulingModelImpl.ENTITY_CACHE_ENABLED, RulingImpl.class,
						ruling.getPrimaryKey()) == null) {
				cacheResult(ruling);
			}
			else {
				ruling.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rulings.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RulingImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RulingImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the ruling.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Ruling ruling) {
		EntityCacheUtil.removeResult(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingImpl.class, ruling.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(ruling);
	}

	@Override
	public void clearCache(List<Ruling> rulings) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Ruling ruling : rulings) {
			EntityCacheUtil.removeResult(RulingModelImpl.ENTITY_CACHE_ENABLED,
				RulingImpl.class, ruling.getPrimaryKey());

			clearUniqueFindersCache(ruling);
		}
	}

	protected void cacheUniqueFindersCache(Ruling ruling) {
		if (ruling.isNew()) {
			Object[] args = new Object[] { ruling.getRuleId() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RULEID, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULEID, args, ruling);

			args = new Object[] { ruling.getRuleName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RULENAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULENAME, args,
				ruling);
		}
		else {
			RulingModelImpl rulingModelImpl = (RulingModelImpl)ruling;

			if ((rulingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RULEID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { ruling.getRuleId() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RULEID, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULEID, args,
					ruling);
			}

			if ((rulingModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_RULENAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { ruling.getRuleName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_RULENAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_RULENAME, args,
					ruling);
			}
		}
	}

	protected void clearUniqueFindersCache(Ruling ruling) {
		RulingModelImpl rulingModelImpl = (RulingModelImpl)ruling;

		Object[] args = new Object[] { ruling.getRuleId() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULEID, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RULEID, args);

		if ((rulingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RULEID.getColumnBitmask()) != 0) {
			args = new Object[] { rulingModelImpl.getOriginalRuleId() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULEID, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RULEID, args);
		}

		args = new Object[] { ruling.getRuleName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULENAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RULENAME, args);

		if ((rulingModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_RULENAME.getColumnBitmask()) != 0) {
			args = new Object[] { rulingModelImpl.getOriginalRuleName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULENAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_RULENAME, args);
		}
	}

	/**
	 * Creates a new ruling with the primary key. Does not add the ruling to the database.
	 *
	 * @param ruleId the primary key for the new ruling
	 * @return the new ruling
	 */
	@Override
	public Ruling create(long ruleId) {
		Ruling ruling = new RulingImpl();

		ruling.setNew(true);
		ruling.setPrimaryKey(ruleId);

		return ruling;
	}

	/**
	 * Removes the ruling with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleId the primary key of the ruling
	 * @return the ruling that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a ruling with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling remove(long ruleId)
		throws NoSuchRulingException, SystemException {
		return remove((Serializable)ruleId);
	}

	/**
	 * Removes the ruling with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the ruling
	 * @return the ruling that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a ruling with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling remove(Serializable primaryKey)
		throws NoSuchRulingException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Ruling ruling = (Ruling)session.get(RulingImpl.class, primaryKey);

			if (ruling == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRulingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(ruling);
		}
		catch (NoSuchRulingException nsee) {
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
	protected Ruling removeImpl(Ruling ruling) throws SystemException {
		ruling = toUnwrappedModel(ruling);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(ruling)) {
				ruling = (Ruling)session.get(RulingImpl.class,
						ruling.getPrimaryKeyObj());
			}

			if (ruling != null) {
				session.delete(ruling);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (ruling != null) {
			clearCache(ruling);
		}

		return ruling;
	}

	@Override
	public Ruling updateImpl(
		com.liferay.timetracking.dayoffs.model.Ruling ruling)
		throws SystemException {
		ruling = toUnwrappedModel(ruling);

		boolean isNew = ruling.isNew();

		RulingModelImpl rulingModelImpl = (RulingModelImpl)ruling;

		Session session = null;

		try {
			session = openSession();

			if (ruling.isNew()) {
				session.save(ruling);

				ruling.setNew(false);
			}
			else {
				session.merge(ruling);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RulingModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((rulingModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULETYPE.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						rulingModelImpl.getOriginalMultiplier()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULETYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULETYPE,
					args);

				args = new Object[] { rulingModelImpl.getMultiplier() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_RULETYPE, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_RULETYPE,
					args);
			}
		}

		EntityCacheUtil.putResult(RulingModelImpl.ENTITY_CACHE_ENABLED,
			RulingImpl.class, ruling.getPrimaryKey(), ruling);

		clearUniqueFindersCache(ruling);
		cacheUniqueFindersCache(ruling);

		return ruling;
	}

	protected Ruling toUnwrappedModel(Ruling ruling) {
		if (ruling instanceof RulingImpl) {
			return ruling;
		}

		RulingImpl rulingImpl = new RulingImpl();

		rulingImpl.setNew(ruling.isNew());
		rulingImpl.setPrimaryKey(ruling.getPrimaryKey());

		rulingImpl.setRuleId(ruling.getRuleId());
		rulingImpl.setGroupId(ruling.getGroupId());
		rulingImpl.setCompanyId(ruling.getCompanyId());
		rulingImpl.setUserId(ruling.getUserId());
		rulingImpl.setUserName(ruling.getUserName());
		rulingImpl.setCreateDate(ruling.getCreateDate());
		rulingImpl.setModifiedDate(ruling.getModifiedDate());
		rulingImpl.setRuleName(ruling.getRuleName());
		rulingImpl.setMultiplier(ruling.getMultiplier());

		return rulingImpl;
	}

	/**
	 * Returns the ruling with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the ruling
	 * @return the ruling
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a ruling with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRulingException, SystemException {
		Ruling ruling = fetchByPrimaryKey(primaryKey);

		if (ruling == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRulingException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return ruling;
	}

	/**
	 * Returns the ruling with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRulingException} if it could not be found.
	 *
	 * @param ruleId the primary key of the ruling
	 * @return the ruling
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a ruling with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling findByPrimaryKey(long ruleId)
		throws NoSuchRulingException, SystemException {
		return findByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns the ruling with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the ruling
	 * @return the ruling, or <code>null</code> if a ruling with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Ruling ruling = (Ruling)EntityCacheUtil.getResult(RulingModelImpl.ENTITY_CACHE_ENABLED,
				RulingImpl.class, primaryKey);

		if (ruling == _nullRuling) {
			return null;
		}

		if (ruling == null) {
			Session session = null;

			try {
				session = openSession();

				ruling = (Ruling)session.get(RulingImpl.class, primaryKey);

				if (ruling != null) {
					cacheResult(ruling);
				}
				else {
					EntityCacheUtil.putResult(RulingModelImpl.ENTITY_CACHE_ENABLED,
						RulingImpl.class, primaryKey, _nullRuling);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RulingModelImpl.ENTITY_CACHE_ENABLED,
					RulingImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return ruling;
	}

	/**
	 * Returns the ruling with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleId the primary key of the ruling
	 * @return the ruling, or <code>null</code> if a ruling with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Ruling fetchByPrimaryKey(long ruleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns all the rulings.
	 *
	 * @return the rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ruling> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rulings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RulingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rulings
	 * @param end the upper bound of the range of rulings (not inclusive)
	 * @return the range of rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ruling> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rulings.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RulingModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rulings
	 * @param end the upper bound of the range of rulings (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rulings
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Ruling> findAll(int start, int end,
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

		List<Ruling> list = (List<Ruling>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RULING);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULING;

				if (pagination) {
					sql = sql.concat(RulingModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Ruling>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Ruling>(list);
				}
				else {
					list = (List<Ruling>)QueryUtil.list(q, getDialect(), start,
							end);
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
	 * Removes all the rulings from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Ruling ruling : findAll()) {
			remove(ruling);
		}
	}

	/**
	 * Returns the number of rulings.
	 *
	 * @return the number of rulings
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

				Query q = session.createQuery(_SQL_COUNT_RULING);

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
	 * Initializes the ruling persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.dayoffs.model.Ruling")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Ruling>> listenersList = new ArrayList<ModelListener<Ruling>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Ruling>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RulingImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RULING = "SELECT ruling FROM Ruling ruling";
	private static final String _SQL_SELECT_RULING_WHERE = "SELECT ruling FROM Ruling ruling WHERE ";
	private static final String _SQL_COUNT_RULING = "SELECT COUNT(ruling) FROM Ruling ruling";
	private static final String _SQL_COUNT_RULING_WHERE = "SELECT COUNT(ruling) FROM Ruling ruling WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "ruling.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Ruling exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Ruling exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RulingPersistenceImpl.class);
	private static Ruling _nullRuling = new RulingImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Ruling> toCacheModel() {
				return _nullRulingCacheModel;
			}
		};

	private static CacheModel<Ruling> _nullRulingCacheModel = new CacheModel<Ruling>() {
			@Override
			public Ruling toEntityModel() {
				return _nullRuling;
			}
		};
}