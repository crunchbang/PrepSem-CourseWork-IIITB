#include "vfs.h"

void print_file_info(struct Vfs_file_info file_info)
{
        printf("\n Filename:%s Offset:%ld Size:%ld\n", file_info.fname, file_info.offset, file_info.file_size);
}

void print_vfs_info(struct Vfs_info vfs_info)
{
        printf("\n VFS_Name:%s N_files:%d Size:%ld \n", vfs_info.vfs_name, vfs_info.num_files, vfs_info.size);
}

void print_vfs_header_info(struct Vfs_header_info vfs_header_info)
{
        struct Vfs_info vfs_info = vfs_header_info.vfs_info;
        printf("VFS_INFO:");
        print_vfs_info(vfs_info);
        printf("VFS_FILE_INFO:");
        for (int i = 0; i < vfs_header_info.vfs_info.num_files; i++)
                print_file_info(vfs_header_info.vfs_files[i]);
}

void print_vfs(struct Vfs v, int mode)
{
        if (mode)
                print_vfs_header_info(v.header);
        printf("\n Status:%d \n", v.vfs_status);
}
