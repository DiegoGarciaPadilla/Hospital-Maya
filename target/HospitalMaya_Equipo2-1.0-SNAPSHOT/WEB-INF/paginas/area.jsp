<!-- 

    JSP de area.

    Esta página permite visualzar el contenido de la tabla 'areas', agregar,
    editar y eliminar campos de esta.

-->

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
            <h1 class="titulo">Área del hospital</h1>
            <hr>
            <br>

            <!-- Tabla -->

            <table>
                <thead>
                    <tr>
                        <th>ID Area</th>
                        <th>Descripción</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Ciclo que se repite hasta ingresar todos los datos de la tabla 'areas' -->
                    <c:forEach var="a" items="${area}">
                        <tr>
                            <td>${a.id_area}</td>
                            <td>${a.descripcion}</td>
                            <td><a href="${pageContext.request.contextPath}/AreaServlet?accion=editar&id_area=${a.id_area}">Editar</a></td>
                            <td><a href="${pageContext.request.contextPath}/AreaServlet?accion=eliminar&id_area=${a.id_area}">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <br>

            <div class="boton">
                <button onclick="window.location.href = '${pageContext.request.contextPath}/AreaServlet?accion=agregar'">Agregar nueva área</button>
            </div>

            <!-- / Tabla -->

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


