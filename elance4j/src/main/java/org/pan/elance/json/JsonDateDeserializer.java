package org.pan.elance.json;

import java.io.IOException;
import java.util.Date;

import org.codehaus.jackson.JsonParser;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.DeserializationContext;
import org.codehaus.jackson.map.JsonDeserializer;

/**
 * Json date serializer
 * <p>
 * Used for deserializing json property into date using timeinmilisec
 * 
 * @author Pance.Isajeski
 *
 */
public class JsonDateDeserializer extends JsonDeserializer<Date>{

	@Override
	public Date deserialize(JsonParser paramJsonParser,
			DeserializationContext paramDeserializationContext)
	throws IOException, JsonProcessingException {

		Integer dateInSec = paramJsonParser.getIntValue();
		Long dateInMilisec = Long.valueOf(dateInSec) * 1000L;
		Date date = new Date(dateInMilisec);
		return date;
	}
}
