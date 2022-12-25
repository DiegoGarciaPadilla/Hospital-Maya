package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import beans.Pacientes;
import datos.PacientesDAO;
import beans.Ingresos;
import datos.IngresosDAO;
import beans.Area;
import datos.AreaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet PacientesServlet
@WebServlet(name = "PacientesServlet", urlPatterns = {"/PacientesServlet"})
public class PacientesServlet extends HttpServlet {

    // Respuestas a las peticiones realizadas por el metodo GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'accion' de la peticion
        String accion = request.getParameter("accion");

        // Condicion que se realiza si el parametro 'accion' contiene algun valor
        if (accion != null) {
            switch (accion) {
                // Si el parametro 'accion' es igual a 'agregar'
                case "agregar":
                    // Ejecuta el metodo agregarPaciente, pasando los parametros
                    this.agregarPaciente(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'editar'
                case "editar":
                    // Ejecuta el metodo editarPaciente, pasando los parametros
                    this.editarPaciente(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'eliminar'
                case "eliminar":
                    // Ejecuta el metodo eliminarPaciente, pasando los parametros
                    this.eliminarPaciente(request, response);
                    break;
                // En caso de que no coincida se ejecuta la accion por default
                default:
                    this.accionDefault(request, response);
                    break;
            }
        // En caso de estar vacio
        } else {
            // Ejecuta la accion por defecto
            this.accionDefault(request, response);
        }
    }

    // Respuestas a las peticiones realizadas por el metodo POST
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'accion' de la peticion
        String accion = request.getParameter("accion");

        // Condicion que se realiza si el parametro 'accion' contiene algun valor
        if (accion != null) {
            switch (accion) {
                // Si el parametro 'accion' es igual a 'insertar'
                case "insertar":
                    // Ejecuta el metodo insertarPaciente, pasando los parametros
                    this.insertarPaciente(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'modificar'
                case "modificar":
                    // Ejecuta el metodo modifcarPaciente, pasando los parametros
                    this.modifcarPaciente(request, response);
                    break;
                // En caso contrario se ejecuta la accion por default
                default:
                    this.accionDefault(request, response);
                    break;
            }
        // En caso de no haber coincidencia
        } else {
            // Ejecuta la accion por defecto
            this.accionDefault(request, response);
        }
    }

    // Metodo que se ejecuta cuando hay una peticion default al serlvet
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Creacion de objeto de tipo PacientesDAO
        PacientesDAO pac = new PacientesDAO();
        // Lista que contiene todos los campos de la tabla 'pacientes' importados mediante el metodo listar() de la clase PacientesDAO
        List<Pacientes> pacientes = pac.listar();

        System.out.println("pacientes" + pacientes);
        // Agrega un atributo a la petición con los datos de la lista 'pacientes' 
        request.setAttribute("pacientes", pacientes);

        // Reririge la peticion al JSP pacientes
        request.getRequestDispatcher("/WEB-INF/paginas/pacientes.jsp").forward(request, response);

    }

    // Metodo que redirige al formulario para agregar un paciente y su ingreso
    protected void agregarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Creacion de objeto de tipo AreaDAO
        AreaDAO a = new AreaDAO();
        // Lista que contiene todos los campos de la tabla 'areas' importados mediante el metodo listar() de la clase AreaDAO
        List<Area> area = a.listar();

        System.out.println("area" + area);
        // Agrega un atributo a la petición con los datos de la lista 'area' 
        request.setAttribute("area", area);

        // Reririge la peticion al JSP agregar_paciente
        request.getRequestDispatcher("/WEB-INF/paginas/crud/agregar_paciente.jsp").forward(request, response);
    }

    // Metodo para agregar paciente
    protected void insertarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros desde el formulario
        
        // Parte de la tabla 'pacientes'
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String telefono = request.getParameter("telefono");
        String domicilio = request.getParameter("domicilio");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        String estado = request.getParameter("estado");
        
        // Parte de la tabla 'ingresos'
        String fecha_ingreso = request.getParameter("fecha_ingreso");
        String situacion = request.getParameter("situacion");
        int id_area = Integer.parseInt(request.getParameter("id_area"));

        // Objeto de tipo Pacientes que contiene los datos de los parametros de la parte del paciente
        Pacientes pacientes = new Pacientes(nombre, apellidoP, apellidoM, telefono, domicilio, edad, sexo, estado);
        //Insertar en la tabla 'pacientes'
        int registrosmodificados = new PacientesDAO().insertar(pacientes);
        System.out.println("Registros modificados: " + registrosmodificados);

        // Objeto de tipo Pacientes que contiene los datos de la fila que corresponde a la de los parametros importados
        Pacientes pacienteid = new PacientesDAO().encontrarId(pacientes);
        // Variable de tipo int que contiene el valor del id_paciente de los datos recien ingresados
        int id_paciente = pacienteid.getId_paciente();

        // Condicion que se realiza si hay registros modificados en la tabla 'pacientes'
        if (registrosmodificados != 0) {
            // Objeto de tipo Ingresos que contiene los datos de los parametros importados
            Ingresos ingresos = new Ingresos(id_paciente, fecha_ingreso, situacion, id_area);
            // Reririge la peticion al JSP agregar_paciente
            request.setAttribute("ingresos", ingresos);
            this.insertarIngreso(request, response);
        } else {
            this.accionDefault(request, response);
        }

    }

    // Metodo que redirige al servlet IngresosServlet con el paraetro 'accion' para hacer el ingrreso del paciente
    protected void insertarIngreso(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Realiza una peticion al Servlet IngresosServlet pasando el parametro 'accion' con valor de 'ingresoPaciente', pasando los parametros
        request.getRequestDispatcher("/IngresosServlet?accion=ingresoPaciente").forward(request, response);
    }

    // Metodo para redirigir al formulario para editar un paciente
    protected void editarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importa el parametro 'id_paciente' de la peticion
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));

        // Creacion de objeto de tipo PacientesDAO
        PacientesDAO pac = new PacientesDAO();
        // Objeto de tipo Pacientes que contiene el valor de los campos cuyo id_paciente coincida con el ingresado
        Pacientes paciente = pac.encontrar(id_paciente);

        // Agrega un atributo a la petición con los datos del objeto 'paciente' 
        request.setAttribute("paciente", paciente);

        // Reririge la peticion al JSP editar_paciente
        request.getRequestDispatcher("/WEB-INF/paginas/crud/editar_paciente.jsp").forward(request, response);
    }

    // Metodo para editar un paciente
    protected void modifcarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros desde el formulario
        
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String telefono = request.getParameter("telefono");
        String domicilio = request.getParameter("domicilio");
        int edad = Integer.parseInt(request.getParameter("edad"));
        String sexo = request.getParameter("sexo");
        String estado = request.getParameter("estado");

        // Objeto de tipo Pacientes que contiene los parametros importados
        Pacientes pacientes = new Pacientes(id_paciente, nombre, apellidoP, apellidoM, telefono, domicilio, edad, sexo, estado);
        // Actualizar campos en la tabla 'pacientes'
        int registrosmodificados = new PacientesDAO().actualizar(pacientes);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

    // Metodo para eliminar un paciente
    protected void eliminarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'id_paciente' de la peticion
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
        
        // Elimina campos en la tabla 'pacientes'
        int registrosmodificados = new PacientesDAO().eliminar(id_paciente);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }
    

}
