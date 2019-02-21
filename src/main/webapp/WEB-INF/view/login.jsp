<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../pages/taglibs.jsp"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>支付管理系统</title>
	<link  href="${ctx}/css/login.css" rel="stylesheet" type="text/css" />
	<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
	<script type="text/javascript" src="${ctx}/js/cloud.js"></script>
	<script language="javascript">
		$(function(){
		    $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
			$(window).resize(function(){  
		      $('.loginbox').css({'position':'absolute','left':($(window).width()-692)/2});
		    })  
		    if(top.location!=self.location){
		    	  //说明你的页面在if框架中显示
		    	  	parent.location.reload();
		    	}else{
		    	}
	    	});  
	</script> 
</head>

<body style="background-color:#1c77ac; background-image:url(images/light.png); background-repeat:no-repeat; background-position:center top; overflow:hidden;">
    <div id="mainBody">
      <div id="cloud1" class="cloud"></div>
      <div id="cloud2" class="cloud"></div>
    </div>  
	<div class="logintop">    
	    <span>欢迎登录支付管理系统</span>    
	    <ul>
	    <li><a href="#">回首页</a></li>
	    <li><a href="#">帮助</a></li>
	    <li><a href="#">关于</a></li>
	    </ul>    
    </div>
    <div class="loginbody">
	    <span class="systemlogo"></span> 
	    <div class="loginbox">
	    <form action="" method="post"> 
	    <ul>
		    <li><input type="text" name="username" class="loginuser" value="${userName }" placeholder="请输入用户名"/></li>
		    <li><input type="password" name="password" class="loginpwd" onclick="JavaScript:this.value=''"  placeholder="请输入密码"/></li>
		    <li style="font-family: '微软雅黑';font-weight: bold;font-size: 15px;margin-bottom: 15px;color:red;">${error }</li>
		    <li style="font-family: '微软雅黑';font-weight: bold;font-size: 15px;margin-bottom: 15px;color:red;">${kickOutMsg }</li>
		    <li>
		       <input name="" type="submit" class="loginbtn" value="登录"/>
		       <label><input name="rememberMe" type="checkbox" value="true"/>记住密码</label>
		       <label><a href="#">忘记密码？</a></label>
		    </li>
	    </ul>
	    </form>
	    </div>
    </div>
    <div class="loginbm">@版权所有 <a href="">INLEE</a>技术支持; (推荐使用IE8+,谷歌浏览器可以获得更快,更安全的页面响应速度)</div>
</body>
</html>