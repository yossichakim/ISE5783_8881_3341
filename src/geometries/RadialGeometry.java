package geometries;

public abstract class RadialGeometry implements Geometry {

    protected double radius;

    /***
     *
      * @param radius
     */
    public RadialGeometry(double radius){
        this.radius=radius;
    }
}
