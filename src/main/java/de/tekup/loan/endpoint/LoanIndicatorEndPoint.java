package de.tekup.loan.endpoint;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import de.tekup.loan.service.LoanService;
import de.tekup.loan.soap.ws.loaneligebilty.CustomerRequest;
import de.tekup.loan.soap.ws.loaneligebilty.WsResponse;

@Endpoint
public class LoanIndicatorEndPoint {
	
	public static final String targetNamespace="http://www.tekup.de/loan/soap/ws/loanEligebilty";
	@Autowired
	private LoanService service;
	
	@PayloadRoot(namespace = targetNamespace, localPart = "CustomerRequest")
	@ResponsePayload
	public WsResponse getLoanStatus(@RequestPayload CustomerRequest customerRequest) {
		
		return service.checkClientEligebilty(customerRequest);
	}

}
