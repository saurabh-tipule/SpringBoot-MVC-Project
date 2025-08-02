<%@page import="java.util.List"%>
<%@page import="com.cjc.app.model.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<script type="text/javascript">
	
	function deleteData()
	{
		alert('You are deleting record...!')
		document.myForm.action="delete";
		document.myForm.submit();
	}
	
	function editData()
	{
		alert('You are editing record...!')
		document.myForm.action="edit";
		document.myForm.submit();
	}
	
	
	
</script>

</head>




<body>
	<h1>Success Page..!</h1>

	<%
		List<Student> list = (List<Student>) request.getAttribute("data");
	%>

	<form name="myForm">

		<table border="2px" align="center">
			<thead>
				<tr>
					<th>SELECT</th>
					<th>ROLLNO</th>
					<th>FIRST NAME</th>
					<th>LAST NAME</th>
					<th>GENDER</th>
					<th>MOBILE NO</th>
					<th>EMAIL ID</th>
					<th>BIRTH DATE</th>
					<th>USER NAME</th>
					<th>PASSWORD</th>
				</tr>
			</thead>
			<tbody>

				<%
					for (Student stu : list) {
				%>
				<tr>
					<td><input type="radio" name="rollno"
						value="<%=stu.getRollno()%>"></td>
					<td><%=stu.getRollno()%></td>
					<td><%=stu.getFirstName()%></td>
					<td><%=stu.getLastName()%></td>
					<td><%=stu.getGender()%></td>
					<td><%=stu.getMobileNo()%></td>
					<td><%=stu.getEmailId()%></td>
					<td><%=stu.getBirthDate()%></td>
					<td><%=stu.getUserName()%></td>
					<td><%=stu.getPassword()%></td>
				</tr>
				<%
					}
				%>
			</tbody>
		</table>

		<div align="center">
			<button style="background-color: red; color: white;" onclick="deleteData()">DELETE</button>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
			<button style="background-color: blue; color: white;" onclick="editData()">EDIT</button>
		</div>


	</form>



</body>
</html>