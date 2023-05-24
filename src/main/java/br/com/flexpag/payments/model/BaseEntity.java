package br.com.flexpag.payments.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Data
@MappedSuperclass
public abstract class BaseEntity {

    //pre persistencia, pre update - dar uma olhada
    LocalDate createdAt;
    LocalDate updatedAt;
    LocalDate removedAt;

}
