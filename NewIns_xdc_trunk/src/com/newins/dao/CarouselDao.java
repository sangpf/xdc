package com.newins.dao;

import java.util.List;

import com.newins.model.Carousel;


public interface CarouselDao {

	public List<Carousel> getCarousel(int channelId);
	
}
