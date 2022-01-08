package assignment9;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import assignment9.scenes.Bubbles;
import assignment9.scenes.Circle;
import assignment9.scenes.Clear;
import assignment9.scenes.Forest;
import assignment9.scenes.Leaves;
import assignment9.scenes.Line;
import assignment9.scenes.Poly;
import assignment9.scenes.Sequence;
import assignment9.scenes.Square;
import assignment9.scenes.ifs.Dragon;
import assignment9.scenes.ifs.Leaf;
import assignment9.scenes.ifs.Tree;
import edu.princeton.cs.introcs.StdDraw;
import support.cse131.ArgsProcessor;

public class SceneComposer {

//Generate a bunch of objects that a drawer can draw --> forest, dragon, circle
	// recall will store everthing that the drawer can draw.
	// init -> create a scene that has a list of drawables

	public static void main(String[] args) {
		Map<String, Drawable> recalled = new HashMap<String, Drawable>(); // allows users to recall existing scenes and
																			// create new ones

		recalled.put("Bubbles", new Bubbles(10));
		recalled.put("Circle", new Circle(0.3, 0.3, 0.05));
		recalled.put("Forest", new Forest(4));
		recalled.put("Leaves", new Leaves(4));
		recalled.put("Line", new Line());
		recalled.put("Poly", new Poly(5));
		recalled.put("Square", new Square(0.15, 0.2, 0.05));
		recalled.put("Dragon", new Dragon(0.05, 0.3, 0.1));
		recalled.put("Leaf", new Leaf(0.28, 0.38, 0.04));
		recalled.put("Tree", new Tree(0.02, 0.02, 0.15));
		recalled.put("clear", new Clear());

		List<Drawable> list = new LinkedList<>();
		List<Integer> list1 = new LinkedList<>();
		
		list.add(new Tree(0.01, 0.02, 0.15));
		list.add(new Tree(0.3, 0.4, 0.15));
		list.add(new Leaves(10));
		list.add(new Dragon(0.35, 0.7, 0.18));
		list.add(new Square(0.4, 0.8, 0.1));

		Sequence sq = new Sequence(list);

		recalled.put("init", sq); // we first created the init scene and stored it in the map
		ArgsProcessor ap = new ArgsProcessor(args);

		// Note: Double Buffering is enabled!
		// You'll need to call show() to update the screen.
		// In most cases you'll want to call show() after you've drawn something
		StdDraw.enableDoubleBuffering();
		recalled.get("init").draw();

		StdDraw.show();

		while (true) {
			List<Drawable> another1 = new LinkedList<>();   //each time u iterate the linkedList becomes null
			String input = ap.nextString("express yourself");
			if (input.equals("clear")) {
				recalled.get("clear").draw();
			}
			if (input.equals("end")) {
				break;
			}
			if (input.equals("Bubbles")) {
				recalled.get("Bubbles").draw();
				StdDraw.show();

			}
			if (input.equals("Circle")) {
				recalled.get("Circle").draw();
				StdDraw.show();

			}
			if (input.equals("Forest")) {
				recalled.get("Forest").draw();
				StdDraw.show();

			}
			if (input.equals("Leaves")) {
				recalled.get("Leaves").draw();
				StdDraw.show();

			}

			if (input.equals("Line")) {
				recalled.get("Line").draw();
				StdDraw.show();

			}
			if (input.equals("Poly")) {
				recalled.get("Poly").draw();
				StdDraw.show();

			}
			if (input.equals("Square")) {
				recalled.get("Square").draw();
				StdDraw.show();

			}
			if (input.equals("Dragon")) {
				recalled.get("Dragon").draw();
				StdDraw.show();

			}
			if (input.equals("Leaf")) {
				recalled.get("Leaf").draw();
				StdDraw.show();

			}
			if (input.equals("Tree")) {
				recalled.get("Tree").draw();
				StdDraw.show();

			}
			if(recalled.containsKey(input)) {
				recalled.get(input).draw();
				StdDraw.show();
			}


			if (input.equals("record")) {
				String recordedInput = "";
				String nameOfScene = "";
				while (!recordedInput.equals("end recording")) {
					recordedInput = ap.nextString("Everything you say is recorded. Express yourself");
					
					if (recordedInput.equals("clear")) {
						recalled.get("clear").draw();
					}
					if (recordedInput.equals("end")) {
						break;
					}
					if (recordedInput.equals("Bubbles")) {
						recalled.get("Bubbles").draw();
						another1.add(new Bubbles(10));
						StdDraw.show();

					}
					if (recordedInput.equals("Circle")) {
						recalled.get("Circle").draw();
						another1.add(new Circle(0.3, 0.3, 0.05));
						StdDraw.show();

					}
					if (recordedInput.equals("Forest")) {
						recalled.get("Forest").draw();
						another1.add(new Forest(4));
						StdDraw.show();

					}
					if (recordedInput.equals("Leaves")) {
						recalled.get("Leaves").draw();
						another1.add(new Leaves(4));
						StdDraw.show();

					}

					if (recordedInput.equals("Line")) {
						recalled.get("Line").draw();
						another1.add(new Line());
						StdDraw.show();
					}
					if (recordedInput.equals("Poly")) {
						recalled.get("Poly").draw();
						another1.add(new Poly(5));
						StdDraw.show();
						StdDraw.show();

					}
					if (recordedInput.equals("Square")) {
						recalled.get("Square").draw();
						another1.add(new Square(0.15, 0.2, 0.05));
						StdDraw.show();

					}
					if (recordedInput.equals("Dragon")) {
						recalled.get("Dragon").draw();
						another1.add(new Dragon(0.05, 0.3, 0.1));
						StdDraw.show();
					}
					if (recordedInput.equals("Leaf")) {
						recalled.get("Leaf").draw();
						another1.add(new Leaf(0.28, 0.38, 0.04));
						StdDraw.show();

					}
					if (recordedInput.equals("Tree")) {
						recalled.get("Tree").draw();
						another1.add(new Tree(0.02, 0.02, 0.15));
						StdDraw.show();
					}
					if(recalled.containsKey(recordedInput)) {
						recalled.get(recordedInput).draw();
						another1.add(recalled.get(recordedInput));

						StdDraw.show();
					}

				}
				nameOfScene = ap.nextString("What do you want to call the Scene");
				Sequence newScene = new Sequence(another1);
				recalled.put(nameOfScene, newScene);
				
			}
		}

		//
		// for demo only, remove this code and write your own to do what
		// is needed for this assignment
//		while(true) {
//			StdDraw.show();
//			StdDraw.pause(10);
//			for (int i=0; i < 10; ++i) {
//				Forest f = new Forest(5);
//				f.draw(); f.draw(); f.draw(); f.draw();
//				Leaves l = new Leaves(5);
//				l.draw(); l.draw();
//			}
//			Bubbles b = new Bubbles(10);
//			b.draw();
//			StdDraw.show();
//			StdDraw.pause(10);
//			String resp = ap.nextString("Again?");
//			if (resp.equals("no")) {
//				break;
//			}
//			else {
//				new Clear().draw();
//			}
//		}
		//
		// end of demo code
		//
	}

}
