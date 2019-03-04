package cn.com.payment.admin.service.impl;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

import org.springframework.dao.DataAccessException;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.mapper.BaseMapper;
import cn.com.payment.admin.service.BaseService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public abstract class BaseServiceImpl<T extends Object, PK extends Serializable> implements BaseService<T, PK> {

	public abstract BaseMapper<T, PK> getBaseMapper();

	@Override
	public PK create(T t) throws DBAccessException {

		try {
			return this.getBaseMapper().save(t);
		} catch (DataAccessException e) {
			log.error("create -> class:{}, message:{}", t.getClass().getSimpleName(), e.getMessage());
			throw new DBAccessException(e.getMessage(), "保存数据出错。");
		}
	}

	@Override
	public void batchCreate(Collection<T> t) throws DBAccessException {

		try {
			this.getBaseMapper().saveBatch(t);
		} catch (DataAccessException e) {
			log.error("batchCreate -> class:{},message:{}", t.getClass().getSimpleName(), e.getMessage());
			throw new DBAccessException(e.getMessage(), "保存数据出错。");
		}
	}

	@Override
	public Long modify(T t) throws DBAccessException {
		try {
			return this.getBaseMapper().update(t);
		} catch (DataAccessException e) {
			log.error("modify -> class:{},message:{}", t.getClass().getSimpleName(), e.getMessage());
			throw new DBAccessException(e.getMessage(), "修改数据出错。");
		}
	}

	@Override
	public Long remove(PK pk) throws DBAccessException {

		try {
			return this.getBaseMapper().deleteByPK(pk);
		} catch (DataAccessException e) {
			log.error("remove:{} -> class:{},message:{}", pk, e.getClass().getName(), e.getMessage());
			throw new DBAccessException(e.getMessage(), "删除数据出错。");
		}
	}

	@Override
	public void remove(PK... pks) throws DBAccessException {

		try {
			this.getBaseMapper().deleteByPKs(pks);
		} catch (DataAccessException e) {
			log.error("remove:{} -> class:{},message:{}", pks, e.getClass().getName(), e.getMessage());
			throw new DBAccessException(e.getMessage(), "删除数据出错。");
		}
	}

	@Override
	public T searchById(PK pk) throws DBAccessException {
		try {
			return (T) this.getBaseMapper().selectOne(pk);
		} catch (DataAccessException e) {
			log.error("searchById:{} -> class:{},message:{}", pk, e.getClass().getName(), e.getMessage());
			throw new DBAccessException(e.getMessage(), "查询数据出错。");
		}
	}

	@Override
	public List<T> searchAll() throws DBAccessException {
		try {

			return this.getBaseMapper().selectAll();
		} catch (DataAccessException e) {
			log.error("searchAll -> class:{},message:{}", e.getClass().getName(), e.getMessage());
			throw new DBAccessException(e.getMessage(), "查询数据出错。");
		}
	}

	@Override
	public List<T> searchByProperty(T t) throws DataAccessException {
		return this.getBaseMapper().selectByProperty(t);
	}

}