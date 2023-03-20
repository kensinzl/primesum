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

        // has to be less than Integer.MAX_VALUE to avoid explode the following array max size and also Integer max
        // TODO: if your local memory is enough, test the Integer.MAX_VALUE -1
        if(n < 0 || n == Integer.MAX_VALUE) {
            throw new PrimeSumServiceException("The max number have to be over zero or less than Integer.MAX_VALUE. ");
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
