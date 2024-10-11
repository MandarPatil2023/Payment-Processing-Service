package com.cpt.payments.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import com.cpt.payments.dao.interfaces.TransactionDAO;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;

@Repository
public class TransactionDAOImpl implements TransactionDAO {  // fetch data from DB where status = "pending" & retry count < 3

	private ModelMapper modelMapper;
	private NamedParameterJdbcTemplate namedParameterJDBCTemplate;
	
	TransactionDAOImpl(ModelMapper modelMapper,NamedParameterJdbcTemplate namedParameterJDBCTemplate)
	{
		this.modelMapper=modelMapper;
		this.namedParameterJDBCTemplate=namedParameterJDBCTemplate;
	}
	
	
	@Override
	public List<TransactionDTO> getTransactionsForRecon() {
		
		String sql="select * from Transaction where txnStatusId = :txnStatusId and retryCount < :retryCount";
		
		Map<String,Object> params= new HashMap<>();
		params.put("txnStatusId", 3);
		params.put("retryCount", 3);
																					
		List<TransactionEntity> reconTxnEntities = namedParameterJDBCTemplate.query(
					sql,
					params, 
					new BeanPropertyRowMapper<>(TransactionEntity.class)
				);
		
		List<TransactionDTO> reconTxnDTO=convertToDTOList(reconTxnEntities);
		
		return reconTxnDTO;
	}
	//multiple object will be converted from enity to dto , each row of table = one object
	
	// Method to convert List<TransactionEntity> to List<TransactionDTO>          
    private List<TransactionDTO> convertToDTOList(List<TransactionEntity> reconTxnEntities) {
        return reconTxnEntities.stream()
                .map(entity -> modelMapper.map(entity, TransactionDTO.class))
                .collect(Collectors.toList());
	
    }
}
