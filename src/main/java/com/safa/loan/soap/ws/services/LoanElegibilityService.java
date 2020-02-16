package com.safa.loan.soap.ws.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.safa.loan.soap.ws.loaneligebility.CustomerRequest;
import com.safa.loan.soap.ws.loaneligebility.WsResponse;

@Service
public class LoanElegibilityService {

	public WsResponse checkLoanEligibility(CustomerRequest request) {

		WsResponse response = new WsResponse();
		List<String> criteriaMismatch = response.getCriteriaMismatch();

		if (!(request.getAge() >= 30 && request.getAge() <= 50)) {
			criteriaMismatch.add("Client age must be between 30 and 50");
		}

		if (!(request.getYearlyIncome() > 20000)) {
			criteriaMismatch.add("Client minimun income must be over 20000");
		}

		if (!(request.getCibilScore() > 500)) {
			criteriaMismatch.add("Client cible socre must be over 500");
		}

		if (criteriaMismatch.size() > 0) {
			response.setApprovedAmount(0);
			response.setIsEligeble(false);
		} else {
			response.setApprovedAmount(15000);
			response.setIsEligeble(true);

		}

		return response;
	}

}
