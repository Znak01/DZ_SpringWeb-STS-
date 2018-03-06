package spring.STS.web.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import spring.STS.web.entity.MyColor;

@Component
public class ColorFormatter implements Formatter<MyColor> {

	@Override
	public String print(MyColor object, Locale locale) {
		System.out.println("Print value: " + 
	            object.getId() + " " + 
				object.getName());
		return String.valueOf(object.getId());
	}

	@Override
	public MyColor parse(String text, Locale locale) throws ParseException {
		int id = Integer.valueOf(text);
		MyColor color = new MyColor();
		color.setId(id);
		return color;
	}

}
