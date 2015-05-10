 <!DOCTYPE html>
 <html>
 <head>
 <meta charset="utf-8">
 <title>Home</title>
 <link rel="stylesheet"
     href="${pageContext.request.contextPath}/resources/app/css/styles.css">
 </head>
 <body>
     <div id="wrapper">
         <sec:authentication property="principal.account" var="account" /><!-- (1) -->
         <h1>Hello world!</h1>
         <p>Welcome ${f:h(account.firstName)} ${f:h(account.lastName)}</p><!-- (2) -->

         <ul>
             <li><a href="${pageContext.request.contextPath}/account">view account</a></li>
             <li><a href="${pageContext.request.contextPath}/logout">logout</a></li>
         </ul>
     </div>
 </body>
 </html>