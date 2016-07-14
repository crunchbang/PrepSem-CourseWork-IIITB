#include <stdio.h>
#include <string.h>

int to_int(char c);
void reverse(char *s);

int main()
{
        char n1[100] = {0}; 
        char n2[100] = {0};
        char result[101] = {0};

        scanf("%s", n1);
        scanf("%s", n2);

        int l1 = strlen(n1);
        int l2 = strlen(n2);
        int mx = l1 > l2 ? l1 : l2;

        reverse(n1);
        reverse(n2);

        printf("%s\n", n1);
        int i, carry = 0;
        int res;
        for (i = 0 ; i < mx; ++i) {
                res = carry + to_int(n1[i]) + to_int(n2[i]);
                result[i] = (res % 10) + '0';
                carry = res/10;

        }

        result[i] = carry + '0';
        reverse(result);
        printf("Result: %s\n", result);
        return 0;
}

int to_int(char c) 
{
        if (c == 0 || c == '\0')
                return 0;
        else
                return c - '0';
}

void reverse(char *s) 
{
        int len = strlen(s);
        int i, j;
        for (i = 0, j = len-1; i <= j; ++i, --j) {
                char temp = s[i];
                s[i] = s[j];
                s[j] = temp;
        }
}
                
