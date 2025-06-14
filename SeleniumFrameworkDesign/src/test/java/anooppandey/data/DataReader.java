/*
 * 


--> Moved this implementation under BestTest as it is reusable method for Test. No need to create a new class.

package anooppandey.data;

import java.io.File;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DataReader {
	
	//This method is moved to BestTest class

	public List<HashMap<String, String>> getJsonDataMap(String filePath) throws IOException {

		// read json to String
		
		// filepath --> System.getProperty("user.dir") + "//src//test//java//anooppandey//data//PurchaseOrder.json"

		String jsonContent = FileUtils.readFileToString(
				new File(filePath),
				StandardCharsets.UTF_8);

		// String to HashMap - (Need new dependency - Jackson Databind
		ObjectMapper mapper = new ObjectMapper();

		List<HashMap<String, String>> data = mapper.readValue(jsonContent,
				new TypeReference<List<HashMap<String, String>>>() {
				});
		return data;
	}

}
*/