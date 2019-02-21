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
			    <li><a href="${ctx}/providerAccount/toProviderAccountPage">ProviderAccount</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>通道名称:
				<input id="providerId_s" name="providerId" type="text"  style="width: 100px;height: 26px;" class="easyui-combobox" data-options="valueField:'providerId',textField:'providerAlias',url:'${ctx}/provider/getProviderList',editable:false"></input>
				</li>
				<li>通道账户:<input name="providerMchNo" type="text" maxlength="30" id="providerMchNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>启用状态:
					<select id="state_s" style="width: 100px;height: 26px;">
				 	 	<option value="">全部</option>
				 	 	<option value="0">停用</option>
						<option value="1">启用</option>
						<option value="2">暂停</option>
				 	</select>				</li>
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="providerAccount:add">
			 		     <li class="click" id="addProviderAccount" onclick="javascript:addProviderAccountDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="providerAccount:update">
					 	<li class="click" id="updateProviderAccount" onclick="javascript:updateProviderAccountDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="providerAccount:delete">
						<li class="click" id="deleteProviderAccount"  onclick="javascript:deleteProviderAccount();">
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
 		<div id="providerAccountDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:370px;height:435px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="providerAccountForm" method="post">
					<fieldset style="width:300px;height:320px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="providerAccId" name="providerAccId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>支付通道<b>*</b></td>
                					 <td>
                					 <input id="providerId" name="providerId" type="text" class="easyui-combobox" data-options="valueField:'providerId',textField:'providerAlias',url:'${ctx}/provider/getProviderList',editable:false"></input>
                					 </td>
									</tr>
									<tr>
                					 <td>账户名称<b>*</b></td><td><input id="accName" name="accName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'账户名称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户编号<b>*</b></td><td><input id="providerMchNo" name="providerMchNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商账户号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户密钥<b>*</b></td><td><input id="providerMchKey" name="providerMchKey" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商账户密钥不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户应用ID<b>*</b></td><td><input id="providerAPPId" name="providerAPPId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商应用ID不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>账户公钥<b>*</b></td><td><input id="providerRSAKey" name="providerRSAKey" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务商公钥不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>启用状态<b>*</b></td>
									 <td>
										<select id="state" class="easyui-combobox" name="state" panelHeight="80" style="width:175px;" data-options="editable:false">
									    <option value="0">停用</option>
										<option value="1">启用</option>
										<option value="2">暂停</option>
									  </select>
									 </td>									</tr>
									<tr>
                					 <td>费率(万分之)<b>*</b></td><td><input id="feeRate" name="feeRate" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'手续费费率万分之不能为空!'"></input></td>
									</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#providerAccountDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/providerAccount/getProviderAccountPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             /* {title:'支付账户主键', field:'providerAccId',width:50,align:'center'}, */
				             {title:'支付通道', field:'providerId',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.provider&&row.provider.providerAlias){
				     					return "<font color='blue'>"+row.provider.providerAlias+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'账户名称', field:'accName',width:50,align:'center'},
				             {title:'账户编号', field:'providerMchNo',width:50,align:'center'},
				             {title:'账户密钥', field:'providerMchKey',width:50,align:'center'},
				             {title:'应用ID', field:'providerAPPId',width:50,align:'center'},
				             {title:'账户公钥', field:'providerRSAKey',width:50,align:'center'},
				             {title:'启用状态', field:'state',width:30,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }		 
				             },
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'更新时间', field:'updateTime',width:50,align:'center'},
				             {title:'费率万分之', field:'feeRate',width:30,align:'center'}
				             /* {title:'账户余额', field:'balance',width:50,align:'center'} */
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/providerAccount/'+url;
					$('#providerAccountForm').ajaxSubmit(options);
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
					if($('#providerAccountForm').form('validate')){
						pro();
						$('#providerAccountDialog').dialog('close');
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
		        	$('#providerAccountDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addProviderAccountDialog(){
				$('#providerAccountForm').form('clear');
				$('#providerAccountDialog').dialog('open');
				url = "addProviderAccount";
			}
			// response,status,xhr
		    function updateProviderAccountDialog(){
		    	url = "updateProviderAccount";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].providerAccId;
	    		 	$.ajax({type:'GET',url:'${ctx}/providerAccount/getProviderAccountById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#providerAccountForm').form('clear');
		    				  		$('#providerAccId').val(data.providerAccId);
		    				  		$('#providerId').combobox('select',data.providerId);
		    				  		$('#accName').val(data.accName);
		    				  		$('#providerMchNo').val(data.providerMchNo);
		    				  		$('#providerMchKey').val(data.providerMchKey);
		    				  		$('#providerAPPId').val(data.providerAPPId);
		    				  		$('#providerRSAKey').val(data.providerRSAKey);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
		    				  		$('#feeRate').val(data.feeRate);
		    				  		$('#balance').val(data.balance);
				    			$('#providerAccountDialog').dialog('open');
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
		    function deleteProviderAccount(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].providerAccId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/providerAccount/deleteProviderAccount',data:{'param':arr.toString()},
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
		    	var providerAccId = $("#providerAccId_s").val();
		    	var providerId = $("#providerId_s").val();
		    	var providerMchNo = $("#providerMchNo_s").val();
		    	var providerMchKey = $("#providerMchKey_s").val();
		    	var providerAPPId = $("#providerAPPId_s").val();
		    	var providerRSAKey = $("#providerRSAKey_s").val();
		    	var state = $("#state_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    	var feeRate = $("#feeRate_s").val();
		    	var balance = $("#balance_s").val();
		    $("#tt").datagrid('load',{
		    	   providerAccId:providerAccId,
		    	   providerId:providerId,
		    	   providerMchNo:providerMchNo,
		    	   providerMchKey:providerMchKey,
		    	   providerAPPId:providerAPPId,
		    	   providerRSAKey:providerRSAKey,
		    	   state:state,
		    	   createTime:createTime,
		    	   updateTime:updateTime,
		    	   feeRate:feeRate,
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