package br.com.flexpag.payments.model.transaction;

import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.purchase.Purchase;
import br.com.flexpag.payments.model.transaction.enums.PaymentTypeEnum;
import br.com.flexpag.payments.model.transaction.enums.StatusEnum;
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
    //Perguntar sobre os relacionamentos
    private Purchase purchase;

}
