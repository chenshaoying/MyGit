<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/public/meta.jsp"></jsp:include>
</head>
<body>
	<div class="container-fluid">
		<div class="row" id="header">
			<div class="col-md-12" style="background: black">
				<div class="row">
					<div class="col-md-2 col-md-offset-1">
						<img alt="" src="<%=request.getContextPath()%>/resources/images/icons/blackcat-large.png"></img>
					</div>
				</div>
			</div>
		</div>
		<!--  style="background:url('/images/icons/background03.jpg')  no-repeat center"-->
		<div class="row" id="content"
			style="background: url('<%=request.getContextPath()%>/resources/images/icons/bg04.jpg') no-repeat center">
			<div class="col-md-8" style="padding: 0">
				<!-- <img src="/images/icons/background03.jpg"></img>	 -->
			</div>
			<div class="col-md-3" style="height:500px">
				<br /> <br />
				<div class="panel panel-default">
					<div class="panel-body">
						<label>${message}</label>					    
						<form id="registerForm" method="get" action="<%=request.getContextPath()%>/login">
							<!-- <div class="form-group">
								<label for="email">Email address</label> <input
									type="email" class="form-control" id="email" name="email"
									placeholder="Email">
							</div> -->
							<div class="form-group">
								<label for="userid">用户名</label> <input
									type="text" class="form-control" id="userid" name="userid"
									placeholder="用户名"/>
							</div>
							
							<div class="form-group">
								<label for="passwd">Password</label> <input
									type="password" class="form-control" id="passwd" name="passwd"
									placeholder="Password">
							</div>
							
							<div class="form-group">
								<label for="gender">gender</label> 
								<form:select path="user.gender" items="${genderList}" class="form-control"/>
							<%-- 	<jsp:select name="gerder" list="@com.blackcat.frame.core.utils.DictUtil@getDict('common','gender', false)"></jsp:select> --%>
							</div>
							
							<!-- <div class="form-group">
	                            <label id="captchaOperation" class="col-md-5 control-label"></label>
			                    <input type="text" class="form-control " name="captcha" />
                       		</div> -->
                       		
							<div class="form-group">
								<div class="checkbox">
									<label> <input type="checkbox" name="isAgreed[]"/> 我已阅读并同意									
									</label>
									<button type="button" class="btn btn-link">《用户服务协议》</button>
								</div>
							</div>
                       		<div class="form-group">
								<button type="submit" class="btn btn-success btn-lg col-md-5 " id="login">
									<span >登录</span>
								</button>
								<button type="button" class="btn btn-primary btn-lg col-md-5 col-md-offset-1" id="register">
									<span>注册</span>
								</button>
                       		</div>
						</form>
					</div>
				</div>

			</div>
		</div>
		<div class="row">
		</div>
		<div class="row" id="footer" style="background: black">
			<div class="col-md-6 col-md-offset-3">
				<p class="text-center">
				 Copyright©2000-2015 Darren Chan All Rights Reserved
				</p>
			</div>
		</div>
	</div>
<script type="text/javascript">
$(document).ready(function() {
	// Generate a simple captcha
    /* function randomNumber(min, max) {
        return Math.floor(Math.random() * (max - min + 1) + min);
    };
    $('#captchaOperation').html([randomNumber(1, 100), '+', randomNumber(1, 200), '='].join(' ')); */
    
    $('#registerForm').bootstrapValidator({
        message: 'This value is not valid',
        submitButtons: 'button[type="submit"]',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {
        	"userid": {
                message: 'The userid is not valid',
                validators: {
                    notEmpty: {
                        message: 'The userid is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The userid must be more than 6 and less than 30 characters long'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'The userid can only consist of alphabetical, number and underscore'
                    }
                }
            },
        	/* "email": {
                validators: {
                    notEmpty: {
                        message: 'The email is required and cannot be empty'
                    },
                    emailAddress: {
                        message: 'The input is not a valid email address'
                    }
                }
            }, */
            "passwd": {
                message: 'The passwd is not valid',
                validators: {
                    notEmpty: {
                        message: 'The passwd is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The passwd must be more than 6 and less than 30 characters long'
                    }/* ,
                    regexp: {
                        regexp: /^[a-zA-Z0-9_]+$/,
                        message: 'The username can only consist of alphabetical, number and underscore'
                    } */
                }
            },
            "isAgreed[]": {
                validators: {
                	choice: {
                        min: 1,
                        max: 1,
                        message: 'Please agree the deal'
                    }
                }
            }/* ,
            captcha: {
                validators: {
                    callback: {
                        message: 'Wrong answer',
                        callback: function(value, validator) {
                            var items = $('#captchaOperation').html().split(' '), sum = parseInt(items[0]) + parseInt(items[2]);
                            return value == sum;
                        }
                    }
                }
            } */             
        }
    });
    
    //
    /* $("#login").click(function(){
    	$("form").data('bootstrapValidator').validate();    	
    	if($("form").data('bootstrapValidator').isValid()){
	    	$("form").data('bootstrapValidator').defaultSubmit();    	
    	}
    }); */
});
</script>
</body>
</html>
