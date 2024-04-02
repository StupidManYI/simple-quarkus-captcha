package com.ingsha;

import com.ingsha.captcha.ArithmeticCaptcha;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

@QuarkusTest
class ExampleResourceTest {
    @Test
    void testHelloEndpoint() {
        ArithmeticCaptcha captcha = new ArithmeticCaptcha(111, 36);
        captcha.setLen(2);  // 几位数运算，默认是两位
        captcha.getArithmeticString();  // 获取运算的公式：3+2=?
        String result = captcha.text();// 获取运算的结果：5
        captcha.supportAlgorithmSign(2); // 可设置支持的算法：2 表示只生成带加法的公式
        captcha.setDifficulty(20); // 设置计算难度，参与计算的每一个整数的最大值
        String base64 = captcha.toBase64();
        System.out.println(result);
        System.out.println(base64);

    }

}