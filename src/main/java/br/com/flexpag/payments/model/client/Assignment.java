package br.com.flexpag.payments.model.client;

import br.com.flexpag.payments.model.client.enums.ContractTypeEnum;

import java.util.List;

public interface Assignment {

    List<Double> getFees(ContractTypeEnum contractTypeEnum);

}
