package org.unicorn.framework.core.dto;

import org.apache.commons.lang3.StringUtils;

import javax.validation.ValidationException;

public class ExampleDto implements ValidatorDto {

    private String id;
    private String name;
    private String mobile;

    @Override
    public void validate() {
        if(StringUtils.isBlank(this.id)){
            if(StringUtils.isBlank(this.name) || StringUtils.isBlank(this.mobile)){
                throw new IllegalArgumentException("ID为空时，名称或手机号码不能为空！");
            }
        }
    }

}
