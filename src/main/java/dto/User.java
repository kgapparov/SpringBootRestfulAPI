package dto;

import common.UserStatus;
import lombok.Data;

@Data
public class User {
    private String userName;
    private UserStatus status;
}
