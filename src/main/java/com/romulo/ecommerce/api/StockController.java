package com.romulo.ecommerce.api;

import com.romulo.ecommerce.api.model.request.StockItemRequest;
import com.romulo.ecommerce.api.model.response.StockItemResponse;
import com.romulo.ecommerce.product.Product;
import com.romulo.ecommerce.product.ProductService;
import com.romulo.ecommerce.stock.StockItem;
import com.romulo.ecommerce.stock.StockService;

import io.swagger.annotations.Api;

import java.util.Optional;
import java.util.stream.Stream;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/v1/stockItems")
@Api(value = "Stock")
public class StockController {

    private final StockService stockService;
    private final ProductService productService;

    public StockController(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StockItemRequest stockItemRequest) {
        Optional<Product> product = productService.findById(stockItemRequest.getProductId());
        if(!product.isPresent()) {
            return ResponseEntity.badRequest().body("inválid productId: " + stockItemRequest.getProductId());
        }

        StockItem stockItem = new StockItem(product.get(), stockItemRequest.getAmount(), stockItemRequest.getPrice());

        StockItem inserted = stockService.save(stockItem);
        return ResponseEntity.ok(new StockItemResponse(inserted));
    }

    @PutMapping
    public ResponseEntity<?> update(@RequestBody StockItemRequest stockItemRequest) {
        Optional<Product> product = productService.findById(stockItemRequest.getProductId());
        if(!product.isPresent()) {
            return ResponseEntity.badRequest().body("inválid productId: " + stockItemRequest.getProductId());
        }

        StockItem stockItem = stockService.findByProductId(product.get().getId()).get();

        stockItem.setAmount(stockItemRequest.getAmount());
        stockItem.setPrice(stockItemRequest.getPrice());
        stockItem.setProduct(product.get());

        StockItem updated = stockService.save(stockItem);
        return ResponseEntity.ok(new StockItemResponse(updated));
    }

    @GetMapping
    public ResponseEntity<?> findAll() {
        Stream<StockItemResponse> stockItems = stockService.findAll().stream()
                .map(StockItemResponse::new);

        return ResponseEntity.ok(stockItems);
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<?> findById(@PathVariable("id") long id) {
        Optional<StockItem> stockItem = stockService.findById(id);
        if(stockItem.isPresent()) {
            return ResponseEntity.ok(new StockItemResponse(stockItem.get()));
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteById(@PathVariable("id") long id) {
        stockService.deleteById(id);
        return ResponseEntity.accepted().build();
    }
}
