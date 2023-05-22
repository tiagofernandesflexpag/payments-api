package br.com.flexpag.payments.model.client;


import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.address.Address;
import br.com.flexpag.payments.model.client.enums.ContractTypeEnum;
import br.com.flexpag.payments.model.client.enums.UserRole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Table(name = "clients")
@Entity(name = "Client")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Client extends BaseEntity implements Assignment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private UUID uuid;
    private String name;
    private String identity;
    private ContractTypeEnum contract;
    private Long contractNumber;
    private String email;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    @Embedded
    private Address address;

    @Override
    public List<Double> getFees(ContractTypeEnum contractTypeEnum) {
        return null;
    }

}
