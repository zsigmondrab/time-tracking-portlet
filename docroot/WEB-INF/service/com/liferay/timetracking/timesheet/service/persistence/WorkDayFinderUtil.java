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

package com.liferay.timetracking.timesheet.service.persistence;

import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.util.ReferenceRegistry;

/**
 * @author Laszlo Hudak, Istvan Sajtos
 */
public class WorkDayFinderUtil {
	public static int countByStartTimeEndTimeUserId(java.util.Date startTime,
		java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .countByStartTimeEndTimeUserId(startTime, endTime, userId);
	}

	public static java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByStartTimeEndTimeUserId(
		java.util.Date startTime, java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException {
		return getFinder()
				   .findByStartTimeEndTimeUserId(startTime, endTime, userId);
	}

	public static WorkDayFinder getFinder() {
		if (_finder == null) {
			_finder = (WorkDayFinder)PortletBeanLocatorUtil.locate(com.liferay.timetracking.timesheet.service.ClpSerializer.getServletContextName(),
					WorkDayFinder.class.getName());

			ReferenceRegistry.registerReference(WorkDayFinderUtil.class,
				"_finder");
		}

		return _finder;
	}

	public void setFinder(WorkDayFinder finder) {
		_finder = finder;

		ReferenceRegistry.registerReference(WorkDayFinderUtil.class, "_finder");
	}

	private static WorkDayFinder _finder;
}