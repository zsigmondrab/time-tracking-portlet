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

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.ServiceContext;

import com.liferay.timetracking.dayoffs.model.Ruling;

import java.util.List;

/**
 * The persistence utility for the ruling service. This utility wraps {@link RulingPersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LĂˇszlĂł HudĂˇk
 * @see RulingPersistence
 * @see RulingPersistenceImpl
 * @generated
 */
public class RulingUtil {
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
	public static void clearCache(Ruling ruling) {
		getPersistence().clearCache(ruling);
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
	public static List<Ruling> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Ruling> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Ruling> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Ruling update(Ruling ruling) throws SystemException {
		return getPersistence().update(ruling);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Ruling update(Ruling ruling, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(ruling, serviceContext);
	}

	/**
	* Returns the ruling where ruleId = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRulingException} if it could not be found.
	*
	* @param ruleId the rule ID
	* @return the matching ruling
	* @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling findByRuleId(
		long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence().findByRuleId(ruleId);
	}

	/**
	* Returns the ruling where ruleId = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ruleId the rule ID
	* @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling fetchByRuleId(
		long ruleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRuleId(ruleId);
	}

	/**
	* Returns the ruling where ruleId = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ruleId the rule ID
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling fetchByRuleId(
		long ruleId, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRuleId(ruleId, retrieveFromCache);
	}

	/**
	* Removes the ruling where ruleId = &#63; from the database.
	*
	* @param ruleId the rule ID
	* @return the ruling that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling removeByRuleId(
		long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence().removeByRuleId(ruleId);
	}

	/**
	* Returns the number of rulings where ruleId = &#63;.
	*
	* @param ruleId the rule ID
	* @return the number of matching rulings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRuleId(long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRuleId(ruleId);
	}

	/**
	* Returns the ruling where ruleName = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRulingException} if it could not be found.
	*
	* @param ruleName the rule name
	* @return the matching ruling
	* @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling findByRuleName(
		java.lang.String ruleName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence().findByRuleName(ruleName);
	}

	/**
	* Returns the ruling where ruleName = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param ruleName the rule name
	* @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling fetchByRuleName(
		java.lang.String ruleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRuleName(ruleName);
	}

	/**
	* Returns the ruling where ruleName = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param ruleName the rule name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching ruling, or <code>null</code> if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling fetchByRuleName(
		java.lang.String ruleName, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByRuleName(ruleName, retrieveFromCache);
	}

	/**
	* Removes the ruling where ruleName = &#63; from the database.
	*
	* @param ruleName the rule name
	* @return the ruling that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling removeByRuleName(
		java.lang.String ruleName)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence().removeByRuleName(ruleName);
	}

	/**
	* Returns the number of rulings where ruleName = &#63;.
	*
	* @param ruleName the rule name
	* @return the number of matching rulings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRuleName(java.lang.String ruleName)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRuleName(ruleName);
	}

	/**
	* Returns all the rulings where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @return the matching rulings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Ruling> findByRuleType(
		double multiplier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRuleType(multiplier);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Ruling> findByRuleType(
		double multiplier, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByRuleType(multiplier, start, end);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Ruling> findByRuleType(
		double multiplier, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByRuleType(multiplier, start, end, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Ruling findByRuleType_First(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence()
				   .findByRuleType_First(multiplier, orderByComparator);
	}

	/**
	* Returns the first ruling in the ordered set where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching ruling, or <code>null</code> if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling fetchByRuleType_First(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRuleType_First(multiplier, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Ruling findByRuleType_Last(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence()
				   .findByRuleType_Last(multiplier, orderByComparator);
	}

	/**
	* Returns the last ruling in the ordered set where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching ruling, or <code>null</code> if a matching ruling could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling fetchByRuleType_Last(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByRuleType_Last(multiplier, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Ruling[] findByRuleType_PrevAndNext(
		long ruleId, double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence()
				   .findByRuleType_PrevAndNext(ruleId, multiplier,
			orderByComparator);
	}

	/**
	* Removes all the rulings where multiplier = &#63; from the database.
	*
	* @param multiplier the multiplier
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByRuleType(double multiplier)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByRuleType(multiplier);
	}

	/**
	* Returns the number of rulings where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @return the number of matching rulings
	* @throws SystemException if a system exception occurred
	*/
	public static int countByRuleType(double multiplier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByRuleType(multiplier);
	}

	/**
	* Caches the ruling in the entity cache if it is enabled.
	*
	* @param ruling the ruling
	*/
	public static void cacheResult(
		com.liferay.timetracking.dayoffs.model.Ruling ruling) {
		getPersistence().cacheResult(ruling);
	}

	/**
	* Caches the rulings in the entity cache if it is enabled.
	*
	* @param rulings the rulings
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timetracking.dayoffs.model.Ruling> rulings) {
		getPersistence().cacheResult(rulings);
	}

	/**
	* Creates a new ruling with the primary key. Does not add the ruling to the database.
	*
	* @param ruleId the primary key for the new ruling
	* @return the new ruling
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling create(
		long ruleId) {
		return getPersistence().create(ruleId);
	}

	/**
	* Removes the ruling with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleId the primary key of the ruling
	* @return the ruling that was removed
	* @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a ruling with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling remove(
		long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence().remove(ruleId);
	}

	public static com.liferay.timetracking.dayoffs.model.Ruling updateImpl(
		com.liferay.timetracking.dayoffs.model.Ruling ruling)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(ruling);
	}

	/**
	* Returns the ruling with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRulingException} if it could not be found.
	*
	* @param ruleId the primary key of the ruling
	* @return the ruling
	* @throws com.liferay.timetracking.dayoffs.NoSuchRulingException if a ruling with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling findByPrimaryKey(
		long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRulingException {
		return getPersistence().findByPrimaryKey(ruleId);
	}

	/**
	* Returns the ruling with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ruleId the primary key of the ruling
	* @return the ruling, or <code>null</code> if a ruling with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Ruling fetchByPrimaryKey(
		long ruleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ruleId);
	}

	/**
	* Returns all the rulings.
	*
	* @return the rulings
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Ruling> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Ruling> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Ruling> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rulings from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rulings.
	*
	* @return the number of rulings
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RulingPersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RulingPersistence)PortletBeanLocatorUtil.locate(com.liferay.timetracking.dayoffs.service.ClpSerializer.getServletContextName(),
					RulingPersistence.class.getName());

			ReferenceRegistry.registerReference(RulingUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RulingPersistence persistence) {
	}

	private static RulingPersistence _persistence;
}