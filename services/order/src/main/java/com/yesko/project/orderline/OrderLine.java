package com.yesko.project.orderline;

import com.yesko.project.order.Order;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Builder
@Table(name = "t_order_line")
public class OrderLine  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "order_id")
    private Order order;
    @Column(name = "product_id")
    private Integer productId;
    @Column(name = "quantity")
    private Integer quantity;
}
