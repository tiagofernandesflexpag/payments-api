package br.com.flexpag.payments.model;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@Component
public abstract class BaseEntity {

    LocalDate createdAt;
    LocalDate updatedAt;
    LocalDate removedAt;

}
