package com.liferay.timetracking.timesheet.service.permission;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.model.ResourceConstants;
import com.liferay.portal.security.auth.PrincipalException;
import com.liferay.portal.security.permission.PermissionChecker;
import com.liferay.timetracking.timesheet.model.WorkDay;
public class WorkDayPermission {

	public static void check(PermissionChecker permissionChecker, long workDayId,
			String actionId) throws PortalException {

		if (!contains(permissionChecker, workDayId, actionId)) {
			throw new PrincipalException();
		}
	}

	public static boolean contains(PermissionChecker permissionChecker,
			long workDayId, String actionId) {

		try {
			if (workDayId != ResourceConstants.PRIMKEY_DNE) {
				if (permissionChecker.hasOwnerPermission(
						permissionChecker.getCompanyId(), WorkDay.class.getName(),
						workDayId, permissionChecker.getUserId(), actionId)) {

					return true;
				}
			}

			if (permissionChecker.hasPermission(
					0, WorkDay.class.getName(), workDayId, actionId)) {

				return true;
			}
		}
		catch (Exception e) {
			_log.error(e, e);
		}

		return false;
	}

	private static Log _log = LogFactoryUtil.getLog(WorkDayPermission.class);

}