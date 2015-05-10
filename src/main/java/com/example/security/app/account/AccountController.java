package com.example.security.app.account;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.security.domain.model.Account;
import com.example.security.domain.service.userdetails.SampleUserDetails;

@Controller
@RequestMapping("account")
public class AccountController {

    @RequestMapping(method = RequestMethod.GET)
    public String view(/* (1) */ Principal principal, Model model) {
        // get login user information
        Authentication authentication = (Authentication) principal; // (2)
        // get UserDetails
        SampleUserDetails userDetails = (SampleUserDetails) authentication
                .getPrincipal(); // (3)
        // get account object
        Account account = userDetails.getAccount(); // (4)
        model.addAttribute(account);
        return "account/view";
    }
}