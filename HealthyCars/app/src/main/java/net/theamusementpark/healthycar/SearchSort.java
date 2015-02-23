package net.theamusementpark.healthycar;

import android.util.Log;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by SiL3NTK0D3R on 2/21/2015.
 */
public class SearchSort {
    static public ArrayList<String> f;
   static public int topFive[];
    public SearchSort(String make, String classType, String fuel, String transmission){
        //Iterator used to search through the input Array 1
        int i = 0;
        //Index of top 5 cars
        topFive = new int[5];
        //If number of matches is less than 5
        int numberOfMatches = 0;
        //Sentinel values for loops
        boolean e = false, z =false;
        //ArrayList of found car fuel economies
        f = new ArrayList<String>();
        //Dummy input arrays
        String[] a = ReadJSON.carStat;
        String[] b = ReadJSON.carFind;

        while(e == false){
            try{
                if(a[i].contains(make)&&a[i].contains(classType)&&a[i].contains(fuel)&&a[i].contains(transmission)){
                    f.add(a[i]);
                    numberOfMatches++;
                }
                i++;
            }
            catch(ArrayIndexOutOfBoundsException g){
                e = true;
            }
        }


        //Collections.sort(f);
       // i=0;
        //for(int x = 0; x < 5 && x < numberOfMatches ; x++)
        //{
           // try{
             //   for(int y = 0; y < b.length; y++){
               //     if(f.get(x).equals(b[y])){
                 //       topFive[x]=y;
                  //  }
             //   }
            //}
            //catch(Exception error){
            //}
       // }
    }
}
