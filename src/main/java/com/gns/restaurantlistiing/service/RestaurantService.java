package com.gns.restaurantlistiing.service;

import com.gns.restaurantlistiing.Repo.RestaurantRepo;
import com.gns.restaurantlistiing.dto.RestaurantDTO;
import com.gns.restaurantlistiing.entity.Restaurant;
import com.gns.restaurantlistiing.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantService {

    @Autowired
    RestaurantRepo restaurantRepo;
    public List<RestaurantDTO> findAllRestaurants() {
        List<Restaurant> restaurants= restaurantRepo.findAll();

        return restaurants.stream().map(RestaurantMapper.INSTANCE::mapRestaurantToRestaurantDTO).
                        collect(Collectors.toList());
    }

    public RestaurantDTO addRestaurantInDB(RestaurantDTO restaurantDTO) {
        Restaurant savedRestaurant=restaurantRepo.save(RestaurantMapper.INSTANCE.mapRestaurantDTOToRestaurant(restaurantDTO));

        return RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(savedRestaurant);

    }

    public ResponseEntity<RestaurantDTO> fetchRestaurantById(int id) {
        Optional<Restaurant> restaurant=restaurantRepo.findById(id);
        return restaurant.map(value -> new ResponseEntity<>(RestaurantMapper.INSTANCE.mapRestaurantToRestaurantDTO(value), HttpStatus.OK)).
                orElseGet(() -> new ResponseEntity<>(null, HttpStatus.NOT_FOUND));
    }
}
