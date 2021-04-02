#!/bin/bash
source /etc/profile
export JAVA_HOME="/data/jdk1.8.0_171/"
versionwar=1.2.3
shdir="/data/zs"
projectname="escenter-$versionwar-SNAPSHOT"
echo $1-$2
update (){
cd $shdir
rm -fr ./*.jar
kill -9  `ps -ef | grep escenter-$versionwar-SNAPSHOT |grep -v grep |awk '{print $2}'`
tar -xf /data/zs/app/$projectname.tar.gz -C /data/zs
cd $shdir
nohup java -jar /data/zs/$projectname.jar >> /data/zs/es.log 2>&1 &
};
stop (){
kill -9  `ps -ef | grep escenter-$versionwar-SNAPSHOT |grep -v grep |awk '{print $2}'`
};
case $1 in
update)
update
;;
stop)
stop
;;
*)
echo $"Usage: $0 {update|stop}"
exit
esac
