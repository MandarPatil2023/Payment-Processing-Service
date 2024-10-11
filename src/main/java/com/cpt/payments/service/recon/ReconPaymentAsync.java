package com.cpt.payments.service.recon;

import java.applet.AppletContext;

import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import com.cpt.payments.constant.ProviderIdEnum;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.impl.PayapProviderHandler;
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
		
		if(txn.getProviderId() == ProviderIdEnum.PAYPAL.getName())
		{
			providerHandler=context.getBean(PayapProviderHandler.class);
		}
		
		log.info("ProviderHandler "+providerHandler);
		providerHandler.reconcileTransaction(txn);
	}

}
