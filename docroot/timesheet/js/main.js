AUI.add(
	'timesheet',
	function(A) {

	var Lang = A.Lang,
		isArray = Lang.isArray,
		isBoolean = Lang.isBoolean,
		isDate = Lang.isDate,
		isFunction = Lang.isFunction,
		isNumber = Lang.isNumber,
		isObject = Lang.isObject,
		isString = Lang.isString,
		isUndefined = Lang.isUndefined,

		DataTypeDate = A.DataType.Date,
		DateMath = A.DataType.DateMath,
		WidgetStdMod = A.WidgetStdMod,

		_serialize = A.IO.prototype._serialize,

		BASE_WORK_TIME_VALUE = 28800000,

		_DOT = '.',
		_EMPTY_STR = '',
		_SPACE = ' ',

		TIMESHEET = "timesheet",
		TIMESHEET_BASE = "timesheet-base",
		TIMESHEET_DAY = "timesheet-day",
		TIMESHEET_DAYS = "timesheet-days",
		TIMESHEET_VIEW_MONTH = "timesheet-view-month",
		TIMESHEET_VIEW = 'timesheet-view',

		ACTIVE = 'active',
		ACTIVE_VIEW = 'activeView',
		ALL = 'all',
		BASE_WORK_TIME = 'baseWorkTime',
		BREAK_TIME = 'breakTime',
		BTN = 'btn',
		BUTTON = 'button',
		CHEVRON = 'chevron',
		COLGRID = 'colgrid',
		COLUMN = 'column',
		COLUMN_DAY_HEADER = 'columnDayHeader',
		COLUMN_HEADER_NODE = 'columnHeaderNode',
		COLUMN_ELEMENT_HEADER = 'columnElementHeader',
		COLUMN_TABLE_GRID = 'columnTableGrid',
		COMPANY_ID = 'companyId',
		CONTAINER = 'container',
		CONTENT = 'content',
		CONTROL = 'control',
		CONTROLS = 'controls',
		CONTROLS_NODE = 'controlsNode',
		DATA = 'data',
		DATE = 'date',
		DAY = 'day',
		DAY_OF_YEAR_ID = 'dayOfYearId',
		DAY_RECORDER = 'dayRecorder',
		DISABLED = 'disabled',
		DISPLAY_DAYS_INTERVAL = 'displayDaysInterval',
		DISPLAY_ROWS = 'displayRows',
		DIV = 'div',
		END_DATE = 'endDate',
		END_TIME = 'endTime',
		ELEMENT = 'element',
		FIELD_NAME
		FIRST = 'first',
		FORM = 'form',
		GRID = 'grid',
		HD = 'hd',
		HEADER = 'header',
		HEADER_DATE_FORMATTER = 'headerDateFormatter',
		HEADER_NODE = 'headerNode',
		HEADER_TABLE_NODE = 'headerTableNode',
		HIDDEN = 'hidden',
		ICON = 'icon',
		ICON_NEXT_NODE = 'iconNextNode',
		ICON_PREV_NODE = 'iconPrevNode',
		ICONS = 'icons',
		LEFT = 'left',
		LOCALE = 'locale',
		NAME = 'name',
		NAV = 'nav',
		NAV_NODE = 'navNode',
		NAVIGATION_DATE_FORMATTER = 'navigationDateFormatter',
		NEXT = 'next',
		NEXT_DATE = 'nextDate',
		NOSCROLL = 'noscroll',
		MEETING = 'meeting',
		MONTH = 'month',
		PAST = 'past',
		PREV = 'prev',
		PREV_DATE = 'prevDate',
		RECORDER = 'recorder',
		RENDERED = 'rendered',
		REMINDER = 'reminder',
		REPEATED = 'repeated',
		RIGHT = 'right',
		ROW = 'row',
		ROWS_CONTAINER_NODE = 'rowsContainerNode',
		SCROLLABLE = 'scrollable',
		SHORT = 'short',
		START_DATE = 'startDate',
		START_TIME = 'startTime',
		TABLE = 'table',
		TABLE_GRID_NODE = 'tableGridNode',
		TABLE_ROW_CONTAINER = 'tableRowContainer',
		TABLE_ROWS = 'tableRows',
		TBODY = 'tbody',
		TITLE = 'title',
		TIMESHEET_DAY = 'timesheetDay',
		TODAY = 'today',
		TODAY_NODE = 'todayNode',
		TODAY_DATE = 'todayDate',
		TR = 'tr',
		TRIGGER_NODE = 'triggerNode',
		USER_ID = 'userId',
		VIEW = 'view',
		VIEW_DATE = 'viewDate',
		VIEW_DATE_NODE = 'viewDateNode',
		VIEW_STACK = 'viewStack',
		VIEWS = 'views',
		VIEWS_NODE = 'viewsNode',
		WEEKEND = 'weekend',

		getNodeListHTMLParser = function(selector, sizeCondition) {
			return function(srcNode) {
				var nodes = srcNode.all(selector);

				return (nodes.size() >= sizeCondition) ? nodes : null;
			};
		},

		isModelList = function(val) {
			return val instanceof A.ModelList;
		},

		isTimesheetView = function(val) {
			return val instanceof Liferay.TimesheetView;
		},

		getCN = A.ClassNameManager.getClassName,

		CSS_BTN = getCN(BTN),
		CSS_FORM_CONTROL = getCN('form', 'control'),
		CSS_ICON = getCN(ICON),
		CSS_TIMESHEET_CONTROLS = getCN(TIMESHEET_BASE, CONTROLS),
		CSS_TIMESHEET_HD = getCN(TIMESHEET_BASE, HD),
		CSS_TIMESHEET_ICON_NEXT = getCN(TIMESHEET_BASE, ICON, NEXT),
		CSS_TIMESHEET_ICON_PREV = getCN(TIMESHEET_BASE, ICON, PREV),
		CSS_TIMESHEET_NAV = getCN(TIMESHEET_BASE, NAV),
		CSS_TIMESHEET_TODAY = getCN(TIMESHEET_BASE, TODAY),
		CSS_TIMESHEET_VIEW = getCN(TIMESHEET_BASE, VIEW),
		CSS_TIMESHEET_VIEW_ = getCN(TIMESHEET_BASE, VIEW, _EMPTY_STR),
		CSS_TIMESHEET_VIEW_COLUMN_DATA = getCN(TIMESHEET_BASE, VIEW, COLUMN, DATA),
		CSS_TIMESHEET_VIEW_DATE = getCN(TIMESHEET_BASE, VIEW, DATE),
		CSS_TIMESHEET_VIEW_NOSCROLL = getCN(TIMESHEET_VIEW, NOSCROLL),
		CSS_TIMESHEET_VIEW_SCROLLABLE = getCN(TIMESHEET_VIEW, SCROLLABLE),
		CSS_TIMESHEET_VIEW_SELECTED = getCN(ACTIVE),
		CSS_ICON_CHEVRON_RIGHT = "icon icon-chevron-right",
		CSS_ICON_CHEVRON_LEFT = "icon icon-chevron-left",
		CSS_TIMESHEET_VIEWS = getCN(TIMESHEET_BASE, VIEWS),

		CSS_TIMESHEET_DAY_RECORDER = getCN(TIMESHEET_DAY, RECORDER),
		CSS_TIMESHEET_DAY_RECORDER_CONTENT = getCN(TIMESHEET_DAY, RECORDER, CONTENT),
		CSS_TVT_COLGRID = getCN(TIMESHEET_VIEW, TABLE, COLGRID),
		CSS_TVT_COLGRID_FIRST = getCN(TIMESHEET_VIEW, TABLE, COLGRID, FIRST),
		CSS_TVT_COLGRID_TODAY = getCN(TIMESHEET_VIEW, TABLE, COLGRID, TODAY),
		CSS_TVT_CONTAINER = getCN(TIMESHEET_VIEW, TABLE, CONTAINER),
		CSS_TVT_HEADER_ELEMENT = getCN(TIMESHEET_VIEW, TABLE, HEADER, ELEMENT),
		CSS_TVT_HEADER_TABLE = getCN(TIMESHEET_VIEW, TABLE, HEADER, TABLE),
		CSS_TVT_HEADER_COLUMN = getCN(TIMESHEET_VIEW, TABLE, HEADER, COLUMN),
		CSS_TVT_ROW = getCN(TIMESHEET_VIEW, TABLE, ROW),
		CSS_TVT_ROW_TODAY = getCN(TIMESHEET_VIEW, TABLE, ROW, TODAY),
		CSS_TVT_ROW_WEEKEND = getCN(TIMESHEET_VIEW, TABLE, ROW, WEEKEND),
		CSS_TVT_ROW_CONTAINER = getCN(TIMESHEET_VIEW, TABLE, ROW, CONTAINER),
		CSS_TVT_TABLE_DATA = getCN(TIMESHEET_VIEW, TABLE, DATA),
		CSS_TVT_TABLE_DATA_COLUMN = getCN(TIMESHEET_VIEW, TABLE, DATA, COLUMN),
		CSS_TVT_TABLE_DATA_FIRST = getCN(TIMESHEET_VIEW, TABLE, DATA, FIRST),
		CSS_TVT_TABLE_GRID = getCN(TIMESHEET_VIEW, TABLE, GRID),
		CSS_TVT_TABLE_GRID_CONTAINER = getCN(TIMESHEET_VIEW, TABLE, GRID, CONTAINER),
		CSS_TVT_TABLE_GRID_FIRST = getCN(TIMESHEET_VIEW, TABLE, GRID, FIRST),

		TPL_FORM = '<form class="' + 'timesheet-day-recorder-form' + '" id="timesheetDayRecorderForm"></form>',
		TPL_RECORDER_BODY_CONTENT = '<input type="hidden" name="startDate" value="{startDate}" />' +
			'<input type="hidden" name="endDate" value="{endDate}" />' +
			'<input class="' + [CSS_TIMESHEET_DAY_RECORDER_CONTENT, CSS_FORM_CONTROL]
				.join(' ') + '" id="timesheedDayContent" name="content" value="{content}" />',
		TPL_RECORDER_HEADER_CONTENT = '<span class="field-name">{fieldName}</span>',
		TPL_TVT_CONTAINER = '<div class="' + CSS_TVT_CONTAINER + '">' +
						 '<div class="' + CSS_TVT_ROW_CONTAINER + '"></div>' +
						 '</div>',
		TPL_TVT_GRID_COLUMN = '<td class="' + CSS_TVT_COLGRID + '">&nbsp;</td>',
		TPL_TVT_HEADER_ELEMENT = '<th class="' + CSS_TVT_HEADER_ELEMENT + '"><div>&nbsp;</div></th>',
		TPL_TVT_HEADER_TABLE = '<table cellspacing="0" cellpadding="0" class="' + CSS_TVT_HEADER_TABLE + '">' +
						 '<tbody>' +
						 '<tr class="' + CSS_TVT_HEADER_COLUMN + '"></tr>' +
						 '</tbody>' +
					 '</table>',
		TPL_TVT_ROW = '<div class="' + CSS_TVT_ROW + '"></div>',
		TPL_TVT_TABLE_DATA = '<table cellspacing="0" cellpadding="0" class="' + CSS_TVT_TABLE_DATA + '">' +
					 '<tbody></tbody>' +
					 '</table>',
		TPL_TVT_TABLE_DATA_ROW = '<tr></tr>',
		TPL_TVT_TABLE_GRID = '<div class="' + CSS_TVT_TABLE_GRID_CONTAINER + '">' +
					 '<table cellspacing="0" cellpadding="0" class="' + CSS_TVT_TABLE_GRID + '">' +
					 '<tbody>' +
					 '<tr></tr>' +
					 '</tbody>' +
					 '</table></div>',
		TPL_TIMESHEET_CONTROLS = '<div class="span7 ' + CSS_TIMESHEET_CONTROLS + '"></div>',
		TPL_TIMESHEET_HD = '<div class="row-fluid ' + CSS_TIMESHEET_HD + '"></div>',
		TPL_TIMESHEET_ICON_NEXT = '<button type="button" class="' + [CSS_TIMESHEET_ICON_NEXT, "btn btn-default"].join(_SPACE) +
					 '"><i class="' + CSS_ICON_CHEVRON_RIGHT + '"></i></button>',
		TPL_TIMESHEET_ICON_PREV = '<button type="button" class="' + [CSS_TIMESHEET_ICON_PREV, "btn btn-default"].join(_SPACE) +
					 '"><i class="' + CSS_ICON_CHEVRON_LEFT + '"></i></button>',
		TPL_TIMESHEET_NAV = '<div class="btn-group"></div>',
		TPL_TIMESHEET_TODAY = '<button type="button" class="' + [CSS_TIMESHEET_TODAY, 'btn btn-default'].join(_SPACE) +
					 '">{today}</button>',
		TPL_TIMESHEET_VIEW = '<button type="button" class="' + [CSS_TIMESHEET_VIEW, CSS_TIMESHEET_VIEW_, "btn"].join(_SPACE) +
					 '{name}" data-view-name="{name}">{label}</button>',
		TPL_TIMESHEET_VIEW_COLUMN_DATA = '<span class="' + CSS_TIMESHEET_VIEW_COLUMN_DATA + '"></span>',
		TPL_TIMESHEET_VIEW_COLUMN_DATA_EDITOR = '<input placeholder="hh:mm" />',
		TPL_TIMESHEET_VIEW_DATE = '<span class="' + CSS_TIMESHEET_VIEW_DATE + '"></span>',
		TPL_TIMESHEET_VIEWS = '<div class="span5 ' + CSS_TIMESHEET_VIEWS + '"></div>';

	var TimesheetDay = A.Component.create({
		NAME: TIMESHEET_DAY,

		ATTRS: {
			breakTime: {
				validator: isNumber,
				value: 0
			},

			companyId: {
				validator: isNumber,
				value: themeDisplay.getCompanyId()
			},

			dayOfYearId: {
				validator: isNumber,
				value: 0
			},

			endDate: {
				validator: isDate
			},

			endTime: {
				validator: isNumber
			},

			id: {
				validator: isNumber,
				value: 0
			},

			rowIndex: {

			},

			startDate: {
				validator: isDate
			},

			startTime: {
				validator: isNumber
			},

			userId: {
				validator: isString,
				value: themeDisplay.getUserId()
			},

			userName: {
				validator: isString,
				value: themeDisplay.getUserName()
			}
		},

		EXTENDS: A.Model,

		prototype: {
			/**
			* TimesheetDay
			*/
			clone: function() {
				var instance = this;

				var cloned = null,
					timesheet = instance.get(TIMESHEET);

				if (timesheet) {
					cloned = new timesheet.dayModel();
					cloned.copyPropagateAttrValues(instance, null, {
						silent: true
					});
				}

				return cloned;
			},

			/**
			* TimesheetDay
			*/
			copyDates: function(timesheetDay, options) {
				var instance = this;

				instance.setAttrs({
					endDate: DateMath.clone(timesheetDay.get('endDate')),
					startDate: DateMath.clone(timesheetDay.get('startDate'))
				},
				options);
			},

			/**
			* TimesheetDay
			*/
			copyPropagateAttrValues: function(timesheetDay, dontCopyMap, options) {
				var instance = this;

				var	attrMap = {};

				A.Array.each(instance.constructor.PROPAGATE_ATTRS, function(attrName) {
					if (!((dontCopyMap || {}).hasOwnProperty(attrName))) {
						var value = timesheetDay.get(attrName);

						if (!isObject(value)) {
							attrMap[attrName] = value;
						}
					}
				});

				instance.setAttrs(attrMap, options);
			},

			getJSONAsParam: function() {
				var instance = this;

				var params = {
					endDate: instance.get('startDate'),
					id: instance.get('id'),
					breakTime: instance.get('breakTime'),
					startDate: instance.get('startDate'),
					userId: instance.get('userId')
				}
			}
		}
	});

	Liferay.TimesheetDay = TimesheetDay;

	Liferay.TimesheetDays = A.Base.create(TIMESHEET_DAYS, A.ModelList, [], {
		model: Liferay.TimesheetDay
	}, {
		ATTRS: {
			timesheet: {}
		}
	});

	var TimesheetDaySupport = function() {};

	TimesheetDaySupport.ATTRS = {};

	A.mix(TimesheetDaySupport.prototype, {
		dayModel: Liferay.TimesheetDay,
		daysModel: Liferay.TimesheetDays,

		/**
		* TimesheetDaySupport
		*/
		initializer: function(config) {
			var instance = this;

			instance._timesheetDaysAsObject = {};

			instance._timesheetDays = new instance.daysModel({
				after: {
					add: A.bind(instance._afterAddTimesheetDay, instance)
				},
				bubbleTargets: instance,
				originalItems: [],
				TIMESHEET: instance
			});

			var timesheetDays = config.items || config.timesheetDays;

			if (timesheetDays) {
				instance.addTimesheetDays(timesheetDays);
			}
		},

		/**
		* TimesheetDaySupport
		*/
		addTimesheetDays: function(model) {
			var instance = this;

			var	timesheetDays = instance._toTimesheetDays(model);

			return instance._timesheetDays.add(timesheetDays);
		},

		/**
		* TimesheetDaySupport
		*/
		calculateAllTime: function(timesheetDay) {
			var instance = this;

			var endTime = timesheetDay.get(END_DATE),
				startTime = timesheetDay.get(START_DATE),
				allTime = '';

			if (endTime && startTime) {
				allTime = endTime.getTime() - startTime.getTime();
			}

			return allTime;
		},

		/**
		* TimesheetDaySupport
		*/
		calculateOverTime: function(timesheetDay) {
			var instance = this;

			var workTime = instance.calculateWorkTime(timesheetDay),
				baseWorkTime = instance.get(BASE_WORK_TIME),
				overTime = '';

			if (isNumber(workTime) && isNumber(baseWorkTime)) {
				overTime = workTime - baseWorkTime;
			}

			return overTime;
		},

		/**
		* TimesheetDaySupport
		*/
		calculateWorkTime: function(timesheetDay) {
			var instance = this;

			var endTime = timesheetDay.get(END_DATE),
				breakTime = timesheetDay.get(BREAK_TIME),
				startTime = timesheetDay.get(START_DATE),
				workTime = '';

			if (endTime && startTime && breakTime) {
				workTime = endTime.getTime() - startTime.getTime() - (breakTime * 60000);
			}

			return workTime
		},

		/**
		* TimesheetDaySupport
		*/
		getTimesheetDays: function(filterFn, skipSort) {
			var instance = this;

			var	timesheetDays = instance._timesheetDays;

			if (!skipSort) {
				timesheetDays.sort({
					silent: true
				});
			}

			if (filterFn) {
				timesheetDays = timesheetDays.filter(filterFn);
			}
			else {
				timesheetDays = timesheetDays.toArray();
			}

			return timesheetDays;
		},

		/**
		* TimesheetDaySupport
		*/
		_afterAddTimesheetDay: function(event) {
			var instance = this;

			var	timesheetDay = event.model,
				timesheetDaysAsObject = instance._timesheetDaysAsObject,
				startDate, endDate;

			endDate = new Date(timesheetDay.get('endTime'));
			timesheetDay.set('endDate', endDate);

			startDate = new Date(timesheetDay.get('startTime'));
			timesheetDay.set('startDate', startDate);

			timesheetDay.set(TIMESHEET, instance);

			timesheetDaysAsObject[String((DateMath.toMidnight(DateMath.clone(startDate))).getTime())] = timesheetDay;
		},

		/**
		* TimesheetDaySupport
		*/
		invokeResourceURL: function(resourceId, parameters, callback) {
			var instance = this;

			var url = Liferay.PortletURL.createResourceURL();

			url.setPortletId('2_WAR_timetrackingportlet');
			url.setResourceId(resourceId);

			A.each(
				parameters,
				function(item, index, collection) {
					url.setParameter(index, item);
				}
			);

			A.io.request(
				url.toString(),
				{
					dataType: 'json',
					on: {
						success: function() {
							callback(this.get('responseData'));
						}
					}
				}
			);
		},

		invokeService: function(payload, callback) {
			var instance = this;

			callback = callback || {};

			A.io.request(
				'/api/jsonws/invoke',
				{
					cache: false,
					data: {
						cmd: A.JSON.stringify(payload),
						p_auth: Liferay.authToken
					},
					dataType: 'JSON',
					on: {
						failure: callback.failure,
						start: callback.start,
						success: function(event) {
							if (callback.success) {
								var data = this.get('responseData');

								callback.success.apply(this, [data, event]);
							}
						}
					}
				}
			);
		},

		/**
		* TimesheetDaySupport
		*/
		_toTimesheetDays: function(values) {
			var instance = this;

			var	timesheetDays = [];

			if (isModelList(values)) {
				timesheetDays = values.toArray();
				values.set(TIMESHEET, instance);
			}
			else if (isArray(values)) {
				A.Array.each(values, function(value) {
					if (isModelList(value)) {
						timesheetDays = timesheetDays.concat(value.toArray());
						value.set(TIMESHEET, instance);
					}
					else {
						timesheetDays.push(value);
					}
				});
			}
			else {
				timesheetDays = values;
			}

			return timesheetDays;
		}
	});

	Liferay.TimesheetDaySupport = TimesheetDaySupport;

	var TimesheetBase =  A.Component.create({
		NAME: TIMESHEET_BASE,

		ATTRS: {
			activeView: {
				validator: isTimesheetView
			},

			baseWorkTime: {
				validator: isNumber,
				value: BASE_WORK_TIME_VALUE
			},

			controlsNode: {
				valueFn: function() {
					return A.Node.create(TPL_TIMESHEET_CONTROLS);
				}
			},

			date: {
				validator: isDate,
				value: new Date()
			},

			dayRecorder: {
				setter: '_setDayRecorder'
			},

			firstDayOfWeek: {
				validator: isNumber,
				value: 0
			},

			headerNode: {
				valueFn: function() {
					return A.Node.create(TPL_TIMESHEET_HD);
				}
			},

			iconNextNode: {
				valueFn: function() {
					return A.Node.create(TPL_TIMESHEET_ICON_NEXT);
				}
			},

			iconPrevNode: {
				valueFn: function() {
					return A.Node.create(TPL_TIMESHEET_ICON_PREV);
				}
			},

			navigationDateFormatter: {
				validator: isFunction,
				value: function(date) {
					var instance = this;

					return A.DataType.Date.format(
						date, {
							format: '%B %d, %Y',
							locale: instance.get(LOCALE)
						}
					);
				}
			},

			navNode: {
				valueFn: function() {
					return A.Node.create(TPL_TIMESHEET_NAV);
				}
			},

			strings: {
				value: {
					day: 'Day',
					month: 'Month',
					today: 'Today',
					week: 'Week',
					year: 'Year'
				}
			},

			todayDate: {
				validator: isDate,
				value: new Date()
			},

			todayNode: {
				valueFn: function() {
					return A.Node.create(
						this._processTemplate(TPL_TIMESHEET_TODAY)
					);
				}
			},

			userId: {
				value: 0
			},

			viewsNode: {
				valueFn: function() {
					return A.Node.create(TPL_TIMESHEET_VIEWS);
				}
			},

			viewDate: {
				getter: '_getViewDate',
				readOnly: true
			},

			viewDateNode: {
				valueFn: function() {
					return A.Node.create(TPL_TIMESHEET_VIEW_DATE);
				}
			},

			views: {
				setter: '_setViews',
				value: []
			}
		},

		HTML_PARSER: {
			controlsNode: _DOT + CSS_TIMESHEET_CONTROLS,
			viewDateNode: _DOT + CSS_TIMESHEET_VIEW_DATE,
			headerNode: _DOT + CSS_TIMESHEET_HD,
			iconNextNode: _DOT + CSS_TIMESHEET_ICON_NEXT,
			iconPrevNode: _DOT + CSS_TIMESHEET_ICON_PREV,
			navNode: _DOT + CSS_TIMESHEET_NAV,
			todayNode: _DOT + CSS_TIMESHEET_TODAY,
			viewsNode: _DOT + CSS_TIMESHEET_VIEWS
		},

		UI_ATTRS: [DATE, ACTIVE_VIEW],

		AUGMENTS: [Liferay.TimesheetDaySupport, A.WidgetStdMod],

		prototype: {
			/**
			* TimesheetBase
			*/
			initializer: function() {
				var instance = this;

				instance[VIEW_STACK] = {};

				instance[CONTROLS_NODE] = instance.get(CONTROLS_NODE);
				instance[VIEW_DATE_NODE] = instance.get(VIEW_DATE_NODE);
				instance[HEADER] = instance.get(HEADER_NODE);
				instance[ICON_NEXT_NODE] = instance.get(ICON_NEXT_NODE);
				instance[ICON_PREV_NODE] = instance.get(ICON_PREV_NODE);
				instance[NAV_NODE] = instance.get(NAV_NODE);
				instance[TODAY_NODE] = instance.get(TODAY_NODE);
				instance[VIEWS_NODE] = instance.get(VIEWS_NODE);

				instance.after({
					activeViewChange: instance._afterActiveViewChange,
					render: instance._afterRender
				});

				this.publish({
					viewTimesheetDays: {
					defaultFn: this._viewTimesheetDaysFn
					}
				});
			},

			/**
			* TimesheetBase
			*/
			bindUI: function() {
				var instance = this;

				instance._bindDelegate();
			},

			/**
			* TimesheetBase
			*/
			viewTimesheetDays: function(view) {
				var instance = this;

				view.viewTimesheetDays(
					instance.getTimesheetDays()
				);
			},

			/**
			* TimesheetBase
			*/
			renderButtonGroup: function() {
				var instance = this;

				instance.buttonGroup = new A.ButtonGroup({
					boundingBox: instance[VIEWS_NODE],
					on: {
						selectionChange: A.bind(instance._onButtonGroupSelectionChange, instance)
					}
				}).render();
			},

			/**
			* TimesheetBase
			*/
			renderView: function(view) {
				var instance = this;

				if (view) {
					view.show();

					if (!view.get(RENDERED)) {
						if (!instance.bodyNode) {
								instance.setStdModContent(WidgetStdMod.BODY, _EMPTY_STR);
						}

						view.render(instance.bodyNode);
					}
				}
			},

			syncTimesheetDayUI: function(timesheetDay) {
				var instance = this;

				var activeview =  instance.get(ACTIVE_VIEW);;

				if (activeview) {
					if (timesheetDay) {
						var headerElements = activeview.get('headerElements'),
							headerElementsCount = headerElements.length;

						activeview._syncTimesheetDayNodeUI(timesheetDay, headerElementsCount);
					}
				}
			},

			/**
			* TimesheetBase
			*/
			syncStdContent: function() {
				var instance = this;

				var views = instance.get(VIEWS);

				instance[NAV_NODE].append(instance[ICON_PREV_NODE]);
				instance[NAV_NODE].append(instance[ICON_NEXT_NODE]);

				instance[CONTROLS_NODE].append(instance[TODAY_NODE]);
				instance[CONTROLS_NODE].append(instance[NAV_NODE]);
				instance[CONTROLS_NODE].append(instance[VIEW_DATE_NODE]);

				A.Array.each(views, function(view) {
						instance[VIEWS_NODE].append(instance._createViewTriggerNode(view));
				});

				instance[HEADER].append(instance[CONTROLS_NODE]);
				instance[HEADER].append(instance[VIEWS_NODE]);

				instance.setStdModContent(WidgetStdMod.HEADER, instance[HEADER].getDOM());
			},

			/**
			* TimesheetBase
			*/
			syncUI: function() {
				var instance = this;

				instance.syncStdContent();
			},

			/**
			* TimesheetBase
			*/
			_afterActiveViewChange: function(event) {
				var instance = this;

				if (instance.get(RENDERED)) {
					var activeView = event.newVal;
					var lastActiveView = event.prevVal;

					if (lastActiveView) {
						lastActiveView.hide();
					}

					instance.renderView(activeView);

					var eventRecorder = instance.get(DAY_RECORDER);

					if (eventRecorder) {
						eventRecorder.hidePopover();
					}

					instance._uiSetDate(instance.get(DATE));
				}
			},

			/**
			* TimesheetBase
			*/
			_afterRender: function(event) {
				var instance = this;

				var	activeView = instance.get(ACTIVE_VIEW);

				instance.renderView(activeView);
				instance.renderButtonGroup();

				instance._uiSetDate(instance.get(DATE));
				instance._uiSetActiveView(activeView);
			 },

			/**
			* TimesheetBase
			*/
			_bindDelegate: function() {
				var instance = this;

				instance[CONTROLS_NODE].delegate('click', instance._onClickPrevIcon, _DOT + CSS_TIMESHEET_ICON_PREV, instance);
				instance[CONTROLS_NODE].delegate('click', instance._onClickNextIcon, _DOT + CSS_TIMESHEET_ICON_NEXT, instance);
				instance[CONTROLS_NODE].delegate('click', instance._onClickToday, _DOT + CSS_TIMESHEET_TODAY, instance);
			},

			/**
			* TimesheetBase
			*/
		 	_createViewTriggerNode: function(view) {
				var instance = this;

				if (!view.get(TRIGGER_NODE)) {
					var name = view.get(NAME);

					view.set(
						TRIGGER_NODE,
						A.Node.create(
							Lang.sub(TPL_TIMESHEET_VIEW, {
								name: name,
								label: (instance.getString(name) || name)
							})
						)
					);
				}

				return view.get(TRIGGER_NODE);
			},

			/**
			* TimesheetBase
			*/
			_setDayRecorder: function(val) {
				var instance = this;

				if (val) {
					val.setAttrs({
						timesheet: instance
					}, {
						silent: true
					});

					val.addTarget(instance);
				}
			},

			/**
			* TimesheetBase
			*/
			_viewTimesheetDaysFn: function() {
				this.viewTimesheetDays(this.get('activeView'));
			},

			/**
			* TimesheetBase
			*/
			_getViewDate: function() {
				var instance = this;

				var	date = instance.get(DATE),
					activeView = instance.get(ACTIVE_VIEW);

				if (activeView) {
						date = activeView.getAdjustedViewDate(date);
				}

				return date;
			},

			/**
			* TimesheetBase
			*/
			_onButtonGroupSelectionChange: function(event) {
				var instance = this;

				var	viewName = event.originEvent.target.attr(DATA_VIEW_NAME);

				//instance.set(ACTIVE_VIEW, instance.getViewByName(viewName));

				event.preventDefault();
			},

			/**
			* TimesheetBase
			*/
			_onClickToday: function(event) {
				var instance = this;

				var activeView = instance.get(ACTIVE_VIEW);

				if (activeView) {
					instance.set(DATE, instance.get(TODAY_DATE));
				}

				event.preventDefault();
			},

			/**
			* TimesheetBase
			*/
			_onClickNextIcon: function(event) {
				var instance = this;

				var	activeView = instance.get(ACTIVE_VIEW);

				if (activeView) {
					instance.set(DATE, activeView.get(NEXT_DATE));
				}

				event.preventDefault();
			},

			/**
			* TimesheetBase
			*/
			_onClickPrevIcon: function(event) {
				var instance = this;

				var	activeView = instance.get(ACTIVE_VIEW);

				if (activeView) {
					instance.set(DATE, activeView.get(PREV_DATE));
				}

				event.preventDefault();
			},

			/**
			* TimesheetBase
			*/
			_processTemplate: function(tpl) {
				var instance = this;

				return Lang.sub(tpl, instance.getStrings());
			},

			/**
			* TimesheetBase
			*/
			_setViews: function(val) {
				var instance = this;

				var views = [];

				A.Array.each(val, function(view) {
					if (isTimesheetView(view) && !view.get(RENDERED)) {
							view.setAttrs({
							timesheet: instance
						});

						views.push(view);

						instance[VIEW_STACK][view.get(NAME)] = view;
					}
				});

				if (!instance.get(ACTIVE_VIEW)) {
						instance.set(ACTIVE_VIEW, val[0]);
				}

				return views;
			},

			/**
			* TimesheetBase
			*/
			_uiSetActiveView: function(val) {
				var instance = this;

				if (val) {
					var activeView = val.get(NAME),
						activeNav = instance[VIEWS_NODE].one(_DOT + CSS_TIMESHEET_VIEW_ + activeView);

					if (activeNav) {
						instance[VIEWS_NODE].all(BUTTON).removeClass(CSS_TIMESHEET_VIEW_SELECTED);
						activeNav.addClass(CSS_TIMESHEET_VIEW_SELECTED);
					}
				}
			},

			/**
			* TimesheetBase
			*/
			_uiSetDate: function(val) {
				var instance = this;

				var	formatter = instance.get(NAVIGATION_DATE_FORMATTER),
					navigationTitle = formatter.call(instance, val);

				if (instance.get(RENDERED)) {
					var activeView = instance.get(ACTIVE_VIEW);

					if (activeView) {
						activeView._uiSetDate(val);

						formatter = activeView.get(NAVIGATION_DATE_FORMATTER);
						navigationTitle = formatter.call(activeView, val);
					}

					instance[VIEW_DATE_NODE].html(navigationTitle);
				}
			}
		}
	});

	Liferay.Timesheet = TimesheetBase;

	var TimesheetView = A.Component.create({
		NAME: TIMESHEET_VIEW,

		ATTRS: {
			bodyContent: {
					value: _EMPTY_STR
			},

			height: {
					value: 1000
			},

			name: {
				validator: isString,
				value: _EMPTY_STR,
			},

			navigationDateFormatter: {
				validator: isFunction,
				value: function(date) {
					var instance = this;

					var timesheet = instance.get(TIMESHEET);

					return A.DataType.Date.format(date, {
						format: '%A, %d %B, %Y',
						locale: timesheet.get(LOCALE)
					});
				}
			},

			nextDate: {
				getter: 'getNextDate',
				readOnly: true
			},

			prevDate: {
				getter: 'getPrevDate',
				readOnly: true
			},

			scrollable: {
				validator: isBoolean,
				value: true
			},

			timesheet: {
				lazyAdd: false,
				setter: '_setTimesheet'
			},

			userId: {
				value: 0
			}
		},

		AUGMENTS: [A.WidgetStdMod],

		BIND_UI_ATTRS: [SCROLLABLE],

		prototype: {
			/**
			* TimesheetView
			*/
			initializer: function() {
				var instance = this;

				instance.after('render', instance._afterRender);
			},

			/**
			* TimesheetView
			*/
			syncUI: function() {
				var instance = this;

				instance.syncStdContent();
			},

			/**
			* TimesheetView
			*/
			flushViewCache: function() {},

			/**
			* TimesheetView
			*/
			getNextDate: function() {},

			/**
			* TimesheetView
			*/
			getPrevDate: function() {},

			/**
			* TimesheetView
			*/
			getToday: function() {
				return DateMath.toMidnight(new Date());
			},

			/**
			* TimesheetView
			*/
			syncStdContent: function() {},

			/**
			* TimesheetView
			*/
			syncEventUI: function(timesheetDay) {},

			/**
			* TimesheetView
			*/
			_afterRender: function(event) {
				var instance = this;

				instance._uiSetScrollable(
						instance.get(SCROLLABLE)
				);
			},

			/**
			* TimesheetView
			*/
			_uiSetDate: function(val) {},

			/**
			* TimesheetView
			*/
			_uiSetScrollable: function(val) {
				var instance = this;

				var bodyNode = instance.bodyNode;

				if (bodyNode) {
					bodyNode.toggleClass(CSS_TIMESHEET_VIEW_SCROLLABLE, val);
					bodyNode.toggleClass(CSS_TIMESHEET_VIEW_NOSCROLL, !val);
				}
			},

			/**
			* TimesheetView
			*/
			_setTimesheet: function(timesheet) {
				var instance = this;

				var oldTimesheet = instance.get(TIMESHEET);

				if (oldTimesheet) {
						instance.removeTarget(oldTimesheet);
				}

				if (timesheet) {
					instance.addTarget(timesheet);

					timesheet.after(['*:add', '*:remove', '*:reset'], A.bind(instance.flushViewCache, instance));
				}

				return timesheet;
			}
		}
	});

	Liferay.TimesheetView = TimesheetView;

	var TimesheetMonthView = A.Component.create({

		NAME: TIMESHEET_VIEW_MONTH,

		ATTRS: {
			bodyContent: {
				value: _EMPTY_STR
			},

			name: {
				value: MONTH
			},

			columnHeaderNode: {
				valueFn: '_valueColumnHeaderNode'
			},

			headerElements: {
				validator: isArray,
				value: []
			},

			headerDateFormatter: {
				validator: isString,
				value: function(date) {
					var instance = this;

					var timesheet = instance.get(TIMESHEET);

					return A.DataType.Date.format(
						date, {
							format: '%d. %A',
							locale: timesheet.get(LOCALE)
						}
					);
				}
			},

			rowDateFormatter: {
				validator: isString,
				value: function(date) {
					var instance = this;

					var timesheet = instance.get(TIMESHEET);

					return A.DataType.Date.format(
						date, {
							format: '%X',
							locale: timesheet.get(LOCALE)
						}
					);
				}
			},

			headerTableNode: {
				valueFn: function() {
					return A.Node.create(TPL_TVT_HEADER_TABLE);
				}
			},

			hourMinutesFormatter: {
				validator: isString,
				value: function(time) {
					var instance = this;

					var timesheet = instance.get(TIMESHEET),
						hours = time / (60 * 60 * 1000),
						minutes = Math.abs((time % (60 * 60 * 1000)) / (60 * 1000));

					if (hours < 10) {
						if (hours < 0) {
							hours = '-0' + Math.floor(Math.abs(hours));
						}
						else {
							hours = '0' + Math.floor(hours);
						}
					}
					else {
						hours = Math.floor(hours);
					}

					if (minutes < 10) {
						minutes = '0' + minutes;
					}

					return hours + ':' + minutes;
				}
			},

			navigationDateFormatter: {
				value: function(date) {
					var instance = this;

					var timesheet = instance.get(TIMESHEET);

					return DataTypeDate.format(
						date, {
							format: '%B %Y',
							locale: timesheet.get(LOCALE)
						}
					);
				},
				validator: isFunction
			},

			rowsContainerNode: {
				valueFn: function() {
					return A.Node.create(TPL_TVT_CONTAINER);
				}
			},

			scrollable: {
				value: false
			},

			strings: {
				value: {
					close: 'Close',
					show: 'Show',
					more: 'more'
				}
			},

			today: {
				value: new Date()
			},

			userId: {
				value: 0
			}
		},

		HTML_PARSER: {
			headerElements: getNodeListHTMLParser(_DOT + CSS_TVT_HEADER_COLUMN, 7),
			headerTableNode: _DOT + CSS_TVT_HEADER_TABLE,
			rowsContainerNode: _DOT + CSS_TVT_CONTAINER
		},

		EXTENDS: Liferay.TimesheetView,

		prototype: {
			timesheetDayRowStack: null,
			rowDataTableStack: null,

			/**
			* TimesheetMonthView
			*/
			initializer: function() {
				var instance = this;

				instance.timesheetDayRowStack = {};
				instance.rowDataTableStack = {};
				instance.timesheetDayRowStacks = {};

				instance[COLUMN_HEADER_NODE] = instance.get(COLUMN_HEADER_NODE);
				instance[HEADER_TABLE_NODE] = instance.get(HEADER_TABLE_NODE);
				instance[ROWS_CONTAINER_NODE] = instance.get(ROWS_CONTAINER_NODE);
				instance[COLUMN_ELEMENT_HEADER] = instance.headerTableNode.one(_DOT + CSS_TVT_HEADER_COLUMN);
				instance[COLUMN_TABLE_GRID] = A.NodeList.create();
				instance[TABLE_ROW_CONTAINER] = instance[ROWS_CONTAINER_NODE].one(_DOT + CSS_TVT_ROW_CONTAINER);
			},

			/**
			* TimesheetMonthView
			*/
			renderUI: function() {
				var instance = this;

				instance[COLUMN_HEADER_NODE].appendTo(instance[COLUMN_ELEMENT_HEADER]);
			},

			bindUI: function() {
				var instance = this;
			},

			// This is not necesseraly
			/**
			* TimesheetMonthView
			*/
			buildEventsRow: function(rowStartDate, rowEndDate) {
				var instance = this;

				var displayRows = instance.get(DISPLAY_ROWS),
					rowRenderedColumns = 0,
					timesheet = instance.get('timesheet'),
					timesheetDaysAsObject = timesheet._timesheetDaysAsObject;

				instance.loopDates(rowStartDate, rowEndDate, function(celDate, index) {
					var timesheetDay = timesheetDaysAsObject[rowStartDate.getDate()];

					rowRenderedColumns++;
				});

				return rowNode;
			},

			/**
			* TimesheetMonthView
			*/
			buildGridRowNode: function(celDate, index) {
				var instance = this;

				var	tableGridNode = instance._getTableGridNode(celDate, index),
					rowNode = A.Node.create(TPL_TVT_ROW);

				rowNode.append(tableGridNode);

				return rowNode;
			},

			/**
			* TimesheetMonthView
			*/
			getAdjustedViewDate: function(val) {
				var instance = this;

				return DateMath.toMidnight(DateMath.findMonthStart(val));
			},

			/**
			* TimesheetMonthView
			*/
			getNextDate: function() {
				var instance = this;

				var	timesheet = instance.get(TIMESHEET),
					viewDate = timesheet.get(VIEW_DATE);

				return DateMath.toLastHour(DateMath.add(viewDate, DateMath.MONTH, 1));
			},

			/**
			* TimesheetMonthView
			*/
			getPrevDate: function() {
				var instance = this;

				var timesheet = instance.get(TIMESHEET),
					viewDate = timesheet.get(VIEW_DATE);

				return DateMath.toMidnight(DateMath.subtract(viewDate, DateMath.MONTH, 1));
			},

			/**
			* TimesheetMonthView
			*/
			getRowsNumber: function() {
				var instance = this;

				var	intervalStartDate = instance._findCurrentIntervalStart(),
					startDateRef = DateMath.safeClearTime(intervalStartDate),
					rowEndDate = DateMath.safeClearTime(DateMath.findMonthEnd(startDateRef));

				return rowEndDate.getDate();
			},

			/**
			* TimesheetMonthView
			*/
			loopDates: function(startDate, endDate, fn) {
				var instance = this;

				var curDate = DateMath.clone(startDate),
					endDateMs = endDate.getTime(),
					index;

				for (index = 0; curDate.getTime() <= endDateMs; index++) {
					fn.apply(instance, [curDate, index]);

					curDate = DateMath.add(curDate, DateMath.DAY, 1);
				}
			},

			/**
			* TimesheetMonthView
			*/
			viewTimesheetDays: function(timesheetDays) {
				var instance = this;

				var intervalStartDate = instance._findCurrentIntervalStart(),
					startDateRef = DateMath.safeClearTime(intervalStartDate),
					timesheet = instance.get(TIMESHEET),
					viewDate = timesheet.get(VIEW_DATE),
					monthEnd = DateMath.findMonthEnd(viewDate),
					monthStart = DateMath.findMonthStart(viewDate);

				instance.flushViewCache();

				instance.bodyNode.all(_DOT + CSS_TVT_TABLE_DATA).remove();

				instance[TABLE_ROWS].each(function(rowNode, index) {
					var rowStartDate = DateMath.add(monthStart, DateMath.DAY, index);
					var rowEndDate = DateMath.add(monthStart, DateMath.DAY, index + 1);
					var timesheet = instance.get(TIMESHEET);

					var timesheetDay = timesheet._timesheetDaysAsObject[String(rowStartDate.getTime())];

					instance._buildTimesheetDay(timesheetDay, index);

					rowNode.delegate(
						'mousedown',
						A.bind(instance._onMouseDownGrid, instance),
						'.timesheet-day-content');

					rowNode.delegate(
						'mouseup',
						A.bind(instance._onMouseUpGrid, instance),
						'.timesheet-day-content');
				});
			},

			/**
			* TimesheetMonthView
			*/
			syncElementsHeaderUI: function() {
				var instance = this;

				var timesheet = instance.get(TIMESHEET),
					headerElements = instance.get('headerElements');

				instance.columnHeaderNode.all(DIV).each(
					function(columnNode, i) {
							columnNode.html(headerElements[i]);
					}
				);
			},

			/**
			* TimesheetMonthView
			*/
			syncGridUI: function() {
				var instance = this;

				var	intervalStartDate = instance._findCurrentIntervalStart(),
					startDateRef = DateMath.toMidnight(intervalStartDate),
					intervalStartDate = DateMath.toMidnight(DateMath.findMonthStart(startDateRef)),
					intervalEndDate = DateMath.toMidnight(DateMath.findMonthEnd(startDateRef)),
					cacheKey = String(intervalStartDate.getTime()).concat(intervalStartDate.getTime()).concat(intervalEndDate.getTime()),
					rowDataTableNode = instance.rowDataTableStack[cacheKey],
					timesheet = instance.get(TIMESHEET);

				if (!rowDataTableNode) {
					var params = {};

					params.userId = instance.get('userId');
					params.intervalStartTime = intervalStartDate.getTime();
					params.intervalEndTime = intervalEndDate.getTime();

					timesheet.invokeResourceURL(
						"timesheetDays",
						params,
						function(items) {
							timesheet.addTimesheetDays(items);

							instance[TABLE_ROWS] = A.NodeList.create();
							instance[TABLE_GRID_NODE] = instance._valueTableGridNode();

							instance.loopDates(
								intervalStartDate,
								intervalEndDate,
								function(celDate, index) {
									instance[TABLE_ROWS].push(instance.buildGridRowNode(celDate, index));
								}
							);

							instance.rowDataTableStack[cacheKey] = instance[TABLE_ROWS];
							instance.timesheetDayRowStacks[cacheKey] = A.clone(instance.timesheetDayRowStack);

							timesheet.fire('viewTimesheetDays');

							instance[TABLE_ROW_CONTAINER].setHTML(instance[TABLE_ROWS]);
						}
					);
				}
				else {
					instance[TABLE_ROWS] = rowDataTableNode;
					instance.timesheetDayRowStack = instance.timesheetDayRowStacks[cacheKey];

					instance[TABLE_ROW_CONTAINER].setHTML(instance[TABLE_ROWS]);
				}
			},

			/**
			* TimesheetMonthView
			*/
			syncStdContent: function() {
				var instance = this;

				instance.setStdModContent(
					WidgetStdMod.BODY, instance[ROWS_CONTAINER_NODE].getDOM());

				instance.setStdModContent(
					WidgetStdMod.HEADER, instance[HEADER_TABLE_NODE].getDOM());
			},

			/**
			* TimesheetMonthView
			*/
			_buildTimesheetDay: function(timesheetDay, index) {
				var instance = this;

				var	timesheet = instance.get(TIMESHEET);

				if (timesheetDay) {
					var headerElements = instance.get('headerElements'),
						headerElementsCount = headerElements.length;

					timesheetDay.set('rowIndex', index);

					instance._syncTimesheetDayNodeUI(timesheetDay, headerElementsCount);
				}
			},

			/**
			* TimesheetMonthView
			*/
			_findCurrentIntervalEnd: function() {
				var instance = this;

				var	timesheet = instance.get(TIMESHEET),
					viewDate = timesheet.get(VIEW_DATE),
					displayDaysInterval = instance.get(DISPLAY_DAYS_INTERVAL);

				return DateMath.add(viewDate, DateMath.DAY, displayDaysInterval);
			},

			/**
			* TimesheetMonthView
			*/
			_findCurrentIntervalStart: function() {
				var instance = this;

				var	timesheet = instance.get(TIMESHEET),
					startDate = instance.get('today');

				if (timesheet) {
					startDate = timesheet.get(VIEW_DATE);
				}

				return startDate;
			},

			/**
			* TimesheetMonthView
			*/
			_getTableGridNode: function(celDate, index) {
				var instance = this;

				var	headerElements = instance.get('headerElements'),
					headerElementsCount = headerElements.length,
					tableGridNode = instance[TABLE_GRID_NODE].item(index),
					firstRowNode = tableGridNode.one(TR),
					i;

				var formatter = instance.get(HEADER_DATE_FORMATTER);

				if (!instance.timesheetDayRowStack[String(index)]) {
					instance.timesheetDayRowStack[String(index)] = {};
				}

				for (i = 0; i < headerElementsCount; i++) {
					var columnNode = A.Node.create(TPL_TVT_GRID_COLUMN);

					firstRowNode.append(columnNode);

					if (i === 0) {
						columnNode.addClass(CSS_TVT_COLGRID_FIRST);
						columnNode.append(formatter.call(instance, celDate));
					}
					else if (i === 1) {
						columnNode.addClass('timesheet-day-content');
						columnNode.setData(FIELD_NAME, START_TIME);
					}
					else if (i === 2) {
						columnNode.addClass('timesheet-day-content');
						columnNode.setData(FIELD_NAME, END_TIME);
					}
					else if (i === 3) {
						columnNode.addClass('timesheet-day-content');
						columnNode.setData(FIELD_NAME, BREAK_TIME);
					}

					if (i === 1 || i === 2 || i === 3) {
						columnNode.setData('date', celDate);
						columnNode.setData('rowIndex', index);
					}

					if (DateMath.isToday(celDate)) {
						columnNode.addClass(CSS_TVT_ROW_TODAY);
					}

					if (!DateMath.isWeekDay(celDate)) {
						columnNode.addClass(CSS_TVT_ROW_WEEKEND);
					}

					instance.timesheetDayRowStack[String(index)][String(i)] = columnNode;
				}

				return tableGridNode;
			},

			_onMouseDownGrid: function(event) {
				var instance = this;

				var timesheet = instance.get(TIMESHEET),
					recorder = timesheet.get(DAY_RECORDER);
					currentTarget = event.currentTarget;

				if (recorder && !timesheet.get('disabled') && currentTarget.test('.timesheet-day-content')) {
					instance._recording = true;
				}
			},

			_onMouseUpGrid: function(event) {
				var instance = this;

				var	timesheet = instance.get(TIMESHEET),
					recorder = timesheet.get(DAY_RECORDER),
					currentTarget = event.currentTarget;

				if (recorder && instance._recording && !timesheet.get('disabled')) {
					var selectedNode = recorder.get('selectedNode');

					recorder.hidePopover();

					if (selectedNode) {
						selectedNode.removeClass('timesheet-selected-content');
					}

					var timesheetDay = currentTarget.getData(TIMESHEET_DAY);

					recorder.set('selectedColumnName', currentTarget.getData(FIELD_NAME));

					if (timesheetDay) {
						recorder.set(TIMESHEET_DAY, timesheetDay);
					}

					currentTarget.addClass('timesheet-selected-content');

					recorder.set('selectedNode', currentTarget);
					recorder.showPopover(currentTarget);

					instance._recording = false;
				}
			},

			/**
			* TimesheetMonthView
			*/
			_syncTimesheetDayNodeUI: function(timesheetDay, headerElementsCount) {
				var instance = this;

				var timesheet = instance.get(TIMESHEET),
					rowDateFormatter = instance.get('rowDateFormatter'),
					i,
					hourMinutesFormatter = instance.get('hourMinutesFormatter'),
					rowIndex = timesheetDay.get('rowIndex'),
					timesheetDayRow = instance.timesheetDayRowStack[String(rowIndex)];

				for (i = 1; i < headerElementsCount; i++) {
					var timesheetDayNode = timesheetDayRow[String(i)],
						columnDataNode = A.Node.create(TPL_TIMESHEET_VIEW_COLUMN_DATA);

					timesheetDayNode.setData(TIMESHEET_DAY, timesheetDay);

					if ((i == 1) && timesheetDay.get(START_DATE)) {
						columnDataNode.html(rowDateFormatter.call(instance, timesheetDay.get(START_DATE)));
					}
					else if ((i == 2) && timesheetDay.get(END_DATE)) {
						columnDataNode.html(rowDateFormatter.call(instance, timesheetDay.get(END_DATE)));
					}
					else if ((i == 3) && timesheetDay.get(BREAK_TIME)) {
						columnDataNode.html(String(timesheetDay.get(BREAK_TIME)));
					}
					else if (i == 4) {
						var allTime = timesheet.calculateAllTime(timesheetDay);

						if (allTime) {
							columnDataNode.html(hourMinutesFormatter.call(instance, allTime));
						}
					}
					else if (i == 5) {
						var workTime = timesheet.calculateWorkTime(timesheetDay);

						if (workTime) {
							columnDataNode.html(hourMinutesFormatter.call(instance, workTime));
						}
					}
					else if (i == 6) {
						var overTime = timesheet.calculateOverTime(timesheetDay);

						if (overTime) {
							columnDataNode.html(hourMinutesFormatter.call(instance, overTime));
						}
					}

					timesheetDayNode.setHTML(columnDataNode);
				}
			},

			/**
			* TimesheetMonthView
			*/
			_uiSetDate: function(val) {
				var instance = this;

				instance.syncElementsHeaderUI();

				instance.syncGridUI();
			},

			/**
			* TimesheetMonthView
			*/
			_valueColumnHeaderNode: function() {
				var instance = this;

				var headerElements = instance.get('headerElements'),
					headerElementsCount = headerElements.length;

				return instance._valueNodeList(headerElementsCount, TPL_TVT_HEADER_ELEMENT);
			},

			/**
			* TimesheetMonthView
			*/
			_valueNodeList: function(size, tpl) {
				var instance = this;

				var buffer = [];

				while (size--) {
						buffer.push(tpl);
				}

				return A.NodeList.create(buffer.join(_EMPTY_STR));
			},

			/**
			* TimesheetMonthView
			*/
			_valueTableGridNode: function() {
				var instance = this;

				var rowNumber = instance.getRowsNumber()

				return instance._valueNodeList(rowNumber, TPL_TVT_TABLE_GRID);
			}
		}
	});

	Liferay.TimesheetMonthView = TimesheetMonthView;

	var TimesheetDayRecorder = A.Component.create({
		NAME: 'timesheet-day-recorder',

		ATTRS: {
			selectedColumnName: {
				validator: isString,
				value: ''
			},

			selectedNode: {

			},

			bodyTemplate: {
				value: TPL_RECORDER_BODY_CONTENT
			},

			contentDateFormatter: {
				validator: isString,
				value: function(date) {
					var instance = this;

					return A.DataType.Date.format(
						date, {
							format: '%X',
							locale: instance.get(LOCALE)
						}
					);
				}
			},

			dateFormat: {
				validator: isString,
				value: '%a, %B %d'
			},

			timesheetDay: {},

			headerTemplate: {
				value: TPL_RECORDER_HEADER_CONTENT
			},

			popover: {
				setter: '_setPopover',
				validator: isObject,
				value: {}
			},

			strings: {
				value: {},
				setter: function(val) {
					return A.merge({
						cancel: 'Cancel',
						description: 'Description',
						edit: 'Edit',
						endTime: 'End Time',
						breakTime: 'Lunch Time',
						save: 'Save',
						startTime: 'Start Time'
						},
						val || {}
					);
				},
				validator: isObject
			}
		},

		EXTENDS: Liferay.TimesheetDay,

		prototype: {
			/**
			* TimesheetDayRecorder
			*/
			initializer: function() {
				var instance = this;

				instance.publish('cancel', {
					defaultFn: instance._defCancelEventFn
				});

				instance.publish('edit', {
					defaultFn: instance._defEditEventFn
				});

				instance.publish('save', {
					defaultFn: instance._defSaveEventFn
				});

				instance.popover = new A.Popover(instance.get('popover'));
				instance.popover.after('visibleChange', A.bind(instance._afterPopoverVisibleChange, instance));
			},

			/**
			* TimesheetDayRecorder
			*/
			getContentNode: function() {
				var instance = this;

				var popoverBB = instance.popover.get('boundingBox');

				return popoverBB.one('.' + CSS_TIMESHEET_DAY_RECORDER_CONTENT);
			},

			/**
			* TimesheetDayRecorder
			*/
			getTemplateData: function(fieldName) {
				var instance = this;

				var	strings = instance.get('strings'),
					timesheetDay = instance.get(TIMESHEET_DAY) || instance,
					content = '',
					endDate = timesheetDay.get('endDate'), endTime = '',
					startDate = timesheetDay.get('startDate'), startTime = '',
					selectedNode = instance.get('selectedNode'),
					fieldName = selectedNode.getData(FIELD_NAME),
					timesheet = instance.get(TIMESHEET),
					contentDateFormatter = instance.get('contentDateFormatter');

				if (fieldName === START_TIME) {
					content = contentDateFormatter.call(timesheet, timesheetDay.get(START_DATE));
				}
				else if (fieldName === END_TIME) {
					content = contentDateFormatter.call(timesheet, timesheetDay.get(END_DATE));
				}
				else if (fieldName === BREAK_TIME) {
					content = contentDateFormatter.call(timesheet, timesheetDay.get(BREAK_TIME));

					id = 'timesheetDayContentBreak';
				}

				if (!isUndefined(endDate)) {
					endTime = endDate.getTime();
				}

				if (!isUndefined(startDate)) {
					startTime = startDate.getTime();
				}

				return {
					content: content,
					date: new Date(),
					endDate: endDate,
					fieldName: strings[fieldName],
					startDate: startDate
				};
			},

			/**
			* TimesheetDayRecorder
			*/
			getUpdatedTimesheetDay: function(optAttrMap) {
				var instance = this;

				var timesheetDay = instance.get(TIMESHEET_DAY),
					formValues = instance.serializeForm(),
					timeValues = formValues.content.split(':'),
					selectedNode = instance.get('selectedNode'),
					fieldName = selectedNode.getData(FIELD_NAME),
					currentDate = selectedNode.getData('date'),
					rowIndex = selectedNode.getData('rowIndex'),
					workDate;

				if (!timesheetDay) {
					timesheetDay = instance.clone();

					timesheetDay.set('timesheet', instance.get(TIMESHEET), {
						silent: true
					});
				}

				timesheetDay.set('rowIndex', rowIndex);

				workDate = DateMath.add(currentDate, DateMath.HOUR, timeValues[0]);
				workDate = DateMath.add(workDate, DateMath.MINUTES, timeValues[1]);

				if (fieldName === START_TIME) {
					timesheetDay.set(START_DATE, workDate);
				}
				else if (fieldName === END_TIME) {
					timesheetDay.set(END_DATE, workDate);
				}
				else if (fieldName === LUNCH_TIME) {
					timesheetDay.set(LUNCH_TIME, workDate.getTime() - currentDate.getTime());
				}

				return timesheetDay;
			},

			/**
			* TimesheetDayRecorder
			*/
			hidePopover: function() {
				var instance = this;

				instance.popover.hide();
			},

			/**
			* TimesheetDayRecorder
			*/
			populateForm: function() {
				var instance = this;

				var bodyTemplate = instance.get('bodyTemplate'),
					headerTemplate = instance.get('headerTemplate'),
					templateData = instance.getTemplateData(instance.get('selectedColumnName'));

				instance.popover.setStdModContent('body', A.Lang.sub(bodyTemplate, templateData));
				instance.popover.setStdModContent('header', A.Lang.sub(headerTemplate, templateData));

				if (!instance.timepicker) {
					instance.timepicker = new A.TimePicker({
						mask: '%H:%M',
						trigger: '#timesheedDayContent',
						on: {
							selectionChange: function(event) {

							}
						}
					});
				}

				instance.popover.addToolbar(instance._getFooterToolbar(), 'footer');
			},

			/**
			* TimesheetDayRecorder
			*/
			serializeForm: function() {
				var instance = this;

				return A.QueryString.parse(_serialize(instance.formNode.getDOM()));
			},

			/**
			* TimesheetDayRecorder
			*/
			showPopover: function(node) {
				var instance = this;

				var timesheetDay = instance.get(TIMESHEET_DAY);

				if (!instance.popover.get('rendered')) {
					instance._renderPopover();
				}

				var align = instance.popover.get('align');

				instance.popover.set('align', {
					node: node,
					points: align.points
				});

				instance.popover.show();
			},

			/**
			* TimesheetDayRecorder
			*/
			_afterPopoverVisibleChange: function(event) {
				var instance = this;

				var	popover = instance.popover,
					boundingBox = popover.get('boundingBox');

				boundingBox.addClass('timesheet-popover');

				if (event.newVal) {
					instance.populateForm();

					if (!instance.get('event')) {
						var contentNode = instance.getContentNode();

						if (contentNode) {
							setTimeout(function() {
								contentNode.selectText();
							}, 0);
						}
					}
				}
				else {
					instance.set(TIMESHEET_DAY, null, {
					silent: true
					});
				}
			},

			/**
			* TimesheetDayRecorder
			*/
			_defCancelEventFn: function() {
				var instance = this;

				var selectedNode = instance.get('selectedNode');

				instance.hidePopover();

				if (selectedNode) {
					selectedNode.removeClass('timesheet-selected-content');

					instance.set('selectedNode', null);
				}
			},

			/**
			* TimesheetDayRecorder
			*/
			_defEditEventFn: function(event) {
				var instance = this;

				var timesheet = instance.get(TIMESHEET);

				timesheet.syncTimesheetDayUI(event.timesheetDay);

				instance._defCancelEventFn();
			},

			/**
			* TimesheetDayRecorder
			*/
			_defSaveEventFn: function(event) {
				var instance = this;

				var timesheet = instance.get(TIMESHEET);

				timesheet.addTimesheetDays(event.timesheetDay);

				timesheet.syncTimesheetDayUI(event.timesheetDay);

				instance._defCancelEventFn();
			},

			/**
			* TimesheetDayRecorder
			*/
			_getFooterToolbar: function() {
				var instance = this;

				var	timesheetDay = instance.get(TIMESHEET_DAY),
					strings = instance.get('strings'),
					children = [
						{
							label: strings.save,
							on: {
								click: A.bind(instance._handleSaveEvent, instance)
							}
						},
						{
							label: strings.cancel,
							on: {
								click: A.bind(instance._handleCancelEvent, instance)
							}
						}
					];

				return [children];
			},

			/**
			* TimesheetDayRecorder
			*/
			_handleCancelEvent: function(event) {
				var instance = this;

				instance.fire('cancel');

				if (event.domEvent) {
					event.domEvent.preventDefault();
				}

				event.preventDefault();
			},

			/**
			* TimesheetDayRecorder
			*/
			_handleSaveEvent: function(event) {
				var instance = this;

				var	eventName = instance.get(TIMESHEET_DAY) ? 'edit' : 'save',
					selectedNode = instance.get('selectedNode'),
					timesheet = instance.get(TIMESHEET),
					timesheetDay = instance.getUpdatedTimesheetDay();

				timesheet.invokeService(
					{
						'/time-tracking-portlet.workday/add-work-day': {
							startDate: timesheetDay.get('startDate') ? timesheetDay.get('startDate').getTime() : 0,
							endDate: timesheetDay.get('endDate') ? timesheetDay.get('endDate').getTime() : 0
						}
					},
					{
						failure: function() {
							//instance.destroyEvent(schedulerEvent);
						},

						start: function() {
							timesheetDay.set(
								'loading',
								true,
								{
									silent: true
								}
							);
						},

						success: function(data) {
							timesheetDay.set(
								'loading',
								false,
								{
									silent: true
								}
							);

							if (data) {
								if (data.exception) {

								}
								else {
									instance.fire(eventName, {
										timesheetDay: timesheetDay,
										currentDate: selectedNode.getData('date')
									});
								}
							}
						}
					}
				);

				if (event.domEvent) {
					event.domEvent.preventDefault();
				}

				event.preventDefault();
			},

			/**
			* TimesheetDayRecorder
			*/
			_renderPopover: function() {
				var instance = this;

				var	timesheet = instance.get(TIMESHEET),
					timesheetBB = timesheet.get('boundingBox');

				instance.popover.render(timesheetBB);

				instance.formNode = A.Node.create(TPL_FORM);

				//instance.formNode.on('submit', A.bind(instance._onSubmitForm, instance));
				//instance.popover.get('boundingBox').addClass(CSS_TIMESHEET_DAY);
				instance.popover.get('contentBox').wrap(instance.formNode);
			},

			/**
			* TimesheetDayRecorder
			*/
			_setPopover: function(val) {
				var instance = this;

				return A.merge({
					align: {
						points: [A.WidgetPositionAlign.BC, A.WidgetPositionAlign.TC]
					},
					bodyContent: TPL_RECORDER_BODY_CONTENT,
					constrain: true,
					headerContent: TPL_RECORDER_HEADER_CONTENT,
					preventOverlap: true,
					position: 'top',
					toolbars: {
						footer: instance._getFooterToolbar()
					},
					visible: false,
					zIndex: 500
				},
				val
				);
			}
		}
	});

	Liferay.TimesheetDayRecorder = TimesheetDayRecorder;

	}, '0.0.1', {
	"requires": ["aui-button", "aui-datatype", "aui-component", "aui-node-base", "aui-popover", "aui-timepicker", "aui-timepicker-native", "io-form", "model", "model-list", "querystring-parse", "widget-stdmod"], "skinnable": true
});