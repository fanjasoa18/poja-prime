package com.poja.prime.endpoint.rest.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PrimeController {

    private static final int MAX_PRIMES_TO_STORE = 10;
    private List<BigInteger> generatedPrimes = new ArrayList<>();

    @GetMapping("/new-prime")
    public ResponseEntity<BigInteger> generateAndStoreNewPrime() {
        BigInteger newPrime = generateProbablePrime(10_000);
        addGeneratedPrime(newPrime);
        return ResponseEntity.ok(newPrime);
    }

    private BigInteger generateProbablePrime(int bitLength) {
        // Générer un nombre premier probable à la longueur spécifiée
        return BigInteger.probablePrime(bitLength, new java.util.Random());
    }

    private void addGeneratedPrime(BigInteger newPrime) {
        generatedPrimes.add(newPrime);
        if (generatedPrimes.size() > MAX_PRIMES_TO_STORE) {
            generatedPrimes.remove(0);
        }
    }
}
