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
			    <li><a href="${ctx}/merchantAgent/toMerchantAgentPage">商户代理</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<!-- <li>商户交易方式Id:<input name="id" type="text" maxlength="30" id="id_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<li>代理编号:<input name="orgNo" type="text" maxlength="30" id="orgNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>代理名称:<input name="orgName" type="text" maxlength="30" id="orgName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<!-- <li>代理描述:<input name="orgDesc" type="text" maxlength="30" id="orgDesc_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
			 	<!-- <li>创建时间:<input name="createTime" type="text" maxlength="30" id="createTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
			 	<li>修改时间:<input name="updateTime" type="text" maxlength="30" id="updateTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li> -->
				<li>启用状态:
					<select id="state_s" style="width: 100px;height: 26px;">
				 	 		<option value="">全部</option>
				 	 		<option value="0">停用</option>
							<option value="1">启用</option>
							<option value="2">暂停</option>
				 	</select>
				</li>
				<!-- <li>是否删除:<input name="isDel" type="text" maxlength="30" id="isDel_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="merchantAgent:add">
			 		     <li class="click" id="addMerchantAgent" onclick="javascript:addMerchantAgentDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="merchantAgent:update">
					 	<li class="click" id="updateMerchantAgent" onclick="javascript:updateMerchantAgentDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="merchantAgent:delete">
						<li class="click" id="deleteMerchantAgent"  onclick="javascript:deleteMerchantAgent();">
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
 		<div id="merchantAgentDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:370px;height:360px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="merchantAgentForm" method="post">
					<fieldset style="width:300px;height:230px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="id" name="id" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>代理编号<b>*</b></td><td><input id="orgNo" name="orgNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>代理名称<b>*</b></td><td><input id="orgName" name="orgName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'账户不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>代理描述<b></b></td><td><input id="orgDesc" name="orgDesc" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'服务商交易方式不能为空!'"></input></td>
									<!-- </tr>
							 		 <td>创建时间<b>*</b></td><td><input id="createTime" name="createTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>修改时间<b>*</b></td><td><input id="updateTime" name="updateTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
									<tr> -->
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
									<!-- <tr>
                					 <td>是否删除<b>*</b></td><td><input id="isDel" name="isDel" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'是否删除不能为空!'"></input></td>
									</tr> -->
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#merchantAgentDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/merchantAgent/getMerchantAgentPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				            /*  {title:'商户交易方式Id', field:'id',width:50,align:'center'}, */
				             {title:'代理编号', field:'orgNo',width:50,align:'center'},
				             {title:'代理名称', field:'orgName',width:50,align:'center'},
				             {title:'代理描述', field:'orgDesc',width:50,align:'center'},
				             {title:'创建时间', field:'createTime',width:50,align:'center',
				            	 formatter:function(value){
	 									if(value)
	 										return $.formatDate(value);
	 							 }
				             },
				             {title:'修改时间', field:'updateTime',width:50,align:'center',
				            	 formatter:function(value){
	 									if(value)
	 										return $.formatDate(value);
	 							 }
				             },
				             {title:'启用状态', field:'state',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'停用':value=='1'?'启用':value=='2'?'暂停':'未知';
				            	 }	
				             },
				             {title:'是否删除', field:'isDel',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?'正常':value=='1'?'已删除':'未知';
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
					options.url = '${ctx}/merchantAgent/'+url;
					$('#merchantAgentForm').ajaxSubmit(options);
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
					if($('#merchantAgentForm').form('validate')){
						pro();
						$('#merchantAgentDialog').dialog('close');
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
		        	$('#merchantAgentDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMerchantAgentDialog(){
				$('#merchantAgentForm').form('clear');
				$('#merchantAgentDialog').dialog('open');
				url = "addMerchantAgent";
			}
			// response,status,xhr
		    function updateMerchantAgentDialog(){
		    	url = "updateMerchantAgent";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].id;
	    		 	$.ajax({type:'GET',url:'${ctx}/merchantAgent/getMerchantAgentById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#merchantAgentForm').form('clear');
		    				  		$('#id').val(data.id);
		    				  		$('#orgNo').val(data.orgNo);
		    				  		$('#orgName').val(data.orgName);
		    				  		$('#orgDesc').val(data.orgDesc);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#isDel').combobox('select',data.isDel);
				    			$('#merchantAgentDialog').dialog('open');
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
		    function deleteMerchantAgent(){
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
	        			$.ajax({type:'GET',url:'${ctx}/merchantAgent/deleteMerchantAgent',data:{'param':arr.toString()},
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
		    	var orgName = $("#orgName_s").val();
		    	var orgDesc = $("#orgDesc_s").val();
		    /* 	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val(); */
		    	var state = $("#state_s").val();
		    	var isDel = $("#isDel_s").val();
		    $("#tt").datagrid('load',{
		    	   id:id,
		    	   orgNo:orgNo,
		    	   orgName:orgName,
		    	   orgDesc:orgDesc,
		    	  /*  createTime:createTime,
		    	   updateTime:updateTime, */
		    	   state:state,
		    	   isDel:isDel,
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