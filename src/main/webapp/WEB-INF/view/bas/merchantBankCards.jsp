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
		li{background:url(${ctx}/images/toolbg.gif) repeat-x; line-height:33px; height:33px; float:left; padding-right:10px; margin-right:5px;border-radius: 3px; behavior:url(${ctx}/js/pie.htc); cursor:pointer;}
	  	a{text-decoration: none;color:black;}
	  	</style>
	</head>
	<body>
		<div class="place">
			<span>位置：</span>
		    <ul class="placeul">
			    <li><a href="#">首页</a></li>
			    <li><a href="${ctx}/merchantBankCards/toMerchantBankCardsPage">MerchantBankCards</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>银行卡主键:<input name="bankCardId" type="text" maxlength="30" id="bankCardId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>商户主键ID:<input name="mchId" type="text" maxlength="30" id="mchId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>卡用途0-结算1-代付2-代扣:<input name="useType" type="text" maxlength="30" id="useType_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>银行编码:<input name="bankCode" type="text" maxlength="30" id="bankCode_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>银行账户所属银行名:<input name="bankName" type="text" maxlength="30" id="bankName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>银行账户类型 0-公 1-私:<input name="bankAccType" type="text" maxlength="30" id="bankAccType_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>卡类型：借记卡、贷记卡:<input name="bankCardType" type="text" maxlength="30" id="bankCardType_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>银行账户绑定的银行卡预留手机号:<input name="bankReservedPhone" type="text" maxlength="30" id="bankReservedPhone_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>银行卡号:<input name="bankCardNo" type="text" maxlength="30" id="bankCardNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>开户省份编号:<input name="bankProvince" type="text" maxlength="30" id="bankProvince_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>开户城市:<input name="bankCity" type="text" maxlength="30" id="bankCity_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>联行号:<input name="bankLineNo" type="text" maxlength="30" id="bankLineNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>支行名称:<input name="subBankName" type="text" maxlength="30" id="subBankName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>身份证号:<input name="idCardNo" type="text" maxlength="30" id="idCardNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>真实姓名:<input name="realName" type="text" maxlength="30" id="realName_s" class="easyui-textbox" style="width:100px;" value=""/></li>
				<li>状态0-未启用;1-启用2-暂停:<input name="state" type="text" maxlength="30" id="state_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	<li>创建时间:<input name="createTime" type="text" maxlength="30" id="createTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
			 	<li>更新时间:<input name="updateTime" type="text" maxlength="30" id="updateTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="merchantBankCards:add">
			 		     <li class="click" id="addMerchantBankCards" onclick="javascript:addMerchantBankCardsDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="merchantBankCards:update">
					 	<li class="click" id="updateMerchantBankCards" onclick="javascript:updateMerchantBankCardsDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="merchantBankCards:delete">
						<li class="click" id="deleteMerchantBankCards"  onclick="javascript:deleteMerchantBankCards();">
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
 		<div id="merchantBankCardsDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:830px;height:560px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="merchantBankCardsForm" method="post">
					<fieldset style="width:800px;height:530px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="bankCardId" name="bankCardId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>商户主键ID<b>*</b></td><td><input id="mchId" name="mchId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户主键ID不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>卡用途0-结算1-代付2-代扣<b>*</b></td><td><input id="useType" name="useType" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'卡用途0-结算1-代付2-代扣不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>银行编码<b>*</b></td><td><input id="bankCode" name="bankCode" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'银行编码不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>银行账户所属银行名<b>*</b></td><td><input id="bankName" name="bankName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'银行账户所属银行名不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>银行账户类型 0-公 1-私<b>*</b></td><td><input id="bankAccType" name="bankAccType" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'银行账户类型 0-公 1-私不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>卡类型：借记卡、贷记卡<b>*</b></td><td><input id="bankCardType" name="bankCardType" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'卡类型：借记卡、贷记卡不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>银行账户绑定的银行卡预留手机号<b>*</b></td><td><input id="bankReservedPhone" name="bankReservedPhone" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'银行账户绑定的银行卡预留手机号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>银行卡号<b>*</b></td><td><input id="bankCardNo" name="bankCardNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'银行卡号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>开户省份编号<b>*</b></td><td><input id="bankProvince" name="bankProvince" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'开户省份编号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>开户城市<b>*</b></td><td><input id="bankCity" name="bankCity" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'开户城市不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>联行号<b>*</b></td><td><input id="bankLineNo" name="bankLineNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'联行号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>支行名称<b>*</b></td><td><input id="subBankName" name="subBankName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'支行名称不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>身份证号<b>*</b></td><td><input id="idCardNo" name="idCardNo" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'身份证号不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>真实姓名<b>*</b></td><td><input id="realName" name="realName" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'真实姓名不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>状态0-未启用;1-启用2-暂停<b>*</b></td><td><input id="state" name="state" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'状态0-未启用;1-启用2-暂停不能为空!'"></input></td>
									</tr>
							 		 <td>创建时间<b>*</b></td><td><input id="createTime" name="createTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>更新时间<b>*</b></td><td><input id="updateTime" name="updateTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#merchantBankCardsDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/merchantBankCards/getMerchantBankCardsPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'银行卡主键', field:'bankCardId',width:50,align:'center'},
				             {title:'商户主键ID', field:'mchId',width:50,align:'center'},
				             {title:'卡用途0-结算1-代付2-代扣', field:'useType',width:50,align:'center'},
				             {title:'银行编码', field:'bankCode',width:50,align:'center'},
				             {title:'银行账户所属银行名', field:'bankName',width:50,align:'center'},
				             {title:'银行账户类型 0-公 1-私', field:'bankAccType',width:50,align:'center'},
				             {title:'卡类型：借记卡、贷记卡', field:'bankCardType',width:50,align:'center'},
				             {title:'银行账户绑定的银行卡预留手机号', field:'bankReservedPhone',width:50,align:'center'},
				             {title:'银行卡号', field:'bankCardNo',width:50,align:'center'},
				             {title:'开户省份编号', field:'bankProvince',width:50,align:'center'},
				             {title:'开户城市', field:'bankCity',width:50,align:'center'},
				             {title:'联行号', field:'bankLineNo',width:50,align:'center'},
				             {title:'支行名称', field:'subBankName',width:50,align:'center'},
				             {title:'身份证号', field:'idCardNo',width:50,align:'center'},
				             {title:'真实姓名', field:'realName',width:50,align:'center'},
				             {title:'状态0-未启用;1-启用2-暂停', field:'state',width:50,align:'center'},
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'更新时间', field:'updateTime',width:50,align:'center'}
						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/merchantBankCards/'+url;
					$('#merchantBankCardsForm').ajaxSubmit(options);
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
					if($('#merchantBankCardsForm').form('validate')){
						pro();
						$('#merchantBankCardsDialog').dialog('close');
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
		        	$('#merchantBankCardsDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMerchantBankCardsDialog(){
				$('#merchantBankCardsForm').form('clear');
				$('#merchantBankCardsDialog').dialog('open');
				url = "addMerchantBankCards";
			}
			// response,status,xhr
		    function updateMerchantBankCardsDialog(){
		    	url = "updateMerchantBankCards";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].bankCardId;
	    		 	$.ajax({type:'GET',url:'${ctx}/merchantBankCards/getMerchantBankCardsById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#merchantBankCardsForm').form('clear');
		    				  		$('#bankCardId').val(data.bankCardId);
		    				  		$('#mchId').val(data.mchId);
		    				  		$('#useType').val(data.useType);
		    				  		$('#bankCode').val(data.bankCode);
		    				  		$('#bankName').val(data.bankName);
		    				  		$('#bankAccType').val(data.bankAccType);
		    				  		$('#bankCardType').val(data.bankCardType);
		    				  		$('#bankReservedPhone').val(data.bankReservedPhone);
		    				  		$('#bankCardNo').val(data.bankCardNo);
		    				  		$('#bankProvince').val(data.bankProvince);
		    				  		$('#bankCity').val(data.bankCity);
		    				  		$('#bankLineNo').val(data.bankLineNo);
		    				  		$('#subBankName').val(data.subBankName);
		    				  		$('#idCardNo').val(data.idCardNo);
		    				  		$('#realName').val(data.realName);
		    				  		$('#state').val(data.state);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
				    			$('#merchantBankCardsDialog').dialog('open');
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
		    function deleteMerchantBankCards(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].bankCardId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/merchantBankCards/deleteMerchantBankCards',data:{'param':arr.toString()},
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
		    	var bankCardId = $("#bankCardId_s").val();
		    	var mchId = $("#mchId_s").val();
		    	var useType = $("#useType_s").val();
		    	var bankCode = $("#bankCode_s").val();
		    	var bankName = $("#bankName_s").val();
		    	var bankAccType = $("#bankAccType_s").val();
		    	var bankCardType = $("#bankCardType_s").val();
		    	var bankReservedPhone = $("#bankReservedPhone_s").val();
		    	var bankCardNo = $("#bankCardNo_s").val();
		    	var bankProvince = $("#bankProvince_s").val();
		    	var bankCity = $("#bankCity_s").val();
		    	var bankLineNo = $("#bankLineNo_s").val();
		    	var subBankName = $("#subBankName_s").val();
		    	var idCardNo = $("#idCardNo_s").val();
		    	var realName = $("#realName_s").val();
		    	var state = $("#state_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    $("#tt").datagrid('load',{
		    	   bankCardId:bankCardId,
		    	   mchId:mchId,
		    	   useType:useType,
		    	   bankCode:bankCode,
		    	   bankName:bankName,
		    	   bankAccType:bankAccType,
		    	   bankCardType:bankCardType,
		    	   bankReservedPhone:bankReservedPhone,
		    	   bankCardNo:bankCardNo,
		    	   bankProvince:bankProvince,
		    	   bankCity:bankCity,
		    	   bankLineNo:bankLineNo,
		    	   subBankName:subBankName,
		    	   idCardNo:idCardNo,
		    	   realName:realName,
		    	   state:state,
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