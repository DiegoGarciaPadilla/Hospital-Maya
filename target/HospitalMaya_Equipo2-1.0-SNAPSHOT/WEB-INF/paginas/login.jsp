<!-- 

    JSP que contiene un formulario de inicio de sesión.

    Al ingresar valores en los campos de usuario y contraseña busca en la tabla 
    de 'usuarios' alguna coincidencia. En caso de encotrarla redirige al JSP de
    inicio, en caso contrario redirige al JSP 'error.jsp' el cual poseé una
    aletra emergente que avisa al usuario del error y redirige a esta página.

-->

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content='width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;' name='viewport' />
        <meta name="viewport" content="width=device-width" />
        
        <link rel="stylesheet" href="recursos/css/estilo.css"/>
        <link rel="stylesheet" href="recursos/css/login.css"/>
        <link rel="shortcut icon" href="recursos/favicon.png"/>
        
        <title>Iniciar sesion</title>
    </head>
    <body>
        <section class="cuerpo">
            <section class="contenedor100">
                
                <!-- Formulario de login -->
                
                <form class="form_login admin" action="${pageContext.request.contextPath}/LoginServlet?accion=iniciarSesion" method="post">
                    <img src="recursos/hospitalMaya.png" width="323" height="118" alt="hospitalMaya"/>
                    <h3>Iniciar sesión</h3>
                    <!-- Campo de tipo text para ingresar el usuario -->
                    <div class="campo">
                        <input type="text" name="usuario" class="field" autocomplete="off" required>
                        <label for="txtUsuario" class="form_label">
                            <span class="contenido">Usuario</span>
                        </label>
                    </div>
                    <!-- Campo de tipo password para ingresar la contraseña -->
                    <div class="campo">
                        <input type="password" name="password" class="field" autocomplete="off" required>
                        <label for="txtPassword" class="form_label">
                            <span class="contenido">Contraseña</span>
                        </label>
                    </div>
                    <br>
                    <div class="boton">
                        <button type="submit">Iniciar sesión</button>
                    </div>
                </form>
                    
                    <!-- / Formulario de login -->
                    
            </section>
        </section>
    </body>
</html>
