package com.example.SpringVueJs.serviceImpl;

import com.example.SpringVueJs.model.Restaurant;
import com.example.SpringVueJs.repository.RestaurantRepo;
import com.example.SpringVueJs.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RestServiceImpl implements RestService {
    @Autowired
    RestaurantRepo restaurantRepo;

    @Override
    public List<Restaurant> getAllData() {
        return restaurantRepo.findAll();
    }

    @Override
    public Restaurant saveRestData(Restaurant restaurant) {
        return restaurantRepo.save(restaurant);
    }
    @Override
    public Optional<Restaurant> getRestById(int id){
        return restaurantRepo.findById(id);
    }

    @Override
    public void delRestById(int id) {
        restaurantRepo.deleteById(id);
    }
    @Override
    public List<Restaurant> searchRestaurantByCity(String city) {
        return restaurantRepo.searchByCity(city);
    }

}
