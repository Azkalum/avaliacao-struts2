<html>
<head>
  <title>Criar Exame</title>
</head>
<body>
<h1>Criar Exame</h1>
<s:form action="createExame" method="post">
  Nome: <s:textfield name="exame.nome"/><br/>
  Descrição: <s:textarea name="exame.descricao"/><br/>
  <s:submit value="Salvar"/>
</s:form>
</body>
</html>
