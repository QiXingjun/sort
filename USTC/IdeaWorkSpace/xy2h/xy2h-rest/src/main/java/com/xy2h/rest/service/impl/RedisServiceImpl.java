package com.xy2h.rest.service.impl;

import com.xy2h.common.utils.ExceptionUtil;
import com.xy2h.common.utils.Xy2hResult;
import com.xy2h.rest.dao.JedisClient;
import com.xy2h.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class RedisServiceImpl implements RedisService {

	@Autowired
	private JedisClient jedisClient;

	@Value("${INDEX_CONTENT_REDIS_KEY}")
	private String INDEX_CONTENT_REDIS_KEY;

	@Override
	public Xy2hResult syncContent(long contentCid) {
		try {
			jedisClient.hdel(INDEX_CONTENT_REDIS_KEY, contentCid+"");
		} catch (Exception e) {
			e.printStackTrace();
			return Xy2hResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return Xy2hResult.ok();
	}

}
