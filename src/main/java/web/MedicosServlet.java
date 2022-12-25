package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import beans.Medicos;
import datos.MedicosDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet MedicosServlet
@WebServlet(name = "MedicosServlet", urlPatterns = {"/MedicosServlet"})
public class MedicosServlet extends HttpServlet {

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
                    // Ejecuta el metodo agregarMedicos, pasando los parametros
                    this.agregarMedicos(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'editar'
                case "editar":
                    // Ejecuta el metodo editarMedicos, pasando los parametros
                    this.editarMedicos(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'eliminar'
                case "eliminar":
                    // Ejecuta el metodo eliminarPaciente, pasando los parametros
                    this.eliminarMedicos(request, response);
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
                // Si el parametro 'accion' es igual a 'insertar'
                case "insertar":
                    // Ejecuta el metodo insertarMedicos, pasando los parametros
                    this.insertarMedicos(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'modificar'
                case "modificar":
                    // Ejecuta el metodo modifcarMedicos, pasando los parametros
                    this.modifcarMedicos(request, response);
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

        // Creacion de objeto de tipo MedicosDAO
        MedicosDAO med = new MedicosDAO();
        // Lista que contiene todos los campos de la tabla 'medicos' importados mediante el metodo listar() de la clase MedicosDAO
        List<Medicos> medicos = med.listar();

        System.out.println("medicos" + medicos);
        // Agrega un atributo a la petición con los datos de la lista 'medicos' 
        request.setAttribute("medicos", medicos);
        
        // Reririge la peticion al JSP medicos
        request.getRequestDispatcher("/WEB-INF/paginas/medicos.jsp").forward(request, response);

    }

    // Metodo que redirige al formulario para agregar un medico
    protected void agregarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Reririge la peticion al JSP agregar_medico
        request.getRequestDispatcher("/WEB-INF/paginas/crud/agregar_medico.jsp").forward(request, response);
    }

    // Metodo que ingresa un medico
    protected void insertarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros desde el formulario
        
        int matricula = Integer.parseInt(request.getParameter("matricula"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String telefono = request.getParameter("telefono");
        String domicilio = request.getParameter("domicilio");
        String especialidad = request.getParameter("especialidad");
        
        // Objeto de tipo Medicos que contiene los parametros importados
        Medicos medicos = new Medicos(matricula, nombre, apellidoP, apellidoM, telefono, domicilio, especialidad);
        // Ingresar datos del objeto 'medicos' en la tabla 'medicos'
        int registrosmodificados = new MedicosDAO().insertar(medicos);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

    // Metodo que redirige al formulario para editar un medico
    protected void editarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'matricula' de la peticion
        int matricula = Integer.parseInt(request.getParameter("matricula"));

        // Creacion de objeto de tipo MedicosDAO
        MedicosDAO med = new MedicosDAO();
        // Objeto de tipo Medicos que contiene el valor de los campos cuyo matricula coincida con el ingresado
        Medicos medicos = med.encontrar(matricula);

        // Agrega un atributo a la petición con los datos del objeto 'medicos' 
        request.setAttribute("medicos", medicos);

        // Reririge la peticion al JSP editar_paciente
        request.getRequestDispatcher("/WEB-INF/paginas/crud/editar_medico.jsp").forward(request, response);
    }

    // Metodo para modificar los datos de un medico
    protected void modifcarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros desde el formulario
        
        int matricula = Integer.parseInt(request.getParameter("matricula"));
        String nombre = request.getParameter("nombre");
        String apellidoP = request.getParameter("apellidoP");
        String apellidoM = request.getParameter("apellidoM");
        String telefono = request.getParameter("telefono");
        String domicilio = request.getParameter("domicilio");
        String especialidad = request.getParameter("especialidad");

        // Objeto de tipo Medicos que contiene los parametros importados
        Medicos medicos = new Medicos(matricula, nombre, apellidoP, apellidoM, telefono, domicilio, especialidad);
        // Actualizar campos en la tabla 'medicos'
        int registrosmodificados = new MedicosDAO().actualizar(medicos);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }
    
    protected void eliminarMedicos(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importa el parametro 'matricula' de la peticion
        int matricula = Integer.parseInt(request.getParameter("matricula"));
        
        // Elimina campos en la tabla 'medicos'
        int registrosmodificados = new MedicosDAO().eliminar(matricula);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

}
