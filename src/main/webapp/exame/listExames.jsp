<html>
<head>
    <title>Lista de Exames</title>
</head>
<body>
<h1>Lista de Exames</h1>
<s:form action="listExames" method="get">
    Filtro Ativo:
    <s:select name="filtroAtivo" list="{'true':'Ativo', 'false':'Inativo', '' : 'Todos'}" />
    Nome: <s:textfield name="nome" />
    Código: <s:textfield name="codigo" />
    <s:submit value="Filtrar" />
    <s:if test="#session.username != null">
        <p>Usuário logado: <s:property value="#session.username"/></p>
    </s:if>
</s:form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Nome</th>
        <th>Descrição</th>
        <th>Ativo</th>
        <th>Ações</th>
    </tr>
    <s:iterator value="exames">
        <tr>
            <td><s:property value="id" /></td>
            <td><s:property value="nome" /></td>
            <td><s:property value="descricao" /></td>
            <td><s:property value="ativo" /></td>
            <td>
                <a href="editExame.action?id=<s:property value='id'/>">Editar</a> |
                <a href="deleteExame.action?id=<s:property value='id'/>">Excluir</a>
            </td>
        </tr>
    </s:iterator>
</table>
<a href="createExame.action">Criar Novo Exame</a>
</body>
</html>
