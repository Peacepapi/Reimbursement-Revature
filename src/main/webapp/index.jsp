<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<%@ include file="head.jsp" %>
<body>
	<div class="container centered">
		<div class="form-container">
			<div class="row form-row">
				<div class="col-md-8 col-md-offset-2 text-center">
					<h2>Welcome PRS</h2>
					<c:if test="${message != null }">
						<c:out value="${message}"></c:out>
					</c:if>
				</div>
				<div class="col-sm-6 col-sm-offset-3">
					<form action="login" method="post">
						<div class="form-group row">
							<input type="text" class="form-control" name="username"
								placeholder="Username" required>
						</div>
						<div class="form-group row">
							<input type="password" class="form-control" name="password"
								placeholder="Password" required>
						</div>
						<div class="form-group row text-center">
							<div class="col-sm-4 col-sm-offset-4">
								<input type="submit" class="form-control btn btn-cus" value="Login">
							</div>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
