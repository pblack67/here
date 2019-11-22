package ord.peb.here;

import java.util.HashSet;
import java.util.Set;

public class Market {
	private static int ATTRIBUTES_SIZE = 35;

	private String id;
	private String name;
	private String city;
	private String county;
	private String state;
	private String zip;
	private String x;
	private String y;
	Set<ATTRIBUTES> attributes = new HashSet<ATTRIBUTES>();
	
	private void parseLine(String line) {
		String[] parts = line.split(",");
		
	}
	
	public Market(String line) {
		super();
		parseLine(line);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	public String getX() {
		return x;
	}

	public void setX(String x) {
		this.x = x;
	}

	public String getY() {
		return y;
	}

	public void setY(String y) {
		this.y = y;
	}
	
	
}
