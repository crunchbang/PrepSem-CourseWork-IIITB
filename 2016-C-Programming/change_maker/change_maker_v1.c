#include <stdio.h>
#include <string.h>

int string_to_int(char *s);

int main()
{


        char *delim = ",";
        char *token;
        char input[20];

        int denom[20];
        int n_denom = 0;
        //read line
        scanf("%s", input);
        //tokenize
        token = strtok(input, delim);
        while (token != NULL) {

                denom[n_denom++] = string_to_int(token);

                token = strtok(NULL, delim);
        }
        
        //TODO: set up input loop

        int value;
        scanf("%d", &value);
        int result_denom_num[20] = {0};
        int intr_value = value;
        for (int i = 0; i < n_denom; ++i) {
                if (
                while (intr_value / denom[i]) {
                        intr_value -= denom[i];
                        result_denom_num[i]++;
                }
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
