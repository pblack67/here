package farmersmarket;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import ord.peb.here.FarmersMarket;
import ord.peb.here.Market;
import ord.peb.here.MarketInput;

class FarmersMarketTest {

	@Test
	void test() {
		List<Market> markets = FarmersMarket.readMarkets("C:\\Users\\pblac\\Documents\\GitHub\\here\\Farmers Market\\Data\\Farmers_Market.csv");
		MarketInput input = new MarketInput("[41.098698, -81.553272], 5000, [Credit, WIC, Bakedgoods, Cheese, Vegetables]");
		List<Market> results = FarmersMarket.findMarkets(markets, input);
		assertEquals("[[1019530, 0], [1019531, 3320]]", results);
	}

}
