package ro.sd.a2.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import ro.sd.a2.entity.User;
import ro.sd.a2.form.LoginForm;
import ro.sd.a2.service.UserService;

import javax.validation.Valid;
import java.security.Principal;


@Controller
public class FirstController {

    private static final Logger log = LoggerFactory.getLogger(FirstController.class);

    @Autowired
    private UserService userService;

    @GetMapping("/profile")
    @ResponseBody
    public User showProfile() {
        //validation if needed
        //shall we log a little?
        //ModelAndView mav = new ModelAndView();
        /*User user = new User("Bubu");
        user.setPassword("1234");
        userService.saveUser(user);
        mav.addObject("userObj", "bubu");
        mav.addObject("numeStudent", user.getUsername());
        // adaugi x obiecte*/
        //mav.setViewName("profile");
        //log the final outcome: Success y?
        //return mav;
        User user = new User();
        user.setUsername("aaa");
        user.setPassword(new BCryptPasswordEncoder().encode("updated"));
        user.setId("030ba9fe-5e6a-4966-89f3-c03cc176b3ee");
        return user;
    }

    @GetMapping("/login")
    public ModelAndView loginPage(){
        ModelAndView modelAndView = new ModelAndView("login");
        modelAndView.addObject("loginForm", new LoginForm());
        return modelAndView;
    }

    @PostMapping("/login")
    public ModelAndView processLoginRequest(@Valid LoginForm loginForm, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView("profile");
        modelAndView.addObject("numeStudent", loginForm.getUsername());
        return modelAndView;
    }

    @GetMapping("/logout-success")
    public ModelAndView logoutPage(){
        ModelAndView modelAndView = new ModelAndView("logout");
        return modelAndView;
    }

    @RequestMapping("user")
    public Principal user(Principal principal, ModelAndView mav){
        mav.setViewName("redirect:/profile");
        return principal;
    }

}
