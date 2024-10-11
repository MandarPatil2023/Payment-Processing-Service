package com.cpt.payments.util;

import org.modelmapper.AbstractConverter;

import com.cpt.payments.constant.PaymentTypeIdEnum;

public class PaymentTypeIdConverter extends AbstractConverter<Integer, String> {

    @Override
    protected String convert(Integer source) {
        return PaymentTypeIdEnum.fromId(source).getName();
    }
}
