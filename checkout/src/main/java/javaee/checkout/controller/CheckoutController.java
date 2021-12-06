package javaee.checkout.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.http.*;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/checkout")
public class CheckoutController {

    @Autowired private RestTemplate restTemplate;

    @RequestMapping(value = "/{userEmail}/{id}/{token}", method = RequestMethod.POST)
    @HystrixCommand(fallbackMethod = "catalogFallBack")
    public ResponseEntity<?> purchase(
            @PathVariable("userEmail") String userEmail,
            @PathVariable("id") Long id,
            //@RequestHeader("Authorization") String token
            @PathVariable("token") String token
    ) {

        try {

            HttpHeaders headers = new HttpHeaders();
            headers.add("Authorization", "Bearer " + token);
            HttpEntity<String> request = new HttpEntity<String>(headers);

            String url = "http://zuul-server-application/api/user-orders/add/{userEmail}/{id}";

            String result = restTemplate.postForObject(url, request, String.class, userEmail, id.toString());

            return ResponseEntity.ok("Response "+result);

        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Bad "+e.getMessage());
        }


    }

    //@RequestMapping(value = "/hello", method = RequestMethod.POST)
    @GetMapping("/hello")
    public ResponseEntity<?> hello() {
        return ResponseEntity.ok("Hello world");
    }

    public ResponseEntity<?> catalogFallBack(String userEmail, Long id, String token) {
        System.out.println("Nothing");
        return ResponseEntity.badRequest().body("Service Unavailable");
    }
}
