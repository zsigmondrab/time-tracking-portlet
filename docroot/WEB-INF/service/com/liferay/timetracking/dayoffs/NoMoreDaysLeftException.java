package com.liferay.timetracking.dayoffs;

public class NoMoreDaysLeftException extends Exception {

	public NoMoreDaysLeftException() {
		super();
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

	public NoMoreDaysLeftException(int remainingDays, int numberofDays) {
		super();
	}
}
