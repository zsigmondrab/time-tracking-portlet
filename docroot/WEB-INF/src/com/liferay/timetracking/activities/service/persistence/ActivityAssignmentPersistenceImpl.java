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

import com.liferay.timetracking.activities.NoSuchActivityAssignmentException;
import com.liferay.timetracking.activities.model.ActivityAssignment;
import com.liferay.timetracking.activities.model.impl.ActivityAssignmentImpl;
import com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the activity assignment service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityAssignmentPersistence
 * @see ActivityAssignmentUtil
 * @generated
 */
public class ActivityAssignmentPersistenceImpl extends BasePersistenceImpl<ActivityAssignment>
	implements ActivityAssignmentPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ActivityAssignmentUtil} to access the activity assignment persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ActivityAssignmentImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentModelImpl.FINDER_CACHE_ENABLED,
			ActivityAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentModelImpl.FINDER_CACHE_ENABLED,
			ActivityAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentModelImpl.FINDER_CACHE_ENABLED,
			ActivityAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByCompanyId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID =
		new FinderPath(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentModelImpl.FINDER_CACHE_ENABLED,
			ActivityAssignmentImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByCompanyId",
			new String[] { Long.class.getName() },
			ActivityAssignmentModelImpl.COMPANYID_COLUMN_BITMASK |
			ActivityAssignmentModelImpl.STARTTIME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_COMPANYID = new FinderPath(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByCompanyId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the activity assignments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the matching activity assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActivityAssignment> findByCompanyId(long companyId)
		throws SystemException {
		return findByCompanyId(companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS,
			null);
	}

	/**
	 * Returns a range of all the activity assignments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity assignments
	 * @param end the upper bound of the range of activity assignments (not inclusive)
	 * @return the range of matching activity assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActivityAssignment> findByCompanyId(long companyId, int start,
		int end) throws SystemException {
		return findByCompanyId(companyId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activity assignments where companyId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityAssignmentModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param companyId the company ID
	 * @param start the lower bound of the range of activity assignments
	 * @param end the upper bound of the range of activity assignments (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activity assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActivityAssignment> findByCompanyId(long companyId, int start,
		int end, OrderByComparator orderByComparator) throws SystemException {
		boolean pagination = true;
		FinderPath finderPath = null;
		Object[] finderArgs = null;

		if ((start == QueryUtil.ALL_POS) && (end == QueryUtil.ALL_POS) &&
				(orderByComparator == null)) {
			pagination = false;
			finderPath = FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId };
		}
		else {
			finderPath = FINDER_PATH_WITH_PAGINATION_FIND_BY_COMPANYID;
			finderArgs = new Object[] { companyId, start, end, orderByComparator };
		}

		List<ActivityAssignment> list = (List<ActivityAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (ActivityAssignment activityAssignment : list) {
				if ((companyId != activityAssignment.getCompanyId())) {
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

			query.append(_SQL_SELECT_ACTIVITYASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActivityAssignmentModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

				if (!pagination) {
					list = (List<ActivityAssignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ActivityAssignment>(list);
				}
				else {
					list = (List<ActivityAssignment>)QueryUtil.list(q,
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
	 * Returns the first activity assignment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity assignment
	 * @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a matching activity assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment findByCompanyId_First(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchActivityAssignmentException, SystemException {
		ActivityAssignment activityAssignment = fetchByCompanyId_First(companyId,
				orderByComparator);

		if (activityAssignment != null) {
			return activityAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchActivityAssignmentException(msg.toString());
	}

	/**
	 * Returns the first activity assignment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity assignment, or <code>null</code> if a matching activity assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment fetchByCompanyId_First(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		List<ActivityAssignment> list = findByCompanyId(companyId, 0, 1,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity assignment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity assignment
	 * @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a matching activity assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment findByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchActivityAssignmentException, SystemException {
		ActivityAssignment activityAssignment = fetchByCompanyId_Last(companyId,
				orderByComparator);

		if (activityAssignment != null) {
			return activityAssignment;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("companyId=");
		msg.append(companyId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchActivityAssignmentException(msg.toString());
	}

	/**
	 * Returns the last activity assignment in the ordered set where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity assignment, or <code>null</code> if a matching activity assignment could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment fetchByCompanyId_Last(long companyId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByCompanyId(companyId);

		if (count == 0) {
			return null;
		}

		List<ActivityAssignment> list = findByCompanyId(companyId, count - 1,
				count, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activity assignments before and after the current activity assignment in the ordered set where companyId = &#63;.
	 *
	 * @param activityAssignmentId the primary key of the current activity assignment
	 * @param companyId the company ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity assignment
	 * @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment[] findByCompanyId_PrevAndNext(
		long activityAssignmentId, long companyId,
		OrderByComparator orderByComparator)
		throws NoSuchActivityAssignmentException, SystemException {
		ActivityAssignment activityAssignment = findByPrimaryKey(activityAssignmentId);

		Session session = null;

		try {
			session = openSession();

			ActivityAssignment[] array = new ActivityAssignmentImpl[3];

			array[0] = getByCompanyId_PrevAndNext(session, activityAssignment,
					companyId, orderByComparator, true);

			array[1] = activityAssignment;

			array[2] = getByCompanyId_PrevAndNext(session, activityAssignment,
					companyId, orderByComparator, false);

			return array;
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}
	}

	protected ActivityAssignment getByCompanyId_PrevAndNext(Session session,
		ActivityAssignment activityAssignment, long companyId,
		OrderByComparator orderByComparator, boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTIVITYASSIGNMENT_WHERE);

		query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

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
			query.append(ActivityAssignmentModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(companyId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(activityAssignment);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<ActivityAssignment> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activity assignments where companyId = &#63; from the database.
	 *
	 * @param companyId the company ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByCompanyId(long companyId) throws SystemException {
		for (ActivityAssignment activityAssignment : findByCompanyId(
				companyId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null)) {
			remove(activityAssignment);
		}
	}

	/**
	 * Returns the number of activity assignments where companyId = &#63;.
	 *
	 * @param companyId the company ID
	 * @return the number of matching activity assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public int countByCompanyId(long companyId) throws SystemException {
		FinderPath finderPath = FINDER_PATH_COUNT_BY_COMPANYID;

		Object[] finderArgs = new Object[] { companyId };

		Long count = (Long)FinderCacheUtil.getResult(finderPath, finderArgs,
				this);

		if (count == null) {
			StringBundler query = new StringBundler(2);

			query.append(_SQL_COUNT_ACTIVITYASSIGNMENT_WHERE);

			query.append(_FINDER_COLUMN_COMPANYID_COMPANYID_2);

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(companyId);

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

	private static final String _FINDER_COLUMN_COMPANYID_COMPANYID_2 = "activityAssignment.companyId = ?";

	public ActivityAssignmentPersistenceImpl() {
		setModelClass(ActivityAssignment.class);
	}

	/**
	 * Caches the activity assignment in the entity cache if it is enabled.
	 *
	 * @param activityAssignment the activity assignment
	 */
	@Override
	public void cacheResult(ActivityAssignment activityAssignment) {
		EntityCacheUtil.putResult(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentImpl.class, activityAssignment.getPrimaryKey(),
			activityAssignment);

		activityAssignment.resetOriginalValues();
	}

	/**
	 * Caches the activity assignments in the entity cache if it is enabled.
	 *
	 * @param activityAssignments the activity assignments
	 */
	@Override
	public void cacheResult(List<ActivityAssignment> activityAssignments) {
		for (ActivityAssignment activityAssignment : activityAssignments) {
			if (EntityCacheUtil.getResult(
						ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						ActivityAssignmentImpl.class,
						activityAssignment.getPrimaryKey()) == null) {
				cacheResult(activityAssignment);
			}
			else {
				activityAssignment.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all activity assignments.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ActivityAssignmentImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ActivityAssignmentImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the activity assignment.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(ActivityAssignment activityAssignment) {
		EntityCacheUtil.removeResult(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentImpl.class, activityAssignment.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<ActivityAssignment> activityAssignments) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (ActivityAssignment activityAssignment : activityAssignments) {
			EntityCacheUtil.removeResult(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				ActivityAssignmentImpl.class, activityAssignment.getPrimaryKey());
		}
	}

	/**
	 * Creates a new activity assignment with the primary key. Does not add the activity assignment to the database.
	 *
	 * @param activityAssignmentId the primary key for the new activity assignment
	 * @return the new activity assignment
	 */
	@Override
	public ActivityAssignment create(long activityAssignmentId) {
		ActivityAssignment activityAssignment = new ActivityAssignmentImpl();

		activityAssignment.setNew(true);
		activityAssignment.setPrimaryKey(activityAssignmentId);

		return activityAssignment;
	}

	/**
	 * Removes the activity assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityAssignmentId the primary key of the activity assignment
	 * @return the activity assignment that was removed
	 * @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment remove(long activityAssignmentId)
		throws NoSuchActivityAssignmentException, SystemException {
		return remove((Serializable)activityAssignmentId);
	}

	/**
	 * Removes the activity assignment with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity assignment
	 * @return the activity assignment that was removed
	 * @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment remove(Serializable primaryKey)
		throws NoSuchActivityAssignmentException, SystemException {
		Session session = null;

		try {
			session = openSession();

			ActivityAssignment activityAssignment = (ActivityAssignment)session.get(ActivityAssignmentImpl.class,
					primaryKey);

			if (activityAssignment == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(activityAssignment);
		}
		catch (NoSuchActivityAssignmentException nsee) {
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
	protected ActivityAssignment removeImpl(
		ActivityAssignment activityAssignment) throws SystemException {
		activityAssignment = toUnwrappedModel(activityAssignment);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activityAssignment)) {
				activityAssignment = (ActivityAssignment)session.get(ActivityAssignmentImpl.class,
						activityAssignment.getPrimaryKeyObj());
			}

			if (activityAssignment != null) {
				session.delete(activityAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (activityAssignment != null) {
			clearCache(activityAssignment);
		}

		return activityAssignment;
	}

	@Override
	public ActivityAssignment updateImpl(
		com.liferay.timetracking.activities.model.ActivityAssignment activityAssignment)
		throws SystemException {
		activityAssignment = toUnwrappedModel(activityAssignment);

		boolean isNew = activityAssignment.isNew();

		ActivityAssignmentModelImpl activityAssignmentModelImpl = (ActivityAssignmentModelImpl)activityAssignment;

		Session session = null;

		try {
			session = openSession();

			if (activityAssignment.isNew()) {
				session.save(activityAssignment);

				activityAssignment.setNew(false);
			}
			else {
				session.merge(activityAssignment);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ActivityAssignmentModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((activityAssignmentModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						activityAssignmentModelImpl.getOriginalCompanyId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);

				args = new Object[] { activityAssignmentModelImpl.getCompanyId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_COMPANYID,
					args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_COMPANYID,
					args);
			}
		}

		EntityCacheUtil.putResult(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
			ActivityAssignmentImpl.class, activityAssignment.getPrimaryKey(),
			activityAssignment);

		return activityAssignment;
	}

	protected ActivityAssignment toUnwrappedModel(
		ActivityAssignment activityAssignment) {
		if (activityAssignment instanceof ActivityAssignmentImpl) {
			return activityAssignment;
		}

		ActivityAssignmentImpl activityAssignmentImpl = new ActivityAssignmentImpl();

		activityAssignmentImpl.setNew(activityAssignment.isNew());
		activityAssignmentImpl.setPrimaryKey(activityAssignment.getPrimaryKey());

		activityAssignmentImpl.setActivityAssignmentId(activityAssignment.getActivityAssignmentId());
		activityAssignmentImpl.setCompanyId(activityAssignment.getCompanyId());
		activityAssignmentImpl.setUserId(activityAssignment.getUserId());
		activityAssignmentImpl.setUserName(activityAssignment.getUserName());
		activityAssignmentImpl.setCreateDate(activityAssignment.getCreateDate());
		activityAssignmentImpl.setModifiedDate(activityAssignment.getModifiedDate());
		activityAssignmentImpl.setActivityId(activityAssignment.getActivityId());
		activityAssignmentImpl.setWorkDayId(activityAssignment.getWorkDayId());
		activityAssignmentImpl.setStartTime(activityAssignment.getStartTime());
		activityAssignmentImpl.setEndTime(activityAssignment.getEndTime());

		return activityAssignmentImpl;
	}

	/**
	 * Returns the activity assignment with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity assignment
	 * @return the activity assignment
	 * @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityAssignmentException, SystemException {
		ActivityAssignment activityAssignment = fetchByPrimaryKey(primaryKey);

		if (activityAssignment == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityAssignmentException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return activityAssignment;
	}

	/**
	 * Returns the activity assignment with the primary key or throws a {@link com.liferay.timetracking.activities.NoSuchActivityAssignmentException} if it could not be found.
	 *
	 * @param activityAssignmentId the primary key of the activity assignment
	 * @return the activity assignment
	 * @throws com.liferay.timetracking.activities.NoSuchActivityAssignmentException if a activity assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment findByPrimaryKey(long activityAssignmentId)
		throws NoSuchActivityAssignmentException, SystemException {
		return findByPrimaryKey((Serializable)activityAssignmentId);
	}

	/**
	 * Returns the activity assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity assignment
	 * @return the activity assignment, or <code>null</code> if a activity assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		ActivityAssignment activityAssignment = (ActivityAssignment)EntityCacheUtil.getResult(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
				ActivityAssignmentImpl.class, primaryKey);

		if (activityAssignment == _nullActivityAssignment) {
			return null;
		}

		if (activityAssignment == null) {
			Session session = null;

			try {
				session = openSession();

				activityAssignment = (ActivityAssignment)session.get(ActivityAssignmentImpl.class,
						primaryKey);

				if (activityAssignment != null) {
					cacheResult(activityAssignment);
				}
				else {
					EntityCacheUtil.putResult(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
						ActivityAssignmentImpl.class, primaryKey,
						_nullActivityAssignment);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ActivityAssignmentModelImpl.ENTITY_CACHE_ENABLED,
					ActivityAssignmentImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return activityAssignment;
	}

	/**
	 * Returns the activity assignment with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityAssignmentId the primary key of the activity assignment
	 * @return the activity assignment, or <code>null</code> if a activity assignment with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public ActivityAssignment fetchByPrimaryKey(long activityAssignmentId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)activityAssignmentId);
	}

	/**
	 * Returns all the activity assignments.
	 *
	 * @return the activity assignments
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<ActivityAssignment> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

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
	@Override
	public List<ActivityAssignment> findAll(int start, int end)
		throws SystemException {
		return findAll(start, end, null);
	}

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
	@Override
	public List<ActivityAssignment> findAll(int start, int end,
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

		List<ActivityAssignment> list = (List<ActivityAssignment>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACTIVITYASSIGNMENT);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITYASSIGNMENT;

				if (pagination) {
					sql = sql.concat(ActivityAssignmentModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<ActivityAssignment>)QueryUtil.list(q,
							getDialect(), start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<ActivityAssignment>(list);
				}
				else {
					list = (List<ActivityAssignment>)QueryUtil.list(q,
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
	 * Removes all the activity assignments from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (ActivityAssignment activityAssignment : findAll()) {
			remove(activityAssignment);
		}
	}

	/**
	 * Returns the number of activity assignments.
	 *
	 * @return the number of activity assignments
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

				Query q = session.createQuery(_SQL_COUNT_ACTIVITYASSIGNMENT);

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
	 * Initializes the activity assignment persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.activities.model.ActivityAssignment")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<ActivityAssignment>> listenersList = new ArrayList<ModelListener<ActivityAssignment>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<ActivityAssignment>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ActivityAssignmentImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACTIVITYASSIGNMENT = "SELECT activityAssignment FROM ActivityAssignment activityAssignment";
	private static final String _SQL_SELECT_ACTIVITYASSIGNMENT_WHERE = "SELECT activityAssignment FROM ActivityAssignment activityAssignment WHERE ";
	private static final String _SQL_COUNT_ACTIVITYASSIGNMENT = "SELECT COUNT(activityAssignment) FROM ActivityAssignment activityAssignment";
	private static final String _SQL_COUNT_ACTIVITYASSIGNMENT_WHERE = "SELECT COUNT(activityAssignment) FROM ActivityAssignment activityAssignment WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "activityAssignment.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No ActivityAssignment exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No ActivityAssignment exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ActivityAssignmentPersistenceImpl.class);
	private static ActivityAssignment _nullActivityAssignment = new ActivityAssignmentImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<ActivityAssignment> toCacheModel() {
				return _nullActivityAssignmentCacheModel;
			}
		};

	private static CacheModel<ActivityAssignment> _nullActivityAssignmentCacheModel =
		new CacheModel<ActivityAssignment>() {
			@Override
			public ActivityAssignment toEntityModel() {
				return _nullActivityAssignment;
			}
		};
}