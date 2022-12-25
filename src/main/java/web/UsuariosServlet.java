package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import beans.Usuarios;
import datos.UsuariosDAO;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet UsuariosServlet
@WebServlet(name = "UsuariosServlet", urlPatterns = {"/UsuariosServlet"})
public class UsuariosServlet extends HttpServlet {

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
                    // Ejecuta el metodo agregarUsuarios, pasando los parametros
                    this.agregarUsuarios(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'editar'
                case "editar":
                    // Ejecuta el metodo editarUsuarios, pasando los parametros
                    this.editarUsuarios(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'eliminar'
                case "eliminar":
                    // Ejecuta el metodo eliminarUsuarios, pasando los parametros
                    this.eliminarUsuarios(request, response);
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
                    // Ejecuta el metodo insertarUsuarios, pasando los parametros
                    this.insertarUsuarios(request, response);
                    break;
                // Si el parametro 'accion' es igual a 'modificar'
                case "modificar":
                    // Ejecuta el metodo modifcarUsuarios, pasando los parametros
                    this.modifcarUsuarios(request, response);
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

        // Creacion de objeto de tipo UsuariosDAO
        UsuariosDAO usr = new UsuariosDAO();
        // Lista que contiene todos los campos de la tabla 'usuarios' importados mediante el metodo listar() de la clase UsuariosDAO
        List<Usuarios> usuarios = usr.listar();

        System.out.println("usuarios" + usuarios);
        // Agrega un atributo a la petición con los datos de la lista 'usuarios' 
        request.setAttribute("usuarios", usuarios);
        
        // Reririge la peticion al JSP usuarios
        request.getRequestDispatcher("/WEB-INF/paginas/usuarios.jsp").forward(request, response);
    }

    // Metodo que redirige al formulario para ingresar un usuario
    protected void agregarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Reririge la peticion al JSP agregar_usuario
        request.getRequestDispatcher("/WEB-INF/paginas/crud/agregar_usuario.jsp").forward(request, response);
    }
    
    // Metodo para ingresar un usuario
    protected void insertarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importacion de los parametros desde el formulario
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        // Objeto de tipo Usuarios que contiene los parametros importados
        Usuarios usuarios = new Usuarios(usuario, password);
        // Actualizar campos en la tabla 'usuarios'
        int registrosmodificados = new UsuariosDAO().insertar(usuarios);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
        
    }
    
    // Metodo que redirige al formulario para editar un usuario
    protected void editarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importa el parametro 'id_usuario' de la peticion
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        
        // Creacion de objeto de tipo UsuariosDAO
        UsuariosDAO usr = new UsuariosDAO();
        // Objeto de tipo Medicos que contiene el valor de los campos cuyo matricula coincida con el ingresado
        Usuarios usuarios = usr.encontrar(id_usuario);
        
        // Agrega un atributo a la petición con los datos del objeto 'usuarios' 
        request.setAttribute("usuarios", usuarios);
        
        // Reririge la peticion al JSP editar_usuario
        request.getRequestDispatcher("/WEB-INF/paginas/crud/editar_usuario.jsp").forward(request, response);      
        
        
    }
    
    // Metodo que edita un usuario
    protected void modifcarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importacion de los parametros desde el formulario
        
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");
        
        // Objeto de tipo Usuarios que contiene los parametros importados
        Usuarios usuarios = new Usuarios(id_usuario, usuario, password);
        // Actualizar campos en la tabla 'usuarios'
        int registrosmodificados = new UsuariosDAO().actualizar(usuarios);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
        
    }
    
    // Metodo que elimina un usuario
    protected void eliminarUsuarios(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Importa el parametro 'id_usuario' de la peticion
        int id_usuario = Integer.parseInt(request.getParameter("id_usuario"));
        
        // Elimina campos en la tabla 'usuarios'
        int registrosmodificados = new UsuariosDAO().eliminar(id_usuario);
        System.out.println("Registros modificados: " + registrosmodificados);
        // Redirige a la accion default
        this.accionDefault(request, response);
        
    }

}
