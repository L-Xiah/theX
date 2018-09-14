package fv.service;

import fv.dao.CompanyTheDictionaryDao;
import fv.mapper.CompanyTheDicMapper;
import fv.model.CompanyTheDictionary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyTheDicService {


    private final
    CompanyTheDicMapper userMapper;
    private final
    fv.dao.CompanyTheDictionaryDao CompanyTheDictionaryDao;

    @Autowired
    public CompanyTheDicService(CompanyTheDicMapper userMapper, CompanyTheDictionaryDao CompanyTheDictionaryDao) {
        this.userMapper = userMapper;
        this.CompanyTheDictionaryDao = CompanyTheDictionaryDao;
    }



    public CompanyTheDictionary selectUser(int id) {
        return userMapper.selectUser(id);
    }

    public CompanyTheDictionary selectMapUser(int id) {
        return CompanyTheDictionaryDao.get((long)id);
    }

}
