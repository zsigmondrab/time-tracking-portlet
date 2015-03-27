create table TimeTracking_Activity (
	activityId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	activityName VARCHAR(75) null
);

create table TimeTracking_ActivityAssignment (
	activityAssignmentId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	activityId LONG,
	workDayId LONG,
	startTime DATE null,
	endTime DATE null
);