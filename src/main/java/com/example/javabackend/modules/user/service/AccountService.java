package com.example.javabackend.modules.user.service;

import com.example.javabackend.entity.AccountType;
import com.example.javabackend.entity.Accounts;
import com.example.javabackend.modules.user.DTO.AccountsDTO;
import com.example.javabackend.modules.user.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCrypt;

import org.springframework.stereotype.Service;

@Service
public class AccountService {
    @Autowired
    private AccountRepository accountsRepository;

    public AccountsDTO  createAccount(AccountsDTO accountsDTO) {
        Accounts accounts = new Accounts();
        // set các giá trị cho đối tượng accounts từ accountsDTO
        String salt = BCrypt.gensalt();
        String hashedPassword = BCrypt.hashpw(accountsDTO.getPassword(), salt);
        accounts.setPassword(hashedPassword);
        accounts.setFullName(accountsDTO.getFullName());
        accounts.setPhoneNumber(accountsDTO.getPhoneNumber());
        accounts.setEmail(accountsDTO.getEmail());
        accounts.setGender(accountsDTO.getGender());
        accounts.setBrithday(accountsDTO.getBirthday());
        accounts.setAddress(accountsDTO.getAddress());
        // set AccountType cho Accounts
        AccountType accountType = new AccountType();
        accountType.setAccountTypeID(accountsDTO.getAccountTypeId());
        accounts.setAccountTypes(accountType);

        accounts = accountsRepository.save(accounts);

        return new AccountsDTO(
                accounts.getAccountID(),
                accounts.getPassword(),
                accounts.getFullName(),
                accounts.getPhoneNumber(),
                accounts.getEmail(),
                accounts.getGender(),
                accounts.getBrithday(),
                accounts.getAddress(),
                accounts.getAccountTypes().getAccountTypeID()
        );
    }
}