package com.wode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wode.dao.IGoodsJpaRepository;
import com.wode.entity.GoodsEntity;

@Service
@Transactional
public class GoodsService {
	@Autowired
	private IGoodsJpaRepository goodsJpaRepository;
	
	//添加或修改商品
	public void addAndModifyGoods(GoodsEntity goods){
		goodsJpaRepository.save(goods);
	}
	
	//删除
	public void deleteGoods(Integer id){
		if(goodsJpaRepository.exists(id)){
			goodsJpaRepository.delete(id);
		}
	}
	
	//查看商品
	public GoodsEntity getGoods(Integer id){
		GoodsEntity goodsEntity = goodsJpaRepository.findOne(id);
		return goodsEntity;
	}
	
	//查看所有
	public List<GoodsEntity> getAllGoods(){
		List<GoodsEntity> goodsEntities = goodsJpaRepository.findAll();
		return goodsEntities;
	}
	
	//返回总记录数
	public long getGoodsCount(){
		long count = goodsJpaRepository.count();
		return count;
	}
	
	//根据商品价格分页查询
	public Page<GoodsEntity> getPageGoodsByPrice(Double price,int page,int size){
		Page<GoodsEntity> pages = goodsJpaRepository.findByPriceGreaterThan(price, new PageRequest(page, size));
		return pages;
	}
}
