<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c"   uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/public/meta.jsp"></jsp:include>

</head>
<body>
	<div style="">
	    <table id="jqGrid"></table>
	    <div id="jqGridPager">
    </div>
    	
</div>

<script type="text/javascript">
$(document).ready(function() {
	$("#jqGrid").jqGrid({
        url: '<%=request.getContextPath()%>/queryUserList',
        mtype: "GET",
        datatype: "json",
        styleUI: 'Bootstrap',//设置jqgrid的全局样式为bootstrap样式
        colModel: [
            { label: 'userid', name: 'userid', key: true, width: 75 },
            { label: 'userna', name: 'userna', width: 150 },
            { label: 'email', name: 'email', width: 150 },
            { label: 'gender', name: 'gender', width: 150 },
            { label:'mobile', name: 'mobile', width: 150 }
        ],
		page: 1,
		autowidth: true,
        shrinkToFit: true,
        height: 250,
        rowNum: 20,
        rowList:[20,30,50],
	//	scrollPopUp:true,
	//	scrollLeftOffset: "83%",
		viewrecords: true,
        //scroll: 1, // set the scroll property to 1 to enable paging with scrollbar - virtual loading of records
        emptyrecords: 'Scroll to bottom to retrieve new page', // the message will be displayed at the bottom 
        pager: "#jqGridPager"
    });
});

</script>
</body>
</html>
