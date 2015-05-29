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
import com.liferay.portal.model.Company;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.timetracking.timesheet.model.WorkDay;
import com.liferay.timetracking.timesheet.service.base.WorkDayLocalServiceBaseImpl;

import java.util.Calendar;
import java.util.Date;
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
	public WorkDay addWorkDay(long userId, long companyId,
			long startTime, long endTime, long dayOfYearId, int pause,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		long workDayId = counterLocalService.increment();

		WorkDay workDay = workDayPersistence.create(workDayId);

		workDay.setCompanyId(companyId);
		workDay.setUserId(userId);
		workDay.setUserName(UserLocalServiceUtil.getUserById(
			userId).getFullName());

		workDay.setCreateDate(now);
		workDay.setModifiedDate(now);

		TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);

		Calendar start = CalendarFactoryUtil.getCalendar(timeZone);
		start.setTimeInMillis(startTime);

		Calendar end = CalendarFactoryUtil.getCalendar(timeZone);
		end.setTimeInMillis(endTime);

		workDay.setDayOfYearId(dayOfYearId);
		workDay.setEndTime(end.getTime());
		workDay.setPause(pause);
		workDay.setStartTime(start.getTime());

		workDayPersistence.update(workDay);

		return workDay;
	}

	public WorkDay updateWorkDay(long userId, long workDayId, long startTime,
			long endTime, long dayOfYearId, int pause,
			ServiceContext serviceContext)
		throws PortalException, SystemException {

		Date now = new Date();

		WorkDay workDay = workDayPersistence.findByPrimaryKey(workDayId);

		workDay.setUserId(userId);
		workDay.setUserName(UserLocalServiceUtil.getUserById(userId).
			getFullName());

		workDay.setModifiedDate(now);

		TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);

		Calendar start = CalendarFactoryUtil.getCalendar(timeZone);
		start.setTimeInMillis(startTime);

		Calendar end = CalendarFactoryUtil.getCalendar(timeZone);
		end.setTimeInMillis(endTime);

		workDay.setEndTime(end.getTime());
		workDay.setPause(pause);
		workDay.setStartTime(start.getTime());
		workDay.setDayOfYearId(dayOfYearId);

		workDayPersistence.update(workDay);

		return workDay;
	}

	public List<WorkDay> getWorkDays(long userId, long startTime,
			long endTime, int start, int end,
			OrderByComparator orderByComparator)
		throws SystemException {

		TimeZone timeZone = TimeZoneUtil.getTimeZone(StringPool.UTC);

		Calendar startCalendar = CalendarFactoryUtil.getCalendar(timeZone);
		startCalendar.setTimeInMillis(startTime);

		Calendar endCalendar = CalendarFactoryUtil.getCalendar(timeZone);
		endCalendar.setTimeInMillis(endTime);

		List<WorkDay> workDays = workDayPersistence.findByS_E_U(
			startCalendar.getTime(), endCalendar.getTime(), userId);

		return workDays;
	}
}