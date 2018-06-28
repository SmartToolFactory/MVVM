package com.example.tutorial4livedatamvvmrecyclerview.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.example.tutorial4livedatamvvmrecyclerview.data.Repository;
import com.example.tutorial4livedatamvvmrecyclerview.model.Marker;

import java.util.List;


public class MarkerViewModel extends ViewModel {

    private MutableLiveData<List<Marker>> listLiveData = new MutableLiveData<>();

    private Repository repository;

    public MarkerViewModel() {
        repository = Repository.getsInstance();
    }


    public LiveData<List<Marker>> getMarkerList() {
        // MOCK: Make an api call or retrieve from database
        listLiveData = (MutableLiveData<List<Marker>>) repository.getAll();
        return repository.getAll();
    }

    public void update() {
        System.out.println("MarkerViewModel update()");
        List<Marker> markerList = listLiveData.getValue();
        if (markerList != null) {
            for (Marker marker: markerList) {
                marker.setTitle("UPDATED TITLE");
            }

        }
        // Invokes listLiveData.observe();
        listLiveData.setValue(markerList);
    }
}
