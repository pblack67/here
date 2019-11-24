package ord.peb.here;

public class MarketResult implements Comparable {
	public String marketId = "";
	public int distance = 0;
	public float percent = (float)0.0;
	
	MarketResult(String marketId, int distance, Float percent) {
		this.marketId = marketId;
		this.distance = distance;
		this.percent = percent;
	}
	
	public String toString() {
		StringBuilder buf = new StringBuilder();
		buf.append("[");
		buf.append(marketId);
		buf.append(", ");
		buf.append(distance);
		if (percent > 0.0) {
			buf.append(", ");
			buf.append(percent);
		}
		buf.append("]");
		return buf.toString();
	}

	@Override
	public int hashCode() {
		return marketId.hashCode();
	}
	
	public int compareTo(Object obj) {
		MarketResult result = (MarketResult)obj;
		return (int)(result.percent - this.percent);
	}
}
