package javaee.checkout;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

import javaee.checkout.models.Item;
import javaee.checkout.services.CatalogService;

@RestController
@RequestMapping("checkout/")
public class CheckoutController {

    @Autowired
    private CatalogService catalogService;

    @GetMapping("/{id}/{amount}")
    @HystrixCommand(fallbackMethod = "catalogFallBack")
    public double purchase(@PathVariable Long id, @PathVariable Long amount) {
        Item item = catalogService.getOneItem(id);
        return item.price * amount;
    }

    public double catalogFallBack(Long id, Long amount) {
        System.out.println("Nothing");
        return 0.0;
    }
}