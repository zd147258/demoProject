package com.xx.test.dao;

import com.xx.test.base.Page;
import com.xx.test.po.OooPO;
import org.apache.ibatis.annotations.Param;


import java.util.List;

public interface OooMapper {


	int insert(OooPO oooPo);


	int deleteBy(OooPO oooPo);


	@Deprecated
	int updateById(OooPO oooPo);


	int updateBy(@Param("set") OooPO set, @Param("where") OooPO where);


	int getCheckBy(OooPO oooPo);


	OooPO getModelBy(OooPO oooPo);


	List<OooPO> getList(OooPO oooPo);


	List<OooPO> getListPage(OooPO oooPo, Page<OooPO> page);


	void insertBatch(List<OooPO> list);

}
