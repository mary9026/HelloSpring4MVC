<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>회원정보상세조회</title>
</head>
<body>
<h1>회원정보 상세조회</h1>
<p>아이디 : ${mvo.userid}</p>
<p>이름 : ${mvo.name}</p>
<p>회원등급 : ${mvo.grade}</p>
<p>회원 마일리지 : ${mvo.points}</p>
<p>가입일 : ${mvo.regdate}</p>
<hr>
<p><button type="button" onclick="modMember('${mvo.userid}')">회원정보 수정</button>
    <button type="button" onclick="rmvMember('${mvo.name}')">회원정보 삭제</button></p>

<script>
    // 성적번호를 이용해서 성적데이터를 수정하는 url 호출
    function modMember(userid) {
        location.href = '/memberupd?userid=' + userid;
    }

    // 성적번호를 이용해서 성적데이터를 삭제하는 url 호출
    function rmvMember(name) {
        location.href='/memberdel?name=' + name;
    }
</script>
</body>
</html>
