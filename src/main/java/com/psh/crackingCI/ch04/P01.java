package com.psh.crackingCI.ch04;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import com.psh.crackingCI.common.GraphNode;

/**
 * Created by Naver on 2018. 4. 20..
 */
public class P01 {
	public static void main(String[] args) {
		GraphNode g1 = new GraphNode(1);
		GraphNode g2 = new GraphNode(2);
		GraphNode g3 = new GraphNode(3);
		GraphNode g4 = new GraphNode(4);
		GraphNode g5 = new GraphNode(5);

		g1.children.add(g2);
		g2.children.add(g3);
		g2.children.add(g4);
		g4.children.add(g5);

		System.out.println(hasPath(g1, g5));
		System.out.println(hasPath(g3, g5));
	}

	public static boolean hasPath(GraphNode start, GraphNode end) {
		Queue<GraphNode> queue = new ArrayDeque<>();
		Set<GraphNode> visit = new HashSet<>();
		queue.add(start);
		while (!queue.isEmpty()) {
			GraphNode n = queue.poll();
			visit.add(n);
			if (n == end) {
				return true;
			}
			for (GraphNode c : n.children) {
				if (!visit.contains(c)) {
					queue.add(c);
				}
			}
		}

		return false;
	}
}
