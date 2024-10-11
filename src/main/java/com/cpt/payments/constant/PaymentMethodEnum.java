package com.cpt.payments.constant;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public enum PaymentMethodEnum {
	
		APM(1, "APM");

	    private final int id ;
	    private final String name;

	    PaymentMethodEnum(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }

	    
	    
	    public static PaymentMethodEnum fromId(int id) {
	        for (PaymentMethodEnum provider : PaymentMethodEnum.values()) {
	            if (provider.getId() == id) {
	                return provider;
	            }
	        }
	        log.error("No Enum constant with Id "+id);
	        throw null;
	    }

	    public static PaymentMethodEnum fromName(String name) {
	        for (PaymentMethodEnum provider : PaymentMethodEnum.values()) {
	            if (provider.getName().equals(name)) {
	                return provider;
	            }
	        }
	        log.error("No Enum constant with name "+name);
	        throw null;
	    }
}
