package pro.bolshakov.geekbrains.springrestapi.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.bolshakov.geekbrains.springrestapi.dto.BalanceDto;
import pro.bolshakov.geekbrains.springrestapi.service.BalanceService;

import java.time.LocalDate;

@RestController
@RequestMapping("/balance")
public class BalanceController {

    private final BalanceService service;

    public BalanceController(BalanceService service) {
        this.service = service;
    }

    @GetMapping
    public BalanceDto getBalance(@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date){
        if(date == null){
            return service.getBalance();
        }
        else {
            return service.getBalanceByDate(date);
        }
    }
}
