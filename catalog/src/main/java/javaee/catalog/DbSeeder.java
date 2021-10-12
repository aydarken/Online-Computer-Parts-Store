package javaee.catalog;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javaee.catalog.repositories.ItemRepository;
import javaee.catalog.models.Item;

@Configuration
public class DbSeeder {

    @Bean
    CommandLineRunner initDatabase(ItemRepository itemRepository) {
        return args -> {
            itemRepository.save(new Item("Item 1", "Description 1", 123.32));
            itemRepository.save(new Item("Item 2", "Description 2", 231.321));
        };
    }

}