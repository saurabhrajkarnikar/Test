import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.opencsv.CSVWriter;
	
/**
 * Generates a CSV file with the name of the city
 * @author SaurabhRajkarnikar
 *
 */
public class CsvFile {

	public CsvFile(DataObject obj) {
		try {
			String csv = obj.getName() + "." + "csv";
			CSVWriter csvWriter = new CSVWriter(new FileWriter(csv));
			List<String[]> data = new ArrayList<String[]>();
			data.add(new String[] { "_id", "name", "type", "latitude", "longitude" });
			data.add(new String[] { obj.get_id(), obj.getName(), obj.getType(), obj.getGeo_position().getLatitude(),
					obj.getGeo_position().getLongitude() });
			System.out.println("Writing Csv File to disk");
			csvWriter.writeAll(data);
			csvWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}
	}

}
