package br.com.flexpag.payments.model.purchase;

import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.client.Client;
import br.com.flexpag.payments.model.invoice.Invoice;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Table(name = "purchases")
@Entity(name = "Purchase")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Purchase extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private Long amount;
    private Long invoiceAmount;
    private Double rate;

    //Fazer e perguntar sobre os relacionamentos;
    private Client client;

    private Invoice invoice;

}
