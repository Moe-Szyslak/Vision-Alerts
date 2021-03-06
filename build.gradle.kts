import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

group = "me.moe"
version = Versions.BOT
description = "Vision Alerts"

plugins {
    kotlin("jvm") version "1.4.10"
    id("com.github.johnrengelman.shadow") version "6.0.0"
}

repositories {
    mavenCentral()
    jcenter()
}

dependencies {
    implementation("me.jakejmattson:DiscordKt:${Versions.DISCORDKT}")
}

tasks {
    withType<KotlinCompile> {
        kotlinOptions.jvmTarget = "1.8"
    }

    shadowJar {
        archiveFileName.set("VisionAlerts.jar")
        manifest {
            attributes(
                    "Main-Class" to "me.moe.visionalerts.MainKt"
            )
        }
    }
}


object Versions {
    const val BOT = "1.0.0"
    const val DISCORDKT = "0.21.3"
}