package com.psh.crackingCI.ch08;

import java.util.Comparator;
import java.util.List;

import com.google.common.collect.Lists;
import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * Created by Naver on 2018. 6. 4..
 */
public class P13 {

	public static void main(String[] args) {
		List<Box> boxes = Lists.newArrayList(
			new Box(10, 9, 9),
			new Box(5, 7, 8),
			new Box(11, 3, 3),
			new Box(4, 6, 6));

		boxes.sort(Comparator.comparing(Box::getHeight, Comparator.reverseOrder()));

		System.out.println(getMaxStackHeight(boxes));
	}

	public static int getMaxStackHeight(List<Box> boxes) {
		int max = 0;
		for (int i = 0; i < boxes.size(); i++) {
			max = Math.max(max, getMaxStackHeight(boxes, i));
		}
		return max;
	}

	public static int getMaxStackHeight(List<Box> boxes, int idx) {
		Box bottom = boxes.get(idx);
		int max = 0;
		for (int i = idx+1; i < boxes.size(); i++) {
			Box cand = boxes.get(i);
			if (cand.getDepth() <= bottom.getDepth() && cand.getWidth() <= bottom.getWidth()) {
				int candMax = getMaxStackHeight(boxes, i);
				max = Math.max(max, candMax);
			}
		}
		max += bottom.getHeight();
		return max;
	}

	@AllArgsConstructor
	@Getter
	static class Box {
		int height;
		int width;
		int depth;
	}
}

