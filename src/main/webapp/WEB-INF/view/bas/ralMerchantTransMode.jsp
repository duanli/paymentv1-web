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
			    <li><a href="${ctx}/ralMerchantTransMode/toRalMerchantTransModePage">通道配置</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>商户名称:
				  <input id="mchId_s" name="mchId" type="text" style="width: 100px;height: 26px;" class="easyui-combobox"  data-options="valueField:'mchId',textField:'mchName',url:'${ctx}/merchantInfo/getMerchantList',editable:false">
				</li>
				<li>交易方式:
					<input id="transModeId_s" name="transModeId" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'transModeId',textField:'transModeName',url:'${ctx}/transMode/getTransModeList',editable:false"></input>
				</li>
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
				</li>			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="ralMerchantTransMode:add">
			 		     <li class="click" id="addRalMerchantTransMode" onclick="javascript:addRalMerchantTransModeDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="ralMerchantTransMode:update">
					 	<li class="click" id="updateRalMerchantTransMode" onclick="javascript:updateRalMerchantTransModeDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="ralMerchantTransMode:delete">
						<li class="click" id="deleteRalMerchantTransMode"  onclick="javascript:deleteRalMerchantTransMode();">
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
 		<div id="ralMerchantTransModeDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:630px;height:360px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="ralMerchantTransModeForm" method="post">
					<fieldset style="width:560px;height:245px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="ralMerTransModeId" name="ralMerTransModeId" type="hidden"/></td>
								    </tr>
									<tr>
									 <td>选择商户<b>*</b></td>
                					 <td><input id="mchId" name="mchId" type="text" class="easyui-combobox" data-options="valueField:'mchId',textField:'mchName',url:'${ctx}/merchantInfo/getMerchantList',editable:false,required:false,missingMessage:'不能为空!'"></input>
                					 </td>									
									 <td>交易方式<b>*</b></td>
                					 <td>
			 							<input id="transModeId" name="transModeId" type="text" class="easyui-combobox" data-options="valueField:'transModeId',textField:'transModeName',url:'${ctx}/transMode/getTransModeList',editable:false"></input>
                					 </td>									
                					</tr>
									<tr>
                					 <td>费率(万分之)<b>*</b></td><td><input id="feeRate" name="feeRate" type="text" class="easyui-numberbox" data-options="min:30,precision:0,required:true"></input></td>
                					 <td>每日限额<b>*</b></td><td><input id="totleAmtLimit" name="stotleAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
									</tr>
									<tr>
                					 <td>单笔最低额<b>*</b></td><td><input id="minAmt" name="sminAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td><td>单笔最高额<b>*</b></td><td><input id="maxAmt" name="smaxAmt" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
									</tr>
							 		 <!-- <td>有效起始时间<b>*</b></td><td><input id="beginTime" name="beginTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>有效截止时间<b>*</b></td><td><input id="endTime" name="endTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td> -->
									<tr>
                					 <td>启用状态<b>*</b></td>
									 <td>
									    <select id="state" class="easyui-combobox" name="state" panelHeight="80" style="width:175px;" data-options="editable:false">
							 	 		<option value="0">停用</option>
										<option value="1">启用</option>
										<option value="2">暂停</option>
									 </select>
									 </td>			
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
									<!--  <td>结算方式<b>*</b></td>
                					 <td>
                					 <select id="settleType" class="easyui-combobox" name="settleType" panelHeight="80" style="width:175px;" data-options="editable:false">
							 	 		<option value="0">D0</option>
										<option value="1">D1</option>
										<option value="2">T0</option>
										<option value="3">T1</option>
									 </select>
                					 </td>	 -->								
                					</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#ralMerchantTransModeDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/ralMerchantTransMode/getRalMerchantTransModePage',
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
				             {title:'交易方式', field:'transModeId',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.transMode&&row.transMode.transModeName){
				     					return "<font color='blue'>"+row.transMode.transModeName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'费率(万分之)', field:'feeRate',width:20,align:'center'},
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
				            /*  {title:'有效起始时间', field:'beginTime',width:50,align:'center'},
				             {title:'有效截止时间', field:'endTime',width:50,align:'center'}, */
				             {title:'状态 ', field:'state',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             {title:'限流状态', field:'restrictState',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             /* {title:'结算方式', field:'settleType',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'D0':value=='1'?'D1':value=='2'?'T0':value=='3'?'T1':'未知';
				            	 }	
				             }, */
				             {title:'IP白名单', field:'validIP',width:40,align:'center'},
				             {title:'创建时间', field:'createTime',width:40,align:'center'},
				             {title:'修改时间', field:'updateTime',width:40,align:'center'},
				             {title:'通道配置', field:'paeizhi',width:40,align:'center',
				            	 formatter:function(value,row,index){
	 								 return '<a href="#" onclick=\'javascript:peizhi('+JSON.stringify(row)+')\' style="color:rgb(0,148,217);">通道配置</a>';
	 							 }
				             }
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/ralMerchantTransMode/'+url;
					$('#ralMerchantTransModeForm').ajaxSubmit(options);
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
					if($('#ralMerchantTransModeForm').form('validate')){
						pro();
						$('#ralMerchantTransModeDialog').dialog('close');
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
		        	$('#ralMerchantTransModeDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addRalMerchantTransModeDialog(){
				$('#ralMerchantTransModeForm').form('clear');
				$('#ralMerchantTransModeDialog').dialog('open');
				url = "addRalMerchantTransMode";
			}
			// response,status,xhr
		    function updateRalMerchantTransModeDialog(){
		    	url = "updateRalMerchantTransMode";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].ralMerTransModeId;
	    		 	$.ajax({type:'GET',url:'${ctx}/ralMerchantTransMode/getRalMerchantTransModeById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#ralMerchantTransModeForm').form('clear');
		    				  		$('#ralMerTransModeId').val(data.ralMerTransModeId);
		    				  		$('#mchId').combobox('select',data.mchId);
		    				  		$('#transModeId').combobox('select',data.transModeId);
		    				  		$('#feeRate').numberbox('setValue', data.feeRate);
		    				  		$('#totleAmtLimit').numberbox('setValue', parseFloat(data.totleAmtLimit/100).toFixed(2));
		    				  		$('#minAmt').numberbox('setValue', parseFloat(data.minAmt/100).toFixed(2));
		    				  		$('#maxAmt').numberbox('setValue', parseFloat(data.maxAmt/100).toFixed(2));
		    				  		$('#beginTime').val(data.beginTime);
		    				  		$('#endTime').val(data.endTime);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#isDel').val(data.isDel);
		    				  		$('#restrictState').combobox('select',data.restrictState);
		    				  		$('#validIP').val(data.validIP);
				    			$('#ralMerchantTransModeDialog').dialog('open');
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
		    function deleteRalMerchantTransMode(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].ralMerTransModeId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/ralMerchantTransMode/deleteRalMerchantTransMode',data:{'param':arr.toString()},
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
		    	var mchId = $("#mchId_s").val();
		    	var transModeId = $("#transModeId_s").val();
		    	var state = $("#state_s").val();
		    	var restrictState = $("#restrictState_s").val();
		    $("#tt").datagrid('load',{
		    	   mchId:mchId,
		    	   transModeId:transModeId,
		    	   feeRate:feeRate,
		    	   state:state,
		    	   restrictState:restrictState
		    	})
		    }
		    function peizhi(rowData){
		    	window.location.href="${ctx}/ralProductMerchant/toRalProductMerchantPage?transModeId="+rowData.transModeId+"&mchId="+rowData.mchId;
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