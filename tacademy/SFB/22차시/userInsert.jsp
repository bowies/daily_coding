<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>����� ���� ���</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">����� ���� ���</h2>
		<div>
			<form method="post" action="insertUser.do"  >
				<table  class="table table-bordered table table-hover">
					<tr>
						<td>���̵� :</td>
						<td><input type="text" name="userId"  /></td>
					</tr>
					<tr>
						<td>�̸� :</td>
						<td><input type="text" name="name" /></td>
					</tr>
					<tr>
						<td>���� :</td>
						<td><c:forEach var="genderName" items="${map.genderList}">
									<input type="radio" name="gender" value="${genderName}">${genderName}
							  </c:forEach></td>
					</tr>
					<tr>
						<td>������ :</td>
						<td><select name="city">
								<c:forEach var="cityName" items="${map.cityList}">
									<option value="${cityName}">${cityName}</option>
								</c:forEach>
								</select></td>
					</tr>
					<tr>
					<td colspan="2"  class="text-center">
						<input type="submit" value="���" /></td>
					</tr>
					<tr>					
						<td colspan="2" class="text-center"><a href="getUserList.do">����� ��Ϻ���</a></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>