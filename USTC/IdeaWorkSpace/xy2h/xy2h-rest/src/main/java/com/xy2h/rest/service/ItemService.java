package com.xy2h.rest.service;


import com.xy2h.common.utils.Xy2hResult;

public interface ItemService {

	Xy2hResult getItemBaseInfo(long itemId);
	Xy2hResult  getItemDesc(long itemId);
	Xy2hResult getItemParam(long itemId);
}
