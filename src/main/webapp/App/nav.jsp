
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<a class="navbar-brand" href="./home">PRS</a>
		</div>
		<div class="collapse navbar-collapse"
			id="bs-example-navbar-collapse-1">
			<ul class="nav navbar-nav navbar-right">
				<li>
					<p>
						<c:out
							value="Hello, ${current_user.userFName} ${current_user.userLName}">
						</c:out>
					</p>
				</li>
				<c:if test="${current_user != null}">
					<li><a href="logout">Logout</a></li>
				</c:if>
				<c:if test="${current_user.userRole.userRoleId != 2}">
					<li><a href="ReimbCreate">Create Reimb</a></li>
				</c:if>
			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>