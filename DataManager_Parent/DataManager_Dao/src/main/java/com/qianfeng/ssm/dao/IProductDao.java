package com.qianfeng.ssm.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.qianfeng.ssm.domain.Product;

@Repository
public interface IProductDao {
	
	@Select("select * from product")
	public List<Product> findAll();
    
	@Insert("insert into product(id,productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{id},#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
	public void addProduct(Product product);
	
	@Select("select * from product where id = #{productId}")
	public Product findById(String productId);
    
	@Delete("delete from product where id = #{id}")
	public void deleteById(String id);

}
