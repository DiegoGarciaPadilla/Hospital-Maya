package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import beans.Paciente_Medico;
import datos.Paciente_MedicoDAO;
import beans.Pacientes;
import datos.PacientesDAO;
import beans.Medicos;
import datos.MedicosDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet Paciente_MedicoServlet
@WebServlet(name = "Paciente_MedicoServlet", urlPatterns = {"/Paciente_MedicoServlet"})
public class Paciente_MedicoServlet extends HttpServlet {

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
                    // Ejecuta el metodo agregarPaciente_Medico, pasando los parametros
                    this.agregarPaciente_Medico(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'editar'
                case "editar":
                    // Ejecuta el metodo editarPaciente_Medico, pasando los parametros
                    this.editarPaciente_Medico(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'eliminar'
                case "eliminar":
                    // Ejecuta el metodo eliminarPaciente_Medico, pasando los parametros
                    this.eliminarPaciente_Medico(request, response);
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
                    // Ejecuta el metodo insertarPaciente_Medico, pasando los parametros
                    this.insertarPaciente_Medico(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'modificar'
                case "modificar":
                    // Ejecuta el metodo modifcarPaciente_Medico, pasando los parametros
                    this.modifcarPaciente_Medico(request, response);
                    break;
                default:
                // En caso de que no coincida se ejecuta la accion por default
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

        // Creacion de objeto de tipo Paciente_MedicoDAO
        Paciente_MedicoDAO pa_me = new Paciente_MedicoDAO();
        // Lista que contiene todos los campos de la tabla 'paciente_medico' importados mediante el metodo listar() de la clase Paciente_MedicoDAO
        List<Paciente_Medico> paciente_medico = pa_me.listar();

        System.out.println("paciente_medico" + paciente_medico);
        // Agrega un atributo a la petición con los datos de la lista 'paciente_medico' 
        request.setAttribute("paciente_medico", paciente_medico);
        
        // Reririge la peticion al JSP paciente_medico
        request.getRequestDispatcher("/WEB-INF/paginas/paciente_medico.jsp").forward(request, response);

    }

    // Metodo que redirige al formulario para agregar una relacion paciente_medico
    protected void agregarPaciente_Medico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obejto de tipo PacientesDAO
        PacientesDAO pac = new PacientesDAO();
        // Lista que contiene todos los campos de la tabla 'pacientes' importados mediante el metodo listar() de la clase PacientesDAO
        List<Pacientes> pacientes = pac.listar();

        System.out.println("pacientes" + pacientes);
        // Agrega un atributo a la petición con los datos de la lista 'pacientes' 
        request.setAttribute("pacientes", pacientes);
        
        // Obejto de tipo PacientesDAO
        MedicosDAO med = new MedicosDAO();
        // Lista que contiene todos los campos de la tabla 'medicos' importados mediante el metodo listar() de la clase MedicosDAO
        List<Medicos> medicos = med.listar();

        System.out.println("medicos" + medicos);
        // Agrega un atributo a la petición con los datos de la lista 'medicos' 
        request.setAttribute("medicos", medicos);
        
        // Reririge la peticion al JSP agregar_paciente
        request.getRequestDispatcher("/WEB-INF/paginas/crud/agregar_paciente_medico.jsp").forward(request, response);
    }

    // Metodo para agregar una relacion de paciente y medico
    protected void insertarPaciente_Medico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de parametros desde el formulario
        
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
        int matricula = Integer.parseInt(request.getParameter("matricula"));
        
        // Objeto de tipo Paciente_Medico que contiene los parametros importados
        Paciente_Medico paciente_medico = new Paciente_Medico(id_paciente, matricula);
        // Ingresar datos del objeto 'paciente_medico' en la tabla 'paciente_medico'
        int registrosmodificados = new Paciente_MedicoDAO().insertar(paciente_medico);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

    // Metodo que redirige al formularioo para editar una relacion de paciente y medico
    protected void editarPaciente_Medico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'id_paciente_medico' de la peticion
        int id_paciente_medico = Integer.parseInt(request.getParameter("id_paciente_medico"));

        // Creacion de objeto de tipo Paciente_MedicoDAO
        Paciente_MedicoDAO pac_med = new Paciente_MedicoDAO();
        // Objeto de tipo Paciente_Medico que contiene el valor de los campos cuyo matricula coincida con el ingresado
        Paciente_Medico paciente_medico = pac_med.encontrar(id_paciente_medico);
        
        // Agrega un atributo a la petición con los datos del objeto 'paciente_medico' 
        request.setAttribute("paciente_medico", paciente_medico);
        
        // Creacion de objeto de tipo PacientesDAO
        PacientesDAO pac = new PacientesDAO();
        // Lista que contiene todos los campos de la tabla 'pacientes' importados mediante el metodo listar() de la clase PacientesDAO
        List<Pacientes> pacientes = pac.listar();

        System.out.println("pacientes" + pacientes);
        // Agrega un atributo a la petición con los datos del objeto 'pacientes' 
        request.setAttribute("pacientes", pacientes);
        
        // Creacion de objeto de tipo MedicosDAO
        MedicosDAO med = new MedicosDAO();
        // Lista que contiene todos los campos de la tabla 'medicos' importados mediante el metodo listar() de la clase MedicosDAO
        List<Medicos> medicos = med.listar();

        System.out.println("medicos" + medicos);
        // Agrega un atributo a la petición con los datos del objeto 'medicos' 
        request.setAttribute("medicos", medicos);

        // Reririge la peticion al JSP editar_paciente_medico
        request.getRequestDispatcher("/WEB-INF/paginas/crud/editar_paciente_medico.jsp").forward(request, response);
    }

    // Metodo para editar una relacion paciente_medico
    protected void modifcarPaciente_Medico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros desde el formulario
        
        int id_paciente_medico = Integer.parseInt(request.getParameter("id_paciente_medico"));
        int id_paciente = Integer.parseInt(request.getParameter("id_paciente"));
        int matricula = Integer.parseInt(request.getParameter("matricula"));

        // Objeto de tipo Paciente_Medico que contiene los parametros importados
        Paciente_Medico pa_me = new Paciente_Medico(id_paciente_medico, id_paciente, matricula);
        // Actualizar campos en la tabla 'paciente_medico'
        int registrosmodificados = new Paciente_MedicoDAO().actualizar(pa_me);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }
    
    protected void eliminarPaciente_Medico(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importa el parametro 'id_paciente_medico' de la peticion
        int id_paciente_medico = Integer.parseInt(request.getParameter("id_paciente_medico"));
        
        // Elimina campos en la tabla 'paciente_medico'
        int registrosmodificados = new Paciente_MedicoDAO().eliminar(id_paciente_medico);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

}
