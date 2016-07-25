#include "vfs.h"

int cmprfn(const void *f1, const void *f2) 
{
        char *fname1 = (*(struct Vfs_file_info *)f1).fname;
        char *fname2 = (*(struct Vfs_file_info *)f2).fname;
        return strcmp(fname1, fname2);
}

int vfs_save(char *save_name, char *name_with_path)
{
        extern struct Vfs vfs;
        if (vfs.vfs_status == VFS_CLOSED)
                return VFS_FILE_ERROR;

        FILE *fp = fopen(name_with_path, "r");
        fseek(fp, 0, SEEK_END);
        long size = ftell(fp);
        rewind(fp);

        FILE *vfs_fp = vfs.vfs_fp;
        fseek(vfs_fp, 0, SEEK_END);

        long offset = ftell(vfs_fp);
        struct Vfs_file_info fi;
        strcpy(fi.fname, save_name);
        fi.offset = offset;
        fi.file_size = size;

        char *buffer = malloc(size + 1);
        fread(buffer, size, 1, fp);
        fwrite(buffer, size, 1, vfs_fp);
        fclose(fp);
        free(buffer);
#ifdef DEBUG
        printf("%s file saved as %s in VFS\n", name_with_path, save_name);
#endif

        struct Vfs_header_info header = vfs.header;
        int n = header.vfs_info.num_files;
        if (n < MAX_FILES)
                header.vfs_files[n] = fi;
        else 
                return VFS_FULL;

        header.vfs_info.num_files = n+1;
        header.vfs_info.size += size;
#ifdef DEBUG
        printf("Header updated\n");
#endif
        qsort(header.vfs_files, header.vfs_info.num_files, sizeof(struct Vfs_file_info), cmprfn);
        vfs.header = header;

        return VFS_SUCCESS;

}
