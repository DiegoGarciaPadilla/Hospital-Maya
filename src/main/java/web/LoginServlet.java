package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import beans.Usuarios;
import datos.LoginDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet LoginServlet
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

    // Respuestas a las peticiones realizadas por el metodo GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        this.accionDefault(request, response);
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
                // Si el parametro 'accion' es igual a 'iniciarSesion'
                case "iniciarSesion":
                    // Ejecuta el metodo iniciarSesion, pasando los parametros
                    this.iniciarSesion(request, response);
                    break;
                // En caso contrario se ejecuta la accion por default
                default:
                    this.accionDefault(request, response);
                    break;
            }
        } else {
            this.accionDefault(request, response);
        }
    }

    // Metodo que se ejecuta cuando hay una peticion default al serlvet
    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Creacion de objeto de tipo LoginDAO
        LoginDAO usr = new LoginDAO();
        // Lista que contiene todos los campos de la tabla 'usuarios' importados mediante el metodo listar() de la clase LoginDAO
        List<Usuarios> usuarios = usr.listar();

        System.out.println("Usuarios: " + usuarios);
        // Agrega un atributo a la petición con los datos de la lista 'usuarios' 
        request.setAttribute("usuariolista", usuarios);

        // Reririge la peticion al JSP login
        request.getRequestDispatcher("WEB-INF/paginas/login.jsp").forward(request, response);
    }

    protected void iniciarSesion(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importacion de los parametros almacenados en la peticion
        String usuario = request.getParameter("usuario");
        String password = request.getParameter("password");

        // Compara los parametros importados con los datos de la tabla 'usuarios'
        Usuarios users = new Usuarios(usuario, password);
        // Devuelve el numero de coincidencias en una variable de tipo int
        int encontrar = new LoginDAO().encontrar(users);

        System.out.println(encontrar);
        // Condición que se ejecuta si se ha encotrado una coincidencia
        if (encontrar == 1) {
            // Reririge la peticion al JSP inicio
            request.getRequestDispatcher("WEB-INF/paginas/inicio.jsp").forward(request, response);
        // En caso de no haber coincidencia
        } else {
            // Reririge la peticion al JSP error
            request.getRequestDispatcher("WEB-INF/paginas/error.jsp").forward(request, response);

        }

    }

}
