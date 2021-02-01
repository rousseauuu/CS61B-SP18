public class Body {
    /* Helper methods to do the calculation. */
    public double xxPos;
    public double yyPos;
    public double xxVel;
    public double yyVel;
    public double mass;
    public String imgFileName;
    public static double G = 6.67e-11;


    public Body(double xP, double yP, double xV,
                double yV, double m, String img) {
        /* Constructor of a planet */
        this.xxPos = xP;
        this.yyPos = yP;
        this.xxVel = xV;
        this.yyVel = yV;
        this.mass = m;
        this.imgFileName = img;
    }


    public Body(Body b) {
        /* Constructor of a planet copy */
        this(b.xxPos, b.yyPos, b.xxVel, b.yyVel, b.mass, b.imgFileName);
    }

    public double calcDistance(Body b) {
        double deltaX = b.xxPos - this.xxPos;
        double deltaY = b.yyPos - this.yyPos;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }

    public double calcForceExertedBy(Body b) {
        double dis = this.calcDistance(b);
        return (this.mass * b.mass * G) / (dis * dis);
    }

    public double calcForceExertedByX(Body b) {
        double force = this.calcForceExertedBy(b);
        double dis = this.calcDistance(b);
        return force * (b.xxPos - this.xxPos) / dis;
    }

    public double calcForceExertedByY(Body b) {
        double force = this.calcForceExertedBy(b);
        double dis = this.calcDistance(b);
        return force * (b.yyPos - this.yyPos) / dis;
    }

    public double calcNetForceExertedByX(Body[] allBodys) {
        double netForceX = 0;
        for (Body b : allBodys) {
            if (!this.equals(b)) {
                netForceX += this.calcForceExertedByX(b);
            }
        }
        return netForceX;
    }

    public double calcNetForceExertedByY(Body[] allBodys) {
        double netForceY = 0;
        for (Body b : allBodys) {
            if (!this.equals(b)) {
                netForceY += this.calcForceExertedByY(b);
            }
        }
        return netForceY;
    }

    public void update(double t, double fx, double fy) {
        double ax = fx / this.mass;
        double ay = fy / this.mass;
        this.xxVel += ax * t;
        this.yyVel += ay * t;
        this.xxPos += this.xxVel * t;
        this.yyPos += this.yyVel * t;
    }

    public void draw() {
        String imgLocation = "images/" + imgFileName;
        StdDraw.picture(xxPos, yyPos, imgLocation);
    }

}

