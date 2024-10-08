package com.cpt.payments.service.recon;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ReconPaymentAsync {
	
	@Async
	public void reconAsync(String txnId)
	{
		
		log.info("ReconPaymentAsync.reconAsync()"+txnId);
	}

}
