package com.tlias.mapper;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

//员工信息
@Mapper
public interface EmpMapper {
    /*1.原始查询方法
    //查询总记录数
    @Select("select count(*) from emp e left join dept d on e.dept_id=d.id")
    public Long count();

    //分页查询
    @Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id order by e.update_time desc limit #{start}, #{pageSize}")
    public List<Emp> list(Integer start, Integer pageSize);
     */

    //2.PageHelper方法
    //分页查询（可用xml的方法）
    //@Select("select e.*, d.name deptName from emp as e left join dept as d on e.dept_id = d.id order by e.update_time desc")
    //public List<Emp> list(String name, Integer gender, LocalDate begin, LocalDate end);


    //条件查询员工信息的方法
    public List<Emp> list(EmpQueryParam empQueryParam);

    //新增员工基本信息
    @Options(useGeneratedKeys = true, keyProperty = "id")//获取生成的id
    @Insert("insert into emp(username, name, gender, phone, job, salary, image, entry_date, dept_id, create_time, update_time) " +
            "values (#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    //根据id批量删除员工
    void deleteByIds(List<Integer> ids);

    //根据id查询员工信息及工作经历信息
    Emp getById(Integer id);

    //根据id更新员工信息
    void updateById(Emp emp);

    //统计员工职位人数
    @MapKey("pos")
    List<Map<String, Object>> countEmpJobData();

    //统计员工性别人数
    @MapKey("name")
    List<Map<String, Object>> countEmpGenderData();

    //根据用户名和密码查询员工信息
    @Select("select id,username,name from emp where username=#{username} and password=#{password}")
    Emp selectByUsernameAndPassword(Emp emp);
}
