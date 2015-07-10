package com.liferay.timetracking.timesheet.service.persistence;

import com.liferay.portal.kernel.dao.orm.QueryPos;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.dao.orm.SQLQuery;
import com.liferay.portal.kernel.dao.orm.Session;
import com.liferay.portal.kernel.dao.orm.Type;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.CalendarUtil;
import com.liferay.portal.service.persistence.impl.BasePersistenceImpl;
import com.liferay.timetracking.timesheet.model.WorkDay;
import com.liferay.timetracking.timesheet.model.impl.WorkDayImpl;
import com.liferay.util.dao.orm.CustomSQLUtil;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class WorkDayFinderImpl
	extends BasePersistenceImpl<WorkDay> implements WorkDayFinder {

	public static final String COUNT_BY_START_TIME_END_TIME_USER_ID =
		WorkDayFinder.class.getName() + ".countByStartTimeEndTimeUserId";


	public static final String FIND_BY_START_TIME_END_TIME_USER_ID =
		WorkDayFinder.class.getName() + ".findByStartTimeEndTimeUserId";

	@Override
	public int countByStartTimeEndTimeUserId(
			Date startTime, Date endTime, long userId)
		throws SystemException {

		Timestamp startTime_TS = CalendarUtil.getTimestamp(startTime);
		Timestamp endTime_TS = CalendarUtil.getTimestamp(endTime);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(
				COUNT_BY_START_TIME_END_TIME_USER_ID);

			SQLQuery q = session.createSQLQuery(sql);

			q.addScalar(COUNT_COLUMN_NAME, Type.LONG);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(startTime_TS);
			qPos.add(endTime_TS);
			qPos.add(userId);

			Iterator<Long> itr = q.iterate();

			if (itr.hasNext()) {
				Long count = itr.next();

				if (count != null) {
					return count.intValue();
				}
			}

			return 0;
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}

	@Override
	public List<WorkDay> findByStartTimeEndTimeUserId(
			Date startTime, Date endTime, long userId)
		throws SystemException {

		Timestamp startTime_TS = CalendarUtil.getTimestamp(startTime);
		Timestamp endTime_TS = CalendarUtil.getTimestamp(endTime);

		Session session = null;

		try {
			session = openSession();

			String sql = CustomSQLUtil.get(FIND_BY_START_TIME_END_TIME_USER_ID);

			SQLQuery q = session.createSQLQuery(sql);

			q.addEntity("TimeTracking_WorkDay", WorkDayImpl.class);

			QueryPos qPos = QueryPos.getInstance(q);

			qPos.add(startTime_TS);
			qPos.add(endTime_TS);
			qPos.add(userId);

			return (List<WorkDay>)QueryUtil.list(q, getDialect(),
				QueryUtil.ALL_POS, QueryUtil.ALL_POS);
		}
		catch (Exception e) {
			throw new SystemException(e);
		}
		finally {
			closeSession(session);
		}
	}
}
