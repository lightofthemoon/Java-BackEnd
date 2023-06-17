package com.example.javabackend.modules.order.Dto;

import com.example.javabackend.entity.Dishes;
import com.example.javabackend.entity.Size;
import com.example.javabackend.entity.Topping;

import java.util.List;

public class DishesDto {
    public Long dishId;

    public int quantity;
    public Long sizeId;
    public List<ToppingDto> listTopping;

    public Long getSizeId() {return sizeId;}

    public void setSizeId(Long sizeId) {this.sizeId = sizeId;}

    public Long getDishId() {
        return dishId;
    }

    public void setDishId(Long dishId) {
        this.dishId = dishId;
    }

    public List<ToppingDto> getListTopping() {
        return listTopping;
    }

    public void setListTopping(List<ToppingDto> listTopping) {
        this.listTopping = listTopping;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
