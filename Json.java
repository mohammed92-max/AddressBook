package assignment;
import java.io.File;
import java.io.IOException;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

public class Json 
{
	private static ObjectMapper mapper;
	
	static 
	{
		mapper = new ObjectMapper();
	}

	public static Object readMapper(String path, Object object) throws JsonParseException, JsonMappingException, IOException 
	{
		return mapper.readValue(new File(path), object.getClass());		
	}																	
	public static String writeMapper(String path, Object object) throws JsonParseException, JsonMappingException, IOException 
	{
		mapper.writeValue(new File(path), object);
		return "Written in file";
	}
}
