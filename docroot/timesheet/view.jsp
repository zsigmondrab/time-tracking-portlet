<%@ include file="init.jsp" %>

<article>
	<div id="timesheet"></div>

	<aui:script use="timesheet">
		var timesheetViews = [
			new Liferay.TimesheetMonthView({
				headerElements: ['days', 'startTime', 'endTime', 'lunch', 'allTime', 'workTime', 'overTime'],
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