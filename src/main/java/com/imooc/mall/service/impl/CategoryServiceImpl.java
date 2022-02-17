package com.imooc.mall.service.impl;

import com.imooc.mall.consts.MallConst;
import com.imooc.mall.dao.CategoryMapper;
import com.imooc.mall.pojo.Category;
import com.imooc.mall.service.ICategoryService;
import com.imooc.mall.vo.CategoryVo;
import com.imooc.mall.vo.ResponseVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static com.imooc.mall.consts.MallConst.ROOT_PARENT_ID;

/**
 * @author SaoE
 * @date 2022/2/11 15:54
 */
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 一次全部查出，在拿到的数据里进行操作
     *
     * 耗时：http（请求微信api） > 磁盘 > 内存（最快）
     * mysql（内网+磁盘）
     * @return
     */
    @Override
    public ResponseVo<List<CategoryVo>> selectAll() {
        List<Category> categories = categoryMapper.selectAll();

        //查出parent_id = 0
//        List<CategoryVo> categoryVoList = new ArrayList<>();
//        for (Category category:categories){
//            if (category.getParentId().equals(ROOT_PARENT_ID)){
//                CategoryVo categoryVo = new CategoryVo();
//                BeanUtils.copyProperties(category,categoryVo);
//                categoryVoList.add(categoryVo);
//            }
//        }


        //lambda +stream
        List<CategoryVo> categoryVoList = categories.stream()
                //只需要ParentId等于0的数据
                .filter(e -> e.getParentId().equals(ROOT_PARENT_ID))
                .map(this::categoryToCategoryVo)
                //对一级目录排序（从大到小）
                .sorted(Comparator.comparing(CategoryVo::getSortOrder).reversed())
                .collect(Collectors.toList());

        //查询子目录
        findSubCategory(categoryVoList,categories);

        return ResponseVo.success(categoryVoList);
    }

    @Override
    public void findSubCategoryId(Integer id, Set<Integer> resultSet) {
        List<Category> categories = categoryMapper.selectAll();
        findSubCategoryId(id,resultSet,categories);
    }

    private void findSubCategoryId(Integer id, Set<Integer> resultSet,List<Category> categories){
        for (Category category : categories) {
            if (category.getParentId().equals(id)){
                resultSet.add(category.getId());
                findSubCategoryId(category.getId(),resultSet,categories);
            }
        }
    }

    private void findSubCategory(List<CategoryVo> categoryVoList,List<Category> categories){
        for (CategoryVo categoryVo : categoryVoList) {
            List<CategoryVo> subCategoryVoList = new ArrayList<>();

            for (Category category : categories) {
                //如果查到内容，设置subCategory，还要继续往下查
                if (categoryVo.getId().equals(category.getParentId())){
                    CategoryVo subcategoryVo = categoryToCategoryVo(category);
                    subCategoryVoList.add(subcategoryVo);
                }

                //对一级目录以外的目录层次排序(从大到小排序)
                subCategoryVoList.sort(Comparator.comparing(CategoryVo::getSortOrder).reversed());
                //插入数据
                categoryVo.setSubCategories(subCategoryVoList);

                findSubCategory(subCategoryVoList,categories);
            }
        }
    }

    private CategoryVo categoryToCategoryVo(Category category){
        CategoryVo categoryVo = new CategoryVo();
        BeanUtils.copyProperties(category,categoryVo);
        return categoryVo;
    }
}
