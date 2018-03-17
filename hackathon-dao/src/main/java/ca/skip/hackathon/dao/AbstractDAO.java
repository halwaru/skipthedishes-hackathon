package ca.skip.hackathon.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import ca.skip.hackathon.entity.AbstractEntity;

public abstract class AbstractDAO<E extends AbstractEntity> {

    public abstract E readEntity(ResultSet rs) throws SQLException;

    public abstract String getByIdSql();

    public abstract String getAllSql();

    public Optional<E> get(int id) {
        try (Connection c = newConnection();
                PreparedStatement ps = c.prepareStatement(getByIdSql());
                ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                return Optional.of(readEntity(rs));
            }
        } catch (SQLException e) {
            // TODO log
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public Set<E> listAll() {
        try (Connection c = newConnection();
                PreparedStatement ps = c.prepareStatement(getAllSql());
                ResultSet rs = ps.executeQuery()) {
            final Set<E> set = new HashSet<>();
            while (rs.next()) {
                set.add(readEntity(rs));
            }
            return set;
        } catch (SQLException e) {
            // TODO log
            e.printStackTrace();
        }
        return Collections.emptySet();
    }

    protected Connection newConnection() throws SQLException {
        return DriverManager.getConnection("jdbc:mysql://localhost:3306/SkipIsAwesome", "root", "admin");
    }

}
