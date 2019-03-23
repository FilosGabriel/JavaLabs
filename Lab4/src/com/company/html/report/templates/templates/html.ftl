<html>
<head>
  <title>${title}</title>
</head>
<body>
  <h1>${title}</h1>


  <ul>
    <#list systems as system>
      <li>${system_index + 1}. ${system.name}
            <ul>
                <li>Descriere: ${system.describe}</li>
                <li>Cale imagine: ${system.caleImage}</li>
                <li>Cale tgf: ${system.caleTgf}</li>
            </ul>
      </li>
    </#list>
  </ul>

</body>
</html>