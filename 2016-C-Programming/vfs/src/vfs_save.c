#include "vfs.h"

int vfs_save(char *save_name, char *name_with_path)
{
        extern struct Vfs vfs;
        if (vfs.vfs_status == VFS_CLOSED)
                return VFS_FILE_ERROR;

        FILE *fp = fopen(name_with_path, "r");
        FILE *vfs_fp = vfs.vfs_fp;
        fseek(vfs_fp, 0, SEEK_END);

        long offset = ftell(vfs_fp);
        struct Vfs_file_info fi;
        strcpy(fi.fname, save_name);
        fi.offset = offset;

        char b = 0;
        while (fread(&b, sizeof(b), 1, fp) == 1) {
                fwrite(&b, sizeof(b), 1, vfs_fp);
        }
        fclose(fp);
#ifdef DEBUG
        printf("File Save complete\n");
#endif

        struct Vfs_header_info header = vfs.header;
        int n = header.vfs_info.num_files;
        if (n < MAX_FILES)
                header.vfs_files[n] = fi;
        else 
                return VFS_FULL;

        header.vfs_info.num_files = n+1;
        vfs.header = header;
#ifdef DEBUG
        printf("Header updated\n");
#endif

        return VFS_SUCCESS;

}

