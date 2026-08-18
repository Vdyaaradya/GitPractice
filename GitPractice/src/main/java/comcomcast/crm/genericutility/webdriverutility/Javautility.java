package comcomcast.crm.genericutility.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import org.apache.poi.ss.formula.functions.Days360;

public class Javautility {

 public int getRandomNumber()
	{
		Random random=new Random();
		int randomNumber=random.nextInt(4000);
		return randomNumber;
	}
 public String getSystemDateYYYYMMDD()
  {
	 Date dobj =new Date();
	 SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	 String date= sim.format(dobj);
	 return date;
  }
 
public String getRequiredDateYYYYDDMM(int days)
{
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	Calendar cal=Calendar.getInstance();
	 //cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
	String requiredDate=sim.format(cal.getTime());
	return requiredDate;
}
}
