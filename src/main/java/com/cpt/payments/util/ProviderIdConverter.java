package com.cpt.payments.util;

import org.modelmapper.AbstractConverter;

import com.cpt.payments.constant.ProviderIdEnum;

public class ProviderIdConverter extends AbstractConverter<Integer, String> {

    @Override
    protected String convert(Integer source) {
        return ProviderIdEnum.fromId(source).getName();
    }
}
