import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication

subprojects {
  apply {
    plugin("java-library")
    plugin("maven-publish")
  }
  dependencies {
    "api"("com.google.guava:guava:21.0")
    implementation("com.squareup.okhttp3", "okhttp", "3.6.0")
  }

  configure<PublishingExtension> {
    publications {
      create<MavenPublication>("mavenJavaLibrary") {
        from(components["java"])
      }
    }
  }
}

project(":invalid-library-example") {
  dependencies {
    "api"("com.google.inject:guice:4.0")
  }
}

