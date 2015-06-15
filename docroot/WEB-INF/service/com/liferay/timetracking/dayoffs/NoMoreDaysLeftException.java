package com.liferay.timetracking.dayoffs;

import com.liferay.portal.kernel.exception.PortalException;

public class NoMoreDaysLeftException extends PortalException {

	public NoMoreDaysLeftException() {
	}

	public NoMoreDaysLeftException(String msg) {
		super(msg);
	}

	public NoMoreDaysLeftException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoMoreDaysLeftException(Throwable cause) {
		super(cause);
	}

}
