#include <stdio.h>
#include <ctype.h>
#include <math.h>
#include <string.h>

/*
 * Based on the assumption that the input is of the form
 * A(x)=E
 * where 
 * A can be any uppercase alphabet 
 * x can be any lower case alphabet
 * E is an expression comprising x and one or more of the operators +,-,*,/,^
 * For ease it is assumed that there are no spaces in the program input and len(expession) < 20 characters
 */

char expression[20];

float ex_stack[5] = {0};
char op_stack[5] = {0};

int ex_top = -1;
int op_top = -1;


void ex_push(float val);
float ex_pop();
void op_push(char op);
char op_pop();
float eval_expression(int value);
int to_int(char val);
void do_calc();
void reset_stack();



int main()
{
        //read expression
        scanf("%s", expression);
        printf("%s\n", expression);

        int value;

        scanf("%d", &value);
        while (value != 1000) {
                printf("%c(%d)=%0.2f\n", expression[0], value, eval_expression(value));
                reset_stack();
                scanf("%d", &value);
        }

        return 0;
}

float eval_expression(int value)
{
        
        char c;
        int i=0; 
        float num;

        while(expression[i++] != '=');

        while ((c = expression[i]) != '\0') {
                if (isalpha(c)) {
                        ex_push(value);
                        i++;
                } else if (isdigit(c)) {
                        num = to_int(c);
                        while(isdigit(expression[++i])) 
                                num = num * 10 + to_int(expression[i]); 
                        ex_push(num);
                } else {
                        if (op_top == -1)
                                op_push(c);
                        else {
                                do_calc();
                                op_push(c);
                        }
                        i++;
                }
        }
        do_calc();
        return ex_pop();
}

void do_calc()
{
        char op = op_pop();
        float op2 = ex_pop();
        float op1 = ex_pop();

        switch(op) {
                case '+': ex_push(op1+op2);
                          break;
                case '-': ex_push(op1-op2);
                          break;
                case '*': ex_push(op1*op2);
                          break;
                case '/': ex_push(op1/op2);
                          break;
                case '^': ex_push(pow(op1,op2));
                          break;
        }
}

void ex_push(float val)
{
        ex_stack[++ex_top] = val;
}

float ex_pop()
{
        return ex_stack[ex_top--];
}

void op_push(char val)
{
        op_stack[++op_top] = val;
}

char op_pop()
{
        return op_stack[op_top--];
}

int to_int(char val) 
{
        return val - '0';
}

void reset_stack()
{
        ex_top = op_top = -1; 
}
