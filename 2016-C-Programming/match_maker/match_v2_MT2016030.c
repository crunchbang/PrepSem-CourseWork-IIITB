#include <stdio.h>
#include <string.h>

void match(FILE *corpus, char *target_line);

int main() 
{
        FILE *mfp = fopen("matches.txt", "w");

        char t_line[20][50];
        int t_size = 0;
        char buffer[100];

        FILE *tfp = fopen("targets.txt", "r");
        while (fscanf(tfp, "%[^\n]\n", buffer) != EOF) {
                strcpy(t_line[t_size++], buffer);
        }
        fclose(tfp);

        FILE *cfp = fopen("corpus.txt", "r");
        for (int i = 0; i < t_size; ++i) 
                match(cfp, t_line[i]);

        fclose(cfp);
        fclose(mfp);

        return 0;
}

void match(FILE *corpus, char *target_line)
{
        char target[20][20];
        int tlen = 0;
        char *token;

        char vword[20][20];
        int vlen = 0;
        char vocab[100];

        fseek(corpus, 0, SEEK_SET);
        fscanf(corpus, "%[^\n]\n", vocab);

        token = strtok(vocab, ",");
        while (token != NULL) {
                strcpy(vword[vlen++], token);
                token = strtok(NULL, ",");
        }

        char temp_target_line[100];
        strcpy(temp_target_line, target_line);
        token = strtok(temp_target_line, ",");
        while (token != NULL) {
                strcpy(target[tlen++], token);
                token = strtok(NULL, ",");
        }


        char corpus_line[100];
        int max_numerator = 0;
        int max_denominator = 1;
        float max_score = 0;
        char max_corpus_line[100];
        while (fscanf(corpus, "%[^\n]\n", corpus_line) != EOF) {
                float score = 0;
                int match = 0;
                int ntok = 0;
                char temp_corpus_line[100];
                strcpy(temp_corpus_line, corpus_line);
                token = strtok(temp_corpus_line, ",");
                while (token != NULL) {
                        int in_vocab = 0;
                        for (int i = 0; i < vlen; ++i) {
                                if (strcmp(token, vword[i]) == 0) {
                                        in_vocab = 1;
                                        break;
                                }
                        }

                        if (in_vocab) {
                                ntok++;
                                for (int i = 0; i < tlen; ++i) {
                                        if (strcmp(token, target[i]) == 0) {
                                                match++;
                                                break;
                                        }
                                }
                        }

                        token = strtok(NULL, ",");
                }
                int denom = ntok + tlen - match;
                score = match / (float)denom;
                if (score > max_score) {
                        max_score = score;
                        max_numerator = match;
                        max_denominator = denom;
                        strcpy(max_corpus_line, corpus_line);
                }
        }
        printf("%s;%d/%d=%0.2f;%s\n", target_line, max_numerator, max_denominator, max_score, max_corpus_line);
}
