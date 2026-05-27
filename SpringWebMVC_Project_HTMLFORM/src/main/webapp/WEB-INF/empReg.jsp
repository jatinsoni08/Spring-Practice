<%@ page language="java" contentType="text/html;charset=UTF-8"%>

<html>
<head>
    <title>WELCOME TO APP</title>
</head>

<body>

<pre>

<h2>WELCOME TO REGISTER FORM</h2>

<form action="register" method="POST">

ID   : <input type="text" name="eid"/>

NAME : <input type="text" name="ename"/>

SAL  : <input type="text" name="esal"/>

PWD  : <input type="password" name="epwd"/>

DEPT : <select name="edept">
            <option value="DEV">DEV</option>
            <option value="QA">QA</option>
            <option value="BA">BA</option>
       </select>

ADDR : <textarea name="eaddr"></textarea>

<input type="submit" value="CREATE"/>

</form>

</pre>

</body>
</html>