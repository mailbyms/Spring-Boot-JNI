project("SpringBootNativeLib")

cmake_minimum_required(VERSION 2.8)

#c++11支持
add_definitions(-std=c++11)

#设置java路径
#set(java_home "/usr/local/jdk")

#jni头文件
include_directories($ENV{JAVA_HOME}/include/
                    $ENV{JAVA_HOME}/include/linux/)

# .a 库所在目录（cmakelists.txt 目录的 /core）
link_libraries(${CMAKE_CURRENT_SOURCE_DIR}/core/libRegister.a)

add_library(NativeLib SHARED
            com_gyjian_algorithm_jni_NativeLib.cpp)

target_link_libraries(NativeLib)