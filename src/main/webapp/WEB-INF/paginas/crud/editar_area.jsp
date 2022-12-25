<!-- 

    JSP para editar un campo a la tabla 'area'.

    Este JSP contiene un formulario que al ser llenado y enviado edita un campo
    especificado por el id_area en la tabla 'area' con los valores especificados.

-->


<%@page import="beans.Area"%>
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
            Area a = new Area();
            a = (Area) request.getAttribute("area");

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
            <h1 class="titulo">Editar médico</h1>
            <hr>
            <br>
            <form action="${pageContext.request.contextPath}/AreaServlet?accion=modificar" method="post">
                <!-- Campo de tipo number de solo lectura que contiene el ID del area (Sirve para el paso de parámetros) -->
                <div class="campo focusCampo">
                    <input type="number" name="id_area" class="field" autocomplete="off" value="<%=a.getId_area()%>" readonly autofocus>
                    <label for="matricula" class="form_label">
                        <span class="contenido">ID Area</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para editar la descripcion del area especificada por el ID del area -->
                <div class="campo">
                    <input type="text" name="descripcion" class="field" autocomplete="off" value="<%=a.getDescripcion()%>" required>
                    <label for="nombre" class="form_label">
                        <span class="contenido">Descripción</span>
                    </label>
                </div>
                <br>
                <br>
                <div class="boton">
                    <button type="submit">Modificar área</button>
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

