<!-- 

    JSP para agregar un campo a la tabla 'paciente_medico'.

    Este JSP contiene un formulario que al ser llenado y enviado ingresa en la
    tabla 'paciente_medico' una nueva tupla con los valores especificados mediante
    dos campos de tipo select que importan los datos del campo id_paciente de 
    la tabla 'pacientes', asi como el nombre, apellidoP y apellidoM para una 
    mejor comprensión; y otro que importa los  datos del campo matricula de la 
    tabla 'medicos', además del nombre, apellidoP y apellidoM para una 
    mejor comprensión de la misma.

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
            <h1 class="titulo">Agregar relación de medico y paciente</h1>
            <hr>
            <br>
            <form action="${pageContext.request.contextPath}/Paciente_MedicoServlet?accion=insertar" method="post">
                <!-- Campo de tipo select que importa el id_paciente de la tabla 'pacientes' para ingresar el ID del paciente a relacionar -->
                <div class="campo">
                    <select name="id_paciente">
                        <option selected disabled>ID Paciente</option>
                        <c:forEach var="pac" items="${pacientes}">
                        <option value="${pac.id_paciente}">${pac.id_paciente} - ${pac.nombre} ${pac.apellidoP} ${pac.apellidoM}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <!-- Campo de tipo select que importa la matricula de la tabla 'medicos' para ingresar la matricula del medico a relacionar -->
                <div class="campo">
                    <select name="matricula">
                        <option selected disabled>Matricula</option>
                        <c:forEach var="med" items="${medicos}">
                        <option value="${med.matricula}">${med.matricula} - ${med.nombre} ${med.apellidoP} ${med.apellidoM}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="boton">
                    <button type="submit">Agregar relación de paciente y medico</button>
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
