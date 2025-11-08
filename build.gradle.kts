plugins {
    kotlin("jvm") version "2.2.20"
    kotlin("plugin.spring") version "2.2.20"
}

val room_version = "2.8.3"
group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
    google()
}

dependencies {
    // Room
    implementation("androidx.room:room-runtime:${room_version}")

    // telegram
    implementation("org.telegram:telegrambots-spring-boot-starter:6.9.7.1")
}

tasks.test {
    useJUnitPlatform()
}