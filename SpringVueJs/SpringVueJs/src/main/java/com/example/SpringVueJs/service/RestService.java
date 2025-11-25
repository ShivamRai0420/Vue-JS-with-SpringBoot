package com.example.SpringVueJs.service;

import com.example.SpringVueJs.model.Restaurant;

import java.util.List;
import java.util.Optional;

public interface RestService {
    List<Restaurant> getAllData();

    Restaurant saveRestData(Restaurant restaurant);
    Optional<Restaurant> getRestById(int id);
    void delRestById(int id);

    List<Restaurant> searchRestaurantByCity(String city);

}
