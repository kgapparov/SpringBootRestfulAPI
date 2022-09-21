package service;

import common.UserStatus;
import dto.User;
import entity.UserEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private UserRepository userEntityRepository;

    @Autowired
    public UserService(UserRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public void createUser(User user) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUserName());
        userEntity.setPassword(UUID.randomUUID().toString());
        userEntity.setStatus(UserStatus.PENDING);
        userEntityRepository.save(userEntity);
    }

    public User readUserByUsername(String username) {
        Optional<UserEntity> userEntity = userEntityRepository.findUserEntitiesByUsername(username);
        User user = new User();
        BeanUtils.copyProperties(userEntity.get(), user);
        return user;
    }
}
