package utility;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;


import datastructures.map.EntryComparator;
import datastructures.map.PriorityMap;


public final class LoadBalancerPriorityMap<k> implements LoadBalancer<k>{
	private static LoadBalancer loadBalObject;
	
	PriorityMap<k,Integer> loadMappings;
	
	int maxLoad;
	
	private LoadBalancerPriorityMap(int maxLoad){
		this.maxLoad=maxLoad;
		Comparator cmp = new EntryComparator<String,Integer>(true);
		loadMappings = new PriorityMap<k,Integer>(cmp);
	}
	
	public static LoadBalancer getLoadBalancer(int maxLoad){
		if(loadBalObject==null){
			loadBalObject=new LoadBalancerPriorityMap(maxLoad);
			return loadBalObject;
		}else{
			return loadBalObject;
		}
	}
	
	@Override
	public void addInitialLoad(k key , int load){
		loadMappings.put(key, load);
	}
	
	@Override
	public void reduceLoad(k env , int reduceAmt){
		int load = loadMappings.get(env);
		loadMappings.put(env, load-reduceAmt);
	}


	@Override
	public k addLoad(int load) {
		Entry<k,Integer> leastLoadEnv = loadMappings.peek();
		k key=leastLoadEnv.getKey();
		int keyload=leastLoadEnv.getValue();
		loadMappings.put(key,keyload+load);
		return key;
		//
		
	}

	@Override
	public void addInitialLoads(Iterable<k> keys, int load) {
		keys.forEach(f -> loadMappings.put(f, load));
		
	}

}
