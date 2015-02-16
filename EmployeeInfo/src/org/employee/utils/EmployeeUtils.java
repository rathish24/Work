package org.employee.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class EmployeeUtils
{

	public String convertDOB(String empDOB)
	{
		String newDate = null;
		try
		{
			String oldformat = "dd-mm-yyyy";
			String newFormat = "yyyy-mm-dd";
			SimpleDateFormat sdf = new SimpleDateFormat(oldformat);
			Date d = sdf.parse(empDOB);
			sdf.applyPattern(newFormat);
			newDate = sdf.format(d);
		} catch (ParseException e)
		{

			e.printStackTrace();
		}

		return newDate;
	}

}
