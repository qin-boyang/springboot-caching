package com.example.springboot_caching;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class MathService {

    @Cacheable(value = "squareCache", key = "#number")
    public double square(Integer number) {
        System.out.println("Calculating square of " + number);
        simulateHeavyCalculation();
        return number * number;
    }

    private void simulateHeavyCalculation() {
        try {
            Thread.sleep(2000); // Simulate 2-second calculation
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    @CacheEvict(value = "squareCache", allEntries = true)
    public void clearCache() {
        System.out.println("Clearing all product cache");
    }
}
