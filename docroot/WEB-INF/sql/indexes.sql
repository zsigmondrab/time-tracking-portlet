create index IX_59886E9B on TimeTracking_DaysOfYear (dayId);
create index IX_A6D7650E on TimeTracking_DaysOfYear (dayId, unitId);
create index IX_62A07F2D on TimeTracking_DaysOfYear (dayId, unitType);
create index IX_BE92ACEF on TimeTracking_DaysOfYear (dayOfYearId);
create index IX_542F601F on TimeTracking_DaysOfYear (unitId);
create index IX_19E5F9FE on TimeTracking_DaysOfYear (unitType);

create index IX_AE27A06F on TimeTracking_Ruling (multiplier);
create index IX_62872C65 on TimeTracking_Ruling (ruleId);
create index IX_E5EB27D5 on TimeTracking_Ruling (ruleName);