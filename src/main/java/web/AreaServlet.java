package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import beans.Area;
import datos.AreaDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet AreaServlet
@WebServlet(name = "AreaServlet", urlPatterns = {"/AreaServlet"})
public class AreaServlet extends HttpServlet {

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
                    // Ejecuta el metodo agregarArea, pasando los parametros
                    this.agregarArea(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'editar'
                case "editar":
                    // Ejecuta el metodo editarArea, pasando los parametros
                    this.editarArea(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'eliminar'
                case "eliminar":
                    // Ejecuta el metodo eliminarArea, pasando los parametros
                    this.eliminarArea(request, response);
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
                    // Ejecuta el metodo insertarArea, pasando los parametros
                    this.insertarArea(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'modificar'
                case "modificar":
                    // Ejecuta el metodo modifcarArea, pasando los parametros
                    this.modifcarArea(request, response);
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
        AreaDAO ar = new AreaDAO();
        // Lista que contiene todos los campos de la tabla 'areas' importados mediante el metodo listar() de la clase AreaDAO
        List<Area> area = ar.listar();

        System.out.println("area" + area);
        // Agrega un atributo a la petición con los datos de la lista 'areas' 
        request.setAttribute("area", area);
        
        // Reririge la peticion al JSP area
        request.getRequestDispatcher("/WEB-INF/paginas/area.jsp").forward(request, response);

    }

    
    // Metodo que redirige al formulario para ingresar un area
    protected void agregarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Reririge la peticion al JSP agregar_area
        request.getRequestDispatcher("/WEB-INF/paginas/crud/agregar_area.jsp").forward(request, response);
    }

    // Metodo para ingresar un area
    protected void insertarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Impotacion del parametro 'descripcion' del formulario
        String descripcion = request.getParameter("descripcion");
        
        // Objeto de tipo Medicos que contiene los parametros importados
        Area area = new Area(descripcion);
        // Ingresar datos del objeto 'area' en la tabla 'areas'
        int registrosmodificados = new AreaDAO().insertar(area);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

    // Metodo que redirige al formulario para editar un area
    protected void editarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'id_area' de la peticion
        int id_area = Integer.parseInt(request.getParameter("id_area"));

        // Creacion de objeto de tipo AreaDAO
        AreaDAO a = new AreaDAO();
        // Objeto de tipo Area que contiene el valor de los campos cuyo matricula coincida con el ingresado
        Area area = a.encontrar(id_area);

        // Agrega un atributo a la petición con los datos del objeto 'area' 
        request.setAttribute("area", area);

        // Reririge la peticion al JSP editar_area
        request.getRequestDispatcher("/WEB-INF/paginas/crud/editar_area.jsp").forward(request, response);
    }

    protected void modifcarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros desde el formulario
        
        int id_area = Integer.parseInt(request.getParameter("id_area"));
        String descripcion = request.getParameter("descripcion");

        // Objeto de tipo Area que contiene los parametros importados
        Area area = new Area(id_area, descripcion);
        // Actualizar campos en la tabla 'areas'
        int registrosmodificados = new AreaDAO().actualizar(area);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }
    
    protected void eliminarArea(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importa el parametro 'id_area' de la peticion
        int id_area = Integer.parseInt(request.getParameter("id_area"));
        
        // Elimina campos en la tabla 'areas'
        int registrosmodificados = new AreaDAO().eliminar(id_area);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
    }

}
