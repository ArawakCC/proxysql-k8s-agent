package com.mitchwood.proxysql.svc;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import com.mitchwood.proxysql.model.User;

@Service
public class ProxySqlService {

    @Autowired
    JdbcTemplate jdbc;

    RowMapper<User> userRowMapper = new RowMapper<User>() {
        @Override
        public User mapRow(ResultSet rs, int rowNum) throws SQLException {
            User user = new User(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setActive(rs.getBoolean("active"));
            user.setHostgroup(rs.getInt("default_hostgroup"));
            user.setMaxConnections(rs.getInt("max_connections"));
            user.setSchema(rs.getString("default_schema"));
            user.setFastForward(rs.getBoolean("fast_forward"));
            user.setTransactionPersistent(rs.getBoolean("transaction_persistent"));
            user.setUseSsl(rs.getBoolean("use_ssl"));
            return user;
        }

    };

    public Collection<User> getUsers() {
        return jdbc.query("select * from global_variables", userRowMapper);
    }

    public void write(User user) {
        Object[] args = new Object[] {
                user.getUsername(),
                user.getPassword(),
                user.isActive(),
                user.getHostgroup(),
                user.getMaxConnections(),
                user.getSchema(),
                user.isFastForward(),
                user.isTransactionPersistent(),
                user.isUseSsl()
        };
        jdbc.update("REPLACE INTO mysql_users(username,password,active,default_hostgroup,max_connections,default_schema, fast_forward, transaction_persistent, use_ssl) values(?,?,?,?,?,?,?,?,?)", args);
    }

    public void delete(User user) {
        jdbc.update("DELETE FROM mysql_users where username = ?", user.getUsername());
    }
}
