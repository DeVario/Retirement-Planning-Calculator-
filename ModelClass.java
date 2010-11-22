package cs368_projecttwo;


import java.util.Calendar;
import java.util.Observable;
import java.text.DecimalFormat;


/***************************************************************************
 * ModelClass.java
 *
 * This program is used to finance and plan an individual's retirement.
 * This is class performs all the calculations and stores all the data
 * entered into the applet.
 * 
 * @authors DeVario Voltz, Dan Mikita, Callie O'Brien
 * 
 * @category Computer Science 368
 * @version 2.3
 ***************************************************************************/
public class ModelClass extends Observable{

	//a basic array to store the data type and created for each field
	public String [] dataStorage = new String [19];

	/***************************************************************************
	 * Empties out the dataStorage array list.
	 ***************************************************************************/
	public void reset(){

		//loops through the dataStorage while setting the array value to empty
		for(int i = 0; i < dataStorage.length; i++){
			dataStorage [i] = "";
		}

		setChanged();
		notifyObservers();
	}

	/***************************************************************************
	 * Returns a value from the array.
	 * @return dataStorage[row]
	 ***************************************************************************/
	public String getRawData(int row){

		return dataStorage[row];

	}

	/***************************************************************************
	 * Returns a value from the array.
	 * @return dataStorage[row]
	 ***************************************************************************/
	public String getValue(int row){

		return dataStorage[row];		
	}

	/***************************************************************************
	 * Sets a value in the array to the new string of data.
	 * @param newdata, row
	 ***************************************************************************/
	public void setValue(String newData,int row){

		dataStorage[row] = newData;
		setChanged();
		notifyObservers();

	}

	/***************************************************************************
	 * Prints the data stored in the dataStorage array.
	 * This is for testing purposes only.
	 ***************************************************************************/
	public void printData(){

		//loops through the dataStorage array while printing
		for(int i = 0; i < dataStorage.length; i++){
			System.out.println(dataStorage[i]);
		}
	}

	/***************************************************************************
	 * Performs all the calculations and sets data in the array
	 ***************************************************************************/
	public void calculate(){

		DecimalFormat df = new DecimalFormat("0.00");


		// TODO add your handling code here:
		String name;
		double currentAge =0;
		double annualIncome;
		double socialSecurityIncome;
		double percentOfIncomeWanted = 0;
		double otherIncomeAfterRetirement = 0;

		int yearBorn;
		int month;
		int day;

		name = getValue(0);

		yearBorn = Integer.parseInt(getValue(12));

		currentAge = 2010 - yearBorn;


		annualIncome = Double.parseDouble(getValue(2));

		double annualRetirementNeeded;
		annualRetirementNeeded = 0;


		percentOfIncomeWanted = Double.parseDouble(getValue(3));

		//Social Security — If you make under $25,000, enter $8,000; between $25,000 - $40,000, enter $12,000; over
		//$40,000, enter $14,500
		socialSecurityIncome = 0;

		if(annualIncome < 25000)
			socialSecurityIncome = 8000;
		else if(annualIncome >= 25000 && annualIncome <= 40000)
			socialSecurityIncome = 12000;
		else if(annualIncome > 40000)
			socialSecurityIncome = 14500;


		setValue(df.format(socialSecurityIncome), 4);

		otherIncomeAfterRetirement = Double.parseDouble(getValue(5));

		double partTimeIncome;
		partTimeIncome = Double.parseDouble(getValue(15));
		double employerPension;
		employerPension = Double.parseDouble(getValue(16));
		double annualRetirementWanted;


		if(getValue(18).equals("calculatePercentage")){
			percentOfIncomeWanted = Double.parseDouble(getValue(3));
			annualRetirementNeeded = (annualIncome * (percentOfIncomeWanted /100)) - socialSecurityIncome 
			- otherIncomeAfterRetirement - partTimeIncome - employerPension ;
		}
		else if(getValue(18).equals("doNotCalculatePercentage")){
			annualRetirementWanted = Double.parseDouble(getValue(14));
			annualRetirementNeeded = (annualRetirementWanted) - socialSecurityIncome 
			- otherIncomeAfterRetirement - partTimeIncome - employerPension ;
		}


		setValue(df.format(annualRetirementNeeded),6);


		String retirementAge = "";
		String lifeExpectancy = "";
		String gender = "";
		double factor = 0;

		retirementAge = getValue(7);

		lifeExpectancy = getValue(8);

		gender = getValue(13);

		if(retirementAge.equals("55-59") && lifeExpectancy.equals("Below Average") && gender.equals("Male"))
			factor = 18.79;
		else if(retirementAge.equals("55-59") && lifeExpectancy.equals("Below Average") && gender.equals("Female"))
			factor = 20.53;
		else if(retirementAge.equals("55-59") && lifeExpectancy.equals("Average")&& gender.equals("Male"))
			factor = 21.71;
		else if(retirementAge.equals("55-59") && lifeExpectancy.equals("Average")&& gender.equals("Female"))
			factor = 22.79;
		else if(retirementAge.equals("55-59") && lifeExpectancy.equals("Above Average")&& gender.equals("Male"))
			factor = 23.46;
		else if(retirementAge.equals("55-59") && lifeExpectancy.equals("Above Average")&& gender.equals("Female"))
			factor = 24.40;
		else if(retirementAge.equals("60-64") && lifeExpectancy.equals("Below Average")&& gender.equals("Male"))
			factor = 16.31;
		else if(retirementAge.equals("60-64") && lifeExpectancy.equals("Below Average")&& gender.equals("Female"))
			factor = 18.32;
		else if(retirementAge.equals("60-64") && lifeExpectancy.equals("Average")&& gender.equals("Male"))
			factor = 19.68;
		else if(retirementAge.equals("60-64") && lifeExpectancy.equals("Average")&& gender.equals("Female"))
			factor = 20.93;
		else if(retirementAge.equals("60-64") && lifeExpectancy.equals("Above Average")&& gender.equals("Male"))
			factor = 21.71;
		else if(retirementAge.equals("60-64") && lifeExpectancy.equals("Above Average")&& gender.equals("Female"))
			factor = 22.79;
		else if(retirementAge.equals("65-69") && lifeExpectancy.equals("Below Average")&& gender.equals("Male"))
			factor = 13.45;
		else if(retirementAge.equals("65-69") && lifeExpectancy.equals("Below Average")&& gender.equals("Female"))
			factor = 15.77;
		else if(retirementAge.equals("65-69") && lifeExpectancy.equals("Average")&& gender.equals("Male"))
			factor = 17.35;
		else if(retirementAge.equals("65-69") && lifeExpectancy.equals("Average")&& gender.equals("Female"))
			factor = 18.79;
		else if(retirementAge.equals("65-69") && lifeExpectancy.equals("Above Average")&& gender.equals("Male"))
			factor = 19.68;
		else if(retirementAge.equals("65-69") && lifeExpectancy.equals("Above Average")&& gender.equals("Female"))
			factor = 20.93;
		else if(retirementAge.equals("70+") && lifeExpectancy.equals("Below Average")&& gender.equals("Male"))
			factor = 10.15;
		else if(retirementAge.equals("70+") && lifeExpectancy.equals("Below Average")&& gender.equals("Female"))
			factor = 12.83;
		else if(retirementAge.equals("70+") && lifeExpectancy.equals("Average")&& gender.equals("Male"))
			factor = 14.65;
		else if(retirementAge.equals("70+") && lifeExpectancy.equals("Average")&& gender.equals("Female"))
			factor = 16.31;
		else if(retirementAge.equals("70+") && lifeExpectancy.equals("Above Average")&& gender.equals("Male"))
			factor = 17.35;
		else if(retirementAge.equals("70+") && lifeExpectancy.equals("Above Average")&& gender.equals("Female"))
			factor = 18.79;


		double additionalSavingsNeeded  = 0;

		additionalSavingsNeeded = annualRetirementNeeded * factor;
		//System.out.println(additionalSavingsNeeded);

		double ssFactor = 0;

		if (retirementAge.equals("55-59"))
			ssFactor = 8.8;
		else if(retirementAge.equals("60-64"))
			ssFactor = 4.7;

		socialSecurityIncome = socialSecurityIncome * ssFactor;

		additionalSavingsNeeded = additionalSavingsNeeded + socialSecurityIncome;

		double currentSavingsAmount = 0;

		currentSavingsAmount = Double.parseDouble(getValue(9));

		double yearsUntilRetirement = 0;
		double intValueRetirementAge = 0;
		if (retirementAge.equals("55-59"))
			intValueRetirementAge = 55;
		else if(retirementAge.equals("60-64"))
			intValueRetirementAge = 60;
		else if(retirementAge.equals("65-69"))
			intValueRetirementAge = 65;
		else if(retirementAge.equals("70+"))
			intValueRetirementAge = 70;

		yearsUntilRetirement = intValueRetirementAge - currentAge;

		if(yearsUntilRetirement <= 10)
			factor = 1.3;
		else if(yearsUntilRetirement > 10 && yearsUntilRetirement <= 15)
			factor = 1.6;
		else if(yearsUntilRetirement > 15 && yearsUntilRetirement <= 20)
			factor = 1.8;
		else if(yearsUntilRetirement > 20 && yearsUntilRetirement <= 25)
			factor = 2.1;
		else if(yearsUntilRetirement > 25 && yearsUntilRetirement <= 30)
			factor = 2.4;
		else if(yearsUntilRetirement > 30 && yearsUntilRetirement <= 35)
			factor = 2.8;
		else if(yearsUntilRetirement > 35)
			factor = 3.3;

		additionalSavingsNeeded = additionalSavingsNeeded - (currentSavingsAmount * factor);


		setValue(df.format(additionalSavingsNeeded),10);


		if(yearsUntilRetirement <= 10)
			factor = .085;
		else if(yearsUntilRetirement > 10 && yearsUntilRetirement <= 15)
			factor = .052;
		else if(yearsUntilRetirement > 15 && yearsUntilRetirement <= 20)
			factor = .036;
		else if(yearsUntilRetirement > 20 && yearsUntilRetirement <= 25)
			factor = .027;
		else if(yearsUntilRetirement > 25 && yearsUntilRetirement <= 30)
			factor = .020;
		else if(yearsUntilRetirement > 30 && yearsUntilRetirement <= 35)
			factor = .016;
		else if(yearsUntilRetirement > 35)
			factor = .013;

		double annualAmountNeeded = 0;
		annualAmountNeeded = additionalSavingsNeeded * factor;

		double monthlyAmountNeeded = annualAmountNeeded/12;


		setValue(df.format(annualAmountNeeded),11);
		setValue(df.format(monthlyAmountNeeded),17);

	}
}