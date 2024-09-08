<html>
<head>
  <title>Editar Funcionário</title>
</head>
<body>
<h1>Editar Funcionário</h1>
<s:form action="updateFuncionario" method="post">
  <s:hidden name="funcionario.codigo"/>
  Nome: <s:textfield name="funcionario.nome"/><br/>
  <s:submit value="Atualizar"/>
</s:form>
</body>
</html>
