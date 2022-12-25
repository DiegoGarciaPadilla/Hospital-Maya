<!-- 

    JSP para editar un campo a la tabla 'pacientes'.

    Este JSP contiene un formulario que al ser llenado y enviado edita un campo
    especificado por la id_paciente en la tabla 'pacientes' con los valores 
    especificados.

-->

<%@page import="beans.Pacientes"%>
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
            Pacientes pac = new Pacientes();
            pac = (Pacientes) request.getAttribute("paciente");

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
            <h1 class="titulo">Editar paciente</h1>
            <hr>
            <br>
            <form action="${pageContext.request.contextPath}/PacientesServlet?accion=modificar" method="post">
                <div class="campo focusCampo">
                    <input type="number" name="id_paciente" class="field" value="<%=pac.getId_paciente()%>" readonly required autofocus>
                    <label for="id_paciente" class="form_label">
                        <span class="contenido">ID Paciente</span>
                    </label>
                </div>
                    <br>
                <div class="campo">
                    <input type="text" name="nombre" class="field" autocomplete="off" value="<%=pac.getNombre()%>" required>
                    <label for="nombre" class="form_label">
                        <span class="contenido">Nombre</span>
                    </label>
                </div>    
                <br>
                <div class="campo">
                    <input type="text" name="apellidoP" class="field" autocomplete="off" value="<%=pac.getApellidoP()%>" required>
                    <label for="apellidoP" class="form_label">
                        <span class="contenido">Apellido paterno</span>
                    </label>
                </div>
                <br>
                <div class="campo">
                    <input type="text" name="apellidoM" class="field" autocomplete="off" value="<%=pac.getApellidoM()%>" required>
                    <label for="apellidoM" class="form_label">
                        <span class="contenido">Apellido materno</span>
                    </label>
                </div>
                <br>
                <div class="campo">
                    <input type="number" name="telefono" class="field" autocomplete="off" value="<%=pac.getTelefono()%>" required>
                    <label for="telefono" class="form_label">
                        <span class="contenido">Teléfono</span>
                    </label>
                </div>
                <br>
                <div class="campo">
                    <input type="text" name="domicilio" class="field" autocomplete="off" value="<%=pac.getDomicilio()%>" required>
                    <label for="domicilio" class="form_label">
                        <span class="contenido">Domicilio</span>
                    </label>
                </div>
                <br>
                <div class="campo">
                    <input type="number" name="edad" class="field" autocomplete="off" value="<%=pac.getEdad()%>" min="0" required>
                    <label for="edad" class="form_label">
                        <span class="contenido">Edad</span>
                    </label>
                </div>
                <br>
                <div class="campo">
                    <select name="sexo">
                        <option disabled>Sexo</option>
                        <c:set var="sexo" value="<%=pac.getSexo()%>" scope="page" />
                        <c:if test="${sexo == 'M'}">
                            <option value='M' selected>M - Masculino</option>
                            <option value='F'>F - Femenino</option>
                        </c:if>
                        <c:if test="${sexo == 'F'}">
                            <option value='M'>M - Masculino</option>
                            <option value='F' selected>F - Femenino</option>
                        </c:if>
                    </select>
                </div>
                <br>
                <div class="campo">
                    <input type="text" name="estado" class="field" autocomplete="off" value="<%=pac.getEstado()%>" required>
                    <label for="estado" class="form_label">
                        <span class="contenido">Estado</span>
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

