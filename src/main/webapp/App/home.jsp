<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<html>
<%@ include file="../head.jsp"%>

<body>
	<nav class="navbar navbar-default">
		<div class="container-fluid">
			<div class="navbar-header">
				<a class="navbar-brand" href="#">PRS</a>
			</div>
			<div class="collapse navbar-collapse"
				id="bs-example-navbar-collapse-1">
				<ul class="nav navbar-nav navbar-right">
					<li><a href="#"> <c:out
								value="Hello, ${current_user.userFName} ${current_user.userLName}"></c:out>
					</a></li>
					<c:if test="${current_user != null}">
						<li><a href="logout">Logout</a></li>
					</c:if>
				</ul>
			</div>
			<!-- /.navbar-collapse -->
		</div>
		<!-- /.container-fluid -->
	</nav>

	<div class="container" id="main-body">
		<div class="row">
			<div class="">
				<table class="table">
					<thead class="thead-inverse">
						<tr>
							<th>#</th>
							<th>Description</th>
							<th>Submitted By</th>
							<th>Type</th>
							<th>Submitted Date</th>
							<th>Amount</th>
							<th>Status</th>
							<th>Resolver</th>
							<th>Resolved Date</th>
							<c:if test="${current_user.userRole.userRoleId == 2}">
								<th>Option</th>
							</c:if>
						</tr>
					</thead>
					<c:forEach items="${reimbList}" var="reimb">
						<tbody>
							<tr>
								<td scope="row">${reimb.rId}</td>
								<td>${reimb.rDescription}</td>
								<td>${reimb.rAuthor.username}</td>
								<td>${reimb.rType.rType}</td>
								<td><fmt:formatDate type="date" value="${reimb.rSubmitted}" /></td>
								<td>$${reimb.rAmount}</td>
								<td>
									<a href="ViewReimbsByStatus?statusId=${reimb.rStatus.rStatusId}">${reimb.rStatus.rStatus}</a>
								</td>
								<td>${reimb.rResolver.username}</td>
								<td><fmt:formatDate type="date" value="${reimb.rResolved}" />
								</td>
								<c:if test="${reimb.rStatus.rStatusId == 1 && current_user.userRole.userRoleId == 2}">
									<td>
										<button class="btn btn-success">Approve</button>
										<button class="btn btn-danger">Deny</button>
									</td>
								</c:if>
								<c:if test="${reimb.rStatus.rStatusId != 1}">
									<td>Reimbursement has already been processed</td>
								</c:if>
							</tr>
						</tbody>
					</c:forEach>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
