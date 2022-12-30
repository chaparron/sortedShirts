import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "2.7.7"
	id("io.spring.dependency-management") version "1.1.0"
	kotlin("jvm") version "1.7.22"
	kotlin("plugin.spring") version "1.7.22"
	kotlin("plugin.serialization") version "1.7.20"
}


group = "com.inditex"
version = "0.0.1-SNAPSHOT"
java.sourceCompatibility = JavaVersion.VERSION_17

configurations {
	compileOnly {
		extendsFrom(configurations.annotationProcessor.get())
	}
}

repositories {
	mavenCentral()
}

dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-mongodb")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation ("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation ("io.projectreactor.kotlin:reactor-kotlin-extensions")
	implementation ("org.jetbrains.kotlin:kotlin-reflect")
	implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
	implementation ("org.jetbrains.kotlinx:kotlinx-coroutines-reactor")
	implementation ("org.jetbrains.kotlinx:kotlinx-serialization-json:1.4.1")
	testImplementation ("org.springframework.boot:spring-boot-starter-test")
	testImplementation ("io.projectreactor:reactor-test")
	testImplementation ("org.mockito.kotlin:mockito-kotlin:4.0.0")
	testImplementation ("org.mockito:mockito-junit-jupiter:4.0.0")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs = listOf("-Xjsr305=strict")
		jvmTarget = "17"
	}
}

tasks.withType<Test> {
	useJUnitPlatform()
}
