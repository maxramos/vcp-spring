<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Person</title>
</head>
<body>
<table border="1">
	<tbody>
		<tr>
			<td>id</td>
			<td>${person.id}</td>
		</tr>
		<tr>
			<td>firstName</td>
			<td>${person.firstName}</td>
		</tr>
		<tr>
			<td>lastName</td>
			<td>${person.lastName}</td>
		</tr>
		<tr>
			<td>age</td>
			<td>${person.age}</td>
		</tr>
		<tr>
			<td>birthDate</td>
			<td>${person.birthDate}</td>
		</tr>
		<tr>
			<td>weight</td>
			<td>${person.weight}</td>
		</tr>
		<tr>
			<td>height</td>
			<td>${person.height}</td>
		</tr>
	</tbody>
</table>
</body>
</html>