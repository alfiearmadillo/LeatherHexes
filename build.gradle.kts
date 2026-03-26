plugins {
    id("net.fabricmc.fabric-loom") version "1.15-SNAPSHOT"
}

group = "com.leatherhex"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:26.1")
    implementation("net.fabricmc:fabric-loader:0.18.4")
    implementation("net.fabricmc.fabric-api:fabric-api:0.144.3+26.1")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(25))
}