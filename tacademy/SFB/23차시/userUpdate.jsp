<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>����� ���� ����</title>
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css" rel="stylesheet">
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap-theme.min.css">
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<h2 class="text-center">����� ���� ����</h2>
		<div>
			<form method="post" action="updateUser.do">
				<input type="hidden" name="userId"  value="${map.user.userId}" />
				<table class="table table-bordered table table-hover">
					<tr>
						<td>���̵� :</td>
						<td>${map.user.userId}</td>
					</tr>
					<tr>
						<td>�̸� :</td>
						<td><input type="text" name="name" value="${map.user.name}" />
						</td>
					</tr>
					<tr>
						<td>���� :</td>
						<td>
								<c:forEach items='${map.genderList}' var='genderName'>
									<c:choose>
										<c:when test="${genderName eq map.user.gender}">
											<input type="radio" name="gender" value="${genderName}"
												checked="checked">${genderName}
										</c:when>
										<c:otherwise>
											<input type="radio" name="gender" value="${genderName}">${genderName}
										</c:otherwise>
									</c:choose>
								</c:forEach>
							</td>
					</tr>
					<tr>
						<td>������ :</td>
						<td>
								<select name="city">
									<c:forEach items='${map.cityList}' var='cityName'>
										<c:choose>
											<c:when test="${cityName eq map.user.city}">
												<option value="${cityName}" selected>${cityName}</option>
											</c:when>
											<c:otherwise>
												<option value="${cityName}">${cityName}</option>
											</c:otherwise>
										</c:choose>
									</c:forEach>
								</select>
						</td>
					</tr>
					<tr>
						<td colspan="2" class="text-center"><input type="submit" value="����" /></td>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>