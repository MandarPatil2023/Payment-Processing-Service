package com.cpt.payments.constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum PaymentTypeIdEnum {
    SALE(1, "SALE");

    private final int id;
    private final String name;

    PaymentTypeIdEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    public static PaymentTypeIdEnum fromId(int id) {
        for (PaymentTypeIdEnum type : PaymentTypeIdEnum.values()) {
            if (type.getId() == id) {
                return type;
            }
        }
        log.error("No Enum constant with Id "+id);
        throw null;
    }

    public static PaymentTypeIdEnum fromName(String name) {
        for (PaymentTypeIdEnum type : PaymentTypeIdEnum.values()) {
            if (type.getName().equals(name)) {
                return type;
            }
        }
        log.error("No Enum constant with name "+name);
        throw null;
    }
}