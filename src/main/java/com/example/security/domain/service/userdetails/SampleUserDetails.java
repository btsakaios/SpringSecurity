package com.example.security.domain.service.userdetails;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import com.example.security.domain.model.Account;

public class SampleUserDetails extends User {
    private static final long serialVersionUID = 1L;

    private final Account account; // (1)

    public SampleUserDetails(Account account) {
        super(account.getUsername(), account.getPassword(), createRole(account)); // (2)
        this.account = account;

    }

    private static Collection<? extends GrantedAuthority> createRole(
            Account account) {
        // sample role
        return Collections
                .singletonList(new SimpleGrantedAuthority("ROLE_USER")); // (3)
    }

    public Account getAccount() { // (4)
        return account;
    }
}