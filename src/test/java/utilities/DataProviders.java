package utilities;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="LoginData")
	public String[][] getData() throws Exception
	{
	    String path=".\\testData\\Credentials.xlsx";

	    ExcelUtility xlutil=new ExcelUtility(path);

	    int totalRows=xlutil.getRowCount("Sheet1");
	    int totalCells=xlutil.getCellCount("Sheet1",1);

	    String loginData[][]=new String[totalRows][totalCells];

	    for(int i=1;i<=totalRows;i++)
	    {
	        for(int j=0;j<totalCells;j++)
	        {
	            loginData[i-1][j]=xlutil.getCellData("Sheet1", i, j);
	        }
	    }
	    return loginData;
	}
}
