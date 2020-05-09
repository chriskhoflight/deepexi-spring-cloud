# Scaffold参考文档

此项目由[generator-deepexi-spring-cloud](https://github.com/deepexi/generator-deepexi-spring-cloud)生成。

如何你有任何问题或优化建议，请到[Github Issues](https://github.com/deepexi/generator-deepexi-spring-cloud/issues)进行反馈，我们需要你宝贵的意见:-)。

## 项目信息

- **工具版本**: v1.18.0
- **node版本**: v12.16.1
- **yeoman版本**: v3.1.1
- **生成时间**: 2020-04-14 11:00:58
- **生成方式**: 交互模式
- **生成参数**: 
```json
{"groupId":"com.deepexi","artifactId":"deepexi-spring-cloud","basePackage":"com.deepexi","mavenUrl":"http://maven.aliyun.com/nexus/content/groups/public/","templateEngine":"none","log":"log4j2","jsonParser":"fastjson","db":"mysql","dbPool":"druid","orm":"mybatis-plus","discovery":"eureka","feignCircuit":"hystrix","mq":"rabbitmq","configservice":"apollo","authentication":"jwt","jwtIssue":"deepexi","security":"shiro","cache":"redis","apm":"skywalking","swVersion":"6.4.0","docker":"Jib","jdk":"openjdk:8","prometheus":false,"demo":false,"mode":"interaction","cli":"yo generator-deepexi-spring-cloud -c --groupId=com.deepexi --artifactId=deepexi-spring-cloud --mavenUrl=http://maven.aliyun.com/nexus/content/groups/public/ --templateEngine=none --log=log4j2 --jsonParser=fastjson --db=mysql --dbPool=druid --orm=mybatis-plus --discovery=eureka --feignCircuit=hystrix --mq=rabbitmq --configservice=apollo --authentication=jwt --jwtIssue=deepexi --security=shiro --cache=redis --apm=skywalking --swVersion=6.4.0 --docker=Jib --jdk=openjdk:8","version":"1.18.0","basePath":"com/deepexi","conditions":{"mybatis-plus":true,"eureka":true,"fastjson":true,"rabbitmq":true,"apollo":true,"jwt":true,"shiro":true,"redis":true,"skywalking":true,"dockerScripts":true,"log4j2":true},"openfeign":true}
```
- **生成命令**: 
```text
yo generator-deepexi-spring-cloud -c --groupId=com.deepexi --artifactId=deepexi-spring-cloud --mavenUrl=http://maven.aliyun.com/nexus/content/groups/public/ --templateEngine=none --log=log4j2 --jsonParser=fastjson --db=mysql --dbPool=druid --orm=mybatis-plus --discovery=eureka --feignCircuit=hystrix --mq=rabbitmq --configservice=apollo --authentication=jwt --jwtIssue=deepexi --security=shiro --cache=redis --apm=skywalking --swVersion=6.4.0 --docker=Jib --jdk=openjdk:8
```

## 项目参考

### .gitkeep

项目生成后，为了维持一些空文件夹的存在，会为这些空文件夹添加一个`.gitkeep`文件，如果不需要了，可以在项目目录下执行以下命令全部清除

```bash
$ find . -name '.gitkeep' | xargs rm
```

### demo

可以通过以下指令清除所有带有Demo字样的文件

```bash
$ find . -name '*Demo*' | xargs rm
```
