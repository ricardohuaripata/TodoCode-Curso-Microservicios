package com.todocodeacademy.max_rep_calculator;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    public double calculateMaxBenchPress(int reps, double weight) {
        double max = ((weight * reps) * 0.03) + weight;
        return max;
    }

    public double calculateMaxSquat(int reps, double weight) {
        double max = weight / (1.0278 - 0.0278 * reps);
        return max;
    }

    public double calculateMaxDeadlift(int reps, double weight) {
        double max = (weight * reps * 0.0333) + weight;
        return max;
    }
}
