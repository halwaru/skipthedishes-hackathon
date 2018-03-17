package ca.skip.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;

import ca.skip.hackathon.entity.Order;

public class OrderDAO extends AbstractDAO<Order> {

    private static final String CREATE_NEW = "insert into order (date, customerId, deliveryAddress, contact, storeId, total, status, lastUpdate) values (?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean save(Order order) {
        try (Connection c = newConnection(); PreparedStatement ps = c.prepareStatement(CREATE_NEW)) {
            ps.setTimestamp(1, new Timestamp(order.getDate().toInstant().toEpochMilli()));
            ps.setInt(2, order.getCustomerId());
            ps.setString(3, order.getDeliveryAddress());
            ps.setString(4, order.getContact());
            ps.setInt(5, order.getStoreId());
            ps.setBigDecimal(6, order.getTotal());
            ps.setString(7, order.getStatus());
            ps.setTimestamp(8, new Timestamp(order.getLastUpdate().toInstant().toEpochMilli()));

            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();
            final int id = rs.getInt("id");
            order.setId(id);
            return id > 0;
        } catch (SQLException e) {
            // TODO log
        }
        return false;
    }

    @Override
    public String getByIdSql() {
        // TODO
        return null;
    }

    @Override
    public String getAllSql() {
        // TODO
        return null;
    }

    @Override
    public Order readEntity(ResultSet rs) throws SQLException {
        // TODO
        return null;
    }

}
