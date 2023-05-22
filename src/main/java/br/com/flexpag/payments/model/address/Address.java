package br.com.flexpag.payments.model.address;

import br.com.flexpag.payments.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Address extends BaseEntity {

    private String street;
    private String number;
    private String city;
    private String state;
    private String complement;

}
