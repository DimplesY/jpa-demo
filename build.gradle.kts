plugins {
    java
}

description = "my-server"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

allprojects {
    group = "top.dimples"

    repositories {
        mavenLocal()
        mavenCentral()
    }
}