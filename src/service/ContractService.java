package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entities.Contract;
import entities.Installment;

public class ContractService {
		
	private OnlinePaymentService online;
	
	public ContractService(OnlinePaymentService online) {
		this.online = online;
	}

	public void processContract(Contract contract, Integer months) {
		for(int i =1; i<=months; i++) {
			double value = contract.getTotalValue() / months;
			value = online.interest(value, i);
			Double value1 = online.paymentFee(value);
			LocalDate date = contract.getDate().plusMonths(i);
			contract.getInstallment().add(new Installment(date, value1));
		}
	}
	
}

