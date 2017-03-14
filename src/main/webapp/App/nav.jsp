
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
				<li><c:if test="${current_user.userRole.userRoleId != 2}">
						<a href="ReimbCreate">Create Reimb</a>
					</c:if></li>
				<li><c:if test="${current_user != null}">
						<a href="logout">Logout</a>
					</c:if></li>


			</ul>
		</div>
		<!-- /.navbar-collapse -->
	</div>
	<!-- /.container-fluid -->
</nav>