

/**
 * @author SaurabhRajkarnikar
 *
 */
public class DataObject {
	private String name="";
	private String _id="";
	private String type="";
	boolean found=false;
	private Position geo_position=new Position();
	
	
	public boolean isFound() {
		return found;
	}
	public void setFound(boolean found) {
		this.found = found;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Position getGeo_position() {
		return geo_position;
	}
	
	public void setGeo_position(String latitude, String longitude) {
		this.geo_position.setLatitude(latitude); 
		this.geo_position.setLongitude(longitude);
	}
	
	
}
