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
			    <li><a href="${ctx}/merchantSettlement/toMerchantSettlementPage">商户结算</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>商户名称:<input name="mchId" type="text" maxlength="30" id="mchId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<!-- <li>结算方式0-D0;1-D1;2-T0;3-T1:<input name="settleType" type="text" maxlength="30" id="settleType_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>状态 0-未结算 1-结算成功 2-结算中:<input name="state" type="text" maxlength="30" id="state_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
			 	<li>起始时间:<input name="beginTime" type="text" maxlength="30" id="beginTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
			 	<li>截止时间:<input name="endTime" type="text" maxlength="30" id="endTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="merchantSettlement:add">
			 		     <li class="click" id="addMerchantSettlement" onclick="javascript:addMerchantSettlementDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="merchantSettlement:update">
					 	<li class="click" id="updateMerchantSettlement" onclick="javascript:updateMerchantSettlementDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="merchantSettlement:delete">
						<li class="click" id="deleteMerchantSettlement"  onclick="javascript:deleteMerchantSettlement();">
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
 		<div id="merchantSettlementDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:830px;height:560px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="merchantSettlementForm" method="post">
					<fieldset style="width:800px;height:530px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="settleId" name="settleId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>商户主键ID<b>*</b></td><td><input id="mchId" name="mchId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户主键ID不能为空!'"></input></td>
									</tr>
							 		 <td>结算日期<b>*</b></td><td><input id="settleDate" name="settleDate" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>交易日期<b>*</b></td><td><input id="payDate" name="payDate" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
									<tr>
                					 <td>结算方式<b>*</b></td><td><input id="settleType" name="settleType" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'结算方式0-D0;1-D1;2-T0;3-T1不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>结算金额<b>*</b></td><td><input id="settleAmount" name="settleAmount" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'结算金额不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>状态 <b>*</b></td><td><input id="state" name="state" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'状态 0-未结算 1-结算成功 2-结算中不能为空!'"></input></td>
									</tr>
							 		 <td>创建时间<b>*</b></td><td><input id="createTime" name="createTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>修改时间<b>*</b></td><td><input id="updateTime" name="updateTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#merchantSettlementDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/merchantSettlement/getMerchantSettlementPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'商户名称', field:'mchId',width:50,align:'center'},
				             {title:'结算日期', field:'settleDate',width:50,align:'center'},
				             {title:'交易日期', field:'payDate',width:50,align:'center'},
				             {title:'结算方式', field:'settleType',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='blue'>D0</font>":value=='1'?"<font color='blue'>D1</font>":value=='2'?"<font color='blue'>T0</font>":value=='3'?"<font color='blue'>T1</font>":'未知';
				            	 }
				             },
				             {title:'结算金额', field:'settleAmount',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 		 
				             },
				             {title:'处理状态', field:'state',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>未结算</font>":value=='1'?"<font color='green'>结算成功</font>":value=='2'?'结算中':'未知';
				            	 }
				             },
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
					options.url = '${ctx}/merchantSettlement/'+url;
					$('#merchantSettlementForm').ajaxSubmit(options);
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
					if($('#merchantSettlementForm').form('validate')){
						pro();
						$('#merchantSettlementDialog').dialog('close');
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
		        	$('#merchantSettlementDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMerchantSettlementDialog(){
				$('#merchantSettlementForm').form('clear');
				$('#merchantSettlementDialog').dialog('open');
				url = "addMerchantSettlement";
			}
			// response,status,xhr
		    function updateMerchantSettlementDialog(){
		    	url = "updateMerchantSettlement";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].settleId;
	    		 	$.ajax({type:'GET',url:'${ctx}/merchantSettlement/getMerchantSettlementById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#merchantSettlementForm').form('clear');
		    				  		$('#settleId').val(data.settleId);
		    				  		$('#mchId').val(data.mchId);
		    				  		$('#settleDate').val(data.settleDate);
		    				  		$('#payDate').val(data.payDate);
		    				  		$('#settleType').val(data.settleType);
		    				  		$('#settleAmount').val(data.settleAmount);
		    				  		$('#state').val(data.state);
				    			$('#merchantSettlementDialog').dialog('open');
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
		    function deleteMerchantSettlement(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].settleId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/merchantSettlement/deleteMerchantSettlement',data:{'param':arr.toString()},
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
		    	var settleId = $("#settleId_s").val();
		    	var mchId = $("#mchId_s").val();
		    	var settleDate = $("#settleDate_s").val();
		    	var payDate = $("#payDate_s").val();
		    	var settleType = $("#settleType_s").val();
		    	var settleAmount = $("#settleAmount_s").val();
		    	var state = $("#state_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    $("#tt").datagrid('load',{
		    	   settleId:settleId,
		    	   mchId:mchId,
		    	   settleDate:settleDate,
		    	   payDate:payDate,
		    	   settleType:settleType,
		    	   settleAmount:settleAmount,
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