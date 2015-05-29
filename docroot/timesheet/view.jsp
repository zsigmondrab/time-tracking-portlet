<%@ include file="init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	boolean hasConfigurePermission = WorkDayPermission.contains(
			permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
%>

<aui:button-row>
	<c:if test="<%= hasConfigurePermission %>">
		<liferay-security:permissionsURL
			modelResource="com.liferay.timetracking.timesheet.model"
			modelResourceDescription="Permissions"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL" />

		<aui:button onClick="<%= permissionsURL %>" value="permissions" />
	</c:if>
</aui:button-row>