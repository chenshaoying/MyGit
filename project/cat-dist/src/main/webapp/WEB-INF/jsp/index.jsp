<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="/WEB-INF/jsp/public/meta.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid">
		<div class="row" id="header">
			<div class="col-md-12" style="background: grey">
				<div class="row">
					<div class="col-md-2 col-md-offset-1">
						<img alt="" src="/images/icons/blackcat-large.png"></img>
					</div>
				</div>
			</div>
		</div>
		<div class="row" id="content"
			style="height: 600px; background-image: url('/images/icons/login_background.jpg'); background-repeat: no-repeat; background-position: center;">
			<div class="col-md-9"></div>

			<div class="col-md-3">
				<form>
					<div class="form-group">
						<label for="exampleInputEmail1">Email address</label> <input
							type="email" class="form-control" id="exampleInputEmail1"
							placeholder="Email">
					</div>
					<div class="form-group">
						<label for="exampleInputPassword1">Password</label> <input
							type="password" class="form-control" id="exampleInputPassword1"
							placeholder="Password">
					</div>
					<div class="form-group">
						<label for="exampleInputFile">File input</label> <input
							type="file" id="exampleInputFile">
						<p class="help-block">Example block-level help text here.</p>
					</div>
					<div class="checkbox">
						<label> <input type="checkbox"> Check me out
						</label>
					</div>
					<button type="submit" class="btn btn-default">Submit</button>
				</form>
			</div>
		</div>
		<div class="row" id="footer" style="background: grey">
			<div class="col-md-6 col-md-offset-3">
				<p class="text-center">
					Author:Darren Chan, contacts me:
					<addr>Darren_csy@163.com</addr>
					<br /> Copyright©2000-2015 Darren Chan All Rights Reserved
				</p>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
	
</script>
</html>
