<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Layui</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="layui/css/layui.css"
	media="all">
<!-- 注意：如果你直接复制所有代码到本地，上述css路径需要改成你本地的 -->

</head>
<body>

	<table class="layui-hide" id="test" lay-filter="test"></table>

	<script type="text/html" id="toolbarDemo">
  <div class="layui-btn-container">
    <button class="layui-btn layui-btn-sm" lay-event="getCheckData">获取选中行数据</button>
    <button class="layui-btn layui-btn-sm" lay-event="getCheckLength">获取选中数目</button>
    <button class="layui-btn layui-btn-sm" lay-event="isAll">验证是否全选</button>
    <a class="layui-btn layui-btn-sm" href="NewFile.jsp">加入人脸</a>
    <a class="layui-btn layui-btn-sm" href="AddInform.jsp">发布公告</a>
  </div>
</script>

	<script type="text/html" id="barDemo">
  <a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  <a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
<div  class="layui-form-item" id="showInfo" style="display:none;height:500px;width:300px;">

    <div class="layui-input-inline">
      <label class="layui-form-label">密码框</label>
      <input type="password" name="password" required lay-verify="required" placeholder="请输入密码" autocomplete="off" class="layui-input">
    </div>
	<div  class="layui-form-item">
	<label  class="layui-form-label" >用户名</label>
	<input class="layui-input" type="text" id="showUserName">
	</div>
	
</div>

	<script src="layui/layui.js" charset="utf-8"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
<script type="text/javascript" src="js/jquery-3.4.0.js"></script>
	<script>
		layui.use('table', function() {
			var table = layui.table;

			table.render({
				elem : '#test',
				url : 'one/listWorker',
				toolbar : '#toolbarDemo' //开启头部工具栏，并为其绑定左侧模板
				,
				defaultToolbar : [ 'filter', 'exports', 'print', { //自定义头部工具栏右侧图标。如无需自定义，去除该参数即可
					title : '提示',
					layEvent : 'LAYTABLE_TIPS',
					icon : 'layui-icon-tips'
				} ],
				title : '用户数据表',
				cols : [ [ {
					type : 'checkbox',
					fixed : 'left'
				}, {
					field : 'user_id',
					title : 'ID',
					width : 80,
					fixed : 'left',
					unresize : true,
					sort : true
				}, {
					field : 'uname',
					title : '用户名',
					width : 120,
					edit : 'text'
				}, {
					field : 'user_pass',
					title : '邮箱',
					width : 150,
					edit : 'text',
					templet : function(res) {
						return '<em>' + res.email + '</em>'
					}
				}, {
					field : 'job',
					title : '性别',
					width : 80,
					edit : 'text',
					sort : true
				}, {
					field : 'sal',
					title : '城市',
					width : 100
				}, {
					field : 'comm',
					title : '签名'
				}, {
					field : 'dept',
					title : '积分',
					width : 80,
					sort : true
				}, {
					field : 'ip',
					title : 'IP',
					width : 120
				}, {
					field : 'logins',
					title : '登入次数',
					width : 100,
					sort : true
				}, {
					field : 'joinTime',
					title : '加入时间',
					width : 120
				}, {
					fixed : 'right',
					title : '操作',
					toolbar : '#barDemo',
					width : 150
				} ] ],
				page : true
			});

			//头工具栏事件
			table.on('toolbar(test)', function(obj) {
				var checkStatus = table.checkStatus(obj.config.id);
				switch (obj.event) {
				case 'getCheckData':
					var data = checkStatus.data;
					layer.alert(JSON.stringify(data));
					break;
				case 'getCheckLength':
					var data = checkStatus.data;
					layer.msg('选中了：' + data.length + ' 个');
					break;
				case 'isAll':
					layer.msg(checkStatus.isAll ? '全选' : '未全选');
					break;

				//自定义头工具栏右侧图标 - 提示
				case 'LAYTABLE_TIPS':
					layer.alert('这是工具栏右侧自定义的一个图标按钮');
					break;
				}
				;
			});

			//监听行工具事件
			table.on('tool(test)', function(obj) {
				var data = obj.data;
				alert(data.user_id);
				var user_id = data.user_id;
				//console.log(obj)
				if (obj.event === 'del') {
					layer.confirm('真的删除行么', function(index) {
						$.ajax({
							type : "get", //提交方式
							url : "one/edit", //後台路徑
							data : { //你想傳的數據
							"user_id":user_id
							},
							success : function(appleData){
							alert(appleData);
							}
							});
						obj.del();
						layer.close(index);
					});
				} else if (obj.event === 'edit') {
			   		$("#showID").val(data.user_id);
			   		$("#showUserName").val(data.user_pass);
					layer.open({
				    	  title: '查看信息'
				    	  ,type: 1
				          ,skin: 'layui-layer-rim'//加上边框
				          ,area: ['400px', 'auto'] //宽高
				          ,shadeClose: true//点击遮罩关闭
				    	  ,content: $("#showInfo")
				      });

					
					
				}
			});
		});
	</script>

</body>
</html>