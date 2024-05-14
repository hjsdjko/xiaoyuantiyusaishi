
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 赛队成绩
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saiduichengji")
public class SaiduichengjiController {
    private static final Logger logger = LoggerFactory.getLogger(SaiduichengjiController.class);

    @Autowired
    private SaiduichengjiService saiduichengjiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("运动员".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = saiduichengjiService.queryPage(params);

        //字典表数据转换
        List<SaiduichengjiView> list =(List<SaiduichengjiView>)page.getList();
        for(SaiduichengjiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        SaiduichengjiEntity saiduichengji = saiduichengjiService.selectById(id);
        if(saiduichengji !=null){
            //entity转view
            SaiduichengjiView view = new SaiduichengjiView();
            BeanUtils.copyProperties( saiduichengji , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody SaiduichengjiEntity saiduichengji, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saiduichengji:{}",this.getClass().getName(),saiduichengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SaiduichengjiEntity> queryWrapper = new EntityWrapper<SaiduichengjiEntity>()
            .eq("saiduichengji_name", saiduichengji.getSaiduichengjiName())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaiduichengjiEntity saiduichengjiEntity = saiduichengjiService.selectOne(queryWrapper);
        if(saiduichengjiEntity==null){
            saiduichengji.setCreateTime(new Date());
            saiduichengjiService.insert(saiduichengji);
            return R.ok();
        }else {
            return R.error(511,"赛队名称不能重复,同一个赛队只能添加一条数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaiduichengjiEntity saiduichengji, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,saiduichengji:{}",this.getClass().getName(),saiduichengji.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<SaiduichengjiEntity> queryWrapper = new EntityWrapper<SaiduichengjiEntity>()
            .notIn("id",saiduichengji.getId())
            .andNew()
            .eq("saiduichengji_name", saiduichengji.getSaiduichengjiName())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaiduichengjiEntity saiduichengjiEntity = saiduichengjiService.selectOne(queryWrapper);
        if(saiduichengjiEntity==null){
            saiduichengjiService.updateById(saiduichengji);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"赛队名称不能重复,同一个赛队只能添加一条数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        saiduichengjiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName, HttpServletRequest request){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        Integer yonghuId = Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId")));
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            List<SaiduichengjiEntity> saiduichengjiList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("../../upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            SaiduichengjiEntity saiduichengjiEntity = new SaiduichengjiEntity();
//                            saiduichengjiEntity.setSaiduichengjiName(data.get(0));                    //赛队名称 要改的
//                            saiduichengjiEntity.setSaiduichengjiNumbe(Integer.valueOf(data.get(0)));   //赛队人数 要改的
//                            saiduichengjiEntity.setSaiduichengjiaAddress(data.get(0));                    //赛队所属地区 要改的
//                            saiduichengjiEntity.setSaiduichengjibAddress(data.get(0));                    //赛队所在地址 要改的
//                            saiduichengjiEntity.setSaishifenshuChengji(Integer.valueOf(data.get(0)));   //赛队总成绩 要改的
//                            saiduichengjiEntity.setSaiduichengjiaText(data.get(0));                    //参加的赛事 要改的
//                            saiduichengjiEntity.setSaiduichengjibText(data.get(0));                    //赛队详情 要改的
//                            saiduichengjiEntity.setCreateTime(date);//时间
                            saiduichengjiList.add(saiduichengjiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        saiduichengjiService.insertBatch(saiduichengjiList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
