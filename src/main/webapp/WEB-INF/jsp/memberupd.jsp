
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>회원정보 수정</title>
</head>
<body>
<h1>회원정보 수정</h1>
<form name="mbfrm" method="post" action="/memberupdok">
    <div>아이디 <input type="text" name="userid" readonly value="${mvo.userid}"></div>
    <div>비밀번호 <input type="password" name="passwd" value="${mvo.passwd}"></div>
    <div>이름 <input type="text" name="name" value="${mvo.name}"></div>
    <div><button type="submit">회원정보 수정완료</button></div>
</form>

</body>
</html>
