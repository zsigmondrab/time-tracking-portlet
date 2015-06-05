package com.liferay.timetracking.dayoffs.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.timetracking.dayoffs.model.Rule;

public class RulePermission {

	public static void check(PermissionChecker permissionChecker, long ruleId,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, ruleId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long ruleId, String actionId) {

		try {
			if (ruleId != ResourceConstants.PRIMKEY_DNE) {
				if (permissionChecker.hasOwnerPermission(
						permissionChecker.getCompanyId(), Rule.class.getName(),
						ruleId, permissionChecker.getUserId(), actionId)) {

					return true;
				}
			}

			if (permissionChecker.hasPermission(
					0, Rule.class.getName(), ruleId, actionId)) {

				return true;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(RulePermission.class);

}