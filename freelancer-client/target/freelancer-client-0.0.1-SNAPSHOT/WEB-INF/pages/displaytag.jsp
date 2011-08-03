<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<body>

<display:table uid="user" name="userList" defaultsort="2"
	defaultorder="ascending" pagesize="10" size="${size}"
	partialList="true" requestURI="">
	<display:column title="row number" >
      <c:out value="${user_rowNum}"/>
    </display:column>
	
	<display:column property="id" sortable="true" title="Employee ID"
		maxLength="25" />
	<display:column property="name" sortable="true" title="Real Name"
		maxLength="25" />
	<display:column property="emailAddress" sortable="true"
		title="Email Address" maxLength="25" />
	<display:column property="phone" sortable="true" title="Phone"
		maxLength="25" />

	<display:column sortable="true" sortName="position" title="Position">
		<a href="display.do?id=${jobs.id}">View</a>
	</display:column>

</display:table>
</body>