<html>
<head>
  <title>Lista de Funcionários</title>
</head>
<body>
<h1>Lista de Funcionários</h1>
<table border="1">
  <tr>
    <th>Código</th>
    <th>Nome</th>
    <th>Ações</th>
  </tr>
  <s:iterator value="funcionarios">
    <tr>
      <td><s:property value="codigo" /></td>
      <td><s:property value="nome" /></td>
      <td>
        <a href="editFuncionario.action?codigo=<s:property value='codigo'/>">Editar</a> |
        <a href="deleteFuncionario.action?codigo=<s:property value='codigo'/>">Excluir</a>
      </td>
    </tr>
  </s:iterator>
  <s:if test="#session.username != null">
    <p>Usuário logado: <s:property value="#session.username"/></p>
  </s:if>
</table>
<a href="createFuncionario.action">Criar Novo Funcionário</a>
</body>
</html>
