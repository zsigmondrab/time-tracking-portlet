package com.liferay.timetracking.timesheet.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.timetracking.timesheet.model.WorkDay;

public class WorkDayPermission {

	public static final String RESOURCE_NAME = "com.liferay.timetracking.activities.model";

	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			WorkDay workDay, String actionId) {

		if (permissionChecker.hasOwnerPermission(workDay.getCompanyId(),
				WorkDay.class.getName(), workDay.getWorkDayId(),
				workDay.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(workDay.getGroupId(),
				WorkDay.class.getName(), workDay.getWorkDayId(),
				actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId,
				actionId);
	}

}