package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import beans.Ingresos;
import datos.IngresosDAO;
import beans.Pacientes;
import datos.PacientesDAO;
import beans.Area;
import datos.AreaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet IngresosServlet
@WebServlet(name = "IngresosServlet", urlPatterns = {"/IngresosServlet"})
public class IngresosServlet extends HttpServlet {

    // Respuestas a las peticiones realizadas por el metodo GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'accion' de la peticion
        String accion = request.getParameter("accion");

        // Condicion que se realiza si el parametro 'accion' contiene algun valor
        if (accion != null) {
            switch (accion) {
                // Si el parametro 'accion' es igual a 'ingresoPaciente'
                case "ingresoPaciente":
                    // Ejecuta el metodo insertarPaciente, pasando los parametros
                    this.insertarPaciente(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'editar'
                case "editar":             
                    // Ejecuta el metodo editarIngresos, pasando los parametros
                    this.editarIngresos(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'eliminar'
                case "eliminar":
                    // Ejecuta el metodo eliminarIngresos, pasando los parametros
                    this.eliminarIngresos(request, response);
                    break;
                // En caso de que no coincida se ejecuta la accion por default
                default:
                    this.accionDefault(request, response);
                    break;
            }
        // En caso de estar vacio
        } else {
            // Redirige a la accion default
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
                // Si el parametro 'accion' es igual a 'ingresoPaciente'
                case "ingresoPaciente":
                    // Ejecuta el metodo insertarPaciente, pasando los parametros
                    this.insertarPaciente(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'modificar'
                case "modificar":
                    // Ejecuta el metodo modifcarIngresos, pasando los parametros
                    this.modifcarIngresos(request, response);
                    break;
                // En caso de que no coincida se ejecuta la accion por default
                default:
                    this.accionDefault(request, response);
                    break;
            }
        // En caso de estar vacio
        } else {
            // Redirige a la accion default
            this.accionDefault(request, response);
        }
    }

    // Metodo que se ejecuta cuando hay una peticion default al serlvet
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Creacion de objeto de tipo IngresosDAO
        IngresosDAO ing = new IngresosDAO();
        // Lista que contiene todos los campos de la tabla 'ingresos' importados mediante el metodo listar() de la clase IngresosDAO
        List<Ingresos> ingresos = ing.listar();
        
        System.out.println("ingresos" + ingresos);
        // Agrega un atributo a la petición con los datos de la lista 'ingresos' 
        request.setAttribute("ingresos", ingresos);
        
        // Reririge la peticion al JSP ingresos
        request.getRequestDispatcher("/WEB-INF/paginas/ingresos.jsp").forward(request, response);

    }

    // Metodo que ingresa un paciente
    protected void insertarPaciente(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importacion del parametro 'ingresos' desde la peticion
        Ingresos ingresos = (Ingresos)request.getAttribute("ingresos");
        
        // Ingresar datos del objeto 'ingresos' en la tabla 'ingresos'
        int registrosmodificados = new IngresosDAO().insertar(ingresos);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
        
    }

    // Metodo que redirige al formulario para editar un ingreso
    protected void editarIngresos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'id_paciente_medico' de la peticion
        int id_ingreso = Integer.parseInt(request.getParameter("id_ingreso"));

         // Creacion de objeto de tipo IngresosDAO
        IngresosDAO ing = new IngresosDAO();
        // Objeto de tipo Ingresos que contiene el valor de los campos cuyo id_ingreso coincida con el ingresado
        Ingresos ingresos = ing.encontrar(id_ingreso);
        
        System.out.println("ingresos" + ingresos);
        // Agrega un atributo a la petición con los datos del objeto 'ingresos'
        request.setAttribute("ingresos", ingresos);
        
        // Creacion de objeto de tipo PacientesDAO
        PacientesDAO pac = new PacientesDAO();
        // Lista que contiene todos los campos de la tabla 'pacientes' importados mediante el metodo listar() de la clase PacientesDAO
        List<Pacientes> pacientes = pac.listar();

        System.out.println("pacientes" + pacientes);
        // Agrega un atributo a la petición con los datos del objeto 'pacientes'
        request.setAttribute("pacientes", pacientes);
        
        // Creacion de objeto de tipo PacientesDAO
        AreaDAO a = new AreaDAO();
        // Lista que contiene todos los campos de la tabla 'areas' importados mediante el metodo listar() de la clase AreaDAO
        List<Area> area = a.listar();

        System.out.println("area" + area);
        // Agrega un atributo a la petición con los datos del objeto 'area'
        request.setAttribute("area", area);

        // Reririge la peticion al JSP editar_ingreso
        request.getRequestDispatcher("/WEB-INF/paginas/crud/editar_ingreso.jsp").forward(request, response);
    }

    // Metodo para modificar un ingreso
    protected void modifcarIngresos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros desde el formulario
        
        int id_ingreso = Integer.parseInt(request.getParameter("id_ingreso"));
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
        String fecha_ingreso = request.getParameter("fecha_ingreso");
        String situacion = request.getParameter("situacion");
        int id_area = Integer.parseInt(request.getParameter("id_area"));

        // Objeto de tipo Ingresos que contiene los parametros importados
        Ingresos ingresos = new Ingresos(id_ingreso, id_paciente, fecha_ingreso, situacion, id_area);
        // Actualizar campos en la tabla 'ingresos'
        int registrosmodificados = new IngresosDAO().actualizar(ingresos);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

    // Metodo para eliminar un ingreso
    protected void eliminarIngresos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'id_ingreso' de la peticion
        int id_ingreso = Integer.parseInt(request.getParameter("id_ingreso"));

        // Elimina campos en la tabla 'ingresos'
        int registrosmodificados = new IngresosDAO().eliminar(id_ingreso);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

}
