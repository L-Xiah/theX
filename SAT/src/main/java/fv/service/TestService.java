package fv.service;

import fv.dao.TestMapper;
import fv.pojo.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 测试服务接口
 */
@Service
public class TestService {
    @Autowired//(required = false)
    private TestMapper testMapper ;//= null;

    public Test getById(int id) {
        return testMapper.selectByPrimaryKey(id);
    }
}