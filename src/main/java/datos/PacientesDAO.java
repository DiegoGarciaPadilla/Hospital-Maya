package datos;

import beans.Pacientes;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacientesDAO {

    private static final String SELECT = "SELECT * FROM pacientes";
    private static final String INSERT = "INSERT INTO pacientes(nombre, apellidoP, apellidoM, telefono, domicilio, edad, sexo, estado) VALUES(?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE pacientes SET nombre=?, apellidoP=?, apellidoM=?, telefono=?, domicilio=?, edad=?, sexo=?, estado=? WHERE id_paciente=?";
    private static final String DELETE = "DELETE FROM pacientes WHERE id_paciente=?";
    private static final String SELECT_ID = "SELECT * FROM pacientes WHERE id_paciente=?";
    private static final String SELECT_BY_ID = "SELECT id_paciente FROM pacientes WHERE nombre=? AND apellidoP=? AND apellidoM=? AND telefono=? AND domicilio=? AND edad=? AND sexo=? AND estado=?";

    public List<Pacientes> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pacientes Paciente = null;
        List<Pacientes> pacienteLista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                int id_paciente = rs.getInt("id_paciente");
                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String telefono = rs.getString("telefono");
                String domicilio = rs.getString("domicilio");
                int edad = rs.getInt("edad");
                String sexo = rs.getString("sexo");
                String estado = rs.getString("estado");

                Paciente = new Pacientes(id_paciente, nombre, apellidoP, apellidoM, telefono, domicilio, edad, sexo, estado);
                pacienteLista.add(Paciente);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return pacienteLista;

    }

    public Pacientes encontrar(int id_paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pacientes pacientes = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ID);
            stmt.setInt(1, id_paciente);
            rs = stmt.executeQuery();

            while (rs.next()) {

                String nombre = rs.getString("nombre");
                String apellidoP = rs.getString("apellidoP");
                String apellidoM = rs.getString("apellidoM");
                String telefono = rs.getString("telefono");
                String domicilio = rs.getString("domicilio");
                int edad = rs.getInt("edad");
                String sexo = rs.getString("sexo");
                String estado = rs.getString("estado");
                
                pacientes = new Pacientes(id_paciente, nombre, apellidoP, apellidoM, telefono, domicilio, edad, sexo, estado);

            }

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return pacientes;

    }
    
    public Pacientes encontrarId(Pacientes pacientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Pacientes pacientesret = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_BY_ID);
            
            stmt.setString(1, pacientes.getNombre());
            stmt.setString(2, pacientes.getApellidoP());
            stmt.setString(3, pacientes.getApellidoM());
            stmt.setString(4, pacientes.getTelefono());
            stmt.setString(5, pacientes.getDomicilio());
            stmt.setInt(6, pacientes.getEdad());
            stmt.setString(7, pacientes.getSexo());
            stmt.setString(8, pacientes.getEstado());
            
            rs = stmt.executeQuery();
            
            while(rs.next()){
                int id_paciente = rs.getInt("id_paciente");
                
                pacientesret = new Pacientes(id_paciente);
            }

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return pacientesret;

    }

    public int insertar(Pacientes pacientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);

            stmt.setString(1, pacientes.getNombre());
            stmt.setString(2, pacientes.getApellidoP());
            stmt.setString(3, pacientes.getApellidoM());
            stmt.setString(4, pacientes.getTelefono());
            stmt.setString(5, pacientes.getDomicilio());
            stmt.setInt(6, pacientes.getEdad());
            stmt.setString(7, pacientes.getSexo());
            stmt.setString(8, pacientes.getEstado());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;

    }

    public int actualizar(Pacientes pacientes) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);

            stmt.setString(1, pacientes.getNombre());
            stmt.setString(2, pacientes.getApellidoP());
            stmt.setString(3, pacientes.getApellidoM());
            stmt.setString(4, pacientes.getTelefono());
            stmt.setString(5, pacientes.getDomicilio());
            stmt.setInt(6, pacientes.getEdad());
            stmt.setString(7, pacientes.getSexo());
            stmt.setString(8, pacientes.getEstado());
            stmt.setInt(9, pacientes.getId_paciente());

            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registro;
    }

    public int eliminar(int id_paciente) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);

            stmt.setInt(1,id_paciente);

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(PacientesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;
    }

}
