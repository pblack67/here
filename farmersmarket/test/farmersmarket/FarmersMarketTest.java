package farmersmarket;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ord.peb.here.FarmersMarket;
import ord.peb.here.Market;
import ord.peb.here.MarketInput;
import ord.peb.here.MarketResult;

class FarmersMarketTest {

	@Test
	void testBasic() {
		List<Market> markets = FarmersMarket.readMarkets("C:\\Users\\pblac\\Documents\\GitHub\\here\\Farmers Market\\Data\\Farmers_Market.csv");
		MarketInput input = new MarketInput("[-81.553272, 41.098698], 5000, [Credit, WIC, Bakedgoods, Cheese, Vegetables]");
		List<MarketResult> results = FarmersMarket.findMarkets(markets, input);
		assertEquals("[[1019530, 0], [1019531, 4161], [1019529, 3683]]", results.toString());
	}

	@Test
	void testFuzzy() {
		List<Market> markets = FarmersMarket.readMarkets("C:\\Users\\pblac\\Documents\\GitHub\\here\\Farmers Market\\Data\\Farmers_Market.csv");
		MarketInput input = new MarketInput("[-81.553272, 41.098698], 5000, [Credit, WIC, Bakedgoods, Cheese, Crafts, Vegetables]");
		List<MarketResult> results = FarmersMarket.findPercentageMarkets(markets, input);
		assertEquals("[[1019530, 0], [1019531, 4161], [1019529, 3683]]", results.toString());
	}

}
