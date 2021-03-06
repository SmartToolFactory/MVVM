package com.example.tutorial1mvvmrecyclerview.data;


import com.example.tutorial1mvvmrecyclerview.model.Marker;

import java.util.ArrayList;
import java.util.List;

public class Repository implements DataSource {

    private static Repository sInstance;
    private List<Marker> markerList;

    private Repository() {
        markerList = new ArrayList<>();
        Marker marker = new Marker();
       marker.getTitle().set("Title");
       marker.getLatitude().set("10.5234124");
       marker.getAddress().set("Berlin");
       markerList.add(marker);

        marker = new Marker();
        marker.getTitle().set("Title2");
        marker.getLatitude().set("40.7534546");
        marker.getAddress().set("Moskow");
        markerList.add(marker);

        marker = new Marker();
        marker.getTitle().set("Title3");
        marker.getLatitude().set("30.7534546");
        marker.getAddress().set("New York");
        markerList.add(marker);
    }

    public static Repository getsInstance() {

        if (sInstance == null) {
            sInstance = new Repository();
        }

        return sInstance;
    }

    @Override
    public List<Marker> getAll() {
        return markerList;
    }

    @Override
    public long addMarker(Marker marker) {
        markerList.add(marker);
        return 1;
    }

    @Override
    public int update(Marker marker) {
        if (markerList.contains(marker)) {
            markerList.set(markerList.indexOf(marker), marker);
        }
        return markerList.indexOf(marker);
    }

    @Override
    public int deleteMarker(Marker marker) {
        if (markerList.contains(marker)) {
            markerList.remove(marker);
        }
        return markerList.indexOf(marker);
    }

    @Override
    public void deleteAll() {
        markerList.clear();
    }
}
