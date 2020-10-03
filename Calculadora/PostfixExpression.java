package com.moesiof.opei2019;

import java.util.Scanner;
import java.util.Stack;

public class PostfixExpression
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String expression = input.nextLine();
        input.close();

        Expression postFix = new Expression(expression);
        System.out.println(postFix.result);
    }
}

class Expression //Classe que possui a expressão em Postfix
{
    private String[] subExpressions; //Conjunto de subexpressões divididas por " "
    private Stack<Integer> numbers = new Stack<Integer>(); //Stack temporário para armazenar os números
    int result = 0; //Resultado final da expressão

    private void setExpression()
    {
        for(int i = 0; i < subExpressions.length; i++) //Percorre todas subexpressões
        {
            String current = subExpressions[i];
            try //Testa se é um número
            {
                int number = Integer.parseInt(current);
                numbers.push(number);
            }
            catch (Exception ex) //Do contrário é um Char (A exceção não precisa ser tratada)
            {
                pResult(new Operator(current.toCharArray()[0])); //Cria a instãncia do operador e roda o método para calcular o resultado parcial (Dos dois últimos números + operador)
            }
        }

        result = numbers.pop(); //O Resultado final será o último número do Stack
    }


    private void pResult(Operator operator)
    {
        int pResult = 0;
        int b = numbers.pop();
        int a = numbers.pop();
        pResult = operator.valueOfOperation(a,b);
        numbers.push(pResult);
    }

    Expression(String expression)
    {
        subExpressions = expression.split(" ");
        setExpression();
    }
}

class Operator //Classe responsável por identificar uma operação por um char
{
    char identificator;

    int valueOfOperation(int a, int b)
    {
        switch (identificator)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a*b;
            case '/':
                return a/b;
        }

        return Integer.MIN_VALUE;
    }

    Operator(char identificator)
    {
        this.identificator = identificator;
    }
}
