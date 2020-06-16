查看指定进程，并杀死

```shell
[mr@dfworks97 js]$ ps -ef | grep tomcat
mr       11140     1  0 6?.4 pts/2   00:06:13 /home/synway/dfworks/apache-tomcat……
mr       14348 27180  0 16:09 pts/3    00:00:00 grep --color=auto tomcat
[mr@dfworks97 js]$ kill -9 11140
[mr@dfworks97 js]$
```

查看当前目录下的所有文件和目录大小

```shell
[root@localhost local]# du -sh *
4.0K	bin
4.0K	etc
4.0K	games
4.0K	include
4.0K	lib
4.0K	lib64
4.0K	libexec
11G	mysql
652M	mysql-5.7.17-linux-glibc2.5-x86_64.tar
624M	mysql-5.7.17-linux-glibc2.5-x86_64.tar.gz
28M	mysql-test-5.7.17-linux-glibc2.5-x86_64.tar.gz
4.0K	sbin
96K	share
4.0K	src
[root@localhost local]#
```

查看目录使用率

```shell
[root@localhost local]# df -h /root
Filesystem            			Size  Used Avail Use% Mounted on
/dev/mapper/VolGroup-lv_root	148G   19G  122G  14% /
[root@localhost local]#
```



查看内存

```shell
[root@localhost logs]# free -mh
             total       used       free     shared    buffers     cached
Mem:           11G       8.0G       3.6G        76K       949M       2.6G
-/+ buffers/cache:       4.5G       7.2G 
Swap:         5.9G       182M       5.7G 
```

查看系统版本信息

```shell
[root@localhost logs]# cat /etc/redhat-release 
CentOS release 6.7 (Final)
[root@localhost logs]# uname -r
2.6.32-573.el6.x86_64
[root@localhost logs]# lsb_release -a
LSB Version:	:base-4.0-amd64:base-4.0-noarch:core-4.0-amd64:core-4.0-noarch:graphics-4.0-amd64:graphics-4.0-noarch:printing-4.0-amd64:printing-4.0-noarch
Distributor ID:	CentOS
Description:	CentOS release 6.7 (Final)
Release:	6.7
Codename:	Final
[root@localhost local]# cat /etc/issue
CentOS release 6.7 (Final)
Kernel \r on an \m
[root@localhost logs]# 
```

两台服务器之间发送和拉取文件

```shell
[root@localhost /]# scp /aaa.sh root@192.168.8.245:/home
The authenticity of host '192.168.8.245 (192.168.8.245)' can't be established.
RSA key fingerprint is 27:f3:41:c5:ac:b6:58:d8:6f:1c:e6:4c:d7:52:98:a4.
Are you sure you want to continue connecting (yes/no)? yes
Warning: Permanently added '192.168.8.245' (RSA) to the list of known hosts.
root@192.168.8.245's password: 
aaa.sh              100%  878     0.9KB/s   00:00    
[root@localhost /]# scp root@192.168.8.245:/home/dfworks.sql /home
root@192.168.8.245's password: 
dfworks.sql         100% 1118KB   1.1MB/s   00:01    
[root@localhost /]# 
```











linux查看物理CPU个数、核数、逻辑CPU个数

​	总核数 = 物理CPU个数 * 每颗物理CPU的核数

​	总逻辑CPU数 = 物理CPU个数 * 每颗物理CPU核数 * 超线程数

```shell
# 查看物理CPU个数
[root@localhost local]# cat /proc/cpuinfo | grep "physical id" | sort | uniq | wc -l
8
# 查看每个物理CPU中core的个数（即核数）
[root@localhost local]# cat /proc/cpuinfo | grep "processor"  | wc -l
8
[root@localhost local]# 
```























```
C:\Users\dell>jps
13556 Jps
5252
13720 Launcher
4988 Test

C:\Users\dell>jstack 4988
2019-06-26 15:28:24
Full thread dump Java HotSpot(TM) 64-Bit Server VM (25.161-b12 mixed mode):

"DestroyJavaVM" #12 prio=5 os_prio=0 tid=0x00000000024d3800 nid=0x3708 waiting o
n condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Thread-1" #11 prio=5 os_prio=0 tid=0x000000001c10d000 nid=0x55c waiting for mon
itor entry [0x000000001d10f000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.synway.dfworks.Test$2.run(Test.java:48)
        - waiting to lock <0x0000000780c92708> (a java.lang.String)
        - locked <0x0000000780c92738> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)

"Thread-0" #10 prio=5 os_prio=0 tid=0x000000001bcfa800 nid=0x3798 waiting for mo
nitor entry [0x000000001cf8f000]
   java.lang.Thread.State: BLOCKED (on object monitor)
        at com.synway.dfworks.Test$1.run(Test.java:35)
        - waiting to lock <0x0000000780c92738> (a java.lang.String)
        - locked <0x0000000780c92708> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)

"Service Thread" #9 daemon prio=9 os_prio=0 tid=0x000000001b53b800 nid=0x36fc ru
nnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C1 CompilerThread1" #8 daemon prio=9 os_prio=2 tid=0x000000001b52f800 nid=0x2da
c waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"C2 CompilerThread0" #7 daemon prio=9 os_prio=2 tid=0x000000001b51e000 nid=0x351
0 waiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Monitor Ctrl-Break" #6 daemon prio=5 os_prio=0 tid=0x000000001b525000 nid=0x328
8 runnable [0x000000001b6ee000]
   java.lang.Thread.State: RUNNABLE
        at java.net.SocketInputStream.socketRead0(Native Method)
        at java.net.SocketInputStream.socketRead(SocketInputStream.java:116)
        at java.net.SocketInputStream.read(SocketInputStream.java:171)
        at java.net.SocketInputStream.read(SocketInputStream.java:141)
        at sun.nio.cs.StreamDecoder.readBytes(StreamDecoder.java:284)
        at sun.nio.cs.StreamDecoder.implRead(StreamDecoder.java:326)
        at sun.nio.cs.StreamDecoder.read(StreamDecoder.java:178)
        - locked <0x0000000780d046e8> (a java.io.InputStreamReader)
        at java.io.InputStreamReader.read(InputStreamReader.java:184)
        at java.io.BufferedReader.fill(BufferedReader.java:161)
        at java.io.BufferedReader.readLine(BufferedReader.java:324)
        - locked <0x0000000780d046e8> (a java.io.InputStreamReader)
        at java.io.BufferedReader.readLine(BufferedReader.java:389)
        at com.intellij.rt.execution.application.AppMainV2$1.run(AppMainV2.java:
64)

"Attach Listener" #5 daemon prio=5 os_prio=2 tid=0x0000000019977000 nid=0x3174 w
aiting on condition [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Signal Dispatcher" #4 daemon prio=9 os_prio=2 tid=0x0000000019976000 nid=0x2cf0
 runnable [0x0000000000000000]
   java.lang.Thread.State: RUNNABLE

"Finalizer" #3 daemon prio=8 os_prio=1 tid=0x000000001994c800 nid=0x3028 in Obje
ct.wait() [0x000000001a85e000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x0000000780708ec0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:143)
        - locked <0x0000000780708ec0> (a java.lang.ref.ReferenceQueue$Lock)
        at java.lang.ref.ReferenceQueue.remove(ReferenceQueue.java:164)
        at java.lang.ref.Finalizer$FinalizerThread.run(Finalizer.java:209)

"Reference Handler" #2 daemon prio=10 os_prio=2 tid=0x0000000019903000 nid=0x176
c in Object.wait() [0x000000001a64e000]
   java.lang.Thread.State: WAITING (on object monitor)
        at java.lang.Object.wait(Native Method)
        - waiting on <0x0000000780706b68> (a java.lang.ref.Reference$Lock)
        at java.lang.Object.wait(Object.java:502)
        at java.lang.ref.Reference.tryHandlePending(Reference.java:191)
        - locked <0x0000000780706b68> (a java.lang.ref.Reference$Lock)
        at java.lang.ref.Reference$ReferenceHandler.run(Reference.java:153)

"VM Thread" os_prio=2 tid=0x00000000198f9000 nid=0x34d4 runnable

"GC task thread#0 (ParallelGC)" os_prio=0 tid=0x00000000024f0800 nid=0x2ba4 runn
able

"GC task thread#1 (ParallelGC)" os_prio=0 tid=0x00000000024f2000 nid=0x342c runn
able

"VM Periodic Task Thread" os_prio=2 tid=0x000000001b58f800 nid=0x36a4 waiting on
 condition

JNI global references: 30


Found one Java-level deadlock:
=============================
"Thread-1":
  waiting to lock monitor 0x000000001994aa98 (object 0x0000000780c92708, a java.
lang.String),
  which is held by "Thread-0"
"Thread-0":
  waiting to lock monitor 0x000000001994be88 (object 0x0000000780c92738, a java.
lang.String),
  which is held by "Thread-1"

Java stack information for the threads listed above:
===================================================
"Thread-1":
        at com.synway.dfworks.Test$2.run(Test.java:48)
        - waiting to lock <0x0000000780c92708> (a java.lang.String)
        - locked <0x0000000780c92738> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)
"Thread-0":
        at com.synway.dfworks.Test$1.run(Test.java:35)
        - waiting to lock <0x0000000780c92738> (a java.lang.String)
        - locked <0x0000000780c92708> (a java.lang.String)
        at java.lang.Thread.run(Thread.java:748)

Found 1 deadlock.


C:\Users\dell>
```



jdk设置

变量设置

- 变量名：JAVA_HOME
- 变量值：C:\Program Files\Java\jdk1.7.0

- 变量名：CLASSPATH
- 变量值：.;%JAVA_HOME%\lib\dt.jar;%JAVA_HOME%\lib\tools.jar; //记得前面有个"."

- 变量名：Path
- 变量值：%JAVA_HOME%\bin;%JAVA_HOME%\jre\bin;

这是java的环境配置，配置完成后直接启动eclipse，它会自动完成java环境的配置。

> **注意：**如果使用1.5以上版本的JDK，不用设置CLASSPATH环境变量，也可以正常编译和运行Java程序。

测试jdk是否安装成功：

1、"开始"->;"运行"，键入"cmd"；

2、键入命令"java -version"，"java"，"javac"几个命令，出现画面，说明环境变量配置成功；

















































