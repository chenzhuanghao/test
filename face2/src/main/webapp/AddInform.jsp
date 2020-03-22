<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <title>Layui</title>
  <meta name="renderer" content="webkit">
  <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <link rel="stylesheet" href="css/layui.css"  media="all">
  <!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->
</head>
<body>
          

              
<fieldset class="layui-elem-field layui-field-title" style="margin-top: 20px;">
  <legend>添加公告</legend>
</fieldset>
 
<form class="layui-form" action="<%=request.getContextPath()%>/one/addInform" method="get">
  <div class="layui-form-item">
    <label class="layui-form-label">单行输入框</label>
    <div class="layui-input-block">
      <input type="text" name="i_topic" lay-verify="title" autocomplete="off" placeholder="请输入标题" class="layui-input">
    </div>
  </div>

  

  
  <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label">选择日期</label>
      <div class="layui-input-inline">
        <input type="text" name="i_date" id="date" lay-verify="date" placeholder="yyyy-MM-dd" autocomplete="off" class="layui-input">
      </div>
    </div>

  </div>
    <div class="layui-form-item">
    <div class="layui-inline">
      <label class="layui-form-label"></label>
      <div class="layui-input-inline">
        <input type="text" name="i_name"  class="layui-input" value="admin" >
      </div>
    </div>

  </div>
  
  
  
  

  <div class="layui-form-item layui-form-text">
    <label class="layui-form-label">普通文本域</label>
    <div class="layui-input-block">
      <textarea placeholder="请输入内容" name="i_article" class="layui-textarea"></textarea>
    </div>
  </div>
  <!--<div class="layui-form-item layui-form-text">
    <label class="layui-form-label">编辑器</label>
    <div class="layui-input-block">
      <textarea class="layui-textarea layui-hide" name="content" lay-verify="content" id="LAY_demo_editor"></textarea>
    </div>
  </div>-->
  <div class="layui-form-item">
    <div class="layui-input-block">
      <input type="submit" class="layui-btn"  value="立即提交" lay-submit="" lay-filter="demo1">
      <input type="reset" value="重置" class="layui-btn layui-btn-primary">
    </div>
  </div>
</form>
 
<script src="layui/layui.js" charset="utf-8"></script>
<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  //日期
  laydate.render({
    elem: '#date'
  });
  laydate.render({
    elem: '#date1'
  });
  
  //创建一个编辑器
  var editIndex = layedit.build('LAY_demo_editor');
 
  //自定义验证规则
  form.verify({
    title: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
  });
  
  

 
  
  
});
</script> 

</body>
</html>