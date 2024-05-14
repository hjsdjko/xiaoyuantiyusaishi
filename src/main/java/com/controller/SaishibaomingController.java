
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
 * 赛事报名
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishibaoming")
public class SaishibaomingController {
    private static final Logger logger = LoggerFactory.getLogger(SaishibaomingController.class);

    @Autowired
    private SaishibaomingService saishibaomingService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private SaishiService saishiService;
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
        PageUtils page = saishibaomingService.queryPage(params);

        //字典表数据转换
        List<SaishibaomingView> list =(List<SaishibaomingView>)page.getList();
        for(SaishibaomingView c:list){
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
        SaishibaomingEntity saishibaoming = saishibaomingService.selectById(id);
        if(saishibaoming !=null){
            //entity转view
            SaishibaomingView view = new SaishibaomingView();
            BeanUtils.copyProperties( saishibaoming , view );//把实体数据重构到view中

                //级联表
                SaishiEntity saishi = saishiService.selectById(saishibaoming.getSaishiId());
                if(saishi != null){
                    BeanUtils.copyProperties( saishi , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setSaishiId(saishi.getId());
                }
                //级联表
                YonghuEntity yonghu = yonghuService.selectById(saishibaoming.getYonghuId());
                if(yonghu != null){
                    BeanUtils.copyProperties( yonghu , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setYonghuId(yonghu.getId());
                }
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
    public R save(@RequestBody SaishibaomingEntity saishibaoming, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishibaoming:{}",this.getClass().getName(),saishibaoming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");
        else if("运动员".equals(role))
            saishibaoming.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));

        Wrapper<SaishibaomingEntity> queryWrapper = new EntityWrapper<SaishibaomingEntity>()
            .eq("saishi_id", saishibaoming.getSaishiId())
            .eq("yonghu_id", saishibaoming.getYonghuId())
                .in("saishibaoming_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishibaomingEntity saishibaomingEntity = saishibaomingService.selectOne(queryWrapper);
        if(saishibaomingEntity==null){
            saishibaoming.setSaishibaomingYesnoTypes(1);
            saishibaoming.setCreateTime(new Date());
            saishibaomingService.insert(saishibaoming);
            return R.ok();
        }else {
            return R.error(511,"请不要重复报名");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishibaomingEntity saishibaoming, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,saishibaoming:{}",this.getClass().getName(),saishibaoming.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
//        else if("运动员".equals(role))
//            saishibaoming.setYonghuId(Integer.valueOf(String.valueOf(request.getSession().getAttribute("userId"))));
        //根据字段查询是否有相同数据
        Wrapper<SaishibaomingEntity> queryWrapper = new EntityWrapper<SaishibaomingEntity>()
            .notIn("id",saishibaoming.getId())
            .andNew()
            .eq("saishi_id", saishibaoming.getSaishiId())
            .eq("yonghu_id", saishibaoming.getYonghuId())
            .in("saishibaoming_yesno_types", new Integer[]{1,2})
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishibaomingEntity saishibaomingEntity = saishibaomingService.selectOne(queryWrapper);
        if(saishibaomingEntity==null){
            saishibaomingService.updateById(saishibaoming);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"请不要重复报名");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        saishibaomingService.deleteBatchIds(Arrays.asList(ids));
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
            List<SaishibaomingEntity> saishibaomingList = new ArrayList<>();//上传的东西
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
                            SaishibaomingEntity saishibaomingEntity = new SaishibaomingEntity();
//                            saishibaomingEntity.setSaishiId(Integer.valueOf(data.get(0)));   //赛事信息 要改的
//                            saishibaomingEntity.setYonghuId(Integer.valueOf(data.get(0)));   //运动员 要改的
//                            saishibaomingEntity.setSaishibaomingYesnoTypes(Integer.valueOf(data.get(0)));   //报名状态 要改的
//                            saishibaomingEntity.setSaishibaomingYesnoText(data.get(0));                    //报名结果 要改的
//                            saishibaomingEntity.setCreateTime(date);//时间
                            saishibaomingList.add(saishibaomingEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        saishibaomingService.insertBatch(saishibaomingList);
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
