package com.liferay.timetracking.activities.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.timetracking.activities.model.Activity;

public class ActivityPermission {

	public static final String RESOURCE_NAME = "com.liferay.timetracking.activities.model";

	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			Activity activity, String actionId) {

		if (permissionChecker.hasOwnerPermission(activity.getCompanyId(),
				Activity.class.getName(), activity.getActivityId(),
				activity.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(activity.getGroupId(),
				Activity.class.getName(), activity.getActivityId(),
				actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId,
				actionId);
	}

}