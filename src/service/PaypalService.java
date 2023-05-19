package service;

public class PaypalService implements OnlinePaymentService {
	
	public Double paymentFee(Double amount) {
		Double result = amount * 0.02;
		return amount + result;
	}
	
	public Double interest(Double amount, Integer months) {
		Double result = months * 0.01;
		return result + amount;
	}

	
}