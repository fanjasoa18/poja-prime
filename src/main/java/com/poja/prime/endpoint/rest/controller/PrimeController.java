package com.poja.prime.endpoint.rest.controller;

import java.math.BigInteger;
import java.util.Random;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PrimeController {
    @GetMapping(value = "/new-prime")
    public BigInteger newPrime() {
        return BigInteger.probablePrime(1000, new Random());
    }
}
