package com.dsa.recursion.subsequence.p3;

import java.util.ArrayList;
import java.util.List;

public class Solve {
	
	public static void main(String[] args) {
		
		final String s = "abc";
		List<String> result = new ArrayList<>();
		dfs(0,"",s,result);
		
		System.out.println(result);
	}
	
	private static void dfs(final int index, final String s, final String str,
			final List<String> result) {
		
		// base case
		if(index>=str.length()){
			
			if(!s.isEmpty()){
				result.add(s);
			}
			
			return;
		}
		
		// take ==> s+str.charAt(index)
		dfs(index+1,s+str.charAt(index),str,result);
		// not take ==> s
		dfs(index+1,s,str,result);
	}
}
