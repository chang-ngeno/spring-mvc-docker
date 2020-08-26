package com.clc.business;

import java.util.List;

import com.clc.model.Item;

public interface ItemBO {
	public List<Item> fetchAll();

	public Item findOne(Item item);
	
	public Item findById(int id);
}
