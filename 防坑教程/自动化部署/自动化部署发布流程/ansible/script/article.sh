#!/bin/bash
source /etc/profile
export JAVA_HOME="/data/jdk1.8.0_171/"
version=0.0.2
shdir="/data/gf/gf-article-service-$version-SNAPSHOT"
ipaddr=`ifconfig eth2 | grep " inet addr" | awk '{print $2}'|awk  -F ':' '{print $NF}'`
projectname="gf-article-service-$version-SNAPSHOT"
env=$2
update (){
cd $shdir
if [ ! -d $shdir/logs ];then
mkdir $shdir/logs
fi
rm -fr ./lib
kill -9  ` ps -ef | grep gf-article-service-$version-SNAPSHOT |grep -v grep |awk '{print $2}'`
tar -xf /data/gf/app/$projectname.tar.gz -C /data/gf
cd $shdir/bin
./service.sh restart wrapper.java.additional.1=-Denv=$env wrapper.java.initmemory=256 wrapper.java.maxmemory=256 wrapper.java.additional.2=-server wrapper.java.additional.3=-Xmn256M wrapper.java.additional.4=-Xss256K wrapper.java.additional.5=-XX:+CMSClassUnloadingEnabled wrapper.java.additional.6=-XX:+ScavengeBeforeFullGC wrapper.java.additional.7=-XX:+UseParNewGC wrapper.java.additional.8=-XX:+CMSParallelRemarkEnabled wrapper.java.additional.9=-XX:SoftRefLRUPolicyMSPerMB=0 wrapper.java.additional.10=-XX:+UseFastAccessorMethods wrapper.java.additional.11=-XX:+UseConcMarkSweepGC wrapper.java.additional.12=-XX:ParallelGCThreads=2 wrapper.java.additional.13=-XX:CMSFullGCsBeforeCompaction=5 wrapper.java.additional.14=-XX:+UseCMSCompactAtFullCollection wrapper.java.additional.15=-XX:SurvivorRatio=4 wrapper.java.additional.16=-XX:LargePageSizeInBytes=128m wrapper.java.additional.17=-XX:+UseCMSInitiatingOccupancyOnly wrapper.java.additional.18=-XX:CMSInitiatingOccupancyFraction=80 wrapper.java.additional.19=-XX:+UseCompressedOops wrapper.java.additional.20=-XX:+CMSScavengeBeforeRemark wrapper.java.additional.21=-XX:TargetSurvivorRatio=80 wrapper.java.additional.22=-XX:+ParallelRefProcEnabled wrapper.java.additional.23=-XX:+UseBiasedLocking wrapper.java.additional.24=-XX:-OmitStackTraceInFastThrow wrapper.java.additional.25=-XX:AutoBoxCacheMax=20000 wrapper.java.additional.26=-XX:+AggressiveOpts wrapper.java.additional.27=-XX:PretenureSizeThreshold=5242880 wrapper.java.additional.28=-XX:InitialCodeCacheSize=20971520 wrapper.java.additional.29=-XX:ReservedCodeCacheSize=268435456 wrapper.java.additional.30=-XX:+UseCodeCacheFlushing wrapper.java.additional.31=-XX:+TieredCompilation wrapper.java.additional.32=-XX:+DisableExplicitGC wrapper.java.additional.33=-XX:+ExplicitGCInvokesConcurrent wrapper.java.additional.34=-XX:+ExplicitGCInvokesConcurrentAndUnloadsClasses wrapper.java.additional.35=-XX:StringTableSize=800024 wrapper.java.additional.36=-XX:TLABWasteTargetPercent=2 wrapper.java.additional.37=-XX:ConcGCThreads=8 wrapper.java.additional.38=-Dcom.sun.management.jmxremote wrapper.java.additional.39=-Dcom.sun.management.jmxremote.authenticate=false wrapper.java.additional.40=-Dcom.sun.management.jmxremote.ssl=false wrapper.java.additional.41=-Dcom.sun.management.jmxremote.port=12346 wrapper.java.additional.42=-Djava.rmi.server.hostname=$ipaddr
};
stop (){
cd $shdir/bin
./service.sh stop
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
