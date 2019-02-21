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
			    <li><a href="${ctx}/merchantStatisticsMouth/toMerchantStatisticsMouthPage">月统计</a></li>
		    </ul>
		</div>
		<!-- buttons -->
		<div class="rightinfo">
			<div style="margin:1px 5px 5px 1px;float: left;">
			 	<ul >
				<li>商户名称:<input name="mchName" type="text" maxlength="30" id="mchId_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	<li>商户编号:<input name="mchNo" type="text" maxlength="30" id="mchNo_s" class="easyui-textbox" style="width:100px;" value=""/></li>
			 	<li>查询月份:<input name="beginTime" type="text" maxlength="30" id="beginTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li>
			 	<!-- <li>截止时间:<input name="endTime" type="text" maxlength="30" id="endTime_s" class="easyui-datebox" data-options="formatter:formatter" style="width:100px;" value=""/></li> -->
			 	<li class="click" id="toStorePage" onclick="javascript:search();" style="border:solid 1px #d3dbde;">
    				 <a href="#">
    					 <span style="display: block;float: left;margin: 5px;">
    						 <img src="${ctx}/images/ico06.png" style="width: 24px;height:24px;"/>
    					 </span>
    					 搜索
    				 </a>
    			</li>
			 		<shiro:hasPermission name="merchantStatisticsMouth:add">
			 		     <li class="click" id="addMerchantStatisticsMouth" onclick="javascript:addMerchantStatisticsMouthDialog();">
				     		<span><a href="#"><img src="${ctx}/images/t01.png"/></a></span>新增
			     		</li>  
					</shiro:hasPermission>   
					<shiro:hasPermission name="merchantStatisticsMouth:update">
					 	<li class="click" id="updateMerchantStatisticsMouth" onclick="javascript:updateMerchantStatisticsMouthDialog();">
			 	 			<span><a href="#"><img src="${ctx}/images/t02.png"/></a></span>编辑
		 	 			</li>
					</shiro:hasPermission>
					<shiro:hasPermission name="merchantStatisticsMouth:delete">
						<li class="click" id="deleteMerchantStatisticsMouth"  onclick="javascript:deleteMerchantStatisticsMouth();">
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
 		<div id="merchantStatisticsMouthDialog" title="操作菜单" class="easyui-dialog" closed="true"  style="width:830px;height:560px;padding:10px" data-options="iconCls:'icon-save',modal:true" buttons="#dialog_buttons">
			<div class="tab">
 				<form class="easyui-form" id="merchantStatisticsMouthForm" method="post">
					<fieldset style="width:800px;height:530px">
 						<legend>带<b>*</b>为必填项</legend>
 						<table border="0">
								    <tr>
									 <td><input id="sdId" name="sdId" type="hidden"/></td>
								    </tr>
									<tr>
                					 <td>商户主键ID<b>*</b></td><td><input id="mchId" name="mchId" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'商户主键ID不能为空!'"></input></td>
									</tr>
							 		 <td>统计日期<b>*</b></td><td><input id="sdMouth" name="sdMouth" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
									<tr>
                					 <td>总支付笔数<b>*</b></td><td><input id="payCountTotal" name="payCountTotal" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'总支付笔数不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>总支付金额<b>*</b></td><td><input id="payAmountTotal" name="payAmountTotal" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'总支付金额不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>成功总笔数<b>*</b></td><td><input id="payCountSucc" name="payCountSucc" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'成功总笔数不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>成功总金额<b>*</b></td><td><input id="payAmountSucc" name="payAmountSucc" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'成功总金额不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>净入金额<b>*</b></td><td><input id="realAmount" name="realAmount" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'净入金额不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>手续费<b>*</b></td><td><input id="totleFee" name="totleFee" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'手续费不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>退款总笔数<b>*</b></td><td><input id="refundCount" name="refundCount" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'退款总笔数不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>退款总金额<b>*</b></td><td><input id="refundAmount" name="refundAmount" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'退款总金额不能为空!'"></input></td>
									</tr>
									<tr>
                					 <td>状态 0-停用 1-启用 2-暂停<b>*</b></td><td><input id="state" name="state" type="text" class="easyui-validatebox" data-options="required:true,missingMessage:'状态 0-停用 1-启用 2-暂停不能为空!'"></input></td>
									</tr>
							 		 <td>创建时间<b>*</b></td><td><input id="createTime" name="createTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
							 		 <td>修改时间<b>*</b></td><td><input id="updateTime" name="updateTime" type="text" class="easyui-datebox" data-options="formatter:formatter"></input></td>
 						</table>
 					</fieldset>
 				</form>
			</div>
		</div>
		<!-- dialog bbuttons -->
		<div id="dialog_buttons">
			<a href="javascript:void(0)" id="submitFormBtn" class="easyui-linkbutton " iconCls="icon-ok"  style="width:70px;height:30px;">提交</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="$('#merchantStatisticsMouthDialog').dialog('close');" style="width:70px;height:30px;">关闭</a>
		</div>
		<script type="text/javascript">
			$(function(){
			$("#tt").css("width",$(window).width());
	        	initGrid();
	        	regCRUDEvent();
			});
			function initGrid(){
				 $('#tt').datagrid({
						url:'${ctx}/merchantStatisticsMouth/getMerchantStatisticsMouthPage',
						pagination:true,
						rownumbers : true,
						fitColumns : true,
						collapsible : true,
						autoRowHeight : true,
						loadMsg : "数据加载中,请稍等...",
						frozenColumns : [[{field : 'ck',checkbox : true}]],
						columns:[[
				             {title:'商户名称', field:'mchId',width:50,align:'center'},
				             {title:'统计日期', field:'sdMouth',width:50,align:'center'},
				             {title:'总支付笔数', field:'payCountTotal',width:50,align:'center'},
				             {title:'总支付金额', field:'payAmountTotal',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }
				             },
				             {title:'成功总笔数', field:'payCountSucc',width:50,align:'center'},
				             {title:'成功总金额', field:'payAmountSucc',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 
				             },
				             {title:'净入金额', field:'realAmount',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 
				             },
				             {title:'手续费', field:'totleFee',width:50,align:'center',
				            	 formatter: function (value) {  
				                     if (value) {  
				                         return "<font color='red'>"+parseFloat(value/100).toFixed(2)+"</font>"  
				                     }else {  
				                         return value;  
				                     }  
				            	 }	 
				             },
				            /*  {title:'退款总笔数', field:'refundCount',width:50,align:'center'},
				             {title:'退款总金额', field:'refundAmount',width:50,align:'center'}, */
				            /*  {title:'状态 0-停用 1-启用 2-暂停', field:'state',width:50,align:'center'}, */
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
					options.url = '${ctx}/merchantStatisticsMouth/'+url;
					$('#merchantStatisticsMouthForm').ajaxSubmit(options);
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
					if($('#merchantStatisticsMouthForm').form('validate')){
						pro();
						$('#merchantStatisticsMouthDialog').dialog('close');
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
		        	$('#merchantStatisticsMouthDialog').dialog('open');
		        	$.messager.alert('提示',eval(p1.responseText), 'info');
		        };
			}
			
			function addMerchantStatisticsMouthDialog(){
				$('#merchantStatisticsMouthForm').form('clear');
				$('#merchantStatisticsMouthDialog').dialog('open');
				url = "addMerchantStatisticsMouth";
			}
			// response,status,xhr
		    function updateMerchantStatisticsMouthDialog(){
		    	url = "updateMerchantStatisticsMouth";
		    	var chks= $('#tt').datagrid('getChecked');
	    		if(null!=chks && chks.length==1){
	    			$.ajaxSettings.async = true;
	    			pro();
	    			var id = chks[0].sdId;
	    		 	$.ajax({type:'GET',url:'${ctx}/merchantStatisticsMouth/getMerchantStatisticsMouthById',data:{'id':id,'r':Math.random()},
		        	    success:function(data,status,xhr){
	        	    		if(null!=data){
			    				$('#merchantStatisticsMouthForm').form('clear');
		    				  		$('#sdId').val(data.sdId);
		    				  		$('#mchId').val(data.mchId);
		    				  		$('#sdMouth').val(data.sdMouth);
		    				  		$('#payCountTotal').val(data.payCountTotal);
		    				  		$('#payAmountTotal').val(data.payAmountTotal);
		    				  		$('#payCountSucc').val(data.payCountSucc);
		    				  		$('#payAmountSucc').val(data.payAmountSucc);
		    				  		$('#realAmount').val(data.realAmount);
		    				  		$('#totleFee').val(data.totleFee);
		    				  		$('#refundCount').val(data.refundCount);
		    				  		$('#refundAmount').val(data.refundAmount);
		    				  		$('#state').val(data.state);
		    				  		$('#createTime').val(data.createTime);
		    				  		$('#updateTime').val(data.updateTime);
				    			$('#merchantStatisticsMouthDialog').dialog('open');
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
		    function deleteMerchantStatisticsMouth(){
		    	var chks = null;
	        	chks = $('#tt').datagrid('getChecked');
	        	if(chks.length<1){
	        		$.messager.alert('提示','请至少选择一项!','warning');
	        		return ;
	        	}
	        	var arr = new Array();
	        	for(var c in chks){
	        		arr[c] = chks[c].sdId;
	        	}
	        	
	        	$.messager.confirm('提示', '确定要删除该项目吗?', function(yes){
	        		if(yes){
	        			pro();
	        			$.ajax({type:'GET',url:'${ctx}/merchantStatisticsMouth/deleteMerchantStatisticsMouth',data:{'param':arr.toString()},
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
		    	var mchId = $("#mchId_s").val();
		    	var beginTime = $("#beginTime_s").val();
		    	var endTime = $("#endTime_s").val();
		    $("#tt").datagrid('load',{
		    	   mchId:mchId,
		    	   state:state,
		    	   beginTime:beginTime,
		    	   endTime:endTime,
		    	})
		    }
		    
		    $(function() {

		    	   $('#beginTime_s').datebox({
		    	       //显示日趋选择对象后再触发弹出月份层的事件，初始化时没有生成月份层
		    	       onShowPanel: function () {
		    	          //触发click事件弹出月份层
		    	          span.trigger('click'); 
		    	          if (!tds)
		    	            //延时触发获取月份对象，因为上面的事件触发和对象生成有时间间隔
		    	            setTimeout(function() { 
		    	                tds = p.find('div.calendar-menu-month-inner td');
		    	                tds.click(function(e) {
		    	                   //禁止冒泡执行easyui给月份绑定的事件
		    	                   e.stopPropagation(); 
		    	                   //得到年份
		    	                   var year = /\d{4}/.exec(span.html())[0] ,
		    	                   //月份
		    	                   //之前是这样的month = parseInt($(this).attr('abbr'), 10) + 1; 
		    	                   month = parseInt($(this).attr('abbr'), 10);  

		    	         //隐藏日期对象                     
		    	         $('#beginTime_s').datebox('hidePanel') 
		    	           //设置日期的值
		    	           .datebox('setValue', year + '-' + month); 
		    	                        });
		    	                    }, 0);
		    	            },
		    	            //配置parser，返回选择的日期
		    	            parser: function (s) {
		    	                if (!s) return new Date();
		    	                var arr = s.split('-');
		    	                return new Date(parseInt(arr[0], 10), parseInt(arr[1], 10) - 1, 1);
		    	            },
		    	            //配置formatter，只返回年月 之前是这样的d.getFullYear() + '-' +(d.getMonth()); 
		    	            formatter: function (d) { 
		    	                var currentMonth = (d.getMonth()+1);
		    	                var currentMonthStr = currentMonth < 10 ? ('0' + currentMonth) : (currentMonth + '');
		    	                return d.getFullYear() + '-' + currentMonthStr; 
		    	            }
		    	        });

		    	        //日期选择对象
		    	        var p = $('#beginTime_s').datebox('panel'), 
		    	        //日期选择对象中月份
		    	        tds = false, 
		    	        //显示月份层的触发控件
		    	        span = p.find('span.calendar-text'); 
		    	        var curr_time = new Date();

		    	        //设置前当月
		    	        $("#beginTime_s").datebox("setValue", myformatter(curr_time));
		    	});
		    
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
	            return year + "-" + month;
	        }
		    //********************************************** 华丽分割线 ***************************************//
		</script>
	</body>
</html>