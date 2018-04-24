package com.psh.crackingCI.common;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Naver on 2018. 4. 20..
 */
public class GraphNode {
	public int id;
	public Set<GraphNode> children = new HashSet<>();

	public GraphNode(int id) {
		this.id = id;
	}
}
