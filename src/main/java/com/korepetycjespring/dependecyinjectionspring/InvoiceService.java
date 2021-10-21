package com.korepetycjespring.dependecyinjectionspring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final MessageService messageService;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          @Qualifier("emailService") MessageService messageService) {
        this.invoiceRepository = invoiceRepository;
        this.messageService = messageService;
    }

    public double calculateTotalPrice(int invoiceId) {
        final Invoice invoice = this.invoiceRepository.findById(invoiceId);
        double totalPrice = invoice.getTotalPrice();
        messageService.sendMessage("atest@wp.pl", "Obliczono koszt twojej faktury. Cena: " + totalPrice);
        return totalPrice;
    }
}