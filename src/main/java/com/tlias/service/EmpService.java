package com.tlias.service;

import com.tlias.pojo.Emp;
import com.tlias.pojo.EmpQueryParam;
import com.tlias.pojo.LoginInfo;
import com.tlias.pojo.PageResult;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    //分页查询，page：页码，pageSize：每页记录数
    //PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender, LocalDate begin, LocalDate end);
    PageResult<Emp> page(EmpQueryParam empQueryParam);

    //新增员工信息
    void save(Emp emp);

    //批量删除员工信息
    void delete(List<Integer> ids);

    //根据id查询员工信息
    Emp getInfo(Integer id);

    //修改员工信息
    void update(Emp emp);

    //员工登录
    LoginInfo login(Emp emp);
}
