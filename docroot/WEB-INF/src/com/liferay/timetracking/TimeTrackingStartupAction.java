package com.liferay.timetracking;

import com.liferay.portal.kernel.events.ActionException;
import com.liferay.portal.kernel.events.SimpleAction;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

public class TimeTrackingStartupAction extends SimpleAction {

	@Override
	public void run(String[] ids) throws ActionException {
		_log.info("Initializing Time Tracking Plugin");
	}

	private static Log _log = LogFactoryUtil.getLog(
		TimeTrackingStartupAction.class);
}
