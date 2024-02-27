package com.foodservice.foodcatalogue.service;

import com.foodservice.foodcatalogue.dto.FoodCataloguePage;
import com.foodservice.foodcatalogue.dto.FoodItem;
import com.foodservice.foodcatalogue.dto.Restaurant;
import com.foodservice.foodcatalogue.mapper.FoodItemMapper;
import com.foodservice.foodcatalogue.repository.FoodItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class FoodCatalogueService {

    @Autowired
    private FoodItemRepository foodItemRepository;

    @Autowired
    RestTemplate restTemplate;

    public FoodItem addFoodItem(FoodItem foodItem) {
        com.foodservice.foodcatalogue.entity.FoodItem foodItemSavedInDb = foodItemRepository.save(FoodItemMapper.INSTANCE.mapFoodItemDTOtoFoodItem(foodItem));
        return FoodItemMapper.INSTANCE.mapFoodItemtoFoodItemDTO(foodItemSavedInDb);
    }

    public FoodCataloguePage fetchFoodCataloguePageDetails(Integer restaurantId) {
        List<com.foodservice.foodcatalogue.entity.FoodItem> foodItems = fetchFoodItemList(restaurantId);
        Restaurant restaurant = fetechRestauarantDetailsFromRestauarantMS(restaurantId);
        return createFoodCataloguePage(foodItems, restaurant);
    }

    private FoodCataloguePage createFoodCataloguePage(List<com.foodservice.foodcatalogue.entity.FoodItem> foodItems, Restaurant restaurant) {

        FoodCataloguePage foodCataloguePage = new FoodCataloguePage();
        foodCataloguePage.setFoodItems(foodItems);
        foodCataloguePage.setRestaurant(restaurant);
        return foodCataloguePage;
    }

    private Restaurant fetechRestauarantDetailsFromRestauarantMS(Integer restaurantId) {
        return restTemplate.getForObject("http://RESTAURANT-SERVICE/restaurant/fetchById/"+restaurantId, Restaurant.class);
    }

    private List<com.foodservice.foodcatalogue.entity.FoodItem> fetchFoodItemList(Integer restaurantId) {
        return foodItemRepository.findByRestaurantId(restaurantId);
    }
}
