package com.xy2h.rest.controller;

import com.xy2h.common.utils.ExceptionUtil;
import com.xy2h.common.utils.Xy2hResult;
import com.xy2h.pojo.TbContent;
import com.xy2h.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


@Controller
@RequestMapping("/content")
public class ContentController {
	
	//发布服务，接收查询参数
	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list/{cid}")
	@ResponseBody
	public Xy2hResult getContentList(@PathVariable Long cid){
		try {
			List<TbContent> list = contentService.getContentList(cid);
			return Xy2hResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return Xy2hResult.build(500, ExceptionUtil.getStackTrace(e));
		}		
	}
}
