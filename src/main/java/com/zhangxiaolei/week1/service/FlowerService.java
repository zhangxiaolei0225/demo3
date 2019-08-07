package com.zhangxiaolei.week1.service;



import java.util.List;

import com.github.pagehelper.PageInfo;
import com.zhangxiaolei.week1.domain.Flower;
import com.zhangxiaolei.week1.domain.Types;

public interface FlowerService {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 分页模糊  列表展示
	 * @param f
	 * @param pageNum
	 * @param pageSize
	 * @return
	 * @return: PageInfo<Flower>
	 */
	PageInfo<Flower> selects(Flower f,Integer pageNum,Integer pageSize);
	/**
	 * 
	 * @Title: getflowerbyid 
	 * @Description: 单查方法用于回显
	 * @param id
	 * @return
	 * @return: Flower
	 */
	Flower getflowerbyid(Integer id);
	/**
	 * 
	 * @Title: gettypelist 
	 * @Description: 全查类型表
	 * @return
	 * @return: List<Types>
	 */
	List<Types> gettypelist();
/**
 * 
 * @Title: add 
 * @Description: 添加方法
 * @param f
 * @return
 * @return: int
 */
	int add(Flower f);
/**
 * 
 * @Title: update 
 * @Description:修稿 方法
 * @param f
 * @return
 * @return: int
 */
	int update(Flower f);
/**
 * 
 * @Title: deletebyid 
 * @Description: 单删TODO
 * @param id
 * @return
 * @return: int
 */
	int deletebyid(Integer id);
/**
 * 
 * @Title: deletes 
 * @Description: 批删
 * @param ids
 * @return
 * @return: int
 */
	int deletes(Integer[] ids);

	

}
