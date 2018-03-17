package ca.skip.hackathon.business.rules;

import java.util.Optional;
import java.util.Set;

import ca.skip.hackathon.business.rules.exception.BusinessRulesException;
import ca.skip.hackathon.dao.ProductDAO;
import ca.skip.hackathon.entity.Product;

public class ProductBusinessRules extends AbstractBusinessRules {

    public Product get(int id) throws BusinessRulesException {
        final Optional<Product> product = getDAO(ProductDAO.class).get(id);
        if (product.isPresent()) {
            return product.get();
        }
        throw new BusinessRulesException("ID not found");
    }

    public Set<Product> listAll() {
        return getDAO(ProductDAO.class).listAll();
    }

    public Set<Product> search(String searchText) {
        return getDAO(ProductDAO.class).basicSearch(searchText);
    }

    public Set<Product> findByStore(int storeId) {
        return getDAO(ProductDAO.class).storeSearch(storeId);
    }

}
