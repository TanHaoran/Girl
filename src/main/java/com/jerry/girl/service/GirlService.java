package com.jerry.girl.service;

import com.jerry.girl.domain.Girl;
import com.jerry.girl.enums.ResultEnum;
import com.jerry.girl.exception.GirlException;
import com.jerry.girl.repository.GirlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/4
 * Time: 20:53
 * Description:
 */
@Service
public class GirlService {

    @Autowired
    private GirlRepository girlRepository;

    @Transactional
    public void insertTwo() {
        Girl girlA = new Girl();
        girlA.setCupSize("A");
        girlA.setAge(21);
        girlRepository.save(girlA);


        Girl girlB = new Girl();
        girlB.setCupSize("BB");
        girlB.setAge(22);
        girlRepository.save(girlB);
    }

    public void getAge(Integer id) throws Exception {
        Girl girl = girlRepository.findOne(id);
        Integer age = girl.getAge();
        if (age <= 10) {
            throw new GirlException(ResultEnum.PRIMARY_SCHOOL);
        } else if (age > 10 && age <= 16) {
            throw new GirlException(ResultEnum.MIDDLE_SCHOOL);
        }
    }

    public Girl findOne(Integer id) {
        return girlRepository.findOne(id);
    }


}
