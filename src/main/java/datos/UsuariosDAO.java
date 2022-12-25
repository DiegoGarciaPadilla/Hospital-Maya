package datos;

import beans.Usuarios;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuariosDAO {
    
    private static final String SELECT = "SELECT * FROM usuarios";
    private static final String INSERT = "INSERT INTO usuarios(usuario, password) VALUES (?, ?)";
    private static final String UPDATE = "UPDATE usuarios SET usuario=?, password=? WHERE id_usuario=?";
    private static final String DELETE = "DELETE FROM usuarios WHERE id_usuario=?";
    private static final String SELECT_ID = "SELECT * FROM usuarios WHERE id_usuario=?";
    
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
    
    public Usuarios encontrar(int id_usuario) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Usuarios usuarios = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ID);
            stmt.setInt(1,id_usuario);
            rs = stmt.executeQuery();

            while (rs.next()) {                
                String usuario = rs.getString("usuario");
                String password = rs.getString("password");
                
                usuarios = new Usuarios(id_usuario, usuario, password);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return usuarios;

    }
    
    public int insertar(Usuarios users) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            
            stmt.setString(1, users.getUsuario());
            stmt.setString(2, users.getPassword());
            
            registros=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        
        return registros;
        
    }
    
    public int actualizar(Usuarios users){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            
            stmt.setString(1, users.getUsuario());
            stmt.setString(2, users.getPassword());
            stmt.setInt(3, users.getId_usuario());
            
            registros=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        
        return registros;

    }
    
    public int eliminar(int id_usuario){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            
            stmt.setInt(1, id_usuario);
            
            registros=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(UsuariosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        
        return registros;
    }
    
}
