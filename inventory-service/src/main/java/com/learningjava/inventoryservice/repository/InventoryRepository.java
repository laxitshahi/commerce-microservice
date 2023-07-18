package com.learningjava.inventoryservice.repository;

import com.learningjava.inventoryservice.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    // Optional :: if value is present, return true and get() will return the value
    // isPresent() can be used to check if the object is present (true/fa;se)
    Optional<Inventory> findBySkuCode(String skuCode);
    // At runtime, spring will

}
