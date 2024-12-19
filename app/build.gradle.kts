plugins {
    application
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.google.guava:guava:31.1-jre")
    implementation("org.xerial:sqlite-jdbc:3.47.1.0")
    implementation("org.hibernate.orm:hibernate-core:6.6.3.Final")
    implementation("org.hibernate.orm:hibernate-community-dialects:6.6.3.Final")
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

application {
    mainClass.set("com.mille_bornes.App")
}

sourceSets {
    main {
        java {
            setSrcDirs(setOf("src/main/java"))
        }
    }
    test {
        java {
            setSrcDirs(setOf("src/test/java"))
        }
    }
}

tasks.test {
    useJUnitPlatform()
}

tasks.register("javaVersion") {
    doLast {
        println("Java version: ${System.getProperty("java.version")}")
    }
}
