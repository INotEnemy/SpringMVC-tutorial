package ru.sevsu.rest.service;

import org.jooq.DSLContext;
import org.springframework.beans.factory.annotation.Autowired;
import ru.sevsu.db.Sequences;

import java.math.BigInteger;

public abstract class JooqAbstractService {

    @Autowired
    protected DSLContext context;


    protected Long nextLongId() {
       return context.nextval(Sequences.SEQ_GET_ID);
    }

    protected BigInteger nextBigIntId () {
        return BigInteger.valueOf(nextLongId());
    }
}
