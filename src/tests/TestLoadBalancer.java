package tests;

import java.util.Arrays;

import utility.LoadBalancer;
import utility.LoadBalancerPriorityMap;
import utility.LoadBalancer_HashMapSort;

public class TestLoadBalancer {
	public static void main(String[] args){
		
		//testUsingPriorityMap();
		testUsingHashMapSort();
		
	}
	
	public static void testUsingPriorityMap(){
		LoadBalancer<String> envs = LoadBalancerPriorityMap.getLoadBalancer(0);
		String envsString="a,b,c,d";
		envs.addInitialLoads(Arrays.asList(envsString.split(",")), 0);
		String e1 = envs.addLoad(1);
		System.out.println(e1);
		String e2 = envs.addLoad(1);
		System.out.println(e2);
		String e3 = envs.addLoad(1);
		System.out.println(e3);
		String e4 = envs.addLoad(1);
		System.out.println(e4);
		String e5 = envs.addLoad(1);
		System.out.println(e5);
		String e6 = envs.addLoad(1);
		System.out.println(e6);
		String e7 = envs.addLoad(1);
		System.out.println(e7);
		String e8 = envs.addLoad(1);
		System.out.println(e8);
		String e9 = envs.addLoad(1);
		System.out.println(e1);
		envs.reduceLoad(e9 , 1);
		e1 = envs.addLoad(1);
		System.out.println(e1);
	}
	
	public static void testUsingHashMapSort(){

		LoadBalancer<String> envs = LoadBalancer_HashMapSort.getLoadBalancer(0);
		String envsString="a,b,c,d";
		envs.addInitialLoads(Arrays.asList(envsString.split(",")), 0);
		String e1 = envs.addLoad(1);
		System.out.println(e1);
		String e2 = envs.addLoad(1);
		System.out.println(e2);
		String e3 = envs.addLoad(1);
		System.out.println(e3);
		String e4 = envs.addLoad(1);
		System.out.println(e4);
		String e5 = envs.addLoad(1);
		System.out.println(e5);
		String e6 = envs.addLoad(1);
		System.out.println(e6);
		String e7 = envs.addLoad(1);
		System.out.println(e7);
		String e8 = envs.addLoad(1);
		System.out.println(e8);
		String e9 = envs.addLoad(1);
		System.out.println(e1);
		envs.reduceLoad(e9 , 1);
		e1 = envs.addLoad(1);
		System.out.println(e1);
	
		
	}
	
	
}
