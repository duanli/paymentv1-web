package cn.com.payment.admin.mapper;

import java.util.List;

import cn.com.payment.admin.exceptions.DBAccessException;
import cn.com.payment.admin.model.Role;
/**
 * 代码生成器自动生成
 * Date:2015-6-10 16:41:38
 * @author rono
 */
public interface RoleMapper extends BaseMapper<Role,Long>{
	public List<Role> selectAdminRolesByFK(Long id)throws DBAccessException;
}