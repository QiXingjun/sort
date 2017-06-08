package com.xy2h.rest.controller;

import com.xy2h.common.utils.Xy2hResult;
import com.xy2h.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
@RequestMapping("/item")
public class ItemController {

	//接收商品id,调用service查询商品信息，返回商品对象，使用Xy2hResult包装
	@Autowired
	private ItemService itemService;


	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public Xy2hResult getItemBaseInfo(@PathVariable Long itemId){
		Xy2hResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}

	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public Xy2hResult getItemDesc(@PathVariable Long itemId){
		Xy2hResult result = itemService.getItemDesc(itemId);
		return result;
	}

	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public Xy2hResult getItemParam(@PathVariable Long itemId){
		Xy2hResult result = itemService.getItemParam(itemId);
		return result;
	}

}
