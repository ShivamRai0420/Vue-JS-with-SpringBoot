package com.example.SpringVueJs.controller;

import com.example.SpringVueJs.model.Restaurant;
import com.example.SpringVueJs.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class RestaurantController {
    @Autowired
    RestService restService;


    //Using Stored Procedure
    @GetMapping("/search")
    public List<Restaurant> searchByCity(@RequestParam String city) {
        return restService.searchRestaurantByCity(city);
    }

    @GetMapping("/getAll")
    public List<Restaurant>getAllRest(){
        System.out.println("---"+restService.getAllData());
        return restService.getAllData();

    }
    @GetMapping("/getById/{id}")
    public Optional<Restaurant> getRestById(@PathVariable int id){
        return restService.getRestById(id);
    }

    @DeleteMapping("/delById/{id}")
    public String delRestById(@PathVariable int id){
        restService.delRestById(id);
        return "Deleted";
    }

    @PutMapping("updateById/{id}")
    public String updateById(@PathVariable int id,@RequestBody Restaurant updated){
        Optional<Restaurant> existing=restService.getRestById(id);

        if(existing.isPresent()){
            Restaurant rest= existing.get();
            rest.setCity(updated.getCity());
            rest.setName(updated.getName());
            rest.setType(updated.getType());

            restService.saveRestData(rest);
        }
        else {
            return "Restaurant not found for ID: " + id;
        }
        return "Updated Successfull";
    }

    @PostMapping("/save")
    public String saveData(@RequestBody Restaurant restaurant){
        restService.saveRestData(restaurant);
        return "Saved Succesfully";
    }
}
