# 父镜像
FROM adoptopenjdk/openjdk8-openj9

# 作者
MAINTAINER linhf

# jar拷贝
ADD *.jar super-markeet.jar

# 执行命令
ENTRYPOINT ["sh","-c","java $JAVA_OPTIONS -jar super-markeet.jar $APP_OPTIONS"]
