create table Task (
	taskId LONG not null primary key,
	taskName VARCHAR(75) null
);

create table TaskAssignment (
	taskAssignmentId LONG not null primary key,
	taskId LONG,
	workDayId LONG,
	startTime DATE null,
	endTime DATE null,
	companyId LONG,
	groupId LONG,
	userId LONG,
	userName VARCHAR(75) null,
	createDate DATE null,
	modifiedDate DATE null
);