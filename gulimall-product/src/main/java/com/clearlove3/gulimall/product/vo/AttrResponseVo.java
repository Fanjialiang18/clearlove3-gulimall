package com.clearlove3.gulimall.product.vo;

import lombok.Data;

/**
 * @author clearlove3
 * @date 2022/2/27 13:10
 */
@Data
public class AttrResponseVo extends AttrVo{
    private String catelogName;
    private String groupName;
    private Long[] catelogPath;
}
