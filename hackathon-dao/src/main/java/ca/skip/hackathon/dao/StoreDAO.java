package ca.skip.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ca.skip.hackathon.entity.Store;

public class StoreDAO extends AbstractDAO<Store> {

    private static final String GET_BY_ID = "select * from store where id = ?";
    private static final String GET_ALL = "select * from store";
    private static final String GET_BY_NAME = "select * from store where name like '%?%'";
    private static final String GET_BY_COUSINE = "select * from store where cousineId = ?";

    @Override
    public String getByIdSql() {
        return GET_BY_ID;
    }

    @Override
    public String getAllSql() {
        return GET_ALL;
    }

    public Set<Store> basicSearch(String searchText) {
        try (Connection c = newConnection(); PreparedStatement ps = c.prepareStatement(GET_BY_NAME)) {
            // FIXME sql-injection
            ps.setString(1, searchText);
            try (ResultSet rs = ps.executeQuery()) {
                final Set<Store> set = new HashSet<>();
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

    public Set<Store> cousineSearch(int cousineId) {
        try (Connection c = newConnection(); PreparedStatement ps = c.prepareStatement(GET_BY_COUSINE)) {
            ps.setInt(1, cousineId);
            try (ResultSet rs = ps.executeQuery()) {
                final Set<Store> set = new HashSet<>();
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
    public Store readEntity(ResultSet rs) throws SQLException {
        return null;
    }

}
