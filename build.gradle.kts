plugins {
    kotlin("jvm") version "1.9.25"
    kotlin("plugin.spring") version "1.9.25"
    id("org.springframework.boot") version "3.3.5"
    id("io.spring.dependency-management") version "1.1.6"
}

group = "springboot-kotlin-msa"
version = "0.0.1-SNAPSHOT"

java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.springframework.cloud:spring-cloud-config-server:4.1.3")

    implementation("org.springframework.boot:spring-boot-starter-security:3.3.5")

    implementation("org.springframework.boot:spring-boot-starter:3.3.5")
    testImplementation("org.springframework.boot:spring-boot-starter-test:3.3.5")
    runtimeOnly("org.jetbrains.kotlin:kotlin-reflect:2.1.0-RC")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit5:2.1.0-RC")
    testImplementation("org.junit.platform:junit-platform-launcher:1.11.3")
}

kotlin {
    compilerOptions {
        freeCompilerArgs.addAll("-Xjsr305=strict")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}
