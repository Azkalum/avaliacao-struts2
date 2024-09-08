<html>
<head>
  <title>Editar Exame Realizado</title>
</head>
<body>
<h1>Editar Exame Realizado</h1>
<s:form action="updateExameRealizado" method="post">
  <s:hidden name="exameRealizado.codigoFuncionario"/>
  <s:hidden name="exameRealizado.codigoExame"/>
  Data da Realização: <s:textfield name="exameRealizado.dataRealizacao"/><br/>
  <s:submit value="Atualizar"/>
</s:form>
</body>
</html>
