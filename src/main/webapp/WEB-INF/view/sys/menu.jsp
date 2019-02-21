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
			    <li><a href="${ctx}/menu/toMenuPage">菜单管理</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul>
			 		<shiro:hasPermission name="menu:add">
			 		     <li class="click" id="addMenu" onclick="javascript:addMenuDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>  
					<shiro:hasPermission name="menu:update">
					 	<li class="click" id="updateMenu" onclick="javascript:updateMenuDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="menu:delete">
						<li class="click" id="deleteMenu"  onclick="javascript:deleteMenu();">
					 	 	<span><a href="#"><img src="${ctx}/images/t03.png"/></a></span>删除
				 	 	</li>
					</shiro:hasPermission>
			    </ul>
			</div>
		</div>
		<!-- grid -->
		<div>
			<table id="tt" style="width:1024px;height:452px"></table>
		</div>
		<!-- dialog -->
 		<div id="menuDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:590px;height:290px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="menuForm" method="post">
					<fieldset style="width:520px">
					  <legend>带<b>*</b>为必填项</legend>
						<table border="0">
							<tr>
								<td><input id="id" name="id" type="hidden"/></td>
								<td><input id="parentId" name="parentId" type="hidden"/></td>
								<td><input id="parentIds" name="parentIds" type="hidden"/></td></td>
								<td><input id="level" name="level" type="hidden"/></td></td>
							</tr>
							<tr>
								<td>所属资源<b>*</b></td><td><label id="parentName"></label></td>
								<td>资源名<b>*</b></td><td><input id="name" name="name" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'资源名不能为空!'"></input></td>
							</tr>
						    <tr>
							     <td>资源类型 <b>*</b></td>
							     <td>
								     <select id="menuType" class="easyui-combobox" name="menuType" style="width:175px;" panelHeight="50" data-options="editable:false,required:'true',missingMessage:'类型不能为空!'">
	                              			<option value="0">菜单</option>
	                              			<option value="1">按钮</option>
	                          		 </select>
                          		 </td>
								<td>资源链接<b>*</b></td><td><input id="url" name="url" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'资源链接不能为空!'"></input></td>
						    </tr>
							<tr>
								<td>菜单权限<b>*</b></td><td><input id="permission" name="permission" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'菜单权限不能为空!'"></input></td>
								<td>序号</td><td><input id="sort" name="sort" type="text" class="easyui-numberbox" data-options="min:0"></input></td>
							</tr>
							<tr>
								<td>跳转目标</td><td><input id="target" name="target" type="text"></input></td>
								<td>资源描述</td><td><input id="desc"/></td>
							</tr>
						</table>
					  </fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#menuDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
				$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').treegrid({
						url:'${ctx}/menu/getAsyncTree',
					    idField:'id',
		    		    treeField:'name',
		    		    rownumbers:true,
		    		    collapsible: true,
		                fitColumns: true,
						loadMsg : "数据加载中,请稍等...",
					 	onBeforeLoad:function(row,param){
							if(row)
								$(this).treegrid('options').url='${ctx}/menu/getTreeList';
						}, 
						columns:[[
						             {title:'资源名', field:'name',width:280,align:'left'},
						             {title:'主键id', field:'id',width:60,align:'left'},
						             {title:'资源类型 0 菜单 1 方法 ', field:'menuType',width:50,align:'center',
						            	 formatter: function(value,row,index){
					    		        		if(value==0) return '菜单';
					    		        		if(value==1) return '按钮';
					    			 }},
						             {title:'链接地址', field:'url',width:200,align:'left'},
						             {title:'菜单权限', field:'permission',width:150,align:'center'},
						             {title:'序号', field:'sort',width:50,align:'center'},
						             {title:'资源图标', field:'icon',width:150,align:'center'},
						             {title:'深度', field:'level',width:50,align:'center'},
						             {title:'parentIds', field:'parentIds',width:200,align:'left',hidden:true}
						     
						        ]]
					 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/menu/'+url;
					var treeGrid = $('#tt').treegrid("getSelected");
					var menuType = $('#menuType').combobox('getValue');
					var parentId  = 0;
					var parentIds = 0;
					var level = 0;
					
					if(null!=treeGrid){
						parentId = treeGrid.id; 
						if(null!=treeGrid.parentIds)
							parentIds = treeGrid.parentIds+"/"+parentId;
						level = $('#tt').treegrid('getLevel',parentId);
					}
					if(url =="addMenu"){
						if(level>=3 && menuType==0){
	    				    $.messager.alert('提示','目前最多只能添加三级菜单!','info');
	    					return false;
	    				}
	    				if(level>=4 && menuType==1){
	    				    $.messager.alert('提示','目前最多只能添加四级方法级菜单!','info');
	    					return false;
	    				}
					}
					$('#level').val(level);
					$('#parentIds').val(parentIds);
					$('#parentId').val(parentId);
					// ajax form submit
					$('#menuForm').ajaxSubmit(options);
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
			  		var treeGrid = $('#tt').treegrid("getSelected");
					if($('#menuForm').form('validate')){
						pro();
						$('#menuDialog').dialog('close');
						return true;
					}else
						return false;
			  	};
		        function showResponse(responseText, statusText, xhr, $form) {
		        	hide();
		        	$.messager.alert('提示',eval(responseText), 'info');
		        	$('#tt').treegrid('reload');
		        	$('#tt').treegrid('clearSelections');
		        };
		        function showError(p1, $form) {
		        	hide();
		        	$('#menuDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMenuDialog(){
				$('#menuForm').form('clear');
			    var treeGrid = $('#tt').treegrid("getSelected");
		   	    if(null!=treeGrid){
				   $('#parentName').text(treeGrid.name);
				   var menuType = treeGrid.menuType;
			   	   if(null!=menuType && menuType==1){
		   	    	  $.messager.alert('提示',"请选择菜单进行添加！", 'info');
		   	    	  return;
		   	       }
		   	   	   $('#parentId').val(treeGrid.id);
			    }else{
			       $('#parentId').val(0);
				   $('#parentName').text('根目录');
			    }
		   	 
				$('#menuDialog').dialog('open');
				url = "addMenu";
			}
			// response,status,xhr
		    function updateMenuDialog(){
		    	url = "updateMenu";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].id;
	    		 	$.ajax({type:'GET',url:'${ctx}/menu/getMenuById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#menuForm').form('clear');
	    				  		$('#id').val(data.id);
	    				  		$('#parentId').val(data.parentId);
	    				  		$('#parentIds').val(data.parentIds);
	    				  		$('#name').val(data.name);
	    				  		$('#menuType').combobox('select',data.menuType);
	    				  		$('#url').val(data.url);
	    				  		$('#permission').val(data.permission);
	    				  		$('#sort').val(data.sort);
	    				  		$('#icon').val(data.icon);
	    				  		$('#target').val(data.target);
	    				  		$('#level').val(data.level);
	    				  		$('#desc').val(data.desc);
				    			$('#menuDialog').dialog('open');
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
		    function deleteMenu(){
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
	        			$.ajax({type:'GET',url:'${ctx}/menu/deleteMenu',data:{'param':arr.toString()},
	    	        	    success:function(text,status,xhr){
	    	        	    	$.messager.alert('提示',eval(xhr.responseText),'info');
	    	        	    	$('#tt').treegrid('clearSelections');
	    	        	    	$('#tt').treegrid('reload');
	    	        	    	hide();
	    	        	    },error:function(res){
	    	        	    	hide();
	    	        	    	$.messager.alert('提示',xhr.responseText,'warning');
	    	        	    },
	    	        	    dataType:'json'
	    	        	});
	        		}
	        	});
		    } 
		    //********************************************** 华丽分割线 ***************************************//
		</script>
	</body>
</html>