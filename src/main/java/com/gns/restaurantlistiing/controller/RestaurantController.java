package com.gns.restaurantlistiing.controller;

import com.gns.restaurantlistiing.dto.RestaurantDTO;
import com.gns.restaurantlistiing.entity.Restaurant;
import com.gns.restaurantlistiing.service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/restaurant")
@CrossOrigin
public class RestaurantController {

    @Autowired
    RestaurantService restaurantService;

    @GetMapping("/fetchAllRestaurant")
    public ResponseEntity<List<RestaurantDTO>> fetchAllRestaurant()
    {
        List<RestaurantDTO> allRestaurants= restaurantService.findAllRestaurants();

        return new ResponseEntity<>(allRestaurants, HttpStatus.OK);
    }

    @PostMapping("/addRestaurant")
    public ResponseEntity<RestaurantDTO> addRestaurantInDB(@RequestBody RestaurantDTO restaurantDTO)
    {
      RestaurantDTO restaurantAdded= restaurantService.addRestaurantInDB(restaurantDTO);
      return new ResponseEntity<>(restaurantAdded,HttpStatus.CREATED);
    }

    @GetMapping("/fetchById/{id}")
    public ResponseEntity<RestaurantDTO> fetchRestaurantById(@PathVariable int id)
    {
        return restaurantService.fetchRestaurantById(id);
    }





}
