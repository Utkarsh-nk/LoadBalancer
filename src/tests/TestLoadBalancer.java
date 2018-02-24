package tests;

import utility.LoadBalancerPriorityMap;

public class TestLoadBalancer {
	public static void main(String[] args){
		LoadBalancerPriorityMap envs = LoadBalancerPriorityMap.getLoadBalancer(0);
		String e1 = envs.getLeastLoadItem();
		System.out.println(e1);
		String e2 = envs.getLeastLoadItem();
		System.out.println(e2);
		String e3 = envs.getLeastLoadItem();
		System.out.println(e3);
		String e4 = envs.getLeastLoadItem();
		System.out.println(e4);
		String e5 = envs.getLeastLoadItem();
		System.out.println(e5);
		String e6 = envs.getLeastLoadItem();
		System.out.println(e6);
		String e7 = envs.getLeastLoadItem();
		System.out.println(e7);
		String e8 = envs.getLeastLoadItem();
		System.out.println(e8);
		String e9 = envs.getLeastLoadItem();
		System.out.println(e1);
		envs.reduceLoad(e9);
		e1 = envs.getLeastLoadItem();
		System.out.println(e1);
	}
}
