# Spring Boot JNI 接口项目
Spring Boot WEB -> JNI (libNativeLib.so) -> 算法库(libRegister.a)

# 0. 环境准备
系统安装编译工具 yum install cmake gcc-c++，或 ubuntu 的 apt install cmake gcc g++  
安装 JDK 8，并设置好环境变量 JAVA_HOME （编译 C 项目时要找到 jni.h）  
--jni.h: No such file or directory -> `export JAVA_HOME=/usr/java/jdk`

# 1. 项目构建（在 IDEA 操作）
- IDEA 使用 Spring 初始工具，生成 maven 项目
- 项目的前缀 com.gyjian.algorithm，添加 package jni，在下面添加 LibLoader 和 NativeLib 两个类
  - LibLoader 定义加载库的逻辑
  - NativeLib 定义了调用C函数的参数
- 先把 NativeLib 的构造函数屏蔽，在目录 `/root/gyjian-algorithm/src/main/java` 下执行命令
  ```
  javac com/gyjian/algorithm/jni/NativeLib.java
  javah -classpath ${PWD} NativeLib
  ```
- 会在当前目录下生成 `com_gyjian_algorithm_jni_NativeLib.h` 文件，移动到 `/root/gyjian-algorithm/src/c` 目录下
- 添加对应的 cpp 文件 `com_gyjian_algorithm_jni_NativeLib.cpp`
- 增加 core 目录，用来存放真正的算法代码，包括 `register.h` 和 `register.c`，将生成 `libRegister.a` 库（或者客户提供 .h 和 .a 文件）
- 恢复 NativeLib 的构造函数

# 2. 编译
## 2.1 核心算法库编译
> 客户自行实现算法，执行下面命令生成 .a 文件
> 如果客户已提供 .h 和 .a 文件，直接放置在 core 文件夹下
```
cd xxx/c/core
make clean
make
```
> 如果客户提供 .o 文件
ar -crv libRegister.a xxx.o
xxx.o 编译时需要使用 `-fPic` 开关来生成

## 2.2 JNI库编译
> 目的是把 .a 库，封装成 .so 动态库，给 java 调用
```
cd xxx/c/
# 预编译，会生成 cmake_build 目标文件夹
cmake -B cmake_build
# 编译
cmake --build cmake_build
# 把生成的 .so 文件，复制到 java 项目的 resources 目录下
mv cmake_build/libNativeLib.so /mnt/src/main/resources/
```

## 2.3 Java 项目编译运行（在 IDEA 操作）
```
mvn package -DskipTests=true
java -jar target/algorithm-0.0.1-SNAPSHOT.jar
```

# 3. 注意
- JDK 10 开始移除了 `javah` 工具，本项目使用 JDK 8 生成 JNI 相关文件
- 可在 Windows 下用 IDEA 打开项目
- 共享项目文件夹。Linux 下挂载共享文件夹，编译 C/C++ 语言部分
- Windows/Linux 下 Maven 打包项目都可以
- docker build 时加上 `--no-cache` 参数
