package hu.helixlab.simple;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.RandomUtils;

/**
 * Java basics (this is a javadoc comment)
 * 
 * @author erbalazs
 */
public class S1 {

	private static int m2(int p) {
		return 2 * p;
	}

	public static void m1() {

		// normal comment

		// ------------------------

		/*
		 * 
		 * normal comment
		 * 
		 */

		// ------------------------

		/*
		 * 
		 * // this is a comment
		 * 
		 */

		// ------------------------

		/// *

		String s = "this is not a comment";

		// */

		// ------------------------

		{

			int x = 10;

			if (x < 15) {
				System.out.println("x (bigger): " + x);
			} else {
				System.out.println("x (not bigger): " + x);
			}

		}

		// ------------------------

		{

			for (int i = 0; i < 10; ++i) {
				System.out.println("i (loop): " + i);
			}

		}

		// ------------------------

		{
			int k = 3;
			int r = m2(k);

			System.out.println("r: " + r);
		}

		// ------------------------

		{

			List<Integer> list = new ArrayList<>();
			list.add(3);
			list.add(2);
			list.add(RandomUtils.nextInt(7, 10));

			for (Integer l : list) {
				int t = l.intValue();
				System.out.println("list element: " + t);
			}

		}

	}

}
