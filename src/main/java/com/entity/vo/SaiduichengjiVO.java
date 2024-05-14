package com.entity.vo;

import com.entity.SaiduichengjiEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 赛队成绩
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 */
@TableName("saiduichengji")
public class SaiduichengjiVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

    @TableField(value = "id")
    private Integer id;


    /**
     * 赛队名称
     */

    @TableField(value = "saiduichengji_name")
    private String saiduichengjiName;


    /**
     * 赛队人数
     */

    @TableField(value = "saiduichengji_numbe")
    private Integer saiduichengjiNumbe;


    /**
     * 赛队所属地区
     */

    @TableField(value = "saiduichengjia_address")
    private String saiduichengjiaAddress;


    /**
     * 赛队所在地址
     */

    @TableField(value = "saiduichengjib_address")
    private String saiduichengjibAddress;


    /**
     * 赛队总成绩
     */

    @TableField(value = "saishifenshu_chengji")
    private Integer saishifenshuChengji;


    /**
     * 参加的赛事
     */

    @TableField(value = "saiduichengjia_text")
    private String saiduichengjiaText;


    /**
     * 赛队详情
     */

    @TableField(value = "saiduichengjib_text")
    private String saiduichengjibText;


    /**
     * 创建时间  show1 show2 photoShow
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat

    @TableField(value = "create_time")
    private Date createTime;


    /**
	 * 设置：主键
	 */
    public Integer getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Integer id) {
        this.id = id;
    }
    /**
	 * 设置：赛队名称
	 */
    public String getSaiduichengjiName() {
        return saiduichengjiName;
    }


    /**
	 * 获取：赛队名称
	 */

    public void setSaiduichengjiName(String saiduichengjiName) {
        this.saiduichengjiName = saiduichengjiName;
    }
    /**
	 * 设置：赛队人数
	 */
    public Integer getSaiduichengjiNumbe() {
        return saiduichengjiNumbe;
    }


    /**
	 * 获取：赛队人数
	 */

    public void setSaiduichengjiNumbe(Integer saiduichengjiNumbe) {
        this.saiduichengjiNumbe = saiduichengjiNumbe;
    }
    /**
	 * 设置：赛队所属地区
	 */
    public String getSaiduichengjiaAddress() {
        return saiduichengjiaAddress;
    }


    /**
	 * 获取：赛队所属地区
	 */

    public void setSaiduichengjiaAddress(String saiduichengjiaAddress) {
        this.saiduichengjiaAddress = saiduichengjiaAddress;
    }
    /**
	 * 设置：赛队所在地址
	 */
    public String getSaiduichengjibAddress() {
        return saiduichengjibAddress;
    }


    /**
	 * 获取：赛队所在地址
	 */

    public void setSaiduichengjibAddress(String saiduichengjibAddress) {
        this.saiduichengjibAddress = saiduichengjibAddress;
    }
    /**
	 * 设置：赛队总成绩
	 */
    public Integer getSaishifenshuChengji() {
        return saishifenshuChengji;
    }


    /**
	 * 获取：赛队总成绩
	 */

    public void setSaishifenshuChengji(Integer saishifenshuChengji) {
        this.saishifenshuChengji = saishifenshuChengji;
    }
    /**
	 * 设置：参加的赛事
	 */
    public String getSaiduichengjiaText() {
        return saiduichengjiaText;
    }


    /**
	 * 获取：参加的赛事
	 */

    public void setSaiduichengjiaText(String saiduichengjiaText) {
        this.saiduichengjiaText = saiduichengjiaText;
    }
    /**
	 * 设置：赛队详情
	 */
    public String getSaiduichengjibText() {
        return saiduichengjibText;
    }


    /**
	 * 获取：赛队详情
	 */

    public void setSaiduichengjibText(String saiduichengjibText) {
        this.saiduichengjibText = saiduichengjibText;
    }
    /**
	 * 设置：创建时间  show1 show2 photoShow
	 */
    public Date getCreateTime() {
        return createTime;
    }


    /**
	 * 获取：创建时间  show1 show2 photoShow
	 */

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

}
