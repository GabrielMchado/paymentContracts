package service;

public class PaypalService implements OnlinePaymentService {
	
	public Double paymentFee(Double amount) {
		Double result = amount * 0.02;
		return result + amount;
	}
	
	public Double interest(Double amount, Integer months) {
		Double result = (amount * 0.01) * months;
		return result + amount;
	}

	
}
