package com.liferay.timetracking;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.timetracking.dayoffs.service.RuleLocalServiceUtil;
public class TimeTrackingStartupAction extends SimpleAction {

	@Override
	public void run(String[] ids) throws ActionException {
		_log.info("Initializing Time Tracking Plugin");

		try {
			initDayOffRules();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initDayOffRules() throws PortalException, SystemException {
		_log.info("Creating default Day Off rules.");

		RuleLocalServiceUtil.addRule("Weekend", 0);
		RuleLocalServiceUtil.addRule("Public Holidays", 0);
		RuleLocalServiceUtil.addRule("Vacations", 0);
		RuleLocalServiceUtil.addRule("Stand-by", 0.15);
		RuleLocalServiceUtil.addRule("Sick leave", 0);
		RuleLocalServiceUtil.addRule("Paternity leave", 0);
		RuleLocalServiceUtil.addRule("Family Emergency", 0);
	}

	private static Log _log = LogFactoryUtil.getLog(
		TimeTrackingStartupAction.class);
}