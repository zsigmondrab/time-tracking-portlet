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

package com.liferay.timetracking.dayoffs.service.base;

import com.liferay.portal.kernel.bean.BeanReference;
import com.liferay.portal.kernel.bean.IdentifiableBean;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdate;
import com.liferay.portal.kernel.dao.jdbc.SqlUpdateFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.service.BaseServiceImpl;
import com.liferay.portal.service.persistence.UserPersistence;

import com.liferay.timetracking.dayoffs.model.DaysOfYear;
import com.liferay.timetracking.dayoffs.service.DaysOfYearService;
import com.liferay.timetracking.dayoffs.service.persistence.DaysOfYearPersistence;
import com.liferay.timetracking.dayoffs.service.persistence.DaysOffCounterPersistence;
import com.liferay.timetracking.dayoffs.service.persistence.RulePersistence;

import javax.sql.DataSource;

/**
 * Provides the base implementation for the days of year remote service.
 *
 * <p>
 * This implementation exists only as a container for the default service methods generated by ServiceBuilder. All custom service methods should be put in {@link com.liferay.timetracking.dayoffs.service.impl.DaysOfYearServiceImpl}.
 * </p>
 *
 * @author Laszlo Hudak
 * @see com.liferay.timetracking.dayoffs.service.impl.DaysOfYearServiceImpl
 * @see com.liferay.timetracking.dayoffs.service.DaysOfYearServiceUtil
 * @generated
 */
public abstract class DaysOfYearServiceBaseImpl extends BaseServiceImpl
	implements DaysOfYearService, IdentifiableBean {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this class directly. Always use {@link com.liferay.timetracking.dayoffs.service.DaysOfYearServiceUtil} to access the days of year remote service.
	 */

	/**
	 * Returns the days off counter local service.
	 *
	 * @return the days off counter local service
	 */
	public com.liferay.timetracking.dayoffs.service.DaysOffCounterLocalService getDaysOffCounterLocalService() {
		return daysOffCounterLocalService;
	}

	/**
	 * Sets the days off counter local service.
	 *
	 * @param daysOffCounterLocalService the days off counter local service
	 */
	public void setDaysOffCounterLocalService(
		com.liferay.timetracking.dayoffs.service.DaysOffCounterLocalService daysOffCounterLocalService) {
		this.daysOffCounterLocalService = daysOffCounterLocalService;
	}

	/**
	 * Returns the days off counter remote service.
	 *
	 * @return the days off counter remote service
	 */
	public com.liferay.timetracking.dayoffs.service.DaysOffCounterService getDaysOffCounterService() {
		return daysOffCounterService;
	}

	/**
	 * Sets the days off counter remote service.
	 *
	 * @param daysOffCounterService the days off counter remote service
	 */
	public void setDaysOffCounterService(
		com.liferay.timetracking.dayoffs.service.DaysOffCounterService daysOffCounterService) {
		this.daysOffCounterService = daysOffCounterService;
	}

	/**
	 * Returns the days off counter persistence.
	 *
	 * @return the days off counter persistence
	 */
	public DaysOffCounterPersistence getDaysOffCounterPersistence() {
		return daysOffCounterPersistence;
	}

	/**
	 * Sets the days off counter persistence.
	 *
	 * @param daysOffCounterPersistence the days off counter persistence
	 */
	public void setDaysOffCounterPersistence(
		DaysOffCounterPersistence daysOffCounterPersistence) {
		this.daysOffCounterPersistence = daysOffCounterPersistence;
	}

	/**
	 * Returns the days of year local service.
	 *
	 * @return the days of year local service
	 */
	public com.liferay.timetracking.dayoffs.service.DaysOfYearLocalService getDaysOfYearLocalService() {
		return daysOfYearLocalService;
	}

	/**
	 * Sets the days of year local service.
	 *
	 * @param daysOfYearLocalService the days of year local service
	 */
	public void setDaysOfYearLocalService(
		com.liferay.timetracking.dayoffs.service.DaysOfYearLocalService daysOfYearLocalService) {
		this.daysOfYearLocalService = daysOfYearLocalService;
	}

	/**
	 * Returns the days of year remote service.
	 *
	 * @return the days of year remote service
	 */
	public com.liferay.timetracking.dayoffs.service.DaysOfYearService getDaysOfYearService() {
		return daysOfYearService;
	}

	/**
	 * Sets the days of year remote service.
	 *
	 * @param daysOfYearService the days of year remote service
	 */
	public void setDaysOfYearService(
		com.liferay.timetracking.dayoffs.service.DaysOfYearService daysOfYearService) {
		this.daysOfYearService = daysOfYearService;
	}

	/**
	 * Returns the days of year persistence.
	 *
	 * @return the days of year persistence
	 */
	public DaysOfYearPersistence getDaysOfYearPersistence() {
		return daysOfYearPersistence;
	}

	/**
	 * Sets the days of year persistence.
	 *
	 * @param daysOfYearPersistence the days of year persistence
	 */
	public void setDaysOfYearPersistence(
		DaysOfYearPersistence daysOfYearPersistence) {
		this.daysOfYearPersistence = daysOfYearPersistence;
	}

	/**
	 * Returns the rule local service.
	 *
	 * @return the rule local service
	 */
	public com.liferay.timetracking.dayoffs.service.RuleLocalService getRuleLocalService() {
		return ruleLocalService;
	}

	/**
	 * Sets the rule local service.
	 *
	 * @param ruleLocalService the rule local service
	 */
	public void setRuleLocalService(
		com.liferay.timetracking.dayoffs.service.RuleLocalService ruleLocalService) {
		this.ruleLocalService = ruleLocalService;
	}

	/**
	 * Returns the rule remote service.
	 *
	 * @return the rule remote service
	 */
	public com.liferay.timetracking.dayoffs.service.RuleService getRuleService() {
		return ruleService;
	}

	/**
	 * Sets the rule remote service.
	 *
	 * @param ruleService the rule remote service
	 */
	public void setRuleService(
		com.liferay.timetracking.dayoffs.service.RuleService ruleService) {
		this.ruleService = ruleService;
	}

	/**
	 * Returns the rule persistence.
	 *
	 * @return the rule persistence
	 */
	public RulePersistence getRulePersistence() {
		return rulePersistence;
	}

	/**
	 * Sets the rule persistence.
	 *
	 * @param rulePersistence the rule persistence
	 */
	public void setRulePersistence(RulePersistence rulePersistence) {
		this.rulePersistence = rulePersistence;
	}

	/**
	 * Returns the counter local service.
	 *
	 * @return the counter local service
	 */
	public com.liferay.counter.service.CounterLocalService getCounterLocalService() {
		return counterLocalService;
	}

	/**
	 * Sets the counter local service.
	 *
	 * @param counterLocalService the counter local service
	 */
	public void setCounterLocalService(
		com.liferay.counter.service.CounterLocalService counterLocalService) {
		this.counterLocalService = counterLocalService;
	}

	/**
	 * Returns the resource local service.
	 *
	 * @return the resource local service
	 */
	public com.liferay.portal.service.ResourceLocalService getResourceLocalService() {
		return resourceLocalService;
	}

	/**
	 * Sets the resource local service.
	 *
	 * @param resourceLocalService the resource local service
	 */
	public void setResourceLocalService(
		com.liferay.portal.service.ResourceLocalService resourceLocalService) {
		this.resourceLocalService = resourceLocalService;
	}

	/**
	 * Returns the user local service.
	 *
	 * @return the user local service
	 */
	public com.liferay.portal.service.UserLocalService getUserLocalService() {
		return userLocalService;
	}

	/**
	 * Sets the user local service.
	 *
	 * @param userLocalService the user local service
	 */
	public void setUserLocalService(
		com.liferay.portal.service.UserLocalService userLocalService) {
		this.userLocalService = userLocalService;
	}

	/**
	 * Returns the user remote service.
	 *
	 * @return the user remote service
	 */
	public com.liferay.portal.service.UserService getUserService() {
		return userService;
	}

	/**
	 * Sets the user remote service.
	 *
	 * @param userService the user remote service
	 */
	public void setUserService(
		com.liferay.portal.service.UserService userService) {
		this.userService = userService;
	}

	/**
	 * Returns the user persistence.
	 *
	 * @return the user persistence
	 */
	public UserPersistence getUserPersistence() {
		return userPersistence;
	}

	/**
	 * Sets the user persistence.
	 *
	 * @param userPersistence the user persistence
	 */
	public void setUserPersistence(UserPersistence userPersistence) {
		this.userPersistence = userPersistence;
	}

	public void afterPropertiesSet() {
		Class<?> clazz = getClass();

		_classLoader = clazz.getClassLoader();
	}

	public void destroy() {
	}

	/**
	 * Returns the Spring bean ID for this bean.
	 *
	 * @return the Spring bean ID for this bean
	 */
	@Override
	public String getBeanIdentifier() {
		return _beanIdentifier;
	}

	/**
	 * Sets the Spring bean ID for this bean.
	 *
	 * @param beanIdentifier the Spring bean ID for this bean
	 */
	@Override
	public void setBeanIdentifier(String beanIdentifier) {
		_beanIdentifier = beanIdentifier;
	}

	@Override
	public Object invokeMethod(String name, String[] parameterTypes,
		Object[] arguments) throws Throwable {
		Thread currentThread = Thread.currentThread();

		ClassLoader contextClassLoader = currentThread.getContextClassLoader();

		if (contextClassLoader != _classLoader) {
			currentThread.setContextClassLoader(_classLoader);
		}

		try {
			return _clpInvoker.invokeMethod(name, parameterTypes, arguments);
		}
		finally {
			if (contextClassLoader != _classLoader) {
				currentThread.setContextClassLoader(contextClassLoader);
			}
		}
	}

	protected Class<?> getModelClass() {
		return DaysOfYear.class;
	}

	protected String getModelClassName() {
		return DaysOfYear.class.getName();
	}

	/**
	 * Performs an SQL query.
	 *
	 * @param sql the sql query
	 */
	protected void runSQL(String sql) throws SystemException {
		try {
			DataSource dataSource = daysOfYearPersistence.getDataSource();

			SqlUpdate sqlUpdate = SqlUpdateFactoryUtil.getSqlUpdate(dataSource,
					sql, new int[0]);

			sqlUpdate.update();
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
	}

	@BeanReference(type = com.liferay.timetracking.dayoffs.service.DaysOffCounterLocalService.class)
	protected com.liferay.timetracking.dayoffs.service.DaysOffCounterLocalService daysOffCounterLocalService;
	@BeanReference(type = com.liferay.timetracking.dayoffs.service.DaysOffCounterService.class)
	protected com.liferay.timetracking.dayoffs.service.DaysOffCounterService daysOffCounterService;
	@BeanReference(type = DaysOffCounterPersistence.class)
	protected DaysOffCounterPersistence daysOffCounterPersistence;
	@BeanReference(type = com.liferay.timetracking.dayoffs.service.DaysOfYearLocalService.class)
	protected com.liferay.timetracking.dayoffs.service.DaysOfYearLocalService daysOfYearLocalService;
	@BeanReference(type = com.liferay.timetracking.dayoffs.service.DaysOfYearService.class)
	protected com.liferay.timetracking.dayoffs.service.DaysOfYearService daysOfYearService;
	@BeanReference(type = DaysOfYearPersistence.class)
	protected DaysOfYearPersistence daysOfYearPersistence;
	@BeanReference(type = com.liferay.timetracking.dayoffs.service.RuleLocalService.class)
	protected com.liferay.timetracking.dayoffs.service.RuleLocalService ruleLocalService;
	@BeanReference(type = com.liferay.timetracking.dayoffs.service.RuleService.class)
	protected com.liferay.timetracking.dayoffs.service.RuleService ruleService;
	@BeanReference(type = RulePersistence.class)
	protected RulePersistence rulePersistence;
	@BeanReference(type = com.liferay.counter.service.CounterLocalService.class)
	protected com.liferay.counter.service.CounterLocalService counterLocalService;
	@BeanReference(type = com.liferay.portal.service.ResourceLocalService.class)
	protected com.liferay.portal.service.ResourceLocalService resourceLocalService;
	@BeanReference(type = com.liferay.portal.service.UserLocalService.class)
	protected com.liferay.portal.service.UserLocalService userLocalService;
	@BeanReference(type = com.liferay.portal.service.UserService.class)
	protected com.liferay.portal.service.UserService userService;
	@BeanReference(type = UserPersistence.class)
	protected UserPersistence userPersistence;
	private String _beanIdentifier;
	private ClassLoader _classLoader;
	private DaysOfYearServiceClpInvoker _clpInvoker = new DaysOfYearServiceClpInvoker();
}