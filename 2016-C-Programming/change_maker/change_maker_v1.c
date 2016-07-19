#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int string_to_int(char *s);
static int compare_num(const void *p1, const void *p2);

int main()
{


        char *delim = ",";
        char *token;
        char input[20];
        char inp_line[20];

        int denom[20];
        int n_denom = 0;
        //read line
        scanf("%s", input);
        strcpy(inp_line, input);
        //tokenize
        token = strtok(input, delim);
        while (token != NULL) {

                denom[n_denom++] = string_to_int(token);

                token = strtok(NULL, delim);
        }

        printf("%s\n", inp_line);
        qsort(denom, n_denom, sizeof(int), compare_num);

        int value;
        char number[15] = {0};
        while (scanf("%s", number) != EOF) {
                value = string_to_int(number);
                int count[20] = {0};
                int temp = value;
                for (int i = 0; i < n_denom; ++i) {
                        count[i] = temp / denom[i];
                        temp = temp - (count[i] * denom[i]);
                        if (count[i])
                                printf("%d:%d,", denom[i], count[i]);
                }
                printf("\n");
        }
        return 0;
}


int string_to_int(char *s)
{
        int result = 0;
        for (int i = 0; i < strlen(s); ++i) 
                result = result * 10 + (s[i] - '0');

        return result;
}

static int compare_num(const void *p1, const void *p2)
{
        int a = *(const int *)p1;
        int b = *(const int *)p2;
        return (b - a);
}
