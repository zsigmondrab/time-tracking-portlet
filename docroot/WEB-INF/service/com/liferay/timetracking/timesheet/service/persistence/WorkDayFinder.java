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

/**
 * @author Laszlo Hudak, Istvan Sajtos
 */
public interface WorkDayFinder {
	public int countByStartTimeEndTimeUserId(java.util.Date startTime,
		java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;

	public java.util.List<com.liferay.timetracking.timesheet.model.WorkDay> findByStartTimeEndTimeUserId(
		java.util.Date startTime, java.util.Date endTime, long userId)
		throws com.liferay.portal.kernel.exception.SystemException;
}