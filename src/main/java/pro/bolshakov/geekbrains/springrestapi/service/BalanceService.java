package pro.bolshakov.geekbrains.springrestapi.service;

import pro.bolshakov.geekbrains.springrestapi.dto.BalanceDto;

import java.time.LocalDate;

public interface BalanceService {
    BalanceDto getBalance();

    BalanceDto getBalanceByDate(LocalDate date);
}
