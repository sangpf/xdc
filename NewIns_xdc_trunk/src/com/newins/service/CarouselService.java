/**
 * 
 */
package com.newins.service;

import java.util.List;

import com.newins.model.Carousel;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年6月16日 下午4:41:56
 */
public interface CarouselService {
	
	public List<Carousel> getCarousel(int channelId);

}
