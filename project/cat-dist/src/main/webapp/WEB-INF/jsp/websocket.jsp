<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<jsp:include page="/WEB-INF/jsp/public/meta.jsp"></jsp:include>
</head>
<body>
<h2>Hello World11111!</h2>

</body>
<script type="text/javascript">
//=========启动一个websocket
    var Socket1 = $.websocket({
        domain:"localhost",   //这是与服务器的域名或IP
        port:9998,                  //这是服务器端口号
        protocol:"text",            //这东西可有可无,组合起来就是 ws://www.qhnovel.com:8080/test
        onOpen:function(event){
            alert("已经与服务端握手,onOpen可省略不写");
        },
        onError:function(event){
            alert("发生了错误,onError可省略不写");
        },
        onSend:function(msg){
            alert("发送数据额外的代码,可省略不写");
        },
        onMessage:function(result,nTime){
            alert("从服务端收到的数据:" + result);
            alert("最近一次发送数据到现在接收一共使用时间:" + nTime);
        }
    });
    //=========发送数据方式
    Socket1.send("要发送的数据");
    //=========关闭连接
    Socket1.close();
</script>
</html>
