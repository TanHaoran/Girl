package com.jerry.girl.exception;

import com.jerry.girl.enums.ResultEnum;

/**
 * Created with IntelliJ IDEA.
 * User: Jerry
 * Date: 2018/3/17
 * Time: 18:59
 * Description:
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
