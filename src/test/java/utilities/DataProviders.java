package utilities;


import org.testng.annotations.DataProvider;

import java.io.IOException;

public class DataProviders {

    // DataProvider 1

    @DataProvider(name = "LoginData")
    public String[][] getData() throws IOException
    {
        String path = "./testData/Login_Test_Data.xlsx"; // taking xl file from testData

        ExcelUtility xlutil = new ExcelUtility(path); // creating an object for XLUtility

        int totalrows = xlutil.getRowCount("Sheet1");
        int totalcols = xlutil.getCellCount("Sheet1", 1);

        String logindata[][] = new String[totalrows][totalcols]; // created for two dimensional array

        // read the data from xl storing in two dimensional array

        for (int i = 1; i <= totalrows; i++) // 1
        {
            for (int j = 0; j < totalcols; j++) // 0
            {
                logindata[i - 1][j] = xlutil.getCellData("Sheet1", i, j); // 1,0
            }
        }

        return logindata; // returning two dimensional array
    }
}
