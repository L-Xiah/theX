package fv.dao;

import fv.pojo.Test;
import org.springframework.stereotype.Repository;

/**
 * Test的Mapper
 */
@Repository
public interface TestMapper {
    Test selectByPrimaryKey(Integer id);
}