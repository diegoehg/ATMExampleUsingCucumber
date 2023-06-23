import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

val kotlin_version = "1.8.22"
val cucumber_version = "7.12.1"
val junit_version = "5.10.0-M1"

plugins {
    kotlin("jvm") version "1.8.22"
    application
}

group = "org.diegoehg.atmapp"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

val cucumberClassPath = configurations.create("cucumberClassPath")

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    testImplementation("io.cucumber:cucumber-java:$cucumber_version")
    testImplementation("io.cucumber:cucumber-junit:$cucumber_version")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:$junit_version")
    cucumberClassPath("io.cucumber:cucumber-java:$cucumber_version")
}

tasks.named<Test>("test") {
    useJUnitPlatform()
}

tasks.register<JavaExec>("runCucumber") {
    mainClass.set("io.cucumber.core.cli.Main")
    classpath = cucumberClassPath
    args("-p", "pretty")
}

kotlin {
    jvmToolchain(8)
}

application {
    mainClass.set("MainKt")
}