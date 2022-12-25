<!-- 

    JSP de pacientes.

    Esta página permite visualzar el contenido de la tabla 'pacientes', editar
    y eliminar campos de esta y agregar tuplas tanto en esta tabla como en la 
    tabla de 'ingresos', asi como contener un vínculo que redirige hacia el JSP 
    de 'paciente_medico'.

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
            <h1 class="titulo">Pacientes</h1>
            <hr>
            <br>

            <!-- Tabla -->

            <table>
                <thead>
                    <tr>
                        <th>ID Paciente</th>
                        <th>Nombre(s)</th>
                        <th>Apellido paterno</th>
                        <th>Apellido materno</th>
                        <th>Teléfono</th>
                        <th>Domicilio</th>
                        <th>Edad</th>
                        <th>Sexo</th>
                        <th>Estado</th>
                        <th colspan="3">Acciones</th>
                    </tr>
                </thead>
                <tbody>
                    <!-- Ciclo que se repite hasta ingresar todos los datos de la tabla 'pacientes' -->
                    <c:forEach var="pac" items="${pacientes}">
                        <tr>
                            <td>${pac.id_paciente}</td>
                            <td>${pac.nombre}</td>
                            <td>${pac.apellidoP}</td>
                            <td>${pac.apellidoM}</td>
                            <td>${pac.telefono}</td>
                            <td>${pac.domicilio}</td>
                            <td>${pac.edad}</td>
                            <td>${pac.sexo}</td>
                            <td>${pac.estado}</td>
                            <td><a href="${pageContext.request.contextPath}/PacientesServlet?accion=editar&id_paciente=${pac.id_paciente}">Editar</a></td>
                            <td><a href="${pageContext.request.contextPath}/PacientesServlet?accion=eliminar&id_paciente=${pac.id_paciente}">Eliminar</a></td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
            <br>
            <p>Nota: no se puede eliminar un paciente si existe una relación de médico y paciente que lo incluya</p>
            <br>

            <div class="boton">
                <button onclick="window.location.href = '${pageContext.request.contextPath}/PacientesServlet?accion=agregar'">Registrar paciente</button>
            </div>

            <!-- / Tabla -->

            <br>
            <h2>Para visualizar a los médicos que atienden a los pacientes <a href="${pageContext.request.contextPath}/Paciente_MedicoServlet" id="vinculo">clic aquí.</a></h2>

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
