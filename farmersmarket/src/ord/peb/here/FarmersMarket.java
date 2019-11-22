package ord.peb.here;

import java.util.List;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FarmersMarket {

	private static Market[] readMarkets(String fileName) { 
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
	
	public static void main(String[] args) {
		Market[] markets = readMarkets("C:\\Users\\pblac\\Documents\\GitHub\\here\\Farmers Market\\Data\\Farmers_Market.csv");
	}

}
