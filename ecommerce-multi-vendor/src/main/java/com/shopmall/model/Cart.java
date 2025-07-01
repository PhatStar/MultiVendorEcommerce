package com.shopmall.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToOne
    private User user;

    //CascadeType.ALL : tất cả thao tác trên Cart sẽ tự động áp dụng cho CartItem (insert, update, delete, ...)
    //orphanRemoval : tự động xóa nó khỏi database khi xóa một phần tử CartItem
    @OneToMany(mappedBy = "cart", cascade =  CascadeType.ALL , orphanRemoval = true)
    private Set<CartItem> cartItems = new HashSet<>();

    private double totalSellingPrice;

    private int totalItem;

    private int totalMaxRetailPrice;

    private int discount;

    private String couponCode;

}
