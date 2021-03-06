package com.ssm.common.core.mapper;

import com.ssm.common.base.model.Model;
import com.ssm.common.base.page.Page;
import com.ssm.common.base.page.Pageable;

import java.util.List;
import java.util.Map;

public interface BaseExtMapper<T extends Model> {

    int insertBatch(List<T> list);

    int deleteBatch(Long[] ids);

    List<Map> selectSelective(Map<String, Object> map);

    Page<Map> selectPage(Pageable pageable);

}
