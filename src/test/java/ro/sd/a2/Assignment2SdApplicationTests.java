package ro.sd.a2;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.web.servlet.MockMvc;
import ro.sd.a2.controller.FirstController;
import ro.sd.a2.entity.User;
import ro.sd.a2.form.LoginForm;
import ro.sd.a2.service.UserService;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
//@WebMvcTest
class Assignment2SdApplicationTests {

    @Autowired
    private UserService userService;

    @Mock
    private UserService userService1;

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @BeforeAll
    static void setup(){
        System.out.println("BeforeAll : Executed just once before all tests");
    }

    @AfterAll
    static void tearDown(){
        System.out.println("AfterAll : Executed just once after all tests");
    }

    @Test
    void contextLoads() {
        System.out.println("Spring boot environment test");
    }

    @BeforeEach
    public void createAnUserObject(){
        System.out.println("Before : created an user obj");
    }

    @AfterEach
    public void destroyTheUserObject(){
        System.out.println("After : destroyed the user obj");
    }

    @Test
    public void testSaveOperation(){
        User user = new User();
        user.setUsername("aaa");
        user.setPassword("bbb");
        userService.saveUser(user);
        User user1 = userService.findUserById(user.getId());
        System.out.println("Inside test 1");
        Assert.assertTrue(user.getUsername().equals(user1.getUsername())
                && user.getPassword().equals(user1.getPassword()));
    }

    @Test
    public void testUpdateOperation(){

        User user = new User();
        user.setUsername("aaa");
        user.setPassword(new BCryptPasswordEncoder().encode("updated"));
        user.setId(userService.findAllUSers().get(0).getId());

        ArrayList<User> users = new ArrayList<>();
        users.add(user);

        Mockito.when(userService1.findAllUSers()).thenReturn(users);
        User user1 = userService1.findAllUSers().get(0); // username : aaa |||| pass : updated
        //System.out.println(new BCryptPasswordEncoder().matches("updated", user.getPassword()));

        System.out.println("Inside test 2");
        Assert.assertEquals(user1.getUsername(), user.getUsername());
    }

    @Test
    public void whenNotUseMockAnnotation_thenCorrect() {
        List mockList = Mockito.mock(ArrayList.class);

        mockList.add("one");
        Mockito.verify(mockList).add("one");
        Assert.assertEquals(0, mockList.size());

        Mockito.when(mockList.size()).thenReturn(100);
        Assert.assertEquals(100, mockList.size());
    }


    /*@Autowired
    private MockMvc mvc;

    @MockBean
    private UserService service;*/

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
