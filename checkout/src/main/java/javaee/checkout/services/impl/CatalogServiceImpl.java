package javaee.checkout.services.impl;

import javaee.checkout.services.CatalogService;
import javaee.checkout.models.Item;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;
import org.springframework.stereotype.Service;
import org.springframework.cloud.client.discovery.DiscoveryClient;

@Service
public class CatalogServiceImpl implements CatalogService {
    
    @Autowired
	private DiscoveryClient discoveryClient;

    private String serviceName = "catalog-service";

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Item> getAllItems() {
        return restTemplate.getForObject(getServiceUrl() + "items/", List.class);
    }
    
    @Override
    public Item getOneItem(Long id) {
        return restTemplate.getForObject(getServiceUrl() + "items/" + id, Item.class);
    }

    private String getServiceUrl() {
        return discoveryClient.getInstances(this.serviceName).get(0).getUri().toString() + "/";
    }

}