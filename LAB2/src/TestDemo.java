import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;
import org.junit.BeforeClass;
import org.junit.AfterClass;
import static org.junit.Assert.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import static org.hamcrest.CoreMatchers.is;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class TestDemo {
	private String user_number, password, expected;
	private static WebDriver driver;
	static String driverPath = System.getProperty("user.dir") + "/src/res/geckodriver.exe";
	static String url = "http://103.120.226.190/selenium-demo/git-repo/";
	
    
    //constructor
	public TestDemo(String user_number, String password, String expected) {
		this.user_number = user_number;
		this.password = password;
		this.expected = expected;
	}
	

	//junit中BeforeClass跟AfterClass的方法要加static（因此时无对象）
	@BeforeClass
	public static void setUp() {
		System.setProperty("webdriver.gecko.driver", driverPath);
		driver = new FirefoxDriver();
		//访问URL
		driver.get(url);
	}
	
	@AfterClass
	public static void tearDown() {
		driver.quit();
	}
	
	@Test
	public void testSite() {
		//输入账号密码并点击登录
		driver.findElement(By.name("user_number")).sendKeys(this.user_number);
		driver.findElement(By.name("password")).sendKeys(this.password);
		driver.findElement(By.cssSelector(".btn")).click();
		//断言
		WebElement element1 = driver.findElement(By.cssSelector(".mb-2:nth-child(6)"));
		assertThat(element1.getText(), is(this.expected));
//		System.out.println(element1.getText());
	}
	
	//从excel表提取账号密码作为参数
	@Parameters
	public static Collection<Object[]> getData(){
		String filePath = "F:\\forever学习/软件测试/实验二/LAB2/src/res/Selenium+Lab2020.xlsx";
        InputStream fis = null;
        //存放从excel中提取出来的账号密码
    	String user[] = new String[20];
        String pwd[] = new String[20];
        int i = 0;
        try {
            fis = new FileInputStream(filePath);
            Workbook workbook = new XSSFWorkbook(fis);//xlsx对应xssf
            
            Sheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rows = sheet.rowIterator();
            Row row;
            Cell cell;
            //遍历行
            while (rows.hasNext()) {
                row = rows.next();
                
                //判断空行
                if(RowOperation.isRowEmpty(row)) {
                	break;
                }
                
                Iterator<Cell> cells = row.cellIterator();
                //遍历一行的单元格
                while (cells.hasNext()) {
                    cell = cells.next();
                    //列号为1为账号，列号为2为密码
                    if(cell.getColumnIndex() == 1) {
                    	user[i] = cell.getStringCellValue();
                    }
                    if(cell.getColumnIndex() == 2) {
                    	pwd[i] = cell.getStringCellValue();
                    }
                }
                i++;
            }
            workbook.close();
//            for(int j = 0; j < 20; j ++) {
//            	System.out.println(user[j]);
//            }
//            for(int k = 0; k < 20; k ++) {
//            	System.out.println(pwd[k]);
//            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != fis) {
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
		return Arrays.asList(new Object[][]{
			{user[0], pwd[0], pwd[0]},
			{user[1], pwd[1], pwd[1]},
			{user[2], pwd[2], pwd[2]},
			{user[3], pwd[3], pwd[3]},
			{user[4], pwd[4], pwd[4]},
			{user[5], pwd[5], pwd[5]},
			{user[6], pwd[6], pwd[6]},
			{user[7], pwd[7], pwd[7]},
			{user[8], pwd[8], pwd[8]},
			{user[9], pwd[9], pwd[9]},
			{user[10], pwd[10], pwd[10]},
			{user[11], pwd[11], pwd[11]},
			{user[12], pwd[12], pwd[12]},
			{user[13], pwd[13], pwd[13]},
			{user[14], pwd[14], pwd[14]},
			{user[15], pwd[15], pwd[15]},
			{user[16], pwd[16], pwd[16]},
			{user[17], pwd[17], pwd[17]},
			{user[18], pwd[18], pwd[18]},
			{user[19], pwd[19], pwd[19]}
		});
	}
	
}
