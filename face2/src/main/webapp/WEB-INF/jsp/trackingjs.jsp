<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests" />
<title>Insert title here</title>
<script src="js/jquery-3.4.0.js"></script>
<script src="js/tracking.js"></script>
<script src="js/face-min.js"></script>
<style>
* {
	padding: 0;
	margin: 0;
}

.container {
	position: relative;
	width: 581px;
	height: 436px;
	float: left;
}

.message {
	float: left;
}

video, #canvas {
	position: absolute;
	width: 581px;
	height: 436px;
}

video {
	background-color: red;
}
</style>


</head>
<body>
	<div class="container">
		<video id="video" width="320" height="240" preload autoplay loop muted></video>
		<canvas id="canvas" width="581" height="436"></canvas>
	</div>
	<div class="message">
		<canvas id="shortCut" width="290" height="218"></canvas>
		<div id="checkinMsg"></div>
	</div>
</body>

<script>
	    $(function () {
	    	
	    	
	    	
	        var video = document.getElementById('video');
	        var canvas = document.getElementById('canvas');
	        var context = canvas.getContext('2d');
	        var shortCut = document.getElementById('shortCut');
	        var scContext = shortCut.getContext('2d');
			var time =3000;//向后台发照片的冷却时间
			
	        //var tracker = new tracking.ObjectTracker('face');
			var objects = new tracking.ObjectTracker("face");
			objects.setInitialScale(4);
			objects.setStepSize(2);
			objects.setEdgesDensity(0.1);
	
			
			tracking.track('#video', objects, {camera: true});
			var flag=true;
	        objects.on('track', function (event) {
	        	if (event.data.length === 0) {
	        		context.clearRect(0, 0, canvas.width, canvas.height);
	        	}else{
	        		context.clearRect(0, 0, canvas.width, canvas.height);
	        		event.data.forEach(function (rect) {
		                context.strokeStyle = '#ff0000';
		                context.strokeRect(rect.x, rect.y, rect.width, rect.height);
		                context.fillStyle = "#ff0000";
		                //console.log(rect.x, rect.width, rect.y, rect.height);
		            });

	        		if(flag){
		        		console.log("c333");
	        			console.log("拍照");
	        			getPhoto();
	        			flag=false;
	        			setTimeout(function(){flag=true;},time);
	        		}else{
	        			//console.log("冷却中");
	        		}
	        	}
	        });
			
	        
	        function getPhoto() {
	        	scContext.drawImage(video,0,0,290,218);
	        	var imgStr = shortCut.toDataURL("image/png");
    			console.log(imgStr);
	        	//讲拍照的图片数据发送到controller，调用百度云，签到，返回签到结果
	        	$.ajax	({
	        		url:"for-face/identify-user",
	        		type:"post",
	        		dataType:"json",
	        		data:{
	        			imgStr:imgStr.substring(imgStr.indexOf(",")+1)
	        		},
	        		success:function(result){
	        			console.log(result);
	        			if(result.result == "true"){
	        				if(result.user != "404"){
		        				send("user_info:"+result.user);
	        				}
	        			}
	    	        	
	        		}
	        	});
	        	
	        }
			
	        
	    	var websocket = null; 
	    	//判断当前浏览器是否支持WebSocket 
	    	if ('WebSocket' in window) { 
	    		websocket = new WebSocket("ws://127.0.0.1:8085/face2/websocket"); 
	    	} else { 
	    		alert('当前浏览器不支持websocket！请更换浏览器！');
	    	} 
	    	//连接发生错误的回调方法 
	    	websocket.onerror = function () { 
	    		setMessageInnerHTML("WebSocket连接发生错误"); 
	    	}; 
	    	//连接成功建立的回调方法
	    	websocket.onopen = function () { 
	    		setMessageInnerHTML("WebSocket连接成功"); 
	    	} ;
	    	
	    	//接收到消息的回调方法 
	    	websocket.onmessage = function (event) { 
	    		setMessageInnerHTML(event.data); 
	    	};
	    	//连接关闭的回调方法
	    	websocket.onclose = function () { 
	    		setMessageInnerHTML("WebSocket连接关闭"); 
	    	};
	    	//监听窗口关闭事件，当窗口关闭时，主动去关闭websocket连接，防止连接还没断开就关闭窗口，server端会抛异常。
	    	window.onbeforeunload = function () { 
	    		closeWebSocket(); 
	    	}; 
	    	//将消息显示在网页上 
	    	function setMessageInnerHTML(innerHTML) { 
	    		document.getElementById('checkinMsg').innerHTML += innerHTML + '<br/>'; 
	    	} 
	    	//关闭WebSocket连接 
	    	function closeWebSocket() { 
	    		websocket.close(); 
	    	} 
	    	//发送消息 
	    	function send(msg) { 
	    		websocket.send(msg); 
	    	} 
	    });
	
	</script>
</html>