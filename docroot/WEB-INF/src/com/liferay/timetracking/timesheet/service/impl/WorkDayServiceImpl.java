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

package com.liferay.timetracking.timesheet.service.impl;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.timetracking.timesheet.model.WorkDay;
import com.liferay.timetracking.timesheet.service.base.WorkDayServiceBaseImpl;

import java.util.List;

/**
 * The implementation of the work day remote service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timetracking.timesheet.service.WorkDayService} interface.
 *
 * <p>
 * This is a remote service. Methods of this service are expected to have security checks based on the propagated JAAS credentials because this service can be accessed remotely.
 * </p>
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see com.liferay.timetracking.timesheet.service.base.WorkDayServiceBaseImpl
 * @see com.liferay.timetracking.timesheet.service.WorkDayServiceUtil
 */
public class WorkDayServiceImpl extends WorkDayServiceBaseImpl {

	public WorkDay addWorkDay(
			long userId, long companyId, long startTime, long endTime,
			long dayOfYearId, int break_, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return workDayLocalService.addWorkDay(
			userId, companyId, startTime, endTime, dayOfYearId, break_,
			serviceContext);
	}

	public List<WorkDay> getWorkDays(
			long userId, long companyId, long startTime, long endTime,
			int start, int end, OrderByComparator orderByComparator)
		throws SystemException {

		return workDayLocalService.getWorkDays(userId, companyId, startTime,
			endTime, start, end, orderByComparator);
	}

	public WorkDay updateWorkDay(
			long userId, long workDayId, long startTime, long endTime,
			long dayOfYearId, int break_, ServiceContext serviceContext)
		throws PortalException, SystemException {

		return workDayLocalService.updateWorkDay(
			userId, workDayId, startTime, endTime, dayOfYearId, break_,
			serviceContext);
	}

}