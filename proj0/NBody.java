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
}
