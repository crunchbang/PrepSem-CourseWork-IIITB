#include "vfs.h"

int scmprfn(const void *f1, const void *f2) 
{
        char *fname1 = (*(struct Vfs_file_info *)f1).fname;
        char *fname2 = (*(struct Vfs_file_info *)f2).fname;
        return strcmp(fname1, fname2);
}

int vfs_extract(char *saved_name, char *name_with_path)
{
        extern struct Vfs vfs;

        if (vfs.vfs_status == VFS_CLOSED)
                return VFS_FILE_ERROR;

        struct Vfs_header_info header = vfs.header;
        int n = header.vfs_info.num_files;

        struct Vfs_file_info finfo;
        if (bsearch(&finfo, header.vfs_files, n, sizeof(struct Vfs_file_info), scmprfn) == NULL) {
#ifdef DEBUG
                printf("File not found");
#endif
                return VFS_FILE_NOT_FOUND;
        }

        long offset = finfo.offset;
        long size = finfo.file_size;
        FILE *vfs_fp = vfs.vfs_fp;
        fseek(vfs_fp, offset, SEEK_SET);

        FILE *fp = fopen(name_with_path, "w");
        char *buffer = malloc(size + 1);

        fread(buffer, size, 1, vfs_fp) ;
        fwrite(buffer, size, 1, fp);
        free(buffer);
        fclose(fp);

#ifdef DEBUG
        printf("File extracted\n");
#endif
        return VFS_SUCCESS;

}
