package br.com.flexpag.payments.model.client;


import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.address.Address;
import br.com.flexpag.payments.model.client.enums.ContractTypeEnum;
import br.com.flexpag.payments.model.client.enums.UserRole;
import br.com.flexpag.payments.model.purchase.Purchase;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "client")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client extends BaseEntity implements Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String name;
    private String identity;

    @Enumerated(EnumType.STRING)
    private ContractTypeEnum contract;
    private Long contractNumber;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(mappedBy = "client")
    private List<Purchase> purchases;

    @Override
    public List<Double> getFees(ContractTypeEnum contractTypeEnum) {
        return null;
    }

}
