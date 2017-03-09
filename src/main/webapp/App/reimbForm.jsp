<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ include file="../head.jsp"%>
<body>
	<%@ include file="nav.jsp"%>
	<div class="container">
		<div class="row">
			<div class="col-md-8 col-md-offset-2 reimb-form">
				<form class="form-horizontal" method="post" action="ReimbCreate">
					<fieldset>
						<!-- Text input-->
						<div class="form-group">
							<label class="col-md-8 col-md-offset-2" for="amount">Amount</label>
							<div class="col-md-8 col-md-offset-2">
								<input id="amount" name="amount" type="text" placeholder="$"
									class="form-control input-md" required>
							</div>
						</div>

						<!-- Textarea -->
						<div class="form-group">
							<label class="col-md-8 col-md-offset-2" for="description">Description</label>
							<div class="col-md-8 col-md-offset-2">
								<textarea class="form-control" id="description"
									name="description"></textarea>
							</div>
						</div>
						<!-- Select Basic -->
						<div class="form-group">
							<label class="col-md-8 col-md-offset-2" for="typeId">Type</label>
							<div class="col-md-8 col-md-offset-2">
								<select id="typeId" name="typeId" class="form-control" required>
									<c:forEach items="${types}" var="type">
										<option value="${type.rTypeId}">${type.rType}</option>
									</c:forEach>
								</select>
							</div>
						</div>
						
						<div class="form-group">
							<label class="col-md-8 col-md-offset-2" for="receipt">Receipt</label>
							<div class="col-md-8 col-md-offset-2">
								<input type="file" id="receipt" name="receipt" class="form-control" multiple="true">

							</div>
						</div>
						
						<div class="form-group">
							<div class="col-md-8 col-md-offset-2">
								<input type="submit" class="btn btn-cus form-control input-md"/>
							</div>
						</div>
					</fieldset>
				</form>
			</div>
		</div>
	</div>
</body>
</html>