package ca.skip.hackathon.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import ca.skip.hackathon.entity.Product;

public class ProductDAO extends AbstractDAO<Product> {

    private static final String GET_BY_ID = "select * from product where id = ?";
    private static final String GET_ALL = "select * from product";
    private static final String GET_BY_STORE = "select * from product where storeId = ?";
    private static final String GET_BY_NAME_OR_DESCRIPTION = "select * from product where name like '%?%' or description like '%?%'";

    @Override
    public String getByIdSql() {
        return GET_BY_ID;
    }

    @Override
    public String getAllSql() {
        return GET_ALL;
    }

    public Set<Product> basicSearch(String searchText) {
        try (Connection c = newConnection(); PreparedStatement ps = c.prepareStatement(GET_BY_NAME_OR_DESCRIPTION)) {
            // FIXME sql-injection
            ps.setString(1, searchText);
            ps.setString(2, searchText);
            try (ResultSet rs = ps.executeQuery()) {
                final Set<Product> set = new HashSet<>();
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

    public Set<Product> storeSearch(int storeId) {
        try (Connection c = newConnection(); PreparedStatement ps = c.prepareStatement(GET_BY_STORE)) {
            ps.setInt(1, storeId);
            try (ResultSet rs = ps.executeQuery()) {
                final Set<Product> set = new HashSet<>();
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
    public Product readEntity(ResultSet rs) throws SQLException {
        Product product = new Product();
        product.setId(rs.getInt("id"));
        product.setName(rs.getString("name"));
        product.setDescription(rs.getString("description"));
        product.setPrice(rs.getBigDecimal("price"));
        product.setStoreId(rs.getInt("storeId"));
        return product;
    }

}
