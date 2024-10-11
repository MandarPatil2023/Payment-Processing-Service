package com.cpt.payments;

import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.spi.MappingContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.client.RestTemplate;

import com.cpt.payments.constant.PaymentMethodEnum;
import com.cpt.payments.constant.PaymentTypeIdEnum;
import com.cpt.payments.constant.ProviderIdEnum;
import com.cpt.payments.constant.TxnStatusIdEnum;
import com.cpt.payments.dto.TransactionDTO;
import com.cpt.payments.entity.TransactionEntity;
import com.cpt.payments.util.*;
import com.google.gson.Gson;


@Configuration
public class AppConfig {						// customize threadpool 


    @Bean
    public ThreadPoolTaskExecutor taskExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        
        executor.setCorePoolSize(5);					//number of thread keep in pool , even if they are idle
        executor.setMaxPoolSize(10);					//max number of thread allowed in pool
        executor.setQueueCapacity(25);					//queue capacity
        executor.setThreadNamePrefix("MyExecutor-");    //prefix name   ex-  MyExecutor-task-1
        executor.initialize();
        return executor;
    }
    
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
    
    @Bean
    Gson gson() {
    	return new Gson();
    }
    
    @Bean
    ModelMapper modelMapper()
    {
    	ModelMapper modelMapper = new ModelMapper();
    	
    	//util package converter - Intger to String
        // Add mappings for Entity -> DTO conversions
        modelMapper.typeMap(TransactionEntity.class, TransactionDTO.class)
                .addMappings(mapper -> {
                	
                	mapper.using(new PaymentMethodIdConverter())	
                		  .map(TransactionEntity::getPaymentMethodId, TransactionDTO::setPaymentMethodName);
                
                	mapper.using(new ProviderIdConverter())		
                          .map(TransactionEntity::getProviderId, TransactionDTO::setProviderName);
                   
                	mapper.using(new PaymentTypeIdConverter())	
                          .map(TransactionEntity::getPaymentTypeId, TransactionDTO::setPaymentTypeName);
                    
                	mapper.using(new TxnStatusIdConverter())		
                          .map(TransactionEntity::getTxnStatusId, TransactionDTO::setTxnStatusName);
                });
        
        

        return modelMapper;
    	
    }
}
