/**
 * Copyright (c) 2000-present Liferay, Inc. All rights reserved.
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

package com.liferay.timetracking.activities.model;

import com.liferay.portal.model.PersistedModel;

/**
 * The extended model interface for the Activity service. Represents a row in the &quot;TimeTracking_Activity&quot; database table, with each column mapped to a property of this class.
 *
 * @author Laszlo Hudak, Adam T. Nagy
 * @see ActivityModel
 * @see com.liferay.timetracking.activities.model.impl.ActivityImpl
 * @see com.liferay.timetracking.activities.model.impl.ActivityModelImpl
 * @generated
 */
public interface Activity extends ActivityModel, PersistedModel {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify this interface directly. Add methods to {@link com.liferay.timetracking.activities.model.impl.ActivityImpl} and rerun ServiceBuilder to automatically copy the method declarations to this interface.
	 */
}