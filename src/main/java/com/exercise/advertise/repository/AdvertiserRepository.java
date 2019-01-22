package com.exercise.advertise.repository;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.exercise.advertise.entity.Advertiser;

@Mapper
public interface AdvertiserRepository {

	@Insert("INSERT INTO advertiser(advertiserName, advertiserContactName,advertiserCreditLimit) VALUES (#{advertiserName}, #{advertiserContactName},#{advertiserCreditLimit})")
	public int insert(Advertiser advertiser);

	@Select("SELECT * FROM advertiser WHERE id=#{advertiserId}")
	public Advertiser getAdvertiserById(Integer advertiserId);

	@Delete("DELETE FROM advertiser WHERE id=#{advertiserId}")
	public int deleteAdvertiserById(Integer advertiserId);

	@Update("UPDATE advertiser SET advertiserName=#{advertiserName}, advertiserContactName=#{advertiserContactName},advertiserCreditLimit=#{advertiserCreditLimit} WHERE id=#{id}")
	public int updateAdvertiser(Advertiser advertiser);

}
