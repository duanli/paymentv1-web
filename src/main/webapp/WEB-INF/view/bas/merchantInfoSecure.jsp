<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../pages/taglibs.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/themes/bootstrap/easyui.css" rel="stylesheet"
	type="text/css" />
<link href="${ctx}/css/themes/bootstrap/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<link href="${ctx}/css/themes/bootstrap/AdminLTE.min.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery.easyui.min.js"
	charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery.utils.js"
	charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery.form.js"
	charset="utf-8"></script>
<script type="text/javascript"
	src="${ctx}/js/locale/easyui-lang-zh_CN.js"></script>
<script type="text/javascript" src="${ctx}/js/qrcode.min.js"></script>
<style type="text/css">
.contBox {
	padding: 10px;
	box-sizing: border-box;
}

.contBox h3 {
	text-align: left;
}

.contBox .promise {
	padding: 10px 0;
	font-size: 16px;
}

.scancodeBox {
	width: 300px;
	height: 300px;
	background: #ececec;
	border-radius: 5px;
	padding: 10px;
	box-sizing: border-box;
}

.mwInput {
	width: 300px;
	border: 1px solid rgb(225, 225, 225) !important;
	padding: 10px;
	border-radius: 5px;
	box-sizing: border-box;
	height: auto;
}

.contBox button {
	padding: 5px 20px;
	border-radius: 5px;
	color: #fff;
	height: auto;
	font-size: 18px;
	margin-top: 15px;
}

.contBox button:nth-of-type(1) {
	background: #f39c12;
	border: 1px solid #e08e0b;
	margin-right: 50px;
}

.contBox button:nth-of-type(2) {
	background: #367fa9;
	border: 1px solid #204d74;
}

.validataBox {
	font-size: 16px;
	padding: 10px 0;
}

.validataBox input {
	width: 200px;
	border: 1px solid rgb(225, 225, 225) !important;
	padding: 10px;
	border-radius: 5px;
	box-sizing: border-box;
	height: auto;
}

.content {
	width: 100%;
	border-bottom: 1px solid #f4f4f4;
	padding: 15px 0;
	min-height: auto;
}

.content table {
	width: 70%;
	margin: 0 15%;
}

.content table td {
	font-size: 16px;
	padding: 10px 0;
}

.content table input {
	width: 100%;
	border: 1px solid rgb(225, 225, 225) !important;
	padding: 10px;
	border-radius: 5px;
	box-sizing: border-box;
	height: auto;
}

.footer {
	padding: 20px;
	box-sizing: border-box;
}

.footer table {
	width: 100%;
	text-align: center;
}

.footer table input {
	padding: 5px 20px;
	border-radius: 5px;
	color: #fff;
	height: auto;
	font-size: 18px;
}

.footer table td:nth-of-type(1) input {
	background: #f39c12;
	border: 1px solid #e08e0b;
}

.footer table td:nth-of-type(2) input {
	background: #367fa9;
	border: 1px solid #204d74;
}

.vPromise {
	font-size: 12px;
	color: #999;
	margin-top: 5px;
}
</style>
</head>
<body>
	<div id="tt" class="easyui-tabs">
		<div title="设置谷歌验证码" style="padding: 20px; display: none;">
			<c:if test="${googleAuthFlag!=null&&googleAuthFlag=='0'}">
				<div class='contBox' id="qrcodeBox">
					<h3>GOOGLE验证器绑定</h3>
					<div class="promise">使用阿里身份宝APP扫码( 备注：身份宝下载地址
						http://otp.aliyun.com/m/index.html)</div>
					<div class="scancodeBox">
						<div id="scancode"></div>
					</div>
					<div class="promise">密文( 备注：身份宝APP可以手动添加密文)</div>
					<input type="text" value="${googleAuthKey}" class="mwInput"
						disabled="disabled" />
					<div class="promise" style="color: red;">重要提示：请你抄写密文进行备份，以便在需要恢复的时候使用。请务必妥善保管密文，防止泄露。</div>
					<div class="validataBox">
						谷歌验证码：<input type="text" class='resetInput' id="googleQrcode"
							placeholder="请输入谷歌验证码" />
					</div>
					<button class="reset">重置</button>
					<button id="qrcodeSubmitBtn">提交</button>
				</div>
			</c:if>
			<c:if test="${googleAuthFlag!=null&&googleAuthFlag=='1'}">
				<div class="contBox" id="promiseBox">
					<div class="promise">您已设置了安全验证码,如需要变更,请联系管理员解绑!</div>
				</div>
			</c:if>
		</div>

		<div title="设置支付密码"
			style="overflow: auto; padding: 20px; display: none;">
			<div class='setBox'>
				<div class='content'>
					<table>
						<tr>
							<td width='130px'>支付密码：</td>
							<td><input type="password" id="password" class='resetInput'
								placeholder="请输入支付密码" /></td>
						</tr>
						<tr>
							<td>确认支付密码：</td>
							<td><input type="password" id="surePassword"
								class='resetInput' placeholder="请确认支付密码" /></td>
						</tr>
						<tr>
							<td>谷歌验证码：</td>
							<td><input type="text" id="googleQrcode1" class='resetInput'
								placeholder="请输入谷歌验证码" /></td>
						</tr>
					</table>
				</div>
				<div class='footer'>
					<table>
						<tr>
							<td><input type="button" value="重置" class="reset" /></td>
							<td><input type="button" value="提交" id="paySubmitBtn" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
		<div title="代付安全设置"
			style="padding: 20px 20px 20px 100px; display: none;">
			<div class='contBox'>
				<div class="validataBox">
					<span>提现白名单：</span><input class="easyui-switchbutton resetInput"
						checked>
					<div class="vPromise" style="padding-left: 70px;">在卡号管理中,并启用的卡为白名单卡</div>
				</div>
				<div class="validataBox">
					<span>谷歌验证码：</span><input type="text" class='resetInput'
						id="googleQrcode2" placeholder="请输入谷歌验证码" />
				</div>

				<button class="reset">重置</button>
				<button id="dfSubmitBtn">提交</button>

			</div>

		</div>
		<div title="api安全设置" style="padding: 20px; display: none;">
			<div class='setBox'>
				<div class='content'>
					<table>
						<tr>
							<td width='130px'>APP ID：</td>
							<td><input type="text" id="appId" placeholder="${APPID}"
								disabled="disabled" /></td>
						</tr>
						<tr>
							<td>秘钥：</td>
							<td><input type="text" id="secret"
								placeholder="*************" disabled="disabled" /></td>
						</tr>
						<tr>
							<td>谷歌验证码：</td>
							<td><input type="text" id="googleQrcode3" class='resetInput'
								placeholder="请输入谷歌验证码" /></td>
						</tr>
					</table>
				</div>
				<div class='footer'>
					<table>
						<tr>
							<td><input type="button" value="重置" class="reset" /></td>
							<td><input type="button" value="提交" id="apiSubmitBtn" /></td>
						</tr>
					</table>
				</div>
			</div>
		</div>
	</div>
	<script>
		$(function(){
			<c:if test="${googleAuthFlag!=null&&googleAuthFlag=='0'}">
			var qrcode = new QRCode(document.getElementById("scancode"), {
			    text: '${googleAuthUrl}',
			    width: 280,
			    height: 280,
			    colorDark : "#000000",
			    colorLight : "#ffffff",
			    correctLevel : QRCode.CorrectLevel.H
			});
			
			$(".reset").click(function(){
				$(".resetInput").val("");
			});
			
			$("#qrcodeSubmitBtn").click(function(){
				var googleCode = $('#googleQrcode').val();
				if(!googleCode){
					$.messager.alert('提示','请输入谷歌验证码', 'info');
				}else{
					$.ajax({type:'GET',url:'${ctx}/merchantInfo/googleAuth',data:{'googleCode':googleCode},
		        	    success:function(data,status,xhr){
		        	    	if(200 == xhr.status){
	        	    			$.messager.alert('提示',data,'info');	
	        	    			window.location.reload();
	        	    		} else
	        	    			$.messager.alert('提示',data,'info');	
		        	    },error:function(res){
		        	  	    $.messager.alert('提示',eval(res.responseText),'info');
		        	    },
		        	    dataType:'json'
		        	});
				}
			});
			</c:if>
			$("#paySubmitBtn").click(function(){
				var googleCode = $('#googleQrcode1').val();
				var pswd = $("#password").val();
				var rePswd = $("#surePassword").val();
				if(!googleCode){
					$.messager.alert('提示','请输入谷歌验证码', 'info');
				}else{
					$.ajax({type:'GET',url:'${ctx}/merchantInfo/setPayPassWord',data:{'pswd':pswd,'rePswd':rePswd,'googleCode':googleCode},
		        	    success:function(data,status,xhr){
		        	    	if(200 == xhr.status){
		        	    		$.messager.alert('提示',data,'info');	
	        	    		}else
	        	    		$.messager.alert('提示',data,'info');	
		        	    },error:function(res){
		        	  	    $.messager.alert('提示',eval(res.responseText),'info');
		        	    },
		        	    dataType:'json'
		        	});
				}
			});
			
			$("#dfSubmitBtn").click(function(){
				var pswd = $("#password").val();
				var rePswd = $("#surePassword").val();
				var googleCode = $('#googleQrcode2').val();
				if(!pswd){
					$.messager.alert('提示','请输入密码', 'info');
				}else if(!rePswd){
					$.messager.alert('提示','请输入确认密码', 'info');
				}else if(pswd !== rePswd){
					$.messager.alert('提示','两次密码 输入不一致', 'info');
				}else{
					$.ajax({type:'GET',url:'${ctx}/merchantInfo/lookMchKey1',data:{'pswd':pswd,'rePswd':rePswd,'googleCode':googleCode},
		        	    success:function(data,status,xhr){
		        	    	if(200 == xhr.status){
		        	    		$.messager.alert('提示',data,'info');
	        	    		} else 
	        	    			$.messager.alert('提示',data,'info');	
		        	    },error:function(res){
		        	  	    $.messager.alert('提示',eval(res.responseText),'info');
		        	    },
		        	    dataType:'json'
		        	});
				}
			});
			
			$("#apiSubmitBtn").click(function(){
				var googleCode = $('#googleQrcode3').val();
				if(!googleCode){
					$.messager.alert('提示','请输入谷歌验证码', 'info');
				}else{
					$.ajax({type:'GET',url:'${ctx}/merchantInfo/lookMchKey',data:{'googleCode':googleCode},
		        	    success:function(data,status,xhr){
							if(200 == xhr.status){
								$("#secret").val(data);
	        	    		} else
	        	    			$.messager.alert('提示',data,'info');	
		        	    },error:function(res){
		        	  	    $.messager.alert('提示',eval(res.responseText),'info');
		        	    },
		        	    dataType:'json'
		        	});
				}
			});
		})
	</script>
</body>
</html>