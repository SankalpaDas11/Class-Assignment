package Exception;
import java.lang.*;
class CountryNotValidException extends Exception { 										// 1st sub class of exception
	public CountryNotValidException(String str) {
		super(str);}}
class EmployeeNameInvalidException extends Exception { 										// 2nd sub class of exception
	public EmployeeNameInvalidException(String str) {
		super(str);}}
class TaxNotEligibleException extends Exception { 										// 3rd sub class of exception
	public TaxNotEligibleException(String str) {
		super(str);}}
class TaxCalculator{ 														// class with calculateTax method
	public double calculateTax(String empName, double empSal, boolean isIndian) 
			throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException{
		double taxAmount = 0;
		if(isIndian==false) { 												// checking if employee is an indian
			throw new CountryNotValidException("The employee should be an Indian citizen for calculating tax");
		}
		else if(empName==null) { 											// checking if employee name is empty
			throw new EmployeeNameInvalidException("The employee name cannot be empty");
		}
		else if (empSal>=10000){ //calculating tax
			if(empSal>=100000 && isIndian==true)
				taxAmount=empSal*8/100;
			else if(empSal<100000 && empSal>=50000 && isIndian==true)
				taxAmount=empSal*6/100;
			else if(empSal<50000 && empSal>=30000 && isIndian==true)
				taxAmount=empSal*5/100;
			else if(empSal<30000 && empSal>=10000 && isIndian==true)
				taxAmount=empSal*4/100;
			return taxAmount;}
		else { 														// checking if employee salary is too low to pay tax
			throw new TaxNotEligibleException("The employee does not need to pay tax");}
	}
	}
public class CalculatorSimulator { 												// class with main method

	public static void main(String[] args) throws CountryNotValidException, EmployeeNameInvalidException, TaxNotEligibleException{
		// TODO Auto-generated method stub
		TaxCalculator tax = new TaxCalculator(); 									// creating object of the previous class TaxCalculator
		//calling method with different inputs
		{try{System.out.print("The amount is : " + tax.calculateTax("Ron",34000,false));}
		catch(CountryNotValidException u) {
			System.out.println(u.getMessage());}}
		{try{System.out.print("The amount is : " + tax.calculateTax("Tim",1000,true));}
		catch(TaxNotEligibleException u) {
			System.out.println(u.getMessage());}}
		System.out.println("The amount is : " + tax.calculateTax("Jack",55000,true));
		{try{System.out.print("The amount is : " + tax.calculateTax(null,30000,true));}
		catch(EmployeeNameInvalidException u) {
			System.out.println(u.getMessage());}}
	}
}
