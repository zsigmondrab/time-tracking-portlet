create table TimeTracking_WorkDay (
	workDayId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	dayOfYearId LONG,
	userId LONG,
	startTime INTEGER,
	endTime INTEGER,
	lunchBreak INTEGER,
	timestamp DATE null
);