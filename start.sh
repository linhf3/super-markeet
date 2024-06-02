#!/bin/bash
source /etc/profile
# 服务名称
SERVER_NAME=super-markeet
# 源jar名称，mvn打包之后，target目录下的jar包名称
JAR_NAME=super-markeet
# jenkins下的目录
JENKINS_HOME=/var/jenkins_home/workspace/super-markeet-test
# 等待三秒
echo sleep 3s
sleep 1
echo sleep 2s
sleep 1
echo sleep 1s
sleep 1
echo "结束进程完成"
cd $JENKINS_HOME/target
cp $JENKINS_HOME/Dockerfile $JENKINS_HOME/target
# 修改文件权限
chmod 755 $JAR_NAME.jar
echo "看看docker能不能用"
docker -v
echo "停止容器"
# 停止容器
docker stop super-markeet
echo "删除容器"
# 删除容器
docker rm super-markeet
echo "删除镜像"
# 删除镜像
docker rmi super-markeet
echo "打包镜像"
# 打包镜像
docker build -t super-markeet .
echo "运行镜像"
# 运行镜像
docker run -d -p 9999:9999 --name super-markeet super-markeet