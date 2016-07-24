#ifndef VFS_DEBUG_H
#define VFS_DEBUG_H

void print_file_info(struct Vfs_file_info file_info);
void print_vfs_info(struct Vfs_info vfs_info);
void print_vfs_header_info(struct Vfs_header_info vfs_header_info);
void print_vfs(struct Vfs v, int mode);

#endif
