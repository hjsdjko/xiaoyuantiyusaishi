
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
 * 赛事信息
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/saishi")
public class SaishiController {
    private static final Logger logger = LoggerFactory.getLogger(SaishiController.class);

    @Autowired
    private SaishiService saishiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private RichengService richengService;

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
        PageUtils page = saishiService.queryPage(params);

        //字典表数据转换
        List<SaishiView> list =(List<SaishiView>)page.getList();
        for(SaishiView c:list){
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
        SaishiEntity saishi = saishiService.selectById(id);
        if(saishi !=null){
            //entity转view
            SaishiView view = new SaishiView();
            BeanUtils.copyProperties( saishi , view );//把实体数据重构到view中

                //级联表
                RichengEntity richeng = richengService.selectById(saishi.getRichengId());
                if(richeng != null){
                    BeanUtils.copyProperties( richeng , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setRichengId(richeng.getId());
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
    public R save(@RequestBody SaishiEntity saishi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,saishi:{}",this.getClass().getName(),saishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<SaishiEntity> queryWrapper = new EntityWrapper<SaishiEntity>()
            .eq("saishi_name", saishi.getSaishiName())
            .eq("saishi_types", saishi.getSaishiTypes())
            .eq("richeng_id", saishi.getRichengId())
            .eq("saishi_fuzeren", saishi.getSaishiFuzeren())
            .eq("saishi_address", saishi.getSaishiAddress())
            .eq("saishi_status_types", saishi.getSaishiStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiEntity saishiEntity = saishiService.selectOne(queryWrapper);
        if(saishiEntity==null){
            saishi.setCreateTime(new Date());
            saishiService.insert(saishi);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody SaishiEntity saishi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,saishi:{}",this.getClass().getName(),saishi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<SaishiEntity> queryWrapper = new EntityWrapper<SaishiEntity>()
            .notIn("id",saishi.getId())
            .andNew()
            .eq("saishi_name", saishi.getSaishiName())
            .eq("saishi_types", saishi.getSaishiTypes())
            .eq("richeng_id", saishi.getRichengId())
            .eq("saishi_fuzeren", saishi.getSaishiFuzeren())
            .eq("saishi_address", saishi.getSaishiAddress())
            .eq("saishi_status_types", saishi.getSaishiStatusTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        SaishiEntity saishiEntity = saishiService.selectOne(queryWrapper);
        if("".equals(saishi.getSaishiFile()) || "null".equals(saishi.getSaishiFile())){
                saishi.setSaishiFile(null);
        }
        if(saishiEntity==null){
            saishiService.updateById(saishi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        saishiService.deleteBatchIds(Arrays.asList(ids));
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
            List<SaishiEntity> saishiList = new ArrayList<>();//上传的东西
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
                            SaishiEntity saishiEntity = new SaishiEntity();
//                            saishiEntity.setSaishiName(data.get(0));                    //赛事名称 要改的
//                            saishiEntity.setSaishiTypes(Integer.valueOf(data.get(0)));   //赛事类型 要改的
//                            saishiEntity.setRichengId(Integer.valueOf(data.get(0)));   //日程 要改的
//                            saishiEntity.setSaishiFuzeren(data.get(0));                    //赛事负责人 要改的
//                            saishiEntity.setSaishiFile(data.get(0));                    //赛事资料 要改的
//                            saishiEntity.setSaishiAddress(data.get(0));                    //场地信息 要改的
//                            saishiEntity.setSaishiStatusTypes(Integer.valueOf(data.get(0)));   //赛事状态 要改的
//                            saishiEntity.setSaishiContent("");//详情和图片
//                            saishiEntity.setCreateTime(date);//时间
                            saishiList.add(saishiEntity);


                            //把要查询是否重复的字段放入map中
                        }

                        //查询是否重复
                        saishiService.insertBatch(saishiList);
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
