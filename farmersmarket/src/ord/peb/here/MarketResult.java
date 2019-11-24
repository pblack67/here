package ord.peb.here;

public class MarketResult {
	public String marketId = "";
	public int distance = 0;
	
	MarketResult(String marketId, int distance) {
		this.marketId = marketId;
		this.distance = distance;
	}
	
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("[");
		buf.append(marketId);
		buf.append(", ");
		buf.append(distance);
		buf.append("]");
		return buf.toString();
	}
}
