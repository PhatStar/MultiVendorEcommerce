package com.shopmall.model;

import com.shopmall.domain.OrderStatus;
import com.shopmall.domain.PaymentStatus;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String orderId;

    @ManyToOne
    private User user;

    private Long sellerId;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<OrderItem> orderItems = new ArrayList<>();

    @ManyToOne
    private Address shippingAddress;

    @Embedded
    private PaymentDetails paymentDetails = new PaymentDetails();

    private Double totalMaxRetailPrice;

    private Integer totalSellingPrice;

    private Integer discount;

    private OrderStatus orderStatus;

    private int totalItem;

    private PaymentStatus paymentStatus = PaymentStatus.PENDING;

    private LocalDateTime orderDate = LocalDateTime.now();

    private LocalDateTime deliveryDate = orderDate.plusDays(7); //cộng thêm 7 ngày vào orderDate

}
