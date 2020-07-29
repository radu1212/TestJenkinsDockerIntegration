package ro.sd.a2.tests;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestComponent;
import org.springframework.stereotype.Component;
import ro.sd.a2.entity.User;
import ro.sd.a2.service.UserService;
import org.junit.Assert;
import ro.sd.a2.service.repository.UserRepository;

import javax.transaction.Transactional;
import java.util.Optional;


@SpringBootTest
@TestComponent
public class SaveOperationTest {

    @Autowired
    private UserService userService;

    @Test
    public void testSaveOperation(){
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        userService.saveUser(user);
        User user1 = userService.findUserById(user.getId());
        Assert.assertTrue(user.getUsername().equals(user1.getUsername())
                && user.getPassword().equals(user1.getPassword()));
    }

}
