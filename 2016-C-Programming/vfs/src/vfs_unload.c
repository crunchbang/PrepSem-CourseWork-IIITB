#include "vfs.h"
#include "vfs_debug.h"


int vfs_unload()
{
        extern struct Vfs vfs;
        FILE *fp = vfs.vfs_fp;
        fseek(fp, 0, SEEK_SET);
#ifdef DEBUG
        printf("Header info:\n");
        print_vfs_header_info(vfs.header);
#endif

        struct Vfs_header_info header = vfs.header;
        fwrite(&header, sizeof(header), 1, fp);

        fclose(fp);
#ifdef DEBUG
        printf("VFS Closed\n");
#endif
        vfs.vfs_fp = NULL;
        vfs.vfs_status = VFS_CLOSED;

        return VFS_SUCCESS;
}
