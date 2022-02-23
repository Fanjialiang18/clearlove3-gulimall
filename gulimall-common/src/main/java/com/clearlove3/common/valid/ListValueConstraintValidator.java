package com.clearlove3.common.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.HashSet;
import java.util.Set;

/**
 * @author clearlove3
 * @date 2022/2/23 15:06
 */
public class ListValueConstraintValidator implements ConstraintValidator<ListValue,Integer> {
    private Set<Integer> set=new HashSet<>();
    /**
     * 判断是否校验成功
     */
    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        return set.contains(integer);
    }

    /**
     * 初始化方法
     */
    @Override
    public void initialize(ListValue constraintAnnotation) {
        int[] vals=constraintAnnotation.vals();
        for (int val : vals) {
            if(set!=null){
                set.add(val);
            }
        }
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
