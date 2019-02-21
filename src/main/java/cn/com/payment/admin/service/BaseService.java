package cn.com.payment.admin.service;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import cn.com.payment.admin.exceptions.BaseException;

public interface BaseService<T extends Object, PK extends Serializable> {
	/**
	 * 添加
	 * 
	 * @param t
	 * @return
	 */
	PK create(T t) throws BaseException;

	/**
	 * 批量增加
	 * 
	 * @param e
	 * @throws Exception
	 */
	void batchCreate(Collection<T> e) throws BaseException;

	/**
	 * 修改
	 * 
	 * @param t
	 */
	Long modify(T t) throws BaseException;

	/**
	 * 删除
	 * 
	 * @throws DataAccessException
	 */

	Long remove(PK pk) throws BaseException;

	/**
	 * 删除
	 * 
	 * @throws DataAccessException
	 */

	void remove(PK... pks) throws BaseException;

	/**
	 * 根据主键查询
	 * 
	 * @param pk
	 * @return DataAccessException
	 */
	T searchById(PK pk) throws BaseException;

	/**
	 * 
	 * @return
	 * @throws DataAccessException
	 */
	List<T> searchAll() throws BaseException;

	/**
	 * 
	 * @param t
	 * @return
	 * @throws BizException
	 */
	List<T> searchByProperty(T t) throws DataAccessException;

}
