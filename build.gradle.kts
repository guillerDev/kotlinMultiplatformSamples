plugins {
    kotlin("multiplatform") version "1.3.72"
}

repositories {
    mavenCentral()
}

kotlin {

    // name has to be "native" otherwise does NOT work, since it target the package "native"
    linuxX64("native") {

        // Include headers and link binaries for shared libraries that are defined
        // in src/nativeInterop/cinterop/openGl.def
        compilations["main"].cinterops {
            val openGl by creating {
                includeDirs.headerFilterOnly("/usr/include")
            }
        }

        binaries {
            sharedLib {
                baseName = "native"
            }
            staticLib {
                baseName = "native"
            }
            executable("ktNative") {
                entryPoint = "com.leakingcode.example.main"
            }
            executable("openGlSample") {
                entryPoint = "com.leakingcode.example.openGl.main"
            }
        }
    }
}

tasks.withType<Wrapper> {
    gradleVersion = "6.4"
    distributionType = Wrapper.DistributionType.ALL
}
