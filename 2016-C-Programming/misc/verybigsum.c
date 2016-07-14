#include <math.h>
#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <assert.h>
#include <limits.h>
#include <stdbool.h>

int main(){
        int t; 
        scanf("%d",&t);
        for(int a0 = 0; a0 < t; a0++){
                int n; 
                scanf("%d",&n);
                int temp = n;
                int count = 0;
                printf("%d", temp);
                /*
                while (temp != 0) {
                        int x = temp % 10;
                        printf("%d", x);
                        if (n % x == 0) count++;
                        temp = temp / 10;
                }
                printf("%d", count);
                */
        }

        return 0;
}
