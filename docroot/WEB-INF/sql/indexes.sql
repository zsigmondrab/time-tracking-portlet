create index IX_A5A0B898 on TimeTracking_Activity (companyId);
create index IX_50AE851A on TimeTracking_Activity (groupId);

create index IX_FC3B434B on TimeTracking_ActivityAssignment (companyId);
create index IX_9DC2208D on TimeTracking_ActivityAssignment (groupId);

create index IX_DA8BA622 on TimeTracking_DaysOfYear (classNameId);
create index IX_4E8B0AB7 on TimeTracking_DaysOfYear (classPK);
create index IX_59886E9B on TimeTracking_DaysOfYear (dayId);
create index IX_5C1C5E93 on TimeTracking_DaysOfYear (dayId, classNameId);
create index IX_BB722AB0 on TimeTracking_DaysOfYear (dayId, classNameId, classPK);
create index IX_50E3A3A8 on TimeTracking_DaysOfYear (dayId, classPK);
create index IX_A6D7650E on TimeTracking_DaysOfYear (dayId, unitId);
create index IX_62A07F2D on TimeTracking_DaysOfYear (dayId, unitType);
create index IX_BE92ACEF on TimeTracking_DaysOfYear (dayOfYearId);
create index IX_F6B7AB7E on TimeTracking_DaysOfYear (groupId);
create index IX_542F601F on TimeTracking_DaysOfYear (unitId);
create index IX_19E5F9FE on TimeTracking_DaysOfYear (unitType);

create index IX_6DD0B84B on TimeTracking_Rule (companyId);
create index IX_F030D58D on TimeTracking_Rule (groupId);
create index IX_7C69432 on TimeTracking_Rule (multiplier);
create index IX_EE5651BC on TimeTracking_Rule (name);

create index IX_AE27A06F on TimeTracking_Ruling (multiplier);
create index IX_62872C65 on TimeTracking_Ruling (ruleId);
create index IX_E5EB27D5 on TimeTracking_Ruling (ruleName);

create index IX_99F1B072 on TimeTracking_WorkDay (companyId);
create index IX_40AFAB74 on TimeTracking_WorkDay (groupId);
create index IX_B9F9C449 on TimeTracking_WorkDay (startTime, endTime, userId);