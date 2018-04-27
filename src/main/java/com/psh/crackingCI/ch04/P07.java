package com.psh.crackingCI.ch04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

/**
 * Created by Naver on 2018. 4. 25..
 */
public class P07 {

	public static void main(String[] args) {
		List<String> projects = Lists.newArrayList("a", "b", "c", "d", "e");
		List<Pair<String, String>> dependancies = Lists.newArrayList(
			Pair.of("a", "b"),
			Pair.of("c", "a"),
			Pair.of("d", "b"),
			Pair.of("c", "d")
		);

		System.out.println(getEliegibleExeOrder(projects, dependancies));
	}

	public static List<String> getEliegibleExeOrder(List<String> projects, List<Pair<String, String>> dependancies) {
		Map<String, Set<String>> inEdges = new HashMap<>();
		Map<String, Set<String>> outEdges = new HashMap<>();
		for (String p : projects) {
			inEdges.put(p, new HashSet<>());
			outEdges.put(p, new HashSet<>());
		}

		for (Pair<String, String> d : dependancies) {
			inEdges.get(d.getRight()).add(d.getLeft());
			outEdges.get(d.getLeft()).add(d.getRight());
		}

		List<String> order = new ArrayList<>();
		while (!inEdges.isEmpty()) {
			Iterator<Map.Entry<String, Set<String>>> it = inEdges.entrySet().iterator();
			boolean removed = false;
			while (it.hasNext()) {
				Map.Entry<String, Set<String>> e = it.next();
				if (e.getValue().isEmpty()) {
					String p = e.getKey();
					order.add(p);
					for (String toPrj : outEdges.get(p)) {
						inEdges.get(toPrj).remove(p);
					}
					it.remove();
					removed = true;
				}
			}
			if (!removed) {
				throw new RuntimeException("infinite loop");
			}
		}
		return order;
	}
}
