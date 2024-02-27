package com.foodservice.foodcatalogue.mapper;

import com.foodservice.foodcatalogue.dto.FoodItem;

public class FoodItemMapperImpl implements FoodItemMapper{
    @Override
    public com.foodservice.foodcatalogue.entity.FoodItem mapFoodItemDTOtoFoodItem(FoodItem foodItemDTO) {
        if (foodItemDTO == null)
            return null;
        else {
            com.foodservice.foodcatalogue.entity.FoodItem foodItem = new com.foodservice.foodcatalogue.entity.FoodItem();
            foodItem.setItemName(foodItemDTO.getItemName());
            foodItem.setItemDescription(foodItemDTO.getItemDescription());
            foodItem.setVeg(foodItemDTO.isVeg());
            foodItem.setId(foodItemDTO.getId());
            foodItem.setPrice(foodItemDTO.getPrice());
            foodItem.setRestaurantId(foodItemDTO.getRestaurantId());
            if (foodItem.getQuantity() != null)
                foodItem.setQuantity(foodItemDTO.getQuantity());
            else
                foodItem.setQuantity(0);

            return foodItem;
        }
    }

    @Override
    public FoodItem mapFoodItemtoFoodItemDTO(com.foodservice.foodcatalogue.entity.FoodItem foodItem) {
        if (foodItem == null)
            return null;
        else {
            FoodItem foodItemDTO = new FoodItem();
            foodItemDTO.setId(foodItem.getId());
            foodItemDTO.setItemName(foodItem.getItemName());
            foodItemDTO.setItemDescription(foodItem.getItemDescription());
            foodItemDTO.setVeg(foodItem.isVeg());
            foodItemDTO.setPrice(foodItem.getPrice());
            foodItemDTO.setRestaurantId(foodItem.getRestaurantId());
            if (foodItem.getQuantity() != null)
                foodItemDTO.setQuantity(foodItem.getQuantity());
            else
                foodItemDTO.setQuantity(0);

            return foodItemDTO;
        }
    }
}
