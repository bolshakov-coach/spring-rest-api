package pro.bolshakov.geekbrains.springrestapi.service;

import org.springframework.stereotype.Service;
import pro.bolshakov.geekbrains.springrestapi.dto.BalanceDto;
import pro.bolshakov.geekbrains.springrestapi.dto.TransactionDto;

import java.time.LocalDate;

@Service
public class BalanceServiceImpl implements BalanceService {

    private final TransactionService transactionService;

    public BalanceServiceImpl(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @Override
    public BalanceDto getBalance() {
        double sum = transactionService.getAll()
                .stream()
                .mapToDouble(TransactionDto::getFlow)
                .sum();
        return new BalanceDto(LocalDate.now(), sum);
    }

    @Override
    public BalanceDto getBalanceByDate(LocalDate date) {
        double sum = transactionService.getAll()
                .stream()
                .filter(entity -> !entity.getDate().isAfter(date))
                .mapToDouble(TransactionDto::getFlow)
                .sum();
        return new BalanceDto(date, sum);
    }
}
