package service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import entities.Contract;
import entities.Installment;

public class ContractService {
	
	private OnlinePaymentService online;
	private List<Installment> list = new ArrayList<Installment>();
	
	public ContractService(OnlinePaymentService online) {
		this.online = online;
	}

	public List<Installment> getList() {
		return list;
	}

	public void processContract(Contract contract, Integer months) {
		for(int i =1; i<=months; i++) {
			double value = contract.getTotalValue() / months;
			value = online.interest(value, i);
			Double value1 = online.paymentFee(value);
			LocalDate date = contract.getDate().plusMonths(i);
			Installment install = new Installment(date, value1);
			list.add(install);
		}
	}
	
}

