package ord.peb.here;

public class MarketResult {
	public int marketId = 0;
	public int distance = 0;
	
	MarketResult(int marketId, int distance) {
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
