plugins {
    `kotlin-dsl`
    id("kotlin")
    id("java-gradle-plugin")
    id("com.gradle.plugin-publish") version "1.1.0"
}

group = "io.github.Wan7451.android-rust"
version = "0.3.2"

java {
    sourceCompatibility = JavaVersion.VERSION_11
    targetCompatibility = JavaVersion.VERSION_11
}

repositories {
    google()
    mavenCentral()
}

pluginBundle {
    website = "https://github.com/Wan7451/GradleAndroidRustPlugin"
    vcsUrl = "https://github.com/Wan7451/GradleAndroidRustPlugin.git"
    tags = listOf("android", "rust", "jni")
}

gradlePlugin {
    plugins {
        create("androidRust") {
            id = "io.github.Wan7451.android-rust"
            implementationClass = "dev.Wan7451.agp.rust.AndroidRustPlugin"
            displayName = "Plugin for building Rust with Cargo in Android projects"
            description = "This plugin helps with building Rust JNI libraries with Cargo for use in Android projects."
        }
    }
}

publishing {
    repositories {
        maven {
            url = uri(layout.buildDirectory.dir("repo"))
        }
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    gradleApi()

    implementation("com.android.tools.build:gradle:7.1.3")
    implementation("com.android.tools.build:gradle-api:7.1.3")
}
