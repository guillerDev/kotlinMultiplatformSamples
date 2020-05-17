LIBRARY_TYPE=Shared  #Shared either Static
LIBRARY_NAME=libnative.so #libnative.so either libnative.a
BUILD_TYPE=release
./gradlew clean
./gradlew linkRelease${LIBRARY_TYPE}Native
export LD_LIBRARY_PATH=build/bin/native/${BUILD_TYPE}${LIBRARY_TYPE}
rm cBuild -r || mkdir cBuild
mkdir cBuild
cp build/bin/native/${BUILD_TYPE}${LIBRARY_TYPE}/libnative_api.h cBuild/libnative_api.h
cp build/bin/native/${BUILD_TYPE}${LIBRARY_TYPE}/${LIBRARY_NAME} cBuild/${LIBRARY_NAME}
cd cSrc || exit
gcc main.c -o ../cBuild/main ../cBuild/${LIBRARY_NAME}

