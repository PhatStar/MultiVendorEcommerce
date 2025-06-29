package com.shopmall.response;

import lombok.Data;

//@Data chứa các hàm getter,setter,toString,equals,hashCode do lombok tự động tạo
@Data
public class ApiResponse {
    private String message;
}
