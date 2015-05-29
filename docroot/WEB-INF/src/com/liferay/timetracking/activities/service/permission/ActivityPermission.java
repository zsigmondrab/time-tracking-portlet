package com.liferay.timetracking.activities.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.timetracking.activities.model.Activity;
public class ActivityPermission {

	public static void check(PermissionChecker permissionChecker, long activityId,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, activityId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long activityId, String actionId) {

		try {
			if (activityId != ResourceConstants.PRIMKEY_DNE) {
				if (permissionChecker.hasOwnerPermission(
						permissionChecker.getCompanyId(), Activity.class.getName(),
						activityId, permissionChecker.getUserId(), actionId)) {

					return true;
				}
			}

			if (permissionChecker.hasPermission(
					0, Activity.class.getName(), activityId, actionId)) {

				return true;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(ActivityPermission.class);

}