package ca.skip.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ca.skip.hackathon.entity.Cousine;

public class CousineDAO extends AbstractDAO<Cousine> {

    private static final String GET_BY_ID = "select * from cousine where id = ?";
    private static final String GET_ALL = "select * from cousine";
    private static final String GET_BY_NAME = "select * from cousine where name like '%?%'";

    @Override
    public String getByIdSql() {
        return GET_BY_ID;
    }

    @Override
    public String getAllSql() {
        return GET_ALL;
    }

    public Set<Cousine> basicSearch(String searchText) {
        try (Connection c = newConnection(); PreparedStatement ps = c.prepareStatement(GET_BY_NAME)) {
            // FIXME sql-injection
            ps.setString(1, searchText);
            try (ResultSet rs = ps.executeQuery()) {
                final Set<Cousine> set = new HashSet<>();
                while (rs.next()) {
                    set.add(readEntity(rs));
                }
                return set;
            }
        } catch (SQLException e) {
            // TODO log
        }
        return Collections.emptySet();
    }

    @Override
    public Cousine readEntity(ResultSet rs) throws SQLException {
        Cousine cousine = new Cousine();
        cousine.setId(rs.getInt("id"));
        cousine.setName(rs.getString("name"));
        return cousine;
    }

}
