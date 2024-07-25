package com.todocodeacademy.max_rep_calculator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/calculate")
public class CalculatorController {

    @Autowired
    private CalculatorService calculatorService;

    @GetMapping("/bench-press")
    public String benchPress(@RequestBody Dto dto) {
        double result = calculatorService.calculateMaxBenchPress(dto.getReps(), dto.getWeight());
        String response = "Your max repetition for bench press is around: " + result + " KG";
        return response;
    }

    @GetMapping("/squat")
    public String squat(@RequestBody Dto dto) {
        double result = calculatorService.calculateMaxSquat(dto.getReps(), dto.getWeight());
        String response = "Your max repetition for squat is around: " + result + " KG";
        return response;
    }

    @GetMapping("/deadlift")
    public String deadlift(@RequestBody Dto dto) {
        double result = calculatorService.calculateMaxDeadlift(dto.getReps(), dto.getWeight());
        String response = "Your max repetition for deadlift is around: " + result + " KG";
        return response;
    }

}
