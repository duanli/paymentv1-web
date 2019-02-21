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
		.rightinfo li{background:url(${ctx}/images/toolbg.gif) repeat-x; line-height:33px; height:33px; float:left; padding-right:10px; margin-right:5px;border-radius: 3px; behavior:url(${ctx}/js/pie.htc); cursor:pointer;}
	  	.rightinfo a{text-decoration: none;color:black;}
	  	</style>
	</head>
	<body>
		<div class="place">
			<span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">首页</a></li>
			    <li><a href="${ctx}/log/toLogPage">Log</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>类型:<input name="type" type="text" maxlength="30" id="type_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>标题:<input name="title" type="text" maxlength="30" id="title_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>用户名称:<input name="userId" type="text" maxlength="30" id="userId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	<!-- <li>创建时间:<input name="createDate" type="text" maxlength="30" id="createDate_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
				<li>结束时间:<input name="timeout" type="text" maxlength="30" id="timeout_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<li>IP地址:<input name="remoteAddr" type="text" maxlength="30" id="remoteAddr_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<!-- <li>用户代理:<input name="userAgent" type="text" maxlength="30" id="userAgent_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>请求URI:<input name="requestUri" type="text" maxlength="30" id="requestUri_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>操作方式:<input name="method" type="text" maxlength="30" id="method_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>操作提交的数据:<input name="params" type="text" maxlength="30" id="params_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>备注:<input name="remark" type="text" maxlength="30" id="remark_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
			 	<li class="click" id="toStorePage" onclick="javascript:search();">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="log:add">
			 		     <li class="click" id="addLog" onclick="javascript:addLogDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="log:update">
					 	<li class="click" id="updateLog" onclick="javascript:updateLogDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="log:delete">
						<li class="click" id="deleteLog"  onclick="javascript:deleteLog();">
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
 		<div id="logDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:830px;height:560px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="logForm" method="post">
					<fieldset style="width:800px;height:530px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="logId" name="logId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>日志类型<b>*</b></td><td><input id="type" name="type" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'日志类型不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>日志标题<b>*</b></td><td><input id="title" name="title" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'日志标题不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>创建者<b>*</b></td><td><input id="userId" name="userId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'创建者不能为空!'"></input></td>
									</tr>
							 		 <td>创建时间<b>*</b></td><td><input id="createDate" name="createDate" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
									<tr>
                					 <td>结束时间<b>*</b></td><td><input id="timeout" name="timeout" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'结束时间不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>操作IP地址<b>*</b></td><td><input id="remoteIp" name="remoteIp" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'操作IP地址不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>用户代理<b>*</b></td><td><input id="userAgent" name="userAgent" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'用户代理不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>请求URI<b>*</b></td><td><input id="requestUri" name="requestUri" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'请求URI不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>操作方式<b>*</b></td><td><input id="method" name="method" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'操作方式不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>操作提交的数据<b>*</b></td><td><input id="params" name="params" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'操作提交的数据不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>备注<b>*</b></td><td><input id="remark" name="remark" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'备注不能为空!'"></input></td>
									</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#logDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/log/getLogPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				            /*  {title:'日ID', field:'logId',width:50,align:'center'}, */
				             {title:'类型', field:'type',width:10,align:'center'},
				             {title:'标题', field:'title',width:20,align:'center'},
				             {title:'创建者', field:'userId',width:10,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.user&&row.user.userName){
				     					return "<font color='blue'>"+row.user.userName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }
				             },
				             {title:'创建时间', field:'startDate',width:20,align:'center'},
				             {title:'耗时ms', field:'timeout',width:10,align:'center'},
				             {title:'IP地址', field:'remoteAddr',width:20,align:'center'},
				             /* {title:'请求头', field:'userAgent',width:30,align:'center'}, */
				             {title:'请求URI', field:'requestUri',width:30,align:'center'},
				             {title:'操作方式', field:'method',width:10,align:'center'},
				             {title:'操作提交的数据', field:'params',width:50,align:'center'}
				           /*   {title:'备注', field:'remark',width:50,align:'center'} */
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/log/'+url;
					$('#logForm').ajaxSubmit(options);
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
					if($('#logForm').form('validate')){
						pro();
						$('#logDialog').dialog('close');
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
		        	$('#logDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addLogDialog(){
				$('#logForm').form('clear');
				$('#logDialog').dialog('open');
				url = "addLog";
			}
			// response,status,xhr
		    function updateLogDialog(){
		    	url = "updateLog";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].logId;
	    		 	$.ajax({type:'GET',url:'${ctx}/log/getLogById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#logForm').form('clear');
		    				  		$('#logId').val(data.logId);
		    				  		$('#type').val(data.type);
		    				  		$('#title').val(data.title);
		    				  		$('#userId').val(data.userId);
		    				  		$('#createDate').val(data.createDate);
		    				  		$('#timeout').val(data.timeout);
		    				  		$('#remoteIp').val(data.remoteIp);
		    				  		$('#userAgent').val(data.userAgent);
		    				  		$('#requestUri').val(data.requestUri);
		    				  		$('#method').val(data.method);
		    				  		$('#params').val(data.params);
		    				  		$('#remark').val(data.remark);
				    			$('#logDialog').dialog('open');
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
		    function deleteLog(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].logId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/log/deleteLog',data:{'param':arr.toString()},
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
		    	var logId = $("#logId_s").val();
		    	var type = $("#type_s").val();
		    	var title = $("#title_s").val();
		    	var userId = $("#userId_s").val();
		    	var createDate = $("#createDate_s").val();
		    	var timeout = $("#timeout_s").val();
		    	var remoteAddr = $("#remoteAddr_s").val();
		    	var userAgent = $("#userAgent_s").val();
		    	var requestUri = $("#requestUri_s").val();
		    	var method = $("#method_s").val();
		    	var params = $("#params_s").val();
		    	var remark = $("#remark_s").val();
		    $("#tt").datagrid('load',{
		    	   logId:logId,
		    	   type:type,
		    	   title:title,
		    	   userName:userId,
		    	   createDate:createDate,
		    	   timeout:timeout,
		    	   remoteAddr:remoteAddr,
		    	   userAgent:userAgent,
		    	   requestUri:requestUri,
		    	   method:method,
		    	   params:params,
		    	   remark:remark,
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