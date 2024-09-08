<html>
<head>
  <title>Registrar Exame Realizado</title>
</head>
<body>
<h1>Registrar Exame Realizado</h1>
<s:form action="createExameRealizado" method="post">
  Código Funcionário: <s:textfield name="exameRealizado.codigoFuncionario"/><br/>
  Código Exame: <s:textfield name="exameRealizado.codigoExame"/><br/>
  Data da Realização: <s:textfield name="exameRealizado.dataRealizacao"/><br/>
  <s:submit value="Salvar"/>
</s:form>
</body>
</html>
