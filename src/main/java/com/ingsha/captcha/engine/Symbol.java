package com.ingsha.captcha.engine;

/**
 * @ClassName Symbol
 * @Description TODO
 * @Author Martin Yi
 * @Date 2024/4/2 14:03
 * @Version 1.0
 */
public enum Symbol {

    /**
     * 标识符
     */
    NUM("n", false),

    /**
     * 加法
     */
    ADD("+", false),

    /**
     * 减发
     */
    SUB("-", false),

    /**
     * 乘法
     */
    MUL("x", true),

    /**
     * 除法
     */
    DIV("÷", true);

    /**
     * 算数符号
     */
    private final String value;

    /**
     * 是否优先计算
     */
    private final boolean priority;

    public static Symbol of(String c) {
        Symbol[] values = Symbol.values();
        for (Symbol value : values) {
            if (value.value.equals(c)) {
                return value;
            }
        }
        throw new IllegalArgumentException("不支持的标识符，仅仅支持(+、-、×、÷)");
    }

    Symbol(String value, boolean priority) {
        this.value = value;
        this.priority = priority;
    }


    public String getValue() {
        return value;
    }

    public boolean isPriority() {
        return priority;
    }
}
