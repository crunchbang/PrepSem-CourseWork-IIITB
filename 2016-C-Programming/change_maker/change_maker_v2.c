#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int string_to_int(char *s);

int main()
{


        char *delim = ",";
        char *token;
        char input[50];
        char inp_line[50];

        int denom[50];
        int n_denom = 0;
        int denom_count[50];
        scanf("%s", input);
        strcpy(inp_line, input);
        token = strtok(input, delim);
        while (token != NULL) {

                char *s = token;
                sscanf(s, "%d:%d", &denom[n_denom], &denom_count[n_denom]);
                n_denom++;

                token = strtok(NULL, delim);
        }

        int value;
        char number[50] = {0};
        char test_cases[50][50] = {0};
        int n_test = 0;
        while (scanf("%s", number) != EOF) {
                value = string_to_int(number);
                int temp = value;
                strcpy(test_cases[n_test], "");
                for (int i = 0; i < n_denom; ++i) {
                        int x;
                        if ((denom_count[i]) &&  (x = temp / denom[i])) {
                                char s[50] = {0};
                                if (x <= denom_count[i]) {
                                        temp = temp - (x * denom[i]);
                                        sprintf(s, "%d:%d,", denom[i], x);
                                        denom_count[i] -= x;
                                } else {
                                        temp = temp - (denom_count[i] * denom[i]);
                                        sprintf(s, "%d:%d,", denom[i], denom_count[i]);
                                        denom_count[i] = 0;
                                }
                                strcat(test_cases[n_test], s);
                        }
                }
                n_test++;
        }

        for (int i = 0; i < n_denom; ++i) {
                printf("%d:%d,", denom[i], denom_count[i]);
        }
        printf("\n");
        for (int i = 0; i < n_test; ++i) {
                printf("%s\n", test_cases[i]);
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
