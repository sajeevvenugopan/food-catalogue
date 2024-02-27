package com.foodservice.foodcatalogue.mapper;

import com.foodservice.foodcatalogue.dto.FoodItem;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface FoodItemMapper {

    FoodItemMapper INSTANCE = Mappers.getMapper(FoodItemMapper.class);

    com.foodservice.foodcatalogue.entity.FoodItem mapFoodItemDTOtoFoodItem(FoodItem foodItem);
    FoodItem mapFoodItemtoFoodItemDTO(com.foodservice.foodcatalogue.entity.FoodItem foodItem);
}
