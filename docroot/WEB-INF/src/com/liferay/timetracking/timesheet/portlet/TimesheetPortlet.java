package com.liferay.timetracking.timesheet.portlet;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.timetracking.timesheet.model.WorkDay;
import com.liferay.timetracking.timesheet.service.WorkDayServiceUtil;
import com.liferay.timetracking.timesheet.util.TimesheetUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class TimesheetPortlet extends MVCPortlet {

	@Override
	public void serveResource(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws PortletException {

		try {
			String resourceID = resourceRequest.getResourceID();

			if (resourceID.equals("timesheetDays")) {
				serveTimesheetDays(resourceRequest, resourceResponse);
			}
			else {
				super.serveResource(resourceRequest, resourceResponse);
			}
		}
		catch (Exception e) {
			throw new PortletException(e);
		}
	}

	protected void serveTimesheetDays(
			ResourceRequest resourceRequest, ResourceResponse resourceResponse)
		throws IOException, PortalException, SystemException {

		long endTime = ParamUtil.getLong(resourceRequest, "intervalEndTime");

		long startTime = ParamUtil.getLong(
			resourceRequest, "intervalStartTime");

		long userId = ParamUtil.getLong(resourceRequest, "userId");

		List<WorkDay> workDays = WorkDayServiceUtil.getWorkDays(
			userId, startTime, endTime);

		ThemeDisplay themeDisplay = (ThemeDisplay)resourceRequest.getAttribute(
			WebKeys.THEME_DISPLAY);

		JSONArray jsonArray = TimesheetUtil.toTimesheetDaysJSONArray(
			themeDisplay, workDays);

		writeJSON(resourceRequest, resourceResponse, jsonArray);
	}

}