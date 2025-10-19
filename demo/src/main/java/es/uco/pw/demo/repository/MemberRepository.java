package es.uco.pw.demo.repository;

//Imports necesarios
import es.uco.pw.demo.model.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


//Añadimos la clase memberRepository
@Repository
public class MemberRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MemberRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    /**
     *Funcion para convertir una fila de la base de datos en un objeto Member.
     */
    private static final class MemberMapper implements RowMapper<Member> {
        
        public Member mapRow(ResultSet rs, int rowNum) throws SQLException {
            Member member = new Member();
            member.setMemberId(rs.getInt("member_id"));
            member.setDni(rs.getString("dni"));
            member.setFirstName(rs.getString("first_name"));
            member.setLastName(rs.getString("last_name"));
            member.setBirthDate(rs.getDate("birth_date").toLocalDate());
            member.setAddress(rs.getString("address"));
            member.setRegistrationDate(rs.getDate("registration_date").toLocalDate());
            member.setSkipperTitle(rs.getBoolean("skipper_title"));

            /** Arreglo para el posible valor nulo en 'role'
            *Ya que si era nulo daba error
            */
            String roleFromDB = rs.getString("role");
            if (roleFromDB != null && !roleFromDB.isEmpty()) {
                member.setRole(Member.RoleType.valueOf(roleFromDB.toUpperCase()));
            } else {
                member.setRole(null);
            }

            return member;
        }
    }

    /**
     * Obtiene todos los miembros.
     */
    public List<Member> findAll() {
        String sql = "SELECT * FROM member";
        // Usa la clase interna MemberMapper
        return jdbcTemplate.query(sql, new MemberMapper());
    }

    /**
     * Guarda un nuevo miembro en la base de datos (INSERT).
     */
    public int save(Member member) {
        String sql = "INSERT INTO member (dni, first_name, last_name, birth_date, address, registration_date, skipper_title, role) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        return jdbcTemplate.update(sql,
                member.getDni(),
                member.getFirstName(),
                member.getLastName(),
                member.getBirthDate(),
                member.getAddress(),
                member.getRegistrationDate(),
                member.isSkipperTitle(),
                // Comprobamos si el rol es nulo antes de guardarlo
                member.getRole() != null ? member.getRole().toString() : null 
        );
    }
    
}