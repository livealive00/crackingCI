package com.psh.crackingCI.ch05;

/**
 * Created by Naver on 2018. 5. 2..
 */
public class P04 {

	public static void main(String[] args) {
		int n = 13948;
		System.out.println(Integer.toBinaryString(n));
		System.out.println(Integer.toBinaryString(getPrev(n)));	// 11011010001111
		System.out.println(Integer.toBinaryString(getNext(n))); // 11011000111110
		System.out.println(Integer.toBinaryString(getPrev(31))); // 11011000111110
		System.out.println(Integer.toBinaryString(getNext(-1))); // 11011000111110
	}

	public static int getPrev(int n) {
		// 작은 수 중 큰수. 0이나오고 첫번째로 나오는 1을 0으로 교환
		int oneCnt = 0;
		boolean zeroDetected = false;
		int i;
		for (i = 0; i < Integer.SIZE; i++) {
			boolean v =  (n & (1 << i)) != 0;
			if (!v) { // 0
				zeroDetected = true;
			} else { // 1
				if (zeroDetected) {	// 0이 나온상태에서 첫번재로 발견된 1
					break;
				}
				oneCnt++;
			}
		}

		if (i == Integer.SIZE) {
			return -1; // impossible
		}

		// i 번째 비트를 0으로 바꿈
		int mask = ~(1 << i);
		int res = n & mask;

		// i 전까지 비트를 모두 0으로 바꾸고
		res = (res >>> i) << i;

		// i 다음부터 1을 (oncCnt+1)개 채워넣음
		int ones = (1 << i) - 1;
		int zeroShift = i - (oneCnt + 1);
		int fill = (ones >>> zeroShift) << zeroShift;

		return res | fill;
	}

	public static int getNext(int n) {
		// 큰 수중에 가장 작은 수. 1이 나오고 첫번재 나오는 0을 1로 바꾸고, oneCnt - 1 개를 오른쪽부터 채워 넣음.
		int oneCnt = 0;
		int i ;
		boolean oneDetected = false;
		for (i = 0; i < Integer.SIZE; i++) {
			boolean v = (n & (1 << i)) != 0;
			if (v) {
				oneDetected = true;
				oneCnt++;
			} else {
				if (oneDetected) {
					break;
				}
			}
		}

		if (i == Integer.SIZE) {
			return -1;
		}

		// i 번째 비트를 1 으로 세팅
		int res = n | (1 << i);
		// i 아래 비트를 모두 0으로 바꿈
		res = (res >>> i) << i;

		// 오른쪽 oneCnt -1 개를 1로 채워넣음
		int fill = (1 << (oneCnt-1)) -1;
		return res | fill;
	}
}
