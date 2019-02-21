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
			    <li><a href="${ctx}/provider/toProviderPage">Provider</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<!-- <li>唯一ID:<input name="providerId" type="text" maxlength="30" id="providerId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>唯一ID:<input name="providerAgentId" type="text" maxlength="30" id="providerAgentId_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<li>通道编号:<input name="providerNo" type="text" maxlength="30" id="providerNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>通道简称:<input name="providerAlias" type="text" maxlength="30" id="providerAlias_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<!-- <li>通道名称:<input name="providerName" type="text" maxlength="30" id="providerName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>创建时间:<input name="createTime" type="text" maxlength="30" id="createTime_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	<li>修改时间:<input name="updateTime" type="text" maxlength="30" id="updateTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
				<li>服务地址:<input name="serverUrl" type="text" maxlength="30" id="serverUrl_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>服务编号:<input name="serverNo" type="text" maxlength="30" id="serverNo_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="provider:add">
			 		     <li class="click" id="addProvider" onclick="javascript:addProviderDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="provider:update">
					 	<li class="click" id="updateProvider" onclick="javascript:updateProviderDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="provider:delete">
						<li class="click" id="deleteProvider"  onclick="javascript:deleteProvider();">
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
 		<div id="providerDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:370px;height:320px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="providerForm" method="post">
					<fieldset style="width:300px;height:200px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="providerId" name="providerId" type="hidden"/></td>
								    </tr>
									<!-- <tr>
                					 <td>通道代理<b>*</b></td><td><input id="providerAgentId" name="providerAgentId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'主键ID不能为空!'"></input></td>
									</tr> -->
									<tr>
                					 <td>通道编号<b>*</b></td><td><input id="providerNo" name="providerNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易服务商编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>通道简称<b>*</b></td><td><input id="providerAlias" name="providerAlias" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易服务商简称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>通道名称<b>*</b></td><td><input id="providerName" name="providerName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易服务商名称不能为空!'"></input></td>
									<!-- </tr>
                					 <td>服务地址<b>*</b></td><td><input id="serverUrl" name="serverUrl" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务地址不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>服务编号<b>*</b></td><td><input id="serverNo" name="serverNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'服务编号不能为空!'"></input></td>
									</tr> -->
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#providerDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/provider/getProviderPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             /* {title:'唯一ID', field:'providerId',width:50,align:'center'}, */
				             /* {title:'主键ID', field:'providerAgentId',width:50,align:'center'}, */
				             {title:'通道编号', field:'providerNo',width:50,align:'center'},
				             {title:'通道简称', field:'providerAlias',width:50,align:'center'},
				             {title:'通道名称', field:'providerName',width:50,align:'center'},
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改时间', field:'updateTime',width:50,align:'center'},
				             /* {title:'服务地址', field:'serverUrl',width:50,align:'center'},
				             {title:'服务编号', field:'serverNo',width:50,align:'center'} */
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/provider/'+url;
					$('#providerForm').ajaxSubmit(options);
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
					if($('#providerForm').form('validate')){
						pro();
						$('#providerDialog').dialog('close');
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
		        	$('#providerDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addProviderDialog(){
				$('#providerForm').form('clear');
				$('#providerDialog').dialog('open');
				url = "addProvider";
			}
			// response,status,xhr
		    function updateProviderDialog(){
		    	url = "updateProvider";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].providerId;
	    		 	$.ajax({type:'GET',url:'${ctx}/provider/getProviderById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#providerForm').form('clear');
		    				  		$('#providerId').val(data.providerId);
		    				  		/* $('#providerAgentId').val(data.providerAgentId); */
		    				  		$('#providerNo').val(data.providerNo);
		    				  		$('#providerAlias').val(data.providerAlias);
		    				  		$('#providerName').val(data.providerName);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
		    				  		$('#serverUrl').val(data.serverUrl);
		    				  		$('#serverNo').val(data.serverNo);
				    			$('#providerDialog').dialog('open');
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
		    function deleteProvider(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].providerId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/provider/deleteProvider',data:{'param':arr.toString()},
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
		    	var providerId = $("#providerId_s").val();
		    	var providerAgentId = $("#providerAgentId_s").val();
		    	var providerNo = $("#providerNo_s").val();
		    	var providerAlias = $("#providerAlias_s").val();
		    	var providerName = $("#providerName_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    	var serverUrl = $("#serverUrl_s").val();
		    	var serverNo = $("#serverNo_s").val();
		    $("#tt").datagrid('load',{
		    	   providerId:providerId,
		    	   providerAgentId:providerAgentId,
		    	   providerNo:providerNo,
		    	   providerAlias:providerAlias,
		    	   providerName:providerName,
		    	   createTime:createTime,
		    	   updateTime:updateTime,
		    	   serverUrl:serverUrl,
		    	   serverNo:serverNo,
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