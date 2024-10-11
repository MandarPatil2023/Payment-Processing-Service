package com.cpt.payments.constant;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum TxnStatusIdEnum {
		CREATED(1, "CREATED"),
	    INITIATED(2, "INITIATED"),
	    PENDING(3, "PENDING"),
	    APPROVED(4, "APPROVED"),
	    SUCCESS(5, "SUCCESS"),
	    FAILED(6, "FAILED");

	    private final int id;
	    private final String name;

	    TxnStatusIdEnum(int id, String name) {
	        this.id = id;
	        this.name = name;
	    }

	    public int getId() {
	        return id;
	    }

	    public String getName() {
	        return name;
	    }
	    
	    
	    public static TxnStatusIdEnum fromId(int id) {
	        for (TxnStatusIdEnum status : TxnStatusIdEnum.values()) {
	            if (status.getId() == id) {
	                return status;
	            }
	        }
	        log.error("No Enum constant with Id "+id);
	        throw null;
	    }

	    public static TxnStatusIdEnum fromName(String name) {
	        for (TxnStatusIdEnum status : TxnStatusIdEnum.values()) {
	            if (status.getName().equals(name)) {
	                return status;
	            }
	        }
	        log.error("No Enum constant with name "+name);
	        throw null;
	    }

}
