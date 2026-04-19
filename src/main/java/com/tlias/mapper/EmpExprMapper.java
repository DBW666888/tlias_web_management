package com.tlias.mapper;

import com.tlias.pojo.EmpExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmpExprMapper {
    //批量保存员工的工作经历信息
    void insertBatch(List<EmpExpr> exprList);

    //根据员工id删除员工工作经历信息
    void deleteByEmpIds(List<Integer> empIds);
}
