package com.chocohead.nsn;

public class Maths {
	public static int floorMod(long x, int y) {
		return (int) Math.floorMod(x, (long) y);
	}

	public static strictfp float fma(float a, float b, float c) {
		return (float) fma((double) a, (double) b, (double) c);
	}

	public static strictfp double fma(double a, double b, double c) {
		return a * b + c; //This isn't strictly right as it lacks the infinite precision of true FMA
	}

	public static int powExact(int x, int n) {
		if (n < 0) throw new ArithmeticException("negative exponent");
		if (n == 0) return 1;
		if (x == 0 || x == 1) return x;
		if (x == -1) return (n & 1) != 0 ? -1 : 1;

		int result = 1;
		while (n > 1) {
			if ((n & 1) != 0) result *= x;
			x = Math.multiplyExact(x, x);
			n >>>= 1;
		}
		return Math.multiplyExact(result, x);
	}

	public static long powExact(long x, int n) {
		if (n < 0) throw new ArithmeticException("negative exponent");
		if (n == 0) return 1;
		if (x == 0 || x == 1) return x;
		if (x == -1) return (n & 1) != 0 ? -1 : 1;

		long result = 1;
		while (n > 1) {
			if ((n & 1) != 0) result *= x;
			x = Math.multiplyExact(x, x);
			n >>>= 1;
		}
		return Math.multiplyExact(result, x);
	}

	public static int clamp(int value, int min, int max) {
		return Math.max(min, Math.min(max, value));
	}

	public static long clamp(long value, long min, long max) {
		return Math.max(min, Math.min(max, value));
	}

	public static float clamp(float value, float min, float max) {
		return Math.max(min, Math.min(max, value));
	}

	public static double clamp(double value, double min, double max) {
		return Math.max(min, Math.min(max, value));
	}
}
