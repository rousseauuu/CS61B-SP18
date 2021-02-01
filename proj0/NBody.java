public class NBody {
    public static double readRadius(String path) {
        In in = new In(path);
        int plantNum = in.readInt();
        double radius = in.readDouble();
        return radius;
    }

    public static Body[] readBodies(String path) {
        In in = new In(path);
        int plantNum = in.readInt();
        in.readDouble();
        Body[] Bodies = new Body[plantNum];
        int index = 0;
        while (index != plantNum) {
            double xP = in.readDouble();
            double yP = in.readDouble();
            double xV = in.readDouble();
            double yV = in.readDouble();
            double m  = in.readDouble();
            String img = in.readString();
            Bodies[index++] = new Body(xP, yP, xV, yV, m, img);
        }
        return Bodies;
    }

    /**
     * arg[0]   T
     * arg[1]   dt
     * arg[2]   filename
     * Radius   the scale of the picture
     * Bodies   arrays of the object body
     */
    public static void main(String[] args) {
        Double T = Double.valueOf(args[0]);
        Double dt = Double.valueOf(args[1]);
        String fileName = args[2];
        double radius = NBody.readRadius(fileName);
        Body[] Bodies = NBody.readBodies(fileName);

        StdDraw.setScale(-radius, radius);
        StdDraw.clear();
        String background = "images/starfield.jpg";
        StdDraw.picture(0, 0, background);

        for (Body b : Bodies) {
            b.draw();
        }

        double time = 0;
        while (time < T) {
            double[] xForces = new double[Bodies.length];
            double[] yForces = new double[Bodies.length];
            for (int i = 0; i < xForces.length; ++i) {
                xForces[i] = Bodies[i].calcNetForceExertedByX(Bodies);
                yForces[i] = Bodies[i].calcNetForceExertedByY(Bodies);
            }
            for (int i = 0; i < xForces.length; ++i) {
                Bodies[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.picture(0, 0, background);

            for (Body b : Bodies) {
                b.draw();
            }

            StdDraw.show();
            StdDraw.pause(10);
            time += dt;
        }
        StdDraw.show();
    }

}

