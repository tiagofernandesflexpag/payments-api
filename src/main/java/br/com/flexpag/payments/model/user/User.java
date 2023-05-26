package br.com.flexpag.payments.model.user;

import br.com.flexpag.payments.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "_user")
@Entity(name = "User")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private UUID uuid;

    private String email;

    private String password;

}
