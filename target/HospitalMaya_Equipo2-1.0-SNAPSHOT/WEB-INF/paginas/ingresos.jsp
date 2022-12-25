<!-- 

    JSP de ingresos.

    Esta página permite visualzar el contenido de la tabla 'ingresos', editar y 
    eliminar campos de esta, asi como contener un vínculo que redirige hacia el 
    JSP de 'area'.

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
            <h1 class="titulo">Ingresos</h1>
            <hr>
            <br>

            <!-- Tabla -->

            <table>
                <thead>
                    <tr>
                        <th>ID Ingreso</th>
                        <th>ID Paciente</th>
                        <th>Fecha del ingreso</th>
                        <th>Situación</th>
                        <th>ID Area</th>
                        <th colspan="2">Acciones</th>
                    </tr>
                </thead>
                <tbody
                    <!-- Ciclo que se repite hasta ingresar todos los datos de la tabla 'ingresos' -->
                    <c:forEach var="ing" items="${ingresos}">
                        <tr>
                            <td>${ing.id_ingreso}</td>
                            <td>${ing.id_paciente}</td>
                            <td>${ing.fecha_ingreso}</td>
                            <td>${ing.situacion}</td>
                            <td>${ing.id_area}</td>
                            <td><a href="${pageContext.request.contextPath}/IngresosServlet?accion=editar&id_ingreso=${ing.id_ingreso}">Editar</a></td>
                            <td><a href="${pageContext.request.contextPath}/IngresosServlet?accion=eliminar&id_ingreso=${ing.id_ingreso}">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>

            <!-- / Tabla -->

            <br>
            <h2>Si desea acceder a la tabla de áreas del hospital <a href="${pageContext.request.contextPath}/AreaServlet" id="vinculo">clic aquí.</a></h2>

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
