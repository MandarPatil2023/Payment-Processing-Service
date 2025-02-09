package com.cpt.payments.dao.interfaces;


import java.util.List;

import com.cpt.payments.dto.TransactionDTO;

public interface TransactionDAO {

	public List<TransactionDTO> getTransactionsForRecon();

	boolean updateTransactionReconDetails(TransactionDTO transactionDTO);
}
