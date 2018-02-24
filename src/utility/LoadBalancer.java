package utility;

public interface LoadBalancer<k> {
	
	public k addLoad(int load);
	
	public void addInitialLoads(Iterable<k> keys, int load);
	
	public void addInitialLoad(k key, int load);
	
	public void reduceLoad(k key , int load);
}
