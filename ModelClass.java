package cs368_projecttwo;


import java.util.Observable;
import java.text.DecimalFormat;


/***************************************************************************
 * ModelClass.java
 *
 * This program is used to fincance and plan an individual's retirement.
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
	public String [] dataStorage = new String [13];

//	public ModelClass(){

//	dataStorage[0]= "";
//	dataStorage[1]= "test";
//	dataStorage[2]= "";
//	dataStorage[3]= "test";
//	dataStorage[4]= "test";
//	dataStorage[5]= "test";
//	dataStorage[6]= "test";
//	dataStorage[7]= "test";
//	dataStorage[8]= "test";
//	dataStorage[9]= "test";
//	dataStorage[10]= "test";

//	}

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
		double currentAge;
		double annualIncome;
		double socialSecurityIncome;
		double percentOfIncomeWanted = 0;
		double otherIncomeAfterRetirement = 0;

		name = getValue(0);

		currentAge = Double.parseDouble(getValue(1));


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

		annualRetirementNeeded = (annualIncome * (percentOfIncomeWanted /100)) - socialSecurityIncome - otherIncomeAfterRetirement;


		setValue(df.format(annualRetirementNeeded),6);


		double retirementAge = 0;
		double lifeExpectancy = 0;
		double factor = 0;

		retirementAge = Double.parseDouble(getValue(7));

		lifeExpectancy = Double.parseDouble(getValue(8));

		if(retirementAge == 55 && lifeExpectancy == 82)
			factor = 18.79;
		else if(retirementAge == 55 && lifeExpectancy == 86)
			factor = 20.53;
		else if(retirementAge == 55 && lifeExpectancy == 89)
			factor = 22.79;
		else if(retirementAge == 55 && lifeExpectancy == 94)
			factor = 23.46;
		else if(retirementAge == 55 && lifeExpectancy == 97)
			factor = 24.40;
		else if(retirementAge == 60 && lifeExpectancy == 82)
			factor = 16.31;
		else if(retirementAge == 60 && lifeExpectancy == 86)
			factor = 18.32;
		else if(retirementAge == 60 && lifeExpectancy == 89)
			factor = 19.68;
		else if(retirementAge == 60 && lifeExpectancy == 92)
			factor = 20.93;
		else if(retirementAge == 60 && lifeExpectancy == 94)
			factor = 21.71;
		else if(retirementAge == 60 && lifeExpectancy == 97)
			factor = 22.79;
		else if(retirementAge == 65 && lifeExpectancy == 82)
			factor = 13.45;
		else if(retirementAge == 65 && lifeExpectancy == 86)
			factor = 15.77;
		else if(retirementAge == 65 && lifeExpectancy == 89)
			factor = 17.35;
		else if(retirementAge == 65 && lifeExpectancy == 92)
			factor = 18.79;
		else if(retirementAge == 65 && lifeExpectancy == 94)
			factor = 19.68;
		else if(retirementAge == 65 && lifeExpectancy == 97)
			factor = 20.93;
		else if(retirementAge == 70 && lifeExpectancy == 82)
			factor = 10.15;
		else if(retirementAge == 70 && lifeExpectancy == 86)
			factor = 12.83;
		else if(retirementAge == 70 && lifeExpectancy == 89)
			factor = 14.65;
		else if(retirementAge == 70 && lifeExpectancy == 92)
			factor = 16.31;
		else if(retirementAge == 70 && lifeExpectancy == 94)
			factor = 17.35;
		else if(retirementAge == 70 && lifeExpectancy == 97)
			factor = 18.79;


		double additionalSavingsNeeded  = 0;

		additionalSavingsNeeded = annualRetirementNeeded * factor;
		//System.out.println(additionalSavingsNeeded);

		double ssFactor = 0;

		if (retirementAge == 55)
			ssFactor = 8.8;
		else if(retirementAge == 60)
			ssFactor = 4.7;

		socialSecurityIncome = socialSecurityIncome * ssFactor;

		additionalSavingsNeeded = additionalSavingsNeeded + socialSecurityIncome;

		double currentSavingsAmount = 0;

		currentSavingsAmount = Double.parseDouble(getValue(9));

		double yearsUntilRetirement = retirementAge - currentAge;
		yearsUntilRetirement = retirementAge - currentAge;

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


		setValue(df.format(annualAmountNeeded),11);

	}
}