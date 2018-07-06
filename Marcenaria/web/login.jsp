
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="static/css/base.css">
    <link rel="stylesheet" href="static/css/login.css">
</head>
<body>

<div class="main-container">
    <h1 class="page-title">Login</h1>
    <div class="login-container">
        <fieldset>
            <form action="/home" method="get">
                <label class="col1">Usuário: </label><label class="col2"><input type="text" name="nome-usuario"></label> <br>
                <label class="col1">Senha: </label><label class="col2"><input type="password" name="senha"> </label> <br>
                <input type="submit" value="Login" name="from-login-page">
            </form>
            <p class="error-message">${errorMessage}</p>
        </fieldset>
    </div>
</div>

</body>
</html>
