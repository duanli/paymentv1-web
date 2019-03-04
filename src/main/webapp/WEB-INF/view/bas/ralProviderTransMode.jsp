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
			    <li><a href="${ctx}/ralProviderTransMode/toRalProviderTransModePage">支付通道</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>交易方式:
				<input id="transModeId_s" name="transModeId" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'transModeId',textField:'transModeName',url:'${ctx}/transMode/getTransModeList',editable:false"></input>
				</li>
				<li>通道名称:<input name="productName" type="text" maxlength="30" id="productName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>启用状态:
				 <select id="state_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">停用</option>
						<option value="1">启用</option>
						<option value="2">暂停</option>
			 	 </select>
				</li>
				<li>限流状态:
				 <select id="restrictState_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">停用</option>
						<option value="1">启用</option>
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
			 		<shiro:hasPermission name="ralProviderTransMode:add">
			 		     <li class="click" id="addRalProviderTransMode" onclick="javascript:addRalProviderTransModeDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="ralProviderTransMode:update">
					 	<li class="click" id="updateRalProviderTransMode" onclick="javascript:updateRalProviderTransModeDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="ralProviderTransMode:delete">
						<li class="click" id="deleteRalProviderTransMode"  onclick="javascript:deleteRalProviderTransMode();">
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
 		<div id="ralProviderTransModeDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:666px;height:480px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="ralProviderTransModeForm" method="post">
					<fieldset style="width:600px;height:360px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="productId" name="productId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>交易方式<b>*</b></td>
                					 <td>
			 							<input id="transModeId" name="transModeId" type="text" class="easyui-combobox" data-options="valueField:'transModeId',textField:'transModeName',url:'${ctx}/transMode/getTransModeList',editable:false"></input>
                					 </td>
                					 <td>流水号前缀<b>*</b></td><td><input id="transRecordPrefix" name="transRecordPrefix" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易流水号开头不能为空!'"></input></td>
									</tr>
									<tr>
									 <td>通道名称<b>*</b></td><td><input id="productName" name="productName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'产品名不能为空!'"></input></td>
                					 <td>描述<b></b></td><td><input id="desc" name="desc" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'描述不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>方法名<b></b></td><td><input id="methodName" name="methodName" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'方法名不能为空!'"></input></td>
                					 <td>参数类型<b></b></td><td><input id="paramClass" name="paramClass" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'参数类型不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>接口名<b>*</b></td><td><input id="serviceName" name="serviceName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'接口名不能为空!'"></input></td>
                					 <td>扩展json<b></b></td><td><input id="submitParamJson" name="submitParamJson" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'服务商提交参数扩展json不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>费率(万分之)<b>*</b></td><td><input id="feeRate" name="feeRate" type="text" class="easyui-numberbox" data-options="min:30,precision:0,required:true"></input></td>
                					 <td>启用状态<b>*</b></td>
									 <td>
									    <select id="state" class="easyui-combobox" name="state" panelHeight="80" style="width:175px;" data-options="editable:false">
							 	 		<option value="0">停用</option>
										<option value="1">启用</option>
										<option value="2">暂停</option>
									 </select>
									 </td>									
									</tr>
									<tr>
									 <td>单笔最低额度<b>*</b></td><td><input id="minAmt" name="sminAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
                					 <td>单笔最高额度<b>*</b></td><td><input id="maxAmt" name="smaxAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>									
                					</tr>
                					<!-- <tr>
							 		 <td>有效起始时间<b>*</b></td><td><input id="beginTime" name="beginTime" type="text" class="easyui-timespinner" data-options="min:'00:00:00',showSeconds:true"></input></td>
							 		 <td>有效截止时间<b>*</b></td><td><input id="endTime" name="endTime" type="text" class="easyui-timespinner" data-options="min:'23:59:59',showSeconds:true"></input></td>
									</tr> -->
									<tr>
									 <td>每日限额<b>*</b></td><td><input id="totleAmtLimit" name="stotleAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
									 <td>限流状态<b>*</b></td>
                					 <td>
                					 <select id="restrictState" class="easyui-combobox" name="restrictState" panelHeight="80" style="width:175px;" data-options="editable:false">
							 	 		<option value="0">停用</option>
										<option value="1">启用</option>
									 </select>
									 </td>
                					</tr>
                					<tr>
                					 <td>IP白名单<b>*</b></td><td><input id="validIP" name="validIP" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'IP白名单不能为空!'"></input></td>
									 <td>结算方式<b>*</b></td>
                					 <td>
                					 <select id="settleType" class="easyui-combobox" name="settleType" panelHeight="80" style="width:175px;" data-options="editable:false">
							 	 		<option value="0">D0</option>
										<option value="1">D1</option>
										<option value="2">T0</option>
										<option value="3">T1</option>
									 </select>
                					 </td>
									 </tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#ralProviderTransModeDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/ralProviderTransMode/getRalProviderTransModePage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				            /*  {title:'服务商交易方式Id', field:'productId',width:50,align:'center'}, */
				             {title:'交易方式', field:'transModeName',width:40,align:'center'},
				             {title:'通道名称', field:'productName',width:40,align:'center'},
				            /*  {title:'交易流水号开头', field:'transRecordPrefix',width:50,align:'center'}, */
				            /*  {title:'接口名', field:'serviceName',width:50,align:'center'}, */
				           	 {title:'通道描述', field:'desc',width:50,align:'center'}, 
				            /*  {title:'服务商提交参数扩展json', field:'submitParamJson',width:50,align:'center'}, */
				             {title:'费率(万分之)', field:'feeRate',width:20,align:'center'},
				             {title:'状态', field:'state',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             {title:'每日限额', field:'totleAmtLimit',width:30,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 		 
				             },
				             {title:'单笔最低额', field:'minAmt',width:30,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 		 
				             },
				             {title:'单笔最高额', field:'maxAmt',width:30,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 		 
				             },
				             {title:'限流状态', field:'restrictState',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             {title:'结算方式', field:'settleType',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'D0':value=='1'?'D1':value=='2'?'T0':value=='3'?'T1':'未知';
				            	 }	
				             },
				             {title:'创建时间', field:'createTime',width:30,align:'center'},
				             {title:'修改日期', field:'updateTime',width:30,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/ralProviderTransMode/'+url;
					$('#ralProviderTransModeForm').ajaxSubmit(options);
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
					if($('#ralProviderTransModeForm').form('validate')){
						pro();
						$('#ralProviderTransModeDialog').dialog('close');
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
		        	$('#ralProviderTransModeDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addRalProviderTransModeDialog(){
				$('#ralProviderTransModeForm').form('clear');
				$('#ralProviderTransModeDialog').dialog('open');
				url = "addRalProviderTransMode";
			}
			// response,status,xhr
		    function updateRalProviderTransModeDialog(){
		    	url = "updateRalProviderTransMode";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].productId;
	    		 	$.ajax({type:'GET',url:'${ctx}/ralProviderTransMode/getRalProviderTransModeById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#ralProviderTransModeForm').form('clear');
		    				  		$('#productId').val(data.productId);
		    				  		$('#parentId').val(data.parentId);
		    				  		$('#proType').val(data.proType);
		    				  		$('#providerName').val(data.providerName);
		    				  		$('#productName').val(data.productName);
		    				  		$('#transModeId').combobox('select',data.transModeId);
		    				  		$('#transRecordPrefix').val(data.transRecordPrefix);
		    				  		$('#serviceName').val(data.serviceName);
		    				  		$('#methodName').val(data.methodName);
		    				  		$('#paramClass').val(data.paramClass);
		    				  		$('#desc').val(data.desc);
		    				  		$('#submitParamJson').val(data.submitParamJson);
		    				  		$('#feeRate').numberbox('setValue', data.feeRate);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#totleAmtLimit').numberbox('setValue', parseFloat(data.totleAmtLimit/100).toFixed(2));
		    				  		$('#minAmt').numberbox('setValue', parseFloat(data.minAmt/100).toFixed(2));
		    				  		$('#maxAmt').numberbox('setValue', parseFloat(data.maxAmt/100).toFixed(2));
		    				  		$('#restrictState').combobox('select',data.restrictState);
		    				  		$('#beginTime').val(data.beginTime);
		    				  		$('#endTime').val(data.endTime);
		    				  		$('#validIP').val(data.validIP);
		    				  		$('#isDel').val(data.isDel);
		    				  		$('#settleType').val(data.settleType);
				    			$('#ralProviderTransModeDialog').dialog('open');
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
		    function deleteRalProviderTransMode(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].productId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/ralProviderTransMode/deleteRalProviderTransMode',data:{'param':arr.toString()},
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
		    	var productId = $("#productId_s").val();
		    	var transModeId = $("#transModeId_s").val();
		    	var productName = $("#productName_s").val();
		    	var desc = $("#desc_s").val();
		    	var state = $("#state_s").val();
		    	var restrictState = $("#restrictState_s").val();
		    $("#tt").datagrid('load',{
		    	   productId:productId,
		    	   transModeId:transModeId,
		    	   productName:productName,
		    	   state:state,
		    	   restrictState:restrictState,
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
		    
	        function formatterTime(date){
	            var hour = date.getHours();
	            var minute = date.getMinutes();
	            var second = data.getSeconds();
	            hour = hour < 10 ? '0' + hour : hour;
	            minute = minute < 10 ? '0' + minute : minute;
	            second = second < 10 ? '0' + second : second;
	            /* return year + "-" + month + "-" + day + "    " + hour; */
	            return hour + ":" + minute + ":" + second;
	        }
		    //********************************************** 华丽分割线 ***************************************//
		</script>
	</body>
</html>