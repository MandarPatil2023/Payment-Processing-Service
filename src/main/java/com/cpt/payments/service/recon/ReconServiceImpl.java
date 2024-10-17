package com.cpt.payments.service.recon;

//import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cpt.payments.dao.interfaces.TransactionDAO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.service.interfaces.ReconService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ReconServiceImpl implements ReconService {

	private ReconPaymentAsync asyncTaskService;
	private TransactionDAO transactionDAO;
	
	ReconServiceImpl(ReconPaymentAsync asyncTaskService,TransactionDAO transactionDAO)
	{
		this.transactionDAO=transactionDAO;
		this.asyncTaskService=asyncTaskService;
	}
	
	@Override
	//@Scheduled(cron = "0/15 * * * * ?")
	public void reconcilePayments() {
		log.info("Reconciling payments...");
		
		//1. Make DB call to Load  all pending  payments/transaction from DB.
		//2. you would get list of all applicable payments 
	
		//List<TransactionEntity>  reconTxns = transactionDAO.getTransactionsForRecon();
							
		//List<TransactionEntity> recconTxns=transactionDAO.getTransactionsForRecon();
		
		List<TransactionDTO> reconTxns=transactionDAO.getTransactionsForRecon();
		
		
		

		
		
		log.info("Total txns for recon size :"+reconTxns.size());
		
		reconTxns.forEach(txn -> {
			log.info("Processing txn : "+txn.getId());
			asyncTaskService.reconAsync(txn);
		});
		
		
		
		//3. for each payments (iterate through all payments),
		//   process each payments asyncronously ,via different thread
		
		//continue with next process
		
		//   call - processing service should call paypal provider service for getstatus call
		//4. whatever is the status recieved , accordingly take actions.

	}

}
