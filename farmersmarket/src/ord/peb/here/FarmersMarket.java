package ord.peb.here;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class FarmersMarket {

	private static boolean attributesMatch(Market market, List<String> attributes) {
		for (String attr : attributes) {
			int attrNum = ATTRIBUTES.valueOf(attr).getNumber();
			if (!market.attributes.contains(attrNum)) {
				return false;
			}
		}
		return true;
	}

	private static float getPercentageMatch(Market market, List<String> attributes) {
		int matches = 0;
		for (String attr : attributes) {
			int attrNum = ATTRIBUTES.valueOf(attr).getNumber();
			if (market.attributes.contains(attrNum)) {
				matches++;
			}
		}
		return (float)matches/(float)attributes.size();
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
					results.add(new MarketResult(market.getId(), (int)(float)distance, (float)0.0));
				}
			}
		}

		return results;
	}

	public static List<MarketResult> findPercentageMarkets(List<Market> markets, MarketInput input) {
		List<MarketResult> results = new ArrayList<MarketResult>();
		for (Market market : markets) {
			float percentMatch = getPercentageMatch(market, input.attributes);
			if (percentMatch > 0.0) {
				Float distance = distFrom(input.target.get(0), input.target.get(1), market.getX(), market.getY());
				if (distance < input.radius) {
					System.out.println(market.getId() + " " + distance + " " + percentMatch);
					results.add(new MarketResult(market.getId(), (int)(float)distance, (float)percentMatch));
				}
			}
		}

		// Return only the highest percentage result(s)
		// TODO Implement better method of this. Horribly inefficient.
		MarketResult[] marketResult = results.toArray(new MarketResult[0]);
		Arrays.parallelSort(marketResult);
		return Arrays.asList(marketResult);
	}
	
}
