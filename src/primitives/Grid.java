package primitives;

import java.util.LinkedList;
import java.util.List;

import static primitives.Util.alignZero;
import static primitives.Util.isZero;

/**
 * The type Grid - represents a grid in the scene.
 */
public abstract class Grid {
    
    private static final int XY_SIZE = 17;

    /**
     * Gets the size of the grid.
     * @return the size of the grid
     */
    public static int getXY_SIZE() {
        return XY_SIZE;
    }


    /**
     * Construct a grid of points on a circle.
     * @param xy the number of points on the circle
     * @param center the center of the circle
     * @param radius the radius of the circle
     * @param vUp the up vector
     * @param vRight the right vector
     * @return a list of points on the circle
     */
    public static List<Point> constructCircleGrid(int xy, Point center, double radius, Vector vUp, Vector vRight) {

        if (xy < 1)
            throw new IllegalArgumentException("xy must be over than 0");
        else {
            if ((xy == 1) || (isZero(radius)))
                return List.of(center);
        }
        
        List<Point> result = new LinkedList<>();
        
        Point pIJ;
        double rxy = (2 * radius) / xy;
        double yI, xJ;

        for (int i = 0; i < xy; i++) {
            for (int j = 0; j < xy; j++) {
                yI = alignZero((i - (xy - 1) / 2.0) * rxy);
                xJ = alignZero((j - (xy - 1) / 2.0) * rxy);

                pIJ = center;
                if (xJ != 0) pIJ = pIJ.add(vRight.scale(xJ));
                if (yI != 0) pIJ = pIJ.add(vUp.scale(yI));

                if (pIJ.distanceSquared(center) <= radius * radius)
                    result.add(pIJ);
            }
        }
        return result;
    }
}
