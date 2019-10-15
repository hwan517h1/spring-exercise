package com.spring.spel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.stereotype.Component;

@Component
public class Runner implements ApplicationRunner {

    // #: Expression
    @Value("#{'Hello, ' + 'SpEL world!'}")
    String greeting;

    @Value("#{2000 + 19}")
    int year;

    @Value("#{0 eq 0}")
    boolean flag;

    // $: Property
    @Value("${value}")
    int value;

    // Expression 안에서 Property 사용 가능
    // Property 안에서 Expression 사용 불가능

    @Value("#{${value} eq 100}")
    boolean hybrid;

    // Bean 보기
    @Value("#{sample.data}")
    int data;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("[Test]");
        System.out.println(greeting);
        System.out.println(year);
        System.out.println(flag);
        System.out.println(value);
        System.out.println(hybrid);
        System.out.println(data);

        ExpressionParser expressionParser = new SpelExpressionParser();
        Expression expression = expressionParser.parseExpression("2000 + 19");
        Integer result = expression.getValue(Integer.class); // ConversionService 이용
        System.out.println(result);
    }
}
