package ro.sd.a2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.repository.UserRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return new ArrayList<>();
    }

    public void saveUser(User user){
        userRepository.save(user);
    }

    public User findUserById(String id) {
        if( userRepository.findById(id).isPresent())
            return userRepository.findById(id).get();
        else return null;
    }

    public List<User> findAllUSers() { return userRepository.findAll(); }

    public void updateUserPassword(User user,String  newPass){
        user.setPassword(newPass);
        userRepository.save(user);
    }

    public void deleteUser(User user) { userRepository.delete(user); }

}
