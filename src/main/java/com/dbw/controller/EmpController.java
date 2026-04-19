package com.dbw.controller;

import com.dbw.pojo.Emp;
import com.dbw.pojo.EmpQueryParam;
import com.dbw.pojo.PageResult;
import com.dbw.pojo.Result;
import com.dbw.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

//员工管理Controller
@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {
    @Autowired
    private EmpService empService;

    @GetMapping
    //分页查询
    public Result page(EmpQueryParam empQueryParam) {
        log.info("分页查询：{}",empQueryParam);
        PageResult<Emp> pageResult=empService.page(empQueryParam);
        return Result.success(pageResult);
    }


    //新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("新增员工:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    /*//删除员工(数组接收)
    @DeleteMapping
    public Result delete(Integer[] ids){
        log.info("删除员工:{}", Arrays.toString(ids));
        return Result.success();
    }*/

    //删除员工(集合接收)
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除员工:{}",ids);
        empService.delete(ids);
        return Result.success();
    }

    //根据id查询员工信息
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id){
        log.info("获取员工信息:{}",id);
        Emp emp=empService.getInfo(id);
        return Result.success(emp);
    }

    //修改员工信息
    @PutMapping
    public Result update(@RequestBody Emp emp){
        log.info("修改员工信息:{}",emp);
        empService.update(emp);
        return Result.success();
    }



}
