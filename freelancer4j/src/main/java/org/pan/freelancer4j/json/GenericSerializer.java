package org.pan.freelancer4j.json;
import org.codehaus.jackson.type.TypeReference;

/**
 * 
 * @author Pance.Isajeski
 *
 */
public interface GenericSerializer {

    public String toJson(Object object);
    
	public <T> T fromJson(String serialization, Class<T> clazz);
	
	public <T> T fromJson(String serialization, TypeReference<T> typeRef);

}
