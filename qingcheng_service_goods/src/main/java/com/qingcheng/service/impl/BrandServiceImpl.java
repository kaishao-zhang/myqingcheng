package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.good.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

/**
 * @author 凯少
 * @create 2019-11-18 19:44
 */
@Service
public class BrandServiceImpl implements BrandService {
    @Autowired
    private BrandMapper brandMapper;
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    public PageResult<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> pageResult = (Page<Brand>) brandMapper.selectAll();
        if (pageResult != null) {
            return new PageResult<>(pageResult.getTotal(),pageResult.getResult());
        }
        return null;
    }

    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = creatExample(searchMap);
        return brandMapper.selectByExample(example);
    }

    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
      /*  PageHelper.startPage(page, size);
        Example example = creatExample(searchMap);
       Page<Brand> pageResult = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<>(pageResult.getTotal(),pageResult.getResult());*/
        PageHelper.startPage(page,size);
        Example example= creatExample(searchMap);
        Page<Brand>brands=(Page<Brand>)brandMapper.selectByExample(example);
        return new PageResult<Brand>(brands.getTotal(),brands.getResult());
    }

    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 创建一个品牌模糊查询的条件方法
     * @param searchMap
     * @return
     */
    private Example creatExample(Map<String, Object> searchMap){
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            //根据名称模糊查询
            if(searchMap.get("name") != null && !"".equals(searchMap.get("name")) ){
                criteria.andLike("name","%"+(String) searchMap.get("name")+"%");
            }
            if(searchMap.get("letter") != null && !"".equals(searchMap.get("letter")) ){
                criteria.andEqualTo("letter",(String) searchMap.get("letter"));
            }
        }
        return  example;
    }

}
