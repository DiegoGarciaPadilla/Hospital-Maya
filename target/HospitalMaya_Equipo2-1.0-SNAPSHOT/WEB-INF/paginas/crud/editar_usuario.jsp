<!-- 

    JSP para editar un campo a la tabla 'usuarios'.

    Este JSP contiene un formulario que al ser llenado y enviado edita un campo
    especificado por el id_usuario en la tabla 'usuaips' con los valores 
    especificados.

-->

<%@page import="beans.Usuarios"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content='width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link rel="stylesheet" href="recursos/css/estilo.css"/>
        <link rel="stylesheet" href="recursos/css/formularios.css"/>
        <link rel="shortcut icon" href="recursos/favicon.png"/>
        <script src="recursos/js/nav.js"></script>

        <title>Hospital Maya</title>
    </head>
    <body>
        
        <%
            Usuarios usr = new Usuarios();
            usr = (Usuarios) request.getAttribute("usuarios");

        %>

        <!-- Cabecera -->

        <header class="cabecera">
            <nav>
                <div class="nav_logo">
                    <img src="recursos/hospitalMaya.png" width="auto" height="100px" alt="hospitalMaya"/>
                </div>
                <ul class="nav_vinculos">
                    <li><a href="${pageContext.request.contextPath}/NavegarServlet?nav=inicio">Inicio</a></li>
                    <li><a href="${pageContext.request.contextPath}/NavegarServlet?nav=pacientes">Pacientes</a></li>
                    <li><a href="${pageContext.request.contextPath}/NavegarServlet?nav=medicos">Médicos</a></li>
                    <li><a href="${pageContext.request.contextPath}/NavegarServlet?nav=ingresos">Ingresos</a></li>
                    <li><a href="${pageContext.request.contextPath}/NavegarServlet?nav=usuario">Usuario</a></li>
                </ul>
                <div class="nav_icono" onclick=navMenu()>
                    <div class="linea1"></div>
                    <div class="linea2"></div>
                    <div class="linea3"></div>
                </div>
            </nav>
        </header>

        <!-- / Cabecera -->

        <!-- Contenido -->   

        <section class="cuerpo altura">
            <h1 class="titulo">Editar usuario</h1>
            <hr>
            <br>
            <form action="${pageContext.request.contextPath}/UsuariosServlet?accion=modificar" method="post">
                <!-- Campo de tipo number de solo lectura que contiene el ID del usuario (Sirve para el paso de parámetros) -->
                <div class="campo focusCampo">
                    <input type="number" name="id_usuario" class="field" autocomplete="off" value="<%=usr.getId_usuario()%>" readonly autofocus>
                    <label for="id_usuario" class="form_label">
                        <span class="contenido">ID Usuario</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para ingresar el usuario a editar -->
                <div class="campo">
                    <input type="text" name="usuario" class="field" autocomplete="off" value="<%=usr.getUsuario()%>" required>
                    <label for="usuario" class="form_label">
                        <span class="contenido">Usuario</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo password para ingresar la contraseña del usuario a editar -->
                <div class="campo">
                    <input type="text" name="password" class="field" autocomplete="off" value="<%=usr.getPassword()%>" required>
                    <label for="password" class="form_label">
                        <span class="contenido">Contraseña</span>
                    </label>
                </div>
                <br>
                <div class="boton">
                    <button type="submit">Editar usuario</button>
                    <button type="reset">Limpiar campos</button>
                </div>
            </form>
        </section>

        <!-- / Contenido -->

        <!--Pie de página-->

        <footer class="pie">
            <b>Equipo 2</b>
            <div class="integrantes">
                <p>Garcia Padilla Diego Antonio</p>
                <p>Garcia Ponce Nelly</p>
                <p>Oropeza Yañez Karem Alitzel</p>  
            </div>          
        </footer>

        <!--/ Pie de página-->

    </body>
</html>