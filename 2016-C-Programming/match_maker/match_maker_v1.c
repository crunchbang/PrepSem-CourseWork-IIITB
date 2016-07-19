#include <stdio.h>
#include <string.h>


#define MAX_TERMS 20
#define MAX_LEN 100

int main() 
{
        char target_term[MAX_TERMS][MAX_TERMS];
        int  n_target_term = 0;
        char line[MAX_LEN];

        scanf("%[^\n]", line);
        printf("%s\n", line);
        getchar();
        char *token = strtok(line, " ");
        while (token != NULL) {
                strcpy(target_term[n_target_term++], token);
                token = strtok(NULL, " ");
        }

        while((scanf("%[^\n]", line)) != EOF) {
                getchar();
                int n_match, n_corpus; 
                float uniq = 0;
                n_match = n_corpus = 0;
                char ln[MAX_LEN];
                strcpy(ln, line);

                char *token = strtok(line, " ");
                while (token != NULL) {
                        n_corpus++;
                        int flag = 1;
                        for (int i = 0; i < n_target_term; ++i) {
                                if (strcmp(token, target_term[i]) == 0) {
                                        n_match++;
                                        if (flag) {       
                                                uniq++;
                                                flag = 0;
                                        }
                                }
                        }

                        token = strtok(NULL, " ");
                }

                float score = n_match/(n_corpus + n_target_term - uniq);
                printf("%0.2f:%s\n", score, ln);
        }
        return 0;
}
