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
		li{background:url(${ctx}/images/toolbg.gif) repeat-x; line-height:33px; height:33px; float:left; padding-right:10px; margin-right:5px;border-radius: 3px; behavior:url(${ctx}/js/pie.htc); cursor:pointer;}
	  	a{text-decoration: none;color:black;}
	  	</style>
	</head>
	<body>
		<div class="place">
			<span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">首页</a></li>
			    <li><a href="${ctx}/transRecordDpay/toTransRecordDpayPage">代付流水</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>系统流水号:<input name="outTradeNo" type="text" maxlength="30" id="outTradeNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>业务订单号:<input name="bizOrderNo" type="text" maxlength="30" id="bizOrderNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>三方流水号:<input name="spTransactionId" type="text" maxlength="30" id="spTransactionId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	<li>状态:
				 <select id="state_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0000">已受理</option>
						<option value="0001">成功</option>
						<option value="0002">失败</option>
						<option value="0003">待支付</option>
						<option value="0004">关闭</option>
			 	 </select>			
				</li>
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
    			<li class="click" onclick="javascript:window.open('${ctx}/transRecordDpay/totxPage','rightFrame'); " style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 我要提现
    				 </a>
    			</li>
			 		<%-- <shiro:hasPermission name="transRecordDpay:add">
			 		     <li class="click" id="addTransRecordDpay" onclick="javascript:addTransRecordDpayDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="transRecordDpay:update">
					 	<li class="click" id="updateTransRecordDpay" onclick="javascript:updateTransRecordDpayDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="transRecordDpay:delete">
						<li class="click" id="deleteTransRecordDpay"  onclick="javascript:deleteTransRecordDpay();">
					 	 	<span><a href="#"><img src="${ctx}/images/t03.png"/></a></span>删除
				 	 	</li>
					</shiro:hasPermission> --%>
			    </ul>
			</div>
		</div>
		<!-- grid -->
		<div>
			<table id="tt" style="width:1024px;height:420px"></table>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/transRecordDpay/getTransRecordDpayPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'商户名称', field:'merId',width:50,align:'center'},
				             {title:'产品名称', field:'productName',width:50,align:'center'},
				             {title:'银行编码', field:'bankCode',width:50,align:'center'},
				             {title:'所属银行', field:'bankName',width:50,align:'center'},
				             {title:'账户类型', field:'accountType',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'对公':value=='1'?'对私':'未知';
				            	 }	
				             },
				             {title:'卡类型',field:'bankCardType',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'借记卡':value=='1'?'贷记卡':'未知';
				            	 }	
				             },
				             /* {title:'银行卡ID', field:'bankId',width:50,align:'center'}, */
				             {title:'银行卡号', field:'bankCardNo',width:50,align:'center'},
				             {title:'开户名', field:'realName',width:50,align:'center'},
				             {title:'交易金额', field:'amount',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 
				             },
				             {title:'交易流水号', field:'outTradeNo',width:50,align:'center'},
				             {title:'状态', field:'state',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0000'?'已受理':value=='0001'?'成功':value=='0002'?'失败':value=='0003'?'等待':value=='0004'?'关闭':'未知';
				            	 }	
				             },
				             {title:'状态描述', field:'stateMsg',width:50,align:'center'},
				             {title:'三方流水号', field:'outTransactionId',width:50,align:'center'},
				             {title:'业务订单号', field:'bizOrderNo',width:50,align:'center'},
				             {title:'交易流水号', field:'spTransactionId',width:50,align:'center'},
				             {title:'交易时间', field:'spTransTime',width:50,align:'center'},
				             {title:'手续费', field:'fee',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 
				             },
				             {title:'清算状态', field:'noticetate',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'未通知':value=='1'?'已通知':value=='9'?'通知失败':'未知';
				            	 }	
				             },
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改日期', field:'updateTime',width:50,align:'center'}
						]]
				 });
			}
		     //查询方法
		    function search(){
		    	var transId = $("#transId_s").val();
		    	var transBrandId = $("#transBrandId_s").val();
		    	var transBrandName = $("#transBrandName_s").val();
		    	var transModeId = $("#transModeId_s").val();
		    	var transModeName = $("#transModeName_s").val();
		    	var merParentId = $("#merParentId_s").val();
		    	var merId = $("#merId_s").val();
		    	var providerId = $("#providerId_s").val();
		    	var providerName = $("#providerName_s").val();
		    	var providerAccId = $("#providerAccId_s").val();
		    	var providerMchNo = $("#providerMchNo_s").val();
		    	var productId = $("#productId_s").val();
		    	var productName = $("#productName_s").val();
		    	var bankCode = $("#bankCode_s").val();
		    	var bankName = $("#bankName_s").val();
		    	var accountType = $("#accountType_s").val();
		    	var bankCardType = $("#bankCardType_s").val();
		    	var bankId = $("#bankId_s").val();
		    	var bankCardNo = $("#bankCardNo_s").val();
		    	var realName = $("#realName_s").val();
		    	var amount = $("#amount_s").val();
		    	var outTradeNo = $("#outTradeNo_s").val();
		    	var state = $("#state_s").val();
		    	var stateMsg = $("#stateMsg_s").val();
		    	var stateRemark = $("#stateRemark_s").val();
		    	var type = $("#type_s").val();
		    	var srcOutTradeNo = $("#srcOutTradeNo_s").val();
		    	var outTransactionId = $("#outTransactionId_s").val();
		    	var terminalIP = $("#terminalIP_s").val();
		    	var goodsName = $("#goodsName_s").val();
		    	var goodsDesc = $("#goodsDesc_s").val();
		    	var bizOrderNo = $("#bizOrderNo_s").val();
		    	var notifyUrl = $("#notifyUrl_s").val();
		    	var resultUrl = $("#resultUrl_s").val();
		    	var payWayUserId = $("#payWayUserId_s").val();
		    	var spTransactionId = $("#spTransactionId_s").val();
		    	var spTransTime = $("#spTransTime_s").val();
		    	var spTransDate = $("#spTransDate_s").val();
		    	var spRespCode = $("#spRespCode_s").val();
		    	var spRespMsg = $("#spRespMsg_s").val();
		    	var fee = $("#fee_s").val();
		    	var noticetate = $("#noticetate_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    $("#tt").datagrid('load',{
		    	   transId:transId,
		    	   transBrandId:transBrandId,
		    	   transBrandName:transBrandName,
		    	   transModeId:transModeId,
		    	   transModeName:transModeName,
		    	   merParentId:merParentId,
		    	   merId:merId,
		    	   providerId:providerId,
		    	   providerName:providerName,
		    	   providerAccId:providerAccId,
		    	   providerMchNo:providerMchNo,
		    	   productId:productId,
		    	   productName:productName,
		    	   bankCode:bankCode,
		    	   bankName:bankName,
		    	   accountType:accountType,
		    	   bankCardType:bankCardType,
		    	   bankId:bankId,
		    	   bankCardNo:bankCardNo,
		    	   realName:realName,
		    	   amount:amount,
		    	   outTradeNo:outTradeNo,
		    	   state:state,
		    	   stateMsg:stateMsg,
		    	   stateRemark:stateRemark,
		    	   type:type,
		    	   srcOutTradeNo:srcOutTradeNo,
		    	   outTransactionId:outTransactionId,
		    	   terminalIP:terminalIP,
		    	   goodsName:goodsName,
		    	   goodsDesc:goodsDesc,
		    	   bizOrderNo:bizOrderNo,
		    	   notifyUrl:notifyUrl,
		    	   resultUrl:resultUrl,
		    	   payWayUserId:payWayUserId,
		    	   spTransactionId:spTransactionId,
		    	   spTransTime:spTransTime,
		    	   spTransDate:spTransDate,
		    	   spRespCode:spRespCode,
		    	   spRespMsg:spRespMsg,
		    	   fee:fee,
		    	   noticetate:noticetate,
		    	})
		    }
		    
		    //修改日历框的显示格式
	        function formatter(date){
	            var year = date.getFullYear();
	            var month = date.getMonth() + 1;
	            var day = date.getDate();
	            var hour = date.getHours();
	            month = month < 10 ? '0' + month : month;
	            day = day < 10 ? '0' + day : day;
	            hour = hour < 10 ? '0' + hour : hour;
	            /* return year + "-" + month + "-" + day + "    " + hour; */
	            return year + "-" + month + "-" + day;
	        }
		    //********************************************** 华丽分割线 ***************************************//
		</script>
	</body>
</html>