<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome To Home!</title>
<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
	
</head>
<body style="font-family: arial;height: 500%;" >

<h3 style="font-family: arial">Spring MVC With MongoDB</h3>

<hr/>
<p style="height: 100%"></p>
	<form action="/mongodb/member/save" method="post" name="roomMember">

		<table align="center" border="2">
			<tr>
				<td align="center">Enter Your Name</td>
				<td>
				<c:choose>
				<c:when test="${member.name eq null}">
					<input type="text" name="name" value="${roomMember.name}" />
				</c:when>
				<c:otherwise>
					<input type="text" name="name" value="${member.name}" />
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td align="center">Enter Your Email</td>
				<td>
				<c:choose>
				<c:when test="${member.mailId eq null}">
					<input type="text" name="mailId" value="${roomMember.mailId}" />
				</c:when>
				<c:otherwise>
					<input type="text" name="mailId" value="${member.mailId}"/>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td align="center">Card Spent Via</td>
				<td>
				<c:choose>
				<c:when test="${member.spentVia eq null}">
					<input type="text" name="spentVia" value="${roomMember.spentVia}" />
				</c:when>
				<c:otherwise>
					<input type="text" name="spentVia" value="${member.spentVia}"/>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td align="center">Spent Amount</td>
				
				<td>
				<c:choose>
				<c:when test="${member.amount eq null}">
					<input type="text" name="amount" value="${roomMember.amount}" />
				</c:when>
				<c:otherwise>
					<input type="text" name="amount" value="${member.amount}"/>
				</c:otherwise>
				</c:choose>
				</td>
			</tr>
			<tr>
				<td align="center"><input type="submit" value="Submit!" align="left"></td>
				<td align="center"><input type="reset" value="Reset!" align="left"></td>
			</tr>
		</table>
		
		<c:if test="${not empty member.id}">
		
		</c:if>
		
		<c:choose>
				<c:when test="${member.id eq null}">
					<input type="hidden" name="id" value="${roomMember.id}">
				</c:when>
				<c:otherwise>
					<input type="hidden" name="id" value="${member.id}">
				</c:otherwise>
	   </c:choose>
	
	
	
	</form>
	
	<p style="height: 50px"></p>
		
	<table border="1" align="center" >
	<c:if test="${memberList.size() > 0}">
			<tr><td><b>MEMBER-ID</b></td><td><b>MEMBER-NAME</b></td><td><b>MEMBER-EMAILID</b></td><td><b>SPENT-VIA</b></td><td><b>AMOUNT SPENT</b></td><td><b>AMOUNT-SPENT-ON</b></td><td></td><td></td></tr>
		<c:forEach var="member" items="${memberList}">
			<tr>
				<td style="color: green">${member.id}</td><td>${member.name}</td><td>${member.mailId}</td><td>${member.spentVia}</td><td>${member.amount}</td><td>${member.spentOn}</td>
				<td><input type="button" value="Edit" onclick="window.location='/mongodb/member/edit?id=${member.id}'" /></td>
				<td><input type="button" value="Delete" onclick="window.location='/mongodb/member/delete?id=${member.id}'" /></td>
			</tr>
		</c:forEach>
		</c:if>
	</table>
	
	
	<p style="height: 1000%;width: 1000%"></p>
	
</body>


<hr/>
	
	<p align="center">
	<b>&copy; 2015 SpringMVCwithMongoDB.com</b>
	</p>
	
</html>