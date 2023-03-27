package geometries;

import primitives.*;

/**
 * Represents a tube in 3D space.
 */
public class Tube extends RadialGeometry{

    /**
     * The axis ray of the tube.
     */
    protected Ray axisRay;

    /**
     * Constructs a tube with a given radius and axis ray.
     *
     * @param radius The radius of the tube.
     * @param axisRay The axis ray of the tube.
     */
    public Tube(double radius, Ray axisRay) {
        super(radius);
        this.axisRay = axisRay;
    }

    /**
     * Gets the normal vector to the tube at a given point.
     *
     * @param point The point at which to get the normal vector.
     * @return The normal vector to the tube at the given point.
     */
    @Override
    public Vector getNormal(Point point) {
        return null;
    }
}