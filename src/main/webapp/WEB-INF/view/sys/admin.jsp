<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../pages/taglibs.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>分销管理系统</title>
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
			    <li><a href="${ctx}/admin/toAdminPage">用户管理</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
			 	 <%-- <li>角色：
			 	 	<select id="role_s" style="width: 100px;height: 26px;">
			 	 		<option value="">请选择</option>
			 	 		<c:forEach items="${roleList }" var="role">
			 	 			<option value="${role.id }">${role.name }</option>
			 	 		</c:forEach>
			 	 	</select>
			 	 </li> --%>
			 	 <li>手机号：<input name="cellPhone" type="text" maxlength="30" id="cellPhone_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	 <li>用户姓名：<input name="name" type="text" maxlength="30" id="name_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	 <li>
			 	 	锁定状态：
			 	 	<select id="state_s" style="width: 100px;height: 26px;">
			 	 		<option value="">请选择</option>
			 	 		<option value="0">下线</option>
			 	 		<option value="1">在线</option>
			 	 		<option value="2">离开</option>
			 	 	</select>
			 	 </li>	
			 	 <li class="click" id="toStorePage" onclick="javascript:search();">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			 </li>	
			 	
			 		<shiro:hasPermission name="admin:add">
			 		     <li class="click" id="addAdmin" onclick="javascript:addAdminDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="admin:update">
					 	<li class="click" id="updateAdmin" onclick="javascript:updateAdminDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="admin:delete">
						<li class="click" id="deleteAdmin"  onclick="javascript:deleteAdmin();">
					 	 	<span><a href="#"><img src="${ctx}/images/t03.png"/></a></span>删除
				 	 	</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="admin:addAdminRole">
						<li class="click" id="addAdminRole" onclick="javascript:addAdminRoleDialog();">
				 	 		<span><a href="#"><img src="${ctx}/images/t05.png"/></a></span>分配角色
			 	 		</li>
					 </shiro:hasPermission>
			    </ul>
			</div>
		</div>
		<!-- grid -->
		<div>
			<table id="tt" style="width:1200px;height:420px"></table>
		</div>
		<!-- addAdminRole dialog -->
		<div id="addAdminRoleDialog" title="权限分配" class="easyui-dialog" closed="true"  style="width:630px;height:480px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#role_buttons">
			<div class="tab">
			   <table id="rt" style="width:580px;height:390px"></table>
			</div>
		</div>
		<!-- dialog -->
 		<div id="adminDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:890px;height:370px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="adminForm" method="post">
					<fieldset style="width:840px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
							<tr>
								<td><input id="id" name="id" type="hidden"/></td>
							</tr>
							<tr>
								<td>用户名<b>*</b></td><td><input id="userName" name="userName" class="easyui-validatebox" type="text"  data-options="required:true,missingMessage:'用户名不能为空!'"></input></td>
								<td>姓名</td><td><input id="name" name="name" type="text"></input></td>
								<%-- <td>机构<b>*</b></td><td><input id="orgId" name="orgId" type="text" class="easyui-combobox" data-options="valueField:'orgId',textField:'orgName',url:'${ctx}/organization/getOrganizationList',editable:false,required:false,missingMessage:'不能为空!',onSelect:OnSelectDepAdd"></input></td> --%>
							    <td>所属商户<b>*</b></td><td><input id="merId" name="merId" type="text" class="easyui-combobox" data-options="valueField:'mchId',textField:'mchName',url:'${ctx}/merchantInfo/getMerchantList',editable:false,required:false,missingMessage:'不能为空!'"></input></td>
							</tr>
							
							<tr>
								<!-- <td>商户<b>(选填)</b></td><td><input id="departmentId" name="departmentId" type="text" class="easyui-combobox" data-options="required:false,missingMessage:'部门不能为空!'"></input></td> -->
						    	<td>用户密码<b>*</b></td><td><input id="pswd"   name="pswd" class="easyui-validatebox" type="password"></input></td>
								<td>确认密码<b>*</b></td><td><input id="rePswd" name="rePswd" class="easyui-validatebox" type="password"></input></td>
								<!-- 	<td>职务</td><td><input id="duty" name="duty" type="text"></input></td> -->
							</tr>
							<tr>
						    	<td>是否锁定<b>*</b></td>
								<td>
									<input id="isLock"  name="locked" type="radio" value="0" style="vertical-align:middle;width:50px;"/>未锁定
									<input id="isLock1" name="locked" type="radio" value="1" style="vertical-align:middle;width:50px;"/>锁定
								</td>
								<td>性别
								<td>
									<select id="gender" class="easyui-combobox" name="gender" panelHeight="80" style="width:175px;" data-options="editable:false">
									    <option value="0">男</option>
									    <option value="1">女</option>
									    <option value="2">未知</option>
									</select>
							    </td>
								<td>手机号<b>*</b></td><td><input id="cellPhone" name="cellPhone" class="easyui-validatebox" type="text"  data-options="required:true,missingMessage:'用户手机号不能为空!'"></input></td>
							</tr>
							<tr>
								<td>详细信息<b>(选填)</b></td>
								<td colspan="8">
									<textarea id="accounts" name="accounts" rows="3" cols="95">
									</textarea>
								</td>
							</tr>
							<tr>
								<td>备注<b>(选填)</b></td>
								<td colspan="8">
									<textarea id="remark" name="remark" rows="3" cols="95">
									</textarea>
								</td>
							</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#adminDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<!-- dialog buttons -->
		<div id="role_buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="addAdminRole();">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#addAdminRoleDialog').dialog('close');">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
				$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/admin/getAdminPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
			                  {title:'登录名', field:'userName',width:50,align:'center'},
			                  /* {title:'用户类型', field:'type',width:50,align:'center',
			                	 formatter:function(value){
			                		 if(null !=value && value>=0){
			                		//0卖方1中介2业务员3权证人员（录入）4驻行人员5评估负责人6办抵押人员7财务8管理员
					            		var name = value=='0'?'卖方':value=='1'?'中介':value==2?'业务员':value==3?'权证人员':value==4?'驻行人员':value==5?'评估负责人':value==6?'办抵押人员':value==7?'财务':value==8?'管理员':'未知';
			                			return '<font color=green>'+name+'</font>'; 
			                		 }
				            	 }
			                  }, */
				             {title:'用户角色', field:'role',width:100,align:'center',
		                		 formatter:function(value,row,index){
				            		 var s = '';
				            		 if(null!=row && null!=row.roles){
				            			 var roles = row.roles
				            			 for(var r in roles){
				            				 var name =roles[r].name;
				            				 if(name)
					            				 s += name+';';
				            			 }
				            		 }
				            		 return s;
				            	 }
				             },
				             {title:'姓名', field:'name',width:50,align:'center'},
				             {title:'性别', field:'gender',width:30,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'男':value=='1'?'女':'未知';
				            	 }
				             },
				             {title:'用户手机号', field:'cellPhone',width:50,align:'center'},
				             {title:'邮箱', field:'email',width:50,align:'center'},
				             {title:'登陆状态', field:'state',width:30,align:'center',
				            	 formatter:function(value){
				            		return value=='0'?"<font color='red'>离线</font>":value==1?"<font color='green'>在线</font>":value==2?"<font color=''>离开</font>":"离线";
				            	 }
				             },
				             {title:'是否锁定', field:'locked',width:30,align:'center',
				            	 formatter:function(value){
				            		 return value==0?"<font color='green'>未锁定</font>":value==1?"<font color='red'>已锁定</font>":'未知';
				            	 }
				             },
				             {title:'登录次数', field:'loginCount',width:30,align:'center'},
				             {title:'最近活动时间', field:'lastActivity',width:70,align:'center',
       		                	 formatter:function(value){
 									if(value)
 										return $.formatDate(value);
 							     }	 
       		                 },
				             {title:'创建时间', field:'createDate',width:70,align:'center',
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
					options.url = '${ctx}/admin/'+url;
					$('#adminForm').ajaxSubmit(options);
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
			  		if(url=='addAdmin'){
						$('#pswd').validatebox({required: true,missingMessage: '请填写密码！'});
						$('#rePswd').validatebox({required: true,missingMessage: '请填写密码！',validType:'checkPswd'});
			  		}else{
			  			var pswd = $('#pswd').val();
			  			var rePswd = $('#rePswd').val();
			  			
			  			if(pswd.length>0 || rePswd.length>0){
			  				$('#pswd').validatebox({required: true,missingMessage: '请填写密码！'});
							$('#rePswd').validatebox({required: true,missingMessage: '请填写密码！',validType:'checkPswd'});
			  			}else{
			  				$('#pswd').validatebox({required: false});
			  				$('#rePswd').validatebox({required: false});
			  			}
			  		}
					if($('#adminForm').form('validate')){
						if(valiedateUserName()){
							$.messager.alert('提示','用户名已经存在!','warning');
							return false;
						}
						pro();
						$('#adminDialog').dialog('close');
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
		        	$('#adminDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addAdminDialog(){
				$('#adminForm').form('clear');
				$('#isLock').attr('checked','checked'); // 按钮初始化
				$('#adminDialog').dialog('open');
				$('#userName').attr('disabled',null);
				url = "addAdmin";
				$('#departmentId').combobox("enable");
			}
			// response,status,xhr
		    function updateAdminDialog(){
		    	url = "updateAdmin";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].id;
	    		 	$.ajax({type:'GET',url:'${ctx}/admin/getAdminById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#adminForm').form('clear');
			    		  		$('#id').val(data.id);
	    				  		$('#userName').val(data.userName);
	    				  		$('#name').val(data.name);
	    				  		$('#gender').combobox('select',data.gender);
	    				  		$('#cellPhone').val(data.cellPhone);
	    				  		$('#merId').combobox('select',data.merId);
	    				  		/* $('#departmentId').combobox('select',data.departmentId);
	    				  		$('#departmentId').combobox("enable"); */
	    				  		/* if(null != data.roles){
	    				  			var roles = data.roles;
	    				  			for(var r in roles){
	    								if('28'==roles[r].id){
	    									$('#departmentId').combobox("disable");
	    								}
	    							}
	    				  		} */
	    				  		$('#duty').val(data.duty);
	    				  		var locked = data.locked;
	    				  		if(!locked)
	    				  			$('#isLock').attr('checked','checked'); 
	    				  		else
	    				  			$('#isLock1').attr('checked','checked');
	    				  		$('#remark').val(data.remark);
	    				  		$('#userName').attr("readOnly",true);
				    			$('#adminDialog').dialog('open');
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
		    function deleteAdmin(){
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
	        			$.ajax({type:'GET',url:'${ctx}/admin/deleteAdmin',data:{'param':arr.toString()},
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
		        // 自定义密码验证
		  	$.extend($.fn.validatebox.defaults.rules, {
			  checkPswd:{
			   validator: function(value,param){
				   var pswd   = $('#pswd').val();
				   var rePswd = $('#rePswd').val();
				  // if(url =='addAdmin'){
					   if(!pswd || !rePswd)
						   return false;
				  // }
	               	if(pswd !=rePswd)
	               		return false;
	               	return true;
			   },
			   message: '两次密码必须输入一致!'
			  }
		  	});
		  	function valiedateUserName(){
		  		var userName = $('#userName').val();
		    	var exists = false;
		    	if(url =='addAdmin'){
		    		   // 检查用户名是否重复
				    $.ajax({type:'GET',url:'${ctx}/admin/checkAdminUserExists',data:{'userName':userName,'r':Math.random()},
		        	    success:function(text,status,xhr){
		        	    	exists = false;
		        	    },error:function(res){
		        	    	exists = true;
		        	    },
		        	    dataType:'json',async:false
			        });
		    	}
		    	return exists;
		  	}
		    // 权限分配
		    function addAdminRoleDialog(){
		    	var uk = $('#tt').datagrid('getChecked');
		    	if(uk ==null || uk.length<1){
		    		$.messager.alert('提示','请选择用户!','warning');
		      		return ;
		    	}
			   	 $('#rt').datagrid({
						url:'${ctx}/role/getRolePage',
						idField : "id",
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'主键', field:'id',width:50,align:'center'},
				             {title:'角色名称', field:'name',width:80,align:'center'},
				             {title:'英文名称', field:'enName',width:80,align:'center'},
				             {title:'角色描述', field:'remark',width:80,align:'center'}
						]]
				 });
			   	$('#addAdminRoleDialog').dialog('open');
		    }
		    // 添加角色数据
		    function addAdminRole(){
		    	var uk = $('#tt').datagrid('getChecked');
		    	var rk = $('#rt').datagrid('getChecked');
		    	var users = new Array();
		    	var roles = new Array();
		    	
		    	if(uk ==null || uk.length<1){
		    		$.messager.alert('提示','请选择用户!','warning');
		      		return ;
		    	}
				if(rk ==null || rk.length<1){
					$.messager.alert('提示','请选择角色!','warning');
		      		return ;
		    	}
				for(var u in uk){
					users[u] = uk[u].id;
				}
				for(var r in rk){
					roles[r] = rk[r].id;
				}
				pro();
				$.ajax({type:'POST',url:'${ctx}/admin/addAdminRole',data:{'users':users.toString(),'roles':roles.toString()},
	        	    success:function(text,status,xhr){
	        	    	$.messager.alert('提示',eval(xhr.responseText),'info');
	        	    	$('#tt').datagrid('clearSelections');
	        	    	$('#tt').datagrid('reload');
	        	    	$('#rt').datagrid('clearSelections');
	        	    	$('#addAdminRoleDialog').dialog('close');
	        	    	hide();
	        	    },error:function(res){
	        	    	hide();
	        	    	$.messager.alert('提示',eval(res.responseText),'warning');
	        	    },
	        	    dataType:'json'
	        	});
		    }
		    //查询方法
		    function search(){
		    	var role = $("#role_s").val();
		    	var cellPhone = $("#cellPhone_s").val();
		    	var name = $("#name_s").val();
		    	var state = $("#state_s").val();
		    	$("#tt").datagrid('load',{
		    		state:state,
		    		name:name,
		    		cellPhone:cellPhone,
// 		    		roleId:role
		    		reserved1:role
		    	})
		    }
		    function OnSelectDep(param) {
				/*    var orgId = $("#orgId_s").combobox('getValue')   */
						var orgId = param.orgId;
						$('#departmentId_s')
								.combobox(
										{
											url : '${ctx}/department/getDepartmentList?orgId='
													+ orgId,
													valueField:'departmentId',
													textField:'departmentName'
										});

				}
			   
			   	function OnSelectDepAdd(param) {
					/*    var orgId = $("#orgId_s").combobox('getValue')   */
							var orgId = param.orgId;
							$('#departmentId')
									.combobox(
											{
												url : '${ctx}/department/getDepartmentList?orgId='
														+ orgId,
														valueField:'departmentId',
														textField:'departmentName'
											});

					}
			   	
		</script>
	</body>
</html>