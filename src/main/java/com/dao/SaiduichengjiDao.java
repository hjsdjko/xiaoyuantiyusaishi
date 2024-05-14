package com.dao;

import com.entity.SaiduichengjiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.SaiduichengjiView;

/**
 * 赛队成绩 Dao 接口
 *
 * @author 
 */
public interface SaiduichengjiDao extends BaseMapper<SaiduichengjiEntity> {

   List<SaiduichengjiView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
