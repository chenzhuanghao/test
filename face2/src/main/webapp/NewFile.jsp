<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.4.0.js"></script>
<script src="js/tracking.js"></script>
<script src="js/face-min.js"></script>
</head>
<style type="text/css">
#showImg{

}
</style>
<body>
<input type="file" name="" id="chooseImage" accept=".jpg,.jpeg,.png">
<input type="text" id="yingwenname" value="yingwenname">
<input type="text" id="username" value="姓名">
<input type="text" id="job" value="工作">
<input type="text" id="sal" value="薪资">
<input type="text" id="comm" value="奖金">
<input type="text" id="dept" value="部门">
   <img width="500px" height="500px" id="showImg" src="">
   <br/>
   	<div class="message">
		<canvas id="shortCut" width="500" height="500" style="border:1px solid #d3d3d3;background:#ffffff;"></canvas>
		<div id="checkinMsg"></div>
	</div>
<script>
$('#chooseImage').on('change',function(e){
    // 检查是否是图片
         //var dataURL
    //alert(username);
	var video11 = document.getElementById('showImg');
	//var canvas = $('canvas');
	//var context = $('2d');
	        var shortCut = document.getElementById('shortCut');
	        var scContext = shortCut.getContext('2d');
    var filePath = $(this).val(),
    fileFormat = filePath.substring(filePath.lastIndexOf(".")).toLowerCase();//获取文件后缀名
    //检查后缀名
    if( !fileFormat.match(/.png|.jpg|.jpeg/) ) {
          showError('文件格式必须为：png/jpg/jpeg');//showError是另外写的一个显示错误信息的function
          return;  
    }


    //获取并记录图片的base64编码
    var imageup;
   // var dataURL;
    var reader = new FileReader();
    reader.readAsDataURL(e.target.files[0]); // 读出 base64
    //console.log(e.target.files[0]);
    reader.onloadend = function () {
          // 图片的 base64 格式, 可以直接当成 img 的 src 属性值        
           var dataURL = reader.result;//base64
           imageup=dataURL;
       //  imageup=dataURL.substring(dataURL.indexOf(",")+1);
         //console.log("试一试"+imageup);
         // 显示图片
         
         //imageup=dataURL.substring(dataURL.indexOf(",")+1);
         $('#showImg').attr('src',dataURL);
        // $('#textarea').val(dataURL);
         //return dataURL;
             //alert(username);
            // alert(dataURL);


    };
    var yingwenname= $(" #yingwenname ").val();
    var username= $(" #username ").val();
    var job= $(" #job ").val();
    var sal= $(" #sal ").val();
    var comm= $(" #comm ").val();
    var dept= $(" #dept ").val();
    
    alert(username);
    //console.log("试一试"+imageup);
	        	scContext.drawImage(video11,0,0,500,500);
	            var imgStr = shortCut.toDataURL("image/png");
	            console.log("希望我能出来"+imgStr);
 	$.ajax	({
		url:"re-face/register-user",
		type:"post",
		dataType:"json",
		data:{
			yingwenname:yingwenname,
	        username:username,
	        job:job,
 			sal:sal,
 			comm:comm,
 			dept:dept,
			dataURL:imgStr.substring(imgStr.indexOf(",")+1)

		},
		success:function(result){
			console.log(result);
				if(result.user != "404"){
   				send("上传人脸错误");
				}
       	
		}
	});

   // imageup


	
});
</script>
</body>
</html>