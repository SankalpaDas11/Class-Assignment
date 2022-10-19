package Exception;
import java.lang.*;
class InvailException extends Exception { 									// sub class of exception
	public InvailException(String str) {
		super(str);}}
class TaxCalculator{ 												// class with calculateTax method
	String empName; boolean isIndian; double empSal; double taxAmount; 					//declaring variables
	public double calculateTax(String empName, double empSal, boolean isIndian) throws InvailException{
		this.empName = empName; this.isIndian = isIndian; this.empSal=empSal;
		if(isIndian==false) { 										// checking if employee is an indian
			throw new InvailException("CountryNotValidException");
		}
		else if(empName==null) { 									// checking if employee name is empty
			throw new InvailException("EmployeeNameInvalidException");
		}
		else if(empSal>=10000){ 									//logic-calculating tax
			if(empSal>=100000 && isIndian==true)
				taxAmount=empSal*8/100;
			else if(empSal<100000 && empSal>=50000 && isIndian==true)
				taxAmount=empSal*6/100;
			else if(empSal<50000 && empSal>=30000 && isIndian==true)
				taxAmount=empSal*5/100;
			else if(empSal<30000 && empSal>=10000 && isIndian==true)
				taxAmount=empSal*4/100;
			return taxAmount;}
		else (){ 											// checking if employee salary is too low to pay tax
			throw new InvailException("TaxNotEligibleException");}
	}
	}
public class CalculatorSimulator { 										// class with main method

	public static void main(String[] args) throws InvailException{
		// TODO Auto-generated method stub
		TaxCalculator tax = new TaxCalculator(); 							// creating object of the previous class TaxCalculator
		//calling method with different inputs
		{try{System.out.print("The amount is : " + tax.calculateTax("Ron",34000,false));}
		catch(InvailException u) {
			System.out.println("The employee should be an Indian");
			System.out.println(u.getMessage());}}
		{try{System.out.print("The amount is : " + tax.calculateTax("Tim",1000,true));}
		catch(InvailException u) {
			System.out.println("The employee does not need to pay tax");
			System.out.println(u.getMessage());}}
		System.out.println("The amount is : " + tax.calculateTax("Jack",55000,true));
		{try{System.out.print("The amount is : " + tax.calculateTax(null,30000,true));}
		catch(InvailException u) {
			System.out.println("The employee name cannot be empty");
			System.out.println(u.getMessage());}}
	}
}
