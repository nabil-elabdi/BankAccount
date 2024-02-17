package org.sid.bankaccountservice.service;

import org.sid.bankaccountservice.dto.BankAccountRequestDTO;
import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.sid.bankaccountservice.mappers.AcountMapper;
import org.sid.bankaccountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.UUID;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {
    private BankAccountRepository bankAccountRepository;
    private AcountMapper acountMapper;

    public AccountServiceImpl(BankAccountRepository bankAccountRepository, AcountMapper acountMapper) {
        this.bankAccountRepository = bankAccountRepository;
        this.acountMapper = acountMapper;
    }

    @Override
    public BankAccountResponseDTO addAccount(BankAccountRequestDTO request) {
        BankAccount account = BankAccount.builder()
                .id(UUID.randomUUID().toString())
                .createdAt(new Date())
                .balance(request.getBalance())
                .type(request.getType())
                .currency(request.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(account);
        BankAccountResponseDTO bankAccountResponseDTO = acountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }

    @Override
    public BankAccountResponseDTO updateAccount(String id, BankAccountRequestDTO request) {
        BankAccount account = BankAccount.builder()
                .id(id)
                .createdAt(new Date())
                .balance(request.getBalance())
                .type(request.getType())
                .currency(request.getCurrency())
                .build();
        BankAccount savedBankAccount = bankAccountRepository.save(account);
        BankAccountResponseDTO bankAccountResponseDTO = acountMapper.fromBankAccount(savedBankAccount);
        return bankAccountResponseDTO;
    }
}
