<!-- 

    JSP de usuarios.

    Esta página permite visualzar el contenido de la tabla 'usuarios', agregar,
    editar y eliminar campos de esta.

-->

<%@page import="beans.Usuarios"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta content='width=device-width; initial-scale=1.0; maximum-scale=1.0; user-scalable=0;' name='viewport' />
        <meta name="viewport" content="width=device-width" />

        <link rel="stylesheet" href="recursos/css/estilo.css"/>
        <link rel="stylesheet" href="recursos/css/tablas.css"/>
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
            <h1 class="titulo">Usuarios</h1>
            <hr>
            <br>

            <!-- Tabla -->

            <table>
                <thead>
                    <tr>
                        <th>ID Usuario</th>
                        <th>Usuario</th>
                        <th>Contraseña</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Ciclo que se repite hasta ingresar todos los datos de la tabla 'usuarios' -->
                    <c:forEach var="usr" items="${usuarios}">
                        <tr>
                            <td>${usr.id_usuario}</td>
                            <td>${usr.usuario}</td>
                            <td>${usr.password}</td>
                            <td><a href="${pageContext.request.contextPath}/UsuariosServlet?accion=editar&id_usuario=${usr.id_usuario}">Editar</a></td>
                            <td><a href="${pageContext.request.contextPath}/UsuariosServlet?accion=eliminar&id_usuario=${usr.id_usuario}">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- / Tabla -->

            <div class="boton">
                <button onclick="window.location.href = '${pageContext.request.contextPath}/UsuariosServlet?accion=agregar'">Registrar paciente</button>
            </div>

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
