package es.uco.pw.demo.repository;

import es.uco.pw.demo.model.Registration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class RegistrationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public RegistrationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class RegistrationMapper implements RowMapper<Registration> {
        public Registration mapRow(ResultSet rs, int rowNum) throws SQLException {
            Registration reg = new Registration();
            reg.setRegistrationId(rs.getInt("registration_id"));
            reg.setCreationDate(rs.getDate("creation_date").toLocalDate());

            String typeFromDB = rs.getString("type");
            if (typeFromDB != null && !typeFromDB.isEmpty()) {
                reg.setType(Registration.RegistrationType.valueOf(typeFromDB.toUpperCase()));
            } else {
                reg.setType(null);
            }
            return reg;
        }
    }

    public List<Registration> findAll() {
        return jdbcTemplate.query("SELECT * FROM registration", new RegistrationMapper());
    }

    public int save(Registration registration) {
        // Asumimos que registration_id es autoincremental
        String sql = "INSERT INTO registration (type, creation_date) VALUES (?, ?)";
        return jdbcTemplate.update(sql,
                registration.getType().toString(),
                registration.getCreationDate());
    }
}