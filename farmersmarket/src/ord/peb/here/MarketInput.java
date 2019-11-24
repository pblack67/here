package ord.peb.here;

import java.util.ArrayList;
import java.util.List;

public class MarketInput {
	List<Float> target = new ArrayList<Float>();
	int radius = 0;
	List<String> attributes = new ArrayList<String>();
	
	public MarketInput(String input) {
		int firstBracket = input.indexOf("]");
		String[] rawPoint = input.substring(1, firstBracket).split(",");
		for (String coord : rawPoint) {
			target.add(Float.valueOf(coord));
		}
		
		int nextComma = input.indexOf(",", firstBracket+2);
		radius = Integer.valueOf(input.substring(firstBracket+2, nextComma).trim());
		
		String bracketed = input.substring(nextComma+1, input.length()).trim();
		String[] attrs = bracketed.substring(1, bracketed.length()-1).split(",");
		for (String attr : attrs) {
			attributes.add(attr.trim().toUpperCase());
		}
	}
}
