# JsonLayout (built-in)

```xml
<Appenders>
    <Console name="ConsoleJSONAppender" target="SYSTEM_OUT">
        <JsonLayout complete="false" compact="true" eventEol="true" includeTimeMillis="true"/>
    </Console>
</Appenders>
```

This outputs something like:

```json
{"timeMillis":1705411941875,"thread":"main","level":"INFO","loggerName":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication","message":"Started JsonLoggingLog4jApplication in 1.021 seconds (process running for 1.701)","endOfBatch":false,"loggerFqcn":"org.apache.commons.logging.LogAdapter$Log4jLog","threadId":1,"threadPriority":5}
```

# JsonTemplateLayout

```gradle
implementation 'org.apache.logging.log4j:log4j-layout-template-json'
```

then define a layout, [see the example here](https://logging.apache.org/log4j/2.x/manual/json-template-layout.html).

```xml
<Appenders>
    <Console name="ConsoleJSONAppender" target="SYSTEM_OUT">
        <JsonTemplateLayout eventTemplateUri="classpath:LogstashJsonEventLayoutV1.json"/>
    </Console>
</Appenders>
```

This outputs something like:

```json
{"@version":1,"source_host":"PC","message":"Started JsonLoggingLog4jApplication in 0.911 seconds (process running for 1.538)","thread_name":"main","@timestamp":"2024-01-16T14:29:37.192+0100","level":"INFO","logger_name":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication"}
```

## Layouts

### LogstashJsonEventLayoutV1.json

```json
{"@version":1,"source_host":"PC","message":"Started JsonLoggingLog4jApplication in 0.951 seconds (process running for 1.628)","thread_name":"main","@timestamp":"2024-01-17T09:09:07.272+0100","level":"INFO","logger_name":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication"}
```

```json
{"exception":{"exception_class":"java.lang.RuntimeException","exception_message":null,"stacktrace":"java.lang.RuntimeException\n\tat com.example.jsonlogginglog4j.CLR.run(CLR.java:15)\n\tat org.springframework.boot.SpringApplication.lambda$callRunner$5(SpringApplication.java:798)\n\tat org.springframework.util.function.ThrowingConsumer$1.acceptWithException(ThrowingConsumer.java:83)\n\tat org.springframework.util.function.ThrowingConsumer.accept(ThrowingConsumer.java:60)\n\tat org.springframework.util.function.ThrowingConsumer$1.accept(ThrowingConsumer.java:88)\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:806)\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:797)\n\tat org.springframework.boot.SpringApplication.lambda$callRunners$3(SpringApplication.java:782)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)\n\tat java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357)\n\tat java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510)\n\tat java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)\n\tat java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\n\tat java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)\n\tat org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:782)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:341)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1358)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1347)\n\tat com.example.jsonlogginglog4j.JsonLoggingLog4jApplication.main(JsonLoggingLog4jApplication.java:10)\n"},"@version":1,"source_host":"PC","message":"Boom","thread_name":"main","@timestamp":"2024-01-17T09:09:07.276+0100","level":"ERROR","logger_name":"com.example.jsonlogginglog4j.CLR"}
```

### EcsLayout.json

```json
{"@timestamp":"2024-01-17T08:09:57.094Z","ecs.version":"1.2.0","log.level":"INFO","message":"Started JsonLoggingLog4jApplication in 0.84 seconds (process running for 1.408)","process.thread.name":"main","log.logger":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication"}
```

```json
{"@timestamp":"2024-01-17T08:09:57.097Z","ecs.version":"1.2.0","log.level":"ERROR","message":"Boom","process.thread.name":"main","log.logger":"com.example.jsonlogginglog4j.CLR","error.type":"java.lang.RuntimeException","error.message":null,"error.stack_trace":"java.lang.RuntimeException\n\tat com.example.jsonlogginglog4j.CLR.run(CLR.java:15)\n\tat org.springframework.boot.SpringApplication.lambda$callRunner$5(SpringApplication.java:798)\n\tat org.springframework.util.function.ThrowingConsumer$1.acceptWithException(ThrowingConsumer.java:83)\n\tat org.springframework.util.function.ThrowingConsumer.accept(ThrowingConsumer.java:60)\n\tat org.springframework.util.function.ThrowingConsumer$1.accept(ThrowingConsumer.java:88)\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:806)\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:797)\n\tat org.springframework.boot.SpringApplication.lambda$callRunners$3(SpringApplication.java:782)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)\n\tat java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357)\n\tat java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510)\n\tat java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)\n\tat java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\n\tat java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)\n\tat org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:782)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:341)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1358)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1347)\n\tat com.example.jsonlogginglog4j.JsonLoggingLog4jApplication.main(JsonLoggingLog4jApplication.java:10)\n"}
```

### GcpLayout.json

```json
{"timestamp":"2024-01-17T08:10:44.626Z","severity":"INFO","message":"Started JsonLoggingLog4jApplication in 0.853 seconds (process running for 1.422)","logging.googleapis.com/sourceLocation":{"function":"org.springframework.boot.StartupInfoLogger.logStarted"},"logging.googleapis.com/insertId":"2","_exception":{"stackTrace":""},"_thread":"main","_logger":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication"}
```

```json
{"timestamp":"2024-01-17T08:10:44.629Z","severity":"ERROR","message":"Boom java.lang.RuntimeException: null\n\tat com.example.jsonlogginglog4j.CLR.run(CLR.java:15) ~[main/:?]\n\tat org.springframework.boot.SpringApplication.lambda$callRunner$5(SpringApplication.java:798) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.util.function.ThrowingConsumer$1.acceptWithException(ThrowingConsumer.java:83) ~[spring-core-6.1.2.jar:6.1.2]\n\tat org.springframework.util.function.ThrowingConsumer.accept(ThrowingConsumer.java:60) ~[spring-core-6.1.2.jar:6.1.2]\n\tat org.springframework.util.function.ThrowingConsumer$1.accept(ThrowingConsumer.java:88) ~[spring-core-6.1.2.jar:6.1.2]\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:806) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:797) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.lambda$callRunners$3(SpringApplication.java:782) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183) [?:?]\n\tat java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357) [?:?]\n\tat java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510) [?:?]\n\tat java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) [?:?]\n\tat java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150) [?:?]\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173) [?:?]\n\tat java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) [?:?]\n\tat java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) [?:?]\n\tat org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:782) [spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:341) [spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) [spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) [spring-boot-3.2.1.jar:3.2.1]\n\tat com.example.jsonlogginglog4j.JsonLoggingLog4jApplication.main(JsonLoggingLog4jApplication.java:10) [main/:?]\n","logging.googleapis.com/sourceLocation":{"function":"com.example.jsonlogginglog4j.CLR.run"},"logging.googleapis.com/insertId":"4","_exception":{"class":"java.lang.RuntimeException","message":null,"stackTrace":"java.lang.RuntimeException: null\n\tat com.example.jsonlogginglog4j.CLR.run(CLR.java:15) ~[main/:?]\n\tat org.springframework.boot.SpringApplication.lambda$callRunner$5(SpringApplication.java:798) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.util.function.ThrowingConsumer$1.acceptWithException(ThrowingConsumer.java:83) ~[spring-core-6.1.2.jar:6.1.2]\n\tat org.springframework.util.function.ThrowingConsumer.accept(ThrowingConsumer.java:60) ~[spring-core-6.1.2.jar:6.1.2]\n\tat org.springframework.util.function.ThrowingConsumer$1.accept(ThrowingConsumer.java:88) ~[spring-core-6.1.2.jar:6.1.2]\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:806) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:797) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.lambda$callRunners$3(SpringApplication.java:782) ~[spring-boot-3.2.1.jar:3.2.1]\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183) [?:?]\n\tat java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357) [?:?]\n\tat java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510) [?:?]\n\tat java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499) [?:?]\n\tat java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150) [?:?]\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173) [?:?]\n\tat java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234) [?:?]\n\tat java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596) [?:?]\n\tat org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:782) [spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:341) [spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1358) [spring-boot-3.2.1.jar:3.2.1]\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1347) [spring-boot-3.2.1.jar:3.2.1]\n\tat com.example.jsonlogginglog4j.JsonLoggingLog4jApplication.main(JsonLoggingLog4jApplication.java:10) [main/:?]\n"},"_thread":"main","_logger":"com.example.jsonlogginglog4j.CLR"}
```

### GelfLayout.json

```json
{"version":"1.1","host":"PC","short_message":"Started JsonLoggingLog4jApplication in 0.846 seconds (process running for 1.365)","timestamp":1705479090.267185740,"level":6,"_logger":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication","_thread":"main"}
```

```json
{"version":"1.1","host":"PC","short_message":"Boom","full_message":"java.lang.RuntimeException\n\tat com.example.jsonlogginglog4j.CLR.run(CLR.java:15)\n\tat org.springframework.boot.SpringApplication.lambda$callRunner$5(SpringApplication.java:798)\n\tat org.springframework.util.function.ThrowingConsumer$1.acceptWithException(ThrowingConsumer.java:83)\n\tat org.springframework.util.function.ThrowingConsumer.accept(ThrowingConsumer.java:60)\n\tat org.springframework.util.function.ThrowingConsumer$1.accept(ThrowingConsumer.java:88)\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:806)\n\tat org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:797)\n\tat org.springframework.boot.SpringApplication.lambda$callRunners$3(SpringApplication.java:782)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)\n\tat java.base/java.util.stream.SortedOps$SizedRefSortingSink.end(SortedOps.java:357)\n\tat java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:510)\n\tat java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:499)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:150)\n\tat java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:173)\n\tat java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:234)\n\tat java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:596)\n\tat org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:782)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:341)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1358)\n\tat org.springframework.boot.SpringApplication.run(SpringApplication.java:1347)\n\tat com.example.jsonlogginglog4j.JsonLoggingLog4jApplication.main(JsonLoggingLog4jApplication.java:10)\n","timestamp":1705479090.270186742,"level":3,"_logger":"com.example.jsonlogginglog4j.CLR","_thread":"main"}
```

### JsonLayout.json

```json
{"instant":{"epochSecond":1705479143,"nanoOfSecond":466995479},"thread":"main","level":"INFO","loggerName":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication","message":"Started JsonLoggingLog4jApplication in 0.875 seconds (process running for 1.406)","endOfBatch":false,"loggerFqcn":"org.apache.commons.logging.LogAdapter$Log4jLog","threadId":1,"threadPriority":5}
```

```json
{"instant":{"epochSecond":1705479143,"nanoOfSecond":470653831},"thread":"main","level":"ERROR","loggerName":"com.example.jsonlogginglog4j.CLR","message":"Boom","thrown":{"message":null,"name":"java.lang.RuntimeException","extendedStackTrace":[{"class":"com.example.jsonlogginglog4j.CLR","method":"run","file":"CLR.java","line":15},{"class":"org.springframework.boot.SpringApplication","method":"lambda$callRunner$5","file":"SpringApplication.java","line":798},{"class":"org.springframework.util.function.ThrowingConsumer$1","method":"acceptWithException","file":"ThrowingConsumer.java","line":83},{"class":"org.springframework.util.function.ThrowingConsumer","method":"accept","file":"ThrowingConsumer.java","line":60},{"class":"org.springframework.util.function.ThrowingConsumer$1","method":"accept","file":"ThrowingConsumer.java","line":88},{"class":"org.springframework.boot.SpringApplication","method":"callRunner","file":"SpringApplication.java","line":806},{"class":"org.springframework.boot.SpringApplication","method":"callRunner","file":"SpringApplication.java","line":797},{"class":"org.springframework.boot.SpringApplication","method":"lambda$callRunners$3","file":"SpringApplication.java","line":782},{"class":"java.util.stream.ForEachOps$ForEachOp$OfRef","method":"accept","file":"ForEachOps.java","line":183},{"class":"java.util.stream.SortedOps$SizedRefSortingSink","method":"end","file":"SortedOps.java","line":357},{"class":"java.util.stream.AbstractPipeline","method":"copyInto","file":"AbstractPipeline.java","line":510},{"class":"java.util.stream.AbstractPipeline","method":"wrapAndCopyInto","file":"AbstractPipeline.java","line":499},{"class":"java.util.stream.ForEachOps$ForEachOp","method":"evaluateSequential","file":"ForEachOps.java","line":150},{"class":"java.util.stream.ForEachOps$ForEachOp$OfRef","method":"evaluateSequential","file":"ForEachOps.java","line":173},{"class":"java.util.stream.AbstractPipeline","method":"evaluate","file":"AbstractPipeline.java","line":234},{"class":"java.util.stream.ReferencePipeline","method":"forEach","file":"ReferencePipeline.java","line":596},{"class":"org.springframework.boot.SpringApplication","method":"callRunners","file":"SpringApplication.java","line":782},{"class":"org.springframework.boot.SpringApplication","method":"run","file":"SpringApplication.java","line":341},{"class":"org.springframework.boot.SpringApplication","method":"run","file":"SpringApplication.java","line":1358},{"class":"org.springframework.boot.SpringApplication","method":"run","file":"SpringApplication.java","line":1347},{"class":"com.example.jsonlogginglog4j.JsonLoggingLog4jApplication","method":"main","file":"JsonLoggingLog4jApplication.java","line":10}]},"endOfBatch":false,"loggerFqcn":"org.apache.logging.slf4j.Log4jLogger","threadId":1,"threadPriority":5}
```
