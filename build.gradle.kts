plugins {
    id("fabric-loom") version "1.9.2"
}

group = "com.leatherhex"
version = "1.0.0"

repositories {
    mavenCentral()
    maven("https://maven.fabricmc.net/")
}

dependencies {
    minecraft("com.mojang:minecraft:1.21.1")
    mappings("net.fabricmc:yarn:1.21.1+build.3:v2")
    modImplementation("net.fabricmc:fabric-loader:0.16.9")
    modImplementation("net.fabricmc.fabric-api:fabric-api:0.102.0+1.21.1")
}

java {
    toolchain.languageVersion.set(JavaLanguageVersion.of(21))
}