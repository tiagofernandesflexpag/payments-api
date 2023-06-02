package br.com.flexpag.payments.model.report;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Table(name = "report")
@Entity(name = "Report")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;
    private UUID uuid;
    private String name;
    private String link;

}
