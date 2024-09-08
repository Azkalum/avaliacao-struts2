<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
  <title>Home</title>
</head>
<body>
<s:if test="#session.username != null">
  <p>Usuário logado: <s:property value="#session.username"/></p>
</s:if>
<!-- Conteúdo da página -->
</body>
</html>
