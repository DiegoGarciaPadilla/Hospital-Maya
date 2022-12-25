<!-- 

    JSP para agregar un campo a la tabla 'usuarios'.

    Este JSP contiene un formulario que al ser llenado y enviado ingresa en la
    tabla 'usuarios' una nueva tupla con los valores especificados.

-->


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
            <h1 class="titulo">Agregar usuario</h1>
            <hr>
            <br>
            <form action="${pageContext.request.contextPath}/UsuariosServlet?accion=insertar" method="post">
                <!-- Campo de tipo text para ingresar el usuario a registrar -->
                <div class="campo">
                    <input type="text" name="usuario" class="field" autocomplete="off" required>
                    <label for="usuario" class="form_label">
                        <span class="contenido">Usuario</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo password para ingresar la contraseña del usuario a registrar -->
                <div class="campo">
                    <input type="password" name="password" class="field" autocomplete="off" required>
                    <label for="password" class="form_label">
                        <span class="contenido">Contraseña</span>
                    </label>
                </div>
                <br>
                <div class="boton">
                    
                    <button type="submit">Registrar usuario</button>
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