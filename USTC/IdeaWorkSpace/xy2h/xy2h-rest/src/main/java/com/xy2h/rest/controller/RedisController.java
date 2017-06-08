package com.xy2h.rest.controller;

import com.xy2h.common.utils.Xy2hResult;
import com.xy2h.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/cache/sync")
public class RedisController {

	@Autowired
	private RedisService redisService;

	@RequestMapping("/content/{contentCid}")
	@ResponseBody
	public Xy2hResult contentCacheSync(@PathVariable Long contentCid){
		Xy2hResult  result = redisService.syncContent(contentCid);
		return result;
	}
}
