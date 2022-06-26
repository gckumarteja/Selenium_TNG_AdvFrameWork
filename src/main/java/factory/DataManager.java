package factory;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Connection;
import com.codoid.products.fillo.Fillo;
import com.codoid.products.fillo.Recordset;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

public class DataManager {

    @DataProvider(name = "data")
    public static Object[][] getDataFromExcelUsingFillo(Method test) throws FilloException {
        //Object[][] obj = new Object[1][1];
        Fillo file= new Fillo();
        Connection connection=file.getConnection(System.getProperty("user.dir") + "\\src\\data\\TestData.xlsx");
        Recordset rs= connection.executeQuery("Select * from Sheet1 where Run='Yes' and TestID='"+test.getName()+"' order by Iteration asc");
        int rowCnt=rs.getCount();
        int colCnt=rs.getFieldNames().size();

        Object[][] obj= new Object[rowCnt][1];
        int row=0;
        while(rs.next())
        {
            HashMap<String,String> dataMap=new HashMap<String, String>();
            for(int col=0;col<colCnt;col++)
            {
                dataMap.put(rs.getFieldNames().get(col), rs.getField(col).value());
            }
            System.out.println(dataMap);
            obj[row][0]=dataMap;
            row=row+1;
        }
        return obj;
    }


        /* We can use ITestContext to get data based on groups
    @Test(dataProvider="SearchProvider",groups="B")

    @DataProvider(name="SearchProvider")
	public Object[][] getDataFromDataprovider(ITestContext c){
	Object[][] groupArray = null;
		for (String group : c.getIncludedGroups()) {
		if(group.equalsIgnoreCase("A")){
			groupArray = new Object[][] {
					{ "Guru99", "India" },
					{ "Krishna", "UK" },
					{ "Bhupesh", "USA" }
				};
		break;
		}
			else if(group.equalsIgnoreCase("B"))
			{
			groupArray = new Object[][] {
						{  "Canada" },
						{  "Russia" },
						{  "Japan" }
					};
			}
		break;
	}
	return groupArray;
	}
     */
}
