//package com.xy2h.rest.controller;
//
//import com.xy2h.rest.pojo.CatResult;
//import com.xy2h.rest.service.ItemCatService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.converter.json.MappingJacksonValue;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//@Controller
//public class ItemCatController {
//
//	@Autowired
//	private ItemCatService itemCatService;
//
//
//
//	/*@RequestMapping(value="/itemcat/list",
//			produces=MediaType.APPLICATION_JSON_VALUE+";charset=utf-8")
//	@ResponseBody
//	public String getItemCatList(String callback){
//		CatResult catResult=itemCatService.getItemCatList();
//		//把pojo转换位字符串
//		String json=JsonUtils.objectToJson(catResult);
//		String result=callback+"("+json+");";
//		return result;
//	}
//*/
//
//	@RequestMapping("/itemcat/list")
//	@ResponseBody
//	public Object getItemCatList(String callback){
//		CatResult catResult=itemCatService.getItemCatList();
//		MappingJacksonValue   mappingJacksonValue=new MappingJacksonValue(catResult);
//		mappingJacksonValue.setJsonpFunction(callback);
//		return mappingJacksonValue;
//
//	}
//}
