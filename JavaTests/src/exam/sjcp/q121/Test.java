package exam.sjcp.q121;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;


public class Test {
	public static void main(String[] args)  {
		Date now = new Date();
		Locale locale = Locale.getDefault();
		DateFormat df = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, locale);
		System.out.println(df.format(now));
		
		Float f = 5.5f;
		int x = (int)f;
		int t = 5;
		f = (float) t;
	}

}
