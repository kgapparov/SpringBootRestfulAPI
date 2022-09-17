package entity;

import common.UserStatus;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@ToString
@Table(name="user")
public class UserEntity {
    @Id
    private Integer userId;

    private String username;

    private String password;

    private UserStatus status;
}
