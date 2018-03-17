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

import ca.skip.hackathon.business.rules.StoreBusinessRules;
import ca.skip.hackathon.business.rules.exception.BusinessRulesException;
import ca.skip.hackathon.entity.Store;
import ca.skip.hackathon.rest.dto.StoreDTO;

@RestController
public class StoreRestController extends AbstractRestController {

    @ResponseBody
    @RequestMapping(value = "/Store", method = RequestMethod.GET)
    public ResponseEntity<Set<StoreDTO>> listStores(@PathVariable int cousineId) {
        final Set<Store> stores = getBR(StoreBusinessRules.class).listAll();
        return new ResponseEntity<>(stores.stream().map(StoreDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/Store/search/{searchText}", method = RequestMethod.GET)
    public ResponseEntity<Set<StoreDTO>> listStoresFromCousine(@PathVariable String searchText) {
        final Set<Store> stores = getBR(StoreBusinessRules.class).search(searchText);
        return new ResponseEntity<>(stores.stream().map(StoreDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/Store/{storeId}", method = RequestMethod.GET)
    public ResponseEntity<StoreDTO> getProduct(@PathVariable int storeId) throws BusinessRulesException {
        final Store store = getBR(StoreBusinessRules.class).get(storeId);
        return new ResponseEntity<>(new StoreDTO(store), HttpStatus.OK);
    }

    @ResponseBody
    @RequestMapping(value = "/Cousine/{cousineId}/stores", method = RequestMethod.GET)
    public ResponseEntity<Set<StoreDTO>> listStoresFromCousine(@PathVariable int cousineId) {
        final Set<Store> stores = getBR(StoreBusinessRules.class).findByCousine(cousineId);
        return new ResponseEntity<>(stores.stream().map(StoreDTO::new).collect(Collectors.toSet()), HttpStatus.OK);
    }

}
