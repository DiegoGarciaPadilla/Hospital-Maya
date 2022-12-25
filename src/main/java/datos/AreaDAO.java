package datos;

import beans.Area;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class AreaDAO {

    private static final String SELECT = "SELECT * FROM area";
    private static final String INSERT = "INSERT INTO area(descripcion) VALUES(?)";
    private static final String UPDATE = "UPDATE area SET descripcion=? WHERE id_area=?";
    private static final String DELETE = "DELETE FROM area WHERE id_area=?";
    private static final String SELECT_ID = "SELECT * FROM area WHERE id_area=?";

    public List<Area> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Area area = null;
        List<Area> areaLista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_area = rs.getInt("id_area");
                String descrpcion = rs.getString("descripcion");

                area = new Area(id_area, descrpcion);
                areaLista.add(area);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return areaLista;

    }

    public Area encontrar(int id_area) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Area area = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ID);
            stmt.setInt(1,id_area);
            rs = stmt.executeQuery();

            while (rs.next()) {                
                String descripcion = rs.getString("descripcion");
                
                area = new Area(id_area, descripcion);
            }
           
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return area;

    }

    public int insertar(Area area) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);
            
            stmt.setString(1, area.getDescripcion());
            
            
            registros=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        
        return registros;
        
    }
    
    public int actualizar(Area area){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);
            
            stmt.setString(1, area.getDescripcion());
            stmt.setInt(2, area.getId_area());           

            registro=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        
        return registro;
    }
    
    public int eliminar(int id_area){
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;
        
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);
            
            stmt.setInt(1, id_area);
            
            registros=stmt.executeUpdate();
            
        } catch (SQLException ex) {
            Logger.getLogger(AreaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }
        
        return registros;
    }

}