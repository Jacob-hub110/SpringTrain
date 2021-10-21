package com.korepetycjespring.dependecyinjectionspring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class InvoiceServiceTest {

    @Autowired
    private InvoiceService invoiceService;

    @Test
    public void calculateTotalPriceTest() {
        //given
        int invoiceId = 3;
        //when
        double result = invoiceService.calculateTotalPrice(invoiceId);
        //then
        assertThat(result).isEqualTo(10);
    }

}