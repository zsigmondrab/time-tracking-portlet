package com.liferay.timetracking.dayoffs.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.timetracking.dayoffs.model.Rule;

public class RulePermission {

	public static final String RESOURCE_NAME = "com.liferay.timetracking.activities.model";

	public static void check(PermissionChecker permissionChecker, long groupId,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, groupId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			Rule rule, String actionId) {

		if (permissionChecker.hasOwnerPermission(rule.getCompanyId(),
				Rule.class.getName(), rule.getRuleId(),
				rule.getUserId(), actionId)) {

			return true;
		}

		return permissionChecker.hasPermission(rule.getGroupId(),
				Rule.class.getName(), rule.getRuleId(),
				actionId);
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long groupId, String actionId) {

		return permissionChecker.hasPermission(groupId, RESOURCE_NAME, groupId,
				actionId);
	}

}