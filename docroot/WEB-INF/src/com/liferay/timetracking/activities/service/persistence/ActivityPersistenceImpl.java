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

import com.liferay.timetracking.activities.NoSuchActivityException;
import com.liferay.timetracking.activities.model.Activity;
import com.liferay.timetracking.activities.model.impl.ActivityImpl;
import com.liferay.timetracking.activities.model.impl.ActivityModelImpl;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * The persistence implementation for the activity service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityPersistence
 * @see ActivityUtil
 * @generated
 */
public class ActivityPersistenceImpl extends BasePersistenceImpl<Activity>
	implements ActivityPersistence {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link ActivityUtil} to access the activity persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this class.
	 */
	public static final String FINDER_CLASS_NAME_ENTITY = ActivityImpl.class.getName();
	public static final String FINDER_CLASS_NAME_LIST_WITH_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List1";
	public static final String FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION = FINDER_CLASS_NAME_ENTITY +
		".List2";
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_ALL = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_ALL = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findAll", new String[0]);
	public static final FinderPath FINDER_PATH_COUNT_ALL = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countAll", new String[0]);
	public static final FinderPath FINDER_PATH_WITH_PAGINATION_FIND_BY_GROUPID = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITH_PAGINATION, "findByGroupId",
			new String[] {
				Long.class.getName(),
				
			Integer.class.getName(), Integer.class.getName(),
				OrderByComparator.class.getName()
			});
	public static final FinderPath FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID =
		new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, ActivityImpl.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "findByGroupId",
			new String[] { Long.class.getName() },
			ActivityModelImpl.GROUPID_COLUMN_BITMASK |
			ActivityModelImpl.NAME_COLUMN_BITMASK);
	public static final FinderPath FINDER_PATH_COUNT_BY_GROUPID = new FinderPath(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityModelImpl.FINDER_CACHE_ENABLED, Long.class,
			FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION, "countByGroupId",
			new String[] { Long.class.getName() });

	/**
	 * Returns all the activities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the matching activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Activity> findByGroupId(long groupId) throws SystemException {
		return findByGroupId(groupId, QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of matching activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Activity> findByGroupId(long groupId, int start, int end)
		throws SystemException {
		return findByGroupId(groupId, start, end, null);
	}

	/**
	 * Returns an ordered range of all the activities where groupId = &#63;.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param groupId the group ID
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of matching activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Activity> findByGroupId(long groupId, int start, int end,
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

		List<Activity> list = (List<Activity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if ((list != null) && !list.isEmpty()) {
			for (Activity activity : list) {
				if ((groupId != activity.getGroupId())) {
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

			query.append(_SQL_SELECT_ACTIVITY_WHERE);

			query.append(_FINDER_COLUMN_GROUPID_GROUPID_2);

			if (orderByComparator != null) {
				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);
			}
			else
			 if (pagination) {
				query.append(ActivityModelImpl.ORDER_BY_JPQL);
			}

			String sql = query.toString();

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				QueryPos qPos = QueryPos.getInstance(q);

				qPos.add(groupId);

				if (!pagination) {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Activity>(list);
				}
				else {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
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
	 * Returns the first activity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity
	 * @throws com.liferay.timetracking.activities.NoSuchActivityException if a matching activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity findByGroupId_First(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchActivityException, SystemException {
		Activity activity = fetchByGroupId_First(groupId, orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchActivityException(msg.toString());
	}

	/**
	 * Returns the first activity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the first matching activity, or <code>null</code> if a matching activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity fetchByGroupId_First(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		List<Activity> list = findByGroupId(groupId, 0, 1, orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the last activity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity
	 * @throws com.liferay.timetracking.activities.NoSuchActivityException if a matching activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity findByGroupId_Last(long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchActivityException, SystemException {
		Activity activity = fetchByGroupId_Last(groupId, orderByComparator);

		if (activity != null) {
			return activity;
		}

		StringBundler msg = new StringBundler(4);

		msg.append(_NO_SUCH_ENTITY_WITH_KEY);

		msg.append("groupId=");
		msg.append(groupId);

		msg.append(StringPool.CLOSE_CURLY_BRACE);

		throw new NoSuchActivityException(msg.toString());
	}

	/**
	 * Returns the last activity in the ordered set where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the last matching activity, or <code>null</code> if a matching activity could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity fetchByGroupId_Last(long groupId,
		OrderByComparator orderByComparator) throws SystemException {
		int count = countByGroupId(groupId);

		if (count == 0) {
			return null;
		}

		List<Activity> list = findByGroupId(groupId, count - 1, count,
				orderByComparator);

		if (!list.isEmpty()) {
			return list.get(0);
		}

		return null;
	}

	/**
	 * Returns the activities before and after the current activity in the ordered set where groupId = &#63;.
	 *
	 * @param activityId the primary key of the current activity
	 * @param groupId the group ID
	 * @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	 * @return the previous, current, and next activity
	 * @throws com.liferay.timetracking.activities.NoSuchActivityException if a activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity[] findByGroupId_PrevAndNext(long activityId, long groupId,
		OrderByComparator orderByComparator)
		throws NoSuchActivityException, SystemException {
		Activity activity = findByPrimaryKey(activityId);

		Session session = null;

		try {
			session = openSession();

			Activity[] array = new ActivityImpl[3];

			array[0] = getByGroupId_PrevAndNext(session, activity, groupId,
					orderByComparator, true);

			array[1] = activity;

			array[2] = getByGroupId_PrevAndNext(session, activity, groupId,
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

	protected Activity getByGroupId_PrevAndNext(Session session,
		Activity activity, long groupId, OrderByComparator orderByComparator,
		boolean previous) {
		StringBundler query = null;

		if (orderByComparator != null) {
			query = new StringBundler(6 +
					(orderByComparator.getOrderByFields().length * 6));
		}
		else {
			query = new StringBundler(3);
		}

		query.append(_SQL_SELECT_ACTIVITY_WHERE);

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
			query.append(ActivityModelImpl.ORDER_BY_JPQL);
		}

		String sql = query.toString();

		Query q = session.createQuery(sql);

		q.setFirstResult(0);
		q.setMaxResults(2);

		QueryPos qPos = QueryPos.getInstance(q);

		qPos.add(groupId);

		if (orderByComparator != null) {
			Object[] values = orderByComparator.getOrderByConditionValues(activity);

			for (Object value : values) {
				qPos.add(value);
			}
		}

		List<Activity> list = q.list();

		if (list.size() == 2) {
			return list.get(1);
		}
		else {
			return null;
		}
	}

	/**
	 * Removes all the activities where groupId = &#63; from the database.
	 *
	 * @param groupId the group ID
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeByGroupId(long groupId) throws SystemException {
		for (Activity activity : findByGroupId(groupId, QueryUtil.ALL_POS,
				QueryUtil.ALL_POS, null)) {
			remove(activity);
		}
	}

	/**
	 * Returns the number of activities where groupId = &#63;.
	 *
	 * @param groupId the group ID
	 * @return the number of matching activities
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

			query.append(_SQL_COUNT_ACTIVITY_WHERE);

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

	private static final String _FINDER_COLUMN_GROUPID_GROUPID_2 = "activity.groupId = ?";

	public ActivityPersistenceImpl() {
		setModelClass(Activity.class);
	}

	/**
	 * Caches the activity in the entity cache if it is enabled.
	 *
	 * @param activity the activity
	 */
	@Override
	public void cacheResult(Activity activity) {
		EntityCacheUtil.putResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityImpl.class, activity.getPrimaryKey(), activity);

		activity.resetOriginalValues();
	}

	/**
	 * Caches the activities in the entity cache if it is enabled.
	 *
	 * @param activities the activities
	 */
	@Override
	public void cacheResult(List<Activity> activities) {
		for (Activity activity : activities) {
			if (EntityCacheUtil.getResult(
						ActivityModelImpl.ENTITY_CACHE_ENABLED,
						ActivityImpl.class, activity.getPrimaryKey()) == null) {
				cacheResult(activity);
			}
			else {
				activity.resetOriginalValues();
			}
		}
	}

	/**
	 * Clears the cache for all activities.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache() {
		if (_HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE) {
			CacheRegistryUtil.clear(ActivityImpl.class.getName());
		}

		EntityCacheUtil.clearCache(ActivityImpl.class.getName());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	/**
	 * Clears the cache for the activity.
	 *
	 * <p>
	 * The {@link com.liferay.portal.kernel.dao.orm.EntityCache} and {@link com.liferay.portal.kernel.dao.orm.FinderCache} are both cleared by this method.
	 * </p>
	 */
	@Override
	public void clearCache(Activity activity) {
		EntityCacheUtil.removeResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityImpl.class, activity.getPrimaryKey());

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	@Override
	public void clearCache(List<Activity> activities) {
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);

		for (Activity activity : activities) {
			EntityCacheUtil.removeResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
				ActivityImpl.class, activity.getPrimaryKey());
		}
	}

	/**
	 * Creates a new activity with the primary key. Does not add the activity to the database.
	 *
	 * @param activityId the primary key for the new activity
	 * @return the new activity
	 */
	@Override
	public Activity create(long activityId) {
		Activity activity = new ActivityImpl();

		activity.setNew(true);
		activity.setPrimaryKey(activityId);

		return activity;
	}

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity that was removed
	 * @throws com.liferay.timetracking.activities.NoSuchActivityException if a activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity remove(long activityId)
		throws NoSuchActivityException, SystemException {
		return remove((Serializable)activityId);
	}

	/**
	 * Removes the activity with the primary key from the database. Also notifies the appropriate model listeners.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity that was removed
	 * @throws com.liferay.timetracking.activities.NoSuchActivityException if a activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity remove(Serializable primaryKey)
		throws NoSuchActivityException, SystemException {
		Session session = null;

		try {
			session = openSession();

			Activity activity = (Activity)session.get(ActivityImpl.class,
					primaryKey);

			if (activity == null) {
				if (_log.isWarnEnabled()) {
					_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
				}

				throw new NoSuchActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
					primaryKey);
			}

			return remove(activity);
		}
		catch (NoSuchActivityException nsee) {
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
	protected Activity removeImpl(Activity activity) throws SystemException {
		activity = toUnwrappedModel(activity);

		Session session = null;

		try {
			session = openSession();

			if (!session.contains(activity)) {
				activity = (Activity)session.get(ActivityImpl.class,
						activity.getPrimaryKeyObj());
			}

			if (activity != null) {
				session.delete(activity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		if (activity != null) {
			clearCache(activity);
		}

		return activity;
	}

	@Override
	public Activity updateImpl(
		com.liferay.timetracking.activities.model.Activity activity)
		throws SystemException {
		activity = toUnwrappedModel(activity);

		boolean isNew = activity.isNew();

		ActivityModelImpl activityModelImpl = (ActivityModelImpl)activity;

		Session session = null;

		try {
			session = openSession();

			if (activity.isNew()) {
				session.save(activity);

				activity.setNew(false);
			}
			else {
				session.merge(activity);
			}
		}
		catch (Exception e) {
			throw processException(e);
		}
		finally {
			closeSession(session);
		}

		FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);

		if (isNew || !ActivityModelImpl.COLUMN_BITMASK_ENABLED) {
			FinderCacheUtil.clearCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
		}

		else {
			if ((activityModelImpl.getColumnBitmask() &
					FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID.getColumnBitmask()) != 0) {
				Object[] args = new Object[] {
						activityModelImpl.getOriginalGroupId()
					};

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);

				args = new Object[] { activityModelImpl.getGroupId() };

				FinderCacheUtil.removeResult(FINDER_PATH_COUNT_BY_GROUPID, args);
				FinderCacheUtil.removeResult(FINDER_PATH_WITHOUT_PAGINATION_FIND_BY_GROUPID,
					args);
			}
		}

		EntityCacheUtil.putResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
			ActivityImpl.class, activity.getPrimaryKey(), activity);

		return activity;
	}

	protected Activity toUnwrappedModel(Activity activity) {
		if (activity instanceof ActivityImpl) {
			return activity;
		}

		ActivityImpl activityImpl = new ActivityImpl();

		activityImpl.setNew(activity.isNew());
		activityImpl.setPrimaryKey(activity.getPrimaryKey());

		activityImpl.setActivityId(activity.getActivityId());
		activityImpl.setGroupId(activity.getGroupId());
		activityImpl.setCompanyId(activity.getCompanyId());
		activityImpl.setUserId(activity.getUserId());
		activityImpl.setUserName(activity.getUserName());
		activityImpl.setCreateDate(activity.getCreateDate());
		activityImpl.setModifiedDate(activity.getModifiedDate());
		activityImpl.setName(activity.getName());

		return activityImpl;
	}

	/**
	 * Returns the activity with the primary key or throws a {@link com.liferay.portal.NoSuchModelException} if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity
	 * @throws com.liferay.timetracking.activities.NoSuchActivityException if a activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity findByPrimaryKey(Serializable primaryKey)
		throws NoSuchActivityException, SystemException {
		Activity activity = fetchByPrimaryKey(primaryKey);

		if (activity == null) {
			if (_log.isWarnEnabled()) {
				_log.warn(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY + primaryKey);
			}

			throw new NoSuchActivityException(_NO_SUCH_ENTITY_WITH_PRIMARY_KEY +
				primaryKey);
		}

		return activity;
	}

	/**
	 * Returns the activity with the primary key or throws a {@link com.liferay.timetracking.activities.NoSuchActivityException} if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity
	 * @throws com.liferay.timetracking.activities.NoSuchActivityException if a activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity findByPrimaryKey(long activityId)
		throws NoSuchActivityException, SystemException {
		return findByPrimaryKey((Serializable)activityId);
	}

	/**
	 * Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param primaryKey the primary key of the activity
	 * @return the activity, or <code>null</code> if a activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity fetchByPrimaryKey(Serializable primaryKey)
		throws SystemException {
		Activity activity = (Activity)EntityCacheUtil.getResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
				ActivityImpl.class, primaryKey);

		if (activity == _nullActivity) {
			return null;
		}

		if (activity == null) {
			Session session = null;

			try {
				session = openSession();

				activity = (Activity)session.get(ActivityImpl.class, primaryKey);

				if (activity != null) {
					cacheResult(activity);
				}
				else {
					EntityCacheUtil.putResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
						ActivityImpl.class, primaryKey, _nullActivity);
				}
			}
			catch (Exception e) {
				EntityCacheUtil.removeResult(ActivityModelImpl.ENTITY_CACHE_ENABLED,
					ActivityImpl.class, primaryKey);

				throw processException(e);
			}
			finally {
				closeSession(session);
			}
		}

		return activity;
	}

	/**
	 * Returns the activity with the primary key or returns <code>null</code> if it could not be found.
	 *
	 * @param activityId the primary key of the activity
	 * @return the activity, or <code>null</code> if a activity with the primary key could not be found
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public Activity fetchByPrimaryKey(long activityId)
		throws SystemException {
		return fetchByPrimaryKey((Serializable)activityId);
	}

	/**
	 * Returns all the activities.
	 *
	 * @return the activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Activity> findAll() throws SystemException {
		return findAll(QueryUtil.ALL_POS, QueryUtil.ALL_POS, null);
	}

	/**
	 * Returns a range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @return the range of activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Activity> findAll(int start, int end) throws SystemException {
		return findAll(start, end, null);
	}

	/**
	 * Returns an ordered range of all the activities.
	 *
	 * <p>
	 * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link com.liferay.timetracking.activities.model.impl.ActivityModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
	 * </p>
	 *
	 * @param start the lower bound of the range of activities
	 * @param end the upper bound of the range of activities (not inclusive)
	 * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
	 * @return the ordered range of activities
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public List<Activity> findAll(int start, int end,
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

		List<Activity> list = (List<Activity>)FinderCacheUtil.getResult(finderPath,
				finderArgs, this);

		if (list == null) {
			StringBundler query = null;
			String sql = null;

			if (orderByComparator != null) {
				query = new StringBundler(2 +
						(orderByComparator.getOrderByFields().length * 3));

				query.append(_SQL_SELECT_ACTIVITY);

				appendOrderByComparator(query, _ORDER_BY_ENTITY_ALIAS,
					orderByComparator);

				sql = query.toString();
			}
			else {
				sql = _SQL_SELECT_ACTIVITY;

				if (pagination) {
					sql = sql.concat(ActivityModelImpl.ORDER_BY_JPQL);
				}
			}

			Session session = null;

			try {
				session = openSession();

				Query q = session.createQuery(sql);

				if (!pagination) {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
							start, end, false);

					Collections.sort(list);

					list = new UnmodifiableList<Activity>(list);
				}
				else {
					list = (List<Activity>)QueryUtil.list(q, getDialect(),
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
	 * Removes all the activities from the database.
	 *
	 * @throws SystemException if a system exception occurred
	 */
	@Override
	public void removeAll() throws SystemException {
		for (Activity activity : findAll()) {
			remove(activity);
		}
	}

	/**
	 * Returns the number of activities.
	 *
	 * @return the number of activities
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

				Query q = session.createQuery(_SQL_COUNT_ACTIVITY);

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
	 * Initializes the activity persistence.
	 */
	public void afterPropertiesSet() {
		String[] listenerClassNames = StringUtil.split(GetterUtil.getString(
					com.liferay.util.service.ServiceProps.get(
						"value.object.listener.com.liferay.timetracking.activities.model.Activity")));

		if (listenerClassNames.length > 0) {
			try {
				List<ModelListener<Activity>> listenersList = new ArrayList<ModelListener<Activity>>();

				for (String listenerClassName : listenerClassNames) {
					listenersList.add((ModelListener<Activity>)InstanceFactory.newInstance(
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
		EntityCacheUtil.removeCache(ActivityImpl.class.getName());
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_ENTITY);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITH_PAGINATION);
		FinderCacheUtil.removeCache(FINDER_CLASS_NAME_LIST_WITHOUT_PAGINATION);
	}

	private static final String _SQL_SELECT_ACTIVITY = "SELECT activity FROM Activity activity";
	private static final String _SQL_SELECT_ACTIVITY_WHERE = "SELECT activity FROM Activity activity WHERE ";
	private static final String _SQL_COUNT_ACTIVITY = "SELECT COUNT(activity) FROM Activity activity";
	private static final String _SQL_COUNT_ACTIVITY_WHERE = "SELECT COUNT(activity) FROM Activity activity WHERE ";
	private static final String _ORDER_BY_ENTITY_ALIAS = "activity.";
	private static final String _NO_SUCH_ENTITY_WITH_PRIMARY_KEY = "No Activity exists with the primary key ";
	private static final String _NO_SUCH_ENTITY_WITH_KEY = "No Activity exists with the key {";
	private static final boolean _HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE = GetterUtil.getBoolean(PropsUtil.get(
				PropsKeys.HIBERNATE_CACHE_USE_SECOND_LEVEL_CACHE));
	private static Log _log = LogFactoryUtil.getLog(ActivityPersistenceImpl.class);
	private static Activity _nullActivity = new ActivityImpl() {
			@Override
			public Object clone() {
				return this;
			}

			@Override
			public CacheModel<Activity> toCacheModel() {
				return _nullActivityCacheModel;
			}
		};

	private static CacheModel<Activity> _nullActivityCacheModel = new CacheModel<Activity>() {
			@Override
			public Activity toEntityModel() {
				return _nullActivity;
			}
		};
}