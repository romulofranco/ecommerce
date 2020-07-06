package com.romulo.ecommerce.stock;

import com.romulo.ecommerce.order.Status;
import com.romulo.ecommerce.product.Product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StockService {

    private final StockItemRepository stockItemRepository;
    private final StockRequestRepository stockRequestRepository;
    private static final Logger logger = LoggerFactory.getLogger(StockService.class);

    public StockService(StockItemRepository stockItemRepository, StockRequestRepository stockRequestRepository) {
        this.stockItemRepository = stockItemRepository;
        this.stockRequestRepository = stockRequestRepository;
    }

    public StockItem save(StockItem stockItem) {
        saveStockRequest(stockItem);
        return stockItemRepository.save(stockItem);
    }

    public void deleteById(Long id) {
        try {
            stockItemRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            logger.warn("user attempted to delete a non-existent client. Id: {}.", id);
        }
    }

    public Optional<StockItem> findById(long id) {
        return stockItemRepository.findById(id);
    }

    public List<StockItem> findAll() {
        return stockItemRepository.findAll();
    }

    public Optional<StockItem> findByProductId(long productId) {
        return stockItemRepository.findByProductId(productId);
    }

    private StockRequest saveStockRequest(StockItem stockItem) {
        StockRequest stockRequest = new StockRequest(stockItem.getProduct(), stockItem.getAmount(), Status.FINALIZED);
        return stockRequestRepository.save(stockRequest);
    }

}
