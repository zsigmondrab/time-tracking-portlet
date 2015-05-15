<%@ include file="/init.jsp" %>

<%
	String redirect = PortalUtil.getCurrentURL(renderRequest);

	boolean hasConfigurePermission = ActivityPermission.contains(
			permissionChecker, scopeGroupId, ActionKeys.PERMISSIONS);
%>

<aui:button-row>
	<c:if test='<%= hasConfigurePermission %>'>
		<liferay-security:permissionsURL
			modelResource="com.liferay.timetracking.activities.model"
			modelResourceDescription="Permissions"
			resourcePrimKey="<%= String.valueOf(scopeGroupId) %>"
			var="permissionsURL" />

		<aui:button value="permissions" onClick="<%= permissionsURL %>" />
	</c:if>
</aui:button-row>
