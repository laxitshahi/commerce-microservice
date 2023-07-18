package com.learningjava.inventoryservice;

import com.learningjava.inventoryservice.model.Inventory;
import com.learningjava.inventoryservice.repository.InventoryRepository;
import com.learningjava.inventoryservice.service.InventoryService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    public CommandLineRunner loadData(InventoryRepository inventoryRepository){
        return args -> {
            Inventory item1 = new Inventory();
            item1.setSkuCode("big_stick");
            item1.setQuantity(20);

            Inventory item2 = new Inventory();
            item2.setSkuCode("small_stick");
            item2.setQuantity(0);

            inventoryRepository.save(item1);
            inventoryRepository.save(item2);
        };
    }
}
