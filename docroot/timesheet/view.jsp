<%@page import="com.liferay.portal.kernel.util.LocaleUtil"%>
<%@ include file="init.jsp" %>

<article>
	<div id="timesheet"></div>

	<aui:script use="timesheet">
		var timesheetViews = [
			new Liferay.TimesheetMonthView({
				headerElements: ['<%= LanguageUtil.get(pageContext, "days") %>', '<%= LanguageUtil.get(pageContext, "start-time") %>', '<%= LanguageUtil.get(pageContext, "end-time") %>', '<%= LanguageUtil.get(pageContext, "lunch") %>', '<%= LanguageUtil.get(pageContext, "all-time") %>', '<%= LanguageUtil.get(pageContext, "work-time") %>', '<%= LanguageUtil.get(pageContext, "over-time") %>'],
				userId: <%= themeDisplay.getUserId() %>
			})
		];

		new Liferay.Timesheet({
			boundingBox: '#timesheet',
			dayRecorder: new Liferay.TimesheetDayRecorder(),
			firstDayOfWeek: 1,
			locale: "en",
			views: timesheetViews,
			activeView: timesheetViews[0]
		}).render();
	</aui:script>
</article>