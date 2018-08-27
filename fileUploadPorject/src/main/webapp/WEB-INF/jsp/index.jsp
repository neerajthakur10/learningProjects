<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link rel="stylesheet" type="text/css" href="webjars/bootstrap/3.3.7/css/bootstrap.min.css" />

<title>Index Page</title>
</head>
<body>
<table>
<h4>Upload a file</h4>
Select a file to upload :<br/>
<form action="upload" method = "post" enctype = "multipart/form-data">

			<table>
				<tr>
					<td><input type="file" name="file" size="50" /></td>
				</tr>
				<tr>
					<td><input type="submit" value="Upload File" /></td>
				</tr>

				
				<h2>Uploaded Csv File Data</h2>

				<%--  
				Message prnting code is still pending, this will be printed in for loop in proper sequence
				<tr>
				 <td>
						<h2>Message: ${messageArray[0]}</h2>
						<h2>Message: ${messageArray[1]}</h2>
				</td>
				</tr>  --%>
				
				
			</table>
		</form>
</body>
</html>