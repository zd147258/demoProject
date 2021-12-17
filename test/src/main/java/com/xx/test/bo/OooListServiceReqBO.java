package com.xx.test.bo;

import com.xx.test.base.page.ReqPage;
import lombok.Data;

@Data
public class OooListServiceReqBO extends ReqPage {
    private Long id;
    private String name;
    private String nameLike;
}
