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
			    <li><a href="${ctx}/ralAccountTransMode/toProAccInfoPage">通道账户</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
			 	<li>交易方式:
				<input id="transModeId_s" name="transModeId" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'transModeId',textField:'transModeName',url:'${ctx}/transMode/getTransModeList',editable:false"></input>
				</li>
				<!-- <li>商户名称:<input name="mchId" type="text" maxlength="30" id="mchId_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<!-- <li>账户名称:<input name="providerAccId" type="text" maxlength="30" id="providerAccId_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<%-- <li>交易产品:
				<input id="productId_s" name="productId" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'productId',textField:'productName',url:'${ctx}/providerTransMode/getProviderTransModeList',editable:false">
				</li> --%>
				<li>启用状态 :
				 <select id="state_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">停用</option>
						<option value="1">启用</option>
						<option value="2">暂停</option>
			 	 </select>				
			 	</li>
				<!-- <li>限流状态:
				 <select id="restrictState_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">停用</option>
						<option value="1">启用</option>
			 	 </select>
				</li> -->
				<li>结算方式:
				 <select id="settleType_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">D0</option>
						<option value="1">D1</option>
						<option value="2">T0</option>
						<option value="3">T1</option>
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
						url:'${ctx}/ralAccountTransMode/getProAccInfoList',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'商户名称', field:'merName',width:50,align:'center'},
				            /*  {title:'支付通道', field:'providerAccId',width:50,align:'center'},
				             {title:'通道账户', field:'providerAccId',width:50,align:'center'},*/
				             {title:'产品名称', field:'productName',width:50,align:'center'}, 
				             {title:'费率(万分之)', field:'feeRate',width:50,align:'center'},
				             {title:'每日限额', field:'totleAmtLimit',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 
				             },
				             {title:'单笔最低额', field:'minAmt',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 
				             },
				             {title:'单笔最高额', field:'maxAmt',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 
				             },
				             /* {title:'流量占比', field:'percentage',width:50,align:'center'}, */
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改时间', field:'updateTime',width:50,align:'center'},
				             {title:'状态 ', field:'state',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             {title:'IP白名单', field:'validIP',width:50,align:'center'},
				            /*  {title:'限流状态', field:'restrictState',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             }, */
				             {title:'结算方式', field:'settleType',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'D0':value=='1'?'D1':value=='2'?'T0':value=='3'?'T1':'未知';
				            	 }	
				             },
				             {title:'总余额', field:'balance',width:50,align:'center'},
				             {title:'未入账余额', field:'balanceUnaccounted',width:50,align:'center'},
				             {title:'冻结余额', field:'balanceFreeze',width:50,align:'center'},
				             {title:'可用余额', field:'balanceValid',width:50,align:'center'}
						]]
				 });
			}
		     //查询方法
		    function search(){
		    	var transModeId = $("#transModeId_s").val();
		    	var state = $("#state_s").val();
		    	var settleType = $("#settleType_s").val();
		    $("#tt").datagrid('load',{
		    	   transModeId:transModeId,
		    	   state:state,
		    	   settleType:settleType,
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