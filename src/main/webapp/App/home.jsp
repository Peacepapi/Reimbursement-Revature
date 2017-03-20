<!DOCTYPE html>

<html>
<%@ include file="../head.jsp"%>

<body>
	<%@ include file="nav.jsp"%>
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
							<th>Receipt</th>
							<c:if test="${current_user.userRole.userRoleId == 2}">
								<th>Option</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:if test="${reimbList.isEmpty()}">
							<tr>
								<td class="empty-fields" colspan="10">No Reimbursement
									Request Has Been Made.</td>
							</tr>
						</c:if>
					</tbody>
					<c:forEach items="${reimbList}" var="reimb">
						<tbody>
							<tr>
								<td scope="row">${reimb.rId}</td>
								<c:if test="${reimb.rDescription == null}">
									<td class="empty-fields">-- No Description Provided --</td>
								</c:if>
								<c:if test="${reimb.rDescription != null}">
									<td>${reimb.rDescription}</td>
								</c:if>
								<td>${reimb.rAuthor.userFName} ${reimb.rAuthor.userLName}</td>
								<td>${reimb.rType.rType}</td>
								<td><fmt:formatDate type="date" value="${reimb.rSubmitted}" /></td>
								<td><fmt:formatNumber value="${reimb.rAmount}"
										type="currency" /></td>
								<td><c:if test="${current_user.userRole.userRoleId == 2}">
										<a href="ViewReimbsByStatus?statusId=${reimb.rStatus.rStatusId}">${reimb.rStatus.rStatus}</a>
									</c:if> <c:if test="${current_user.userRole.userRoleId != 2}">
									${reimb.rStatus.rStatus}						
								</c:if></td>
								<c:if test="${reimb.rResolver.username != null}">
									<td>${reimb.rResolver.userFName} ${reimb.rResolver.userLName}</td>
								</c:if>
								<c:if test="${reimb.rResolver.username == null}">
									<td class="empty-fields">-</td>
								</c:if>

								<c:if test="${reimb.rResolved != null}">
									<td><fmt:formatDate type="date" value="${reimb.rResolved}" />
								</c:if>
								<c:if test="${reimb.rResolved == null}">
									<td class="empty-fields">-</td>
								</c:if>
								<td><c:if test="${reimb.rReceipt != null }">
										<a href="ReimbImage?id=${reimb.rId}" target="_blank"><i
											class="fa fa-list-alt fa-2x myImg" aria-hidden="true"></i> </a>
									</c:if> <c:if test="${reimb.rReceipt == null }">
										<span class="empty-fields">-</span>
									</c:if></td>

								<c:if
									test="${reimb.rStatus.rStatusId == 1 && current_user.userRole.userRoleId == 2}">
									<td>
										<form action="ProcessReimb" method="post" id="form-approve">
											<input type="hidden" name="reimbId" value="${reimb.rId}">
											<input type="hidden" name="statusId" value="2"> <input
												type="submit" class="btn btn-success" value="Approve">
										</form>

										<form action="ProcessReimb" method="post" id="form-deny">
											<input type="hidden" name="reimbId" value="${reimb.rId}">
											<input type="hidden" name="statusId" value="3"> <input
												type="submit" class="btn btn-danger" value="Deny">
										</form>
									</td>
								</c:if>
								<c:if
									test="${reimb.rStatus.rStatusId != 1 && current_user.userRole.userRoleId == 2}">
									<td class="empty-fields">-- Processed --</td>
								</c:if>
							</tr>

						</tbody>
					</c:forEach>
					<tbody>
						<tr>
							<td colspan="11"><a href="ReimbCreate"> <a
									href="ReimbCreate"><i class="fa fa-plus-circle fa-2x"
										aria-hidden="true"></i></a></td>
						</tr>
					</tbody>
				</table>
			</div>
		</div>
	</div>
</body>
</html>
