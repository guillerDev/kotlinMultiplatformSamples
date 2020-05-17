
## Kotlin multiplatform in Linux x64

Repo that illustrates how to build a Kotlin native library and a Kotlin native executable,
 and how they can interact with C lang and linked libraries.

### Build Kotlin native library and kotlin native executable

* Run `bash make.sh` script. It will compile our sample kotlin library into a shared library for Linux x64 platform,
  then this shared library is linked into main.c and is compiled with gcc.

    * Run `cd cBuild && ./main && cd ..` to verify that the linked library works with main.c program.

* Compare result with a kotlin native executable, run gradle task `linkReleaseExecutableNative` to generate an executable with
 the sample kotlin library source code and Main.kt as entry point, then execute `build/bin/native/ktNativeReleaseExecutable/ktNative.kexe`.
  Alternatively, you could run a gradle task `runKtNativeReleaseExecutableNative`.


### Build Kotlin executable with an external library: openGl

* You would need to install in your system [OpenGL](https://en.wikibooks.org/wiki/OpenGL_Programming/Installation/GLUT)

* Run gradle task `cinteropOpenGlNative` which will include openGl libs and headers
 and creates a wrapper for OpenGL that will be accessible from Kotlin.

   * Note: Depending on the target platform, there are different availability of [platform libraries](https://kotlinlang.org/docs/reference/native/platform_libs.html)
     F.e: In linux x64, there are builtin, iconv, linux, posix, stdlib and zlib out of the box.

* Run gradle task `runOpenGlSampleReleaseExecutableNative` and see the tea pot sample.

* Last: run another sample of OpenGL but implemented in C `gcc openGlSample.c -o ../cBuild/openGlSample -lglut -lGLU -lGL` and
 execute it with `../cBuild/openGlSample`.

## Notes-Issues

* compilation to a static library does not work with gcc at compiling the C program.

## References

[Official Kotlin native repository](https://github.com/JetBrains/kotlin-native)
[Official Kotlin native doc: how to create a dynamic library](https://kotlinlang.org/docs/tutorials/native/dynamic-libraries.html)
[C. Intro level](https://www.tutorialspoint.com/cprogramming/c_structures.htm)
[C: how to link a C library](https://www.cs.swarthmore.edu/~newhall/unixhelp/howto_C_libraries.html)
[Kotlin: how to link a library-C Interop](https://kotlinlang.org/docs/reference/native/c_interop.html)
