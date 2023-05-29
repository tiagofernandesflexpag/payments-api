package br.com.flexpag.payments.model.client;


import br.com.flexpag.payments.controller.dto.request.CreateClientData;
import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.address.Address;
import br.com.flexpag.payments.model.client.enums.ContractTypeEnum;
import br.com.flexpag.payments.model.purchase.Purchase;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@Table(name = "client")
@Entity(name = "Client")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client extends BaseEntity implements Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private Long userId;
    private String name;
    private String identity;

    @Enumerated(EnumType.STRING)
    private ContractTypeEnum contract;
    private Long contractNumber;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "client",fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Purchase> purchases;

    @Override
    public List<Double> getFees(ContractTypeEnum contractTypeEnum) {
        return null;
    }

    public Client(CreateClientData clientData) {
        this.uuid = UUID.randomUUID();
        this.userId = clientData.userId();
        this.name = clientData.name();
        this.identity = clientData.identity();
        this.contract = clientData.contract();
        this.contractNumber = clientData.contractNumber();
        this.address = new Address(clientData.address());
        setCreatedAt(LocalDate.now());
        setUpdatedAt(LocalDate.now());
    }

}
