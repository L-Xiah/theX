package fv.mapper;


import fv.model.CompanyTheDictionary;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Mapper//@Repository
public interface CompanyTheDicMapper {

    @Select("SELECT * FROM company_thedic WHERE id = #{id}")
    CompanyTheDictionary selectUser(int id);




}