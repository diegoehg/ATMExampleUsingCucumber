import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version = "1.8.22"
val cucumber_version = "7.12.1"

plugins {
    kotlin("jvm") version "1.8.22"
    application
}

group = "org.diegoehg.atmapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    testImplementation("io.cucumber:cucumber-java:$cucumber_version")
    testImplementation("io.cucumber:cucumber-junit:$cucumber_version")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}