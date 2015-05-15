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

import com.liferay.timetracking.dayoffs.NoSuchRuleException;
import com.liferay.timetracking.dayoffs.model.Rule;
import com.liferay.timetracking.dayoffs.model.impl.RuleImpl;
import com.liferay.timetracking.dayoffs.model.impl.RuleModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the rule service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak
 * @see RulePersistence
 * @see RuleUtil
 * @generated
 */
public class RulePersistenceImpl extends BasePersistenceImpl<Rule>
	implements RulePersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link RuleUtil} to access the rule persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = RuleImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			RuleModelImpl.GROUPID_COLUMN_BITMASK |
			RuleModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the rules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @return the range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rules where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findByGroupId(long groupId, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID;
			finderArgs = new Object[] { groupId, start, end, orderByComparator };
		}

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Rule rule : list) {
				if ((groupId != rule.getGroupId())) {
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

			query.append(_SQL_SELECT_RULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Rule>(list);
				}
				else {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = fetchByGroupId_First(groupId, orderByComparator);

		if (rule != null) {
			return rule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleException(msg.toString());
	}

	/**
	 * Returns the first rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule, or <code>null</code> if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Rule> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = fetchByGroupId_Last(groupId, orderByComparator);

		if (rule != null) {
			return rule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleException(msg.toString());
	}

	/**
	 * Returns the last rule in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule, or <code>null</code> if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Rule> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rules before and after the current rule in the ordered set where groupId = &#63;.
	 *
	 * @param ruleId the primary key of the current rule
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule[] findByGroupId_PrevAndNext(long ruleId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByPrimaryKey(ruleId);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, rule, groupId,
					orderByComparator, true);

			array[1] = rule;

			array[2] = getByGroupId_PrevAndNext(session, rule, groupId,
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

	protected Rule getByGroupId_PrevAndNext(Session session, Rule rule,
		long groupId, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

		query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rules where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Rule rule : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rule);
		}
	}

	/**
	 * Returns the number of rules where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByGroupId(long groupId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_GROUPID;

		Object[] finderArgs = new Object[] { groupId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULE_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "rule.groupId = ?";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTIPLIER =
		new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByMultiplier",
			new String[] {
				Double.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLIER =
		new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, RuleImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByMultiplier",
			new String[] { Double.class.getName() },
			RuleModelImpl.MULTIPLIER_COLUMN_BITMASK |
			RuleModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_MULTIPLIER = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByMultiplier",
			new String[] { Double.class.getName() });

	/**
	 * Returns all the rules where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @return the matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findByMultiplier(double multiplier)
		throws SystemException {
		return findByMultiplier(multiplier, QueryUtil.ALL_POS,
			QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rules where multiplier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param multiplier the multiplier
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @return the range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findByMultiplier(double multiplier, int start, int end)
		throws SystemException {
		return findByMultiplier(multiplier, start, end, null);
	}

	/**
	 * Returns an ordered range of all the rules where multiplier = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param multiplier the multiplier
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findByMultiplier(double multiplier, int start, int end,
		OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLIER;
			finderArgs = new Object[] { multiplier };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_MULTIPLIER;
			finderArgs = new Object[] { multiplier, start, end, orderByComparator };
		}

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Rule rule : list) {
				if ((multiplier != rule.getMultiplier())) {
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

			query.append(_SQL_SELECT_RULE_WHERE);

			query.append(_FINDER_COLUMN_MULTIPLIER_MULTIPLIER_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(RuleModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(multiplier);

				if (!pagination) {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Rule>(list);
				}
				else {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
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
	 * Returns the first rule in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule findByMultiplier_First(double multiplier,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = fetchByMultiplier_First(multiplier, orderByComparator);

		if (rule != null) {
			return rule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("multiplier=");
		msg.append(multiplier);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleException(msg.toString());
	}

	/**
	 * Returns the first rule in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching rule, or <code>null</code> if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByMultiplier_First(double multiplier,
		OrderByComparator orderByComparator) throws SystemException {
		List<Rule> list = findByMultiplier(multiplier, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last rule in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule findByMultiplier_Last(double multiplier,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = fetchByMultiplier_Last(multiplier, orderByComparator);

		if (rule != null) {
			return rule;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("multiplier=");
		msg.append(multiplier);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchRuleException(msg.toString());
	}

	/**
	 * Returns the last rule in the ordered set where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching rule, or <code>null</code> if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByMultiplier_Last(double multiplier,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByMultiplier(multiplier);

		if (count == 0) {
			return null;
		}

		List<Rule> list = findByMultiplier(multiplier, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the rules before and after the current rule in the ordered set where multiplier = &#63;.
	 *
	 * @param ruleId the primary key of the current rule
	 * @param multiplier the multiplier
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule[] findByMultiplier_PrevAndNext(long ruleId, double multiplier,
		OrderByComparator orderByComparator)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByPrimaryKey(ruleId);

		Session session = null;

		try {
			session = openSession();

			Rule[] array = new RuleImpl[3];

			array[0] = getByMultiplier_PrevAndNext(session, rule, multiplier,
					orderByComparator, true);

			array[1] = rule;

			array[2] = getByMultiplier_PrevAndNext(session, rule, multiplier,
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

	protected Rule getByMultiplier_PrevAndNext(Session session, Rule rule,
		double multiplier, OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_RULE_WHERE);

		query.append(_FINDER_COLUMN_MULTIPLIER_MULTIPLIER_2);

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
			query.append(RuleModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(multiplier);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(rule);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Rule> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the rules where multiplier = &#63; from the database.
	 *
	 * @param multiplier the multiplier
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByMultiplier(double multiplier) throws SystemException {
		for (Rule rule : findByMultiplier(multiplier, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(rule);
		}
	}

	/**
	 * Returns the number of rules where multiplier = &#63;.
	 *
	 * @param multiplier the multiplier
	 * @return the number of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByMultiplier(double multiplier) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_MULTIPLIER;

		Object[] finderArgs = new Object[] { multiplier };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULE_WHERE);

			query.append(_FINDER_COLUMN_MULTIPLIER_MULTIPLIER_2);

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

	private static final String _FINDER_COLUMN_MULTIPLIER_MULTIPLIER_2 = "rule.multiplier = ?";
	public static final FinderPath FINDER_PATH_FETCH_BY_NAME = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, RuleImpl.class,
			FINDER_CLASS_NAME_ENTITY, "fetchByName",
			new String[] { String.class.getName() },
			RuleModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_NAME = new FinderPath(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByName",
			new String[] { String.class.getName() });

	/**
	 * Returns the rule where name = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRuleException} if it could not be found.
	 *
	 * @param name the name
	 * @return the matching rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule findByName(String name)
		throws NoSuchRuleException, SystemException {
		Rule rule = fetchByName(name);

		if (rule == null) {
			StringBundler msg = new StringBundler(4);

			msg.append(_NO_SUCH_ENTITY_WITH_KEY);

			msg.append("name=");
			msg.append(name);

			msg.append(StringPool.CLOSE_CURLY_BRACE);

			if (_log.isWarnEnabled()) {
				_log.warn(msg.toString());
			}

			throw new NoSuchRuleException(msg.toString());
		}

		return rule;
	}

	/**
	 * Returns the rule where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	 *
	 * @param name the name
	 * @return the matching rule, or <code>null</code> if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByName(String name) throws SystemException {
		return fetchByName(name, true);
	}

	/**
	 * Returns the rule where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	 *
	 * @param name the name
	 * @param retrieveFromCache whether to use the finder cache
	 * @return the matching rule, or <code>null</code> if a matching rule could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByName(String name, boolean retrieveFromCache)
		throws SystemException {
		Object[] finderArgs = new Object[] { name };

		Object result = null;

		if (retrieveFromCache) {
			result = FinderCacheUtil.getResult(FINDER_PATH_FETCH_BY_NAME,
					finderArgs, this);
		}

		if (result instanceof Rule) {
			Rule rule = (Rule)result;

			if (!Validator.equals(name, rule.getName())) {
				result = null;
			}
		}

		if (result == null) {
			StringBundler query = new StringBundler(3);

			query.append(_SQL_SELECT_RULE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
				}

				List<Rule> list = q.list();

				if (list.isEmpty()) {
					FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
						finderArgs, list);
				}
				else {
					if ((list.size() > 1) && _log.isWarnEnabled()) {
						_log.warn(
							"RulePersistenceImpl.fetchByName(String, boolean) with parameters (" +
							StringUtil.merge(finderArgs) +
							") yields a result set with more than 1 result. This violates the logical unique restriction. There is no order guarantee on which result is returned by this finder.");
					}

					Rule rule = list.get(0);

					result = rule;

					cacheResult(rule);

					if ((rule.getName() == null) ||
							!rule.getName().equals(name)) {
						FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
							finderArgs, rule);
					}
				}
			}
			catch (Exception e) {
				FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME,
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
			return (Rule)result;
		}
	}

	/**
	 * Removes the rule where name = &#63; from the database.
	 *
	 * @param name the name
	 * @return the rule that was removed
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule removeByName(String name)
		throws NoSuchRuleException, SystemException {
		Rule rule = findByName(name);

		return remove(rule);
	}

	/**
	 * Returns the number of rules where name = &#63;.
	 *
	 * @param name the name
	 * @return the number of matching rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByName(String name) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_NAME;

		Object[] finderArgs = new Object[] { name };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_RULE_WHERE);

			boolean bindName = false;

			if (name == null) {
				query.append(_FINDER_COLUMN_NAME_NAME_1);
			}
			else if (name.equals(StringPool.BLANK)) {
				query.append(_FINDER_COLUMN_NAME_NAME_3);
			}
			else {
				bindName = true;

				query.append(_FINDER_COLUMN_NAME_NAME_2);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				if (bindName) {
					qPos.add(name);
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

	private static final String _FINDER_COLUMN_NAME_NAME_1 = "rule.name IS NULL";
	private static final String _FINDER_COLUMN_NAME_NAME_2 = "rule.name = ?";
	private static final String _FINDER_COLUMN_NAME_NAME_3 = "(rule.name IS NULL OR rule.name = '')";

	public RulePersistenceImpl() {
		setModelClass(Rule.class);
	}

	/**
	 * Caches the rule in the entity cache if it is enabled.
	 *
	 * @param rule the rule
	 */
	@Override
	public void cacheResult(Rule rule) {
		EntityCacheUtil.putResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleImpl.class, rule.getPrimaryKey(), rule);

		FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME,
			new Object[] { rule.getName() }, rule);

		rule.resetOriginalValues();
	}

	/**
	 * Caches the rules in the entity cache if it is enabled.
	 *
	 * @param rules the rules
	 */
	@Override
	public void cacheResult(List<Rule> rules) {
		for (Rule rule : rules) {
			if (EntityCacheUtil.getResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
						RuleImpl.class, rule.getPrimaryKey()) == null) {
				cacheResult(rule);
			}
			else {
				rule.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all rules.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(RuleImpl.class.getName());
		}

		EntityCacheUtil.clearCache(RuleImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the rule.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Rule rule) {
		EntityCacheUtil.removeResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleImpl.class, rule.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		clearUniqueFindersCache(rule);
	}

	@Override
	public void clearCache(List<Rule> rules) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Rule rule : rules) {
			EntityCacheUtil.removeResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
				RuleImpl.class, rule.getPrimaryKey());

			clearUniqueFindersCache(rule);
		}
	}

	protected void cacheUniqueFindersCache(Rule rule) {
		if (rule.isNew()) {
			Object[] args = new Object[] { rule.getName() };

			FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
				Long.valueOf(1));
			FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, rule);
		}
		else {
			RuleModelImpl ruleModelImpl = (RuleModelImpl)rule;

			if ((ruleModelImpl.getColumnBitmask() &
					FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { rule.getName() };

				FinderCacheUtil.putResult(FINDER_PATH_COUNT_BY_NAME, args,
					Long.valueOf(1));
				FinderCacheUtil.putResult(FINDER_PATH_FETCH_BY_NAME, args, rule);
			}
		}
	}

	protected void clearUniqueFindersCache(Rule rule) {
		RuleModelImpl ruleModelImpl = (RuleModelImpl)rule;

		Object[] args = new Object[] { rule.getName() };

		FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
		FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);

		if ((ruleModelImpl.getColumnBitmask() &
				FINDER_PATH_FETCH_BY_NAME.getColumnBitmask()) != 0) {
			args = new Object[] { ruleModelImpl.getOriginalName() };

			FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_NAME, args);
			FinderCacheUtil.removeResult(FINDER_PATH_FETCH_BY_NAME, args);
		}
	}

	/**
	 * Creates a new rule with the primary key. Does not add the rule to the database.
	 *
	 * @param ruleId the primary key for the new rule
	 * @return the new rule
	 */
	@Override
	public Rule create(long ruleId) {
		Rule rule = new RuleImpl();

		rule.setNew(true);
		rule.setPrimaryKey(ruleId);

		return rule;
	}

	/**
	 * Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule remove(long ruleId) throws NoSuchRuleException, SystemException {
		return remove((Serializable)ruleId);
	}

	/**
	 * Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the rule
	 * @return the rule that was removed
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule remove(Serializable primaryKey)
		throws NoSuchRuleException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Rule rule = (Rule)session.get(RuleImpl.class, primaryKey);

			if (rule == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(rule);
		}
		catch (NoSuchRuleException nsee) {
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
	protected Rule removeImpl(Rule rule) throws SystemException {
		rule = toUnwrappedModel(rule);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(rule)) {
				rule = (Rule)session.get(RuleImpl.class, rule.getPrimaryKeyObj());
			}

			if (rule != null) {
				session.delete(rule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (rule != null) {
			clearCache(rule);
		}

		return rule;
	}

	@Override
	public Rule updateImpl(com.liferay.timetracking.dayoffs.model.Rule rule)
		throws SystemException {
		rule = toUnwrappedModel(rule);

		boolean isNew = rule.isNew();

		RuleModelImpl ruleModelImpl = (RuleModelImpl)rule;

		Session session = null;

		try {
			session = openSession();

			if (rule.isNew()) {
				session.save(rule);

				rule.setNew(false);
			}
			else {
				session.merge(rule);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !RuleModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((ruleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] { ruleModelImpl.getOriginalGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { ruleModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}

			if ((ruleModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLIER.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						ruleModelImpl.getOriginalMultiplier()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MULTIPLIER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLIER,
					args);

				args = new Object[] { ruleModelImpl.getMultiplier() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_MULTIPLIER,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_MULTIPLIER,
					args);
			}
		}

		EntityCacheUtil.putResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
			RuleImpl.class, rule.getPrimaryKey(), rule);

		clearUniqueFindersCache(rule);
		cacheUniqueFindersCache(rule);

		return rule;
	}

	protected Rule toUnwrappedModel(Rule rule) {
		if (rule instanceof RuleImpl) {
			return rule;
		}

		RuleImpl ruleImpl = new RuleImpl();

		ruleImpl.setNew(rule.isNew());
		ruleImpl.setPrimaryKey(rule.getPrimaryKey());

		ruleImpl.setRuleId(rule.getRuleId());
		ruleImpl.setGroupId(rule.getGroupId());
		ruleImpl.setCompanyId(rule.getCompanyId());
		ruleImpl.setUserId(rule.getUserId());
		ruleImpl.setUserName(rule.getUserName());
		ruleImpl.setCreateDate(rule.getCreateDate());
		ruleImpl.setModifiedDate(rule.getModifiedDate());
		ruleImpl.setName(rule.getName());
		ruleImpl.setMultiplier(rule.getMultiplier());

		return ruleImpl;
	}

	/**
	 * Returns the rule with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule
	 * @return the rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule findByPrimaryKey(Serializable primaryKey)
		throws NoSuchRuleException, SystemException {
		Rule rule = fetchByPrimaryKey(primaryKey);

		if (rule == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchRuleException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return rule;
	}

	/**
	 * Returns the rule with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRuleException} if it could not be found.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule
	 * @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule findByPrimaryKey(long ruleId)
		throws NoSuchRuleException, SystemException {
		return findByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns the rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the rule
	 * @return the rule, or <code>null</code> if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Rule rule = (Rule)EntityCacheUtil.getResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
				RuleImpl.class, primaryKey);

		if (rule == _nullRule) {
			return null;
		}

		if (rule == null) {
			Session session = null;

			try {
				session = openSession();

				rule = (Rule)session.get(RuleImpl.class, primaryKey);

				if (rule != null) {
					cacheResult(rule);
				}
				else {
					EntityCacheUtil.putResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
						RuleImpl.class, primaryKey, _nullRule);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(RuleModelImpl.ENTITY_CACHE_ENABLED,
					RuleImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return rule;
	}

	/**
	 * Returns the rule with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param ruleId the primary key of the rule
	 * @return the rule, or <code>null</code> if a rule with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Rule fetchByPrimaryKey(long ruleId) throws SystemException {
		return fetchByPrimaryKey((Serializable)ruleId);
	}

	/**
	 * Returns all the rules.
	 *
	 * @return the rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @return the range of rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the rules.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.dayoffs.model.impl.RuleModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of rules
	 * @param end the upper bound of the range of rules (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of rules
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Rule> findAll(int start, int end,
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

		List<Rule> list = (List<Rule>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_RULE);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_RULE;

				if (pagination) {
					sql = sql.concat(RuleModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
							end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Rule>(list);
				}
				else {
					list = (List<Rule>)QueryUtil.list(q, getDialect(), start,
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
	 * Removes all the rules from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Rule rule : findAll()) {
			remove(rule);
		}
	}

	/**
	 * Returns the number of rules.
	 *
	 * @return the number of rules
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

				Query q = session.createQuery(_SQL_COUNT_RULE);

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
	 * Initializes the rule persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.dayoffs.model.Rule")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Rule>> listenersList = new ArrayList<ModelListener<Rule>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Rule>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(RuleImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_RULE = "SELECT rule FROM Rule rule";
	private static final String _SQL_SELECT_RULE_WHERE = "SELECT rule FROM Rule rule WHERE ";
	private static final String _SQL_COUNT_RULE = "SELECT COUNT(rule) FROM Rule rule";
	private static final String _SQL_COUNT_RULE_WHERE = "SELECT COUNT(rule) FROM Rule rule WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "rule.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Rule exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Rule exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(RulePersistenceImpl.class);
	private static Rule _nullRule = new RuleImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Rule> toCacheModel() {
				return _nullRuleCacheModel;
			}
		};

	private static CacheModel<Rule> _nullRuleCacheModel = new CacheModel<Rule>() {
			@Override
			public Rule toEntityModel() {
				return _nullRule;
			}
		};
}