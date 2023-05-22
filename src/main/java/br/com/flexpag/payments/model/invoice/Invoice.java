package br.com.flexpag.payments.model.invoice;

import br.com.flexpag.payments.model.BaseEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "invoices")
@Entity(name = "Invoice")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Invoice extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private LocalDate dueDate;
    private String barcode;
    private Long amount;
    private Boolean paid;
    private Long contractNumber;

}
