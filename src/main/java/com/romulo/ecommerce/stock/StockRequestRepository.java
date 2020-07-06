package com.romulo.ecommerce.stock;

import org.springframework.data.jpa.repository.JpaRepository;

public interface StockRequestRepository extends JpaRepository<StockRequest, Long> {
}
