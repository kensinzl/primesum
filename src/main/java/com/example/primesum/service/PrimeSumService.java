package com.example.primesum.service;

import com.example.primesum.exception.PrimeSumServiceException;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class PrimeSumService {

    /**
     * Sum the Prime to N
     *
     * @return Sum of Primes
     */
    public Long sumPrimesToN(int n) {

        if(n > 10000000) {
            throw new PrimeSumServiceException("The max number have to be less than 10 millions. ");
        }

        // init all as the prime
        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);

        // set not prime as false
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // use long to avoid too big value of int for overflow
        long sum = 0;
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                sum = sum + i;
                //System.out.println("find prime: " + i);
            }
        }
        return sum;
    }
}
