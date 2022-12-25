<!-- 

    JSP de error.

    Este JSP muestra un mensaje de alerta mediante JavaScript informando al 
    usuario de que el usuario ingresado y/o su contraseña no coinciden con los 
    registrados en la tabla de 'usuarios'

-->

<script>alert("Usuario y/o contraseña no validos");</script>
<meta http-equiv="refresh" content="0;url=${pageContext.request.contextPath}/LoginServlet">