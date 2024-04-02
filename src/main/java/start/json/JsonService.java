package start.json;

import java.io.File;
import java.io.IOException;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonService {

public ObjectMapper mapper = new ObjectMapper();
	
	//objeto -> json
	public String json(Object o) throws IOException {
		return mapper.writeValueAsString(o);
	}
	
	//objeto -> json
	public String jsonFormatado(Object o) throws IOException {
		return mapper.writerWithDefaultPrettyPrinter().writeValueAsString(o);
	}

	//objeto -> json
	public void jsonNaoFormatado(File file, Object o) throws IOException {
		mapper.writeValue(file, o);
	}
	
	//objeto -> json
	public void jsonFormatado(File file, Object o) throws IOException {
		mapper.writerWithDefaultPrettyPrinter().writeValue(file, o);
	}
	
	//json -> objeto
	public <T> T objeto(String json, Class<T> clazz) throws IOException {
		return mapper.readValue(json, clazz);
	}
	
	//json -> objeto
	public <T> T objeto(File fileJson, Class<T> clazz) throws IOException {
		return mapper.readValue(fileJson, clazz);
	}
}
