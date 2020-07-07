package com.romulo.ecommerce.api;

import com.romulo.ecommerce.api.model.request.StockItemRequest;
import com.romulo.ecommerce.api.model.request.StockRequestItem;
import com.romulo.ecommerce.api.model.request.StockRequestRequest;
import com.romulo.ecommerce.api.model.response.StockItemResponse;
import com.romulo.ecommerce.product.ProductService;
import com.romulo.ecommerce.stock.StockItem;
import com.romulo.ecommerce.stock.StockRequest;
import com.romulo.ecommerce.stock.StockService;

import io.swagger.annotations.Api;

import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/v1/stockRequest")
@Api(value = "Stock Request")
public class StockRequestController {

    private final StockService stockService;
    private final ProductService productService;

    public StockRequestController(StockService stockService, ProductService productService) {
        this.stockService = stockService;
        this.productService = productService;
    }

    @PostMapping
    public ResponseEntity<?> save(@RequestBody StockRequestRequest stockRequestRequest) {
        for (StockRequestItem stockRequestItem: stockRequestRequest.getItems()) {

            Optional<StockItem> stockItem = stockService.findByProductId(stockRequestItem.getProductId());

            if (!stockItem.isPresent()) {
                return ResponseEntity.badRequest().body("the store does not work with this type of product. id:" + stockRequestItem.getProductId());
            } else {
                stockItem.get().setAmount(stockItem.get().getAmount() + stockRequestItem.getAmount());
                stockService.save(stockItem.get());
            }
        }
        return ResponseEntity.ok("stock has been updated");
    }
}
