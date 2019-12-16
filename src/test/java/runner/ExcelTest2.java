package runner;

import utilities.ExcelUtills;

import java.io.IOException;

public class ExcelTest2 {
    public static void main(String[] args) throws IOException {
        ExcelUtills.openExcelFIle("testData","Sheet1");
        System.out.println(ExcelUtills.getValue(1,1));
        System.out.println(ExcelUtills.getValue(2,2));
        ExcelUtills.setValue("Chicago",4,3);
        ExcelUtills.setValue("20",4,4);
//        for(int row=1; row<=ExcelUtills.getNumberofRows();row++){
//           String age=ExcelUtills.getValue(row,4) ;
//           double ageInt=Double.parseDouble(age);
//           ExcelUtills.setValue((ageInt+1)+"",row,4);
//
        }
    }
    //Data Driven Testing --> DDT


