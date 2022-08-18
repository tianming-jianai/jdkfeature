package com.zsg.chapter02;

import com.zsg.pojo.Boy;
import com.zsg.pojo.Girl;
import org.junit.jupiter.api.Test;

import javax.swing.text.html.Option;
import java.util.Optional;

/**
 * @BelongsProject: jdkfeature
 * @BelongsPackage: com.zsg.chapter02
 * @Author: 张世罡
 * @CreateTime: 2022/8/18 21:28
 * @Description:
 */
public class OptionalTest {

    /**
     * Optional.of(T t) 创建一个Optional实例，必须非空
     * Optional.empty() 创建一个空的Optional实例
     * Optional.ofNullable(T t) t可以为null
     */
    @Test
    public void test1() {
        Girl girl = new Girl();
//        girl = null;
//        Optional<Girl> optionalGirl = Optional.of(girl);
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);
    }

    /**
     *
     */
    @Test
    public void test2() {
        Girl girl = new Girl();
        girl = null;
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        System.out.println(optionalGirl);

        Girl girl1 = optionalGirl.orElse(new Girl("Pen"));
        System.out.println(girl1);
    }

    public String getGirlName(Boy boy) {
        return boy.getGirl().getName();
    }

    /**
     *
     */
    @Test
    public void test3() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName(boy);
        System.out.println(girlName);
    }

    public String getGirlName2(Boy boy) {
        if (boy != null) {
            Girl girl = boy.getGirl();
            if (girl != null) {
                return girl.getName();
            }
        }
        return null;
    }

    /**
     *
     */
    @Test
    public void test4() {
        Boy boy = new Boy();
        boy = null;
        String girlName = getGirlName2(boy);
        System.out.println(girlName);
    }

    public String getGirlName3(Boy boy) {
        Optional<Boy> optionalBoy = Optional.ofNullable(boy);
        Boy boy1 = optionalBoy.orElse(new Boy(new Girl("Piano")));
        Girl girl = boy1.getGirl();
        Optional<Girl> optionalGirl = Optional.ofNullable(girl);
        Girl girl1 = optionalGirl.orElse(new Girl("Eraser"));
        return girl1.getName();
    }

    /**
     *
     */
    @Test
    public void test5() {
        Boy boy = new Boy();
        boy.setGirl(new Girl("Power"));
//        boy = null;
        String girlName = getGirlName3(boy);
        System.out.println(girlName);
    }
}
