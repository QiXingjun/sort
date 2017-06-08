package com.xy2h.rest.service;

import com.xy2h.common.utils.Xy2hResult;

public interface RedisService {
	//
	Xy2hResult syncContent(long contentCid);
}
