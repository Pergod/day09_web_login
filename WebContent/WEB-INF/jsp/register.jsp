<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
<script src="/WEB-INF/js_date/laydate.js"></script>
</head>
<body>
	<%--数据回写，错误提醒 --%>
	<form action="${pageContext.request.contextPath }/register" method="post">
		用户名:<input type="text" name="username" value="${message.username}"/><span class="message">${message.errors.username}</span><br/>
		密码:<input type="text" name="password" value="${message.password}"/><span class="message">${message.errors.password}</span><br/>
		确认密码:<input type="text" name="password2" value="${message.password2}"/><span class="message">${message.errors.password2}</span><br/>
		邮箱:<input type="text" name="email" value="${message.email}"/><span class="message">${message.errors.email}</span><br/>
		生日:<input class="laydate-icon" id="demo" type="text" name="birthday" onclick="laydate()" value="${message.birthday}"/><span class="message">${message.errors.birthday}</span><br/>
		昵称:<input type="text" name="neckname" value="${message.neckname}"/><span class="message">${message.errors.neckname}</span><br/>
		认证码:<input type="text" name="checkcode"/><img alt="看不清，再换一张" src="/day07/image" onclick="refreshImage(this)"><br/>
		<input type="reset" value="重置"/>
		<input type="submit" value="注册"/>
	</form>
	<script>
		;!function(){
		laydate({
		   elem: '#demo'
		})
		}();
</script>
</body>
</html>