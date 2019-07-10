<html>
<head>
<title>Practice</title>
</head>


<font color='red'>${errorMessage}</font>
<body>

	<form method="post"> <!--in case of 'Processing instruction not closed' 
	close the JSP file and open it again. It should work fine after that  -->
		
		Name:<input type="text" name="name" /> 
		Password:<input type="password" name="password" /> 
		<input type="submit" />

	</form>

</body>
</html>