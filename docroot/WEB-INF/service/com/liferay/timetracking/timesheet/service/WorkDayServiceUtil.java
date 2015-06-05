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

package com.liferay.timetracking.timesheet.service;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;
import com.liferay.portal.service.InvokableService;

/**
 * Provides the remote service utility for WorkDay. This utility wraps
 * {@link com.liferay.timetracking.timesheet.service.impl.WorkDayServiceImpl} and is the
 * primary access point for service operations in application layer code running
 * on a remote server. Methods of this service are expected to have security
 * checks based on the propagated JAAS credentials because this service can be
 * accessed remotely.
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see WorkDayService
 * @see com.liferay.timetracking.timesheet.service.base.WorkDayServiceBaseImpl
 * @see com.liferay.timetracking.timesheet.service.impl.WorkDayServiceImpl
 * @generated
 */
public class WorkDayServiceUtil {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this class directly. Add custom service methods to {@link com.liferay.timetracking.timesheet.service.impl.WorkDayServiceImpl} and rerun ServiceBuilder to regenerate this class.
	 */

	/**
	* Returns the Spring bean ID for this bean.
	*
	* @return the Spring bean ID for this bean
	*/
	public static java.lang.String getBeanIdentifier() {
		return getService().getBeanIdentifier();
	}

	/**
	* Sets the Spring bean ID for this bean.
	*
	* @param beanIdentifier the Spring bean ID for this bean
	*/
	public static void setBeanIdentifier(java.lang.String beanIdentifier) {
		getService().setBeanIdentifier(beanIdentifier);
	}

	public static java.lang.Object invokeMethod(java.lang.String name,
		java.lang.String[] parameterTypes, java.lang.Object[] arguments)
		throws java.lang.Throwable {
		return getService().invokeMethod(name, parameterTypes, arguments);
	}

	public static com.liferay.timetracking.timesheet.model.WorkDay addWorkDay(
		long userId, long companyId, long startTime, long endTime,
		long dayOfYearId, int break_,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .addWorkDay(userId, companyId, startTime, endTime,
			dayOfYearId, break_, serviceContext);
	}

	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> getWorkDays(
		long userId, long companyId, long startTime, long endTime, int start,
		int end,
		com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .getWorkDays(userId, companyId, startTime, endTime, start,
			end, orderByComparator);
	}

	public static com.liferay.timetracking.timesheet.model.WorkDay updateWorkDay(
		long userId, long workDayId, long startTime, long endTime,
		long dayOfYearId, int break_,
		com.liferay.portal.service.ServiceContext serviceContext)
		throws com.liferay.portal.kernel.exception.PortalException,
			com.liferay.portal.kernel.exception.SystemException {
		return getService()
				   .updateWorkDay(userId, workDayId, startTime, endTime,
			dayOfYearId, break_, serviceContext);
	}

	public static void clearService() {
		_service = null;
	}

	public static WorkDayService getService() {
		if (_service == null) {
			InvokableService invokableService = (InvokableService)PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(),
					WorkDayService.class.getName());

			if (invokableService instanceof WorkDayService) {
				_service = (WorkDayService)invokableService;
			}
			else {
				_service = new WorkDayServiceClp(invokableService);
			}

			ReferenceRegistry.registerReference(WorkDayServiceUtil.class,
				"_service");
		}

		return _service;
	}

	/**
	 * @deprecated As of 6.2.0
	 */
	public void setService(WorkDayService service) {
	}

	private static WorkDayService _service;
}