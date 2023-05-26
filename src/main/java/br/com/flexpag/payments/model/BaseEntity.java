package br.com.flexpag.payments.model;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@MappedSuperclass
public abstract class BaseEntity {

    //pre persistencia, pre update - dar uma olhada
    LocalDate createdAt;
    LocalDate updatedAt;
    LocalDate removedAt;

}
