package com.wode.dao;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wode.entity.GoodsEntity;

public interface IGoodsJpaRepository extends JpaRepository<GoodsEntity, Integer>{
	//分页功能（条件查询）
	Page<GoodsEntity> findByPriceGreaterThan(Double price,Pageable pageable);
	
	//自定义
	@Query(value="select * from t_goods where id = ?",nativeQuery = true)
	GoodsEntity queryGoodsById(Integer id);
	
	@Modifying
	@Query("update GoodsEntity goods set goods.price = :price")
	int modifyGoodsPrice(@Param("price") Double price);
}
