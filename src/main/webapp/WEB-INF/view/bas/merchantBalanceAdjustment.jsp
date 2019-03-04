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
			    <li><a href="${ctx}/merchantBalanceAdjustment/toMerchantBalanceAdjustmentPage">人工调账</a></li>
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
<!-- 				<li>调账人:<input name="operatorId" type="text" maxlength="30" id="operatorId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
 -->				
 				<li>调整方式:
				<select id="adjustType_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">扣减</option>
						<option value="1">增加</option>
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
			 		<shiro:hasPermission name="merchantBalanceAdjustment:add">
			 		     <li class="click" id="addMerchantBalanceAdjustment" onclick="javascript:addMerchantBalanceAdjustmentDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>开始调账
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="merchantBalanceAdjustment:update">
					 	<li class="click" id="updateMerchantBalanceAdjustment" onclick="javascript:updateMerchantBalanceAdjustmentDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="merchantBalanceAdjustment:delete">
						<li class="click" id="deleteMerchantBalanceAdjustment"  onclick="javascript:deleteMerchantBalanceAdjustment();">
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
 		<div id="merchantBalanceAdjustmentDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:370px;height:340px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="merchantBalanceAdjustmentForm" method="post">
					<fieldset style="width:300px;height:220px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="adjustId" name="adjustId" type="hidden"/></td>
								    </tr>
								    <tr>
								    <td>选择商户<b>*</b></td>
                					 <td><input id="mchId" name="mchId" type="text" class="easyui-combobox" data-options="valueField:'mchId',textField:'mchName',url:'${ctx}/merchantInfo/getMerchantList',editable:false,
                					  onSelect: function(rec){
            							var url = '${ctx}/ralMerchantTransMode/getRalMerchantTransModeList?mchId='+rec.mchId;
            							$('#ralAccProductId').combobox('reload', url);}"></input>
                					 </td>
                					</tr>								
									<tr>
                					 <td>通道选择<b>*</b></td>
                					 <td><input id="ralAccProductId" name="ralAccProductId" type="text" class="easyui-combobox" data-options="valueField:'ralMerTransModeId',textField:'ralMerTransModeId'"></input></td>
									</tr>
									<tr>
                					 <td>调整方式<b>*</b></td>
                					 <td>
								 	 <select id="adjustType" class="easyui-combobox" name="adjustType" panelHeight="80" style="width:175px;" data-options="editable:false">
							 	 		<option value="0">扣减</option>
										<option value="1">增加</option>
									 </select>
                					 </td>
									</tr>
									<tr>
                					 <td>调账金额<b>*</b></td><td><input id="adjustAmount" name="sadjustAmount" type="text" class="easyui-numberbox" data-options="min:0,precision:2"></input></td>
									</tr>
									<tr>
                					 <td>备注<b>*</b></td><td><input id="remark" name="remark" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'调账金额不能为空!'"></input></td>
									</tr>
									<!-- <tr>
                					 <td>状态 0-无效1-有效<b>*</b></td>
                					 <td><input id="state" name="state" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'状态 0-无效1-有效不能为空!'"></input></td>
									</tr> -->
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#merchantBalanceAdjustmentDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/merchantBalanceAdjustment/getMerchantBalanceAdjustmentPage',
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
				             {title:'通道名称', field:'ralAccProductId',width:50,align:'center',
								 formatter: function(value,row,index){
				            		 if (row.transMode&&row.transMode.transModeName){
				     					return "<font color='blue'>"+row.transMode.transModeName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'调账人', field:'operatorId',width:50,align:'center'},
				             {title:'调整方式', field:'adjustType',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>扣减</font>":value=='1'?"<font color='green'>增加</font>":'未知';
				            	 }
				             },
				             {title:'调账前余额', field:'beforBalance',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 
				             },
				             {title:'调账后余额', field:'afterBalance',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 
				             },
				             {title:'调账金额', field:'adjustAmount',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 
				             },
				             /* {title:'状态 0-无效1-有效', field:'state',width:50,align:'center'}, */
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改时间', field:'updateTime',width:50,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/merchantBalanceAdjustment/'+url;
					$('#merchantBalanceAdjustmentForm').ajaxSubmit(options);
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
					if($('#merchantBalanceAdjustmentForm').form('validate')){
						pro();
						$('#merchantBalanceAdjustmentDialog').dialog('close');
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
		        	$('#merchantBalanceAdjustmentDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMerchantBalanceAdjustmentDialog(){
				$('#merchantBalanceAdjustmentForm').form('clear');
				$('#merchantBalanceAdjustmentDialog').dialog('open');
				url = "addMerchantBalanceAdjustment";
			}
			// response,status,xhr
		    function updateMerchantBalanceAdjustmentDialog(){
		    	url = "updateMerchantBalanceAdjustment";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].adjustId;
	    		 	$.ajax({type:'GET',url:'${ctx}/merchantBalanceAdjustment/getMerchantBalanceAdjustmentById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#merchantBalanceAdjustmentForm').form('clear');
		    				  		$('#adjustId').val(data.adjustId);
		    				  		$('#ralAccProductId').val(data.ralAccProductId);
		    				  		$('#operatorId').val(data.operatorId);
		    				  		$('#adjustType').val(data.adjustType);
		    				  		$('#beforBalance').val(data.beforBalance);
		    				  		$('#afterBalance').val(data.afterBalance);
		    				  		$('#adjustAmount').val(data.adjustAmount);
		    				  		$('#state').val(data.state);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
				    			$('#merchantBalanceAdjustmentDialog').dialog('open');
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
		    function deleteMerchantBalanceAdjustment(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].adjustId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/merchantBalanceAdjustment/deleteMerchantBalanceAdjustment',data:{'param':arr.toString()},
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
		    	var adjustId = $("#adjustId_s").val();
		    	var ralAccProductId = $("#ralAccProductId_s").val();
		    	var operatorId = $("#operatorId_s").val();
		    	var adjustType = $("#adjustType_s").val();
		    	var beforBalance = $("#beforBalance_s").val();
		    	var afterBalance = $("#afterBalance_s").val();
		    	var adjustAmount = $("#adjustAmount_s").val();
		    	var state = $("#state_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    $("#tt").datagrid('load',{
		    	   adjustId:adjustId,
		    	   ralAccProductId:ralAccProductId,
		    	   operatorId:operatorId,
		    	   adjustType:adjustType,
		    	   beforBalance:beforBalance,
		    	   afterBalance:afterBalance,
		    	   adjustAmount:adjustAmount,
		    	   state:state,
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