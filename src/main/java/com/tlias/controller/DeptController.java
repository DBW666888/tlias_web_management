package com.tlias.controller;

import com.tlias.pojo.Dept;
import com.tlias.pojo.Result;
import com.tlias.service.DeptService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//部门管理Controller
@Slf4j
@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //@RequestMapping(value = "/depts",method = RequestMethod.GET)
    //查询部门
    @GetMapping
    public Result list() {
        //System.out.println("查询全部部门的数据");
        log.info("查询全部部门数据");
        List<Dept> deptList=deptService.findAll();
        return Result.success(deptList);
    }

//    //删除部门-方式一
//    @DeleteMapping("/depts")
//    public Result delete(HttpServletRequest request) {
//        String idStr=request.getParameter("id");
//        int id=Integer.parseInt(idStr);
//        System.out.println("根据id删除部门"+id);
//        return Result.success();
//    }


//    //删除部门-方式二
//    @DeleteMapping("/depts")
//    public Result delete(@RequestParam("id") Integer deptId) {
//        System.out.println("根据id删除部门"+deptId);
//        return Result.success();
//    }

    //删除部门-方式三
    @DeleteMapping
    public Result delete(Integer id) {
        //System.out.println("根据id删除部门:"+id);
        log.info("根据id删除部门:{}",id);
        deptService.deleteById(id);
        return Result.success();
    }


    //添加部门
    @PostMapping
    public Result add(@RequestBody Dept dept) {
        //System.out.println("添加部门:"+dept);
        log.info("添加部门：{}",dept);
        deptService.add(dept);
        return Result.success();
    }

    //根据id查询部门
    @GetMapping("/{id}")
    public Result getInfo(@PathVariable Integer id) {
        //System.out.println("查询id部门为："+id);
        log.info("查询id部门为：{}",id);
        Dept dept=deptService.getById(id);
        return Result.success(dept);
    }

    //修改部门
    @PutMapping
    public Result update(@RequestBody Dept dept) {
        //System.out.println("修改部门："+dept);
        log.info("修改部门：{}",dept);
        deptService.update(dept);
        return Result.success();
    }

}
