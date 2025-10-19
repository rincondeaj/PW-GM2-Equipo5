package es.uco.pw.demo.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import es.uco.pw.demo.model.Boat;

@Repository
public class BoatRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BoatRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     * Usamos RowMapper para convertir un ResultSet de SQL a un objeto Boat.
     */
    private static final class BoatMapper implements RowMapper<Boat> {
        public Boat mapRow(ResultSet rs, int rowNum) throws SQLException {
            Boat boat = new Boat();

            boat.setRegistrationNumber(rs.getString("registration_number"));
            boat.setName(rs.getString("name"));

            // Convertimos el String de la BBDD de nuevo a un Enum
            boat.setType(Boat.BoatType.valueOf(rs.getString("type")));
            boat.setCapacity(rs.getInt("capacity"));
            boat.setDimensions(rs.getString("dimensions"));
            boat.setSkipperId(rs.getInt("skipper_id"));
            return boat;
        }
    }

// Funcion para obtener todos los barcos

    public List<Boat> findAll() {
        String sql = "SELECT * FROM boat";
        return jdbcTemplate.query(sql, new BoatMapper());
    }

    /**
     * Busca un barco por (registration number).
     * Si no hay, devuelve NULL.
     */


    public Boat findByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM boat WHERE registration_number = ?";
        try {
            // queryForObject se usa cuando esperas un solo resultado
            return jdbcTemplate.queryForObject(sql, new Object[]{registrationNumber}, new BoatMapper());
        } catch (EmptyResultDataAccessException e) {
            return null;
        }
    }

    /**
     * Funcion para guardar un nuevo barco en la base de datos (INSERT).
     */

    public int save(Boat boat) {
        String sql = "INSERT INTO boat (registration_number, name, type, capacity, dimensions, skipper_id) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                boat.getRegistrationNumber(),
                boat.getName(),
                boat.getType().toString(), // Convertimos el Enum a String
                boat.getCapacity(),
                boat.getDimensions(),
                boat.getSkipperId());
    }
}