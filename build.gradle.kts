plugins {
    `maven-publish`
}

buildscript {
    dependencies {
        classpath(group = "com.google.guava", name = "guava", version = "32.0.0-jre")
    }
}

allprojects {
    group = "earth.terrarium"
    version = "1.0.0"
}

subprojects {
    apply(plugin = "version-catalog")
    apply(plugin = "maven-publish")

    publishing {
        publications {
            create<MavenPublication>("maven") {
                from(components["versionCatalog"])
            }
        }

        repositories {
            val username = System.getenv("MAVEN_USERNAME")
            val password = System.getenv("MAVEN_PASSWORD")

            if (username != null && password != null) {
                maven(url = "https://maven.resourcefulbees.com/repository/terrarium/") {
                    credentials {
                        setUsername(username)
                        setPassword(password)
                    }
                }
            }
        }
    }
}
