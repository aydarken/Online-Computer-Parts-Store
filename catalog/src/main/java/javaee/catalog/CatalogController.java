package javaee.catalog;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

import javaee.catalog.models.Item;
import javaee.catalog.repositories.ItemRepository;

@RestController
@RequestMapping("/items")
public class CatalogController {

    private ItemRepository repository;

    public CatalogController(ItemRepository repository) {
        this.repository = repository;
    }


    @GetMapping("/")
    @HystrixCommand(fallbackMethod = "catalogFullback")
    public List<Item> all() {
        return repository.findAll();
    }

    public void catalogFullback(String name, double price) {
        System.out.println("User not chosen");
    }

    @GetMapping("/{id}")
    @HystrixCommand(fallbackMethod = "catalogFullback")
    public Item one(@PathVariable Long id) {
        return repository.findById(id).get();
    }


}