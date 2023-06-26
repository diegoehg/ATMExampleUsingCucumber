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

val kotlinVersion = "1.8.22"
val cucumberVersion = "7.12.1"
val junitPlatformVersion = "1.9.3"
val junitJupiterVersion = "5.9.3"

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlinVersion")
    testImplementation("io.cucumber:cucumber-java:$cucumberVersion")
    testImplementation("io.cucumber:cucumber-junit-platform-engine:$cucumberVersion")
    testImplementation("org.junit.platform:junit-platform-suite:$junitPlatformVersion")
    testImplementation("org.junit.jupiter:junit-jupiter:$junitJupiterVersion")
    cucumberClassPath("io.cucumber:cucumber-java:$cucumberVersion")
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