package com.xx.test.service;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;
import com.xx.test.base.Page;
import com.xx.test.bo.*;
import com.xx.test.constant.BaseRspConstants;
import com.xx.test.dao.OooMapper;
import com.xx.test.po.OooPO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 标题: OooServiceImpl
 * 说明: //TODO
 * 时间: 2021/12/9 10:47
 * @author 郑冬
 **/
@Slf4j
@Service
public class OooServiceImpl implements OooService{

    @Autowired
    private OooMapper oooMapper;

    @Override
    public OooServiceRspBO selectOoo(OooServiceReqBO reqBO) {
        OooServiceRspBO rspBO = new OooServiceRspBO();
        rspBO.setCode(BaseRspConstants.RSP_CODE_SUCCESS);
        rspBO.setMessage(BaseRspConstants.RSP_DESC_SUCCESS);
        OooPO qryParam = new OooPO();
        qryParam.setId(reqBO.getId());
        log.info("qryParam:{}", JSON.toJSONString(qryParam));
        OooPO qryResult = oooMapper.getModelBy(qryParam);
        OooBO oooBO = new OooBO();
        BeanUtils.copyProperties(qryResult, oooBO);
        rspBO.setOooBO(oooBO);
        return rspBO;
    }

    @Override
    public OooListServiceRspBO selectListOoo(OooListServiceReqBO reqBO) {
        OooListServiceRspBO rspBO = new OooListServiceRspBO();
        List<OooBO> rows = new ArrayList<>();
        Page<OooPO> page = new Page<>(reqBO.getPageNo(), reqBO.getPageSize());
        OooPO qryParam = new OooPO();
        BeanUtils.copyProperties(reqBO, qryParam);
        log.info("qryParam:{}", JSON.toJSONString(qryParam));
        List<OooPO> qryResult = oooMapper.getListPage(qryParam, page);
        if (CollectionUtils.isEmpty(qryResult)){
            rspBO.setPageNo(0);
            rspBO.setTotal(0);
            rspBO.setRecordsTotal(0);
            rspBO.setCode(BaseRspConstants.RSP_CODE_SUCCESS);
            rspBO.setMessage(BaseRspConstants.RSP_DESC_SUCCESS);
            return rspBO;
        }
        String jsonString = JSON.toJSONString(qryResult, SerializerFeature.WriteMapNullValue);
        List<OooBO> oooBOS = JSON.parseArray(jsonString, OooBO.class);
        rows.addAll(oooBOS);
        rspBO.setRows(rows);
        rspBO.setRecordsTotal(page.getTotalCount());
        rspBO.setTotal(page.getTotalPages());
        rspBO.setPageNo(page.getPageNo());
        rspBO.setCode(BaseRspConstants.RSP_CODE_SUCCESS);
        rspBO.setMessage(BaseRspConstants.RSP_DESC_SUCCESS);
        return rspBO;
    }
}
