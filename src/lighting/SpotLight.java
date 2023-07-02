package lighting;

import primitives.Color;
import primitives.Grid;
import primitives.Point;
import primitives.Vector;

import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;
/**
 * SpotLight class represents a spot light in a scene.
 */
public class SpotLight extends PointLight{
    private final Vector direction;

    private List<Point> grid = null;

    /**
     * Constructor that sets the light's intensity.
     *
     * @param intensity the light's intensity.
     * @param position  the light's position.
     * @param direction the light's direction.
     */
    public SpotLight(Color intensity, Point position, Vector direction) {
        super(intensity, position);
        this.direction = direction.normalize();
    }


    /**
     * Constructor that sets the light's intensity and radius.
     * @param intensity the light's intensity.
     * @param position the light's position.
     * @param direction the light's direction.
     * @param radius    the light's radius.
     */
    public SpotLight(Color intensity, Point position, Vector direction, double radius) {
        super(intensity, position, radius);
        this.direction = direction.normalize();
        Vector v = !(isZero(direction.getZ()) || isZero(direction.getY())) ? new Vector(0,direction.getZ(),-direction.getY()) :
                new Vector(0,1,1).normalize();
        if (radius == 0)
            grid = List.of(position);
        else
            grid = Grid.constructCircleGrid(Grid.getXY_SIZE(), position, radius,v, direction.crossProduct(v));
    }

    @Override
    public Color getIntensity(Point point) {
        double projection = alignZero(direction.dotProduct(getL(point)));
        return alignZero(projection) <= 0 ? Color.BLACK
                : super.getIntensity(point).scale(projection);
    }

    @Override
    public List<Point> getGrid(Vector v) {
        return grid;
    }
}
