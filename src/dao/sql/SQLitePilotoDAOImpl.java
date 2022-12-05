package dao.sql;

import dao.EscuderiaDAO;
import dao.PilotoDAO;
import models.Escuderia;
import models.Piloto;

import java.sql.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SQLitePilotoDAOImpl implements PilotoDAO {
    private SQLiteEscuderiaDAOImpl esc;

    final String FINDALL = "SELECT * FROM Drivers";
    final String FINDBYID = "SELECT * FROM Drivers WHERE DriverID = ?";
    final String SAVE = "INSERT INTO Drivers (DriverID, Name, DateOfBirth, Team) VALUES (?, ?, ?, ?)";
    final String UPDATE = "UPDATE Drivers SET Name = ?, DateOfBirth = ?, Team = ? WHERE DriverID = ?";
    final String DELETE = "DELETE FROM DRIVERS WHERE DriverID = ?";

    private Connection conexion = null;

    public SQLitePilotoDAOImpl(Connection conexion, SQLiteEscuderiaDAOImpl esc) {
        this.conexion = conexion;
        this.esc = esc;
    }

    @Override
    public List<Piloto> findAll() {
        List<Piloto> pilotos = new ArrayList<>();
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDALL);
             ResultSet rs = sentencia.executeQuery()){
            while (rs.next()) {
                pilotos.add(convertToPilotos(rs));
            }
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return pilotos;
    }

    @Override
    public Piloto findById(Integer id) {
        Piloto piloto = null;
        try (PreparedStatement sentencia = conexion.prepareStatement(FINDBYID)) {
            sentencia.setInt(1, id);
            ResultSet rs = sentencia.executeQuery();
            if (rs.next()) {
                piloto = convertToPilotos(rs);
            }
            rs.close();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        return piloto;
    }

    @Override
    public void save(Piloto piloto) {
        try (PreparedStatement sentencia = conexion.prepareStatement(SAVE)) {
            sentencia.setString(2, piloto.getNombre());
            sentencia.setInt(1, piloto.getNumero());
            sentencia.setString(4, piloto.getEquipo().getNombre());
            sentencia.setString(3, piloto.getFechaNacimiento().toString() + " 00:00:00");
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void update(Piloto piloto) {
        try (PreparedStatement sentencia = conexion.prepareStatement(UPDATE)){
            sentencia.setString(1, piloto.getNombre());
            sentencia.setInt(4, piloto.getNumero());
            sentencia.setString(3, piloto.getEquipo().getNombre());
            sentencia.setString(2, piloto.getFechaNacimiento().toString() + " 00:00:00");
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    @Override
    public void deleteById(Integer id) {
        try (PreparedStatement sentencia = conexion.prepareStatement(DELETE)) {
            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }

    private Piloto convertToPilotos(ResultSet rs) throws SQLException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        return new Piloto(
                rs.getString("Name"),
                rs.getInt("DriverID"),
                esc.findById(rs.getString("Team")),
                LocalDate.parse(rs.getString("DateOfBirth"), formatter)){
        };
    }
}

