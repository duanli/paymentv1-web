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
			    <li><a href="${ctx}/merchantAccount/toMerchantAccountPage">MerchantAccount</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<!-- <li>代理商:<input name="orgNo" type="text" maxlength="30" id="orgNo_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<li>商户编号:<input name="merNo" type="text" maxlength="30" id="merNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>账户编号:<input name="mchNo" type="text" maxlength="30" id="mchNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<!-- <li>账户应用号:<input name="mchAPPId" type="text" maxlength="30" id="mchAPPId_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<li>启用状态:
					<select id="state_s" style="width: 100px;height: 26px;">
				 	 		<option value="">全部</option>
				 	 		<option value="0">停用</option>
							<option value="1">启用</option>
							<option value="2">暂停</option>
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
			 		<shiro:hasPermission name="merchantAccount:add">
			 		     <li class="click" id="addMerchantAccount" onclick="javascript:addMerchantAccountDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="merchantAccount:update">
					 	<li class="click" id="updateMerchantAccount" onclick="javascript:updateMerchantAccountDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="merchantAccount:delete">
						<li class="click" id="deleteMerchantAccount"  onclick="javascript:deleteMerchantAccount();">
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
 		<div id="merchantAccountDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:380px;height:460px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="merchantAccountForm" method="post">
					<fieldset style="width:300px;height:330px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="id" name="id" type="hidden"/></td>
								    </tr>
									<!-- <tr>
                					 <td>代理商<b>*</b></td><td><input id="orgNo" name="orgNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'拓展机构编号不能为空!'"></input></td>
									</tr>
									<tr> -->
                					 <td>商户编号<b>*</b></td><td><input id="merNo" name="merNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'关联商户编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户编号<b>*</b></td><td><input id="mchNo" name="mchNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'三方商户号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户密钥<b>*</b></td><td><input id="mchKey" name="mchKey" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'三方商户密钥不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户应用号<b>*</b></td><td><input id="mchAPPId" name="mchAPPId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'三方应用号不能为空!'"></input></td>
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
                					</tr>
                					<tr>
                					<td>费率(万分之)<b>*</b></td>
                					<td><input id="poundage" name="poundage" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'手续费费率不能为空!'"></input></td>
									</tr>
									<!-- <tr>
                					 <td>账户总余额<b>*</b></td><td><input id="balance" name="balance" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'账户总余额不能为空!'"></input></td>
									</tr> -->
									<tr>
                					 <td>IP白名单<b>*</b></td><td><input id="validIP" name="validIP" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'IP白名单不能为空!'"></input></td>
									</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#merchantAccountDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/merchantAccount/getMerchantAccountPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				            /*  {title:'代理编号', field:'orgNo',width:50,align:'center'}, */
				             {title:'所属商户', field:'merNo',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.merchant&&row.merchant.merName){
				     					return "<font color='blue'>"+row.merchant.merName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'账户编号', field:'mchNo',width:50,align:'center'},
				             {title:'账户密钥', field:'mchKey',width:50,align:'center'},
				             {title:'账户应用号', field:'mchAPPId',width:50,align:'center'},
				             {title:'启用状态', field:'state',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'停用':value=='1'?'启用':value=='2'?'暂停':'未知';
				            	 }	
				             },
				             {title:'创建时间', field:'createTime',width:50,align:'center',
				            	 formatter:function(value){
	 									if(value)
	 										return $.formatDate(value);
	 							 }
				             },
				             {title:'更新时间', field:'updateTime',width:50,align:'center',
				            	 formatter:function(value){
	 									if(value)
	 										return $.formatDate(value);
	 							 }
				             },
				             {title:'手续费费率', field:'poundage',width:50,align:'center'},
				             {title:'账户总余额', field:'balance',width:50,align:'center'},
				             {title:'IP白名单', field:'validIP',width:50,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/merchantAccount/'+url;
					$('#merchantAccountForm').ajaxSubmit(options);
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
					if($('#merchantAccountForm').form('validate')){
						pro();
						$('#merchantAccountDialog').dialog('close');
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
		        	$('#merchantAccountDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMerchantAccountDialog(){
				$('#merchantAccountForm').form('clear');
				$('#merchantAccountDialog').dialog('open');
				url = "addMerchantAccount";
			}
			// response,status,xhr
		    function updateMerchantAccountDialog(){
		    	url = "updateMerchantAccount";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].id;
	    		 	$.ajax({type:'GET',url:'${ctx}/merchantAccount/getMerchantAccountById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#merchantAccountForm').form('clear');
				    				$('#id').val(data.id);
		    				  		$('#orgNo').val(data.orgNo);
		    				  		$('#merNo').val(data.merNo);
		    				  		$('#mchNo').val(data.mchNo);
		    				  		$('#mchKey').val(data.mchKey);
		    				  		$('#mchAPPId').val(data.mchAPPId);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#feeRate').val(data.feeRate);
		    				  		$('#balance').val(data.balance);
		    				  		$('#validIP').val(data.validIP);
				    			$('#merchantAccountDialog').dialog('open');
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
		    function deleteMerchantAccount(){
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
	        			$.ajax({type:'GET',url:'${ctx}/merchantAccount/deleteMerchantAccount',data:{'param':arr.toString()},
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
		    	var orgNo = $("#orgNo_s").val();
		    	var merNo = $("#merNo_s").val();
		    	var mchNo = $("#mchNo_s").val();
		    	var mchKey = $("#mchKey_s").val();
		    	var mchAPPId = $("#mchAPPId_s").val();
		    	var state = $("#state_s").val();
		    	var feeRate = $("#feeRate_s").val();
		    	var balance = $("#balance_s").val();
		    	var validIP = $("#validIP_s").val();
		    $("#tt").datagrid('load',{
		    	   id:id,
		    	   orgNo:orgNo,
		    	   merNo:merNo,
		    	   mchNo:mchNo,
		    	   mchKey:mchKey,
		    	   mchAPPId:mchAPPId,
		    	   state:state,
		    	   feeRate:feeRate,
		    	   balance:balance,
		    	   validIP:validIP,
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