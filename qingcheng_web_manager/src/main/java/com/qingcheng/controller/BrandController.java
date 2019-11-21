package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.good.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author 凯少
 * @create 2019-11-18 19:48
 */
@RestController
@RequestMapping("/brand")
public class BrandController {
    @Reference
    private BrandService brandService;

    //查询品牌的所有信息
    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        System.out.println("进来了");
        return  brandService.findAll();
    }
    //查询品牌的所有信息加分页
    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page,int size){
        PageResult<Brand> result = brandService.findPage(page, size);
        return result;
    }
    //查询品牌的所有信息加模糊查询
    @PostMapping("/findList")
    public List<Brand> findList(@RequestBody Map<String,Object> searchMap){
        return brandService.findList(searchMap);
    }
    //查询品牌的所有信息加分页加模糊查询
    @PostMapping("/findPage")
    public PageResult<Brand> findPage(@RequestBody Map<String,Object> searchMap,int page,int size){
        System.out.println("进来了：");
        return brandService.findPage(searchMap,page,size);
    }
    //根据品牌的id查询品牌
    @GetMapping("findById")
    public Brand findById(Integer id){
        System.out.println("进来了id="+id);
        return brandService.findById(id);
    }
    //添加品牌信息
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand){
        brandService.add(brand);
        return new Result();
    }
    //修改品牌信息
    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }
    //删除品牌信息
    @GetMapping("/delete")
    public Result delete(Integer id){
        System.out.println("进入删除id="+id);
        brandService.delete(id);
        return new Result();
    }

}
