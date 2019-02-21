<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pages/taglibs.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>支付管理系统</title>
		<link  href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript">
			$(function(){	
				initLeftNav(0);
				//导航切换
				switchNav();
			});
			function switchNav(){
				$(".menuson li").click(function(){
					$(".menuson li.active").removeClass("active")
					$(this).addClass("active");
				});
				$('.title').click(function(){
					var $ul = $(this).next('ul');
					$('dd').find('ul').slideUp();
					if($ul.is(':visible')){
						$(this).next('ul').slideUp();
					}else{
						$(this).next('ul').slideDown();
					}
				});
			}
			function initLeftNav(parentId){
				var navStr = "";
				if(parentId && parentId>0){
					$('#leftmenu').html("<dd><img alt='' src='${ctx}/images/loading.gif'>数据加载中...</dd>");
					var i=0;
				    $.ajax({
		    			url:"${ctx}/menu/getRoleMenuTree",
		    			type:"POST",
		    			data:{'menuType':0,'parentId':parentId},
		    			dataType:"json",
		    			async: false,
		    			success:function(data){
		    				if(data && data.length>0){
		    					for(d in data){
		    						var nav = data[d];
		    						if(nav){
		    							navStr += "<dd>";
		    							navStr += "<div class='title'><span><img src='${ctx}/images/leftico01.png'/></span>"+nav.name+"</div>";
		    							var children = nav.children;
		    							if(children && children.length>0){
		    								navStr += "<ul class='menuson'>";
			    								for(c in children){
			    									var subNav = children[c];
			    									if(subNav){
			    										if(i==0){
				    										parent.topFrame.initIndexPage(parentId,subNav.url);
				    									}
			    										navStr += " <li><cite></cite><a href='${ctx}/"+subNav.url+"' target='rightFrame'>"+subNav.name+"</a><i></i></li>";
			    									}
			    									i++;
			    								}
		    								navStr += "</ul>";
		    							}
		    							navStr += "</dd>";
		    						}
		    					}
		    				}
		    			},error:function(data){
		    				$.messager.alert('提示',data,'error');
		    			}
		    		});
				}else{
					navStr +="<dd><div class='title'><span><img src='${ctx}/images/leftico01.png'/></span>管理信息</div><ul class='menuson'><li class='active'><cite></cite><i></i></li></ul></dd>";
					navStr='';
				}
				$('#leftmenu').html(navStr);
				switchNav();
			}
		</script>
	</head>
	<body style="background:#f0f9fd;">
		<div class="lefttop"><span></span>导航菜单</div>
	    <dl class="leftmenu" id="leftmenu">
	    </dl>
	</body>
</html>