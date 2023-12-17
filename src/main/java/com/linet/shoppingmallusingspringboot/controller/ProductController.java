package com.linet.shoppingmallusingspringboot.controller;

import com.linet.shoppingmallusingspringboot.constant.ProductCategory;
import com.linet.shoppingmallusingspringboot.dto.ProductQueryParams;
import com.linet.shoppingmallusingspringboot.dto.ProductRequest;
import com.linet.shoppingmallusingspringboot.model.Product;
import com.linet.shoppingmallusingspringboot. service. ProductService;
import com.linet.shoppingmallusingspringboot.util.Page;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import org. springframework. beans. factory.annotation. Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    //查詢商品列表
    @GetMapping("/products")
    public ResponseEntity<Page<Product>> getProducts(
                                            //查詢條件
                                            //ProductCategory category : 依照查ProductCategory中的enum值查看哪一分類商品(ex:category=FOOD)
                                            //String search:依照查詢關鍵字查看商品(ex:search=蘋果)
                                            @RequestParam(required = false) ProductCategory category,
                                            @RequestParam(required = false) String search,
                                            //排序方式
                                            @RequestParam(defaultValue = "created_date") String orderBy,
                                            @RequestParam(defaultValue = "desc")String sort,
                                            //分頁
                                            //limit : 要取得幾筆數據
                                            //offset : 要跳過幾筆數據
                                            @RequestParam(defaultValue = "10") @Max(1000) @Min(0) Integer limit,
                                            @RequestParam(defaultValue = "0") @Min(0)Integer offset)
    {
        ProductQueryParams productQueryParams = new ProductQueryParams();
        productQueryParams.setCategory(category) ;
        productQueryParams.setSearch(search) ;
        productQueryParams.setOrderBy(orderBy) ;
        productQueryParams.setSort(sort);
        productQueryParams.setLimit(limit);
        productQueryParams.setOffset(offset);

        //get product list
        List<Product> productList = productService.getProducts(productQueryParams);

        //get product total
        Integer total = productService.countProduct(productQueryParams);

        //分頁
        Page<Product> page = new Page<>();
        page.setOffset(offset);
        page.setLimit(limit);
        page.setTotal(total);
        page.setResults(productList) ;

        return ResponseEntity.status(HttpStatus.OK).body(page);
    }

    //查詢單個商品
    @GetMapping("/products/{productId}")
    public ResponseEntity<Product> getProduct(@PathVariable Integer productId) {
        Product product = productService.getProductById(productId);

        //檢查product是否存在
        if (product != null) {
            return ResponseEntity.status(HttpStatus.OK).body(product);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/products")
    public ResponseEntity<Product> createProduct(@RequestBody @Valid ProductRequest productRequest) {

        Integer productId = productService.createProduct(productRequest) ;
        Product product = productService.getProductById (productId) ;
        return ResponseEntity. status (HttpStatus. CREATED) .body (product) ;

    }

    @PutMapping("/products/{productId}")
    public ResponseEntity<Product> updateProduct (@PathVariable Integer productId,
                                                  @RequestBody @Valid ProductRequest productRequest) {
        //檢查product是否存在
        Product product = productService.getProductById(productId);
        if (product == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
        //修改商品數據
        productService.updateProduct (productId, productRequest);
        Product updatedProduct = productService.getProductById (productId) ;
        return ResponseEntity. status (HttpStatus.OK) .body(updatedProduct) ;
    }

    @DeleteMapping("/products/{productId}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProductById(productId) ;
        return ResponseEntity.status(HttpStatus.NO_CONTENT) .build();//回傳表示數據已刪除
    }
}