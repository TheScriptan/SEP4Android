package com.example.sensorsproject.application.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.sensorsproject.business.models.CO2;
import com.example.sensorsproject.business.models.Humidity;
import com.example.sensorsproject.business.models.Temperature;
import com.example.sensorsproject.business.repositories.LiveDataRepository;

public class LiveDataViewModel extends ViewModel {

    private LiveDataRepository repository;
    private MutableLiveData<String> currentSensor;

    public LiveDataViewModel(){
        repository = LiveDataRepository.getInstance();
        currentSensor = new MutableLiveData<>();
    }

    /*
     * SUBSCRIBE & UNSUBSCRIBE
     */

    public void subscribe(String roomName){
        repository.subscribe(roomName);
    }

    public void unsubscribe(String roomName){
        repository.unsubscribe(roomName);
    }

    /*
     * GET LIVE DATA
     */

    public LiveData<CO2> getLiveCo2(){
        return repository.getLiveCo2();
    }

    public LiveData<Humidity> getLiveHumidity(){
        return repository.getLiveHumidity();
    }

    public LiveData<Temperature> getLiveTemperature(){
        return repository.getLiveTemperature();
    }

    public LiveData<String> getLiveTimestamp(){
        return repository.getLiveTimestamp();
    }

    public LiveData<String> getCurrentSensor(){
        return currentSensor;
    }

    /*
     * SETTERS
     */

    public void setCurrentSensor(String s){
        currentSensor.postValue(s);
    }
}
