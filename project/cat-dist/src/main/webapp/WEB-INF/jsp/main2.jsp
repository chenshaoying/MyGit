<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/public/meta.jsp"></jsp:include>

</head>
<body>
	<!-- <nav>
		<div class="container-fluid">
			<div class="row">
				<div class="col-md-2">
					<ul id="main-nav" class="main-nav nav nav-tabs nav-stacked">
						<li><a href="#"> <i class="glyphicon glyphicon-th-large"></i>首页</a></li>
						<li>
							<a href="#systemSetting" class="nav-header collapsed" data-toggle="collapse">
								<i class="glyphicon glyphicon-cog"></i> 系统管理                    
                            	<span class="pull-right glyphicon glyphicon-chevron-right"></span>
							</a>
							<ul id="systemSetting" class="nav nav-list collapse " style="height: 0px;">
	                            <li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;菜单管理</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a></li>
                        	</ul>
						</li>
						<li>
							<a href="#systemSetting1" class="nav-header collapsed" data-toggle="collapse">
								<i class="glyphicon glyphicon-cog"></i> 系统管理                    
                            	<span class=" glyphicon glyphicon-chevron-toggle"></span>
							</a>
							<ul id="systemSetting1" class="nav nav-list collapse " style="height: 0px;">
	                            <li><a href="#"><i class="glyphicon glyphicon-user"></i>&nbsp;用户管理</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-th-list"></i>&nbsp;菜单管理</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-asterisk"></i>&nbsp;角色管理</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-edit"></i>&nbsp;修改密码</a></li>
	                            <li><a href="#"><i class="glyphicon glyphicon-eye-open"></i>&nbsp;日志查看</a></li>
                        	</ul>
						</li>
					</ul>
				</div>
			</div>
			</div>
	</nav> -->
	<div class="container-fluid">
		<div class="row">
			<div class="col-md-2 col-md-offset-2">
			<input id="msg"></input>
			<button id="send" >send</button>
			</div>			
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-2">		
				<textarea rows="8" cols="10"></textarea>
			<div class="col-md-2 col-md-offset-2">
			
		</div>
		<div class="row">
			<div class="col-md-2 col-md-offset-2">		
				<button id="open" >open</button>			
				<button id="close" >close</button>
			</div>
		</div>
	</div>

	<script type="text/javascript">
	$(document).ready(function() {
		var ws;
		$("#open").click(function(){
					    
		    ws = new WebSocket("ws://127.0.0.1:9998/text");  
		    	  
	    	ws.onopen = function(){
				ws.send("建立连接。。。");
			};  
	    	  
	    	ws.onmessage = function(evt){
	  //  		console.log(evt.data);
	    		$("textarea").val($("textarea").val() + "\r\n" + evt.data);
	    	};  
	    	  
	    	ws.onclose = function(evt){
	    		alert("WebSocketClosed!");
	    	};  
	    	  
	    	ws.onerror = function(evt){
	    		alert("WebSocketError!");
	    	};   
		});
		
		$("#send").click(function(){
			ws.send($("#msg").val());
		});
		
		$("#close").click(function(){
			ws.close();
		});

	});
	
	
	</script>
</body>
</html>
