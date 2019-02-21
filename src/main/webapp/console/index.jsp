<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../pages/taglibs.jsp"%>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>支付管理平台</title>
		<link  href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/css/themes/icon.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/css/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.easyui.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.utils.js" charset="utf-8"></script>
		<style type="text/css">
			.duanli{border: medium double rgb(250,0,0);}
		</style>
	</head>
	<body>

	<div style="table-layout:fixed;" id="center_table">
		<div class="place">
	   	 <span>位置：</span>
		    <ul class="placeul">
		    	<li><a href="#">首页</a></li>
		    </ul>
	    </div>
	    <div class="mainindex">
		    <div class="welinfo">
			    <span><img src="${ctx}/images/sun.png" alt="天气" /></span>
			    <b><shiro:principal/> 早上好，欢迎使用支付系统！</b>
			    <a href="#" onclick="javascript:openUserDialog();">修改密码</a>
		    </div>
		    
		    <div class="welinfo">
		    	<span><img src="${ctx}/images/time.png" alt="时间" /></span>
		    	<i>您上次登录的时间：<label id='lastActivity'></label></i> （不是您登录的？<a href="${ctx}/logout" target="_parent">请点这里</a>）
		    </div>
		     <div class="welinfo">
		    	<span><img src="${ctx}/images/time.png" alt="时间" /></span>
		    	<i>这是您第 <label id='loginCount'></label> 次登录</i>
		     </div>
		    <div class="xline"></div>
		    <div class="box"></div>
	    </div>
	    </div>
    	<!-- dialog -->
		<div id="userDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:320px;height:210px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="userForm" method="post">
 					<fieldset style="width:270px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
 						<tr>
 							<td>
 								<input id="userId" name="id" type="hidden">
 							</td>
 						</tr>
 						<tr>
 							<td>新密码<b>*</b></td><td><input id="pswd"   name="pswd" class="easyui-validatebox" type="password"    data-options="validType:'checkPswd'"></input></td>
 						</tr>
 						<tr>
							<td>确认密码<b>*</b></td><td><input id="rePswd" name="rePswd" class="easyui-validatebox" type="password"  data-options="validType:'checkPswd'"></input></td>
 						</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog buttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="submitForm();">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#userDialog').dialog('close');">关闭</a>
		</div>
	</body>
	<script type="text/javascript">
			$(function(){	
				//导航切换
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
				getLoginUserInfo();
				
				//统计
				/* $.ajax({
    				url:'${ctx}/order/getOrderAll',
    				type:"POST",
    				dataType:"json",
    				async: false,
    				success:function(data){
    					if(data){
    						$('#allTotalCount').html(data.count);
    						$('#allTotalAmt').html(data.totleAmt+'元');
    					}
    				}
    			});
				$.ajax({
    				url:'${ctx}/order/getOrderMonth',
    				type:"POST",
    				dataType:"json",
    				async: false,
    				success:function(data){
    					if(data){
    						$('#monthTotalCount').html(data.count);
    						$('#monthTotalAmt').html(data.totleAmt+'元');
    					}
    				}
    			});
				$.ajax({
    				url:'${ctx}/order/getOrderWeek',
    				type:"POST",
    				dataType:"json",
    				async: false,
    				success:function(data){
    					if(data){
    						$('#weekTotalCount').html(data.count);
    						$('#weekTotalAmt').html(data.totleAmt+'元');
    					}
    				}
    			});
				$.ajax({
    				url:'${ctx}/order/getOrderDay',
    				type:"POST",
    				dataType:"json",
    				async: false,
    				success:function(data){
    					if(data){
    						$('#dayTotalCount').html(data.count);
    						$('#dayTotalAmt').html(data.totleAmt+'元');
    					}
    				}
    			}); */
				
			})
			function getLoginUserInfo(){
				var userName = '<shiro:principal/>';
				$.ajax({
    				url:'${ctx}/admin/getAdmin',
    				type:"POST",
    				data:{'userName':userName},
    				dataType:"json",
    				async: false,
    				success:function(data){
    					if(data){
    						$('#lastActivity').text($.formatDate(data.lastActivity));
    						$('#loginCount').text(data.loginCount);
    						$('#userId').val(data.id);
    					}
    				}
    			});
			}
			function openUserDialog(){
				$('#pswd').val('');
				$('#rePswd').val('');
				$('#userDialog').dialog('open');
			}
		    function submitForm(){
		    	$('#userForm').form('submit',{
			    	 dataType:"json",
			    	 url:'${ctx}/admin/setPassWord',
			    	 onSubmit:function(){
			    		 if($(this).form('validate'))
			    			 return true;
			    		 else 
			    			 return false;
			    	 },success:function(data){
			    		$('#userDialog').dialog('close');
			    	 	$.messager.alert('Info',eval(data), 'info');
			    	 	hideLoading();
			    	 } 
		    	});
	        }
		    // 自定义密码验证
		  	$.extend($.fn.validatebox.defaults.rules, {
			  checkPswd:{
			   validator: function(value,param){
				   var pswd   = $('#pswd').val();
				   var rePswd = $('#rePswd').val();
				    if(!pswd || !rePswd)
 						return false;
				  	if(pswd !=rePswd)
	               		return false;
					return true;
			   },
			   message: '两次密码必须输入一致!'
			  }
		  	});
	</script>
</html>