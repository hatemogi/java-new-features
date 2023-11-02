plugins {
    java
    application
}

group = "org.hatemogi"
version = "0.1.0"

repositories {
    mavenCentral()
}

application {
    mainClass = "com.hatemogi.main.Main"
}

dependencies {
    implementation(project(":running"))
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}