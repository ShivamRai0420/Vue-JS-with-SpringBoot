package com.example.SpringVueJs.repository;

import com.example.SpringVueJs.model.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {

    @Query(value = "CALL search_restaurants_by_city(:city)", nativeQuery = true)
    List<Restaurant> searchByCity(@Param("city") String city);
}
