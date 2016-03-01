
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;

/**
 * 
 * saves the result(JSON document) of querying the API into a string
 * @author SaurabhRajkarnikar
 *
 */
public class QueryAPI {
	private String endpoint;
	
	
	public QueryAPI(String endpoint){
		this.endpoint=endpoint;
		
	}
	
	public String queryAPI() {
		System.out.println("API Endpoint: " + endpoint);
		StringBuilder sb = new StringBuilder();
		URLConnection connection = null;
		InputStreamReader inputStreamReader = null;
		try {
			URL url = new URL(endpoint);
			connection = url.openConnection();
			InputStream inputStream = connection.getInputStream();
			if (connection != null && inputStream != null) {
				inputStreamReader = new InputStreamReader(connection.getInputStream(), Charset.defaultCharset());
				BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
				if (bufferedReader != null) {
					int cp;
					while ((cp = bufferedReader.read()) != -1) {
						sb.append((char) cp);
					}
					bufferedReader.close();
				}
			}
			inputStreamReader.close();
		} catch (Exception e) {
			throw new RuntimeException("Exception while querying Location JSON API:" + endpoint, e);
		}
		return sb.toString();
	}

}
