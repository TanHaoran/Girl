package com.jerry.girl.controller;

import com.jerry.girl.aspect.HttpAspect;
import com.jerry.girl.domain.Girl;
import com.jerry.girl.domain.Result;
import com.jerry.girl.repository.GirlRepository;
import com.jerry.girl.service.GirlService;
import com.jerry.girl.util.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/3
 * Time: 19:06
 * Description:
 */
@RestController
public class GirlController {

    private static final Logger logger = LoggerFactory.getLogger(HttpAspect.class);

    @Autowired
    private GirlRepository girlRepository;

    @Autowired
    private GirlService girlService;

    @GetMapping("/girls")
    public List<Girl> girlList() {
        logger.info("girlList执行了");
        return girlRepository.findAll();
    }

    @PostMapping("/girls")
    public Result<Girl> girlAdd(@Valid Girl girl, BindingResult result) {
        if (result.hasErrors()) {
            System.out.println(result.getFieldError().getDefaultMessage());
            return null;
        }
        Girl g = new Girl();
        g.setCupSize(girl.getCupSize());
        g.setAge(girl.getAge());
        g.setMoney(girl.getMoney());
        return ResultUtil.success(girlRepository.save(girl));
    }

    @GetMapping("/girls/{id}")
    public Girl girlFindOne(@PathVariable("id") Integer id) {
        return girlRepository.findOne(id);
    }

    @PutMapping("/girls/{id}")
    public Girl girlUpdate(@PathVariable("id") Integer id,
                           @RequestParam("cupSize") String cupSize,
                           @RequestParam("age") Integer age,
                           @RequestParam("money") Double money) {
        Girl girl = new Girl();
        girl.setId(id);
        girl.setCupSize(cupSize);
        girl.setAge(age);
        girl.setMoney(money);

        return girlRepository.save(girl);
    }

    @DeleteMapping("/girls/{id}")
    public void girlDelete(@PathVariable("id") Integer id) {
        girlRepository.delete(id);
    }

    @GetMapping("/girls/age/{age}")
    public List<Girl> girlListByAge(@PathVariable("age") Integer age) {
        return girlRepository.findByAge(age);
    }

    @PostMapping("/girls/two")
    public void girlTwo() {
        girlService.insertTwo();
    }

    @GetMapping("/girls/getAge/{id}")
    public void getAge(@PathVariable("id") Integer id) throws Exception{
        girlService.getAge(id);
    }
}
