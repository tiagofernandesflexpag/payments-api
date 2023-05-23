package br.com.flexpag.payments.model.address;

import br.com.flexpag.payments.model.BaseEntity;
import br.com.flexpag.payments.model.client.Client;
import jakarta.persistence.*;
import lombok.*;

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

}
