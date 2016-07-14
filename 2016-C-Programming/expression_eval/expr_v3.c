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
int precd(char op);



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
#ifdef DEBUG
                printf("##op_%s\n", op_stack);
                printf("##%c\n", c);
#endif
                if (isalpha(c)) {
                        ex_push(value);
                        i++;
                } else if (isdigit(c)) {
                        num = to_int(c);
                        while(isdigit(expression[++i])) 
                                num = num * 10 + to_int(expression[i]); 
                        ex_push(num);
                } else {
                        i++;
                        if (op_top == -1|| c == '(' || (precd(c) > precd(op_stack[op_top]))) 
                                op_push(c);
                        else if (c == ')') {
                                while (op_stack[op_top] != '(')
                                        do_calc();
                                op_top--;
                        } else {
                                while (op_stack[op_top] != '(' && (precd(c) <= precd(op_stack[op_top])))
                                        do_calc();
                                op_push(c);
                        }

                }
        }
        while (op_top != -1)
                do_calc();
        return ex_pop();

}

void do_calc()
{

        char operator = op_pop();
        float op2 = ex_pop();
        float op1 = ex_pop();

#ifdef DEBUG
        printf("do_calc#%f %c %f\n", op1, operator, op2);
#endif
        switch(operator) {
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

#ifdef DEBUG
        printf("after_do_calc#top:%c %f\n", op_stack[op_top], ex_stack[ex_top]);
#endif

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

int precd(char op) 
{
        int p;
        switch(op) {
                case '^':   p = 3;
                            break;
                case '*':
                case '/':   p = 2;
                            break;
                case '+':
                case '-':   p = 1;
                            break;
                default:    p = 0;
        }
        return p;
}

