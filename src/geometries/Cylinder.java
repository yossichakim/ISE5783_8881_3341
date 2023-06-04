package geometries;

import primitives.Point;
import primitives.Ray;
import primitives.Vector;

import java.util.List;

import static primitives.Util.isZero;

/**
 * The Cylinder class represents a cylinder shape in 3D space.
 * A cylinder is defined by a tube with a given radius and an axis ray,
 * and an additional height parameter that determines the cylinder's height.
 */
public class Cylinder extends Tube {

    /**
     * Cylinder height
     */
    private final double height;

    /**
     * Constructs a Cylinder with a given radius, axis Ray and height.
     *
     * @param radius  The cylinder radius
     * @param axisRay The cylinder axis Ray
     * @param height  The cylinder height
     */
    public Cylinder(double radius, Ray axisRay, double height) {
        super(radius, axisRay);
        this.height = height;
    }

    /**
     * Returns the normal to the cylinder surface at a given point.
     *
     * @param point The point to calculate the normal at
     * @return The normal vector to the cylinder surface at the given point
     */
    @Override
    public Vector getNormal(Point point) {
        Point o1 = axisRay.getP0();//middle of first end
        Point o2 = o1.add(axisRay.getDir().scale(height));//middle of second end

        if (isZero(point.subtract(o1).dotProduct(axisRay.getDir()))) {
            return axisRay.getDir().scale(-1).normalize();

        } else if (isZero(point.subtract(o2).dotProduct(axisRay.getDir()))) {
            return axisRay.getDir().scale(1).normalize();

        }
        return super.getNormal(point);
    }

    /**
     * @param ray the ray
     * @return list of intersection points
     */
    @Override
    public List<GeoPoint> findGeoIntersectionsHelper(Ray ray) {
        return null;
    }
}
