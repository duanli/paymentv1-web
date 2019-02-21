<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../../pages/taglibs.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>ststt</title>
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
			    <li><a href="${ctx}/area/toAreaPage">mark</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>主键id:<input name="id" type="text" maxlength="30" id="id_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>区域编码:<input name="code" type="text" maxlength="30" id="code_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>区域名称:<input name="name" type="text" maxlength="30" id="name_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>父编码:<input name="parentCode" type="text" maxlength="30" id="parentCode_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>简称:<input name="shortName" type="text" maxlength="30" id="shortName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>区域等级0-国家；1-省；2-市；3-区:<input name="levelType" type="text" maxlength="30" id="levelType_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>区号:<input name="cityNum" type="text" maxlength="30" id="cityNum_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>邮编:<input name="zipCode" type="text" maxlength="30" id="zipCode_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>关键词:<input name="mergerName" type="text" maxlength="30" id="mergerName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>拼音:<input name="pingyin" type="text" maxlength="30" id="pingyin_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="area:add">
			 		     <li class="click" id="addArea" onclick="javascript:addAreaDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="area:update">
					 	<li class="click" id="updateArea" onclick="javascript:updateAreaDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="area:delete">
						<li class="click" id="deleteArea"  onclick="javascript:deleteArea();">
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
 		<div id="areaDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:830px;height:560px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="areaForm" method="post">
					<fieldset style="width:800px;height:530px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
									<tr>
										<td><input id="id" name="id" type="hidden"/></td>
									</tr>
									<tr>
                						<td>区域编码<b>*</b></td><td><input id="code" name="code" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'区域编码不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>区域名称<b>*</b></td><td><input id="name" name="name" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'区域名称不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>父编码<b>*</b></td><td><input id="parentCode" name="parentCode" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'父编码不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>简称<b>*</b></td><td><input id="shortName" name="shortName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'简称不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>区域等级0-国家；1-省；2-市；3-区<b>*</b></td><td><input id="levelType" name="levelType" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'区域等级0-国家；1-省；2-市；3-区不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>区号<b>*</b></td><td><input id="cityNum" name="cityNum" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'区号不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>邮编<b>*</b></td><td><input id="zipCode" name="zipCode" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'邮编不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>关键词<b>*</b></td><td><input id="mergerName" name="mergerName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'关键词不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>经度<b>*</b></td><td><input id="lng" name="lng" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'经度不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>纬度<b>*</b></td><td><input id="lat" name="lat" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'纬度不能为空!'"></input></td>
									</tr>
									<tr>
                						<td>拼音<b>*</b></td><td><input id="pingyin" name="pingyin" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'拼音不能为空!'"></input></td>
									</tr>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#areaDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/area/getAreaPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'主键id', field:'id',width:50,align:'center'},
				             {title:'区域编码', field:'code',width:50,align:'center'},
				             {title:'区域名称', field:'name',width:50,align:'center'},
				             {title:'父编码', field:'parentCode',width:50,align:'center'},
				             {title:'简称', field:'shortName',width:50,align:'center'},
				             {title:'区域等级0-国家；1-省；2-市；3-区', field:'levelType',width:50,align:'center'},
				             {title:'区号', field:'cityNum',width:50,align:'center'},
				             {title:'邮编', field:'zipCode',width:50,align:'center'},
				             {title:'关键词', field:'mergerName',width:50,align:'center'},
				             {title:'经度', field:'lng',width:50,align:'center'},
				             {title:'纬度', field:'lat',width:50,align:'center'},
				             {title:'拼音', field:'pingyin',width:50,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/area/'+url;
					$('#areaForm').ajaxSubmit(options);
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
					if($('#areaForm').form('validate')){
						pro();
						$('#areaDialog').dialog('close');
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
		        	$('#areaDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addAreaDialog(){
				$('#areaForm').form('clear');
				$('#areaDialog').dialog('open');
				url = "addArea";
			}
			// response,status,xhr
		    function updateAreaDialog(){
		    	url = "updateArea";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].id;
	    		 	$.ajax({type:'GET',url:'${ctx}/area/getAreaById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#areaForm').form('clear');
		    				  		$('#id').val(data.id);
		    				  		$('#code').val(data.code);
		    				  		$('#name').val(data.name);
		    				  		$('#parentCode').val(data.parentCode);
		    				  		$('#shortName').val(data.shortName);
		    				  		$('#levelType').val(data.levelType);
		    				  		$('#cityNum').val(data.cityNum);
		    				  		$('#zipCode').val(data.zipCode);
		    				  		$('#mergerName').val(data.mergerName);
		    				  		$('#lng').val(data.lng);
		    				  		$('#lat').val(data.lat);
		    				  		$('#pingyin').val(data.pingyin);
				    			$('#areaDialog').dialog('open');
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
		    function deleteArea(){
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
	        			$.ajax({type:'GET',url:'${ctx}/area/deleteArea',data:{'param':arr.toString()},
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
		    	var code = $("#code_s").val();
		    	var name = $("#name_s").val();
		    	var parentCode = $("#parentCode_s").val();
		    	var shortName = $("#shortName_s").val();
		    	var levelType = $("#levelType_s").val();
		    	var cityNum = $("#cityNum_s").val();
		    	var zipCode = $("#zipCode_s").val();
		    	var mergerName = $("#mergerName_s").val();
		    	var lng = $("#lng_s").val();
		    	var lat = $("#lat_s").val();
		    	var pingyin = $("#pingyin_s").val();
		    $("#tt").datagrid('load',{
		    	   id:id,
		    	   code:code,
		    	   name:name,
		    	   parentCode:parentCode,
		    	   shortName:shortName,
		    	   levelType:levelType,
		    	   cityNum:cityNum,
		    	   zipCode:zipCode,
		    	   mergerName:mergerName,
		    	   lng:lng,
		    	   lat:lat,
		    	   pingyin:pingyin,
		    	})
		    }
		    //********************************************** 华丽分割线 ***************************************//
		</script>
	</body>
</html>