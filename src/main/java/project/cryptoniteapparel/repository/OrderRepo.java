package project.cryptoniteapparel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import project.cryptoniteapparel.model.Order;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
