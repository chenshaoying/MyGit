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
	
  <link href="${ctx}/resources/js/sbadmin/css/sb-admin-2.css" rel="stylesheet">
  <link href="${ctx}/resources/js/sbadmin/css/timeline.css" rel="stylesheet">
  <!-- MetisMenu CSS -->
  <link href="${ctx}/resources/js/sbadmin/bower_components/metisMenu/dist/metisMenu.min.css" rel="stylesheet">

  <!-- Morris Charts CSS -->
  <link href="${ctx}/resources/js/sbadmin/bower_components/morrisjs/morris.css" rel="stylesheet">

  <!-- Custom Fonts -->
  <link href="${ctx}/resources/js/sbadmin/bower_components/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">

	<!-- Metis Menu Plugin JavaScript -->
    <script src="${ctx}/resources/js/sbadmin/bower_components/metisMenu/dist/metisMenu.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="${ctx}/resources/js/sbadmin/bower_components/raphael/raphael-min.js"></script>
    <script src="${ctx}/resources/js/sbadmin/bower_components/morrisjs/morris.min.js"></script>
    <%-- <script src="${ctx}/resources/js/sbadmin/js/morris-data.js"></script> --%>

    <!-- Custom Theme JavaScript -->
    <script src="${ctx}/resources/js/sbadmin/js/sb-admin-2.js"></script>
    
    <style type="text/css">
    	.closeTab {
		    opacity: 0;
		    filter: alpha(opacity=0);
		}
		.closeTab:hover {
		    color:white;
		    opacity: 1.0;
		    filter: alpha(opacity=40);
		    cursor: pointer;
		}
    </style>
    
    
</head>
<body>
<div id="wrapper">

        <!-- Navigation -->
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
            <!-- /.navbar-header -->
            <div class="col-md-6 col-offset-left-2" style="height:50px;">
            	<ul class="nav nav-pills navbar-top-links" >
				  <li role="presentation" style=""><a href="${ctx}/rrr">Home</a></li>
				  <li role="presentation"><a href="#">Profile</a></li>
				  <li role="presentation"><a href="#">Messages</a></li>
				</ul>            
            </div>
			
            <ul class="nav navbar-top-links navbar-right">
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-envelope fa-fw"></i>  <i class="fa fa-caret-down"></i>
                        <span>messages</span>
                    </a>
                    <ul class="dropdown-menu dropdown-messages">
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <strong>John Smith</strong>
                                    <span class="pull-right text-muted">
                                        <em>Yesterday</em>
                                    </span>
                                </div>
                                <div>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Pellentesque eleifend...</div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>Read All Messages</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-messages -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-tasks fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-tasks">
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 1</strong>
                                        <span class="pull-right text-muted">40% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-success" role="progressbar" aria-valuenow="40" aria-valuemin="0" aria-valuemax="100" style="width: 40%">
                                            <span class="sr-only">40% Complete (success)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 2</strong>
                                        <span class="pull-right text-muted">20% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-info" role="progressbar" aria-valuenow="20" aria-valuemin="0" aria-valuemax="100" style="width: 20%">
                                            <span class="sr-only">20% Complete</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 3</strong>
                                        <span class="pull-right text-muted">60% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-warning" role="progressbar" aria-valuenow="60" aria-valuemin="0" aria-valuemax="100" style="width: 60%">
                                            <span class="sr-only">60% Complete (warning)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <p>
                                        <strong>Task 4</strong>
                                        <span class="pull-right text-muted">80% Complete</span>
                                    </p>
                                    <div class="progress progress-striped active">
                                        <div class="progress-bar progress-bar-danger" role="progressbar" aria-valuenow="80" aria-valuemin="0" aria-valuemax="100" style="width: 80%">
                                            <span class="sr-only">80% Complete (danger)</span>
                                        </div>
                                    </div>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Tasks</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-tasks -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-bell fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-alerts">
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-comment fa-fw"></i> New Comment
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-twitter fa-fw"></i> 3 New Followers
                                    <span class="pull-right text-muted small">12 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-envelope fa-fw"></i> Message Sent
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-tasks fa-fw"></i> New Task
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a href="#">
                                <div>
                                    <i class="fa fa-upload fa-fw"></i> Server Rebooted
                                    <span class="pull-right text-muted small">4 minutes ago</span>
                                </div>
                            </a>
                        </li>
                        <li class="divider"></li>
                        <li>
                            <a class="text-center" href="#">
                                <strong>See All Alerts</strong>
                                <i class="fa fa-angle-right"></i>
                            </a>
                        </li>
                    </ul>
                    <!-- /.dropdown-alerts -->
                </li>
                <!-- /.dropdown -->
                <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
                        <i class="fa fa-user fa-fw"></i>  <i class="fa fa-caret-down"></i>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="${ctx}/logout"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
                <!-- /.dropdown -->
            </ul>
            <!-- /.navbar-top-links -->
            
			<div class="navbar-default sidebar " role="navigation" >
                <div class="sidebar-nav navbar-collapse">
                    <ul class="nav" id="side-menu">                        
                        <li>
                            <a href="#" id="Dashboard"><i class="fa fa-dashboard fa-fw"></i> Dashboard</a>
                        </li>
                        <c:forEach var="menu" items="${menus}">
							<li>
							    <a href="${menu.action}"><i class="fa ${menu.icon} fa-fw"></i> ${menu.name}<span class="fa arrow"></span></a>							
							</li>
						</c:forEach>
                        <li>
                            <a href="#"><i class="fa fa-bar-chart-o fa-fw"></i> Charts<span class="fa arrow"></span></a>
                            <ul class="nav nav-second-level">
                                <li>
                                    <a href="flot.html">Flot Charts</a>
                                </li>
                                <li>
                                    <a href="morris.html">Morris.js Charts</a>
                                </li>
                            </ul>
                            <!-- /.nav-second-level -->
                        </li>
                        
                    </ul>
                </div>
                <!-- /.sidebar-collapse -->
            </div>
            <!-- /.navbar-static-side -->
			
        </nav>
    
        
            
        <div id="page-wrapper" style="margin-top:50px">
        	<br/>
            <!-- <div class="row">
                <div class="col-md-12">
                    <ol class="breadcrumb">
					  <li><a href="#">Home</a></li>
					  <li><a href="#">Library</a></li>
					  <li class="active">Data</li>
					</ol>
                </div>
                /.col-lg-12
            </div> -->
            <div class="row">
	            <ul class="nav nav-tabs nav-pills" role="tablist">
				    <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Home <button type="button" class="close"  aria-label="Close" id="closetabbtn"><span aria-hidden="true" style="color:grey">&times;</span></button></a></li>
				    <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Profile</a></li>
				    <li role="presentation"><a href="#messages" aria-controls="messages" role="tab" data-toggle="tab">Messages <i class=" fa fa-close closeTab  pull-right"></i></a></li>
				    <li role="presentation"><a href="#settings" aria-controls="settings" role="tab" data-toggle="tab">Settings &nbsp<i class=" glyphicon glyphicon-camera  pull-right"></i></a> </li>
				    <li role="presentation" id="closetabli"><a href="#closetab" aria-controls="closetab" role="tab" data-toggle="tab"><span>closetab</span>
    &nbsp;<button type="button" class="closeTab"  id="closetabbtn">&times;</button>
    </a></li>
				 </ul>    
				 <div class="tab-content">
				    <div role="tabpanel" class="tab-pane active" id="home">
				    	<iframe src="${ctx}/test/menu" width="100%" height="100%" frameborder="0" id="test">
				    	
				    	</iframe>
				    </div>
				    <div role="tabpanel" class="tab-pane" id="profile">2</div>
				    <div role="tabpanel" class="tab-pane" id="messages">3</div>
				    <div role="tabpanel" class="tab-pane" id="settings">
					    <ul>
							<c:forEach var="listValue" items="${lists}">
								<li>${listValue.userid}</li>
							</c:forEach>
						</ul>
					</div>
			        <div role="tabpanel" class="tab-pane active" id="closetab">this is closetab</div>
				 </div>        
            </div>   
        </div>
        <!-- /#page-wrapper -->

    </div>

<script type="text/javascript">
$(document).ready(function() {
	/* alert($('#test').contentWindow().height());
	$('#test').load(function() { //方法1  
	    var iframeHeight = Math.min(iframe.contentWindow.window.document.documentElement.scrollHeight, iframe.contentWindow.window.document.body.scrollHeight);  
	    var h=$(this).contents().height();  
	    $(this).height(h+'px');   
	    alert(1);
	});   */
	$(".closeTab").click(function () {

	    //there are multiple elements which has .closeTab icon so close the tab whose close icon is clicked
	    var tabContentId = $(this).parent().attr("href");
	    $(this).parent().parent().remove(); //remove li of tab
	    $('#myTab a:last').tab('show'); // Select first tab
	    $(tabContentId).remove(); //remove respective tab content

	});
	
	setIframeHeight("test");
	function setIframeHeight(id){
	  try{
	    var iframe = document.getElementById(id);
	    if(iframe.attachEvent){
	      iframe.attachEvent("onload", function(){
	        iframe.height =  iframe.contentWindow.document.documentElement.scrollHeight + 20;
	      });
	      return;
	    }else{
	      iframe.onload = function(){
	        iframe.height = iframe.contentDocument.body.scrollHeight + 20;
	      };
	      return;				 
	    }	 
	  }catch(e){
	    throw new Error('setIframeHeight Error');
	  }
	}
});

</script>

</body>
</html>
