//package com.xy2h.rest.service.impl;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import com.xy2h.common.utils.JsonUtils;
//import com.xy2h.mapper.TbItemCatMapper;
//import com.xy2h.pojo.TbItemCat;
//import com.xy2h.pojo.TbItemCatExample;
//import com.xy2h.rest.JedisClient;
//import com.xy2h.rest.pojo.CatNode;
//import com.xy2h.rest.pojo.CatResult;
//import com.xy2h.rest.service.ItemCatService;
//import org.apache.commons.lang3.StringUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//
//
////商品分类服务
//@Service
//public class ItemCatServiceImpl implements ItemCatService {
//
//	@Autowired
//	private TbItemCatMapper itemCatMapper;
//
//
//	@Autowired
//	private JedisClient jedisClient;
//
//	@Value("${INDEX_CATEGORY_REDIS_KEY}")
//	private String INDEX_CATEGORY_REDIS_KEY;
//
//
//	//过期时间设置
//	@Value("${REDIS_ITEM_EXPIRE}")
//	private Integer REDIS_ITEM_EXPIRE;
//
//	@Override
//	public CatResult getItemCatList() {
//		CatResult catResult=new CatResult();
//
//
//		try {
//			// 添加redis业务
//			// 1.先在redis中查询 ，如果有值，直接返回
//			String resultString = jedisClient.get(INDEX_CATEGORY_REDIS_KEY);
//			if (!StringUtils.isBlank(resultString)) {
//				catResult.setData(JsonUtils.jsonToList(resultString,
//						CatNode.class));
//				return catResult;
//			}
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException(e);
//		}
//
//		//查询分类列表
//		catResult.setData(getCatList(0));
//		return catResult;
//	}
//
//	//查询分类列表的方法
//	private List<?> getCatList(long parentId){
//
//		TbItemCatExample example=new TbItemCatExample();
//		TbItemCatExample.Criteria criteria = example.createCriteria();
//		criteria.andParentIdEqualTo(parentId);
//
//
//
//		List<TbItemCat> list = itemCatMapper.selectByExample(example);
//		//返回值list
//		List resultList=new ArrayList<>();
//
//		int count=0;
//		for (TbItemCat tbItemCat : list) {
//			//判断是否为叶子节点
//			if(tbItemCat.getIsParent()){
//
//				CatNode  catNode=new CatNode();
//				if(parentId==0){
//					catNode.setName("<a href='/products/"+tbItemCat.getId()+".html'>"+tbItemCat.getName()+"</a>");
//				}else{
//					catNode.setName(tbItemCat.getName());
//				}
//				catNode.setUrl("/products/"+tbItemCat.getId()+".html");
//				catNode.setItem(getCatList(tbItemCat.getId()));
//				resultList.add(catNode);
//
//				count++;
//				if(parentId==0 && count>=14){
//					break;
//				}
//
//			}else{
//				//叶子节点
//				resultList.add("/products/"+tbItemCat.getId()+".html|"+tbItemCat.getName());
//			}
//		}
//
//		// 3. 查询完mysql后，将查询结果存入到redis中
//		jedisClient.set(INDEX_CATEGORY_REDIS_KEY,
//			JsonUtils.objectToJson(resultList));
//
//		jedisClient.expire(INDEX_CATEGORY_REDIS_KEY,
//				REDIS_ITEM_EXPIRE);
//
//		return resultList;
//	}
//}
