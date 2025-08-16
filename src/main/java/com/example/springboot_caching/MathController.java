package com.example.springboot_caching;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MathController {

    private final MathService mathService;

    public MathController(MathService mathService) {
        this.mathService = mathService;
    }

    @GetMapping("/square/{number}")
    public String getSquare(@PathVariable Integer number) {
        long startTime = System.currentTimeMillis();
        double result = mathService.square(number);
        long duration = System.currentTimeMillis() - startTime;

        return String.format("Square of %d is %.2f (took %d ms)",
                number, result, duration);
    }

    @GetMapping("/square/clearcache")
    public String clearCache() {
        mathService.clearCache();
        return "Cache cleared";
    }
}