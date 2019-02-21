$(function(){
	$("#kuaidi").hide();
	$(".ceng").hide();
	$("#sure").css("top",$(window).height()*0.85);
	$("#bg").css("height",$(window).height());
	
	var index = 0;
	$("#choose tr td").click(function(){
		if($(this).index() == 0){
			$("#ziti").show();
			$("#kuaidi").hide();
			$("#choose tr td").eq(0).css("background-image","url(images/html5/chooseTitle2.png)");
			$("#choose tr td").eq(1).css("background-image","url(images/html5/chooseTitle5.png)");
			index = $(this).index();
		}else{
			$("#ziti").hide();
			$("#kuaidi").show();
			$("#choose tr td").eq(0).css("background-image","url(images/html5/chooseTitle4.png)");
			$("#choose tr td").eq(1).css("background-image","url(images/html5/chooseTitle3.png)");
			index = $(this).index();
		}
	});
	
	$("#sure").click(function(){
		$("#sure").attr("disabled","disabled");
		var address = $("#address").val();
		var realName = $("#realName").val();
		var cellPhone = $("#cellPhone").val();
		var addressId = $("#addressId").val();
		var quantity = $("#num").val();
		var useScore = $(".jifen").text();
		var account = $("#account").val();
		var ragex = /^1[3|5][0-9]\d{4,8}$/;
		if(index == 1){
			if(address==''){
				style("请输入收货地址","");
				return;
			}else if(realName==''){
				style("请输入联系人","");
				return;
			}else if(cellPhone==''){
				style("请输入联系电话","");
				return;
			}else if(cellPhone.match(ragex) == false){
				style("请输入正确的手机号","");
				return;
			}
		}
		$.ajax( {
			url : 'score/changeGiftdetailmes.do',
			type : 'post',
			dataType : 'text',
			data : "custId=" + custId + "&giftId="+giftId + "&addressId=" + addressId + 
			"&address=" + address + "&realName=" + realName + "&cellPhone=" + cellPhone + 
			"&deliveries=" + (index+1) + "&quantity=" + quantity + "&useScore=" + useScore,
			success : function(data) {
				style(data);
			},
			error : function(data) {
			}
		});
	});
	
	$("#update").click(function(){
		var pwd = $("#pwd").val();
		var oldPwd = $("#oldPwd").val();
		var newPwd = $("#newPwd").val();
		var surePwd = $("#surePwd").val();
		if(oldPwd == ''){
			ceng("请输入旧密码");
		}else if(pwd != oldPwd){
			ceng("密码输入不正确");
		}else if(newPwd == ''){
			ceng("请输入新密码");
		}else if(surePwd == ''){
			ceng("请确认新密码");
		}else if(newPwd != surePwd){
			ceng("两次密码输入不正确");
		}else{
			$.ajax( {
				url : 'cust/uptdetailmes.do',
				type : 'post',
				dataType : 'text',
				data : 'clientPwd='+surePwd,
				success : function(data) {
					if(data == 'success'){
						ceng("更新成功");
					}else{
						ceng("更新失败");
					}
				},
				error : function(data) {
				}
			});
		}
	});
	
	$(".history").click(function(){
		var card = $("#card").val();
		var cellPhone =$("#cellPhone").val();
		$("#cardInp").val(card);
		$("#phoneInp").val(cellPhone);
	});
	
	$("#again").click(function(){
		var msgId = $("#msgId").val();
		var custId = $("#custId").val();
		var phone = $("#Phone").val();
		var card = $("#CusAcctNo").val();
		var orderFee = $("#orderFee").val();
		compatible("applyPaymes.do?cusAcctNo="+card+"&cellphone="+phone+"&orderFee="+orderFee+"&custId="+custId+"&msgId="+msgId,"pay/applyPaymes.do?cusAcctNo="+card+"&cellphone="+phone+"&orderFee="+orderFee+"&custId="+custId+"&msgId="+msgId);
	});
	
});

function ceng(data){
	$(".ceng").empty();
	$(".ceng").text(data);
	$(".ceng").css("top",($(window).height()-$(".ceng").height())/2);
	$(".ceng").css("left",($(window).width()-$(".ceng").width())/2);
	$(".ceng").fadeIn("slow");
	setTimeout(function(){
		$(".ceng").fadeOut("slow");
	},2000);
}

function style(data){
	$(".ceng").empty();
	$(".ceng").text(data);
	$(".ceng").css("top",($(window).height()-$(".ceng").height())/2);
	$(".ceng").css("left",($(window).width()-$(".ceng").width())/2);
	$(".ceng").fadeIn("slow");
	setTimeout(function(){
		$(".ceng").fadeOut("slow");
		location.href = 'javascript:contact.closeActivity()';
	},2000);
}

function jf(custId,msgId){
	$("#card").hide();
	$("#phone").hide();
	$("#tj").hide();
	var sum = $("#sum").text();
	$("#jf").attr("disabled","disabled");
	compatible("readyPaymes.do?custId="+custId+"&msgId="+msgId+"&sum="+sum,"pay/readyPaymes.do?custId="+custId+"&msgId="+msgId+"&sum="+sum);
}

function showInfo(){
	$("#card").show();
	$("#phone").show();
	$("#tj").show();
	
}
function tj(custId,msgId){
	var card = $("#cardInp").val();
	var phone = $("#phoneInp").val();
	var sum = $("#sum").text();
	var custNo = $("#custNo").val();
	var reg = /^\d{6}$/;
	var phoneReg=/^1[3578][0-9]{9}$/;
	if(card == ''){
		ceng("请输入银行卡号");
	}else if(card.match(reg) == null){
		ceng("请输入正确的银行卡号");
	}else if(phone==''){
		ceng("请输入手机号");
	}else if(phone.match(phoneReg) == null){
		ceng("请输入正确的手机号");
	}else{
		compatible("readyEPaymes.do?custId="+custId+"&msgId="+msgId+"&sum="+sum+"&cusAcctNo="+card+"&cellphone="+phone+"&custNo="+custNo,"pay/readyEPaymes.do?custId="+custId+"&msgId="+msgId+"&sum="+sum+"&cusAcctNo="+card+"&cellphone="+phone+"&custNo="+custNo);
	}
}

function next(custId,msgId){
	var card = $("#cardInp").val();
	var phone = $("#phoneInp").val();
	var orderFee = $("#orderFee").val();
	var orderFeeReg = /^[0-9]+(.[0-9]{2})?$/;
	var reg = /^[0-9]*$/;
	if(card == ''){
		ceng("请输入银行卡号");
	}else if(phone == ''){
		ceng("请输入手机号");
	}else if(orderFee == ''){
		ceng("请输入金额");
	}else if(orderFee.match(orderFeeReg) == false){
		ceng("请输入正确的金额");
	}else if(card.match(reg) == false){
		ceng("请输入正确的银行卡号");
	}else if(phone.match(reg) == false){
		ceng("请输入正确的手机号");
	}else{
		compatible("applyPaymes.do?cusAcctNo="+card+"&cellphone="+phone+"&orderFee="+orderFee+"&custId="+custId+"&msgId="+msgId,"pay/applyPaymes.do?cusAcctNo="+card+"&cellphone="+phone+"&orderFee="+orderFee+"&custId="+custId+"&msgId="+msgId);
	}
}

function sure(msgId){
	var password = $("#password").val();
	var PaySerialNo = $("#PaySerialNo").val();
	var OrderNo = $("#OrderNo").val();
	var SSTime = $("#SSTime").val();
	var CusAcctNo = $("#CusAcctNo").val();
	var custId = $("#custId").val();
	var cellphone = $("#cellphone").val();
	var msgId = $("#msgId").val();
	if(password == ''){
		ceng("请输入动态密码");
	}else{
		 compatible("subPaymes.do?PaySerialNo=" + PaySerialNo + "&OrderNo="
				+ OrderNo + "&SSTime=" + SSTime + "&CusAcctNo=" + CusAcctNo
				+ "&custId=" + custId + "&cellphone=" + cellphone
				+ "&password=" + password+"&msgId="+msgId, "pay/subPaymes.do?PaySerialNo="
				+ PaySerialNo + "&OrderNo=" + OrderNo + "&SSTime=" + SSTime
				+ "&CusAcctNo=" + CusAcctNo + "&custId=" + custId
				+ "&cellphone=" + cellphone + "&password=" + password + "&msgId="+msgId);
		 
	}
}

function compatible(url1,url2){
	if($.browser.msie) { 
		window.location.href=url1;
	} 
	else if($.browser.safari) 
	{ 
		window.location.href=url2;
	} 
	else if($.browser.mozilla) 
	{ 
		window.location.href=url1;
	} 
	else if($.browser.opera) { 
		window.location.href=url1;
	} 
	else { 
		window.location.href=url2;
	} 
 }