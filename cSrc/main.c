#include <stdio.h>
#include "../cBuild/libnative_api.h"

// Depends on kotlin native library

int main()
{
    // obtain reference for calling Kotlin/Native functions/classes
    libnative_ExportedSymbols* lib = libnative_symbols();
    // instance of my MyKotlinClass struct
    libnative_kref_com_leakingcode_example_library_MyKotlinClass myClass =
      lib->kotlin.root.com.leakingcode.example.library.MyKotlinClass.MyKotlinClass();
    // instance of MyKotlinClass's method hello
    const char* rsp = lib->kotlin.root.com.leakingcode.example.library.MyKotlinClass.hello(myClass, "leakingcode.com");
    // instance of function sumTwoIntegers
    long x = lib -> kotlin.root.com.leakingcode.example.library.sumTwoIntegers(2,2);
    printf("%s\n", rsp);
    // Dispose allocated memory
    lib->DisposeString(rsp);
    printf("This is a C program compiled with a kotlin native library and 2 + 2 are %ld\n", x);
    // Dispose allocated memory for my MyKotlinClass struct
    lib->DisposeStablePointer(myClass.pinned);
    return 0;
}
