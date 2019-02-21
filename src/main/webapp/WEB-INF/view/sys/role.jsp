<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../pages/taglibs.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>测试系统</title>
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
			    <li><a href="#">后台用户管理</a></li>
			    <li><a href="${ctx}/role/toRolePage">角色管理</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul>
			 		<shiro:hasPermission name="role:add">
			 		     <li class="click" id="addRole" onclick="javascript:addRoleDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="role:update">
					 	<li class="click" id="updateRole" onclick="javascript:updateRoleDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="role:delete">
						<li class="click" id="deleteRole"  onclick="javascript:deleteRole();">
					 	 	<span><a href="#"><img src="${ctx}/images/t03.png"/></a></span>删除
				 	 	</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="role:addRoleAuth">
						<li class="click" id="addRoleAuth" onclick="javascript:assignPermDialog();">
				 	 		<span><a href="#"><img src="${ctx}/images/t05.png"/></a></span>分配权限
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
 		<div id="roleDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:320px;height:260px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="roleForm" method="post">
					<fieldset style="width:260px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
							<tr>
								<td><input id="id" name="id" type="hidden"/></td>
							</tr>
							<tr>
								<td>角色名称<b>*</b></td><td><input id="name" name="name" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'角色名称不能为空!'"></input></td>
							</tr>
							<tr>
								<td>英文名称<b>*</b></td><td><input id="enName" name="enName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'英文名称不能为空!',validType:'checkRoleEname'"></input></td>
							</tr>
							<tr>
								<td>角色描述<b>*</b></td><td><input id="remark" name="remark" type="text" class="easyui-validatebox"></input></td>
							</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- 权限分配窗口 -->
		<div id="assignPermDialog" title="权限菜单" class="easyui-dialog" closed="true"  style="width:330px;height:500px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#assignPerm_buttons">
			<div class="tab">
			<form>
				<fieldset style="width:270px">
					<legend>带勾为选中</legend>
					<ul id="rt"></ul>
				</fieldset>
			</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#roleDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<!-- 权限分配 -->
		<div id="assignPerm_buttons">
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="assignPerm();">提交</a>
	        <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#assignPermDialog').dialog('close');">关闭</a>
	    </div>
		<script type="text/javascript">
			$(function(){
				$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/role/getRolePage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'主键', field:'id',width:50,align:'center'},
				             {title:'角色名称', field:'name',width:50,align:'center'},
				             {title:'英文名称', field:'enName',width:50,align:'center'},
				             {title:'角色描述', field:'remark',width:50,align:'center'},
				             {title:'创建时间', field:'createDate',width:50,align:'center',
       		                	 formatter:function(value){
 									if(value)
 										return $.formatDate(value);
 							     }	 
       		                 },
       		                 {title:'更新时间', field:'updateDate',width:50,align:'center',
       		                	 formatter:function(value){
 									if(value)
 										return $.formatDate(value);
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
					options.url = '${ctx}/role/'+url;
					$('#roleForm').ajaxSubmit(options);
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
					if($('#roleForm').form('validate')){
						pro();
						$('#roleDialog').dialog('close');
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
		        	$('#roleDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addRoleDialog(){
				$('#roleForm').form('clear');
				$('#roleDialog').dialog('open');
				url = "addRole";
			}
			// response,status,xhr
		    function updateRoleDialog(){
		    	url = "updateRole";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].id;
	    		 	$.ajax({type:'GET',url:'${ctx}/role/getRoleById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#roleForm').form('clear');
	    				  		$('#id').val(data.id);
	    				  		$('#name').val(data.name);
	    				  		$('#enName').val(data.enName);
	    				  		$('#remark').val(data.remark);
				    			$('#roleDialog').dialog('open');
			    			}else
			    				$.messager.alert('提示',"暂无用户数据!",'info');
		        	    	hide();
		        	    },error:function(res){
		        	    	alert(res.responseText);
		        	    },
		        	    dataType:'json'
		        	});
	    		}else{
	    			$.messager.alert('提示',"请选择一项进行修改!",'warning');
	    			return null;
	    		}
		    }
		    function deleteRole(){
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
	        			$.ajax({type:'GET',url:'${ctx}/role/deleteRole',data:{'param':arr.toString()},
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
		    //********************************************** 华丽分割线 ***************************************//
    	    // 检查英文名称是否已存在
    		$.extend($.fn.validatebox.defaults.rules, {
	        	checkRoleEname: {
	                validator: function(value){
	                	var datas = $('#tt').datagrid('getRows');
	                	if(datas && url){
	                		if(url == "addRole"){
	                			for(var data in datas){
	                        		var eName =datas[data].enName;
	                        		if(eName ===value){
	                        			return false;
	                        		}
	                        	}
	                		}
	                	}
	                	return true;
	                },
	                message: '英文名称已存在!'
	            }
	        });
    	    // 权限分配
		   	var roleId=null;
	       	function assignPermDialog(){
	    	   var chks = $('#tt').datagrid('getChecked');
	    	   if(null!=chks && chks.length==1){
	    		   $('#rt').html(null);
	    		    pro();
	    	    	roleId  = chks[0].id;
	    	       	$('#rt').tree({
	    	       		lines:true,
	    	       		checkbox:true,
	    	       	    url:'${ctx}/menu/getTreeMenu',
	    	       	    onLoadSuccess:function(){
	    	       	    	hide();
		    	       	  	$.ajax({type:'GET',url:'${ctx}/menu/getRoleMenu',data:{'menuType':1,'roleId':roleId,'r':Math.random()},
				        	    success:function(data,status,xhr){
				        	    	for(d in data){
	    	           					var tnode = data[d];
	    	           					var node = $('#rt').tree('find',tnode.id);
	    	           					$('#rt').tree('check', node.target);
	    	           				} 
				        	    	hide();
				        	    },error:function(res){
				        	    	$.messager.alert('提示','数据加载失败','error');
				        	    },
				        	    dataType:'json'
				        	});
	    	       	    }
	    	       	});
	    	       	$('#assignPermDialog').dialog('open');
	    	   }else{
	    		   $.messager.alert('提示','请选择一项进行操作!','warning');
	    	   }
	       	}
	       	// 添加角色权限
	       	function assignPerm(){
		      	pro();
	        	var nodes = $('#rt').tree('getChecked',['checked','indeterminate']);
		      	var ch = new Array();
		      	for(node in nodes){
		      		ch[node] = nodes[node].id;
		      	}
				$.ajax({type:'POST',url:'${ctx}/role/addRoleAuth',data:{'roles':ch.toString(),'roleId':roleId},
	        	    success:function(text,status,xhr){
	        	    	hide();
	        	    	$.messager.alert('提示',"分配成功，新分配角色需要重新登录!",'info');
	        	    	$('#assignPermDialog').dialog('close');
	        	    },error:function(res){
	        	    	hide();
	        	    	$.messager.alert('提示',res.responseText,'warning');
	        	    },
	        	    dataType:'json'
	        	});
	       	}
		</script>
	</body>
</html>