package project.cryptoniteapparel.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import project.cryptoniteapparel.model.Product;
import project.cryptoniteapparel.service.ProductService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
@CrossOrigin("http://localhost:3000/")
public class ProductController {

    private final ProductService productService;

//    Get Mapping Controller

    @GetMapping("/getAllProducts")
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getAllProducts());
    }

    @GetMapping("/getProductById/{id}")
    public ResponseEntity<Optional<Product>> getProductById(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.getProductById(id));
    }

//    Post Mapping Controller

    @PostMapping("/createProduct")
    public ResponseEntity<Product> createProduct(@RequestBody Product product) {

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.createProduct(product));
    }

//    Delete Mapping Controller

    @DeleteMapping("/deleteProduct/{id}")
    public ResponseEntity<String> deleteProduct(@PathVariable Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.deleteProduct(id));
    }

//    Put Mapping Controller

    @PutMapping("/editProduct")
    public ResponseEntity<Product> editProduct(@RequestBody Product product, Long id) {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(productService.editProduct(product, id));
    }
}
