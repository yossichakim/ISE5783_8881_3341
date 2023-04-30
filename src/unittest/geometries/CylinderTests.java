package geometries;

/**
 * Unit tests for geometries.Cylinder class
 * @author Benjamin Machlev and Yossi Chakim
 */
/*
class CylinderTests {

    /**
     * Test method for {@link geometries.Polygon#getNormal(primitives.Point)}.
     */
    /*
    @Test
    /*
    public void testGetNormal() {
        // ============ Equivalence Partitions Tests ==============
        // TC01: There is a simple single test here
        Cylinder pl =new Cylinder(new Ray(new Point(0,0,0),new Vector(0,0,1)), 1, 2 ) ;
       //checks if this is in the side
        assertEquals(new Vector(0, 0, 1), pl.getNormal(new Point(0, 1, 0)), "Bad normal to Cylinder");
       //checks if this is in the down base
        assertEquals(new Vector(0, 0, 1), pl.getNormal(new Point(0, 1, 2)), "Bad normal to Cylinder");

       //checks if this is in the up base
        assertEquals(new Vector(0, 1, 0), pl.getNormal(new Point(0, 1, 1)), "Bad normal to Cylinder");


        // =============== Boundary Values Tests ==================
        //checks if this is in the down base center
        assertEquals(new Vector(0, 0, 1), pl.getNormal(new Point(0, 0, 0)), "Bad normal to Cylinder");
        //checks if this is in the up base center
        assertEquals(new Vector(0, 0, 1), pl.getNormal(new Point(0, 0, 2)), "Bad normal to Cylinder");

    }

}*/