package com.cpt.payments.service.helper;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;

import com.cpt.payments.http.HttpRequest;

@Service
public class PaypalProviderGetOrderRequestHelper {
		
		
		@Value("${paypal-provider.showOrder.url}") //done
		private String showOrderUrl;

		public HttpRequest getOrder(String orderId)
		{

			HttpRequest httpRequest = new HttpRequest();

			String url=String.format(showOrderUrl,orderId);
			httpRequest.setUrl(url);
			
			httpRequest.setMethod(HttpMethod.GET);

			HttpHeaders headers = new HttpHeaders();               // runned withhout this?
			headers.setContentType(MediaType.APPLICATION_JSON);
			
			
			httpRequest.setHttpHeaders(headers);
			httpRequest.setRequest(null);
			
			return httpRequest;
		}

	}