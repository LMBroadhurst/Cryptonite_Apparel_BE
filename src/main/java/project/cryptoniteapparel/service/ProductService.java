package project.cryptoniteapparel.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.cryptoniteapparel.model.Member;
import project.cryptoniteapparel.model.Product;
import project.cryptoniteapparel.repository.ProductRepo;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepo productRepo;

//    Get Mapping Service

    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    public Optional<Product> getProductById(Long id) {
        return productRepo.findById(id);
    }

//    Post Mapping

    public Product createProduct(Product product) {
        Product addedProduct = productRepo.save(product);
        int productRepoSize = productRepo.findAll().size();

        return productRepo.findAll().get(productRepoSize - 1);
    }

//    Delete Mapping

    public String deleteProduct(Long id) {
        Optional<Product> product = productRepo.findById(id);

        if (product.isEmpty()) {
            return "Could not find member with id: " + id;
        }

        productRepo.deleteById(id);
        return "Member with id " + id + " has been deleted.";
    }

//    Put Mapping

    public Product editProduct(Product product, Long id) {
        Product currentProductDetails = productRepo.findById(id).get();

        product.setId(id);
        if (product.getName() == null) {
            product.setName(currentProductDetails.getName());
        }
        if (product.getPrice() == null) {
            product.setPrice(currentProductDetails.getPrice());
        }
        if (product.getDescription() == null) {
            product.setDescription(currentProductDetails.getDescription());
        }
        if (product.getQuantity() == null) {
            product.setQuantity(currentProductDetails.getQuantity());
        }
        if (product.getSize() == null) {
            product.setSize(currentProductDetails.getSize());
        }
        if (product.getOwnedByMember() == null) {
            product.setOwnedByMember(currentProductDetails.getOwnedByMember());
        }

        return productRepo.save(product);
    }
}
