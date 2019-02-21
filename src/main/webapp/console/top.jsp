<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pages/taglibs.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>支付管理系统</title>
		<link  href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
	</head>
	<body style="background: rgb(65,172,233);">
	    <div class="topleft">
	    	<a href="main.html" target="_parent">
	    		支付管理系统
	    		<%-- <img src="${ctx}/images/loginlogo.png" title="系统首页" /> --%>
	    	</a>
	    </div>
	    <ul id="nav" class="nav">
	    </ul>
	    <div class="topright">
	    	<div class="user">
			    <span>欢迎[<shiro:principal/>]</span>
			<!--     <i>消息</i>
			    <b>5</b> -->
		    </div> 
		    <ul>
			    <li><span><img src="${ctx}/images/help.png" title="帮助"  class="helpimg"/></span><a href="#">帮助</a></li>
			    <li><a href="${ctx}/admin/toSetPassWordPage" target="rightFrame">设置</a></li>
			    <!-- <li><a href="#">关于</a></li> -->
			    <li><a href="${ctx}/logout" target="_parent">退出</a></li>
		    </ul>
	    </div>
	    <script type="text/javascript">
			$(function(){	
				// 加载顶部菜单
				getTopNav();
				//顶部导航切换
				$(".nav li a").click(function(){
					$(".nav li a.selected").removeClass("selected")
					$(this).addClass("selected");
				})	
			});
			function getTopNav(){
				var navs = "<li onclick='initLeftNav(0);''><a href='index.jsp' target='rightFrame' class='selected'><h2>工作台</h2></a></li>";
			     $.ajax({
		    			url:"${ctx}/menu/getRoleMenu",
		    			type:"POST",
		    			data:{'menuType':0,'parentId':0},
		    			dataType:"json",
		    			async: false,
		    			success:function(data){
		    				if(data && data.length>0){
		    					for(d in data){
		    						var nav = data[d];
		    						if(nav){
		    							navs +="<li onclick='initLeftNav("+nav.id+");''><a id='top_"+nav.id+"' href='' target='rightFrame'><h2>"+nav.name+"</h2></a></li>";
		    						}
		    					}
		    				}
		    			},error:function(data){
		    				$.messager.alert('提示',data,'error');
		    			}
		    		});
			     $('#nav').html(navs);
			}
			function initIndexPage(id,url){
				document.getElementById("top_"+id).href="${ctx}/"+url;
			}
			function initLeftNav(id){
				parent.leftFrame.initLeftNav(id);
			}
	    </script>
	</body>
</html>