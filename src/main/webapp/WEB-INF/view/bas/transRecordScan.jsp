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
			    <li><a href="${ctx}/transRecordScan/toTransRecordScanPage">订单流水</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>交易方式:
				<input id="transModeId_s" name="transModeId" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'transModeId',textField:'transModeName',url:'${ctx}/transMode/getTransModeList',editable:false"></input>
				</li>				
				<!-- <li>支付通道:<input name="providerId" type="text" maxlength="30" id="providerId_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
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
				<!-- <li>订单类型: 
				 <select id="type_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">退款</option>
						<option value="1">支付 </option>
			 	 </select>		
				</li> -->
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="transRecordScan:add">
			 		     <li class="click" id="addTransRecordScan" onclick="javascript:addTransRecordScanDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="transRecordScan:update">
					 	<li class="click" id="updateTransRecordScan" onclick="javascript:updateTransRecordScanDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="transRecordScan:delete">
						<li class="click" id="deleteTransRecordScan"  onclick="javascript:deleteTransRecordScan();">
					 	 	<span><a href="#"><img src="${ctx}/images/t03.png"/></a></span>删除
				 	 	</li>
					</shiro:hasPermission>
			    </ul>
			</div>
		</div>
		<!-- grid -->
		<div>
			<table id="tt" style="width:1024px;height:420px"></table>
		</div>
		<!-- dialog -->
 		<div id="transRecordScanDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:830px;height:560px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="transRecordScanForm" method="post">
					<fieldset style="width:800px;height:530px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="id" name="id" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>交易品牌编号<b>*</b></td><td><input id="transBrandId" name="transBrandId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易品牌编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易品牌名称<b>*</b></td><td><input id="transBrandName" name="transBrandName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易品牌名称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易方式id<b>*</b></td><td><input id="transModeId" name="transModeId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易方式id不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易方式名称<b>*</b></td><td><input id="transModeName" name="transModeName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易方式名称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>父商户编号<b>*</b></td><td><input id="merParentId" name="merParentId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'父商户编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>商户编号<b>*</b></td><td><input id="merId" name="merId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>服务商编号<b>*</b></td><td><input id="providerId" name="providerId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户产品关联ID<b>*</b></td><td><input id="providerAccId" name="providerAccId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'账户产品关联ID不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>服务商账号<b>*</b></td><td><input id="providerMchNo" name="providerMchNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商账号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>服务商名称<b>*</b></td><td><input id="providerName" name="providerName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商名称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易产品编号<b>*</b></td><td><input id="productId" name="productId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易产品编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易产品名称<b>*</b></td><td><input id="productName" name="productName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易产品名称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易流水号<b>*</b></td><td><input id="outTradeNo" name="outTradeNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易流水号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易金额-单位分<b>*</b></td><td><input id="amount" name="amount" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易金额-单位分不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>实到金额<b>*</b></td><td><input id="actulAmt" name="actulAmt" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'实到金额不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭  -1-未知状态<b>*</b></td><td><input id="state" name="state" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'状态0000-已受理(状态不明) 0001-成功 0002-失败 0003-等待 0004-关闭  -1-未知状态不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>支付状态描述<b>*</b></td><td><input id="stateMsg" name="stateMsg" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'支付状态描述不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>支付状态备注<b>*</b></td><td><input id="stateRemark" name="stateRemark" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'支付状态备注不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>订单类型: 0-预支付 1-支付 2-转账 3-退款<b>*</b></td><td><input id="type" name="type" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'订单类型: 0-预支付 1-支付 2-转账 3-退款不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>原交易流水号<b>*</b></td><td><input id="srcOutTradeNo" name="srcOutTradeNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'原交易流水号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>三方交易流水号<b>*</b></td><td><input id="outTransactionId" name="outTransactionId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'三方交易流水号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>请求ip地址<b>*</b></td><td><input id="terminalIP" name="terminalIP" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'请求ip地址不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>商品名称<b>*</b></td><td><input id="goodsName" name="goodsName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商品名称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>商品描述<b>*</b></td><td><input id="goodsDesc" name="goodsDesc" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商品描述不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>业务系统订单号<b>*</b></td><td><input id="bizOrderNo" name="bizOrderNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'业务系统订单号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>结果通知Url<b>*</b></td><td><input id="notifyUrl" name="notifyUrl" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'结果通知Url不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>交易结果返回页面<b>*</b></td><td><input id="resultUrl" name="resultUrl" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易结果返回页面不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>支付通道用户标识<b>*</b></td><td><input id="payWayUserId" name="payWayUserId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'支付通道用户标识不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>服务商交易流水号<b>*</b></td><td><input id="spTransactionId" name="spTransactionId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商交易流水号不能为空!'"></input></td>
									</tr>
							 		 <td>服务商交易时间<b>*</b></td><td><input id="spTransTime" name="spTransTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
									<tr>
                					 <td>服务商交易请求日期<b>*</b></td><td><input id="spTransDate" name="spTransDate" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商交易请求日期不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>服务商返回码<b>*</b></td><td><input id="spRespCode" name="spRespCode" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商返回码不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>服务商返回码描述<b>*</b></td><td><input id="spRespMsg" name="spRespMsg" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商返回码描述不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>成本手续费<b>*</b></td><td><input id="providerFee" name="providerFee" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'成本手续费不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>成本手续费率<b>*</b></td><td><input id="providerFeeRate" name="providerFeeRate" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'成本手续费率不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>商户手续费<b>*</b></td><td><input id="merFee" name="merFee" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户手续费不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>商户手续费率<b>*</b></td><td><input id="merfeeRate" name="merfeeRate" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户手续费率不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>通知状态0-未通知 1-已通知 9-通知势必<b>*</b></td><td><input id="noticeState" name="noticeState" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'通知状态0-未通知 1-已通知 9-通知势必不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>分账状态0-未分1-已分2-异常<b>*</b></td><td><input id="settleState" name="settleState" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'分账状态0-未分1-已分2-异常不能为空!'"></input></td>
									</tr>
							 		 <td>创建时间<b>*</b></td><td><input id="createTime" name="createTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>修改日期<b>*</b></td><td><input id="updateTime" name="updateTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#transRecordScanDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/transRecordScan/getTransRecordScanPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				            /*  {title:'内部交易Id', field:'id',width:50,align:'center'},
				             {title:'交易品牌编号', field:'transBrandId',width:50,align:'center'}, */
				            /*  {title:'交易品牌', field:'transBrandName',width:50,align:'center'}, */
				             {title:'交易方式', field:'transModeName',width:50,align:'center'},
				             {title:'支付通道', field:'providerName',width:50,align:'center'},
				             {title:'产品名称', field:'productName',width:50,align:'center'},
				             {title:'交易流水号', field:'outTradeNo',width:50,align:'center'},
				             {title:'交易金额', field:'amount',width:50,align:'center'},
				             {title:'实到金额', field:'actulAmt',width:50,align:'center'},
				             {title:'状态', field:'state',width:50,align:'center'},
				             /* {title:'支付状态描述', field:'stateMsg',width:50,align:'center'},
				             {title:'支付状态备注', field:'stateRemark',width:50,align:'center'}, */
				             {title:'订单类型:', field:'type',width:50,align:'center'},
				             {title:'商品描述', field:'goodsDesc',width:50,align:'center'},
				             {title:'业务订单号', field:'bizOrderNo',width:50,align:'center'},
				             {title:'通道流水号', field:'spTransactionId',width:50,align:'center'},
				            /*  {title:'成本手续费', field:'providerFee',width:50,align:'center'},
				             {title:'成本手续费率', field:'providerFeeRate',width:50,align:'center'},
				             {title:'商户手续费', field:'merFee',width:50,align:'center'},
				             {title:'商户手续费率', field:'merfeeRate',width:50,align:'center'}, */
				             {title:'通知状态', field:'noticeState',width:50,align:'center'},
				             {title:'分账状态', field:'settleState',width:50,align:'center'},
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改日期', field:'updateTime',width:50,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/transRecordScan/'+url;
					$('#transRecordScanForm').ajaxSubmit(options);
			        return false;
				});
				// 提交参数对象
			  	var options = {
		            beforeSubmit: before,
		            success: showResponse,
		            error:showError,
		            type:'post'
		        };
				// 表单检查
			  	function before(){
					if($('#transRecordScanForm').form('validate')){
						pro();
						$('#transRecordScanDialog').dialog('close');
						return true;
					}else
						return false;
			  	};
		        function showResponse(responseText, statusText, xhr, $form) {
		        	hide();
		        	$.messager.alert('提示',eval(responseText), 'info');
		        	$('#tt').datagrid('clearSelections');
		        	$('#tt').datagrid('reload');
		        };
		        function showError(p1, $form) {
		        	hide();
		        	$('#transRecordScanDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addTransRecordScanDialog(){
				$('#transRecordScanForm').form('clear');
				$('#transRecordScanDialog').dialog('open');
				url = "addTransRecordScan";
			}
			// response,status,xhr
		    function updateTransRecordScanDialog(){
		    	url = "updateTransRecordScan";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].id;
	    		 	$.ajax({type:'GET',url:'${ctx}/transRecordScan/getTransRecordScanById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#transRecordScanForm').form('clear');
		    				  		$('#id').val(data.id);
		    				  		$('#transBrandId').val(data.transBrandId);
		    				  		$('#transBrandName').val(data.transBrandName);
		    				  		$('#transModeId').val(data.transModeId);
		    				  		$('#transModeName').val(data.transModeName);
		    				  		$('#merParentId').val(data.merParentId);
		    				  		$('#merId').val(data.merId);
		    				  		$('#providerId').val(data.providerId);
		    				  		$('#providerAccId').val(data.providerAccId);
		    				  		$('#providerMchNo').val(data.providerMchNo);
		    				  		$('#providerName').val(data.providerName);
		    				  		$('#productId').val(data.productId);
		    				  		$('#productName').val(data.productName);
		    				  		$('#outTradeNo').val(data.outTradeNo);
		    				  		$('#amount').val(data.amount);
		    				  		$('#actulAmt').val(data.actulAmt);
		    				  		$('#state').val(data.state);
		    				  		$('#stateMsg').val(data.stateMsg);
		    				  		$('#stateRemark').val(data.stateRemark);
		    				  		$('#type').val(data.type);
		    				  		$('#srcOutTradeNo').val(data.srcOutTradeNo);
		    				  		$('#outTransactionId').val(data.outTransactionId);
		    				  		$('#terminalIP').val(data.terminalIP);
		    				  		$('#goodsName').val(data.goodsName);
		    				  		$('#goodsDesc').val(data.goodsDesc);
		    				  		$('#bizOrderNo').val(data.bizOrderNo);
		    				  		$('#notifyUrl').val(data.notifyUrl);
		    				  		$('#resultUrl').val(data.resultUrl);
		    				  		$('#payWayUserId').val(data.payWayUserId);
		    				  		$('#spTransactionId').val(data.spTransactionId);
		    				  		$('#spTransTime').val(data.spTransTime);
		    				  		$('#spTransDate').val(data.spTransDate);
		    				  		$('#spRespCode').val(data.spRespCode);
		    				  		$('#spRespMsg').val(data.spRespMsg);
		    				  		$('#providerFee').val(data.providerFee);
		    				  		$('#providerFeeRate').val(data.providerFeeRate);
		    				  		$('#merFee').val(data.merFee);
		    				  		$('#merfeeRate').val(data.merfeeRate);
		    				  		$('#noticeState').val(data.noticeState);
		    				  		$('#settleState').val(data.settleState);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
				    			$('#transRecordScanDialog').dialog('open');
			    			}else
			    				$.messager.alert('提示',"暂无用户数据!",'info');
		        	    	hide();
		        	    },error:function(res){
		        	  	    $.messager.alert('提示',eval(res.responseText),'info');
		        	    },
		        	    dataType:'json'
		        	});
	    		}else{
	    			$.messager.alert('提示',"请选择一项进行修改!",'warning');
	    			return null;
	    		}
		    }
		    function deleteTransRecordScan(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].id;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/transRecordScan/deleteTransRecordScan',data:{'param':arr.toString()},
	    	        	    success:function(text,status,xhr){
	    	        	    	$.messager.alert('提示',eval(xhr.responseText),'info');
	    	        	    	$('#tt').datagrid('clearSelections');
	    	        	    	$('#tt').datagrid('reload');
	    	        	    	hide();
	    	        	    },error:function(res){
	    	        	    	hide();
	    	        	    	$.messager.alert('提示',eval(res.responseText),'warning');
	    	        	    },
	    	        	    dataType:'json'
	    	        	});
	        		}
	        	});
		    }
		     //查询方法
		    function search(){
		    	var id = $("#id_s").val();
		    	var transBrandId = $("#transBrandId_s").val();
		    	var transBrandName = $("#transBrandName_s").val();
		    	var transModeId = $("#transModeId_s").val();
		    	var transModeName = $("#transModeName_s").val();
		    	var merParentId = $("#merParentId_s").val();
		    	var merId = $("#merId_s").val();
		    	var providerId = $("#providerId_s").val();
		    	var providerAccId = $("#providerAccId_s").val();
		    	var providerMchNo = $("#providerMchNo_s").val();
		    	var providerName = $("#providerName_s").val();
		    	var productId = $("#productId_s").val();
		    	var productName = $("#productName_s").val();
		    	var outTradeNo = $("#outTradeNo_s").val();
		    	var amount = $("#amount_s").val();
		    	var actulAmt = $("#actulAmt_s").val();
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
		    	var providerFee = $("#providerFee_s").val();
		    	var providerFeeRate = $("#providerFeeRate_s").val();
		    	var merFee = $("#merFee_s").val();
		    	var merfeeRate = $("#merfeeRate_s").val();
		    	var noticeState = $("#noticeState_s").val();
		    	var settleState = $("#settleState_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    $("#tt").datagrid('load',{
		    	   id:id,
		    	   transBrandId:transBrandId,
		    	   transBrandName:transBrandName,
		    	   transModeId:transModeId,
		    	   transModeName:transModeName,
		    	   merParentId:merParentId,
		    	   merId:merId,
		    	   providerId:providerId,
		    	   providerAccId:providerAccId,
		    	   providerMchNo:providerMchNo,
		    	   providerName:providerName,
		    	   productId:productId,
		    	   productName:productName,
		    	   outTradeNo:outTradeNo,
		    	   amount:amount,
		    	   actulAmt:actulAmt,
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
		    	   providerFee:providerFee,
		    	   providerFeeRate:providerFeeRate,
		    	   merFee:merFee,
		    	   merfeeRate:merfeeRate,
		    	   noticeState:noticeState,
		    	   settleState:settleState,
		    	   createTime:createTime,
		    	   updateTime:updateTime,
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