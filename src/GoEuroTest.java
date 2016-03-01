import org.json.JSONException;

/**
 * @author SaurabhRajkarnikar
 *
 */
public class GoEuroTest {
	/**
	 * @param args-takes in the name of the city
	 */
	public static void main(String args[]) {
		if (args.length <= 0) {
			System.out.println("Command line: java -jar GoEuroTest.jar CITY_NAME");
			throw new IllegalArgumentException("Please enter a valid city name");
		}
		String city = args[0];
		if(!city.matches("[a-zA-Z]+$")){
			System.out.println("Command line: java -jar GoEuroTest.jar CITY_NAME");
			throw new IllegalArgumentException("Please enter a valid city name");
		}	
		String str="http://api.goeuro.com/api/v2/position/suggest/en/" + city;
		QueryAPI query = new QueryAPI(str);
		try {
			String jsonString = query.queryAPI();
			new JSONData(jsonString, city);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}

}
