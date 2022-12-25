<!-- 

    JSP para agregar un campo a la tabla 'paciente' e 'ingresos'.

    Este JSP contiene un formulario que al ser llenado y enviado ingresa en la
    tabla 'paciente' una nueva tupla con los valores de los campos de nombre,
    apellido paterno, apellido materno, telefono, domicilio, edad, sexo y estado;
    y en la tabla 'ingresos' con los valores de los campos de fecha del ingreso,
    situación y el area en donde reside.

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
            <h1 class="titulo">Registrar paciente</h1>
            <hr>
            <br>
            <form action="${pageContext.request.contextPath}/PacientesServlet?accion=insertar" method="post">
                <!-- Campo de tipo text para ingresar el nombre del paciente en la tabla 'paciente' -->
                <div class="campo">
                    <input type="text" name="nombre" class="field" autocomplete="off" required>
                    <label for="nombre" class="form_label">
                        <span class="contenido">Nombre</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para ingresar el apellido paterno del paciente en la tabla 'paciente' -->
                <div class="campo">
                    <input type="text" name="apellidoP" class="field" autocomplete="off" required>
                    <label for="apellidoP" class="form_label">
                        <span class="contenido">Apellido paterno</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para ingresar el apellido materno del paciente en la tabla 'paciente' -->
                <div class="campo">
                    <input type="text" name="apellidoM" class="field" autocomplete="off" required>
                    <label for="apellidoM" class="form_label">
                        <span class="contenido">Apellido materno</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo number para ingresar el telefono del paciente en la tabla 'paciente' -->
                <div class="campo">
                    <input type="number" name="telefono" class="field" autocomplete="off" required>
                    <label for="telefono" class="form_label">
                        <span class="contenido">Teléfono</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo text para ingresar el domicilio del paciente en la tabla 'paciente' -->
                <div class="campo">
                    <input type="text" name="domicilio" class="field" autocomplete="off" required>
                    <label for="domicilio" class="form_label">
                        <span class="contenido">Domicilio</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo number para ingresar la edad del paciente en la tabla 'paciente' -->
                <div class="campo">
                    <input type="number" name="edad" class="field" autocomplete="off" min="0" required>
                    <label for="edad" class="form_label">
                        <span class="contenido">Edad</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo select para ingresar el sexo del paciente en la tabla 'paciente' -->
                <div class="campo">
                    <select name="sexo">
                        <option selected disabled>Sexo</option>
                        <option value="M">M - Masculino</option>
                        <option value="F">F - Femenino</option>
                    </select>
                </div>
                <br>
                <div class="campo">
                    <input type="text" name="estado" class="field" autocomplete="off" required>
                    <label for="estado" class="form_label">
                        <span class="contenido">Estado</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo date para ingresar la fecha de ingreso en la tabla 'ingresos' -->
                <div class="campo">
                    <label for="fecha_ingreso" class="form_label">Fecha del ingreso</label>
                    <input style="border-bottom: 1px solid #333" type="date" name="fecha_ingreso" class="field" autocomplete="off" required>
                </div>
                <!-- Campo de tipo text para ingresar la situacion especificada por el ID del ingreso n la tabla 'ingresos' -->
                <div class="campo">
                    <input type="text" name="situacion" class="field" autocomplete="off" required>
                    <label for="id_paciente" class="form_label">
                        <span class="contenido">Situación</span>
                    </label>
                </div>
                <br>
                <!-- Campo de tipo select que importa el id_area de la tabla 'area' para ingresar el ID de area n la tabla 'ingresos' -->
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
                    <button type="submit">Agregar pacientes</button>
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
