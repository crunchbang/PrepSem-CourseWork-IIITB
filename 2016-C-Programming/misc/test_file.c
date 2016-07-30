#include <stdio.h>
#include <stdlib.h>

int main()
{
        FILE *out = fopen("output.txt", "wb");
        FILE *in = fopen("input.txt", "rb");

        int b = 0;
        fread(&b, sizeof(b), 1, in);
        while (!feof(in)) {
                fwrite(&b, sizeof(b), 1, out);
                fread(&b, sizeof(b), 1, in);
        }

        return 0;

}
