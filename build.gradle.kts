plugins {
    kotlin("jvm") version "1.8.22"
    application
}

group = "org.diegoehg.atmapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val cucumberVersion = "7.12.1"
val junitPlatformVersion = "1.9.3"
val junitJupiterVersion = "5.9.3"

dependencies {
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")
    testImplementation("org.junit.platform:junit-platform-suite:$junitPlatformVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(11)
}

application {
    mainClass.set("MainKt")
}