<html>
<head>
  <title>Lista de Exames Realizados</title>
</head>
<body>
<h1>Lista de Exames Realizados</h1>
<table border="1">
  <tr>
    <th>Código Funcionário</th>
    <th>Código Exame</th>
    <th>Data da Realização</th>
    <th>Ações</th>
  </tr>
  <s:iterator value="examesRealizados">
    <tr>
      <td><s:property value="codigoFuncionario" /></td>
      <td><s:property value="codigoExame" /></td>
      <td><s:property value="dataRealizacao" /></td>
      <td>
        <a href="editExameRealizado.action?codigoFuncionario=<s:property value='codigoFuncionario'/>&codigoExame=<s:property value='codigoExame'/>">Editar</a> |
        <a href="deleteExameRealizado.action?codigoFuncionario=<s:property value='codigoFuncionario'/>&codigoExame=<s:property value='codigoExame'/>">Excluir</a>
      </td>
    </tr>
  </s:iterator>
</table>
<a href="createExameRealizado.action">Registrar Novo Exame Realizado</a>
</body>
</html>
