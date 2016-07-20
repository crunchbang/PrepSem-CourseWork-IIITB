#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#define MIN(A,B) {(A)>(B)?(A):(B)}

int string_to_int(char *s);

int main()
{



        int denom[20];
        int n_denom = 0;
        int n_test = 0;
        scanf("%d %d", &n_denom, &n_test);
        for (int i = 0; i < n_denom; ++i)
                scanf("%d", &denom[i]);

        for (int i = 0; i < n_denom; ++i)
                printf("%d ", denom[i]); 

        int i, j;
        int mem[100] ;
        int mem_link[100];
        for (i = 0; i < 100; i++) {
                mem[i] = 1000; 
                mem_link[i] = -1;
        }
        mem[0] = 0;

        int number;
        while (n_test--) {
                scanf("%d", &number);
                for (i = 0; i <= number; ++i) {
                        for (j = n_denom-1; j >= 0; --j) {
                                int link = -1;
                                if (denom[j] <= i) {
                                        int res = 1 + mem[i-denom[j]];
                                        int link = j;
                                        if (res < mem[i]) {
                                                mem[i] = res;
                                                mem_link[i] = link;
                                        }
                                }
                        }
                }
                printf("\n %d Min coins:%d\n",number, mem[number]);
                int sol[20] ={0};
                i = 0;
                int x = number;
                while (x) {
                        sol[i++] = denom[mem_link[x]];
                        x = x - denom[mem_link[x]];
                }
                j = i;
                int count = 0;
                while (j--) {
                        count = 1;
                        while (sol[j-1] == sol[j]) {
                                count++;
                                j--;
                        }
                        printf("%d:%d", sol[j], count);
                        if (j!=0)
                                printf(",");
                }
        }
        return 0;
}
