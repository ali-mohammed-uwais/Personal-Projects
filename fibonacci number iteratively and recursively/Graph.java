package fibonacci;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class Graph {
	private static void graphLine(int[] ys) {

	for(int i = 0; i < ys.length - 1; i++ ) {
		int xPoint = i;
		int yPoint = ys[i];
		int xNextPoint = i + 1;
		int yNextPoint = ys[i+1];
		StdDraw.point(xPoint, yPoint);
		StdDraw.line(xPoint, yPoint, xNextPoint, yNextPoint);
		
		
	}
	
	
	
	}
 
	public static void graphLines(int n, Color aColor, String aTitle, int[] aTimes, Color bColor, String bTitle,
			int[] bTimes) {
		int xMax = n - 1;
		int yMax = max(aTimes, bTimes);
		updateXscale(xMax);
		updateYscale(yMax);
		drawAxes(xMax, yMax);

		double xTextRecursive = xMax * 0.2;
		double xTextIterative = xMax * 0.7;
		double yText = -yMax * 0.05;
		StdDraw.textLeft(xTextRecursive, yText, aTitle);
		StdDraw.textLeft(xTextIterative, yText, bTitle);

		StdDraw.setPenRadius(StdDraw.getPenRadius() * 4.0);

		StdDraw.setPenColor(bColor);
		StdDraw.line(xMax / 2, yText, xTextIterative - 1, yText);
		graphLine(bTimes);

		StdDraw.setPenColor(aColor);
		StdDraw.line(0, yText, xTextRecursive - 1, yText);
		graphLine(aTimes);
	}

	private static void drawAxes(int xMax, int yMax) {
		StdDraw.setPenColor(0, 0, 0);
		StdDraw.line(0, 0, xMax, 0);
		StdDraw.line(0, 0, 0, yMax);
	}

	private static void updateXscale(int max) {
		double pad = padding(max);
		StdDraw.setXscale(-pad, max + pad);
	}

	private static void updateYscale(int max) {
		double pad = padding(max);
		StdDraw.setYscale(-pad, max + pad);
	}

	private static int max(int[] as, int[] bs) {
		int max = Integer.MIN_VALUE;
		for (int v : as) {
			max = Math.max(max, v);
		}
		for (int v : bs) {
			max = Math.max(max, v);
		}
		return max;
	}

	private static double padding(int max) {
		return max * 0.1;
	}

	public static void main(String[] args) {
		int n = 16;

		double theta = 0.0;
		double deltaTheta = Math.PI / (n - 1);

		int[] as = new int[n];
		int[] bs = new int[n];
		for (int i = 0; i < n; ++i) {
			as[i] = 100 + (int) (Math.sin(theta) * 1000);
			bs[i] = 1200 + (int) (Math.cos(Math.PI / 2 + theta) * 1000);
			theta += deltaTheta;
		}

		graphLines(n, new Color(0, 146, 146), "a", as, new Color(0xdb6d00), "b", bs);
	}
}
