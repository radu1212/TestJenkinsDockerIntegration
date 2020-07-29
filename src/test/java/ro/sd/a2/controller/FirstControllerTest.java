package ro.sd.a2.controller;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import ro.sd.a2.entity.User;
import ro.sd.a2.form.LoginForm;
import ro.sd.a2.service.UserService;

import javax.servlet.ServletContext;
import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.springframework.mock.http.server.reactive.MockServerHttpRequest.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FirstController.class)
class FirstControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;

    /*@Test
    public void givenEmployees_whenGetEmployees_thenReturnJsonArray()
            throws Exception {

        User user = new User();
        user.setUsername("aaa");
        user.setPassword(new BCryptPasswordEncoder().encode("updated"));
        user.setId("030ba9fe-5e6a-4966-89f3-c03cc176b3ee");

        List<User> users = new ArrayList<>();
        users.add(user);

        given(service.getAllUsers()).willReturn(users);

        LoginForm form = new LoginForm();
        form.setPassword("updated");
        form.setUsername("aaa");


        mvc.perform(get("/profile")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].username", is(user.getUsername())));
    }
*/
}