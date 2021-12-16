package com.xx.test.dao;

import com.xx.test.base.page.Page;
import com.xx.test.po.SysDicDictionaryPO;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface SysDicDictionaryMapper {


	int insert(SysDicDictionaryPO sysDicDictionaryPo);


	int deleteBy(SysDicDictionaryPO sysDicDictionaryPo);


	@Deprecated
	int updateById(SysDicDictionaryPO sysDicDictionaryPo);


	int updateBy(@Param("set") SysDicDictionaryPO set, @Param("where") SysDicDictionaryPO where);


	int getCheckBy(SysDicDictionaryPO sysDicDictionaryPo);


	SysDicDictionaryPO getModelBy(SysDicDictionaryPO sysDicDictionaryPo);


	List<SysDicDictionaryPO> getList(SysDicDictionaryPO sysDicDictionaryPo);


	List<SysDicDictionaryPO> getListPage(SysDicDictionaryPO sysDicDictionaryPo, Page<SysDicDictionaryPO> page);


	void insertBatch(List<SysDicDictionaryPO> list);

}
