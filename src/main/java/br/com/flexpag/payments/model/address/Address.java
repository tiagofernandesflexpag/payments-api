package br.com.flexpag.payments.model.address;

import br.com.flexpag.payments.model.dto.request.AddressData;
import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.client.Client;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.UUID;

@Table(name = "address")
@Entity(name = "Address")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID uuid;
    private String street;
    private String number;
    private String city;
    private String state;
    private String complement;

    @OneToOne(mappedBy = "address")
    private Client client;

    public Address(AddressData addressData) {
        this.uuid = UUID.randomUUID();
        this.street = addressData.street();
        this.number = addressData.number();
        this.city = addressData.city();
        this.state = addressData.state();
        this.complement = addressData.complement();
        setCreatedAt(LocalDate.now());
        setUpdatedAt(LocalDate.now());
    }

}
