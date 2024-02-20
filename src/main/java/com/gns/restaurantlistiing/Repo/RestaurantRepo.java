package com.gns.restaurantlistiing.Repo;

import com.gns.restaurantlistiing.entity.Restaurant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RestaurantRepo extends JpaRepository<Restaurant,Integer> {

}
