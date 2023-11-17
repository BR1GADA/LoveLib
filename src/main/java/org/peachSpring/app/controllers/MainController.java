package org.peachSpring.app.controllers;

import org.peachSpring.app.models.User;
import org.peachSpring.app.security.UsersDetails;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MainController {
    @GetMapping("/")
    public String showMainPage(Model model){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        UsersDetails usersDetails = (UsersDetails) authentication.getPrincipal();
        User curUser = usersDetails.getOrigin();
        model.addAttribute("usersRole", curUser.getRole());
        model.addAttribute("usersName", curUser.getName());
        model.addAttribute("usersId", curUser.getId());
        return "main/main";
    }

}
