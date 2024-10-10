package com.cpt.payments.service.recon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.cpt.payments.service.interfaces.ReconService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReconServiceImpl implements ReconService {

	private ReconPaymentAsync asyncTaskService;
	
	ReconServiceImpl(ReconPaymentAsync asyncTaskService)
	{
		this.asyncTaskService=asyncTaskService;
	}
	
	@Override
	//@Scheduled(cron = "0/5 * * * * ?")
	public void reconcilePayments() {
		log.info("Reconciling payments...");
		
		//1. Make DB call to Load  all pending  payments/transaction from DB.
		//2. you would get list of all applicable payments 
		
		List<String> items = Arrays.asList("item1","item2","item3","item4");
		//3. for each payments (iterate through all payments),
		//   process each payments asyncronously ,via different thread
		
		for(String item : items)
		{
			asyncTaskService.reconAsync(item);
		}
		//continue with next process
		
		//   call - processing service should call paypal provider service for getstatus call
		//4. whatever is the status recieved , accordingly take actions.

	}

}
