package com.safa.loan.soap.ws.endpoints;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.safa.loan.soap.ws.loaneligebility.CustomerRequest;
import com.safa.loan.soap.ws.loaneligebility.WsResponse;
import com.safa.loan.soap.ws.services.LoanElegibilityService;

@Endpoint
public class LoanEligibilityEndPoint {
	
	public final String NAMESPACE="http://www.safa.com/loan/soap/ws/loanEligebility" ;
    
	@Autowired
	private LoanElegibilityService service ;
	
	 @PayloadRoot(localPart = "CustomerRequest", namespace = NAMESPACE)
	 @ResponsePayload
	public WsResponse getLoanStatus(@RequestPayload CustomerRequest request) {
		return service.checkLoanEligibility(request);
	}

}
