package com.cpt.payments.util;

import org.modelmapper.AbstractConverter;

import com.cpt.payments.constant.TxnStatusIdEnum;

public class TxnStatusIdConverter extends AbstractConverter<Integer, String> {

    @Override
    protected String convert(Integer source) {
        return TxnStatusIdEnum.fromId(source).getName();
    }
}
