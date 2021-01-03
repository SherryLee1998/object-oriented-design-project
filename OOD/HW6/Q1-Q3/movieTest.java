package com.company;
import static org.junit.Assert.*;
import org.junit.*;

public class movieTest {
    private Movie movie1;
    private Action action1;
    private Comedy comedy1;
    private Drama drama1;

    @Before
    public void setUp() throws Exception {
        movie1 = new Movie("G","M001","Titanic");
        action1 = new Action ("PG-13","A002","Terminator");
        comedy1 = new Comedy("R","M001","Crouching Tiger, Hidden Dragon");
        drama1 = new Drama("PG-13","D0074","Phantom of the Opera");
    }

    @Test
    public void getType(){
        assertEquals("G", movie1.getRank());
        assertEquals("PG-13",action1.getRank());
        assertEquals("R", comedy1.getRank());
        assertEquals("PG-13", drama1.getRank());
    }

    @Test
    public void getTitle(){
        assertEquals("Titanic", movie1.getTitle());
        assertEquals("Terminator", action1.getTitle());
    }

    @Test
    public void getId_number(){
        assertEquals("M001", movie1.getId_number());
        assertEquals("A002",action1.getId_number());
        assertEquals("M001",comedy1.getId_number());
        assertEquals("D0074",drama1.getId_number());
    }
    @Test
    public void testToString(){
        assertEquals("Rank: G\n" + "ID: M001\n" + "Title: Titanic", movie1.toString());
        assertEquals("Rank: PG-13\n" + "ID: D0074\n" + "Title: Phantom of the Opera\n" + "Type: Drama",drama1.toString());
    }

    @Test
    public void testEquals(){
        assertEquals(true,movie1.equals(movie1));
        assertEquals(false,drama1.equals(movie1));
        assertEquals(true,comedy1.equals(movie1));
    }

   @Test
   public void test_fee(){
        assertEquals(9,action1.calculateFees(3),0.001);
        assertEquals(10,drama1.calculateFees(5),0.001);
        assertEquals(50,movie1.calculateFees(25),0.001);
        assertEquals(50,comedy1.calculateFees(20),0.01);
    }
}
