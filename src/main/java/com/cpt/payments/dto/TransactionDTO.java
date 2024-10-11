package com.cpt.payments.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class TransactionDTO {  // change int to string. txnStatusId in db is 1,2,3...  map to its value - pending ,approved....
    private int id;
    private int userId;
    private String paymentMethodId;
    private String providerId;
    private String paymentTypeId;
    private Double amount;
    private String currency;
    private String txnStatusId;
    private String merchantTransactionReference;
    private String txnReference;
    private String providerCode;
    private String providerMessage;
    private String providerReference;
    private int retryCount;
   // private Timestamp creationDate;
   // private Timestamp updatedDate;
    
    public void setPaymentMethodName(String paymentMethodName) {
        this.paymentMethodId = paymentMethodName;
    }
    
    public void setProviderName(String providerName) {
        this.providerId = providerName;
    }

    public void setPaymentTypeName(String paymentTypeName) {
        this.paymentTypeId = paymentTypeName;
    }

    public void setTxnStatusName(String txnStatusName) {
        this.txnStatusId = txnStatusName;
    }
}