/*
 * This file was generated by the Gradle 'init' task.
 *
 * This generated file contains a sample Java application project to get you started.
 * For more details on building Java & JVM projects, please refer to https://docs.gradle.org/8.8/userguide/building_java_projects.html in the Gradle documentation.
 * This project uses @Incubating APIs which are subject to change.
 */

plugins {
    // Apply the application plugin to add support for building a CLI application in Java.
    application
}

repositories {
    // Use Maven Central for resolving dependencies.
    mavenCentral()
}

dependencies {
<<<<<<< Updated upstream
    // This dependency is used by the application.
    implementation(libs.guava)
}

=======
    val javafxVersion = "20.0.1"

    // JavaFX multiplateforme (Linux)
    implementation("org.openjfx:javafx-base:$javafxVersion:linux")
    implementation("org.openjfx:javafx-controls:$javafxVersion:linux")
    implementation("org.openjfx:javafx-fxml:$javafxVersion:linux")
    implementation("org.openjfx:javafx-graphics:$javafxVersion:linux")

    // Google Guava
    implementation("com.google.guava:guava:31.1-jre")

    // SQLite JDBC driver
    implementation("org.xerial:sqlite-jdbc:3.47.1.0")

    // Hibernate Core & Dialects
    implementation("org.hibernate.orm:hibernate-core:6.2.12.Final")
    implementation("org.hibernate.orm:hibernate-community-dialects:6.2.12.Final")

    // JUnit for testing
    testImplementation("org.junit.jupiter:junit-jupiter:5.11.3")
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21)) // Utilisation de Java 21
    }
}

application {
    mainClass.set("com.mille_bornes.App")
    applicationDefaultJvmArgs = listOf(
        "--module-path", "/usr/share/openjfx/lib",
        "--add-modules", "javafx.controls,javafx.fxml"
    )
}
>>>>>>> Stashed changes

testing {
    suites {
        // Configure the built-in test suite
        val test by getting(JvmTestSuite::class) {
            // Use JUnit4 test framework
            useJUnit("4.13.2")
        }
    }
}

// Apply a specific Java toolchain to ease working on different environments.
java {
    toolchain {
        languageVersion = JavaLanguageVersion.of(21)
    }
}

application {
    // Define the main class for the application.
    mainClass = "com.mille_bornes.App"
}
