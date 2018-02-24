/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.time.LocalTime;
import org.junit.Test;
import static org.junit.Assert.*;
import parking.ParkingArea;

/**
 *
 * @author tomasz
 */
public class ParkingAreaTests {
    @Test
    public void durationTest(){
        ParkingArea t = new ParkingArea(10);
        LocalTime start = LocalTime.of(10, 0, 0);
        LocalTime stop = LocalTime.of(11, 00, 17);
        assertEquals(3617,t.duration(start,stop));
    }
}
