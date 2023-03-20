package com.example.primesum.service;


import com.example.primesum.exception.PrimeSumServiceException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class PrimeSumServiceTest {

    @Autowired
    private PrimeSumService primeSumService;

    @ParameterizedTest
    @ValueSource(ints = {-1000,Integer.MIN_VALUE, Integer.MAX_VALUE})
    void test_overTenMilltion_exception(int max) {
        Exception exception = assertThrows(PrimeSumServiceException.class, () -> primeSumService.sumPrimesToN(max));
        assertEquals("The max number have to be over zero or less than Integer.MAX_VALUE. ", exception.getMessage());
    }

    @ParameterizedTest
    @ValueSource(ints = {0,1})
    void test_sumPrimesToN_SpecialCase_ZeroAndOne(int max) {
        Long sum = primeSumService.sumPrimesToN(max);
        assertEquals(0, sum);
    }

    @Test
    void test_sumPrimesToN_SpecialCase_OddNum() {
        Long sum = primeSumService.sumPrimesToN(9);
        assertEquals(17, sum);
    }

    @Test
    void test_sumPrimesToN_SpecialCase_EvenNum() {
        Long sum = primeSumService.sumPrimesToN(20);
        assertEquals(77, sum);
    }

    @Test
    void test_sumPrimesToN_SpecialCase_TenMillions() {
        Long sum = primeSumService.sumPrimesToN(10000000);
        assertEquals(3203324994356l,  sum);
    }

}
