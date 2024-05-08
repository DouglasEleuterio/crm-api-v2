package br.com.tresptecnologia.support;

import org.jeasy.random.EasyRandom;
import org.jeasy.random.EasyRandomParameters;
import org.jeasy.random.FieldPredicates;

import java.util.Random;

import static org.jeasy.random.FieldPredicates.named;

public class EasyRandomSupport {

    public static final EasyRandom easyRandom;

    static {
        final GeraCpfCnpj gerador = new GeraCpfCnpj();
        final Random random = new Random();
        EasyRandomParameters parameters = new EasyRandomParameters()
                .stringLengthRange(1, 20)
                .randomize(FieldPredicates.named("id"), () -> random.nextLong())
                .randomize(FieldPredicates.named("cnpj"), gerador::cnpj)
                .randomize(FieldPredicates.named("cpf"), gerador::cpf)
                .excludeField(named("id"));
        easyRandom = new EasyRandom(parameters);
    }

}
