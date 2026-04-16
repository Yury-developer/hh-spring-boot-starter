### Структура проекта:

---
#### Поравил слегка/ актуализировал

```text
hh-spring-boot-starter/
├── pom.xml                          # (исправленный, который выше)
├── hh-autoconfigure/
│   ├── pom.xml                      # (как выше)
│   └── src/
│       ├── main/
│       │   └── java/
│       │       └── io/github/yury/developer/hh/autoconfigure/
│       └── test/
│           └── java/
└── hh-starter/
    ├── pom.xml                      # (как выше)
    └── src/
        └── main/
            └── java/
                └── (пусто — это нормально)
```

---
#### Превоначальная 

```text
hh-spring-boot-starter/           # корневая папка
├── pom.xml                        # родительский (packaging=pom)
├── hh-autoconfigure/
│   ├── pom.xml
│   └── src/main/java/...
└── hh-starter/
│   ├── pom.xml
│   └── (пустой, только зависимости)
└── sample-app/                    # опционально: пример использования
    ├── pom.xml
    └── src/main/java/...
```

---
