<html>
<head>
  <title>${title}
</head>
<body>
  <h1>${title}</h1>

  <ul>
    <#list systems as system>
      <li>${system_index + 1}. ${system.name} from ${system.developer}</li>
    </#list>
  </ul>

</body>
</html>