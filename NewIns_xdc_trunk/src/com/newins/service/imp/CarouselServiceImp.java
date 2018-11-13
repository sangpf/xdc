package com.newins.service.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.newins.dao.CarouselDao;
import com.newins.model.Carousel;
import com.newins.service.CarouselService;

@Service
public class CarouselServiceImp implements CarouselService{

	@Autowired
	private CarouselDao cd;

	public List<Carousel> getCarousel(int channelId) {
		
		return cd.getCarousel(channelId);

	}

}
