package com.proj.salad.prod.dao;

import com.proj.salad.prod.vo.NutrientVO;
import com.proj.salad.prod.vo.ProdVO;
import org.springframework.dao.DataAccessException;

import java.util.List;

public interface ProdDAO {
    public List<ProdVO> selectProdList() throws DataAccessException;
    public NutrientVO selectProdNutrient(int prodNum) throws DataAccessException;
}
