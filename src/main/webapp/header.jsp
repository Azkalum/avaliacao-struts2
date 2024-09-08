<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
  <title>Meu Sistema</title>
</head>
<body>
<div id="header">
  <h1>Bem-vindo ao Sistema</h1>
  <s:if test="#session.username != null">
    <p>Usuário logado: <s:property value="#session.username"/></p>
  </s:if>
</div>
<hr/>
</body>
</html>
