create table TimeTracking_Activity (
	activityId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null
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

create table TimeTracking_DaysOfYear (
	dayOfYearId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dayId DATE null,
	ruleId LONG,
	classNameId LONG,
	classPK LONG
);

create table TimeTracking_Rule (
	ruleId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	name VARCHAR(75) null,
	multiplier DOUBLE
);

create table TimeTracking_Ruling (
	ruleId LONG not null primary key,
	groupId LONG,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	ruleName VARCHAR(75) null,
	multiplier DOUBLE
);

create table TimeTracking_WorkDay (
	workDayId LONG not null primary key,
	companyId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null,
	dayOfYearId LONG,
	startTime DATE null,
	endTime DATE null,
	break_ INTEGER
);