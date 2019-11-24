package ord.peb.here;

import java.text.DecimalFormat;

public class MarketResult implements Comparable<MarketResult> {
	private String marketId = "";
	private int distance = 0;
	private float percent = (float)0.0;
	
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
			DecimalFormat df = new DecimalFormat("#.##");
			buf.append(df.format(percent*100));
		}
		buf.append("]");
		return buf.toString();
	}

	@Override
	public int hashCode() {
		return marketId.hashCode();
	}
	
	public int compareTo(MarketResult mr) {
		float diff = mr.percent - this.percent;
		if (diff > 0) {
			return 1;
		} else if (diff < 0) {
			return -1;
		} else {
			return 0;
		}
	}
}
