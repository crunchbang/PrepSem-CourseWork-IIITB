## VFS

### A simple virtual filesystem.

#### V2:

* Optimize extraction using qsort and bsearch
* Use buffer for read/write insted of character wise transfer
* Add field size for each file; Use size field in extraction

#### V1:

* Create the VFS
* Load the VFS 
* Ability to save files to and extract files from the VFS
* Save the VFS
* Unload the VFS

