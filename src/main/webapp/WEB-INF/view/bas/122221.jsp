<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../pages/taglibs.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>title</title>
		<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/css/themes/icon.css" rel="stylesheet" type="text/css" />
		<link href="${ctx}/css/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
		<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.easyui.min.js" charset="utf-8"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.utils.js" charset="utf-8"></script>
		<script type="text/javascript" src="${ctx}/js/jquery.form.js" charset="utf-8"></script>
		<script type="text/javascript" src="${ctx}/js/locale/easyui-lang-zh_CN.js"></script>
		<style type="text/css">
			.setBox{ margin:10px;border:1px solid rgb(225,225,225)!important}
			.title{ padding:10px;box-sizing:border-box;background:rgb(247,247,247)!important;font-size:16px;border-bottom:1px solid rgb(225,225,225)!important}
			.content{ width:100%;border-bottom:1px solid #f4f4f4;padding: 15px 0;}
			.content table{width: 70%;margin:0 15%;}
			.content table td{font-size:16px;padding:10px 0;}
			.content table input{ width:100%;border:1px solid rgb(225,225,225)!important;padding: 10px;border-radius:5px;box-sizing:border-box;height:auto;}
			.footer{ padding:20px;box-sizing:border-box;}
			.footer table{ width:100%;text-align:center;}
			.footer table input{ padding:10px 20px;border-radius:5px;color:#fff;height:auto;font-size:18px;}
			.footer table td:nth-of-type(1) input{ background:#f39c12;border:1px solid #e08e0b;}
			.footer table td:nth-of-type(2) input{ background:#367fa9;border:1px solid #204d74;}
	  	</style>
	</head>
	<body>
		<form>
			<div class='setBox'>
				<div class='title'>编辑</div>
				<div class='content'>
					<div style="border-bottom:1px solid #ececec;margin:0 20px;">
						<table>
							<tr>
								<td width="120px">出款通道</td>
								<td><input type="text" placeholder="出款通道" /></td>
							</tr>
							<tr>
								<td>收款账户</td>
								<td><input type="text" placeholder="出款通道" /></td>
							</tr>
							
						</table>
					</div>
					
					<div style="border-bottom:1px solid #ececec;margin:0 20px;">
						<table>
							<tr>
								<td width="120px">银行名称</td>
								<td><input type="text" placeholder="银行名称" /></td>
							</tr>
							<tr>
								<td>开户行名称</td>
								<td><input type="text" placeholder="开户行名称"/></td>
							</tr>
							<tr>
								<td>银行省份</td>
								<td><input type="text" placeholder="银行省份"/></td>
							</tr>
							<tr>
								<td>银行城市</td>
								<td><input type="text" placeholder="银行城市"/></td>
							</tr>
							<tr>
								<td>大小额行联号</td>
								<td><input type="text" placeholder="大小额行联号"/></td>
							</tr>
							<tr>
								<td>银行卡号</td>
								<td><input type="text" placeholder="银行卡号"/></td>
							</tr>
							<tr>
								<td>姓名</td>
								<td><input type="text" placeholder="姓名"/></td>
							</tr>
							<tr>
								<td>银行预留手机</td>
								<td><input type="text" placeholder="银行预留手机"/></td>
							</tr>
							<tr>
								<td>打款金额</td>
								<td><input type="text" placeholder="打款金额"/></td>
							</tr>
							<tr>
								<td>打款方式</td>
								<td><input type="text" placeholder="打款方式"/></td>
							</tr>
							<tr>
								<td>备注</td>
								<td><input type="text" placeholder="备注"/></td>
							</tr>
						</table>
					</div>
					<div>
						<table>
							<tr>
								<td width="120px">资金密码</td>
								<td><input type="text" placeholder="资金密码" /></td>
							</tr>
							<tr>
								<td>谷歌验证码</td>
								<td><input type="text" placeholder="谷歌验证码" /></td>
							</tr>
							
						</table>
					</div>
				</div>
				<div class='footer'>
					<table>
						<tr>
							<td><input type="reset" /></td>
							<td><input type="button" value="提交" id="submitBtn"/></td>
						</tr>
					</table>
				</div>
			</div>
		</form>
	</body>
	<script>
		$(function(){
			$("#submitBtn").click(function(){
				var pw = $("#password").val();
				var spw = $("#surePassword").val();
				if(!pw){
					$.messager.alert('提示','请输入密码', 'info');
				}else if(!spw){
					$.messager.alert('提示','请输入确认密码', 'info');
				}else if(pw !== spw){
					$.messager.alert('提示','两次密码 输入不一致', 'info');
				}else{
					$.ajax({type:'GET',url:'${ctx}/ralAccountTransMode/getRalAccountTransModeById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		/* if(data.code == '0000'){
	        	    			
	        	    		} */
	        	    		$.messager.alert('提示',data.msg,'info');	
		        	    },error:function(res){
		        	  	    $.messager.alert('提示',eval(res.responseText),'info');
		        	    },
		        	    dataType:'json'
		        	});
				}
			});
		})
	</script>
</html>