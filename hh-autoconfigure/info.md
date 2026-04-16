### Пример использования в другом проекте

После установки в локальный Maven репозиторий (`mvn install`), добавьте в `pom.xml` своего приложения:

```xml
<dependency>
    <groupId>io.github.yury-developer</groupId>
    <artifactId>hh-starter</artifactId>
    <version>0.0.1-SNAPSHOT</version>
</dependency>
```

В application.yml:
```yaml
hh:
  api:
    enabled: true
    user-agent: MyApp/1.0
    default-area: 113
    connect-timeout: 5000
    read-timeout: 10000
```

В коде:
```java
@Service
@RequiredArgsConstructor
public class VacancyService {
    private final HhApiClient hhApiClient;
    
    public void search() {
        var result = hhApiClient.searchJavaVacancies();
        result.getItems().forEach(vacancy -> {
            System.out.println(vacancy.getName() + " - " + vacancy.getEmployer().getName());
        });
    }
}
```
