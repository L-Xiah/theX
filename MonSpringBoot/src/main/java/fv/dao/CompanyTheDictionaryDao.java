package fv.dao;

import fv.model.CompanyTheDictionary;
import fv.support.MyBatisRepository;
import org.apache.ibatis.annotations.Mapper;

//@MyBatisRepository
@Mapper
public interface CompanyTheDictionaryDao {

    CompanyTheDictionary get(Long value);

}
