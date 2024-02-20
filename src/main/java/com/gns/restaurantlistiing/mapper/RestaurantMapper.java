package com.gns.restaurantlistiing.mapper;

import com.gns.restaurantlistiing.dto.RestaurantDTO;
import com.gns.restaurantlistiing.entity.Restaurant;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RestaurantMapper {

    RestaurantMapper INSTANCE= Mappers.getMapper(RestaurantMapper.class);

    Restaurant mapRestaurantDTOToRestaurant(RestaurantDTO restaurantDTO);

    RestaurantDTO mapRestaurantToRestaurantDTO(Restaurant restaurant);

}
