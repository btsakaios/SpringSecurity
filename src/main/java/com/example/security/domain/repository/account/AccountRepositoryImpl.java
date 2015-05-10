package com.example.security.domain.repository.account;

import javax.inject.Inject;

import org.springframework.stereotype.Repository;

import jp.terasoluna.fw.dao.QueryDAO;

import com.example.security.domain.model.Account;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    @Inject
    QueryDAO queryDAO;

    @Override
    public Account findOne(String username) {
        Account account = queryDAO.executeForObject("account.findOne",
                username, Account.class);
        return account;
    }

}