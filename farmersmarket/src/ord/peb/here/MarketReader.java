package ord.peb.here;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MarketReader {

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
	
}
