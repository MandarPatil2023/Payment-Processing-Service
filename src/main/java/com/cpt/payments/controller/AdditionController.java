package com.cpt.payments.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cpt.payments.service.interfaces.ReconService;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.RequestBody;


@RestController
@Slf4j
public class AdditionController {
	
	private ReconService reconService;
	
	AdditionController(ReconService reconService)
	{
		this.reconService=reconService;
	}
	
	
	
    @PostMapping("/add")
    public int add(@RequestParam int num1, @RequestParam int num2) {
        System.out.println("num1:" + num1 + "|num2:" + num2);
        
        log.info("num1:" + num1 + "|num2:" + num2);
    	
        int sumResult = num1 + num2;
        System.out.println("sumResult:" + sumResult);
        
        log.info("sumResult:" + sumResult);
        
        log.trace("message");
        log.debug("message");
        log.info("message");
        log.warn("message");
        log.error("message");
        
        

        return sumResult;
    }
    
    
    
    @PostMapping("/testRecon")
    public String postMethodName() {
    
        reconService.reconcilePayments();
    	
        return "Recon Triggered";
    }
    
}
