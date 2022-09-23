package service;

import common.UserStatus;
import dto.User;
import entity.UserEntity;
import exception.EntityNotFoundException;
import exception.UserAlreadyExists;
import exception.config.GlobalErrorCode;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.UserRepository;

import java.util.Optional;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userEntityRepository;

    @Autowired
    public UserService(UserRepository userEntityRepository) {
        this.userEntityRepository = userEntityRepository;
    }

    public void createUser(User user) {
        Optional<UserEntity> userEntityByUsername = userEntityRepository.findUserEntitiesByUsername(user.getUserName());
        if (userEntityByUsername.isPresent()) {
            throw new UserAlreadyExists("User is already exists", GlobalErrorCode.ERROR_USER_ALREADY_REGISTERED);
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(user.getUserName());
        userEntity.setPassword(UUID.randomUUID().toString());
        userEntity.setStatus(UserStatus.PENDING);
        userEntityRepository.save(userEntity);
    }

    public User readUserByUsername(String username) {
        UserEntity userEntity = userEntityRepository.findUserEntitiesByUsername(username).orElseThrow(EntityNotFoundException::new);
        User user = new User();
        BeanUtils.copyProperties(userEntity, user);
        return user;
    }
}
