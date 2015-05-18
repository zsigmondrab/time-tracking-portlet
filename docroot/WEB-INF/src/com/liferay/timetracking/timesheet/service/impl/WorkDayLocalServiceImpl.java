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
import com.liferay.portal.kernel.util.CalendarFactoryUtil;
import com.liferay.portal.kernel.util.OrderByComparator;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.TimeZoneUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.timetracking.timesheet.model.WorkDay;
import com.liferay.timetracking.timesheet.service.base.WorkDayLocalServiceBaseImpl;

import java.util.Calendar;
import java.util.List;
import java.util.TimeZone;

/**
 * The implementation of the work day local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.liferay.timetracking.timesheet.service.WorkDayLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Laszlo Hudak, Istvan Sajtos
 * @see com.liferay.timetracking.timesheet.service.base.WorkDayLocalServiceBaseImpl
 * @see com.liferay.timetracking.timesheet.service.WorkDayLocalServiceUtil
 */
public class WorkDayLocalServiceImpl extends WorkDayLocalServiceBaseImpl {
	/**
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.liferay.timetracking.timesheet.service.WorkDayLocalServiceUtil} to access the work day local service.
	 */

	public WorkDay addWorkDay(long endTime, long dayOfYearId, int pause, long startTime,
		long userId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		long workDayId = counterLocalService.increment();

		WorkDay workDay = workDayPersistence.create(workDayId);

		// Group instance

		workDay.setGroupId(serviceContext.getScopeGroupId());

		// Audit fields

		workDay.setCompanyId(serviceContext.getCompanyId());
		workDay.setUserId(userId);
		workDay.setUserName(UserLocalServiceUtil.getUserById(userId).
			getFullName());

		TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);
		Calendar now = CalendarFactoryUtil.getCalendar(timeZone);

		workDay.setCreateDate(now.getTime());
		workDay.setModifiedDate(now.getTime());

		// Other Fields

		Calendar start = CalendarFactoryUtil.getCalendar(timeZone);
		start.setTimeInMillis(startTime);
		
		workDay.setStartTime(start.getTime());
		
		Calendar end = CalendarFactoryUtil.getCalendar(timeZone);
		end.setTimeInMillis(endTime);

		workDay.setEndTime(end.getTime());
		workDay.setPause(pause);
		workDay.setDayOfYearId(dayOfYearId);

		workDayPersistence.update(workDay);

		return workDay;
	}

	public WorkDay updateWorkDay(long endTime, long dayOfYearId, int pause, long startTime,
		long userId, long workDayId, ServiceContext serviceContext)
		throws SystemException, PortalException {

		WorkDay workDay = workDayPersistence.findByPrimaryKey(workDayId);

		// Group instance

		workDay.setGroupId(serviceContext.getScopeGroupId());

		// Audit fields

		workDay.setCompanyId(serviceContext.getCompanyId());
		workDay.setUserId(userId);
		workDay.setUserName(UserLocalServiceUtil.getUserById(userId).
			getFullName());

		TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);
		Calendar now = CalendarFactoryUtil.getCalendar(timeZone);

		workDay.setModifiedDate(now.getTime());

		// Other Fields

		Calendar start = CalendarFactoryUtil.getCalendar(timeZone);
		start.setTimeInMillis(startTime);

		Calendar end = CalendarFactoryUtil.getCalendar(timeZone);
		end.setTimeInMillis(endTime);

		workDay.setStartTime(start.getTime());
		workDay.setEndTime(end.getTime());
		workDay.setPause(pause);

		workDay.setDayOfYearId(dayOfYearId);

		workDayPersistence.update(workDay);

		return workDay;
	}

	public List<WorkDay> getWorkDays(long fromDate, long toDate, long userId,
		int start, int end, OrderByComparator orderByComparator)
		throws SystemException {

		TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);

		Calendar from = CalendarFactoryUtil.getCalendar(timeZone);
		Calendar to = CalendarFactoryUtil.getCalendar(timeZone);

		List<WorkDay> workDays = workDayPersistence.findByS_E_U(
			from.getTime(), to.getTime(), userId);

		return workDays;
	}
}