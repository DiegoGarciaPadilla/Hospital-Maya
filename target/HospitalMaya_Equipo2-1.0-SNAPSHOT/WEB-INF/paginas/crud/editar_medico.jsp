<!-- 

    JSP para editar un campo a la tabla 'medicos'.

    Este JSP contiene un formulario que al ser llenado y enviado edita un campo
    especificado por la matricula en la tabla 'medicos' con los valores 
    especificados.

-->

<%@page import="beans.Medicos"%>
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
            Medicos med = new Medicos();
            med = (Medicos) request.getAttribute("medicos");

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
            <form action="${pageContext.request.contextPath}/MedicosServlet?accion=modificar" method="post">
                <!-- Campo de tipo number de solo lectura que contiene la matricula del medico (Sirve para el paso de parámetros) -->
                <div class="campo focusCampo">
                    <input type="number" name="matricula" class="field" autocomplete="off" value="<%=med.getMatricula()%>" readonly required>
                    <label for="matricula" class="form_label">
                        <span class="contenido">Matrícula</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para editar el nombre del medico especificado por su matricula -->
                <div class="campo">
                    <input type="text" name="nombre" class="field" autocomplete="off" value="<%=med.getNombre()%>" required>
                    <label for="nombre" class="form_label">
                        <span class="contenido">Nombre</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para editar el apellido paterno del medico especificado por su matricula -->
                <div class="campo">
                    <input type="text" name="apellidoP" class="field" autocomplete="off" value="<%=med.getApellidoP()%>" required>
                    <label for="apellidoP" class="form_label">
                        <span class="contenido">Apellido paterno</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para editar el apellido materno del medico especificado por su matricula -->
                <div class="campo">
                    <input type="text" name="apellidoM" class="field" autocomplete="off" value="<%=med.getApellidoM()%>" required>
                    <label for="apellidoM" class="form_label">
                        <span class="contenido">Apellido materno</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo number para editar el telefono del medico especificado por su matricula -->
                <div class="campo">
                    <input type="number" name="telefono" class="field" autocomplete="off" value="<%=med.getTelefono()%>" required>
                    <label for="telefono" class="form_label">
                        <span class="contenido">Teléfono</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para editar el domicilio del medico especificado por su matricula -->
                <div class="campo">
                    <input type="text" name="domicilio" class="field" autocomplete="off" value="<%=med.getDomicilio()%>" required>
                    <label for="domicilio" class="form_label">
                        <span class="contenido">Domicilio</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para editar la especialidad del medico especificado por su matricula -->
                <div class="campo">
                    <input type="text" name="especialidad" class="field" autocomplete="off" value="<%=med.getEspecialidad()%>" min="0" required>
                    <label for="especialidad" class="form_label">
                        <span class="contenido">Especialidad</span>
                    </label>
                </div>
                <br>
                <div class="boton">
                    <button type="submit">Modificar médico</button>
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

