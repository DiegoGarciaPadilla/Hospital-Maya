package datos;

import beans.Usuarios;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginDAO {
    
    private static final String SELECT = "SELECT * FROM usuarios";
    private static final String INSERT = "INSERT INTO usuarios(usuario, password) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE usuarios SET usuario=?, password=? WHERE id_usuario=?";
    private static final String DELETE = "DELETE FROM usuarios WHERE id_usuario=?";
    private static final String SELECT_ID = "SELECT * FROM usuarios WHERE usuario=? AND password=?";
    
    public List<Usuarios> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuarios users = null;
        List<Usuarios> usuarioslista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_usuario = rs.getInt("id_usuario");
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");

                users = new Usuarios(id_usuario, usuario, password);
                usuarioslista.add(users);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return usuarioslista;

    }
    
    public int encontrar(Usuarios users) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int encontrar=0;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ID);
            stmt.setString(1, users.getUsuario());
            stmt.setString(2, users.getPassword());
            rs = stmt.executeQuery();
            
            if(rs.next()){
                encontrar = 1;
                System.out.println(encontrar);
            } else {
                encontrar=0;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);
        }

        return encontrar;

    }
   
    
}
