package datos;

import beans.Paciente_Medico;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Paciente_MedicoDAO {

    private static final String SELECT = "SELECT * FROM paciente_medico";
    private static final String INSERT = "INSERT INTO paciente_medico(id_paciente, matricula) VALUES(?,?)";
    private static final String UPDATE = "UPDATE paciente_medico SET id_paciente=?, matricula=? WHERE id_paciente_medico=?";
    private static final String DELETE = "DELETE FROM paciente_medico WHERE id_paciente_medico=?";
    private static final String SELECT_ID = "SELECT * FROM paciente_medico WHERE id_paciente_medico=?";

    public List<Paciente_Medico> listar() {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente_Medico pame = null;
        List<Paciente_Medico> pameLista = new ArrayList<>();

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_paciente_medico = rs.getInt("id_paciente_medico");
                int id_paciente = rs.getInt("id_paciente");
                int matricula = rs.getInt("matricula");

                pame = new Paciente_Medico(id_paciente_medico, id_paciente, matricula);
                pameLista.add(pame);
            }

        } catch (SQLException ex) {
            ex.printStackTrace(System.out);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return pameLista;

    }

    public Paciente_Medico encontrar(int id_paciente_medico1) {
        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Paciente_Medico pa_me = null;
        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(SELECT_ID);
            stmt.setInt(1, id_paciente_medico1);
            rs = stmt.executeQuery();

            while (rs.next()) {
                int id_paciente_medico = rs.getInt("id_paciente_medico");
                int id_paciente = rs.getInt("id_paciente");
                int matricula = rs.getInt("matricula");

                pa_me = new Paciente_Medico(id_paciente_medico, id_paciente, matricula);
            }

        } catch (SQLException ex) {
            Logger.getLogger(Paciente_MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
            Conexion.close(rs);

        }

        return pa_me;

    }

    public int insertar(Paciente_Medico pa_me) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(INSERT);

            stmt.setInt(1, pa_me.getId_paciente());
            stmt.setInt(2, pa_me.getMatricula());

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Paciente_MedicoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;

    }

    public int actualizar(Paciente_Medico paciente_medico) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registro = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(UPDATE);

            stmt.setInt(1, paciente_medico.getId_paciente());
            stmt.setInt(2, paciente_medico.getMatricula());
            stmt.setInt(3, paciente_medico.getId_paciente_medico());

            registro = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Paciente_Medico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registro;
    }

    public int eliminar(int id_paciente_medico) {
        Connection conn = null;
        PreparedStatement stmt = null;
        int registros = 0;

        try {
            conn = Conexion.getConnection();
            stmt = conn.prepareStatement(DELETE);

            stmt.setInt(1, id_paciente_medico);

            registros = stmt.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(Paciente_Medico.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            Conexion.close(conn);
            Conexion.close(stmt);
        }

        return registros;
    }

}
