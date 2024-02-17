package org.sid.bankaccountservice.mappers;

import org.sid.bankaccountservice.dto.BankAccountResponseDTO;
import org.sid.bankaccountservice.entities.BankAccount;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class AcountMapper {
    private ModelMapper modelMapper = new ModelMapper();

    public BankAccountResponseDTO fromBankAccount(BankAccount account) {
        return modelMapper.map(account, BankAccountResponseDTO.class);
    }

//    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO requestDTO){
//        BankAccount bankAccount = new BankAccount();
//        BeanUtils.copyProperties(requestDTO,bankAccount);
//        return bankAccount;
//    }


}
