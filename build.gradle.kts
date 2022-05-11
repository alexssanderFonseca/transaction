import com.google.protobuf.gradle.*
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile
import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

buildscript {
    dependencies {
        classpath("com.google.protobuf:protobuf-gradle-plugin:0.8.13")
    }
}

plugins {
    id("org.springframework.boot") version "2.6.3"
    id("io.spring.dependency-management") version "1.0.10.RELEASE"
    id("com.google.protobuf") version "0.8.13"
    kotlin("jvm") version "1.4.10"
    kotlin("plugin.jpa") version "1.6.10"
    kotlin("plugin.spring") version "1.4.10"
    kotlin("kapt") version "1.5.10"


}

group = "br.com.alexsdm"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_11

allprojects {
    repositories {
        mavenLocal()
        mavenCentral()
        google()
    }
}

extra["springCloudVersion"] = "2021.0.2"



dependencies {
    implementation("org.springframework.cloud:spring-cloud-starter-openfeign")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:2.13.1")
    implementation("org.jetbrains.kotlin:kotlin-reflect")
    implementation("io.grpc:grpc-protobuf:1.43.2")
    implementation("io.grpc:grpc-stub:1.43.2")
    implementation("io.grpc:grpc-netty:1.43.2")
    compileOnly("javax.annotation:javax.annotation-api:1.3.2")
    api("com.google.protobuf:protobuf-java-util:3.19.3")
    implementation("io.grpc:grpc-all:1.43.2")
    api("io.grpc:grpc-kotlin-stub:1.2.0")
    implementation("io.grpc:protoc-gen-grpc-kotlin:1.2.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.0-native-mt")
    implementation("com.google.protobuf:protobuf-gradle-plugin:0.8.18")
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
    developmentOnly("org.springframework.boot:spring-boot-devtools")
    testImplementation("org.springframework.boot:spring-boot-starter-test")
    implementation("org.springframework.kafka:spring-kafka:2.8.2")
    implementation("org.mapstruct:mapstruct:1.5.0.Beta2")
    kapt("org.mapstruct:mapstruct-processor:1.5.0.Beta2")
    implementation("org.postgresql:postgresql:42.3.2")
    implementation("org.flywaydb:flyway-core")

}

kapt {
    arguments {
        arg("mapstruct.defaultComponentModel", "spring")
    }
}


dependencyManagement {
    imports {
        mavenBom("org.springframework.cloud:spring-cloud-dependencies:${property("springCloudVersion")}")
    }
}

tasks.withType<Test> {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions {
        freeCompilerArgs = listOf("-Xjsr305=strict")
        jvmTarget = "11"
    }
}

java.sourceSets["main"].java {
    srcDir("build/generated/source/proto/main/grpc")
    srcDir("build/generated/source/proto/main/java")
}
java.sourceSets["main"].java {
    srcDir("build/generated/source/proto/main/grpc")
    srcDir("build/generated/source/proto/main/grpckt")
    srcDir("build/generated/source/proto/main/java")
}




protobuf {
    protoc {
        artifact = "com.google.protobuf:protoc:3.10.1"
    }
    plugins {
        id("grpc") {
            artifact = "io.grpc:protoc-gen-grpc-java:1.33.1"
        }
        id("grpckt") {
            artifact = "io.grpc:protoc-gen-grpc-kotlin:0.1.5"
        }
    }
    generateProtoTasks {
        all().forEach {
            it.plugins {
                id("grpc")
                id("grpckt")
            }
        }
    }
}
