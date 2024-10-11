package com.cpt.payments.service.recon;

import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.ProviderIdEnum;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.impl.PaypalProviderHandler;
import com.cpt.payments.service.interfaces.ProviderHandler;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class ReconPaymentAsync {//in future we can use applcontext to lookup for bean (paypal ,strype...)
	
	private ApplicationContext  context;

	ReconPaymentAsync(ApplicationContext  context)
	{
		this.context=context;
	}
	
	@Async
	public void reconAsync(TransactionDTO txn)
	{
		log.info("ReconPaymentAsync.reconAsync()"+txn);

		ProviderHandler providerHandler = null;
		
		if(txn.getProviderId().equals( ProviderIdEnum.PAYPAL.getName()))
		{
			providerHandler=context.getBean(PaypalProviderHandler.class);
		}
		
		if(providerHandler==null)
		{
			log.info("providerHandler is null . txn "+txn);
			return;
		}
		
		log.info("ProviderHandler "+providerHandler);
		providerHandler.reconcileTransaction(txn);
	}

}
