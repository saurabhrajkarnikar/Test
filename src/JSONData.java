

import org.json.JSONArray;
import org.json.JSONObject;

/**
 * extracts the required fields from the JSON Document
 * 
 * @author SaurabhRajkarnikar
 *
 */
public class JSONData {

	public JSONData(String jsonString, String city) {

		JSONArray jsonArray = new JSONArray(jsonString);
		int len = jsonArray.length();
		if(len==0){
			System.out.println("Command line: java -jar GoEuroTest.jar CITY_NAME");
			throw new IllegalArgumentException("Invalid city name.Please enter a valid city name");
		}
		DataObject dataObject=new DataObject();
		for (int i = 0; i < len; i++) {
			JSONObject jsonObject = jsonArray.getJSONObject(i);
			String name = jsonObject.getString("name");
			String type = jsonObject.getString("type");
			if (type.equals("location") && name.toLowerCase().equals(city.toLowerCase())) {
				String id = Integer.toString(jsonObject.getInt("_id"));
				JSONObject position = jsonObject.getJSONObject("geo_position");
				String latitude = Double.toString(position.getDouble("latitude"));
				String longitude = Double.toString(position.getDouble("longitude"));
				dataObject.setFound(true);
				dataObject.set_id(id);
				dataObject.setName(name);
				dataObject.setType(type);
				dataObject.setGeo_position(latitude,longitude);
			}
		}
		if(!dataObject.isFound())		
		{
			System.out.println("Command line: java -jar GoEuroTest.jar CITY_NAME");
			throw new IllegalArgumentException(city+" City not found.Please enter a valid city name");
		}
		new CsvFile(dataObject);
	}
}
