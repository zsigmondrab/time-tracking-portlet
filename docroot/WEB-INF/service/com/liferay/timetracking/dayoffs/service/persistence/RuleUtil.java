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

import com.liferay.timetracking.dayoffs.model.Rule;

import java.util.List;

/**
 * The persistence utility for the rule service. This utility wraps {@link RulePersistenceImpl} and provides direct access to the database for CRUD operations. This utility should only be used by the service layer, as it must operate within a transaction. Never access this utility in a JSP, controller, model, or other front-end class.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author LÃ¡szlÃ³ HudÃ¡k
 * @see RulePersistence
 * @see RulePersistenceImpl
 * @generated
 */
public class RuleUtil {
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
	public static void clearCache(Rule rule) {
		getPersistence().clearCache(rule);
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
	public static List<Rule> findWithDynamicQuery(DynamicQuery dynamicQuery)
		throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int)
	 */
	public static List<Rule> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end) throws SystemException {
		return getPersistence().findWithDynamicQuery(dynamicQuery, start, end);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#findWithDynamicQuery(DynamicQuery, int, int, OrderByComparator)
	 */
	public static List<Rule> findWithDynamicQuery(DynamicQuery dynamicQuery,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {
		return getPersistence()
				   .findWithDynamicQuery(dynamicQuery, start, end,
			orderByComparator);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel)
	 */
	public static Rule update(Rule rule) throws SystemException {
		return getPersistence().update(rule);
	}

	/**
	 * @see com.liferay.portal.service.persistence.BasePersistence#update(com.liferay.portal.model.BaseModel, ServiceContext)
	 */
	public static Rule update(Rule rule, ServiceContext serviceContext)
		throws SystemException {
		return getPersistence().update(rule, serviceContext);
	}

	/**
	* Returns all the rules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the matching rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findByGroupId(
		long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findByGroupId(
		long groupId, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByGroupId(groupId, start, end);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findByGroupId(
		long groupId, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByGroupId(groupId, start, end, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Rule findByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence().findByGroupId_First(groupId, orderByComparator);
	}

	/**
	* Returns the first rule in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule fetchByGroupId_First(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_First(groupId, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Rule findByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence().findByGroupId_Last(groupId, orderByComparator);
	}

	/**
	* Returns the last rule in the ordered set where groupId = &#63;.
	*
	* @param groupId the group ID
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule fetchByGroupId_Last(
		long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByGroupId_Last(groupId, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Rule[] findByGroupId_PrevAndNext(
		long ruleId, long groupId,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence()
				   .findByGroupId_PrevAndNext(ruleId, groupId, orderByComparator);
	}

	/**
	* Removes all the rules where groupId = &#63; from the database.
	*
	* @param groupId the group ID
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByGroupId(groupId);
	}

	/**
	* Returns the number of rules where groupId = &#63;.
	*
	* @param groupId the group ID
	* @return the number of matching rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByGroupId(long groupId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByGroupId(groupId);
	}

	/**
	* Returns all the rules where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @return the matching rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findByMultiplier(
		double multiplier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMultiplier(multiplier);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findByMultiplier(
		double multiplier, int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findByMultiplier(multiplier, start, end);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findByMultiplier(
		double multiplier, int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .findByMultiplier(multiplier, start, end, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Rule findByMultiplier_First(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence()
				   .findByMultiplier_First(multiplier, orderByComparator);
	}

	/**
	* Returns the first rule in the ordered set where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the first matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule fetchByMultiplier_First(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMultiplier_First(multiplier, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Rule findByMultiplier_Last(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence()
				   .findByMultiplier_Last(multiplier, orderByComparator);
	}

	/**
	* Returns the last rule in the ordered set where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @param orderByComparator the comparator to order the set by (optionally <code>null</code>)
	* @return the last matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule fetchByMultiplier_Last(
		double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence()
				   .fetchByMultiplier_Last(multiplier, orderByComparator);
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
	public static com.liferay.timetracking.dayoffs.model.Rule[] findByMultiplier_PrevAndNext(
		long ruleId, double multiplier,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence()
				   .findByMultiplier_PrevAndNext(ruleId, multiplier,
			orderByComparator);
	}

	/**
	* Removes all the rules where multiplier = &#63; from the database.
	*
	* @param multiplier the multiplier
	* @throws SystemException if a system exception occurred
	*/
	public static void removeByMultiplier(double multiplier)
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeByMultiplier(multiplier);
	}

	/**
	* Returns the number of rules where multiplier = &#63;.
	*
	* @param multiplier the multiplier
	* @return the number of matching rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByMultiplier(double multiplier)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByMultiplier(multiplier);
	}

	/**
	* Returns the rule where name = &#63; or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRuleException} if it could not be found.
	*
	* @param name the name
	* @return the matching rule
	* @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule findByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence().findByName(name);
	}

	/**
	* Returns the rule where name = &#63; or returns <code>null</code> if it could not be found. Uses the finder cache.
	*
	* @param name the name
	* @return the matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule fetchByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name);
	}

	/**
	* Returns the rule where name = &#63; or returns <code>null</code> if it could not be found, optionally using the finder cache.
	*
	* @param name the name
	* @param retrieveFromCache whether to use the finder cache
	* @return the matching rule, or <code>null</code> if a matching rule could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule fetchByName(
		java.lang.String name, boolean retrieveFromCache)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByName(name, retrieveFromCache);
	}

	/**
	* Removes the rule where name = &#63; from the database.
	*
	* @param name the name
	* @return the rule that was removed
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule removeByName(
		java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence().removeByName(name);
	}

	/**
	* Returns the number of rules where name = &#63;.
	*
	* @param name the name
	* @return the number of matching rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countByName(java.lang.String name)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countByName(name);
	}

	/**
	* Caches the rule in the entity cache if it is enabled.
	*
	* @param rule the rule
	*/
	public static void cacheResult(
		com.liferay.timetracking.dayoffs.model.Rule rule) {
		getPersistence().cacheResult(rule);
	}

	/**
	* Caches the rules in the entity cache if it is enabled.
	*
	* @param rules the rules
	*/
	public static void cacheResult(
		java.util.List<com.liferay.timetracking.dayoffs.model.Rule> rules) {
		getPersistence().cacheResult(rules);
	}

	/**
	* Creates a new rule with the primary key. Does not add the rule to the database.
	*
	* @param ruleId the primary key for the new rule
	* @return the new rule
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule create(
		long ruleId) {
		return getPersistence().create(ruleId);
	}

	/**
	* Removes the rule with the primary key from the database. Also notifies the appropriate model listeners.
	*
	* @param ruleId the primary key of the rule
	* @return the rule that was removed
	* @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule remove(
		long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence().remove(ruleId);
	}

	public static com.liferay.timetracking.dayoffs.model.Rule updateImpl(
		com.liferay.timetracking.dayoffs.model.Rule rule)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().updateImpl(rule);
	}

	/**
	* Returns the rule with the primary key or throws a {@link com.liferay.timetracking.dayoffs.NoSuchRuleException} if it could not be found.
	*
	* @param ruleId the primary key of the rule
	* @return the rule
	* @throws com.liferay.timetracking.dayoffs.NoSuchRuleException if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule findByPrimaryKey(
		long ruleId)
		throws com.liferay.portal.kernel.exception.SystemException,
			com.liferay.timetracking.dayoffs.NoSuchRuleException {
		return getPersistence().findByPrimaryKey(ruleId);
	}

	/**
	* Returns the rule with the primary key or returns <code>null</code> if it could not be found.
	*
	* @param ruleId the primary key of the rule
	* @return the rule, or <code>null</code> if a rule with the primary key could not be found
	* @throws SystemException if a system exception occurred
	*/
	public static com.liferay.timetracking.dayoffs.model.Rule fetchByPrimaryKey(
		long ruleId) throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().fetchByPrimaryKey(ruleId);
	}

	/**
	* Returns all the rules.
	*
	* @return the rules
	* @throws SystemException if a system exception occurred
	*/
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll();
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findAll(
		int start, int end)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end);
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
	public static java.util.List<com.liferay.timetracking.dayoffs.model.Rule> findAll(
		int start, int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().findAll(start, end, orderByComparator);
	}

	/**
	* Removes all the rules from the database.
	*
	* @throws SystemException if a system exception occurred
	*/
	public static void removeAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		getPersistence().removeAll();
	}

	/**
	* Returns the number of rules.
	*
	* @return the number of rules
	* @throws SystemException if a system exception occurred
	*/
	public static int countAll()
		throws com.liferay.portal.kernel.exception.SystemException {
		return getPersistence().countAll();
	}

	public static RulePersistence getPersistence() {
		if (_persistence == null) {
			_persistence = (RulePersistence)PortletBeanLocatorUtil.locate(com.liferay.timetracking.dayoffs.service.ClpSerializer.getServletContextName(),
					RulePersistence.class.getName());

			ReferenceRegistry.registerReference(RuleUtil.class, "_persistence");
		}

		return _persistence;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setPersistence(RulePersistence persistence) {
	}

	private static RulePersistence _persistence;
}