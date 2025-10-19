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
     * RowMapper para convertir un ResultSet de SQL a un objeto Boat.
     * Esta es la implementación que se explica en el PDF [cite: 330-338].
     */
    private static final class BoatMapper implements RowMapper<Boat> {
        public Boat mapRow(ResultSet rs, int rowNum) throws SQLException {
            Boat boat = new Boat();
            // Asume que tus columnas en la BBDD se llaman como 'registration_number', 'name', etc.
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

    /**
     * Obtiene todos los barcos de la base de datos.
     */
    public List<Boat> findAll() {
        String sql = "SELECT * FROM boat";
        return jdbcTemplate.query(sql, new BoatMapper());
    }

    /**
     * Busca un barco por su número de matrícula (PK).
     */
    public Boat findByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT * FROM boat WHERE registration_number = ?";
        try {
            // queryForObject se usa cuando esperas un solo resultado
            return jdbcTemplate.queryForObject(sql, new Object[]{registrationNumber}, new BoatMapper());
        } catch (EmptyResultDataAccessException e) {
            // Si no se encuentra ningún barco, queryForObject lanza esta excepción. Devolvemos null.
            return null;
        }
    }

    /**
     * Guarda un nuevo barco en la base de datos (INSERT).
     * El PDF explica esta operación con el método .update() [cite: 444-460].
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

    // Aquí puedes añadir más métodos (update, delete, etc.)
}