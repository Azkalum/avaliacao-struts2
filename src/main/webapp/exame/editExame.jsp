<html>
<head>
  <title>Editar Exame</title>
</head>
<body>
<h1>Editar Exame</h1>
<s:form action="updateExame" method="post">
  <s:hidden name="exame.id"/>
  Nome: <s:textfield name="exame.nome"/><br/>
  Descrição: <s:textarea name="exame.descricao"/><br/>
  <s:submit value="Atualizar"/>
</s:form>
</body>
</html>
