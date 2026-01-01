/** Draws ths Sierpinski Triangle fractal. */
public class Sierpinski {
	
	public static void main(String[] args) {
		sierpinski(Integer.parseInt(args[0]));
	}
	
	// Draws a Sierpinski triangle of depth n on the standard canvass.
	public static void sierpinski (int n) {
	StdDraw.setScale(0, 1);
    StdDraw.clear(StdDraw.WHITE);
	
	double x1 = 0.05, y1 = 0.05;   // left-bottom
    double x2 = 0.95, y2 = 0.05;   // right-bottom
    double x3 = 0.50, y3 = 0.90;   // top

    // Draw the outer triangle in black
    StdDraw.setPenColor(StdDraw.BLACK);
    StdDraw.line(x1, y1, x2, y2);
    StdDraw.line(x2, y2, x3, y3);
    StdDraw.line(x3, y3, x1, y1);

    // Do the recursive "holes"
    sierpinski(n, x1, x2, x3, y1, y2, y3);
}
	
	
	// Does the actual drawing, recursively.
	private static void sierpinski(int n, double x1, double x2, double x3,
		                                 double y1, double y2, double y3) {
	if (n == 0) return;

    // Midpoints of the triangle edges
    double mx12 = (x1 + x2) / 2.0;
    double my12 = (y1 + y2) / 2.0;

    double mx23 = (x2 + x3) / 2.0;
    double my23 = (y2 + y3) / 2.0;

    double mx31 = (x3 + x1) / 2.0;
    double my31 = (y3 + y1) / 2.0;

    // "Remove" the middle inverted triangle by drawing it in white
    StdDraw.setPenColor(StdDraw.WHITE);
    StdDraw.line(mx12, my12, mx23, my23);
    StdDraw.line(mx23, my23, mx31, my31);
    StdDraw.line(mx31, my31, mx12, my12);

    // Recurse on the 3 corner triangles
    sierpinski(n - 1, x1, mx12, mx31, y1, my12, my31);
    sierpinski(n - 1, mx12, x2, mx23, my12, y2, my23);
    sierpinski(n - 1, mx31, mx23, x3, my31, my23, y3);
	}
}
