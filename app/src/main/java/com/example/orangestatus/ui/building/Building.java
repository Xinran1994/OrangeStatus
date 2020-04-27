package com.example.orangestatus.ui.building;
import com.google.android.gms.location.LocationServices;
import com.google.firebase.firestore.GeoPoint;


public class Building {
    private GeoPoint Location;
    private String Name;
    private String Type;

    public Building(){}

    public Building(GeoPoint Location, String Name, String Type){
        this.Location = Location;
        this.Name = Name;
        this.Type = Type;
    }

    public GeoPoint getLocation() {
        return Location;
    }

    public String getName() {
        return Name;
    }

    public String getType() {
        return Type;
    }
}
