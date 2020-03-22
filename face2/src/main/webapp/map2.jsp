<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="Content-Security-Policy" content="upgrade-insecure-requests" />
<title>Insert title here</title>
</head>
<style>
#mapPage:{
width:1000px;
height:1000px;
}
</style>
<body>
<iframe id="mapPage" style="width:800px;height:800px;" frameborder=0
    src="https://apis.map.qq.com/tools/locpicker?search=1&type=0&backurl=http://localhost:8085/face2/mapTest.jsp&key=LBZBZ-UR5W4-XISUA-DXMYP-6IJUO-ZSBKW&referer=myapp">
</iframe>
 
<script>
    window.addEventListener('message', function(event) {
    	alert("ddddd");
        // 接收位置信息，用户选择确认位置点后选点组件会触发该事件，回传用户的位置信息
        var loc = event.data;
        if (loc && loc.module == 'locationPicker') {//防止其他应用也会向该页面post信息，需判断module是否为'locationPicker'
          console.log('location', loc);
        }
    }, false);
</script>
</body>
</html>