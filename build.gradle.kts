plugins {
    id("nu.studer.jooq") version("6.0.1")
    id("org.flywaydb.flyway") version("7.7.0")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.spring") version "1.5.31"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {

    implementation("org.telegram:telegrambots-spring-boot-starter:6.9.7.1")
    implementation("org.telegram:telegrambotsextensions:6.9.7.1")

    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}