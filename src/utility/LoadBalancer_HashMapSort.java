package utility;

import java.util.Collections;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import datastructures.map.EntryComparator;

public class LoadBalancer_HashMapSort<k> implements LoadBalancer<k>{
	
	private static LoadBalancer_HashMapSort loadBalObject;
	
	HashMap<k,Integer> loadMappings;
	int maxLoad;
	
	private LoadBalancer_HashMapSort(int maxLoad){
		this.maxLoad=maxLoad;
		loadMappings = new HashMap<k,Integer>();
	}
	
	public static LoadBalancer getLoadBalancer(int maxLoad){
		if(loadBalObject==null){
			return new LoadBalancer_HashMapSort(maxLoad);
		}else{
			return loadBalObject;
		}
	}
	
	
	 private  List<Entry<k, Integer>> sortByComparator(Map<k, Integer> unsortMap, final boolean order)
	    {
	        List<Entry<k, Integer>> list = new LinkedList<Entry<k, Integer>>(unsortMap.entrySet());
	        // Sorting the list based on values
	        Collections.sort(list,new EntryComparator(true));
	        return list;
	    }

	@Override
	public k addLoad(int load) {
		List<Entry<k, Integer>> sortedMapAsc = sortByComparator(loadMappings, true);
		int leastload =loadMappings.get(sortedMapAsc.get(0).getKey());
		loadMappings.put(sortedMapAsc.get(0).getKey() , leastload+load);
		return sortedMapAsc.get(0).getKey();
	}

	@Override
	public void addInitialLoads(Iterable<k> keys, int load) {
		keys.forEach(f -> loadMappings.put(f, load));
		
	}

	@Override
	public void addInitialLoad(k key, int load) {
		loadMappings.put(key, load);
		
	}

	@Override
	public void reduceLoad(k key, int load) {
		int keyload = loadMappings.get(key);
		loadMappings.put(key, keyload-load);
		
	}


}
