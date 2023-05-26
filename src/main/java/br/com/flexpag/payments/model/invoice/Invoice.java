package br.com.flexpag.payments.model.invoice;

import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.controller.dto.request.InvoiceData;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "invoice")
@Entity(name = "Invoice")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Invoice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private LocalDate dueDate;
    private String barcode;
    private Long amount;
    private Boolean paid;
    private Long contractNumber;

    public Invoice(InvoiceData invoiceData) {
        this.uuid = UUID.randomUUID();
        this.dueDate = invoiceData.dueDate();
        this.amount = invoiceData.amount();
        this.barcode = invoiceData.barcode();
        this.paid = false;
        this.contractNumber = invoiceData.contractNumber();
        setCreatedAt(LocalDate.now());
        setUpdatedAt(LocalDate.now());
    }
}
