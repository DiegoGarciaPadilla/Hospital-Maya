package web;

// Importacion de los beans, DAOs y paquetes java y javax necesarios
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// Creacion del servlet NavegarServlet
@WebServlet(name = "NavegarServlet", urlPatterns = {"/NavegarServlet"})
public class NavegarServlet extends HttpServlet {

    // Respuestas a las peticiones realizadas por el metodo GET
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Importa el parametro 'nav' de la peticion
        String nav = request.getParameter("nav");

        if (nav!=null) {
            switch (nav) {
                // Si el parametro 'nav' es igual a 'inicio'
                case "inicio":
                    // Regresa al inicio
                    request.getRequestDispatcher("/WEB-INF/paginas/inicio.jsp").forward(request, response);
                    break;
                // Si el parametro 'nav' es igual a 'pacientes'
                case "pacientes":
                    // Realiza una peticion sin paso de parametros a 'PacientesServlet'
                    request.getRequestDispatcher("/PacientesServlet").forward(request, response);
                    break;
                // Si el parametro 'nav' es igual a 'medicos'
                case "medicos":
                    // Realiza una peticion sin paso de parametros a 'MedicosServlet'
                    request.getRequestDispatcher("/MedicosServlet").forward(request, response);
                    break;
                // Si el parametro 'nav' es igual a 'ingresos'
                case "ingresos":
                    // Realiza una peticion sin paso de parametros a 'IngresosServlet'
                    request.getRequestDispatcher("/IngresosServlet").forward(request, response);
                    break;
                // Si el parametro 'nav' es igual a 'usuario'
                case "usuario":
                    // Realiza una peticion sin paso de parametros a 'UsuariosServlet'
                    request.getRequestDispatcher("/UsuariosServlet").forward(request, response);
                    break;
                // En caso de no coincidir no reliza nada
                default:
                    break;
            }
        }
    }

}
