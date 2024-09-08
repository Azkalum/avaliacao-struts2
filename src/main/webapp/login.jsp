<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Login no Sistema</h1>

<!-- Formulário de Login -->
<s:form action="login" method="post">
    Usuário: <s:textfield name="username"/><br/>
    Senha: <s:password name="password"/><br/>
    <s:submit value="Entrar"/>
</s:form>

<!-- Exibe erros de login, se houver -->
<s:if test="hasActionErrors()">
    <div style="color:red;">
        <s:actionerror/>
    </div>
</s:if>
</body>
</html>
