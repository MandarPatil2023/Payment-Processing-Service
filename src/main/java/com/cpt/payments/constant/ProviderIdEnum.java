package com.cpt.payments.constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum ProviderIdEnum {
    PAYPAL(1, "PAYPAL");

    private final int id;
    private final String name;

    ProviderIdEnum(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
 
    }
    
    public static ProviderIdEnum fromId(int id) {
        for (ProviderIdEnum providerId : ProviderIdEnum.values()) {
            if (providerId.getId() == id) {
                return providerId;
            }
        }
        log.error("No Enum constant with Id "+id);
        throw null;
    }

    public static ProviderIdEnum fromName(String name) {
        for (ProviderIdEnum providerId : ProviderIdEnum.values()) { 
            if (providerId.getName().equals(name)) {
                return providerId;
            }
        }
        log.error("No Enum constant with name "+name);
        throw null;
    }
    
    
    
}