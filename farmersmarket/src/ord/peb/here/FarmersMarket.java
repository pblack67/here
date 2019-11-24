package ord.peb.here;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FarmersMarket {

	public static List<Market> readMarkets(String fileName) { 
		List<Market> markets = new ArrayList<Market>();
		File file = new File(fileName);
		try {
			BufferedReader br = new BufferedReader(new FileReader(file));
			// Eat the first header line
			String line = br.readLine();
			line = br.readLine();
			while (line != null) {
				try {
					Market market = new Market(line);
					markets.add(market);
				} catch (NumberFormatException e) {
					System.out.println("Bad Coordinate(s)");
				}
				line = br.readLine();
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return markets;
	}
	
	private static boolean attributesMatch(Market market, List<String> attributes) {
		for (String attr : attributes) {
			int attrNum = ATTRIBUTES.valueOf(attr).getNumber();
			if (!market.attributes.contains(attrNum)) {
				return false;
			}
		}
		return true;
	}
	
	public static float distFrom(float lat1, float lng1, float lat2, float lng2) {
		    double earthRadius = 6371000; //meters
		    double dLat = Math.toRadians(lat2-lat1);
		    double dLng = Math.toRadians(lng2-lng1);
		    double a = Math.sin(dLat/2) * Math.sin(dLat/2) +
		               Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) *
		               Math.sin(dLng/2) * Math.sin(dLng/2);
		    double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
		    float dist = (float) (earthRadius * c);

		    return dist;
	}
	 
	public static List<MarketResult> findMarkets(List<Market> markets, MarketInput input) {
		List<MarketResult> results = new ArrayList<MarketResult>();
		for (Market market : markets) {
			if (attributesMatch(market, input.attributes)) {
				Float distance = distFrom(input.target.get(0), input.target.get(1), market.getX(), market.getY());
				if (distance < input.radius) {
					System.out.println(market.getId() + " " + distance);
					results.add(new MarketResult(market.getId(), (int)(float)distance));
				}
			}
		}

		return results;
	}
	
}
