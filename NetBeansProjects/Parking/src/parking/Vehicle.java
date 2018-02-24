/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.time.LocalTime;

/**
 *
 * @author tomasz
 */
public class Vehicle {
    private String plate;
    private String category;
    private LocalTime entryTime;
    public Vehicle(String plate,String category){
        setPlate(plate);
        setCategory(category);
        setEntryTime();
    }
    public final void setPlate(String plate){
        if(plate.length()>0)
            this.plate = plate;
        else
            throw new IllegalArgumentException("Plate number can't be empty");
    }
    public final void setCategory(String category){
        this.category = category;
    }
    public final void setEntryTime(){
        entryTime = LocalTime.now();
    }
    public String getPlate(){
        return plate;
    }
    public String getCategory(){
        return category;
    }
    public LocalTime getEntryTime(){
        return entryTime;
    }
    @Override
    public String toString(){
        return plate+" "+category+" "+String.format("%02d", entryTime.getHour())+":"+String.format("%02d", entryTime.getMinute());
    }
}
