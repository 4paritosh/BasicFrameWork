package data;

import utilities.Xls_Reader;

public class df {
	
    Xls_Reader read = new Xls_Reader("/Users/paritosh/Desktop/Selenium jars/ScotiologinTest.xlsx");
	
	public String WrongEmail = read.getCellData("Sheet1", 1, 6);
	public String WrongPass = read.getCellData("Sheet1", 1, 5);
	public String EmailWithSpecialChar = read.getCellData("Sheet1", 1, 7);
	public String SpecialCharErr = read.getCellData("Sheet1", 1, 1);
	public String GlobalError = read.getCellData("Sheet1", 1, 2);
	public String EmptyEmailErr = read.getCellData("Sheet1", 1, 3);
	public String EmptyPassErr = read.getCellData("Sheet1", 1, 4);
	
	{
		System.out.println(WrongEmail);
	}

}
