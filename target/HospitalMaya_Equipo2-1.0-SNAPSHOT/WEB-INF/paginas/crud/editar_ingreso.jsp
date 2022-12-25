<!-- 

    JSP para editar un campo a la tabla 'ingreso'.

    Este JSP contiene un formulario que al ser llenado y enviado edita un campo
    especificado por el id_ingreso en la tabla 'ingreso' con los valores 
    especificados.

-->

<%@page import="beans.Ingresos"%>
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

        <%
            Ingresos ing = new Ingresos();
            ing = (Ingresos) request.getAttribute("ingresos");

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
            <h1 class="titulo">Editar ingreso</h1>
            <hr>
            <br>
            <form action="${pageContext.request.contextPath}/IngresosServlet?accion=modificar" method="post">
                <!-- Campo de tipo number de solo lectura que contiene el ID del ingreso (Sirve para el paso de parámetros) -->
                <div class="campo focusCampo">
                    <input type="number" name="id_ingreso" class="field" autocomplete="off" value="<%=ing.getId_ingreso()%>" readonly autofocus>
                    <label for="id_ingreso" class="form_label">
                        <span class="contenido">ID Ingreso</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo select que importa el id_paciente de la tabla 'pacientes' para editar el ID del paciente -->
                <div class="campo">
                    <select name="id_paciente">
                        <option selected disabled>ID Paciente</option>
                        <c:forEach var="pac" items="${pacientes}">
                            <option value="${pac.id_paciente}">${pac.id_paciente} - ${pac.nombre} ${pac.apellidoP} ${pac.apellidoM}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <!-- Campo de tipo date para editar la fecha de ingreso especificado por el ID del ingreso -->
                <div class="campo">
                    <label for="fecha_ingreso" class="form_label">Fecha del ingreso</label>
                    <input style="border-bottom: 1px solid #333" type="date" name="fecha_ingreso" class="field" autocomplete="off" value="<%=ing.getFecha_ingreso()%>" required>
                </div>
                <br>
                <!-- Campo de tipo text para editar la situacion especificada por el ID del ingreso -->
                <div class="campo">
                    <input type="text" name="situacion" class="field" autocomplete="off" value="<%=ing.getSituacion()%>" required>
                    <label for="id_paciente" class="form_label">
                        <span class="contenido">Situación</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo select que importa el id_area de la tabla 'area' para editar el ID de area especificada por el ID del ingreso -->
                <div class="campo">
                    <select name="id_area">
                        <option selected disabled>ID Area</option>
                        <c:forEach var="a" items="${area}">
                            <option value="${a.id_area}">${a.id_area} - ${a.descripcion}</option>
                        </c:forEach>
                    </select>
                </div>
                <br>
                <div class="boton">
                    <button type="submit">Editar ingreso</button>
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
