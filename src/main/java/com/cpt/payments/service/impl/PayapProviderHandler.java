package com.cpt.payments.service.impl;

import org.springframework.stereotype.Service;

import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.interfaces.ProviderHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PayapProviderHandler implements ProviderHandler {

	@Override
	public void reconcileTransaction(TransactionDTO transactionDTO) {
		log.info("reconcileTransaction() called transactionDTO "+transactionDTO);

		
		
		// TODO get order call
	}

}
