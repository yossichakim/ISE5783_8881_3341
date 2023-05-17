package geometries;

import primitives.Point;
import primitives.Ray;

import java.util.LinkedList;
import java.util.List;

public class Geometries implements Intersectable {

    /**
     * The geometries.
     */
    private final List<Intersectable> geometriesList = new LinkedList<>();

    /**
     * Constructs a geometries object from a list of geometries.
     */
    public Geometries() {
    }

    /**
     * Constructs a geometries object from a list of geometries.
     *
     * @param geometries The geometries.
     */
    public Geometries(Intersectable... geometries) {
        add(geometries);
    }

    /**
     * Adds geometries to the geometries list.
     *
     * @param geometries The geometries to add.
     */
    public void add(Intersectable... geometries) {
        this.geometriesList.addAll(List.of(geometries));
    }

    /**
     * Find intersections list.
     *
     * @param ray the ray
     * @return the list of intersection points
     */
    @Override
    public List<Point> findIntersections(Ray ray) {
        List<Point> intersections = null;
        for (var geometry : geometriesList) {
            var geometryIntersections = geometry.findIntersections(ray);
            if (geometryIntersections != null) {
                if (intersections == null) intersections = new LinkedList<>();
                intersections.addAll(geometryIntersections);
            }
        }
        return intersections;
    }
}