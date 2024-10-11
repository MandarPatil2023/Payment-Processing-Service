package com.cpt.payments.service.impl;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.cpt.payments.dto.Order;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.http.HttpClientUtil;
import com.cpt.payments.http.HttpRequest;
import com.cpt.payments.service.helper.ProcessingGetOrderRequestHelper;
import com.cpt.payments.service.interfaces.ProviderHandler;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PaypalProviderHandler implements ProviderHandler {
	
	private Gson gson;
	private ProcessingGetOrderRequestHelper processingGetOrderRequestHelper;
	private HttpClientUtil httpClientUtil;
	
	PaypalProviderHandler(Gson gson ,ProcessingGetOrderRequestHelper processingGetOrderRequestHelper,HttpClientUtil httpClientUtil)
	{
		this.gson=gson;
		this.processingGetOrderRequestHelper=processingGetOrderRequestHelper;
		this.httpClientUtil=httpClientUtil;
	}
	

	@Override
	public void reconcileTransaction(TransactionDTO transactionDTO){
		log.info("reconcileTransaction() called transactionDTO "+transactionDTO);
		
		System.out.println(transactionDTO.getProviderReference()); //ID

		HttpRequest httpRequest= processingGetOrderRequestHelper.getOrder(transactionDTO.getProviderReference());
		
		ResponseEntity<String> getOrderResponse = httpClientUtil.makeHttpRequest(httpRequest);
		String responseBody=getOrderResponse.getBody();
		
		Order resAsObj = gson.fromJson(responseBody, Order.class);
		
		log.info("resAsObj : "+resAsObj);

	}

}
