package com.example.codefellowship.controllers;

import com.example.codefellowship.domain.ApplicationUser;
import com.example.codefellowship.infrastructure.ApplicationUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import java.security.Principal;
@Controller
public class UserController {


    @Autowired
    ApplicationUserRepository applicationUserRepository;

@Autowired
    BCryptPasswordEncoder bcryptPasswordEncoder;
@Autowired
    PasswordEncoder passwordEncoder;



    @GetMapping("/")
    public String getHome(Principal p, Model m) {
        if(p != null) {
            m.addAttribute("user", applicationUserRepository.findUserByUsername(p.getName()));
            return "Home";
        } else {
            return "login";
        }
    }



    @GetMapping("/signup")
    public String showSignUp(){

        return "SignUp";
}

    @GetMapping("/login")
    public String getLogin() {
        return "logIn";
    }

    @GetMapping("/profile/{id}")
public String getProfile (@PathVariable Long id , Model m){
        UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        m.addAttribute("user",applicationUserRepository.findById(id).get());
        return "userview";
    }

    @PostMapping("/signup")
    public RedirectView createUser(@RequestParam String username,
                                   @RequestParam String password,
                                   @RequestParam String bio,
                                   @RequestParam String dob,
                                   @RequestParam String stName,
                                   @RequestParam String lastName){
        ApplicationUser user = new ApplicationUser();
       String encodedPassword = bcryptPasswordEncoder.encode(password);
       user.setUsername(username);
        user.setPassword(encodedPassword);
       user.setBio(bio);
       user.setDob(dob);
       user.setStName(stName);
       user.setLastName(lastName);
//        ApplicationUser user = new ApplicationUser(username, encodedPassword,bio,dob,stName,lastName);
        applicationUserRepository.save(user);

        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return new RedirectView("/");
    }

        //OR
//          ApplicationUser user = new ApplicationUser("","");
//        System.out.println("username"+username);
//        System.out.println("pswd"+password);

//        user.setUsername(username);
//        user.setBio(bio);
//        user.setDob(dob);
//        user.setStName(stName);
//        user.setLastName(lastName);

//        Account newAccount = new Account(username, encoder.encode(password));
//        user=applicationUserRepository.save(user);

//        Authentication authentication = new UsernamePasswordAuthenticationToken(user, null, user.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);





//    @GetMapping("/userview")
//    public String showUsers(Principal p, Model m){
//
//        return "userview";
//    }
}
