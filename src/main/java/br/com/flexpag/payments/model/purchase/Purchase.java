package br.com.flexpag.payments.model.purchase;

import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.client.Client;
import br.com.flexpag.payments.model.invoice.Invoice;
import br.com.flexpag.payments.model.transaction.Transaction;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.List;

@Table(name = "purchase")
@Entity(name = "Purchase")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Purchase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private Long amount;
    private Long invoiceAmount;
    private Double rate;

    @ManyToOne
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "purchase")
    private Transaction transaction;

    @OneToMany
    @JoinTable(
            name = "purchase_invoice",
            joinColumns = {@JoinColumn(name = "purchase_id")},
            inverseJoinColumns = {@JoinColumn(name = "invoice_id")}
    )
    private List<Invoice> invoices;

}
