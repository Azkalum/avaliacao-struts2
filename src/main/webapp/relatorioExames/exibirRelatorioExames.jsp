<html>
<head>
  <title>Relatório de Exames Realizados</title>
</head>
<body>
<h1>Relatório de Exames Realizados</h1>
<table border="1">
  <tr>
    <th>Código Funcionário</th>
    <th>Nome Funcionário</th>
    <th>Código Exame</th>
    <th>Nome Exame</th>
    <th>Data da Realização</th>
  </tr>
  <s:iterator value="examesRealizados">
    <tr>
      <td><s:property value="codigoFuncionario" /></td>
      <td><s:property value="codigoExame" /></td>
      <td><s:property value="dataRealizacao" /></td>
    </tr>
  </s:iterator>
</table>
<a href="relatorioExames.jsp">Voltar</a>
</body>
</html>
