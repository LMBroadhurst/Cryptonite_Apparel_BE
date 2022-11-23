package project.cryptoniteapparel.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long orderId;
    private Integer totalCost;
    private Boolean orderStatus;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;

    @ManyToMany(mappedBy = "presentInOrders")
    private List<Product> products;
}
