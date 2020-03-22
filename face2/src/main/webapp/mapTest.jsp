<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head lang="zh-CN">
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta name="mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-capable" content="yes">
    <meta name="apple-mobile-web-app-status-bar-style" content="black">
    <meta name="format-detection" content="address=no">
    <script type="text/javascript" src="//3gimg.qq.com/lightmap/components/locationPicker2/js/main-62c2e3b971.js"></script>
    <title>locationPicker Components Demo - link</title>
    <style>
        * {
            margin: 0;
            padding: 0;
        }
        body, html{
            overflow: hidden;
            padding: 30px;
        }
        li{
            list-style: none;
            line-height: 30px;
        }
    </style>
    <script>
        $(function(){
            $('.a').text(decodeURIComponent(getQueryStr('name')));
            $('.b').text(getQueryStr('latng'));
            $('.c').text(decodeURIComponent(getQueryStr('addr')));
            $('.d').text(decodeURIComponent(getQueryStr('city')));
            $('.e').text(decodeURIComponent(getQueryStr('module')));
        });
    </script>
</head>
<body>
    <h1>backurl</h1>
    <P>您刚选择的数据信息为：</P>
    <ul>
        <li>所使用组件:<b class="e"></b></li>
        <li>poi名称: <b class="a"></b></li>
        <li>poi经纬度:  <b class="b"></b></li>
        <li>poi地址:  <b class="c"></b></li>
        <li>poi所在城市:  <b class="d"></b></li>
    </ul>
</body>