package com.psh.crackingCI.ch08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.collect.Lists;

/**
 * Created by Naver on 2018. 5. 24..
 */
public class P02 {
	public static void main(String[] args) {
		int[][] maze = makeMaze(5,3);
		for (int i = 0; i < maze.length; i++) {
			System.out.println(Arrays.toString(maze[i]));
		}
		System.out.println(findPath(maze));

	}

	public static List<Pair<Integer, Integer>> findPath(int[][] maze) {
		int rowLen = maze.length;
		int colLen = maze[0].length;
		boolean[][] visited = new boolean[rowLen][colLen];
		Stack<Point> stack = new Stack<>();


		stack.push(new Point(0, 0, Lists.newArrayList()));
		visited[0][0] = true;

		while (!stack.isEmpty()) {
			Point p = stack.pop();
			if (p.r == rowLen-1 && p.c == colLen-1) {
				return p.path;
			}

			if (p.r+1 < rowLen
				&& maze[p.r+1][p.c] == 0
				&& !visited[p.r+1][p.c]) {

				stack.push(new Point(p.r+1, p.c, p.path));
				visited[p.r+1][p.c] = true;
			}

			if (p.c+1 < colLen
				&& maze[p.r][p.c+1] == 0
				&& !visited[p.r][p.c+1]) {

				stack.push(new Point(p.r, p.c+1, p.path));
				visited[p.r][p.c+1] = true;
			}
		}

		return null;
	}

	public static int[][] makeMaze(int r, int c) {
		int[][] maze = new int[r][c];

		// make block
		for (int i = 0; i < r; i++) {
			for (int j = 0; j < c; j++) {
				if (Math.random() < 0.3) {
					maze[i][j] = 1;
				}
			}
		}

		maze[0][0] = 0;
		maze[r-1][c-1] = 0;

		return maze;
	}
}

class Point {
	int r;
	int c;
	List<Pair<Integer, Integer>> path;

	public Point(int r, int c, List<Pair<Integer,Integer>> beforePath) {
		this.r = r;
		this.c = c;
		List<Pair<Integer, Integer>> newPath = new ArrayList<>(beforePath);
		newPath.add(Pair.of(r, c));
		this.path = newPath;
	}

}