package com.xy2h.rest.service;

import com.xy2h.pojo.TbContent;

import java.util.List;


public interface ContentService {
	
	List<TbContent>  getContentList(long contentCid);

}
