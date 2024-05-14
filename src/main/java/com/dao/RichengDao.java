package com.dao;

import com.entity.RichengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.RichengView;

/**
 * 日程信息 Dao 接口
 *
 * @author 
 */
public interface RichengDao extends BaseMapper<RichengEntity> {

   List<RichengView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
