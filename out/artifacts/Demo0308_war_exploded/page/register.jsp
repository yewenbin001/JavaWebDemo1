<%--
  Created by IntelliJ IDEA.
  User: WuLiangHang
  Date: 2021/3/8
  Time: 15:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册页面</title>
    <script type="text/javascript" src="../js/jquery-1.11.3.min.js"></script>
    <script type="text/javascript">
        //innerHTML：两个HTML元素内部的文本
        /**
         * onsubmit:提交按钮被点击
         * onblur 元素失去焦点
         * onfocus 元素获得焦点
         */

        function check(){
            //1.用户名
            var loginName = document.getElementById("username").value;
            //0 null undefined ""
            if(!loginName){
                alert("用户名不合法！");
                return false;
            }
            //2.密码
            var loginpwd = document.getElementById("password").value;
            if(!loginpwd){
                alert("密码不合法！");
                return false;
            }
            //3.重复密码
            var reloginpwd = document.getElementById("repassword").value;
            if(reloginpwd != loginpwd){
                alert("两次输入密码不一致!");
                return false;
            }
            //4.邮箱格式校验
            //判断正则表达式
            //1.使用String对象中的match方法
            //2.使用正则对象中的test方法
            var email = document.getElementById("email").value;
            //完整的正则对象:以/^开头 以$/
            // /^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/
            if(!/^[A-Za-z\d]+([-_.][A-Za-z\d]+)*@([A-Za-z\d]+[-.])+[A-Za-z\d]{2,4}$/.test(email)){
                //邮箱格式不正确
                alert("邮箱格式不正确！");
                document.getElementById("email").focus();//让鼠标焦点聚集到当前选中的标签上
                return false;
            }
        }

        /**
         * 1.获得指定id的值
         */
        function val(objId){
            return document.getElementById(objId).value;
        }
        /**
         * 2.1.显示错误提示信息
         */
        function showTip(errObjId, text){
            var showObj = document.getElementById(errObjId);
            showObj.innerHTML = text;
            showObj.style.display = "block";
        }

        /**
         * 2.2隐藏错误提示信息
         */
        function hideTip(errObjId){
            var showObj = document.getElementById(errObjId);
            showObj.innerHTML = "";
            showObj.style.display = "none";
        }

        /**
         * 3.获得焦点
         */
        function focus(objId){
            //指定标签获得焦点
            document.getElementById(objId).focus();
        }

        function check(){
            var focusObjId;//记录需要获得焦点标签的id值
            //1.用户名校验
            var loginName = val("username");
            //0 null undefined ""
            if(!loginName){
                showTip("usernameTip", "用户名不能为空");
                focusObjId = "username";
            }else{
                hideTip("usernameTip");
            }

            //2.密码

            //如果有需要获得焦点 表示校验没有通过
            if(focusObjId){
                focus(focusObjId);
                return false;
            }
            return true;
        }
        function changeImg() {
            console.log(0);
            $('#imgID').attr("src", "http://localhost:8080/Demo0308/verifyCode.do?" + new Date());
        }

    </script>
</head>
<body>
<!--
 需求：当表单提交时，需要
 1.验证用户名是否为空
 2.验证密码是否为空
 3.验证密码与确认密码是否一致
 4.通过正则表达式 验证邮箱格式是否正确(扩展)
 -->
<table border="1px" align="center" width="1300px" cellpadding="0px" cellspacing="0px">
    <!--1.logo部分-->
    <tr>
        <td>
            <!--嵌套一个一行三列的表格-->
            <table border="1px" width="100%">
                <tr height="50px">
                    <td width="33.3%">
                        <img src="../img/logo2.png" height="47px" />
                    </td>
                    <td width="33.3%">
                        <img src="../img/header.png" height="47px" />
                    </td>
                    <td width="33.3%">
                        <a href="#">登录</a>
                        <a href="#">注册</a>
                        <a href="#">购物车</a>
                    </td>
                </tr>
            </table>
        </td>
    </tr>
    <!--2.导航栏部分-->
    <tr height="50px">
        <td bgcolor="black">
            &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">
                <font size="5" color="white">首页</font>
            </a> &nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">
                <font color="white">手机数码</font>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">
                <font color="white">电脑办公</font>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">
                <font color="white">鞋靴箱包</font>
            </a>&nbsp;&nbsp;&nbsp;&nbsp;
            <a href="#">
                <font color="white">家用电器</font>
            </a>
        </td>
    </tr>
    <!--3.注册表单-->
    <tr>
        <td height="600px" background="../img/regist_bg.jpg">
            <!--嵌套一个十行二列的表格-->
            <form action="#" method="get" name="regForm" onsubmit="return check()">
                <table border="1px" width="750px" height="400px" align="center" cellpadding="0px" cellspacing="0px" bgcolor="white">
                    <tr height="40px">
                        <td colspan="2">
                            <font size="4">会员注册</font> &nbsp;&nbsp;&nbsp;USER REGISTER
                        </td>
                    </tr>
                    <tr>
                        <td>
                            用户名
                        </td>
                        <td>
                            <input onblur="check()" type="text" id="username" name="user" size="34px" />
                            <span><font id="usernameTip" color="red">1</font> </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            密码
                        </td>
                        <td>
                            <input type="password" id="password" name="password" size="34px" />
                            <span><font id="pwdTip" color="red"></font> </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            确认密码
                        </td>
                        <td>
                            <input type="password" id="repassword" name="repassword" size="34px"></input>
                            <span><font id="repwdTip" color="red"></font> </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            Email
                        </td>
                        <td>
                            <input type="text" id="email" name="email" size="34px" />
                            <span><font id="emailTip" color="red"></font> </span>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            姓名
                        </td>
                        <td>
                            <input type="text" name="username" size="34px" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            性别
                        </td>
                        <td>
                            <input type="radio" name="sex" value="男" />男
                            <input type="radio" name="sex" value="女" />女
                        </td>
                    </tr>
                    <tr>
                        <td>
                            出生日期
                        </td>
                        <td>
                            <input type="text" name="birthday" size="34px" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            验证码
                        </td>
                        <td>
                            <input type="text" name="yzm" />
                            <img  src="http://localhost:8080/Demo0308/verifyCode.do" id="imgID" onclick="changeImg()" />
                        </td>

                    </tr>
                    <tr>
                        <td colspan="2">
                            <input type="submit" value="注册" />
                        </td>
                    </tr>
                </table>
            </form>
        </td>
    </tr>
    <!--4.广告图片-->
    <tr>
        <td>
            <img src="../img/footer.jpg" width="100%" />
        </td>
    </tr>
    <!--5.友情链接和版权信息-->
    <tr>
        <td align="center">
            <a href="#">关于我们</a>
            <a href="#">联系我们</a>
            <a href="#">招贤纳士</a>
            <a href="#">法律声明</a>
            <a href="#">友情链接</a>
            <a href="#">支付方式</a>
            <a href="#">配送方式</a>
            <a href="#">服务声明</a>
            <a href="#">广告声明</a>
            <p>
                Copyright © 2005-2016 Java商城 版权所有
            </p>
        </td>
    </tr>
</table>


</body>
</html>

