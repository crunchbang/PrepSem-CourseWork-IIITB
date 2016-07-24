#include "vfs.h"

int vfs_extract(char *saved_name, char *name_with_path)
{
        extern struct Vfs vfs;

        if (vfs.vfs_status == VFS_CLOSED)
                return VFS_FILE_ERROR;

        struct Vfs_header_info header = vfs.header;
        int n = header.vfs_info.num_files;
#ifdef DEBUG
        printf("Num_files:%d\n", n);
#endif

        struct Vfs_file_info finfo;
        int i;
        for (i = 0; i < n; ++i) {
                if(strcmp(header.vfs_files[i].fname, saved_name) == 0) {
#ifdef DEBUG
                        printf("File found\n");
#endif
                        finfo = header.vfs_files[i];
                        break;
                }
        }
        if (i == n) {
#ifdef DEBUG
                printf("File not found");
#endif
                return VFS_FILE_NOT_FOUND;
        }

        long offset = finfo.offset;
        FILE *vfs_fp = vfs.vfs_fp;
        fseek(vfs_fp, offset, SEEK_SET);

        FILE *fp = fopen(name_with_path, "w");
        char b = 0;
        if (i == n-1) {
#ifdef DEBUG
                printf("Last file\n");
                printf("Commenced extraction\n");
#endif

                while (fread(&b, sizeof(b), 1, vfs_fp)) {
                        fwrite(&b, sizeof(b), 1, fp);
                }
        }
        else {
                int next_offset = header.vfs_files[i+1].offset;
                int limit = (next_offset - offset)/sizeof(b);

                for (i = 0; i < limit; ++i) {
                        fwrite(&b, sizeof(b), 1, fp);
                        fread(&b, sizeof(b), 1, vfs_fp);
                }
        }
#ifdef DEBUG
        printf("File extracted\n");
#endif
        return VFS_SUCCESS;

}
