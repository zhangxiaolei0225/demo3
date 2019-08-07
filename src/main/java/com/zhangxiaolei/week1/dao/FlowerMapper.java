package com.zhangxiaolei.week1.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.zhangxiaolei.week1.domain.Flower;
import com.zhangxiaolei.week1.domain.Types;

public interface FlowerMapper {
	/**
	 * 
	 * @Title: selects 
	 * @Description: 模糊查询的列表展示方法
	 * @param f
	 * @return
	 * @return: List<Flower>
	 */
	List<Flower> selects(Flower f);
	/**
	 * 
	 * @Title: getflowerbyid 
	 * @Description: 单查用于查看回显
	 * @param id
	 * @return
	 * @return: Flower
	 */
	@Select("select f.*,t.tname from flower f left join types t on f.tid = t.tid where id = #{id}")
	Flower getflowerbyid(Integer id);
	/**
	 * 
	 * @Title: gettypelist 
	 * @Description: 全查类型表
	 * @return
	 * @return: List<Types>
	 */
	@Select("select * from types")
	List<Types> gettypelist();
	/**
	 * 
	 * @Title: add 
	 * @Description: 添加方法
	 * @param f
	 * @return
	 * @return: int
	 */
	@Insert("insert into flower set name = #{name},dir = #{dir},tid = #{tid}")
	int add(Flower f);
	/**
	 * 
	 * @Title: update 
	 * @Description: 修改方法
	 * @param f
	 * @return
	 * @return: int
	 */
	@Update("update flower set name = #{name},dir = #{dir},tid = #{tid} where id = #{id}")
	int update(Flower f);
	/**
	 * 
	 * @Title: deletebyid 
	 * @Description: 单删方法
	 * @param id
	 * @return
	 * @return: int
	 */
	@Delete("delete from flower where id = #{id}")
	int deletebyid(Integer id);
	/**
	 * 
	 * @Title: deletes 
	 * @Description: 批删方法
	 * @param ids
	 * @return
	 * @return: int
	 */
	int deletes(@Param("ids")Integer[] ids);
}
