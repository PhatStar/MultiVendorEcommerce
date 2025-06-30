package com.shopmall.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.shopmall.domain.userRole;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.boot.autoconfigure.amqp.RabbitConnectionDetails;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) //Ko để lộ password ra frontend (FE)
    private String password;

    private String email;

    private String fullName;

    private String mobile;

    private userRole role = userRole.ROLE_CUSTOMER;

    @OneToMany
    private Set<Address> addresses = new HashSet<>(); //Dùng hashSet chứa địa chỉ để lưu vào DB 1 địa chỉ, khi mua thì load ko cần nhập lại

    @ManyToMany
    @JsonIgnore //FE sẽ kh thấy thông tin coupon đã dùng, nhưng BE vẫn có thể xử lý đc như bthg
    private Set<Coupon> usedCoupons = new HashSet<>(); //HashSet -> Chỉ có 1 mã khuyến mãi duy nhất
}
