<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="../../../pages/taglibs.jsp"%>
<%@taglib prefix="shiro" uri="http://shiro.apache.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>title</title>
<link href="${ctx}/css/style.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/style2.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/themes/icon.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/themes/bootstrap/easyui.css" rel="stylesheet" type="text/css" />
<link href="${ctx}/css/themes/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="${ctx}/js/jquery-1.8.3.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery.easyui.min.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery.utils.js" charset="utf-8"></script>
<script type="text/javascript" src="${ctx}/js/jquery.form.js" charset="utf-8"></script>
</head>
<body>
	<div id="wrapper" style="margin-left: 20px;">
    <div id="page-wrapper" style="min-height: 657px;">
        <div class="row X-Grid">
            <div class="backLan">
                <h4>${balance}</h4>
                <p>当前余额</p>
            </div>
            <div class="backLu">
                <h4>${balanceValid}</h4>
                <p>可提现余额</p>
            </div>
            <div class="backHo">
                <h4>${balanceFreeze}</h4>
                <p>冻结余额</p>
            </div>
            <div class="backHu">
                <h4>${balanceUnaccounted}</h4>
                <p>待清算余额</p>
            </div>
            <div class="backFe">
                <h4>${todayCnt}</h4>
                <p>今日交易笔数</p>
            </div>
            <div class="backHo">
                <h4>${todayAmount}</h4>
                <p>今日交易金额</p>
            </div>
            <div class="backTu">
                <h4>${todayFee}</h4>
                <p>今日手续费</p>
            </div>
            <div class="backFen">
                <h4>${todayIncome}</h4>
                <p>今日净收入</p>
            </div>
        </div>

        <div class="X-tabe">
            <p class="top">今日交易汇总</p>
            <div class="X-tabList">
                <div class="tab bian">
                    <h4>0.00</h4>
                    <p>支付宝h5</p>
                </div>
                <div class="tab bian">
                    <h4>0.00</h4>
                    <p>支付宝h5</p>
                </div>
                <div class="tab bian">
                    <h4>0.00</h4>
                    <p>支付宝h5</p>
                </div>
                <div class="tab">
                    <h4>0.00</h4>
                    <p>支付宝h5</p>
                </div>
                <div class="tab bian">
                    <h4>0.00</h4>
                    <p>支付宝h5</p>
                </div>
                <div class="tab bian">
                    <h4>0.00</h4>
                    <p>支付宝h5</p>
                </div>
                <c:if test="${transModeList!=null}">
                <c:forEach items="${transModeList}" var="item">
	                <div class="tab bian">
	                    <h4>${item.balanceValid}</h4>
	                    <p>${item.ralProviderTransMode.productName}</p>
	                </div>
				</c:forEach>
				</c:if>
            </div>
        </div>
    </div>
</div>
</body>
</html>