package br.com.flexpag.payments.model.transaction;

import br.com.flexpag.payments.controller.dto.request.PersistTransactionData;
import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.purchase.Purchase;
import br.com.flexpag.payments.model.transaction.enums.PaymentTypeEnum;
import br.com.flexpag.payments.model.transaction.enums.StatusEnum;
import jakarta.persistence.*;
import jdk.jfr.StackTrace;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "transaction")
@Entity(name = "Transaction")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Transaction extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;

    @Enumerated(EnumType.STRING)
    private PaymentTypeEnum paymentType;

    @Enumerated(EnumType.STRING)
    private StatusEnum status;
    private Long authorizationCode;
    private Integer instalments;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "purchase_id", referencedColumnName = "id")
    private Purchase purchase;

    public Transaction(PersistTransactionData persistTransictionData, Purchase purchaseObject, StatusEnum randomStatus){
        this.uuid = UUID.randomUUID();
        this.paymentType = persistTransictionData.paymentType();
        this.status = randomStatus;
        this.authorizationCode = persistTransictionData.authorizationCode();
        this.instalments = persistTransictionData.instalments();
        this.purchase = purchaseObject;
        setCreatedAt(LocalDate.now());
        setUpdatedAt(LocalDate.now());
    }

}
