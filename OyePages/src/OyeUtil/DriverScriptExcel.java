package OyeUtil;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

public class DriverScriptExcel {
	
	
	//Read the data members
	private static FileInputStream fis;
	private static Workbook wb;
	private static Sheet sh;
	private static String[][] strArryData;
	
	//Write the data members
	
	private static FileOutputStream fos;
	private static WritableWorkbook wwb;
	private static WritableSheet ws;
	
	
	
	//Retrieving the test data from external file (excel)
	public static String[][] getTestData(String filePath, String sheetName) throws BiffException, IOException{
		int rowValue = 0;
		int columnValue = 0;
		
		fis = new FileInputStream(filePath);
		wb = Workbook.getWorkbook(fis);
		sh = wb.getSheet(sheetName);
		
		rowValue= sh.getRows();
		//System.out.println(rowValue);
		columnValue= sh.getColumns();
		//System.out.println(columnValue);
		
		strArryData = new String[rowValue-1][columnValue];
		//System.out.println(strArryData.length);
		
		for(int i = 1; i <= rowValue-1; i++){
			for(int j = 0; j < columnValue; j++){
				/*if(i==4 || i==6){
					strArryData[i-1][j]= null;
					//System.out.println("I am null");
				}else{*/
					strArryData[i-1][j]= sh.getCell(j, i).getContents();
					//System.out.println("I am not null");
				//}
				
			}
		}
		
		return strArryData;
	}
	
	
	public static void putTestResult(String filePath, String sheetName) throws BiffException, IOException, WriteException{
		
		
		Object[][] org = DriverScriptExcel.getTestData(".\\input\\InputTestData.xls", "Sheet1");
		
		fos = new FileOutputStream(filePath);
		wwb =  Workbook.createWorkbook(fos);
		ws = wwb.createSheet(sheetName, 0);
		
		for(int i=1; i<=org.length; i++){
			for(int j=0; j<org[i-1].length; j++){
				Label lb = new Label(j,i, ((String)org[i-1][j]));
				ws.addCell(lb);
			}
		}
		
		Label lbuser = new Label(0,0, "Username");
		ws.addCell(lbuser);
		
		Label lbpwd = new Label(1,0, "Password");
		ws.addCell(lbpwd);
		
		Label lbstatus = new Label(2,0, "Status(Pass/Fail)");
		ws.addCell(lbstatus);
		
		wwb.write();
		wwb.close();
		
	}
	
	
	public static void main(String[] args) throws Exception{
		
		/*Object[][] org = DriverScriptExcel.getTestData(".\\input\\InputTestData.xls", "Sheet1");
		for(int i = 0; i< org.length; i++){
			for(int j = 0; j < org[i].length; j++){
				
				if(org[i][j] != null){
					
					System.out.println("Values at: " + org[i][j]);
					System.out.println();
				}
				
			}
		}*/
		
		
		
		//This method write the test data and result in the Output Test Result file
		putTestResult(".\\input\\OutputTestResult.xls", "Result");
		
	}
	
	
	
	
	

}
