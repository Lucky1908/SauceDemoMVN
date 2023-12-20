package testcases;

import org.testng.annotations.Test;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;

import pages.LoginPage;

public class LoginTest extends BaseClass {

@Test
	public void positiveTC() throws FilloException {
		LoginPage lp=new LoginPage(driver);
		Recordset recordset = connection.executeQuery("select * from sheet1 where TestName='positiveTC'");
		recordset.next();
		
		String UN = recordset.getField("User");
		String PW = recordset.getField("Pass");
		lp.loginFunction(UN,PW);
		
	}
	@Test
	public void negativeTC() throws FilloException {
		LoginPage lp=new LoginPage(driver);
		Recordset recordset = connection.executeQuery("select * from sheet1 where TestName='negativeTC'");
		recordset.next();
		
		String UN = recordset.getField("User");
		String PW = recordset.getField("Pass");
		lp.loginFunction(UN,PW);
		
		
	}
}
