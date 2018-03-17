package ca.skip.hackathon.business.rules;

import java.time.ZonedDateTime;
import java.util.Set;

import ca.skip.hackathon.business.rules.exception.BusinessRulesException;
import ca.skip.hackathon.dao.OrderDAO;
import ca.skip.hackathon.entity.Order;
import ca.skip.hackathon.entity.Product;

public class OrderBusinessRules extends AbstractBusinessRules {

    public void newOrder(Set<Product> products) throws BusinessRulesException {
        int storeId = 0;
        for (Product product : products) {
            final int productStoreId = product.getStoreId();
            if (storeId == 0) {
                storeId = productStoreId;
            } else if (storeId != productStoreId) {
                throw new BusinessRulesException("Products from different stores");
            }
        }

        Order order = new Order();
        order.setDate(ZonedDateTime.now());
        order.setCustomerId(0);// TODO get user from request auth
        order.setDeliveryAddress(null); // TODO get from user or a new
        order.setContact(null); // TODO get from user or a new
        order.setStatus("Requested");
        order.setLastUpdate(ZonedDateTime.now());
        order.setStoreId(storeId);

        if (getDAO(OrderDAO.class).save(order)) {
            // FIXME
        } else {
            throw new BusinessRulesException("Error on ordering");
        }
    }

}
