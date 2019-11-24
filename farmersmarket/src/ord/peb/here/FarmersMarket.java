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
			String line = br.readLine();
			while (line != null) {
				Market market = new Market(line);
				markets.add(market);
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
	
	public static List<MarketResult> findMarkets(List<Market> markets, MarketInput input) {
		List<Market> filtered = new ArrayList<Market>();
//		for (Market market : markets) {
//			
//		}
		
		MarketResult result1 = new MarketResult(1019530, 0);
		MarketResult result2 = new MarketResult(1019531, 3320);
		List<MarketResult> results = new ArrayList<MarketResult>();
		results.add(result1);
		results.add(result2);
		return results;
	}
	
}
