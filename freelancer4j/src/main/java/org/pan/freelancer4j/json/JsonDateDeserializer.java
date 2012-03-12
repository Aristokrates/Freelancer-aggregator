package org.pan.freelancer4j.json;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * Json date serializer
 * <p>
 * Used for deserializing json property into date using simple date format
 * 
 * @author Pance.Isajeski
 *
 */
public class JsonDateDeserializer extends JsonDeserializer<Date>{

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	@Override
	public Date deserialize(JsonParser paramJsonParser,
			DeserializationContext paramDeserializationContext)
			throws IOException, JsonProcessingException {
		
		String dateString = paramJsonParser.getText();
		try {
			Date date = dateFormat.parse(dateString);
			return date;
		} catch (ParseException e) {
//			//
		}
		return paramDeserializationContext.parseDate(paramJsonParser.getText());
	}

}
