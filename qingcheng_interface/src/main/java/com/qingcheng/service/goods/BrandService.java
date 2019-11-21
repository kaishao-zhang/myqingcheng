package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.good.Brand;

import java.util.List;
import java.util.Map;

/**
 * @author 凯少
 * @create 2019-11-18 19:42
 */
public interface BrandService {
    //查找所有的品牌信息
    public List<Brand> findAll();
    //查找所有的品牌信息带分页
    public PageResult<Brand> findPage(int page, int size);
    //查找所有的品牌信息带模糊查询
    List<Brand> findList(Map<String, Object> searchMap);
    //查找所有的品牌信息带模糊条件和分页
    PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size);
    //根据品牌id查询品牌
    Brand findById(Integer id);

    void add(Brand brand);

    void update(Brand brand);

    void delete(Integer id);
}
