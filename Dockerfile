FROM openjdk:8u275-jre

RUN cd /etc/apt \
    && mv sources.list sources.list.bak \
    && echo 'deb http://mirrors.aliyun.com/debian/ buster main non-free contrib \n \
    deb-src http://mirrors.aliyun.com/debian/ buster main non-free contrib \n \
    deb http://mirrors.aliyun.com/debian-security buster/updates main \n \
    deb-src http://mirrors.aliyun.com/debian-security buster/updates main \n \
    deb http://mirrors.aliyun.com/debian/ buster-updates main non-free contrib \n \
    deb-src http://mirrors.aliyun.com/debian/ buster-updates main non-free contrib \n \
    deb http://mirrors.aliyun.com/debian/ buster-backports main non-free contrib \n \
    deb-src http://mirrors.aliyun.com/debian/ buster-backports main non-free contrib' > sources.list \
    && apt update \
    && apt install -y locales \
    && localedef -c -f UTF-8 -i zh_CN zh_CN

ENV LANG zh_CN.UTF-8

WORKDIR /opt/gyjian

ADD ./target/algorithm-0.0.1-SNAPSHOT.jar ./

ENTRYPOINT ["sh", "-c", "java ${JAVA_OPTS} -jar algorithm-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080