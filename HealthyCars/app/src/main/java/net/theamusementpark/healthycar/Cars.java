package net.theamusementpark.healthycar;

/*
 @author The Amusement Park
 @event CODE 2015
 @class Cars
 @description This class contains the Cars object that is used to store information about the cars
 */
public class Cars {

    // GLOBAL VARIABLES DEFINED
    public String modelYear = "";
    public String make = "";
    public String model = "";
    public String vehicleClass = "";
    public String engineSize = "";
    public String cylinders = "";
    public String transmission = "";
    public String fuelType = "";
    public String fuelConsumptionCity = "";
    public String fuelConsumptionHwy = "";
    public String fuelConsumptionComb1 = "";
    public String fuelConsumptionComb2 = "";
    public String co2Emissions = "";

    /*
    @method toString()
    @params none
    @return String data
     */
    @Override
    public String toString() {
        return modelYear + " ," + make + " ," + model + " ," + vehicleClass + " ,\"" + fuelType + "\", transmission\": \"" + transmission.substring(0,1);
    }

    /*
    @method toString2()
    @params none
    @return String data
     */
    public String toString2() {
        return co2Emissions + " " + fuelConsumptionHwy + " " + fuelConsumptionCity;
    }

    /*
    @method toMake()
    @params none
    @return String data
     */
    public String toMake() {
        return make;
    }

    /*
    @method toModel()
    @params none
    @return String data
     */
    public String toModel() {
        return model;
    }

    /*
    @method toYear()
    @params none
    @return String data
     */
    public String toYear() {
        return modelYear;
    }
}