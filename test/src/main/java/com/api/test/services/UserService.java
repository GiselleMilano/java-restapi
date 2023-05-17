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
}
