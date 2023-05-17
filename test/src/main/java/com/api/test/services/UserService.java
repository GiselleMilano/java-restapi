package com.api.test.services;
import com.api.test.models.UserModel;
import com.api.test.repositories.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class UserService {

    @Autowired
    IUserRepository iUserRepository;

    public List<UserModel> getUsers() {
        return iUserRepository.findAll();
    }

    public UserModel createUser(UserModel user) {
        UserModel newUser = new UserModel();
        newUser.setEmail(user.getEmail());
        newUser.setName(user.getName());
        newUser.setLastName(user.getLastName());

        return iUserRepository.save(newUser);
    }

    public UserModel updateUser(UserModel user, UserModel dataToUser) {
        user.setEmail(dataToUser.getEmail());
        user.setName(dataToUser.getName());
        user.setLastName(dataToUser.getLastName());

        return iUserRepository.save(user);
    }

    public UserModel findUserById(Long id) {
        return iUserRepository.findById(id).orElse(null);
    }

    public void deleteUser(UserModel user) {
        iUserRepository.delete(user);
    }
}
