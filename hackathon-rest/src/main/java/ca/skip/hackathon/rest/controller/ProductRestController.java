package ca.skip.hackathon.rest.controller;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import ca.skip.hackathon.business.rules.ProductBusinessRules;
import ca.skip.hackathon.business.rules.exception.BusinessRulesException;
import ca.skip.hackathon.entity.Product;
import ca.skip.hackathon.rest.dto.ProductDTO;

@RestController
public class ProductRestController extends AbstractRestController {

    @ResponseBody
    @RequestMapping(value = "/Product", method = RequestMethod.GET)
    public ResponseEntity<Set<ProductDTO>> listProducts() {
        final Set<Product> products = getBR(ProductBusinessRules.class).listAll();
        return new ResponseEntity<>(products.stream().map(ProductDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/Product/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<Set<ProductDTO>> searchProducts(@PathVariable String searchText) {
        final Set<Product> products = getBR(ProductBusinessRules.class).search(searchText);
        return new ResponseEntity<>(products.stream().map(ProductDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/Product/{productId}", method = RequestMethod.GET)
    public ResponseEntity<ProductDTO> getProduct(@PathVariable int productId) throws BusinessRulesException {
        final Product product = getBR(ProductBusinessRules.class).get(productId);
        return new ResponseEntity<>(new ProductDTO(product), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/Store/{storeId}/products", method = RequestMethod.GET)
    public ResponseEntity<Set<ProductDTO>> listProductsFromStore(@PathVariable int storeId) {
        final Set<Product> products = getBR(ProductBusinessRules.class).findByStore(storeId);
        return new ResponseEntity<>(products.stream().map(ProductDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

}
