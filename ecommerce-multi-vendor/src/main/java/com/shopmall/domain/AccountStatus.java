package com.shopmall.domain;

public enum AccountStatus {
    PENDING_VERIFICATION,                   // Tài khoản đã được tạo nhưng chưa được xác minh
    ACTIVE,                                 // Tài khoản đang hoạt động trong tình trạng tốt
    SUSPENDED,                              // Tài khoản tạm thời bị đình chỉ, có thể là do vi phạm
    DEACTIVATED,                            //Tài khoản đã bị vô hiệu hóa, người dùng có thể đã chọn hủy kích hoạt
    BANNED,                                 //Tài khoản bị cấm vĩnh viễn
    CLOSED                                  //Tài khoản bị đóng vĩnh viễn, có thể theo yêu cầu của người dùng
}
