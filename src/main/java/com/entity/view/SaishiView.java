package com.entity.view;

import com.entity.SaishiEntity;
import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;
import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.io.Serializable;
import java.util.Date;

/**
 * 赛事信息
 * 后端返回视图实体辅助类
 * （通常后端关联的表或者自定义的字段需要返回使用）
 */
@TableName("saishi")
public class SaishiView extends SaishiEntity implements Serializable {
    private static final long serialVersionUID = 1L;

		/**
		* 赛事类型的值
		*/
		private String saishiValue;
		/**
		* 赛事状态的值
		*/
		private String saishiStatusValue;



		//级联表 richeng
			/**
			* 日程标题
			*/
			private String richengName;
			/**
			* 场次
			*/
			private String richengChangci;
			/**
			* 时间段
			*/
			private Integer shijianduanTypes;
				/**
				* 时间段的值
				*/
				private String shijianduanValue;
			/**
			* 时间信息
			*/
			@JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
			@DateTimeFormat
			private Date richengTime;

	public SaishiView() {

	}

	public SaishiView(SaishiEntity saishiEntity) {
		try {
			BeanUtils.copyProperties(this, saishiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}



			/**
			* 获取： 赛事类型的值
			*/
			public String getSaishiValue() {
				return saishiValue;
			}
			/**
			* 设置： 赛事类型的值
			*/
			public void setSaishiValue(String saishiValue) {
				this.saishiValue = saishiValue;
			}
			/**
			* 获取： 赛事状态的值
			*/
			public String getSaishiStatusValue() {
				return saishiStatusValue;
			}
			/**
			* 设置： 赛事状态的值
			*/
			public void setSaishiStatusValue(String saishiStatusValue) {
				this.saishiStatusValue = saishiStatusValue;
			}








				//级联表的get和set richeng

					/**
					* 获取： 日程标题
					*/
					public String getRichengName() {
						return richengName;
					}
					/**
					* 设置： 日程标题
					*/
					public void setRichengName(String richengName) {
						this.richengName = richengName;
					}

					/**
					* 获取： 场次
					*/
					public String getRichengChangci() {
						return richengChangci;
					}
					/**
					* 设置： 场次
					*/
					public void setRichengChangci(String richengChangci) {
						this.richengChangci = richengChangci;
					}

					/**
					* 获取： 时间段
					*/
					public Integer getShijianduanTypes() {
						return shijianduanTypes;
					}
					/**
					* 设置： 时间段
					*/
					public void setShijianduanTypes(Integer shijianduanTypes) {
						this.shijianduanTypes = shijianduanTypes;
					}


						/**
						* 获取： 时间段的值
						*/
						public String getShijianduanValue() {
							return shijianduanValue;
						}
						/**
						* 设置： 时间段的值
						*/
						public void setShijianduanValue(String shijianduanValue) {
							this.shijianduanValue = shijianduanValue;
						}

					/**
					* 获取： 时间信息
					*/
					public Date getRichengTime() {
						return richengTime;
					}
					/**
					* 设置： 时间信息
					*/
					public void setRichengTime(Date richengTime) {
						this.richengTime = richengTime;
					}












}
