package com.korepetycjespring.dependecyinjectionspring;

import org.springframework.stereotype.Repository;

@Repository
public class InvoiceRepository {

    public Invoice findById(int id) {
        return new Invoice(10);
    }

}
