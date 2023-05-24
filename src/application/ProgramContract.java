package application;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.Scanner;

import entities.Contract;
import entities.Installment;
import service.ContractService;
import service.PaypalService;

public class ProgramContract {
	
	public static void main(String[] args) throws ParseException, InputMismatchException {
		
		Locale.setDefault(Locale.US);
		DateTimeFormatter sdf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		Scanner sc = new Scanner(System.in);
		ContractService service = new ContractService(new PaypalService());
		Contract contract;
		
		System.out.println("Among the details of the contract: ");
		System.out.print("Number: ");
		int number = sc.nextInt();
		
		System.out.print("Date (dd/MM/yyyy): ");
		LocalDate date = LocalDate.parse(sc.next(), sdf);
		
		System.out.print("Contract value: ");
		Double value = sc.nextDouble();
		
		System.out.print("Enter the number of installments: ");
		int install = sc.nextInt();
		
		service.processContract(contract = new Contract(number, date, value), install);
		
		System.out.println("installments: ");

		for(Installment i: contract.getInstallment()) {
			System.out.println(i);
		}
		
	}

}
