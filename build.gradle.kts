import org.gradle.api.publish.PublishingExtension
import org.gradle.api.publish.maven.MavenPublication

apply {
  plugin("java-library")
  plugin("maven-publish")
}

dependencies {
  "api"("com.google.guava:guava:21.0")
  "api"("org.apache.commons:commons-lang:3.3.5")
  implementation("org.apache.httpcomponents", "httpclient", "4.5.3")
}

configure<PublishingExtension> {
  publications {
    create<MavenPublication>("mavenJavaLibrary") {
      from(components["java"])
    }
  }
}
logger.lifecycle("Applying dependencies after publication creation")
dependencies {
  "api"("com.google.inject:guice:4.0")
  implementation("com.squareup.okhttp3", "okhttp", "3.6.0")
}
applyFrom("dependencies.gradle.kts")
