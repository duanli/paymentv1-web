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
			    <li><a href="${ctx}/ralProductMerchant/toRalProductMerchantPage">子通道配置</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
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
			 		<shiro:hasPermission name="ralProductMerchant:add">
			 		     <li class="click" id="addRalProductMerchant" onclick="javascript:addRalProductMerchantDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="ralProductMerchant:update">
					 	<li class="click" id="updateRalProductMerchant" onclick="javascript:updateRalProductMerchantDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="ralProductMerchant:delete">
						<li class="click" id="deleteRalProductMerchant"  onclick="javascript:deleteRalProductMerchant();">
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
 		<div id="ralProductMerchantDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:350px;height:280px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="ralProductMerchantForm" method="post">
					<fieldset style="width:280px;height:160px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="ralMerProductId" name="ralMerProductId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td><input id="mchId" name="mchId" type="hidden" value="${mchId}"></input></td>
									</tr>
									<tr>
                					 <td>支付通道<b>*</b></td>
                					 <td>
                					 <input id="productId" name="productId" type="text" class="easyui-combobox" data-options="valueField:'productId',textField:'productName',url:'${ctx}/ralProviderTransMode/getRalProviderTransModeList?transModeId=${transModeId}&state=1',editable:false"></input>
                					 </td>
									</tr>
									<!-- <tr>
                					 <td>费率(单位:万分之)<b>*</b></td><td><input id="feeRate" name="feeRate" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'基准费率(单位:万分之)不能为空!'"></input></td>
									</tr> -->
									<!-- <tr>
                					 <td>每日限额<b>*</b></td><td><input id="totleAmtLimit" name="totleAmtLimit" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'每日限额不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>单笔最低额度<b>*</b></td><td><input id="minAmt" name="minAmt" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'单笔最低额度不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>单笔最高额度<b>*</b></td><td><input id="maxAmt" name="maxAmt" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'单笔最高额度不能为空!'"></input></td>
									</tr>
							 		 <td>有效起始时间<b>*</b></td><td><input id="beginTime" name="beginTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>有效截止时间<b>*</b></td><td><input id="endTime" name="endTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
									<tr> -->
									<tr>
                					 <td>权重(1~9)<b>*</b></td><td><input id="percentage" name="percentage" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'流量占比不能为空!'"></input></td>
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
                					 <td>限流状态0-停用；1-启用<b>*</b></td><td><input id="restrictState" name="restrictState" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'限流状态0-停用；1-启用不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>结算方式0-D0;1-D1;2-T0;3-T1<b>*</b></td><td><input id="settleType" name="settleType" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'结算方式0-D0;1-D1;2-T0;3-T1不能为空!'"></input></td>
									</tr> -->
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#ralProductMerchantDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/ralProductMerchant/getRalProductMerchantPage?transModeId=${transModeId}&mchId=${mchId}',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             /* {title:'商户交易方式Id', field:'ralMerProductId',width:50,align:'center'}, */
				             {title:'商户名称', field:'mchId',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.merchantInfo&&row.merchantInfo.mchName){
				     					return "<font color='blue'>"+row.merchantInfo.mchName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             {title:'交易通道', field:'productId',width:50,align:'center',
				            	 formatter: function(value,row,index){
				            		 if (row.ralProviderTransMode&&row.ralProviderTransMode.productName){
				     					return "<font color='blue'>"+row.ralProviderTransMode.productName+"</font>";
				     				} else {
				     					return "暂无";
				     				}
				            	 }	 
				             },
				             /* {title:'基准费率(单位:万分之)', field:'feeRate',width:50,align:'center'},
				             {title:'每日限额', field:'totleAmtLimit',width:50,align:'center'},
				             {title:'单笔最低额度', field:'minAmt',width:50,align:'center'},
				             {title:'单笔最高额度', field:'maxAmt',width:50,align:'center'},
				             {title:'有效起始时间', field:'beginTime',width:50,align:'center'},
				             {title:'有效截止时间', field:'endTime',width:50,align:'center'}, */
				             {title:'权重', field:'percentage',width:50,align:'center'},
				             {title:'状态 ', field:'state',width:20,align:'center',
				            	 formatter:function(value){
				            		 return value=='0'?"<font color='red'>停用</font>":value=='1'?"<font color='green'>启用</font>":value=='2'?'暂停':'未知';
				            	 }
				             },
				             /* {title:'是否删除', field:'isDel',width:50,align:'center'},
				             {title:'IP白名单', field:'validIP',width:50,align:'center'},
				             {title:'限流状态0-停用；1-启用', field:'restrictState',width:50,align:'center'},
				             {title:'结算方式0-D0;1-D1;2-T0;3-T1', field:'settleType',width:50,align:'center'} */
				             {title:'创建时间', field:'createTime',width:50,align:'center'},
				             {title:'修改时间', field:'updateTime',width:50,align:'center'}

						]]
				 });
			}
			var url=null;
			// 注册crud事件
			function regCRUDEvent(){
				// 表单提交（添加、更新）
				$('#submitFormBtn').click(function(e) {
					options.url = '${ctx}/ralProductMerchant/'+url;
					$('#ralProductMerchantForm').ajaxSubmit(options);
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
					if($('#ralProductMerchantForm').form('validate')){
						pro();
						$('#ralProductMerchantDialog').dialog('close');
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
		        	$('#ralProductMerchantDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addRalProductMerchantDialog(){
				$('#ralProductMerchantForm').form('clear');
				$('#ralProductMerchantDialog').dialog('open');
				url = "addRalProductMerchant";
				$('#mchId').val(${mchId});
			}
			// response,status,xhr
		    function updateRalProductMerchantDialog(){
		    	url = "updateRalProductMerchant";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].ralMerProductId;
	    		 	$.ajax({type:'GET',url:'${ctx}/ralProductMerchant/getRalProductMerchantById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#ralProductMerchantForm').form('clear');
		    				  		$('#ralMerProductId').val(data.ralMerProductId);
		    				  		$('#mchId').val(data.mchId);
		    				  		$('#productId').combobox('select',data.productId);
		    				  		$('#feeRate').val(data.feeRate);
		    				  		$('#totleAmtLimit').val(data.totleAmtLimit);
		    				  		$('#minAmt').val(data.minAmt);
		    				  		$('#maxAmt').val(data.maxAmt);
		    				  		$('#beginTime').val(data.beginTime);
		    				  		$('#endTime').val(data.endTime);
		    				  		$('#percentage').val(data.percentage);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
		    				  		$('#state').combobox('select',data.state);
		    				  		$('#isDel').val(data.isDel);
		    				  		$('#validIP').val(data.validIP);
		    				  		$('#restrictState').val(data.restrictState);
		    				  		$('#settleType').val(data.settleType);
				    			$('#ralProductMerchantDialog').dialog('open');
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
		    function deleteRalProductMerchant(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].ralMerProductId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/ralProductMerchant/deleteRalProductMerchant',data:{'param':arr.toString()},
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
		    	var ralMerProductId = $("#ralMerProductId_s").val();
		    	var mchId = $("#mchId_s").val();
		    	var productId = $("#productId_s").val();
		    	var feeRate = $("#feeRate_s").val();
		    	var totleAmtLimit = $("#totleAmtLimit_s").val();
		    	var minAmt = $("#minAmt_s").val();
		    	var maxAmt = $("#maxAmt_s").val();
		    	var beginTime = $("#beginTime_s").val();
		    	var endTime = $("#endTime_s").val();
		    	var percentage = $("#percentage_s").val();
		    	var createTime = $("#createTime_s").val();
		    	var updateTime = $("#updateTime_s").val();
		    	var state = $("#state_s").val();
		    	var isDel = $("#isDel_s").val();
		    	var validIP = $("#validIP_s").val();
		    	var restrictState = $("#restrictState_s").val();
		    	var settleType = $("#settleType_s").val();
		    $("#tt").datagrid('load',{
		    	   ralMerProductId:ralMerProductId,
		    	   mchId:mchId,
		    	   productId:productId,
		    	   feeRate:feeRate,
		    	   totleAmtLimit:totleAmtLimit,
		    	   minAmt:minAmt,
		    	   maxAmt:maxAmt,
		    	   beginTime:beginTime,
		    	   endTime:endTime,
		    	   percentage:percentage,
		    	   createTime:createTime,
		    	   updateTime:updateTime,
		    	   state:state,
		    	   isDel:isDel,
		    	   validIP:validIP,
		    	   restrictState:restrictState,
		    	   settleType:settleType,
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