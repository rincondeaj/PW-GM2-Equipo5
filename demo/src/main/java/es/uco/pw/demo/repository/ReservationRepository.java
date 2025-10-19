package es.uco.pw.demo.repository;

//IMPORTS NECESARIOS
import es.uco.pw.demo.model.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ReservationRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public ReservationRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    private static final class ReservationMapper implements RowMapper<Reservation> {
        public Reservation mapRow(ResultSet rs, int rowNum) throws SQLException {
            Reservation res = new Reservation();
            res.setReservationId(rs.getInt("reservation_id"));
            res.setMemberId(rs.getInt("member_id"));
            res.setRegistrationId(rs.getInt("registration_id"));
            res.setDate(rs.getDate("date").toLocalDate());
            res.setReservedSeats(rs.getInt("reserved_seats"));
            res.setPurpose(rs.getString("purpose"));
            res.setTotalPrice(rs.getDouble("total_price"));
            return res;
        }
    }

    public List<Reservation> findAll() {
        return jdbcTemplate.query("SELECT * FROM reservation", new ReservationMapper());
    }

    public int save(Reservation reservation) {
        // Asumimos que reservation_id es autoincremental
        String sql = "INSERT INTO reservation (member_id, registration_id, date, reserved_seats, purpose, total_price) VALUES (?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                reservation.getMemberId(),
                reservation.getRegistrationId(),
                reservation.getDate(),
                reservation.getReservedSeats(),
                reservation.getPurpose(),
                reservation.getTotalPrice());
    }
}