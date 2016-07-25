#include "vfs.h"

#ifdef DEBUG
#include "vfs_debug.h"
#endif

extern struct Vfs vfs;

int vfs_load(char *name_with_path)
{
        FILE *fp = fopen(name_with_path, "r+");
        if (fp == NULL)
                return VFS_FILE_ERROR;

        vfs.vfs_fp = fp;
        vfs.vfs_status = VFS_OPEN;

        struct Vfs_header_info header;
        fread(&header, sizeof(header), 1, fp);

        vfs.header = header;

#ifdef DEBUG
        printf("VFS %s Loaded\n", name_with_path);
    #ifdef DEBUG_VERBOSE
        print_vfs(vfs, 1);
    #endif
#endif

        return VFS_SUCCESS;
}
