package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.List;

/**
 * Represents a triangle in 3D space.
 */
public class Triangle extends Polygon {

    /**
     * Constructs a triangle with the given vertices.
     *
     * @param p1 The first vertex of the triangle.
     * @param p2 The second vertex of the triangle.
     * @param p3 The third vertex of the triangle.
     */
    public Triangle(Point p1, Point p2, Point p3) {
        super(p1, p2, p3);
    }

    /**
     * @param ray the ray
     * @return list of intersection points
     * @see Polygon#findIntersections(Ray)
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        return super.findIntersections(ray);
    }
}
