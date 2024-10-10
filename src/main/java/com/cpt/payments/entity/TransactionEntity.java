package com.cpt.payments.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity {
    private int id;
    private int userId;
    private int paymentMethodId;
    private int providerId;
    private int paymentTypeId;
    private Double amount;
    private String currency;
    private int txnStatusId;
    private String merchantTransactionReference;
    private String txnReference;
    private String providerCode;
    private String providerMessage;
    private String providerReference;
    private int retryCount;
   // private Timestamp creationDate;
   // private Timestamp updatedDate;
}