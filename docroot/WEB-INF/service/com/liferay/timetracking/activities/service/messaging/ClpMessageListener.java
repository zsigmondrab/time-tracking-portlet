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

package com.liferay.timetracking.activities.service.messaging;

import com.liferay.portal.kernel.messaging.BaseMessageListener;
import com.liferay.portal.kernel.messaging.Message;

import com.liferay.timetracking.activities.service.ActivityAssignmentLocalServiceUtil;
import com.liferay.timetracking.activities.service.ActivityAssignmentServiceUtil;
import com.liferay.timetracking.activities.service.ActivityLocalServiceUtil;
import com.liferay.timetracking.activities.service.ActivityServiceUtil;
import com.liferay.timetracking.activities.service.ClpSerializer;

/**
 * @author Laszlo Hudak, Adam T. Nagy
 */
public class ClpMessageListener extends BaseMessageListener {
	public static String getServletContextName() {
		return ClpSerializer.getServletContextName();
	}

	@Override
	protected void doReceive(Message message) throws Exception {
		String command = message.getString("command");
		String servletContextName = message.getString("servletContextName");

		if (command.equals("undeploy") &&
				servletContextName.equals(getServletContextName())) {
			ActivityLocalServiceUtil.clearService();

			ActivityServiceUtil.clearService();
			ActivityAssignmentLocalServiceUtil.clearService();

			ActivityAssignmentServiceUtil.clearService();
		}
	}
}