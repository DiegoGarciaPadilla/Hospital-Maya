package datos;

import beans.Ingresos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class IngresosDAO {

    private static final String SELECT = "SELECT * FROM ingresos";
    private static final String INSERT = "INSERT INTO ingresos(id_paciente, fecha_ingreso, situacion, id_area) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE ingresos SET id_paciente=?, fecha_ingreso=?, situacion=?, id_area=? WHERE id_ingreso=?";
    private static final String DELETE = "DELETE FROM ingresos WHERE id_ingreso=?";
    private static final String SELECT_ID = "SELECT * FROM ingresos WHERE id_ingreso=?";

    public List<Ingresos> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ingresos Ingreso = null;
        List<Ingresos> ingresoLista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_ingreso = rs.getInt("id_ingreso");
                int id_paciente = rs.getInt("id_paciente");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String situacion = rs.getString("situacion");
                int id_area = rs.getInt("id_area");

                Ingreso = new Ingresos(id_ingreso, id_paciente, fecha_ingreso, situacion, id_area);
                ingresoLista.add(Ingreso);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return ingresoLista;

    }

    public Ingresos encontrar(int id_ingreso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Ingresos ingresos = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ID);
            stmt.setInt(1, id_ingreso);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_paciente = rs.getInt("id_paciente");
                String fecha_ingreso = rs.getString("fecha_ingreso");
                String situacion = rs.getString("situacion");
                int id_area = rs.getInt("id_area");
                
                ingresos = new Ingresos(id_ingreso, id_paciente, fecha_ingreso, situacion, id_area);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return ingresos;

    }

    public int insertar(Ingresos ingresos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);

            stmt.setInt(1, ingresos.getId_paciente());
            stmt.setString(2, ingresos.getFecha_ingreso());
            stmt.setString(3, ingresos.getSituacion());
            stmt.setInt(4, ingresos.getId_area());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngresosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;

    }

    public int actualizar(Ingresos ingresos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);

            stmt.setInt(1, ingresos.getId_paciente());
            stmt.setString(2, ingresos.getFecha_ingreso());
            stmt.setString(3, ingresos.getSituacion());
            stmt.setInt(4, ingresos.getId_area());
            stmt.setInt(5, ingresos.getId_ingreso());

            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngresosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registro;
    }

    public int eliminar(int id_ingreso) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);

            stmt.setInt(1, id_ingreso);

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(IngresosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;
    }

}
