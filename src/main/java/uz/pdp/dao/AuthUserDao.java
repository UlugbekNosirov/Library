package uz.pdp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import uz.pdp.models.Auth;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class AuthUserDao {
    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public AuthUserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Auth> getAll() {
        return jdbcTemplate.query("select id,username,password,role from spring_jdbc.auth_user", new AuthUserDao.UserRowMapper());
    }


    public static class UserRowMapper implements RowMapper<Auth> {
        public Auth mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Auth.builder()
                    .username(rs.getString("username"))
                    .password(rs.getString("password"))
                    .role(rs.getString("role"))
                    .build();
        }
    }


}
