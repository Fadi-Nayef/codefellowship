package com.example.codefellowship.controllers;

import com.example.codefellowship.domain.ApplicationUser;
import com.example.codefellowship.domain.Post;
import com.example.codefellowship.infrastructure.ApplicationUserRepository;
import com.example.codefellowship.infrastructure.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Controller
public class PostController {
   @Autowired
    PostRepository postRepository;
   @Autowired
   ApplicationUserRepository applicationUserRepository;
   @Autowired
   ApplicationUser applicationUser;

@GetMapping("/post")
public String showPost(Model m ){
    List<Post>  post = postRepository.findAll();
    m.addAttribute("posts",post);
    return "Userdata";
}

   @PostMapping("/post")
public RedirectView addpost (String body ){
      LocalDateTime time = LocalDateTime.now();
       DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
       String formatDateTime = time.format(format);

       Post postBody = new Post();
       postBody.setBody(body);
       postBody.setCreatedAt(formatDateTime);

       UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

       ApplicationUser user = applicationUserRepository.findUserByUsername( userDetails.getUsername());
        postBody.setApplicationUser(user);
        postRepository.save(postBody);
   return new RedirectView("/");
   }

//   @GetMapping("/post")
//   public String showPost (Module m , String body, String createdAt , ){
//
//   }

}
