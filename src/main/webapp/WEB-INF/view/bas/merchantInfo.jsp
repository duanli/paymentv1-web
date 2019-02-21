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
			    <li><a href="${ctx}/merchantInfo/toMerchantInfoPage">MerchantInfo</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<!-- <li>机构:
				<input name="orgParentId" type="text" maxlength="30" id="orgParentId_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<li>商户名称:<input name="mchName" type="text" maxlength="30" id="mchName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>商户类型:
				 <select id="mchType_s" style="width: 100px;height: 26px;">
			 	 		<option value="">全部</option>
			 	 		<option value="0">普通商户</option>
						<option value="1">拓展机构</option>
						<option value="2">连锁商户</option>
						<option value="3">连锁门店</option>
			 	 </select>
				<li>商户编号:<input name="mchNo" type="text" maxlength="30" id="mchNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
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
			 		<shiro:hasPermission name="merchantInfo:add">
			 		     <li class="click" id="addMerchantInfo" onclick="javascript:addMerchantInfoDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="merchantInfo:update">
					 	<li class="click" id="updateMerchantInfo" onclick="javascript:updateMerchantInfoDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="merchantInfo:delete">
						<li class="click" id="deleteMerchantInfo"  onclick="javascript:deleteMerchantInfo();">
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
 		<div id="merchantInfoDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:630px;height:360px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="merchantInfoForm" method="post">
					<fieldset style="width:550px;height:240px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="mchId" name="mchId" type="hidden"/></td>
								    </tr>
									<!-- <tr>
                					 <td>机构父ID<b>*</b></td><td><input id="orgParentId" name="orgParentId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'机构父ID不能为空!'"></input></td>
                					 <td>父商户ID<b>*</b></td><td><input id="chainParentId" name="chainParentId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'父商户ID不能为空!'"></input></td>
									</tr> -->
									<tr>
                					 <!-- <td>商户账号<b></b></td><td><input id="accNo" name="accNo" type="text" class="easyui-validatebox" data-options="editable:false" disable=true></input></td> -->
                					 <td>商户名称<b>*</b></td><td><input id="mchName" name="mchName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户名称不能为空!'"></input></td>
									 <td>商户描述<b>*</b></td><td><input id="mchDesc" name="mchDesc" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'商户描述不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>商户类型<b>*</b></td>
                					 <td>
                					  <select id="mchType" class="easyui-combobox" name="mchType" panelHeight="80" style="width:175px;" data-options="editable:false">
									    <option value="">全部</option>
							 	 		<option value="0">普通商户</option>
										<option value="1">拓展机构</option>
										<option value="2">连锁商户</option>
										<option value="3">连锁门店</option>
									  </select>
                					 </td>
                					 <td>邮箱<b>*</b></td><td><input id="email" name="email" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'邮箱不能为空!'"></input></td>
									</tr>
									<!-- <tr>
                					 <td>商户号<b>*</b></td><td><input id="mchNo" name="mchNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'接入商户号不能为空!'"></input></td>
                					 <td>商户密钥<b>*</b></td><td><input id="mchKey" name="mchKey" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'接入商户密钥不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>商户公钥<b>*</b></td><td><input id="mchRSAKey" name="mchRSAKey" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户公钥不能为空!'"></input></td>
                					 <td>应用号<b>*</b></td><td><input id="mchAPPId" name="mchAPPId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'接入应用号不能为空!'"></input></td>
									</tr> -->
									<tr>
                					 <td>联系人<b>*</b></td><td><input id="contacts" name="contacts" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'联系人不能为空!'"></input></td>
                					 <td>联系电话<b>*</b></td><td><input id="contactsCell" name="contactsCell" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'联系人电话不能为空!'"></input></td>
									</tr>
									<tr>
									 <td>审核状态<b>*</b></td>
									 <td>
									  <select id="authState" class="easyui-combobox" name="authState" panelHeight="80" style="width:175px;" data-options="editable:false">
									    <option value="0">未审核</option>
										<option value="1">审核通过</option>
										<option value="2">审核失败</option>
									  </select>
									 </td>
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
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#merchantInfoDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/merchantInfo/getMerchantInfoPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             /* {title:'商户主键ID', field:'mchId',width:50,align:'center'}, */
				             /* {title:'机构父ID', field:'orgParentId',width:50,align:'center'},
				             {title:'父商户ID', field:'chainParentId',width:50,align:'center'}, 
				             {title:'商户账号', field:'accNo',width:50,align:'center'},*/
				             {title:'商户编号', field:'mchNo',width:50,align:'center'},
				             {title:'商户名称', field:'mchName',width:40,align:'center'},
				             /* {title:'商户描述', field:'mchDesc',width:50,align:'center'}, */
				             {title:'商户类型', field:'mchType',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'普通商户':value=='1'?'机构商户':value=='2'?'连锁商户':value=='3'?'连锁门店':'未知';
				            	 }
				             },
				             {title:'联系人', field:'contacts',width:50,align:'center'},
				             /*  {title:'联系人电话', field:'contactsCell',width:50,align:'center'},
				             {title:'邮箱', field:'email',width:50,align:'center'}, */
				             /* {title:'商户密钥', field:'mchKey',width:50,align:'center'},
				             {title:'商户公钥', field:'mchRSAKey',width:50,align:'center'}, 
				             {title:'应用号', field:'mchAPPId',width:50,align:'center'},*/
				             {title:'总余额', field:'balance',width:30,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 	 
				             },
				             {title:'可用余额', field:'balanceValid',width:30,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 	 
				             },
				             {title:'未入账余额', field:'balanceUnaccounted',width:30,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 
				             },
				             {title:'冻结余额', field:'balanceFreeze',width:30,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 	 	 
				             },
				             {title:'状态', field:'state',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             {title:'IP白名单', field:'validIP',width:30,align:'center'},
				             {title:'创建时间', field:'createTime',width:40,align:'center'},
				             {title:'修改时间', field:'updateTime',width:40,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/merchantInfo/'+url;
					$('#merchantInfoForm').ajaxSubmit(options);
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
					if($('#merchantInfoForm').form('validate')){
						pro();
						$('#merchantInfoDialog').dialog('close');
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
		        	$('#merchantInfoDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMerchantInfoDialog(){
				$('#merchantInfoForm').form('clear');
				$('#merchantInfoDialog').dialog('open');
				url = "addMerchantInfo";
			}
			// response,status,xhr
		    function updateMerchantInfoDialog(){
		    	url = "updateMerchantInfo";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].mchId;
	    		 	$.ajax({type:'GET',url:'${ctx}/merchantInfo/getMerchantInfoById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#merchantInfoForm').form('clear');
			    				$('#mchId').val(data.mchId);
	    				  		$('#orgParentId').val(data.orgParentId);
	    				  		$('#chainParentId').val(data.chainParentId);
	    				  		$('#accNo').val(data.accNo);
	    				  		$('#mchName').val(data.mchName);
	    				  		$('#mchDesc').val(data.mchDesc);
	    				  		$('#mchType').combobox('select',data.mchType);
	    				  		$('#contacts').val(data.contacts);
	    				  		$('#contactsCell').val(data.contactsCell);
	    				  		$('#email').val(data.email);
	    				  		$('#mchNo').val(data.mchNo);
	    				  		$('#state').combobox('select',data.state);
	    				  		$('#authState').combobox('select',data.authState);
	    				  		$('#validIP').val(data.validIP);
				    			$('#merchantInfoDialog').dialog('open');
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
		    function deleteMerchantInfo(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].mchId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/merchantInfo/deleteMerchantInfo',data:{'param':arr.toString()},
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
		    	var orgParentId = $("#orgParentId_s").val();
		    	var chainParentId = $("#chainParentId_s").val();
		    	var accNo = $("#accNo_s").val();
		    	var mchName = $("#mchName_s").val();
		    	var mchDesc = $("#mchDesc_s").val();
		    	var mchType = $("#mchType_s").val();
		    	var contacts = $("#contacts_s").val();
		    	var contactsCell = $("#contactsCell_s").val();
		    	var email = $("#email_s").val();
		    	var mchNo = $("#mchNo_s").val();
		    	var state = $("#state_s").val();
		    	var authState = $("#authState_s").val();
		    	var validIP = $("#validIP_s").val();
		    $("#tt").datagrid('load',{
		    	   mchId:mchId,
		    	   orgParentId:orgParentId,
		    	   chainParentId:chainParentId,
		    	   accNo:accNo,
		    	   mchName:mchName,
		    	   mchDesc:mchDesc,
		    	   mchType:mchType,
		    	   contacts:contacts,
		    	   contactsCell:contactsCell,
		    	   email:email,
		    	   mchNo:mchNo,
		    	   state:state,
		    	   authState:authState,
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