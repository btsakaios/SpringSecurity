package com.example.security.domain.service.userdetails;

import javax.inject.Inject;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.terasoluna.gfw.common.exception.ResourceNotFoundException;

import com.example.security.domain.model.Account;
import com.example.security.domain.service.account.AccountSharedService;

@Service
public class SampleUserDetailsService implements UserDetailsService {
    @Inject
    AccountSharedService accountSharedService; // (1)

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try {
            Account account = accountSharedService.findOne(username); // (2)
            return new SampleUserDetails(account); // (3)
        } catch (ResourceNotFoundException e) {
            throw new UsernameNotFoundException("user not found", e); // (4)
        }
    }

}