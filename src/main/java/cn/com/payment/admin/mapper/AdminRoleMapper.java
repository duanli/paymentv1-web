package cn.com.payment.admin.mapper;

import org.springframework.dao.DataAccessException;

import cn.com.payment.admin.model.AdminRole;

/**
 * 代码生成器自动生成
 * Date:2015-6-10 16:41:38
 * @author rono
 */
public interface AdminRoleMapper extends BaseMapper<AdminRole,Long>{
	void deleteByRoleIds(Long[] ids)throws DataAccessException;
}