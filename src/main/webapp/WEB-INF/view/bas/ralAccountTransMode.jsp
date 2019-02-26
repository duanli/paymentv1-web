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
			    <li><a href="${ctx}/ralAccountTransMode/toRalAccountTransModePage">RalAccountTransMode</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
			 	<li>支付通道:
			 	<input id="providerNo_s" name="providerNo" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'providerId',textField:'providerAlias',url:'${ctx}/provider/getProviderList',editable:false"></input>
			 	</li>
			 	<li>交易方式:
				<input id="transModeId_s" name="transModeId" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'transModeId',textField:'transModeName',url:'${ctx}/transMode/getTransModeList',editable:false"></input>
				</li>
				<li>商户名称:<input name="mchId" type="text" maxlength="30" id="mchId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
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
				<li>限流状态:
				 <select id="restrictState_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">停用</option>
						<option value="1">启用</option>
			 	 </select>
				</li>
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
			 		<shiro:hasPermission name="ralAccountTransMode:add">
			 		     <li class="click" id="addRalAccountTransMode" onclick="javascript:addRalAccountTransModeDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="ralAccountTransMode:update">
					 	<li class="click" id="updateRalAccountTransMode" onclick="javascript:updateRalAccountTransModeDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="ralAccountTransMode:delete">
						<li class="click" id="deleteRalAccountTransMode"  onclick="javascript:deleteRalAccountTransMode();">
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
 		<div id="ralAccountTransModeDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:630px;height:400px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="ralAccountTransModeForm" method="post">
					<fieldset style="width:580px;height:280px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="ralAccProductId" name="ralAccProductId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>选择商户<b>*</b></td>
                					 <td>
                					 <input id="mchId" name="mchId" type="text" class="easyui-combobox" data-options="valueField:'mchId',textField:'mchName',url:'${ctx}/merchantInfo/getMerchantList',editable:false,required:false,missingMessage:'不能为空!'"></input>
                					 </td>
                					 <td>支付账户<b>*</b></td>
                					 <td>
                					 <input id="providerAccId" name="providerAccId" type="text" class="easyui-combotree" data-options="url:'${ctx}/provider/getProviderAccTree',method:'get',required:true"></input>
                					 </td>
									</tr>
									<tr>
                					 <td>交易产品<b>*</b></td>
                					 <td>
                					 <input id="productId" name="productId" type="text" class="easyui-combotree" data-options="url:'${ctx}/provider/getProviderTransModeTree',method:'get',required:true"></input>
                					 </td>
                					 <td>费率(万分之)<b>*</b></td><td><input id="feeRate" name="feeRate" type="text" class="easyui-numberbox" data-options="min:30,precision:0,required:true"></input></td>
									</tr>
									<tr>
                					 <td>每日限额<b>*</b></td><td><input id="totleAmtLimit" name="stotleAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
                					 <td>单笔最低额<b>*</b></td><td><input id="minAmt" name="sminAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
									</tr>
									<tr>
                					 <td>单笔最高额<b>*</b></td><td><input id="maxAmt" name="smaxAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
                					 <td>流量占比<b>*</b></td><td><input id="percentage" name="percentage" type="text" class="easyui-numberbox" data-options="min:0,precision:0,required:true"></input></td>
									</tr>
									<tr>
                					 <td>启用状态<b>*</b></td>
                					 <td>
									  <select id="state" class="easyui-combobox" name="state" panelHeight="80" style="width:175px;" data-options="editable:false">
									    <option value="0">停用</option>
										<option value="1">启用</option>
										<option value="2">暂停</option>
									  </select>
									 </td>
									  <!-- <tr>
                					 <td>是否删除<b>*</b></td><td><input id="isDel" name="isDel" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'是否删除不能为空!'"></input></td>
									</tr> -->
                					 <td>IP白名单<b>*</b></td><td><input id="validIP" name="validIP" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'IP白名单不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>限流状态<b>*</b></td>
                					 <td>
                					 <select id="restrictState" class="easyui-combobox" name="restrictState" panelHeight="80" style="width:175px;" data-options="editable:false">
							 	 		<option value="0">停用</option>
										<option value="1">启用</option>
									 </select>
                					 </td>
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
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#ralAccountTransModeDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/ralAccountTransMode/getRalAccountTransModePage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'商户名称', field:'mchId',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.merchantInfo&&row.merchantInfo.mchName){
				     					return "<font color='blue'>"+row.merchantInfo.mchName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'支付通道', field:'providerName',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.providerAccount&&row.providerAccount.provider&&row.providerAccount.provider.providerAlias){
				     					return "<font color='blue'>"+row.providerAccount.provider.providerAlias+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'通道账户', field:'providerAccName',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.providerAccount&&row.providerAccount.accName){
				     					return "<font color='blue'>"+row.providerAccount.accName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'交易产品', field:'productId',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.ralProviderTransMode&&row.ralProviderTransMode.productName){
				     					return "<font color='blue'>"+row.ralProviderTransMode.productName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
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
				             {title:'流量占比', field:'percentage',width:50,align:'center'},
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改时间', field:'updateTime',width:50,align:'center'},
				             {title:'状态 ', field:'state',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             {title:'IP白名单', field:'validIP',width:50,align:'center'},
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
				             {title:'总余额', field:'balance',width:50,align:'center'},
				             {title:'未入账余额', field:'balanceUnaccounted',width:50,align:'center'},
				             {title:'冻结余额', field:'balanceFreeze',width:50,align:'center'},
				             {title:'可用余额', field:'balanceValid',width:50,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/ralAccountTransMode/'+url;
					$('#ralAccountTransModeForm').ajaxSubmit(options);
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
					if($('#ralAccountTransModeForm').form('validate')){
						pro();
						$('#ralAccountTransModeDialog').dialog('close');
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
		        	$('#ralAccountTransModeDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addRalAccountTransModeDialog(){
				$('#ralAccountTransModeForm').form('clear');
				$('#ralAccountTransModeDialog').dialog('open');
				url = "addRalAccountTransMode";
			}
			// response,status,xhr
		    function updateRalAccountTransModeDialog(){
		    	url = "updateRalAccountTransMode";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].ralAccProductId;
	    		 	$.ajax({type:'GET',url:'${ctx}/ralAccountTransMode/getRalAccountTransModeById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#ralAccountTransModeForm').form('clear');
		    				  		$('#ralAccProductId').val(data.ralAccProductId);
		    				  		$('#mchId').combobox('select',data.mchId);
		    				  		$('#providerAccId').combotree('setValue',data.providerAccId);
		    				  		$('#productId').combotree('setValue',data.productId);
		    				  		$('#feeRate').numberbox('setValue', data.feeRate);
		    				  		$('#totleAmtLimit').numberbox('setValue', parseFloat(data.totleAmtLimit/100).toFixed(2));
		    				  		$('#minAmt').numberbox('setValue', parseFloat(data.minAmt/100).toFixed(2));
		    				  		$('#maxAmt').numberbox('setValue', parseFloat(data.maxAmt/100).toFixed(2));
		    				  		$('#percentage').numberbox('setValue', data.percentage);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#isDel').val(data.isDel);
		    				  		$('#validIP').val(data.validIP);
		    				  		$('#restrictState').combobox('select',data.restrictState);
		    				  		$('#settleType').combobox('select',data.settleType);
		    				  		$('#balance').val(data.balance);
				    			$('#ralAccountTransModeDialog').dialog('open');
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
		    function deleteRalAccountTransMode(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].ralAccProductId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/ralAccountTransMode/deleteRalAccountTransMode',data:{'param':arr.toString()},
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
		    	var ralAccProductId = $("#ralAccProductId_s").val();
		    	var mchId = $("#mchId_s").val();
		    	var providerAccId = $("#providerAccId_s").val();
		    	var productId = $("#productId_s").val();
		    	var feeRate = $("#feeRate_s").val();
		    	var totleAmtLimit = $("#totleAmtLimit_s").val();
		    	var minAmt = $("#minAmt_s").val();
		    	var maxAmt = $("#maxAmt_s").val();
		    	var percentage = $("#percentage_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    	var state = $("#state_s").val();
		    	var isDel = $("#isDel_s").val();
		    	var validIP = $("#validIP_s").val();
		    	var restrictState = $("#restrictState_s").val();
		    	var settleType = $("#settleType_s").val();
		    	var balance = $("#balance_s").val();
		    $("#tt").datagrid('load',{
		    	   ralAccProductId:ralAccProductId,
		    	   mchId:mchId,
		    	   providerAccId:providerAccId,
		    	   productId:productId,
		    	   feeRate:feeRate,
		    	   totleAmtLimit:totleAmtLimit,
		    	   minAmt:minAmt,
		    	   maxAmt:maxAmt,
		    	   percentage:percentage,
		    	   createTime:createTime,
		    	   updateTime:updateTime,
		    	   state:state,
		    	   isDel:isDel,
		    	   validIP:validIP,
		    	   restrictState:restrictState,
		    	   settleType:settleType,
		    	   balance:balance,
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