package seleniumproject.utils;

import org.testng.annotations.DataProvider;

import java.io.File;
import java.lang.reflect.Method;

public class ExcelDataProvider {
    @DataProvider(name = "excelSheetNameAsMethodName")
    public static Object[][] multiSheetExcelRead(Method method) throws Exception {
        File file = new File(System.getProperty("user.dir") + "/src/test/resources/Excel Files/TestData.xls");
        String SheetName = method.getName();
        System.out.println(SheetName);
        Object testObjArray[][] = ExcelUtils.getExcelData(file.getAbsolutePath(), SheetName);
        return testObjArray;
    }
}