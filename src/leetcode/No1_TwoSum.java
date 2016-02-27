package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class No1_TwoSum {

	public int[] twoSum(int[] numbers, int target) {

		class Node {
			int value;
			int index;

			Node(int a, int b) {
				this.value = a;
				this.index = b;
			}
		}

		ArrayList<Node> N = new ArrayList<Node>();

		for (int i = 0; i < numbers.length; i++) {
			N.add(new Node(numbers[i], i));
		}

		int[] index = new int[2];

		Collections.sort(N, new Comparator<Node>() {
			public int compare(Node N1, Node N2) {
				return N1.value - N2.value;
			}
		});

		for (int i = 0; i < numbers.length; i++)
			System.out.println(N.get(i).value);

		boolean flag = true;
		int left = 0;
		int right = numbers.length - 1;
		while (flag) {
			if (left == right)
				break;
			if (N.get(left).value + N.get(right).value == target) {
				flag = false;
				index[0] = N.get(left).index + 1;
				index[1] = N.get(right).index + 1;
				break;

			} else if (N.get(left).value + N.get(right).value < target)
				left++;
			else
				right--;
		}

		if (index[0] > index[1]) {
			int temp = index[0];
			index[0] = index[1];
			index[1] = temp;
		}

		return index;
	}

	public static void main(String[] args) {

		int[] numbers = { -1, -2, -3, -4, -5 };
		int target = -8;
		int[] index = new No1_TwoSum().twoSum(numbers, target);

		System.out.println(index[0] + " " + index[1]);

	}

}
