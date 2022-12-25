package datos;

import beans.Medicos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MedicosDAO {

    private static final String SELECT = "SELECT * FROM medicos";
    private static final String INSERT = "INSERT INTO medicos(matricula, nombre, apellidoP, apellidoM, telefono, domicilio, especialidad) VALUES(?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE medicos SET matricula=?, nombre=?, apellidoP=?, apellidoM=?, telefono=?, domicilio=?, especialidad=? WHERE matricula=?";
    private static final String DELETE = "DELETE FROM medicos WHERE matricula=?";
    private static final String SELECT_ID = "SELECT * FROM medicos WHERE matricula=?";

    public List<Medicos> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medicos medico = null;
        List<Medicos> medicoLista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int matricula = rs.getInt("matricula");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String telefono = rs.getString("telefono");
                String domicilio = rs.getString("domicilio");
                String especialidad = rs.getString("especialidad");

                medico = new Medicos(matricula, nombre, apellidoP, apellidoM, telefono, domicilio, especialidad);
                medicoLista.add(medico);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return medicoLista;

    }

    public Medicos encontrar(int matricula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Medicos medico = null;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ID);
            stmt.setInt(1, matricula);
            rs = stmt.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String telefono = rs.getString("telefono");
                String domicilio = rs.getString("domicilio");
                String especialidad = rs.getString("especialidad");
                
                medico = new Medicos(matricula, nombre, apellidoP, apellidoM, telefono, domicilio, especialidad);

            }

        } catch (SQLException ex) {
            Logger.getLogger(MedicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return medico;

    }

    public int insertar(Medicos medicos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);

            stmt.setInt(1, medicos.getMatricula());
            stmt.setString(2, medicos.getNombre());
            stmt.setString(3, medicos.getApellidoP());
            stmt.setString(4, medicos.getApellidoM());
            stmt.setString(5, medicos.getTelefono());
            stmt.setString(6, medicos.getDomicilio());
            stmt.setString(7, medicos.getEspecialidad());
            
            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;

    }

    public int actualizar(Medicos medicos) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);

            stmt.setInt(1, medicos.getMatricula());
            stmt.setString(2, medicos.getNombre());
            stmt.setString(3, medicos.getApellidoP());
            stmt.setString(4, medicos.getApellidoM());
            stmt.setString(5, medicos.getTelefono());
            stmt.setString(6, medicos.getDomicilio());
            stmt.setString(7, medicos.getEspecialidad());
            stmt.setInt(8, medicos.getMatricula());

            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registro;
    }

    public int eliminar(int matricula) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);

            stmt.setInt(1, matricula);

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(MedicosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;
    }

}
