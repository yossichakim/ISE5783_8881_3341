package lighting;

import primitives.Color;
import primitives.Grid;
import primitives.Point;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

/**
 * PointLight class represents a point light in a scene.
 */
public class PointLight extends Light implements LightSource{
    private final Point position;
    private final double radius;
    private double kC = 1;
    private double kL = 0;
    private double kQ = 0;

    /**
     * Constructor that sets the light's intensity.
     *
     * @param intensity the light's intensity.
     * @param position  the light's position.
     */
    public PointLight(Color intensity, Point position) {
        super(intensity);
        this.position = position;
        this.radius = 0.0;
    }


    /**
     * Constructor that sets the light's intensity and radius.
      * @param intensity the light's intensity.
     * @param position the light's position.
     * @param radius the light's radius.
     */
    public PointLight(Color intensity, Point position, double radius) {
        super(intensity);
        this.position = position;
        this.radius = radius;
    }

    /**
     * setter for kC
     *
     * @param kC - new value for kC
     * @return this PointLight for builder pattern
     */
    @SuppressWarnings("unused")
    public PointLight setKc(double kC) {
        this.kC = kC;
        return this;
    }

    /**
     * setter for kL
     *
     * @param kL - new value for kL
     * @return this PointLight for builder pattern
     */
    public PointLight setKl(double kL) {
        this.kL = kL;
        return this;
    }

    /**
     * setter for kQ
     *
     * @param kQ - new value for kQ
     * @return this PointLight for builder pattern
     */
    public PointLight setKq(double kQ) {
        this.kQ = kQ;
        return this;
    }

    @Override
    public Color getIntensity(Point point) {
        double dis = position.distanceSquared(point);
        return intensity.reduce(kC + kL * Math.sqrt(dis) + kQ * dis);
    }

    @Override
    public Vector getL(Point point) {
        return point.subtract(position).normalize();
    }

    @Override
    public double getDistance(Point point) {
        return point.distance(position);
    }

    @Override
    public List<Point> getGrid(Vector v) {
        if (isZero(radius)){
            return List.of(position);
        }else {
            Vector v2 = !(isZero(v.getZ()) || isZero(v.getY())) ? new Vector(0,v.getZ(),-v.getY()) :
                    new Vector(0,1,1).normalize();
            return Grid.constructCircleGrid(Grid.getXY_SIZE(), position, radius, v2, v2.crossProduct(v).normalize());
        }
    }
}
