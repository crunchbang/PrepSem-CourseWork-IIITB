#include <stdio.h>
#include "vfs.h"
#include "vfs_debug.h"

struct Vfs vfs;

int main()
{
        printf("1 CREATE\n"
               "2 LOAD\n"
               "3 SAVE\n"
               "4 EXTRACT\n"
               "5 UNLOAD\n");

        int choice = 0;
        char fname[MAX_LEN];
        char sname[MAX_LEN];
        while(1) {
                scanf("%d", &choice);
                switch(choice) {
                        case 1:
                                scanf("%s", fname);
                                vfs_create(fname);
                                break;
                        case 2:
                                scanf("%s", fname);
                                vfs_load(fname);
                                break;
                        case 3:
                                printf("save_name:");
                                scanf("%s", sname);
                                printf("\ninput:");
                                scanf("%s", fname);
                                vfs_save(sname, fname);
                                break;
                        case 4:
                                printf("saved_name:");
                                scanf("%s", sname);
                                printf("\noutput:");
                                scanf("%s", fname);
                                vfs_extract(sname, fname);
                                break;
                        case 5:
                                vfs_unload();
                                break;
                }
        }
        return 0;
}
