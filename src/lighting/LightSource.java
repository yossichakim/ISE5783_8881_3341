package lighting;

import primitives.Color;
import primitives.Point;
import primitives.Vector;

import java.util.List;
/**
 * LightSource interface represents a light source in a scene.
 */
public interface LightSource {

    /**
     * Returns the intensity of the light at the given point.
     *
     * @param p The point to get the intensity at.
     * @return The intensity of the light at the given point.
     */
    Color getIntensity(Point p);

    /**
     * Returns the direction of the light at the given point.
     *
     * @param p The point to get the direction at.
     * @return The direction of the light at the given point.
     */
    Vector getL(Point p);

    /**
     * returns the distance of the light source
     *
     * @param point point to check the distance
     * @return distance of the light source
     */
    double getDistance(Point point);

    /**
     * returns a list of points that represent a grid of the light source
     *
     * @param v vector of the light source to the point on the geometry
     * @return list of points that represent a grid of the light source
     */
    List<Point> getGrid(Vector v);
}
