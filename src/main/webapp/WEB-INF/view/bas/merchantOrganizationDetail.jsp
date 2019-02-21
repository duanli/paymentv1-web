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
	<div id="wrapper">
    <div id="page-wrapper" style="min-height: 657px;">

        <div class="row index-row" style="margin-left: 25px;">
            <div id="main-content" >
                <div class="formlist">
                    <h4>联系信息</h4>
                    <div>
                        <label>渠道编号</label>
                        <span>10000442878</span>
                    </div>

                    <div>
                        <label>渠道名称</label>
                        <span>2088721037967820</span>
                    </div>

                    <div>
                        <label>联系人</label>
                        <span>安逸</span>
                    </div>
                    <div>
                        <label>手机号码</label>
                        <span>13880618558</span>
                    </div>
                    <div>
                        <label>电子邮箱</label>
                        <span>33667392@qq.com</span>
                    </div>
                </div>
                <div class="formlist">
                    <h4>商户负责人信息</h4>
                    <div>
                        <label>身份证号码</label>
                        <span>510212196408100915</span>
                    </div>
                    <div class="displayImg">
                        <label>身份证照片</label>
                        <span>
					<a href="./渠道进件(渠道商)_files/a6ff972b81d4457f9df00b8b594b3025.jpg" target="_blank"><img
					        style="width: 100px;height: 100px; margin-right: 20px"
					        src="./渠道进件(渠道商)_files/a6ff972b81d4457f9df00b8b594b3025.jpg"></a>
					<a href="./渠道进件(渠道商)_files/d4cf82841b234604974c8d3ad630dd7c.jpg" target="_blank"><img
					        style="width: 100px;height: 100px;" src="./渠道进件(渠道商)_files/d4cf82841b234604974c8d3ad630dd7c.jpg"></a>
					</span>
                    </div>
                </div>
                <div class="formlist license">
                    <h4>营业执照信息</h4>
                    <div>
                        <label>营业执照注册号</label>
                        <span>91510100734807532R</span>
                    </div>
                    <div>
                        <label>营业有效期</label>
                        <span>
						2002-01-28 - 2022-01-27
						</span>
                    </div>
                    <div>
                        <label>营业范围</label>
                        <span>电子产品、软件、计算机软硬件集成的研发，销售；日用品销售；批发兼零售；预包装食品兼散装食品、乳制品；网上销售电子产品、日用品；计算机系统服务，科技信息咨询，企业管理咨询，商务信息咨询，设计、制作、代理、发布国内各类广告。</span>
                    </div>

                    <div class="displayImg">
                        <label>营业执照</label>
                        <span>
						<a href="./渠道进件(渠道商)_files/a63de110b2574a578c110a1fa34de078.jpg" target="_blank"><img
						        style="width: 100px;height: 100px; margin-left: 5px"
						        src="./渠道进件(渠道商)_files/a63de110b2574a578c110a1fa34de078.jpg"></a>
						</span>
                    </div>

                </div>
                <div class="formlist">
                    <h4>状态信息</h4>
                    <div>
                        <label>审核状态</label>
                        <span>审核通过</span>
                    </div>
                    <div>
                        <label>激活状态</label>
                        <span>已激活</span>
                    </div>
                   <!--  <div class="displayImg">
                        <label>审核记录</label>
                        <span class="recording">

						<div>2018-02-08 12:19:00 审核中</div>
						
						<div>2018-02-08 12:20:45 审核通过</div>
						
						<div>2018-02-08 14:07:17 审核中</div>
						
						<div>2018-02-08 14:07:33 审核通过</div>
						
						<div>2018-02-09 10:27:18 审核中</div>
						
						<div>2018-02-09 11:24:10 审核通过</div>
						
						<div>2018-02-09 11:26:14 审核中</div>
						
						<div>2018-02-09 11:26:31 审核通过</div>
						
						<div>2018-03-13 09:42:43 审核中</div>
						
						<div>2018-03-13 09:43:42 审核通过</div>
						
						<div>2018-03-21 15:44:35 审核中</div>
						
						<div>2018-03-21 15:44:46 审核通过</div>
						</span>
                    </div> -->
                </div>
               <!--  <table class="table">
                    <thead>
                    <tr>
                        <th>支付类型</th>
                        <th>费率</th>
                        <th>激活状态</th>
                    </tr>
                    </thead>
                    <tbody>

                    <tr>
                        <td>微信-扫码支付（线下D1）</td>
                        <td>2.2‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>微信-刷卡支付（线下D1）</td>
                        <td>2.2‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>微信-公众账号支付（线下D1）</td>
                        <td>2.2‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>微信-APP支付（线上D1）</td>
                        <td>6.3‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>微信-H5支付（线上D1）</td>
                        <td>6.3‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>京东-扫码支付（线下T1）</td>
                        <td>2.7‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>京东-刷卡支付（线下T1）</td>
                        <td>2.7‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>京东-公众账号支付（线下T1）</td>
                        <td>2.7‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>京东-H5支付（线上T1）</td>
                        <td>4.5‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>京东-扫码支付（线上T1）</td>
                        <td>4.5‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>支付宝-扫码支付（线下D1）</td>
                        <td>2.2‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>支付宝-刷卡支付（线下D1）</td>
                        <td>2.2‰</td>
                        <td>已激活</td>
                    </tr>

                    <tr>
                        <td>支付宝-JS支付（线下D1）</td>
                        <td>2.2‰</td>
                        <td>已激活</td>
                    </tr>
                    </tbody>
                </table> -->
            </div>
        </div>
    </div>
</div>
</body>
</html>