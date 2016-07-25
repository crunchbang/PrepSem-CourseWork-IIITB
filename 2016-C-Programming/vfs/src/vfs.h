#ifndef VFS_H
#define VFS_H

#include <stdio.h>
#include <string.h>
#include <stdlib.h>

#include "vfs_create.h"
#include "vfs_save.h"
#include "vfs_extract.h"
#include "vfs_load.h"
#include "vfs_unload.h"

#define MAX_LEN 32
#define MAX_FILES 50

#define VFS_SUCCESS 0
#define VFS_FILE_ERROR 10
#define VFS_OPEN 11
#define VFS_CLOSED 12
#define VFS_FULL 13
#define VFS_FILE_NOT_FOUND 14

struct Vfs_file_info {
        char fname[MAX_LEN];
        long offset;
        long file_size;
};

struct Vfs_info {
        char vfs_name[MAX_LEN];
        int num_files;
        long size;
};

struct Vfs_header_info {
        struct Vfs_info vfs_info;
        struct Vfs_file_info vfs_files[MAX_FILES];
};

struct Vfs {
        struct Vfs_header_info header;
        FILE *vfs_fp;
        int vfs_status;
};

#endif
