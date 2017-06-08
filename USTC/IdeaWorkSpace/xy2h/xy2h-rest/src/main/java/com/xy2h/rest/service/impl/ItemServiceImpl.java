package com.xy2h.rest.service.impl;

import com.xy2h.common.utils.JsonUtils;
import com.xy2h.common.utils.Xy2hResult;
import com.xy2h.mapper.TbItemDescMapper;
import com.xy2h.mapper.TbItemMapper;
import com.xy2h.mapper.TbItemParamItemMapper;
import com.xy2h.pojo.TbItem;
import com.xy2h.pojo.TbItemDesc;
import com.xy2h.pojo.TbItemParamItem;
import com.xy2h.pojo.TbItemParamItemExample;
import com.xy2h.rest.dao.JedisClient;
import com.xy2h.rest.service.ItemService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;

//商品信息管理
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper itemMapper;

	@Autowired
	private TbItemDescMapper itemDescMapper;

	@Autowired
	private TbItemParamItemMapper itemParamItemMapper;

	@Value("${REDIS_ITEM_KEY}")
	private String REDIS_ITEM_KEY;
	@Value("${REDIS_ITEM_EXPIRE}")
	private Integer REDIS_ITEM_EXPIRE;

	@Autowired
	private JedisClient jedisClient;

	@Override
	public Xy2hResult getItemBaseInfo(long itemId) {
		// 添加缓存
		// 从缓存中取商品信息
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId
					+ ":base");
			if (!StringUtils.isBlank(json)) {
				// 把json转换为pojo
				TbItem item = JsonUtils.jsonToPojo(json, TbItem.class);
				return Xy2hResult.ok(item);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		TbItem item = itemMapper.selectByPrimaryKey(itemId);

		// 把商品信息写入缓存
		try {
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":base",
					JsonUtils.objectToJson(item));
			// 设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":base",
					REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Xy2hResult.ok(item);
	}

	@Override
	public Xy2hResult getItemDesc(long itemId) {
		// 添加缓存
		// 从缓存中取商品信息
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId
					+ ":desc");
			if (!StringUtils.isBlank(json)) {
				// 把json转换为pojo
				TbItemDesc itemDesc = JsonUtils.jsonToPojo(json,
						TbItemDesc.class);
				return Xy2hResult.ok(itemDesc);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		TbItemDesc itemDesc = itemDescMapper.selectByPrimaryKey(itemId);

		// 把商品信息写入缓存
		try {
			jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":desc",
					JsonUtils.objectToJson(itemDesc));
			// 设置key的有效期
			jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":desc",
					REDIS_ITEM_EXPIRE);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Xy2hResult.ok(itemDesc);
	}

	// 根据id查询规格参数
	@Override
	public Xy2hResult getItemParam(long itemId) {

		// 从缓存中取商品信息
		try {
			String json = jedisClient.get(REDIS_ITEM_KEY + ":" + itemId
					+ ":param");
			if (!StringUtils.isBlank(json)) {
				// 把json转换为pojo
				TbItemParamItem paramItem = JsonUtils.jsonToPojo(json,
						TbItemParamItem.class);
				return Xy2hResult.ok(paramItem);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}

		TbItemParamItemExample example = new TbItemParamItemExample();

		TbItemParamItemExample.Criteria criteria = example.createCriteria();
		criteria.andItemIdEqualTo(itemId);

		List<TbItemParamItem> list = itemParamItemMapper
				.selectByExampleWithBLOBs(example);
		TbItemParamItem paramItem;
		if (list != null && list.size() > 0) {
			paramItem = list.get(0);
			// 把商品信息写入缓存
			try {
				jedisClient.set(REDIS_ITEM_KEY + ":" + itemId + ":param",
						JsonUtils.objectToJson(paramItem));
				// 设置key的有效期
				jedisClient.expire(REDIS_ITEM_KEY + ":" + itemId + ":param",
						REDIS_ITEM_EXPIRE);
			} catch (Exception e) {
				e.printStackTrace();
			}
			return Xy2hResult.ok(paramItem);
		}
		return Xy2hResult.build(400, "没有该商品规格信息");
	}
}
