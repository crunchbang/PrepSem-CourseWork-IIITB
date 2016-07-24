#include "vfs.h"
#include <string.h>

int vfs_create(char *name_with_path)
{
        struct Vfs_header_info header;
        struct Vfs_info info;

        FILE *fp = fopen(name_with_path, "w");
        if (fp == NULL)
                return VFS_FILE_ERROR;

        strcpy(info.vfs_name, name_with_path);
        info.num_files = 0;
        header.vfs_info = info;

        fwrite(&header, sizeof(header), 1, fp);
        fclose(fp);

        return VFS_SUCCESS;
}
