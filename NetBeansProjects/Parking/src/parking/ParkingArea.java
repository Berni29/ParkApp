/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parking;

import java.time.LocalTime;
import java.util.ArrayList;

/**
 *
 * @author tomasz
 */
public class ParkingArea {
    private int freeSpots = 0;
    private final ArrayList<Vehicle> spots = new ArrayList<>();
    private float feeA = 3, feeB = 5, feeC = 7, feeD = 10;
    public ParkingArea(int numberOfSpots){
        this.freeSpots = numberOfSpots;
    }
    public void parkVehicle(Vehicle v){
        if(freeSpots>0){
            if(checkIfInDB(v)==false){
            spots.add(v);
            freeSpots--;
            }
            else 
                throw new IllegalArgumentException("Vehicle registered already");
        }
        else
            throw new IndexOutOfBoundsException("Parking area is full");
    }
    public float exitArea(String plate){
        float fee;
        Vehicle v=null;
        for(int i=0; i<spots.size(); i++){
            if(spots.get(i).getPlate().equals(plate)){
                v = spots.get(i);
                spots.remove(i);
                freeSpots++;
            }
        }
        if(v==null)
            throw new NullPointerException("Vehicle not found");
        switch(v.getCategory()){
            case "A":
                fee = feeA;
                break;
            case "B":
                fee = feeB;
                break;
            case "C":
                fee = feeC;
                break;
            case "D":
                fee = feeD;
                break;
            default:
                fee = 0;
                break;
        }
        return fee *= duration(v.getEntryTime(),LocalTime.now())/3600.0f;
    }
    public int duration(LocalTime start, LocalTime stop){
        return stop.toSecondOfDay()-start.toSecondOfDay();
    }
    public int getFreeSpots(){
        return freeSpots;
    }
    public ArrayList<Vehicle> getVehicleList(){
        return spots;
    }
    public boolean checkIfInDB(Vehicle v){
        for(int i=0; i<spots.size(); i++){
            if(spots.get(i).getPlate().equals(v.getPlate()))
                return true;
        }
        return false;
    }
    public void setFee(String category,float fee){
        if(fee<0)
            throw new NumberFormatException("Negative number");
        switch(category){
            case "A":
                feeA = fee;
                break;
            case "B":
                feeB = fee;
                break;
            case "C":
                feeC = fee;
                break;
            case "D":
                feeD = fee;
                break;
            default:
                break;
        }
    }
    public float getFee(String category){
        switch(category){
            case "A":
                return feeA;
            case "B":
                return feeB;
            case "C":
                return feeC;
            case "D":
                return feeD;
            default:
                return 0;
        }
    }
            
}
