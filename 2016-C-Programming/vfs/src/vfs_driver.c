#include <stdio.h>
#include "vfs.h"
#include "vfs_debug.h"

struct Vfs vfs;

int main()
{
//        vfs_create("test.vfs");
        vfs_load("test.vfs");
        vfs_save("test.txt", "test.txt");
        vfs_save("tst.txt", "test.txt");
        vfs_extract("test.txt", "new_test.txt");
        vfs_unload();
        return 0;
}
