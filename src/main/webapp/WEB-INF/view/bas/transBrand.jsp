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
			    <li><a href="${ctx}/transBrand/toTransBrandPage">TransBrand</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<!-- <li>品牌ID:<input name="transBrandId" type="text" maxlength="30" id="transBrandId_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
				<li>品牌编号:<input name="transBrandCode" type="text" maxlength="30" id="transBrandCode_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>品牌名称:<input name="transBrandName" type="text" maxlength="30" id="transBrandName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<!-- <li>状态:<input name="state" type="text" maxlength="30" id="state_s" class="easyui-textbox" style="width:100px;" value=""/></li> -->
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="transBrand:add">
			 		     <li class="click" id="addTransBrand" onclick="javascript:addTransBrandDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="transBrand:update">
					 	<li class="click" id="updateTransBrand" onclick="javascript:updateTransBrandDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="transBrand:delete">
						<li class="click" id="deleteTransBrand"  onclick="javascript:deleteTransBrand();">
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
 		<div id="transBrandDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:370px;height:320px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="transBrandForm" method="post">
					<fieldset style="width:300px;height:200px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="transBrandId" name="transBrandId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>品牌编号<b>*</b></td><td><input id="transBrandCode" name="transBrandCode" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易品牌编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>品牌名称<b>*</b></td><td><input id="transBrandName" name="transBrandName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'交易品牌名称不能为空!'"></input></td>
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
                					 <td>品牌备注<b></b></td><td><input id="remark" name="remark" type="text" class="easyui-validatebox" data-options="required:false,missingMessage:'备注不能为空!'"></input></td>
									</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#transBrandDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/transBrand/getTransBrandPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             /* {title:'品牌ID', field:'transBrandId',width:50,align:'center'}, */
				             {title:'品牌编号', field:'transBrandCode',width:50,align:'center'},
				             {title:'品牌名称', field:'transBrandName',width:50,align:'center'},
				             {title:'启用状态', field:'state',width:50,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }	
				             },
				             {title:'品牌备注', field:'remark',width:50,align:'center'},
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改日期', field:'updateTime',width:50,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/transBrand/'+url;
					$('#transBrandForm').ajaxSubmit(options);
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
					if($('#transBrandForm').form('validate')){
						pro();
						$('#transBrandDialog').dialog('close');
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
		        	$('#transBrandDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addTransBrandDialog(){
				$('#transBrandForm').form('clear');
				$('#transBrandDialog').dialog('open');
				url = "addTransBrand";
			}
			// response,status,xhr
		    function updateTransBrandDialog(){
		    	url = "updateTransBrand";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].transBrandId;
	    		 	$.ajax({type:'GET',url:'${ctx}/transBrand/getTransBrandById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#transBrandForm').form('clear');
		    				  		$('#transBrandId').val(data.transBrandId);
		    				  		$('#transBrandCode').val(data.transBrandCode);
		    				  		$('#transBrandName').val(data.transBrandName);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#remark').val(data.remark);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
				    			$('#transBrandDialog').dialog('open');
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
		    function deleteTransBrand(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].transBrandId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/transBrand/deleteTransBrand',data:{'param':arr.toString()},
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
		    	var transBrandId = $("#transBrandId_s").val();
		    	var transBrandCode = $("#transBrandCode_s").val();
		    	var transBrandName = $("#transBrandName_s").val();
		    	var state = $("#state_s").val();
		    	var remark = $("#remark_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    $("#tt").datagrid('load',{
		    	   transBrandId:transBrandId,
		    	   transBrandCode:transBrandCode,
		    	   transBrandName:transBrandName,
		    	   state:state,
		    	   remark:remark,
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