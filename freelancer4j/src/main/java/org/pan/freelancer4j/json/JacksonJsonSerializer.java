package org.pan.freelancer4j.json;

import org.codehaus.jackson.map.AnnotationIntrospector;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.introspect.JacksonAnnotationIntrospector;
import org.codehaus.jackson.type.TypeReference;

/**
 * Implementation of json serialization/deserialization using jackson library
 * 
 * @author Pance.Isajeski
 *
 */
public class JacksonJsonSerializer implements GenericSerializer {

    private ObjectMapper mapper;

    @SuppressWarnings("deprecation")
	public JacksonJsonSerializer() {
    	
        mapper = new ObjectMapper();
        AnnotationIntrospector introspector = new JacksonAnnotationIntrospector();
        
        mapper.getDeserializationConfig().setAnnotationIntrospector(introspector);
        mapper.getSerializationConfig().setAnnotationIntrospector(introspector);
        
        mapper.configure(SerializationConfig.Feature.WRITE_NULL_PROPERTIES, false);
    }

    @Override
    public <T> T fromJson(String serialization, Class<T> clazz) {
        try {
            return mapper.readValue(serialization, clazz);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public String toJson(Object object) {
        try {
            return mapper.writeValueAsString(object);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

	@SuppressWarnings("unchecked")
	@Override
	public <T> T fromJson(String serialization, TypeReference<T> typeRef) {
        try {
            return (T) mapper.readValue(serialization, typeRef);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
	}
}
