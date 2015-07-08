package com.liferay.timetracking.timesheet.util;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.timetracking.timesheet.model.WorkDay;

import java.util.Date;
import java.util.List;


public class TimesheetUtil {

	public static JSONObject toTimesheetDayJSONObject(
			ThemeDisplay themeDisplay, WorkDay workDay)
		throws SystemException {

		JSONObject jsonObject = JSONFactoryUtil.createJSONObject();

		Date endTime = workDay.getEndTime();
		Date startTime = workDay.getStartTime();

		jsonObject.put("breakTime", workDay.getBreak_());
		jsonObject.put("companyId", workDay.getCompanyId());
		jsonObject.put("endTime", endTime.getTime());
		jsonObject.put("id", workDay.getWorkDayId());
		jsonObject.put("startTime", startTime.getTime());
		jsonObject.put("userId", workDay.getUserId());

		return jsonObject;
	}

	public static JSONArray toTimesheetDaysJSONArray(
			ThemeDisplay themeDisplay, List<WorkDay> workDays)
		throws PortalException, SystemException {

		JSONArray jsonArray = JSONFactoryUtil.createJSONArray();

		if (workDays == null) {
			return jsonArray;
		}

		for (WorkDay workDay : workDays) {
			jsonArray.put(toTimesheetDayJSONObject(themeDisplay, workDay));
		}
	
		return jsonArray;
	}

}