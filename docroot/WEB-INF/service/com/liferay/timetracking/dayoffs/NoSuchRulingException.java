/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.liferay.timetracking.dayoffs;

import com.liferay.portal.NoSuchModelException;

/**
 * @author László Hudák
 */
public class NoSuchRulingException extends NoSuchModelException {

	public NoSuchRulingException() {
		super();
	}

	public NoSuchRulingException(String msg) {
		super(msg);
	}

	public NoSuchRulingException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public NoSuchRulingException(Throwable cause) {
		super(cause);
	}

}