<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn"  uri="http://java.sun.com/jsp/jstl/functions" %>
<c:set var="ctx" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/public/meta.jsp"></jsp:include>
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top" role="navigation" style="margin-bottom:0">
        <div class="navbar-header">
            <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
	            <img  class="navbar-brand" src="${ctx}/resources/images/icons/blackcat-large.png" style="padding:0;margin-left:20px"></img>                       
                <a class="navbar-brand" href="index.html">Black Cat v1.0</a>      
        </div>
        <div>
	        <ul class="nav nav-pills navbar-right" style="margin-right:150px;padding-top:15px">
			  <li role="presentation"><a href="${ctx}/rrr">Home</a></li>
			  <li role="presentation"><a href="#">Profile</a></li>
			  <li role="presentation"><a href="#">Messages</a></li>
  			  <li role="presentation"><a href="#">Messages</a></li>
  			  <li role="presentation"><a href="#">Messages</a></li>
			</ul>               
        </div>
    </nav>
	<div class="container-fluid">
		<div class="row" id="content"
			style="background: url('${ctx}/resources/images/icons/bg04.jpg') no-repeat center">
			<!-- <div class="col-md-8" style="padding: 0">
				<img src="/images/icons/background03.jpg"></img>	
			</div> -->
			<div class="col-md-3 col-md-offset-8" style="height:500px;margin-top:100px">
				<div class="panel panel-default">
					<div class="panel-body">
						<label>${message}</label>					    
						<form id="loginForm" method="get" action="${ctx}/login" class="form-horizontal">
							<!-- <div class="form-group">
								<label for="email">Email address</label> <input
									type="email" class="form-control" id="email" name="email"
									placeholder="Email">
							</div> -->
							<div class="form-group">
							    <!-- <label class="col-md-3 control-label">Full name</label> -->
						        <div class="col-md-12">
									<input type="text" class="form-control" id="userid" name="userid" 
										placeholder="用户名"/>
						        </div>
							</div>
							
							<div class="form-group">
					            <!-- <label class="col-md-3 control-label">Password</label> -->
					            <div class="col-md-12">
									<input type="password" class="form-control" id="passwd" name="passwd"
										placeholder="Password">					            							
								</div>
							</div>
							
							<%-- <div class="form-group">
								<label for="gender">gender</label> 
								<form:select path="user.gender" items="${genderList}" class="form-control"/>
								<jsp:select name="gerder" list="@com.blackcat.frame.core.utils.DictUtil@getDict('common','gender', false)"></jsp:select>
							</div> --%>
							
							<div class="form-group">									
								<div class="col-md-5">
				                    <input type="text" class="form-control" name="captcha"/>
								</div>
			                    	<img src="${ctx}/getKaptchaImage/LOGIN" name="kaptchaImage" class="col-md-5" style="margin-left:-15px"/>       					
	   								<a href="#" name='refreshKaptcha'>看不清?</br>换一张</a> 
                       		</div> 
                       		
							<div class="form-group">
									<div class="checkbox col-md-12">
										<label> <input type="checkbox" name="isAgreed[]"/> 我已阅读并同意									
										</label>
										<a href="#">《用户服务协议》</a>
									</div>
							</div>
                       		<div class="form-group">
                       			<div class="col-md-12">
									<button type="submit" class="btn btn-success btn-lg" id="login" style="width:48%">
										<span >登录</span>
									</button>           			
									<button type="button" class="btn btn-primary btn-lg " id="register" style="width:48%">
										<span>注册</span>
									</button>
                       			</div>
                       			<!-- <div class="col-md-5 col-md-offset-1">
								</div> -->
                       		</div>
						</form>
					</div>
				</div>

			</div>
		</div>	
	</div>
	<nav class="navbar navbar-default navbar-fixed-bottom">
	  <div class="container">
	    <div class="row" id="footer">
	    	<div class="text-center">
				<footer>Copyright©2000-2015 Darren Chan All Rights Reserved</footer>	    	
	    	</div>
		</div>
	  </div>
	</nav>
	
	<!-- register modal -->
	<div id="regModal" class="modal fade" role="dialog" aria-labelledby="gridSystemModalLabel">
	  <div class="modal-dialog" role="document">
	    <div class="modal-content">
	      <div class="modal-header">
	        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
	        <h4 class="modal-title" id="gridSystemModalLabel">注册窗口</h4>
	      </div>
	          <form id="regForm" method="get" action="${ctx}/login" class="form-horizontal">
	      <div class="modal-body">
	        <div class="container-fluid">
							
							<div class="form-group">
							    <label class="col-md-3 control-label">Full name</label>
						        <div class="col-md-8">
									<input type="text" class="form-control"  name="userid" 
										placeholder="用户名"/>
						        </div>
							</div>
							
							<!-- <div class="form-group">
							    <label class="col-md-3 control-label">Full name</label>
						        <div class="col-md-8">
									<input type="text" class="form-control"  name="userid" 
										placeholder="用户名"/>
						        </div>
							</div> -->
												
							<div class="form-group">
					            <label class="col-md-3 control-label">Password</label>
					            <div class="col-md-8">
									<input type="password" class="form-control"  name="passwd"
										placeholder="Password">					            							
								</div>
							</div>
							
							<div class="form-group">
					            <label class="col-md-3 control-label">Password</label>
					            <div class="col-md-8">
									<input type="password" class="form-control"  name="passwd2"
										placeholder="Comfirm your password">					            							
								</div>
							</div>
							
							<div class="form-group">
					            <label class="col-md-3 control-label">Password</label>
					            <div class="col-md-8">
									<form:select path="user.gender" items="${genderList}" class="form-control"/>
					            </div>
					            
							</div>
							<div class="form-group">
					            <label class="col-md-3 control-label">Email</label>
					            <div class="col-md-8">
									<input type="email" class="form-control" name="email"
										placeholder="Email">
					            </div>
							</div>
							
							<div class="form-group">
								<label class="col-md-3 control-label">Mobile</label>
					            <div class="col-md-8">
									<input type="text" class="form-control" name="mobile"
										placeholder="Mobile">
								</div>
							</div>
							
							<div class="form-group">
								<div class="col-md-8 col-md-offset-3">
									<div class="col-md-5">
					                    <input type="text" class="form-control" name="captcha"/>
									</div>
				                    	<img src="${ctx}/getKaptchaImage/REGISTER" name="kaptchaImage" class="col-md-5" style="margin-left:-15px"/>       					
		   								<a href="#" name='refreshKaptcha' >看不清?</br>换一张</a> 
								</div>									
                       		</div> 
                       		
							<div class="form-group">
									<div class="checkbox col-md-8 col-md-offset-3">
										<label> <input type="checkbox" name="isAgreed[]"/> 我已阅读并同意									
										</label>
										<a href="#">《用户服务协议》</a>
									</div>
							</div>
	        </div>
	      </div>
	      <div class="modal-footer">
	        <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
	        <button type="submit" class="btn btn-primary" id="regBtn">Save changes</button>
	      </div>
						</form>
	    </div><!-- /.modal-content -->
	  </div><!-- /.modal-dialog -->
	</div><!-- /.modal -->
<script type="text/javascript">
$(document).ready(function() {
	//
	var kaptcha;
	
    $('#loginForm').bootstrapValidator({
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
            },
            "captcha": {
                validators: {
                	notEmpty: {
                        message: 'The captcha is required and cannot be empty',
                    },
                    callback: {
                        message: 'Wrong answer',
						callback:function(value,validator) {
							$.get('${ctx}/getKaptchaImage/getValue/LOGIN','',function(json) {
								//alert(value + ":" + json);
								kaptcha = json;
							});
							
							return value == kaptcha;
						}
                    }
            
                }
            }            
        }
    });
    $('img[name="kaptchaImage"]').click(function () { 
        $(this).hide().attr('src', $(this).attr('src') + "?" + Math.floor(Math.random()*100) ).fadeIn();
	});
    
    $('a[name="refreshKaptcha"]').click(function () {  
        $(this).prev().hide().attr('src', $(this).prev().attr('src') + "?"  + Math.floor(Math.random()*100) ).fadeIn();
	});
    
    //注册模态框
    $('#regModal').modal({
  		keyboard: false,
    	show: false   	
	});
    
    $('#register').click(function(){
    	$('#regForm').data('bootstrapValidator').resetForm();
    	$('#regModal').modal('show');
    });
    
    
    //注册框验证
    $('#regForm').bootstrapValidator({
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
            "userna": {
                message: 'The userna is not valid',
                validators: {
                    notEmpty: {
                        message: 'The userna is required and cannot be empty'
                    },
                    stringLength: {
                        min: 1,
                        max: 80,
                        message: 'The userid must be more than 6 and less than 30 characters long'
                    }
                }
            },
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
                    }
                }
            },
            "passwd2": {
                message: 'The passwd is not valid',
                validators: {
                    notEmpty: {
                        message: 'The passwd is required and cannot be empty'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: 'The passwd must be more than 6 and less than 30 characters long'
                    }
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
            },
            "captcha": {
                validators: {
                	notEmpty: {
                        message: 'The captcha is required and cannot be empty'
                    },
                    callback: {
                        message: 'Wrong answer',
						callback:function(value,validator) {
							$.get('${ctx}/getKaptchaImage/getValue/REGISTER','',function(json) {
								//alert(value + ":" + json);
								kaptcha = json;
							});
							
							return value == kaptcha;
						}
                    }
                }
            }            
        },
        submitHandler: function(validator, form, submitButton) {
            $.post('${ctx}/login/addUser', form.serialize(), function(result) {
                // The result is a JSON formatted by your back-end
                // I assume the format is as following:
                //  {
                //      valid: true,          // false if the account is not found
                //      username: 'Username', // null if the account is not found
                //  }
                if (result.valid == true || result.valid == 'true') {
                    // You can reload the current location
                    window.location.reload();

                    // Or use Javascript to update your page, such as showing the account name
                    // $('#welcome').html('Hello ' + result.username);
                } else {
                    // The account is not found
                    // Show the errors
                    //$('#errors').html('The account is not found').removeClass('hide');

                    // Enable the submit buttons
                    $('#regForm').bootstrapValidator('disableSubmitButtons', false);
                }
            }, 'json');
        },
    });
    
    //
    /* $("#regBtn").click(function(){
    	if($("regForm").vald)
    	$.post('${ctx}/login/addUser',$("regForm").serialize(),function(data){
    		alert(data);
    	});
    }); */
});
    
</script>
</body>
</html>
