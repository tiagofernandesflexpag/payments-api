package br.com.flexpag.payments.model.purchase;

import br.com.flexpag.payments.controller.dto.request.PurchaseData;
import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.client.Client;
import br.com.flexpag.payments.model.invoice.Invoice;
import br.com.flexpag.payments.model.transaction.Transaction;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.Fetch;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;
import java.util.List;

@Table(name = "purchase")
@Entity(name = "Purchase")
@Getter
@Setter
@ToString
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

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "client_id")
    private Client client;

    @OneToOne(mappedBy = "purchase")
    private Transaction transaction;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "purchase_invoice",
            joinColumns = {@JoinColumn(name = "purchase_id")},
            inverseJoinColumns = {@JoinColumn(name = "invoice_id")}
    )
    private List<Invoice> invoices;

    public Purchase(PurchaseData purchaseData, Client client, List<Invoice> invoices){
        this.uuid = UUID.randomUUID();
        this.amount = purchaseData.amount();
        this.invoiceAmount = purchaseData.invoiceAmount();
        this.rate = purchaseData.rate();
        this.client = client;
        this.invoices = invoices;
        setCreatedAt(LocalDate.now());
        setUpdatedAt(LocalDate.now());
    }
}
