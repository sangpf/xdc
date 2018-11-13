package com.newins.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.newins.model.VqnItem;
import com.newins.service.LoadVqnService;

/**@Description  
 * @author MaNia_chAng
 * @time 2016年6月28日 下午3:52:12
 */
@Controller
@RequestMapping("/wanx")
public class LoadVqnController {
	@Autowired
	private LoadVqnService loadVqnService;
	@Autowired
	private VqnItem vqnItem;
	
	@RequestMapping(value = "/loadVqn", method = RequestMethod.GET)
	@ResponseBody
	public VqnItem loadVqn(HttpServletRequest request){
		//String userIdStr = request.getParameter("userId").trim();
		String vqnIdStr = request.getParameter("vqnId").trim();
		
		/*int userId = 0;
		if(userIdStr != null){
			userId = Integer.parseInt(userIdStr);
		}*/
		
		int vqnId = 0;
		if(vqnIdStr != null){
			vqnId = Integer.parseInt(vqnIdStr);
		}
		
		vqnItem = loadVqnService.loadVqn(vqnId);
		return vqnItem;
	}

}
