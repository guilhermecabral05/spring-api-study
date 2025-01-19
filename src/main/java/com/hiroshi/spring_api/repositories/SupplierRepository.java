package com.hiroshi.spring_api.repositories;

import com.hiroshi.spring_api.entities.SupplierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SupplierRepository extends JpaRepository<SupplierEntity, String> {
}
